package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.run.entity.SchedulingQuery;

/**
 * <p>Title: SchedulingQueryService</p>
 * <p>@Description: 排班查询接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月5日 下午1:32:11
 * @version:V1.0
 */
public interface SchedulingQueryService {

	/**
	 * @Description:排班查询获取
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: List<SchedulingQuery>
	 */
	List<SchedulingQuery> listSchedulingQuery(SchedulingQuery schedulingQuery);
	
	
	/**
	 * @Description:值班人员修改首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: List<SchedulingQuery>
	 */
	List<SchedulingQuery> listUpdateOperator(SchedulingQuery schedulingQuery);
	
	
	/**
	 * @Description:值班人员修改
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: int
	 */
	int updateOperator(SchedulingQuery schedulingQuery,String userId);
	
	
}

