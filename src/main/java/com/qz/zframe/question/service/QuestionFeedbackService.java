package com.qz.zframe.question.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.file.FileException;
import com.qz.zframe.question.entity.QuestionFeedback;
import com.qz.zframe.question.entity.QuestionFeedbackExample;

public interface QuestionFeedbackService {
	//查询问题
	PageResultEntity    selectQuestion(QuestionFeedbackExample questionFeedback);
	//添加问题
	ResultEntity    addQuestion(QuestionFeedback   questionFeedback);
	//关闭问题
	void   closeDown(QuestionFeedback   questionFeedback) throws Exception;
	//查看问题详情
	PageResultEntity   selectById(String questionId) throws FileException;
	//导出数据
	public  String  ExportExcl(QuestionFeedbackExample questionFeedbackExample,HttpServletResponse response,String sheetName) throws Exception;

	//删除上传的文件
	public  ResultEntity removeFile(List<String> fileId) throws Exception;
	
	/**
	 * 返回图片路径
	 * @param fileId
	 * @return
	 */
	public byte[] downloadForBytes(String fileId) throws FileException;
}
