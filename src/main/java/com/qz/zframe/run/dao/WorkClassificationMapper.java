package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkClassificationMapper {
    int countByExample(WorkClassificationExample example);

    int deleteByExample(WorkClassificationExample example);

    int deleteByPrimaryKey(String classificationId);

    int insert(WorkClassification record);

    int insertSelective(WorkClassification record);

    List<WorkClassification> selectByExample(WorkClassificationExample example);

    WorkClassification selectByPrimaryKey(String classificationId);

    int updateByExampleSelective(@Param("record") WorkClassification record, @Param("example") WorkClassificationExample example);

    int updateByExample(@Param("record") WorkClassification record, @Param("example") WorkClassificationExample example);

    int updateByPrimaryKeySelective(WorkClassification record);

    int updateByPrimaryKey(WorkClassification record);
}