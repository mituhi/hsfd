package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.DutyRemember;
import com.qz.zframe.run.entity.DutyRememberExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DutyRememberMapper {
    int countByExample(DutyRememberExample example);

    int deleteByExample(DutyRememberExample example);

    int deleteByPrimaryKey(String dutyId);

    int insert(DutyRemember record);

    int insertSelective(DutyRemember record);

    List<DutyRemember> selectByExample(DutyRememberExample example);

    DutyRemember selectByPrimaryKey(String dutyId);

    int updateByExampleSelective(@Param("record") DutyRemember record, @Param("example") DutyRememberExample example);

    int updateByExample(@Param("record") DutyRemember record, @Param("example") DutyRememberExample example);

    int updateByPrimaryKeySelective(DutyRemember record);

    int updateByPrimaryKey(DutyRemember record);
}