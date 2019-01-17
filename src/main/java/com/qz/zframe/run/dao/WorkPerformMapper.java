package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.WorkPerform;
import com.qz.zframe.run.entity.WorkPerformExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface WorkPerformMapper {
    int countByExample(WorkPerformExample example);

    int deleteByExample(WorkPerformExample example);

    int deleteByPrimaryKey(String performId);

    int insert(WorkPerform record);

    int insertSelective(WorkPerform record);

    List<WorkPerform> selectByExample(WorkPerformExample example);

    WorkPerform selectByPrimaryKey(String performId);

    int updateByExampleSelective(@Param("record") WorkPerform record, @Param("example") WorkPerformExample example);

    int updateByExample(@Param("record") WorkPerform record, @Param("example") WorkPerformExample example);

    int updateByPrimaryKeySelective(WorkPerform record);

    int updateByPrimaryKey(WorkPerform record);
}