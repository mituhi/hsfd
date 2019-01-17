package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyPersonUpdate;
import com.qz.zframe.run.entity.DutyPersonUpdateExample;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.entity.submit.DutyPersonUpdateSubmit;

/**
 * <p>Title: DutyPersonUpdateService</p>
 * <p>@Description: 值班人员修改接口声明 </p>
 * @author
 * @date 2018年11月21日 下午2:53:19
 * @version:V1.0
 */
public interface DutyPersonUpdateService {

	/**
	 * @Description:保存值班人员修改信息
	 * @param: @param schedulingManagement
	 * @param: @param associateds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyPersonUpdate(SchedulingManagement schedulingManagement , List<SchedulingAssociated> associateds);
	
	
	/**
	 * @Description:封装查询条件查找对象
	 * @param: @param dutyPersonUpdateSubmit
	 * @param: @return   
	 * @return: List<SchedulingQueryResult>
	 */
	List<SchedulingQueryResult> getDutyPersonUpdateBySubmit(DutyPersonUpdateSubmit dutyPersonUpdateSubmit);

	
	/**
	 * @Description:封装查询条件查找对象
	 * @param: @param dutyPersonUpdateSubmit
	 * @param: @return   
	 * @return: List<SchedulingQueryResult>
	 */
	List<SchedulingQueryResult> getSchedulingQueryBySubmit(DutyPersonUpdateSubmit dutyPersonUpdateSubmit);
	
	
	
	/**
	 * @Description:保存
	 * @param: @param dutyPersonUpdate
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyPersonUpdate(DutyPersonUpdate dutyPersonUpdate);
	
	
	/**
	 * @Description:根据id删除
	 * @param: @param dutyPersonUpdateId
	 * @param: @return   
	 * @return: int
	 */
	int deleteDutyPersonUpdate(String dutyPersonUpdateId);
	
	
	
	/**
	 * @Description:删除
	 * @param: @param example
	 * @param: @return   
	 * @return: int
	 */
	int deleteDutyPersonUpdateByExample(DutyPersonUpdateExample example);
	
	
	/**
	 * @Description:批量添加
	 * @param: @param dutyPersonUpdates
	 * @param: @return   
	 * @return: int
	 */
	int addDutyPersonUpdate(List<DutyPersonUpdate> dutyPersonUpdates);
	
	
}
