package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogExample;
import com.qz.zframe.run.entity.result.DutyLogUpdateResult;

/**
 * <p>Title: DutyLogService</p>
 * <p>@Description: 值班日志表接口声明 </p>
 * @author 
 * @date 2018年11月8日 上午11:46:32
 * @version:V1.0
 */
public interface DutyLogService {
	
	
	/**
	 * @Description:保存
	 * @param: @param dutyLog
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyLog(DutyLog dutyLog);
	
	
	/**
	 * @Description:模糊查询
	 * @param: @param example
	 * @param: @return   
	 * @return: List<DutyLog>
	 */
	List<DutyLog> listDutyLog(DutyLogExample example);
	
	
	/**
	 * @Description:根据主键删除表信息
	 * @param: @param dutyLogIds   
	 * @return: void
	 */
	void deleteDutyLogById(List<String> dutyLogIds);
	
	
	
	/**
	 * @Description:更新
	 * @param: @param dutyLog   
	 * @return: void
	 */
	void updateDutyLog(DutyLog dutyLog);
	
	
	
	/**
	 * @Description:点击更新：获取数据
	 * @param: @param dutyLogId
	 * @param: @return   
	 * @return: DutyLogUpdateResult
	 */
	DutyLogUpdateResult getDutyLogUpdateResult(String dutyLogId);
	
	
	
	/**
	 * @Description: 选择启用时间，选择班次，获取值次，值班人员	schedulingName:排班表名称
	 * @param: @param schedulingName
	 * @param: @param startTime
	 * @param: @param shiftName
	 * @param: @return   
	 * @return: DutyLogResult
	 */
	ResultEntity getDutyLogResult( String schedulingName, String startTime ,  String shiftName);
	
}
