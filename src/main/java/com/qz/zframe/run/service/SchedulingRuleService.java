package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;

/**
 * <p>Title: SchedulingRuleService</p>
 * <p>@Description: 接口声明 </p>
 * @author 陈汇奇
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
	List<SchedulingRule> listSchedulingRule(SchedulingRuleExample example , int pageNo,int pageSize);

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
	
	
}
