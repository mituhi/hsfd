package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.WorkTaskExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkTaskMapper {
    int countByExample(WorkTaskExample example);

    int deleteByExample(WorkTaskExample example);

    int deleteByPrimaryKey(String workTaskId);

    int insert(WorkTask record);

    int insertSelective(WorkTask record);

    List<WorkTask> selectByExample(WorkTaskExample example);

    WorkTask selectByPrimaryKey(String workTaskId);

    int updateByExampleSelective(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByExample(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByPrimaryKeySelective(WorkTask record);

    int updateByPrimaryKey(WorkTask record);
}