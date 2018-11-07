package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.RuleShiftValueExample;

/**
 * <p>Title: RuleShiftValueService</p>
 * <p>@Description: 排班班次值次关联表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午3:32:54
 * @version:V1.0
 */
public interface RuleShiftValueService {

	/**
	 * @Description:返回批量结果
	 * @param: @param ruleShiftValueId
	 * @param: @return   
	 * @return: RuleShiftValue
	 */
	List<RuleShiftValue> getRuleShiftValues(RuleShiftValueExample example ,int pageNo , int pageSize);
	
	
	/**
	 * @Description:删除排班班次值次信息
	 * @param: @param ruleShiftValueIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeRuleShiftValue(List<String> ruleShiftValueIds);
	
	
	
	/**
	 * @Description:通过排班规则id删除信息
	 * @param: @param schedulingRuleId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeRuleShiftValueBySchedulingRuleId(String schedulingRuleId);
	
	
	/**
	 * @Description:保存排班班次值次表信息
	 * @param: @param ruleShiftValue   
	 * @return: void
	 */
	ResultEntity saveRuleShiftValue(RuleShiftValue ruleShiftValue);
	
	
}
