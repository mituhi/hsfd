package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.entity.DutyInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyInfoMapper {
    int countByExample(DutyInfoExample example);

    int deleteByExample(DutyInfoExample example);

    int deleteByPrimaryKey(String dutyInfoId);

    int insert(DutyInfo record);

    int insertSelective(DutyInfo record);

    List<DutyInfo> selectByExample(DutyInfoExample example);

    DutyInfo selectByPrimaryKey(String dutyInfoId);

    int updateByExampleSelective(@Param("record") DutyInfo record, @Param("example") DutyInfoExample example);

    int updateByExample(@Param("record") DutyInfo record, @Param("example") DutyInfoExample example);

    int updateByPrimaryKeySelective(DutyInfo record);

    int updateByPrimaryKey(DutyInfo record);
}