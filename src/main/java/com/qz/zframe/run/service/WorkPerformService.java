package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.WorkPerform;
import com.qz.zframe.run.entity.WorkPerformExample;

/**
 * <p>Title: WorkPerformService</p>
 * <p>@Description: 任务执行表接口声明 </p>
 * @author 
 * @date 2018年11月13日 上午10:05:51
 * @version:V1.0
 */
public interface WorkPerformService {

	/**
	 * @Description:保存任务执行表信息
	 * @param: @param workPerform
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveWorkPerform(WorkPerform workPerform);
	

	/**
	 * @Description:批量获取数据
	 * @param: @param example
	 * @param: @return   
	 * @return: List<WorkPerform>
	 */
	List<WorkPerform> listWorkPerform(WorkPerformExample example);
	
	
	/**
	 * @Description:根据id进行删除
	 * @param: @param performId   
	 * @return: void
	 */
	void deleteWorkPerformById(String performId);
	
	
	/**
	 * @Description:更新
	 * @param: @param workPerform
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateWorkPerform(WorkPerform workPerform);
	
	
	
	/**
	 * @Description:通过id获取对象
	 * @param: @param performId
	 * @param: @return   
	 * @return: WorkPerform
	 */
	WorkPerform getWorkPerformById(String performId);
	
	
	
	/**
	 * @Description:修改完成情况状态
	 * @param: @param performId： 需要修改的id
	 * @param: @param completeStatus：状态
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity doneWorkPerform(String performId, String completeStatus);
	
}
