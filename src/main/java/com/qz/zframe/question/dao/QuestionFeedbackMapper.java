package com.qz.zframe.question.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.question.entity.QuestionFeedback;
import com.qz.zframe.question.entity.QuestionFeedbackExample;
@Mapper
public interface QuestionFeedbackMapper extends BaseMapper<QuestionFeedback, QuestionFeedbackExample, Long>{
	
    int countByExample(QuestionFeedbackExample example);

    int deleteByExample(QuestionFeedbackExample example);

    int deleteByPrimaryKey(String questionId);

    int insert(QuestionFeedback record);

    int insertSelective(QuestionFeedback record);

    List<QuestionFeedback> selectByExample(QuestionFeedbackExample example);

    List<QuestionFeedback> select(QuestionFeedbackExample example);

    QuestionFeedback selectByPrimaryKey(String questionId);

    int updateByExampleSelective(@Param("record") QuestionFeedback record, @Param("example") QuestionFeedbackExample example);

    int updateByExample(@Param("record") QuestionFeedback record, @Param("example") QuestionFeedbackExample example);

    int updateByPrimaryKeySelective(QuestionFeedback record);

    int updateByPrimaryKey(QuestionFeedback record);
}