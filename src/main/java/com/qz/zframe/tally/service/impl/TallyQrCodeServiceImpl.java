package com.qz.zframe.tally.service.impl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.*;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.tally.dao.TallyQrCodeDao;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.entity.QrCodeExample;
import com.qz.zframe.tally.service.TallyQrCodeService;

import com.qz.zframe.tally.vo.TallyQrCodeExcel;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Service("tallyQrCodeService")
@Transactional(rollbackFor = Exception.class)
public class TallyQrCodeServiceImpl implements TallyQrCodeService{
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CurrentUserService currentUserService;
   
	@Autowired
    TallyQrCodeDao tallyQrCodeDao;


    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getlistQrCode(QrCodeExample example) {
		NewPageResult newPageResult = new NewPageResult();
		int count = tallyQrCodeDao.countByExample(example);
		newPageResult.setTotal(count);
		List<QrCode> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=tallyQrCodeDao.selectByExample(example);
		}
		newPageResult.setCode(ErrorCode.SUCCESS);
		newPageResult.setRows(list);
		return newPageResult;
	}

	@Override
	public ResultEntity insertByCodes(QrCode qrCode) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(qrCode.getPositionId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("位置Id不能为空");
			return resultEntity;
		}
		if(CheckPositionIdIsExit(qrCode)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("位置重复，请重新选择");
			return resultEntity;
		}
		
		qrCode.setCreater(currentUserService.getId());
		qrCode.setCreateTime(new Date());
		String maxQrCodeId=commonService.customOrder("09",  tallyQrCodeDao.getMaxQrcode());
		qrCode.setQrId(UUIdUtil.getUUID());
		qrCode.setQrCodeId(maxQrCodeId);
		tallyQrCodeDao.insertSelective(qrCode);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		return resultEntity;
	}

	private boolean CheckPositionIdIsExit(QrCode qrCode) {
		QrCodeExample example = new QrCodeExample();
		if(StringUtils.isBlank(qrCode.getQrId())){
			example.createCriteria().andPositionIdEqualTo(qrCode.getPositionId());
		}else{
			example.createCriteria().andPositionIdEqualTo(qrCode.getPositionId()).andQrCodeIdNotEqualTo(qrCode.getQrId());
		}
		int count = tallyQrCodeDao.countByExample(example);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ResultEntity updateQrCodeByCode(QrCode qrCode) {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(qrCode.getPositionId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("位置Id不能为空");
			return resultEntity;
		}
		if(CheckPositionIdIsExit(qrCode)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("位置重复，请重新选择");
			return resultEntity;
		}
		tallyQrCodeDao.updateByPrimaryKeySelective(qrCode);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("编辑成功");
		return resultEntity;
	}

	@Override
	public ResultEntity deleteQrCodeByQrId(List<String> qrIds) {
		ResultEntity resultEntity = new ResultEntity();
		tallyQrCodeDao.deleteQrCodeByQrId(qrIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

	@Override
	public ResultEntity ExportExcl(QrCodeExample example, HttpServletResponse response, String positionCode,String sheetName,String noteSite,ResultEntity resultEntity) throws Exception {
        List<QrCode> list=tallyQrCodeDao.selectByExample(example);
		LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
		//CrewInformation c=new CrewInformation();
		for (QrCode qrCode:list){
			qrCode.setUrl("http://47.96.169.132:8000/hsfd/api/support/tallyStandard/listStandardDetail?qrId="+qrCode.getQrId());
		}
		fieldMap.put("url","连接");
		fieldMap.put("positionCode","位置编码");
		fieldMap.put("positionName", "位置名称");
		fieldMap.put("qrCodeId", "二维码id");
		String file= ExcelUtil.Excel(list, fieldMap, sheetName, response);

		List<Map<String, String>> msgs=new ArrayList<Map<String, String>>();
		for (QrCode qrCode:list){
			Map<String,String> map=new HashMap<String,String>();
			map.put("qrUrl","http://47.96.169.132:8000/hsfd/api/support/tallyStandard/listStandardDetail?qrId="+qrCode.getQrId());
			map.put("locationName",qrCode.getPositionName());
			map.put("qrCodeId",qrCode.getQrCodeId());
			map.put("noteSite",noteSite);
			msgs.add(map);
		}
		int n=commonService.exportQrCode(msgs);
		//resultEntity.setData(file);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("导出二维码成功!");
		return  resultEntity;
	}



	@Override
	public ResultEntity importQrCode(String fileName, InputStream in, ResultEntity resultEntity) {

		Workbook wb=null;

		try {
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
			if ("xls".equals(extension)) {
				wb = new HSSFWorkbook(in);
			} else if ("xlsx".equals(extension)) {
				wb = new XSSFWorkbook(in);
			} else {
				try {
					if (in != null)
						in.close();
				} catch (IOException localIOException) {
				}
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("不支持的文件类型! 目前只支持xls或xlsx后缀名的Excel文件!");
				return resultEntity;
			}
			List<QrCode> qrCodes = new ArrayList<QrCode>();
			List<String> positionCodes=tallyQrCodeDao.findAllPositionCodes();
			List<String> notHave=new ArrayList<String>();
			List<QrCode> list=tallyQrCodeDao.findPositionIdAndPositionCode();
			Map<String,String> m=new HashMap();
			for (QrCode qrCode:list){
				m.put(qrCode.getPositionCode(),qrCode.getPositionId());
			}
			int i = 0;
			int r = 0;
			String value = null;
			Cell cell = null;
			String[] headers = {"KKS编码"};
			Sheet sheet1 = wb.getSheetAt(0);
			for (Row row : sheet1) {
				i = 0;
				if (r == 0) {
					resultEntity=ExcelUtils.checkHeader1(r, row, headers);
					//ExcelUtils.checkHeader(r, row, headers);
					if(resultEntity.getCode()==ErrorCode.ERROR){
						return resultEntity;
					}
				} else {
					if (ExcelUtils.isBlankRow(row, headers))
						continue;

					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							if (!positionCodes.contains(value)){
								notHave.add(value);
							}
						}
					}
				}
				r++;
			}
			//assessmentQuestionRep.save(books);
			if (notHave==null||notHave.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("全部重复!");
				return resultEntity;
			}
			for (String positionCode:notHave){
				QrCode qrCode = new QrCode();
				String maxQrCodeId=commonService.customOrder("09",  tallyQrCodeDao.getMaxQrcode());
				qrCode.setQrId(UUIdUtil.getUUID());
				qrCode.setQrCodeId(maxQrCodeId);
				qrCode.setCreateTime(new Date());
				qrCode.setCreater(currentUserService.getId());
				//qrCode.setPositionId(tallyQrCodeDao.findPositonIdByPositionCode(positionCode));
				String id=m.get(positionCode);
				if (StringUtils.isBlank(id)){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("无效的KKS编码!");
					return resultEntity;
				}
				qrCode.setPositionId(m.get(positionCode));
				tallyQrCodeDao.insertSelective(qrCode);
			}
        resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("导入成功!");

    	return resultEntity;
	} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultEntity;
	}

	@Override
	public ResultEntity ExportExclByIds(QrCodeExample example, HttpServletResponse response, String positionCode, String sheetName, String noteSite, ResultEntity resultEntity, HttpServletRequest request) throws Exception {
		List<QrCode> list=tallyQrCodeDao.selectByExample(example);
		LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
		//CrewInformation c=new CrewInformation();
		for (QrCode qrCode:list){
			qrCode.setUrl("http://47.96.169.132:8000/hsfd/api/support/tallyStandard/listStandardDetail?qrId="+qrCode.getQrId());
		}
		fieldMap.put("url","连接");
		fieldMap.put("positionCode","位置编码");
		fieldMap.put("positionName", "位置名称");
		fieldMap.put("qrCodeId", "二维码id");
		String file= ExcelUtil.Excel(list, fieldMap, sheetName, response);

		List<Map<String, String>> msgs=new ArrayList<Map<String, String>>();
		for (QrCode qrCode:list){
			Map<String,String> map=new HashMap<String,String>();
			map.put("qrUrl","http://47.96.169.132:8000/hsfd/api/support/tallyStandard/listStandardDetail?qrId="+qrCode.getQrId());
			map.put("locationName",qrCode.getPositionName());
			map.put("qrCodeId",qrCode.getQrCodeId());
			map.put("noteSite",noteSite);
			msgs.add(map);
		}
		int n=commonService.exportQrCode(msgs);
		//resultEntity.setData(file);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("导出二维码成功!");
		return  resultEntity;
	}
}
