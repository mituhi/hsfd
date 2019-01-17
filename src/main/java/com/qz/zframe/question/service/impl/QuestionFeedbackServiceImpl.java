package com.qz.zframe.question.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.CommonDao;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.file.FileException;
import com.qz.zframe.question.dao.QuestionFeedbackMapper;
import com.qz.zframe.question.dao.QuestionFileMapper;
import com.qz.zframe.question.entity.QuestionFeedback;
import com.qz.zframe.question.entity.QuestionFeedbackExample;
import com.qz.zframe.question.entity.QuestionFile;
import com.qz.zframe.question.service.QuestionFeedbackService;

import sun.misc.BASE64Encoder;
@Service
public class QuestionFeedbackServiceImpl implements QuestionFeedbackService {
	@Autowired
	private  QuestionFeedbackMapper  questionFeedbackMapper;
	@Autowired
	private  QuestionFileMapper  questionFileMapper;
	@Autowired
    private CurrentUserService currentUserService;
	@Autowired
	private CommonService  	commonService;
	@Autowired
	private CommonDao commonDao;
	@Override
	public PageResultEntity selectQuestion(QuestionFeedbackExample questionFeedback) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = questionFeedbackMapper.countByExample(questionFeedback);
		resultEntity.setTotal(count);
		List<QuestionFeedback> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list =questionFeedbackMapper.selectByExample(questionFeedback);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		resultEntity.setMsg("问题反馈信息查询成功!");
		return resultEntity;
	}

	@Override
	public ResultEntity addQuestion(QuestionFeedback questionFeedback) {
		ResultEntity resultEntity = new ResultEntity();
		if(questionFeedback!=null) {
		  if(StringUtils.isBlank(questionFeedback.getTitle())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请输入问题标题");
			return resultEntity;
		  }
		String questionId=UUIdUtil.getUUID();
		questionFeedback.setQuestionId(questionId);
		questionFeedback.setUserId(currentUserService.getId());
		questionFeedback.setUserName(currentUserService.getUsername());
		questionFeedback.setCreateTime(new Date());
		
		List<String> files=questionFeedback.getFile();
		if(files!=null && files.size()>0) {
			QuestionFile  qf=new QuestionFile();
			for(String f:files) {
				qf=new QuestionFile();
				qf.setQuestionFileId(UUIdUtil.getUUID());
				qf.setQuestionId(questionId);
				qf.setFileId(f);
				questionFileMapper.insert(qf);
			}
			
		}
		int save=questionFeedbackMapper.insert(questionFeedback);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
	}else {
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("没有添加数据");
		return resultEntity;
	}
		return resultEntity;
	}

	@Override
	public PageResultEntity selectById(String questionId) throws FileException {
		PageResultEntity resultEntity = new PageResultEntity();
		List<QuestionFeedback> list = new ArrayList<QuestionFeedback>();
		QuestionFeedback question = questionFeedbackMapper.selectByPrimaryKey(questionId);
		if (question == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
			return resultEntity;
		} else {
			List<QuestionFile> questionFile=questionFileMapper.select(questionId);
			if(questionFile!=null) {
				List<String> files=new ArrayList<String>();
				for(QuestionFile   q:questionFile) {
					files.add(q.getFileId());
				}
				question.setFile(files);
			}
			List<String> route=new ArrayList<String>();
			List<String> file=question.getFile();
			if(file!=null) {
				for(int i=0;i<file.size();i++) {
				byte[] res = commonService.download(questionFile.get(i).getFileId());
				BASE64Encoder encoder = new BASE64Encoder();
				String aaa = encoder.encode(res);
				String fi="data:image/png;base64,"+aaa;
				route.add(fi);
			}	
				question.setRoute(route);	
			}
			
			/*List<String>  route=new ArrayList<String>();
			for(String f:file) {
				SpFileUpload spFileUpload = getFileUpload(f);
		        if (spFileUpload == null) {
		            throw new FileException("根据文件ID【" + f + "】获取文件信息为空！");
		        }
		        // 获取FTP服务
		        FtpService ftpService = FtpServiceHolder.getFtpService();
		            ftpService.connect();
		            // 绝对路径（完整路径，路径+文件名）
		         String absolutePath = spFileUpload.getRelativePath() + "/" + spFileUpload.getStorageName();	
		         ftpService.disconnect();
		         route.add(absolutePath);
			    }	
			question.setRoute(route);*/
			list.add(question);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public String ExportExcl(QuestionFeedbackExample questionFeedbackExample, HttpServletResponse response,
			String sheetName) throws Exception {
		//ResultEntity resultEntity = new ResultEntity();
		List<QuestionFeedback> list=questionFeedbackMapper.select(questionFeedbackExample);
	     for(int i=0;i<list.size();i++) {
	    	 list.get(i).setAaa(String.valueOf(i+1)); 
	     }
		
		LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
	
		
		fieldMap.put("aaa", "问题标识");
		fieldMap.put("title", "标题");
		fieldMap.put("contentQuestion", "问题内容");
		fieldMap.put("userName", "创建人");
		fieldMap.put("createTimes","创建时间");
		String fileName= ExcelUtil.Excel(list, fieldMap, sheetName, response);
	/*	if(StringUtils.isBlank(fileName)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("导出失败");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("导出成功");
		resultEntity.setData(fileName);*/
		return  fileName;
	}

	@Override
	public void closeDown(QuestionFeedback questionFeedback) throws Exception {
		if(questionFeedback!=null) {
			List<String> files=questionFeedback.getFile();
			if(files!=null) {
				for(String f:files) {
					commonService.removeFile(f);
				}
				questionFileMapper.delete(files);
			}
		}
	}
	 /* private SpFileUpload getFileUpload(String fileId) {
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
*/
	@Override
	public ResultEntity removeFile(List<String> fileId) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		QuestionFile questionFile = new QuestionFile();
		List<String> file = new ArrayList<String>();
		if (fileId != null) {
			for (String f : fileId) {
				commonService.removeFile(f);
				questionFile = new QuestionFile();
				questionFile = questionFileMapper.selectFileId(f);
				if (questionFile != null) {
					file.add(questionFile.getFileId());
				}
			}
			if (file != null && !file.isEmpty()) {
				questionFileMapper.delete(file);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		}
		return resultEntity;
	}
	public ResultEntity getPics(List<String> fileIds) {
	    ResultEntity resultEntity = new ResultEntity();

	    String pic = "data:image/png;base64,";
	    List<String> picList = new ArrayList<>();
	    BASE64Encoder base64Encoder = new BASE64Encoder();
	    try {
	        if (fileIds!=null && fileIds.size()!=0) {
	            for (String fileId:fileIds) {
	                byte[] download = commonService.download(fileId);
	                String encode = base64Encoder.encode(download);
	                pic += encode;
	                picList.add(pic);
	            }
	        }
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
	    resultEntity.setData(picList);
	    return resultEntity;
}

	@Override
	public byte[] downloadForBytes(String fileId) throws FileException {
		//QuestionFeedback  question=new QuestionFeedback();
		//List<byte[]> lu=new ArrayList<byte[]>();
		 byte[] routes=null;
		if(fileId!=null) {
			/*for(String f:fileId) {*/
			  routes=commonService.download(fileId);	
			 /* lu.add(routes);*/
			/*}*/
		}
		return routes;
		
	}
	
	
}