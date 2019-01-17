package com.qz.zframe.run.service;

import java.text.ParseException;
import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.Example;
import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import com.qz.zframe.run.entity.Shift;

/**
 * <p>Title: SchedulingRuleService</p>
 * <p>@Description: 接口声明 </p>
 * @author 
 * @date 2018年11月1日 下午12:27:58
 * @version:V1.0
 */
public interface SchedulingRuleService {

	
	/**
	 * @Description:批量获取排班规则
	 * @param: @param example
	 * @param: @return   
	 * @return: List<SchedulingRule>
	 */
	List<SchedulingRule> listSchedulingRule(String windCode , int pageNo,int pageSize);

	/**
	 * @Description:添加排班规则
	 * @param: @param schedulingRule
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveSchedulingRule(SchedulingRule schedulingRule);

	/**
	 * @Description:移除排班规则
	 * @param: @param schedulingRuleIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeSchedulingRule(List<String> schedulingRuleIds);

	/**
	 * @Description:批量编辑排班规则
	 * @param: @param schedulingRules
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity editSchedulingRule(List<SchedulingRule> schedulingRules);

	/**
	 * @Description:单条记录编辑排班规则
	 * @param: @param schedulingRules
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateSchedulingRule(SchedulingRule schedulingRule);

	
	/**
	 * @Description:根据主键查询字段
	 * @param: @param schedulingRuleId
	 * @param: @return   
	 * @return: SchedulingRule
	 */
	SchedulingRule getSchedulingRuleById(String schedulingRuleId);
	
	
	/**
	 * @Description:获取总记录数
	 * @param: @return   
	 * @return: int
	 */
	int getCount(SchedulingRuleExample example);
	
	
	/**
	 * @Description:根据规则编码获取排班规则表id
	 * @param: @param SchedulingRuleCode
	 * @param: @return   
	 * @return: SchedulingRule
	 */
	SchedulingRule getSchedulingRuleBySchedulingRuleCode(String SchedulingRuleCode);
	
	
	
	/**
	 * @Description:根据排班规则名称查询
	 * @param: @param schedulingRulename
	 * @param: @return   
	 * @return: SchedulingRule
	 */
	SchedulingRule getSchedulingRuleBySchedulingRuleName(String schedulingRulename);


    List<Shift> getShifts(String schedulingRuleId);

    int findSchedulingRuleCode(String schedulingRuleCode);

	String count();

	int countBySchedulingRuleId(String schedulingRuleId);

	int countBySchedulingRuleCode(String schedulingRuleCode);

	String findSchedulingRuleCodeById(String schedulingRuleId);

    ResultEntity findShiftValueUsers(Example example);

	ResultEntity findShiftValueUsers(String schedulingRuleId, String startTime, String currentTime) throws ParseException;

    List<String> findValueIdsBySchedulingRuleById(String schedulingRuleId);

	List<String> findShiftIdsBySchedulingRuleById(String schedulingRuleId);
}
