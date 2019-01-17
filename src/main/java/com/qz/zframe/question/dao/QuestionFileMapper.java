package com.qz.zframe.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.question.entity.QuestionFile;
@Mapper
public interface QuestionFileMapper {
	
	void  insert(QuestionFile  questionFile);
	
	void  delete(List<String> FileId);

	List<QuestionFile>  select (String questionId);
	QuestionFile selectFileId(String fileId);
}
