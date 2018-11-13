package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogTypeMapper {
    int countByExample(LogTypeExample example);

    int deleteByExample(LogTypeExample example);

    int deleteByPrimaryKey(String logTypeId);

    int insert(LogType record);

    int insertSelective(LogType record);

    List<LogType> selectByExample(LogTypeExample example);

    LogType selectByPrimaryKey(String logTypeId);

    int updateByExampleSelective(@Param("record") LogType record, @Param("example") LogTypeExample example);

    int updateByExample(@Param("record") LogType record, @Param("example") LogTypeExample example);

    int updateByPrimaryKeySelective(LogType record);

    int updateByPrimaryKey(LogType record);
}