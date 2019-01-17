package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.entity.ValueTime;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleShiftValueMapper {
    int countByExample(RuleShiftValueExample example);

    int deleteByExample(RuleShiftValueExample example);

    int deleteByPrimaryKey(String id);

    int insert(RuleShiftValue record);

    int insertSelective(RuleShiftValue record);

    List<RuleShiftValue> selectByExample(RuleShiftValueExample example);

    RuleShiftValue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RuleShiftValue record, @Param("example") RuleShiftValueExample example);

    int updateByExample(@Param("record") RuleShiftValue record, @Param("example") RuleShiftValueExample example);

    int updateByPrimaryKeySelective(RuleShiftValue record);

    int updateByPrimaryKey(RuleShiftValue record);

    List<RuleShiftValue> getRuleShiftValuesBySchedulingRuleId(@Param("schedulingRuleId") String schedulingRuleId);
}