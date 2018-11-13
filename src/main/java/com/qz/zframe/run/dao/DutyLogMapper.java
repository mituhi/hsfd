package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyLogMapper {
    int countByExample(DutyLogExample example);

    int deleteByExample(DutyLogExample example);

    int deleteByPrimaryKey(String dutyLogId);

    int insert(DutyLog record);

    int insertSelective(DutyLog record);

    List<DutyLog> selectByExample(DutyLogExample example);

    DutyLog selectByPrimaryKey(String dutyLogId);

    int updateByExampleSelective(@Param("record") DutyLog record, @Param("example") DutyLogExample example);

    int updateByExample(@Param("record") DutyLog record, @Param("example") DutyLogExample example);

    int updateByPrimaryKeySelective(DutyLog record);

    int updateByPrimaryKey(DutyLog record);
}