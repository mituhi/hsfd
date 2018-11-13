package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.WorkTaskExample;

/**
 * <p>Title: WorkTaskService</p>
 * <p>@Description:工作任务表接口声明  </p>
 * @author 陈汇奇
 * @date 2018年11月12日 下午3:33:48
 * @version:V1.0
 */
public interface WorkTaskService {

	
	/**
	 * @Description:保存操作
	 * @param: @param workTask
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveWorkTask(WorkTask workTask);
	
	
	/**
	 * @Description:批量获取
	 * @param: @param example
	 * @param: @return   
	 * @return: List<WorkTask>
	 */
	List<WorkTask> listWorkTask(WorkTaskExample example);
	
	/**
	 * @Description:更新
	 * @param: @param workTask
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateWorkTask(WorkTask workTask);
	
	
	
	/**
	 * @Description:删除
	 * @param: @param workTaskId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteWorkTask(String workTaskId);
	
	
	
	
}
