package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchedulingRuleMapper {
    int countByExample(SchedulingRuleExample example);

    int deleteByExample(SchedulingRuleExample example);

    int deleteByPrimaryKey(String schedulingRuleId);

    int insert(SchedulingRule record);

    int insertSelective(SchedulingRule record);

    List<SchedulingRule> selectByExample(SchedulingRuleExample example);

    SchedulingRule selectByPrimaryKey(String schedulingRuleId);

    int updateByExampleSelective(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByExample(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByPrimaryKeySelective(SchedulingRule record);

    int updateByPrimaryKey(SchedulingRule record);
}