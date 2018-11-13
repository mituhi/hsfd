package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.UserValueTime;

/**
 * <p>Title: UserValueTimeService</p>
 * <p>@Description: 人员值次关联表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月2日 上午10:27:23
 * @version:V1.0
 */
public interface UserValueTimeService {

	/**
	 * @Description:保存操作
	 * @param: @param userValueTime
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveUserValueTime(UserValueTime userValueTime);
	
	
	/**
	 * @Description:删除人员值次关联表
	 * @param: @param userValueTime
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteUserValueTime(UserValueTime userValueTime);
	
	
	/**
	 * @Description:通过值次id和排班规则id删除记录
	 * @param: @param valueId
	 * @param: @param schedulingRuleId   
	 * @return: void
	 */
	ResultEntity deleteUserValueTimeBySchedulingRuleIdAndValueId(String valueId,String schedulingRuleId);
	
	
	
	
	
	/**
	 * @Description:根据排班规则表id 值次id ，获取对象
	 * @param: @param shiftId
	 * @param: @param schedulingRuleId
	 * @param: @return   
	 * @return: UserValueTime
	 */
	List<UserValueTime> getUserValueTimeByValueIdAndSchedulingRuleId(String valueId,String schedulingRuleId);
	
	
	
	
	
	
	
}
