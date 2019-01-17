package com.qz.zframe.common.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.CommonDao;
import com.qz.zframe.common.entity.Common;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.InputStreamUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.file.FileException;
import com.qz.zframe.file.domain.UploadObject;
import com.qz.zframe.file.helper.FileOperateServiceHelper;
import com.qz.zframe.file.impl.ftp.service.FtpService;
import com.qz.zframe.file.impl.ftp.service.FtpServiceHolder;
import com.qz.zframe.tally.entity.DownloadRecord;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Value("${ftp.rootPath}")
	private String rootPath;
	
	@Autowired
	private CommonDao commonDao;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private DataDictService dataDictService;

	@Autowired
	private RoleService roleService;
	
	@Override
	public SpFileUpload fileUpload(MultipartFile file, String businessType) throws Exception {
		UploadObject uploadObject = new UploadObject();
		uploadObject.setFileBytes(file.getBytes());
		uploadObject.setBusinessType(businessType);
		uploadObject.setFileName(file.getOriginalFilename());
		uploadObject.setUser(currentUserService.getId());
		SpFileUpload spFileUpload = upload(uploadObject);
		return spFileUpload;
	}
	
	private SpFileUpload upload(UploadObject uploadObject) throws FileException {
        // 上传之前校验参数
        FileOperateServiceHelper.checkParamsBeforeUpload(uploadObject);

        FtpService ftpService = null;
        try {
            // 获取FTP服务
            ftpService = FtpServiceHolder.getFtpService();
            ftpService.connect();

            SpFileUpload spFileUpload = new SpFileUpload();

            if (ftpService != null) {
                // 获取上传存储名称
                String storageName = FileOperateServiceHelper.getUploadStorageName(uploadObject.getFileName());
                // 获取上传相对路径
                String relativePath = FileOperateServiceHelper.getUploadRelativePath(
                        uploadObject.getBusinessType(), uploadObject.getRelativePath());

                // 业务ID
                String businessId = uploadObject.getBusinessId();
                // 业务ID不为空，则先根据业务ID查询出存在的文件上传信息删除，FTP服务器上的文件删除
                if (StringUtils.isNotBlank(businessId)) {
                    // 根据业务ID获取文件上传信息
                	SpFileUpload spFileUpload1 = getFileUploadByBusinessId(businessId);
                    if (spFileUpload1 != null) {
                        // 删除数据库中的数据
                        removeFileUploadByBusinessId(businessId);
                        // 删除FTP上的文件
                        ftpService.removeFile(
                        		spFileUpload1.getRelativePath() + "/" + spFileUpload1.getStorageName());
                    }
                }

                // 上传
                ftpService.upload(relativePath, storageName, InputStreamUtil.bytesToInputStream(uploadObject.getFileBytes()));

                spFileUpload.setBusinessId(businessId);
                spFileUpload.setBusinessType(uploadObject.getBusinessType());
                spFileUpload.setCreateUser(uploadObject.getUser());
                spFileUpload.setFileSize((long) uploadObject.getFileBytes().length);
                spFileUpload.setOriginalName(uploadObject.getFileName());
                spFileUpload.setStorageName(storageName);
                spFileUpload.setRelativePath(relativePath);
                // 数据入库
                String fileId = saveFileUpload(spFileUpload);
                spFileUpload.setFileId(fileId);
            }
            return spFileUpload;
        } catch (Exception e) {
            logger.error(StringUtils.EMPTY, e);
            return null;
        } finally {
            // 使用完FTP断开连接
            ftpService.disconnect();
        }
    }
	
	/**
     * 根据业务id
     *
     * @param businessId
     */
    private void removeFileUploadByBusinessId(String businessId) {
        if (StringUtils.isNotBlank(businessId)) {
        	SpFileUpload spFileUpload = new SpFileUpload();
        	spFileUpload.setBusinessId(businessId);
            commonDao.deleteFileUpload(spFileUpload);
        }
    }

    /**
     * 根据业务id获取文件上传信息
     *
     * @param businessId 业务id
     * @return FileUploadModel
     */
    private SpFileUpload getFileUploadByBusinessId(String businessId) {
        if (StringUtils.isNotBlank(businessId)) {
        	SpFileUpload spFileUpload = new SpFileUpload();
        	spFileUpload.setBusinessId(businessId);
            List<SpFileUpload> spFileUploads = commonDao.findfileUploadList(spFileUpload);
            if (CollectionUtils.isNotEmpty(spFileUploads)) {
                return spFileUploads.get(0);
            }
        }
        return null;
    }

    /**
     * 保存文件上传信息
     *
     * @param spFileUpload
     * @return 文件ID
     */
    private String saveFileUpload(SpFileUpload spFileUpload) {
        String fileId = StringUtils.EMPTY;
        String businessId = spFileUpload.getBusinessId();
        if (StringUtils.isBlank(businessId)) {
            fileId = UUID.randomUUID().toString().replaceAll("-", "");
        } else {
            // 业务ID不为空，文件ID使用业务ID
            fileId = businessId;
        }
        spFileUpload.setFileId(fileId);
        spFileUpload.setCreateTime(new Date());
        // 保存
        commonDao.addFileUpload(spFileUpload);
        return fileId;
    }

    /**
     * 下载
     *
     * @param fileId 文件ID
     * @return byte[]
     */
    @Override
    public byte[] download(String fileId) throws FileException {
        // 根据文件ID获取文件上传信息
    	SpFileUpload spFileUpload = getFileUpload(fileId);
        if (spFileUpload == null) {
            throw new FileException("根据文件ID【" + fileId + "】获取文件信息为空！");
        }
        // 获取FTP服务
        FtpService ftpService = FtpServiceHolder.getFtpService();

        try {
            ftpService.connect();
            // 绝对路径（完整路径，路径+文件名）
            String absolutePath = spFileUpload.getRelativePath() + "/" + spFileUpload.getStorageName();
            // 下载
            return ftpService.download(absolutePath);
        } catch (Exception e) {
            logger.error(StringUtils.EMPTY, e);
        } finally {
            // 使用FTP完断开连接
            ftpService.disconnect();
        }
        return new byte[0];
    }

    /**
     * 根据文件id获取文件上传信息
     *
     * @param fileId 文件id
     * @return FileUploadModel
     */
    private SpFileUpload getFileUpload(String fileId) {
        if (StringUtils.isNotBlank(fileId)) {
        	SpFileUpload spFileUpload = new SpFileUpload();
        	spFileUpload.setFileId(fileId);
            List<SpFileUpload> spFileUploads = commonDao.findfileUploadList(spFileUpload);
            if (CollectionUtils.isNotEmpty(spFileUploads)) {
                return spFileUploads.get(0);
            }
        }
        return null;
    }

    /**
     * 下载
     *
     * @param response 响应
     * @param fileId   文件ID
     */
    @Override
    public void download(HttpServletResponse response, String fileId) throws Exception {
        // 根据文件ID获取文件上传信息
    	SpFileUpload spFileUpload = getFileUpload(fileId);
    	response.setContentType("multipart/form-data");
		response.setContentType("text/plain");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		String fileName = java.net.URLEncoder.encode(spFileUpload.getOriginalName(), "UTF-8");
//		response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        if (spFileUpload == null) {
            throw new Exception("根据文件ID【" + fileId + "】获取文件信息为空！");
        }
        // 获取FTP服务
        FtpService ftpService = FtpServiceHolder.getFtpService();

        try {
            ftpService.connect();
            // 绝对路径（完整路径，路径+文件名）
            String absolutePath = spFileUpload.getRelativePath() + "/" + spFileUpload.getStorageName();
            // 下载
            ftpService.download(response, absolutePath, spFileUpload.getOriginalName());
        } catch (Exception e) {
            logger.error(StringUtils.EMPTY, e);
        } finally {
            // 使用FTP完断开连接
            ftpService.disconnect();
        }
    }

    /**
     * 自定义单号
     * @param code 标准代码编号
     * @param maxCode 最大单号
     * @return
     * @throws Exception 
     */
	@Override
	public String customOrder(String code, String maxCode) throws Exception {
		if (StringUtils.isBlank(code)) {
			throw new Exception("标准代码编号不能为空");
		}
		DataDict dataDict = dataDictService.findDataDictByCodeAndType("ORDER_CODING", code);
		if (dataDict != null) {
			String billCode = "";
			//标准代码配置单号头
			String billHead = dataDict.getContent01();
			String newYear = getCurrentYear();
			String monthDay=getCurrentMonth();
			if (StringUtils.isBlank(maxCode)) {
				billCode = billHead + newYear +monthDay+ "0001";
				return billCode;
			}else {
				String oldYear = maxCode.substring(billHead.length(), billHead.length()+4);
				if (oldYear.equals(newYear)) {
					String oldCode = maxCode.substring(maxCode.length()-4, maxCode.length());
					String newCode = makeCode(oldCode);
					billCode = billHead + newYear +monthDay+ newCode;
				}else {
					billCode = billHead + newYear +monthDay+ "0001";
				}
				return billCode;
			}
		}
		return null;
	}
	
	private String makeCode(String oldCode) {
		String newCode = String.valueOf(Integer.parseInt(oldCode)+1);
		switch (newCode.length()) {
			case 1:
				newCode="000"+newCode;
				break;
			case 2:
				newCode="00"+newCode;
				break;
			case 3:
				newCode="0"+newCode;
				break;
			default:
				break;
		} 
		return newCode;
	}

	private static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
	}
	
	private static String getCurrentMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        Date date = new Date();
        return sdf.format(date);
	}

    /**
     * 获取用户id、名称及当前时间
     * @return
     * @throws ParseException
     */
	@Override
	public Common findCommonMsg() throws ParseException {
		String userId = currentUserService.getId();
		String userName = currentUserService.getUsername();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date timeForSeconds = format1.parse(format1.format(new Date()));
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date timeForDay = format2.parse(format2.format(new Date()));
		Common common = commonDao.findDeptMsgByUserId(userId);
        Common team = commonDao.findTeamMsgByUserId(userId);
		if (common == null) {
		    common = new Common();
        }
        if (team != null){
            common.setTeamId(team.getTeamId());
            common.setTeamCode(team.getTeamCode());
            common.setTeamName(team.getTeamName());
            common.setTeamType(team.getTeamType());
        }
		common.setUserId(userId);
		common.setUserName(userName);
		common.setImeForSeconds(timeForSeconds);
		common.setTimeForDay(timeForDay);
		//获取用户角色
        List<Role> roles = roleService.findUserRoleList(userId);
        common.setRoles(roles);
		return common;
	}

    @Override
    public PageResultEntity removeFile(String fileId) throws Exception {
        PageResultEntity pageResultEntity = new PageResultEntity();
	    if (StringUtils.isBlank(fileId)){
	        pageResultEntity.setCode(ErrorCode.ERROR);
	        pageResultEntity.setMsg("文件id为空!");
	        return pageResultEntity;
        }
        SpFileUpload spFileUpload = commonDao.findByFileId(fileId);
        if (spFileUpload != null) {
            FtpService ftpService = null;
            try {
                // 获取FTP服务
                ftpService = FtpServiceHolder.getFtpService();
                ftpService.connect();
                if (ftpService != null) {
                    // 删除数据库中的数据
                    removeFileUploadByFileId(fileId);
                    // 删除FTP上的文件
                    ftpService.removeFile(
                            spFileUpload.getRelativePath() + "/" + spFileUpload.getStorageName());
                    pageResultEntity.setCode(ErrorCode.SUCCESS);
                    pageResultEntity.setMsg("文件删除成功!");
                }else {
                    pageResultEntity.setCode(ErrorCode.ERROR);
                    pageResultEntity.setMsg("ftp服务器获取失败!");
                }
            } catch (Exception e) {
                logger.error(StringUtils.EMPTY, e);
                pageResultEntity.setCode(ErrorCode.ERROR);
                pageResultEntity.setMsg("文件删除异常");
                return pageResultEntity;
            } finally {
                // 使用完FTP断开连接
                ftpService.disconnect();
            }
            return pageResultEntity;
        }else{
            pageResultEntity.setCode(ErrorCode.ERROR);
            pageResultEntity.setMsg("文件不存在!");
            return pageResultEntity;
        }
    }

    /**
     * 根据业务id
     *
     * @param fileId
     */
    private void removeFileUploadByFileId(String fileId) {
        if (StringUtils.isNotBlank(fileId)) {
            SpFileUpload spFileUpload = new SpFileUpload();
            spFileUpload.setFileId(fileId);
            commonDao.deleteFileUpload(spFileUpload);
        }
    }

    @Override
    public Common findUserBaseMsg(String userId) throws Exception {
        if (StringUtils.isBlank(userId)){
            throw new Exception("用户id不能为空!");
        }
        Common common = commonDao.findUserBaseMsg(userId);
        if (common == null) {
            common = new Common();
        }
        Common team = commonDao.findTeamMsgByUserId(userId);
        if (team != null){
            common.setTeamId(team.getTeamId());
            common.setTeamCode(team.getTeamCode());
            common.setTeamName(team.getTeamName());
            common.setTeamType(team.getTeamType());
        }
        return common;
    }

    @Override
    public byte[] downloadForBytes(String fileId) throws FileException {
        return download(fileId);
    }

    private static final int QRCOLOR = 0xFF000000; // 默认是黑色
    private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色

    private static final int WIDTH = 400; // 二维码宽
    private static final int HEIGHT = 400; // 二维码高

    // 用于设置QR二维码参数
    private Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;

        {
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码方式
            put(EncodeHintType.MARGIN, 0);
        }
    };

    @Value("${logoSite}")
    private String logoSite;
    @Value("${noteSite}")
    private String noteSite;

    /**
     * 导出二维码
     * @param msgs 传入信息，包括
     *  	qrUrl 二维码内容
     *  	equipmentName 设备名称
     *  	qrCodeId 二维码编号
     *
     */
    @Override
    public int exportQrCode(List<Map<String, String>> msgs) {
        if (CollectionUtils.isNotEmpty(msgs)) {
            File logoFile = new File(logoSite);//logo图片路径
            for (Map<String, String> map : msgs) {
                String qrUrl = map.get("qrUrl");
                String locationName = map.get("locationName");
                String qrCodeId = map.get("qrCodeId");
                String site = map.get("noteSite");
                if (StringUtils.isNotBlank(site)) {
                    noteSite = site;
                }
                File codeFile = new File(noteSite+qrCodeId+".png");//生成后图片的输出地址
                try {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
                    BitMatrix bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
                    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

                    // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
                    for (int x = 0; x < WIDTH; x++) {
                        for (int y = 0; y < HEIGHT; y++) {
                            image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                        }
                    }
                    int width = image.getWidth();
                    int height = image.getHeight();
                    if (Objects.nonNull(logoFile) && logoFile.exists()) {
                        // 构建绘图对象
                        Graphics2D g = image.createGraphics();
                        // 读取Logo图片
                        BufferedImage logo = ImageIO.read(logoFile);
                        // 开始绘制logo图片
                        g.drawImage(logo, width * 2 / 5, height * 2 / 5, width * 2 / 10, height * 2 / 10, null);
                        g.dispose();
                        logo.flush();
                    }

                    // 自定义文本描述
                    if (StringUtils.isNotBlank(qrCodeId)) {
                        // 新的图片，把带logo的二维码下面加上文字
                        BufferedImage outImage = new BufferedImage(400, 445, BufferedImage.TYPE_4BYTE_ABGR);
                        Graphics2D outg = outImage.createGraphics();
                        // 画二维码到新的面板
                        outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
                        // 画文字到新的面板
                        outg.setColor(Color.BLACK);
                        outg.setFont(new Font("楷体", Font.BOLD, 30)); // 字体、字型、字号

                        // //长度过长就截取前面部分
                        // 长度过长就换行
                        String note1 = locationName;
                        String note2 = qrCodeId;
                        int strWidth1 = outg.getFontMetrics().stringWidth(note1);
                        int strWidth2 = outg.getFontMetrics().stringWidth(note2);
                        outg.drawString(note1, 200 - strWidth1 / 2, height + (outImage.getHeight() - height) / 2 + 12);
                        BufferedImage outImage2 = new BufferedImage(400, 485, BufferedImage.TYPE_4BYTE_ABGR);
                        Graphics2D outg2 = outImage2.createGraphics();
                        outg2.drawImage(outImage, 0, 0, outImage.getWidth(), outImage.getHeight(), null);
                        outg2.setColor(Color.BLACK);
                        outg2.setFont(new Font("宋体", Font.BOLD, 30)); // 字体、字型、字号
                        outg2.drawString(note2, 200 - strWidth2 / 2, outImage.getHeight() + (outImage2.getHeight() - outImage.getHeight()) / 2 + 5);
                        outg2.dispose();
                        outImage2.flush();
                        outImage = outImage2;

                        outg.dispose();
                        outImage.flush();
                        image = outImage;
                    }

                    image.flush();
                    ImageIO.write(image, "png", codeFile); // TODO
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return 1;
        }

        return 0;
    }

}
