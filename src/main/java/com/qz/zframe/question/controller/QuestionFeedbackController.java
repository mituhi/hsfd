package com.qz.zframe.question.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.file.FileException;
import com.qz.zframe.question.entity.QuestionFeedback;
import com.qz.zframe.question.entity.QuestionFeedbackExample;
import com.qz.zframe.question.entity.QuestionFeedbackExample.Criteria;
import com.qz.zframe.question.service.QuestionFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/question/")
@Api(tags = {"api-support-question"}, description = "问题-问题反馈")
public class QuestionFeedbackController {
	
	private static Logger logger = LoggerFactory.getLogger(QuestionFeedbackController.class);
	@Autowired
	private  QuestionFeedbackService  questionFeedbackService;
	@Autowired
	private CommonService commonService;
	  
	    //查询问题
	@RequestMapping(value = "/findQuestion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 查询问题信息", notes = " 查询问题信息")
 public	PageResultEntity   selectQuestion(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="createTime",value="创建时间",required=false)String createTime,
            @RequestParam(required = false)
            @ApiParam(name="createTime2",value="创建时间",required=false)String createTime2,
            @RequestParam(required = false) 
            @ApiParam(name="contentQuestion",value="问题内容",required=false)String contentQuestion
			) throws ParseException {
		logger.info("===== 问题-问题反馈QuestionFeedbackController.findQuestion =====contentQuestion:"+contentQuestion,"createTime:"+createTime,"createTime2:"+createTime2);
				
		
		PageResultEntity resultEntity = new PageResultEntity();
		QuestionFeedbackExample questionFeedback=new QuestionFeedbackExample();
		questionFeedback.setPageNo(pageNum);
		questionFeedback.setPageSize(pageSize);
		questionFeedback.setOrderByClause("q.create_time  desc");
		Criteria criteria=questionFeedback.createCriteria();
		if(StringUtils.isNotBlank(createTime) && StringUtils.isBlank(createTime2)) {
			Date date= DateUtil.getStringToDate(createTime);
			criteria.andCreateTimeEqualTo(date);
		}
		if(StringUtils.isNotBlank(createTime) && StringUtils.isNotBlank(createTime2)) {
			Date date= DateUtil.getStringToDate(createTime);
			Date date2= DateUtil.getStringToDate(createTime2);
			criteria.andCreateTimeBetween(date, date2);
		}
		if(StringUtils.isNotBlank(contentQuestion)) {
			criteria.andContentQuestionLike(contentQuestion);
		}
		resultEntity=questionFeedbackService.selectQuestion(questionFeedback);
		return resultEntity;
	    }
		//添加问题
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增问题信息", notes = "新增问题信息信息")
	 public	ResultEntity    addQuestion(@RequestBody QuestionFeedback   questionFeedback) {
		
		logger.info("===== 问题-问题反馈QuestionFeedbackController.addQuestion====QuestionFeedback:"+questionFeedback);
		
		ResultEntity  resultEntity=new ResultEntity();
		if(questionFeedback==null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("添加数据为空");
			return resultEntity;
		}else {
			resultEntity=questionFeedbackService.addQuestion(questionFeedback);
		}
		return resultEntity;
		}
		//关闭问题
	@RequestMapping(value = "/closeDown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "关闭", notes = "关闭")
	 public	void   closeDown(QuestionFeedback   questionFeedback) throws Exception {
		
		logger.info("===== 问题-问题反馈QuestionFeedbackController.closeDown====QuestionFeedback:"+questionFeedback);
		
		 if( questionFeedback!=null) {
			 questionFeedbackService.closeDown(questionFeedback); 
		 }
		 
		}
		//查看问题详情
	@RequestMapping(value = "/selectById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 查询问题信息详情", notes = "查询问题信息详情")
	 public	PageResultEntity   selectById(String questionId) throws FileException {
		
		logger.info("===== 问题-问题反馈QuestionFeedbackController.selectById====questionId:"+questionId);
		
		PageResultEntity resultEntity = new PageResultEntity();
		if(StringUtils.isNotBlank(questionId)) {
			try {
				resultEntity=questionFeedbackService.selectById(questionId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据");
			return resultEntity;
		}
			return resultEntity;
		}
		//导出数据
	@RequestMapping(value = "/ExportExcl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出问题信息", notes = "导出问题信息")
	public String  ExportExcl(
			HttpServletResponse response,
			@RequestParam(required = false ,defaultValue = "问题信息")String sheetName,
			@RequestParam(required = false)
            @ApiParam(name="createTime",value="创建时间",required=false)String createTime,
            @RequestParam(required = false)
            @ApiParam(name="createTime2",value="创建时间",required=false)String createTime2,
            @RequestParam(required = false) 
            @ApiParam(name="contentQuestion",value="问题内容",required=false)String contentQuestion) throws Exception {
		//ResultEntity  resultEntity=new ResultEntity();
		
		logger.info("===== 问题-问题反馈QuestionFeedbackController.ExportExcl====contentQuestion:"+contentQuestion,"createTime:"+createTime,"createTime2:"+createTime2);
		
		QuestionFeedbackExample questionFeedbackExample = new QuestionFeedbackExample ();
		Criteria criteria =questionFeedbackExample.createCriteria();
		if(StringUtils.isNotBlank(createTime)) {
			Date date= DateUtil.getStringToDate(createTime);
			criteria.andCreateTimeEqualTo(date);
		}
		if(StringUtils.isNotBlank(createTime) && StringUtils.isNotBlank(createTime2)) {
			Date date= DateUtil.getStringToDate(createTime);
			Date date2= DateUtil.getStringToDate(createTime2);
			criteria.andCreateTimeBetween(date, date2);
		}
		if(StringUtils.isNotBlank(contentQuestion)) {
			criteria.andContentQuestionLike(contentQuestion);
		}
		
		return questionFeedbackService.ExportExcl(questionFeedbackExample,response,sheetName);
		  
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public SpFileUpload upload(MultipartFile file, HttpServletRequest request)
			throws Exception {
		
		logger.info("===== 问题-问题反馈QuestionFeedbackController.upload=====file"+file);
		
		SpFileUpload	map = commonService.fileUpload(file, "01");
		//SpFileUpload map = commonService.fileUpload(file, "01");
		return map;
	}

	
	@ApiOperation(value = "删除ftp文件", notes = "删除ftp文件")
	@RequestMapping(value = "removeFile", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity removeFile(@RequestParam(required = true)
			@ApiParam(name="fileId",value="文件id",required=true)List<String> fileId) throws Exception {
		logger.info("===== 删除ftp文件 QuestionFeedbackController.deleteCodeType ===== fileId:"+fileId);
		ResultEntity  resultEntity=new ResultEntity();
		if(fileId!=null && !fileId.isEmpty()) {
			resultEntity=	questionFeedbackService.removeFile(fileId);
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除图片文件id为空");
			return resultEntity;
		}
		return resultEntity;
	}
	
	
	@ApiOperation(value = "获取上传图片的路径", notes = "获取上传图片的路径")
	@RequestMapping(value = "/getRoute", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] downloadForBytes(String fileId) throws FileException{
		logger.info("===== 获取上传图片的路径 QuestionFeedbackController.getRoute ===== fileId:"+fileId);
		byte[]	lu=null;
		if(fileId!=null) {
			lu=questionFeedbackService.downloadForBytes(fileId);
		}
		return lu;
	}
	
}
