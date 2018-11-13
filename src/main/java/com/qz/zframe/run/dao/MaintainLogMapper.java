package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.MaintainLog;
import com.qz.zframe.run.entity.MaintainLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaintainLogMapper {
    int countByExample(MaintainLogExample example);

    int deleteByExample(MaintainLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(MaintainLog record);

    int insertSelective(MaintainLog record);

    List<MaintainLog> selectByExample(MaintainLogExample example);

    MaintainLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MaintainLog record, @Param("example") MaintainLogExample example);

    int updateByExample(@Param("record") MaintainLog record, @Param("example") MaintainLogExample example);

    int updateByPrimaryKeySelective(MaintainLog record);

    int updateByPrimaryKey(MaintainLog record);
}