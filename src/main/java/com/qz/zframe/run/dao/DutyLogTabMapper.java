package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyLogTabMapper {
    int countByExample(DutyLogTabExample example);

    int deleteByExample(DutyLogTabExample example);

    int deleteByPrimaryKey(String tabId);

    int insert(DutyLogTab record);

    int insertSelective(DutyLogTab record);

    List<DutyLogTab> selectByExample(DutyLogTabExample example);

    DutyLogTab selectByPrimaryKey(String tabId);

    int updateByExampleSelective(@Param("record") DutyLogTab record, @Param("example") DutyLogTabExample example);

    int updateByExample(@Param("record") DutyLogTab record, @Param("example") DutyLogTabExample example);

    int updateByPrimaryKeySelective(DutyLogTab record);

    int updateByPrimaryKey(DutyLogTab record);
}