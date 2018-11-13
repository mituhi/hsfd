package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingManagementExample;

/**
 * <p>Title: SchedulingManagementService</p>
 * <p>@Description: 接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:27:54
 * @version:V1.0
 */
public interface SchedulingManagementService {

	/**
	 * @Description:批量获取排班管理
	 * @param: @param example
	 * @param: @return   
	 * @return: List<SchedulingManagement>
	 */
	List<SchedulingManagement> listSchedulingManagement(SchedulingManagementExample example);

	/**
	 * @Description:添加排班管理
	 * @param: @param schedulingManagement
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveSchedulingManagement(SchedulingManagement schedulingManagement);

	
	/**
	 * @Description:根据主键查询字段
	 * @param: @param schedulingManagementId
	 * @param: @return   
	 * @return: SchedulingManagement
	 */
	SchedulingManagement getSchedulingManagementById(String schedulingManagementId);
	
	
	/**
	 * @Description:更新排班管理表信息
	 * @param: @param schedulingManagement
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateSchedulingManagement(SchedulingManagement schedulingManagement);
	
	
	/**
	 * @Description:根据部门名称查询对应排班管理表信息
	 * @param: @param departments
	 * @param: @return   
	 * @return: List<SchedulingManagement>
	 */
	List<SchedulingManagement> getSchedulingManagementByDepartments(List<String> departments);
	
	
	
	/**
	 * @Description:根据排班表名称获取排班管理信息
	 * @param: @param schedulingName
	 * @param: @return   
	 * @return: SchedulingManagement
	 */
	SchedulingManagement getSchedulingManagementBySchedulingName(String schedulingName);
	
}
