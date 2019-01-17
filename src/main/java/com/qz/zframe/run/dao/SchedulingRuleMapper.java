package com.qz.zframe.run.dao;

import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import java.util.List;

import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.dto.IscUserDto;
import com.qz.zframe.run.entity.dto.RuleShiftValueDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchedulingRuleMapper {
    int countByExample(SchedulingRuleExample example);

    int deleteByExample(SchedulingRuleExample example);

    int deleteByPrimaryKey(String schedulingRuleId);

    /**
     * 插入排班规则
     * @param record 排班规则实体
     * @return
     */
    int insert(SchedulingRule record);

    int insertSelective(SchedulingRule record);

    List<SchedulingRule> selectByExample(SchedulingRuleExample example);

    SchedulingRule selectByPrimaryKey(String schedulingRuleId);

    int updateByExampleSelective(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByExample(@Param("record") SchedulingRule record, @Param("example") SchedulingRuleExample example);

    int updateByPrimaryKeySelective(SchedulingRule record);

    int updateByPrimaryKey(SchedulingRule record);

    List<SchedulingRule> selectByWindCode(@Param(value="windCode") String windCode);

    List<Shift> getShifts(String schedulingRuleId);

    int findSchedulingRuleCode(String schedulingRuleCode);

    int count();

    void deleteById(@Param(value="id")String id);

    int countBySchedulingRuleId(String schedulingRuleId);

    int countBySchedulingRuleCode(String schedulingRuleCode);

    String findSchedulingRuleCodeById(String schedulingRuleId);

    List<RuleShiftValueDto> findRuleShiftValueDto(@Param(value="schedulingRuleId")String schedulingRuleId,@Param(value="list") List<Integer> list);

    List<IscUserDto> findIscUserDto(@Param(value="schedulingRuleId")String schedulingRuleId,@Param(value="valueId") String valueId);

    List<RuleShiftValueDto> findRuleShiftValueDtoByschedulingRuleIdAndDayId(@Param(value="schedulingRuleId")String schedulingRuleId,@Param(value="dayId") String dayId);

    String findMaxDayIdBySchedulingRuleId(String schedulingRuleId);

    List<RuleShiftValueDto> findRuleShiftValueDtoByschedulingRuleId(String schedulingRuleId);

    List<IscUserDto> findIscUserDtoBySchedulingRuleId(String schedulingRuleId);

    List<String> findValueIdsBySchedulingRuleId(String schedulingRuleId);

    List<String> findDayIdsBySchedulingRuleId(String schedulingRuleId);

    List<String> findValueIdsBySchedulingRuleById(String schedulingRuleId);

    List<String> findShiftIdsBySchedulingRuleById(String schedulingRuleId);
}