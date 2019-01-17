package com.qz.zframe.run.service;

import com.qz.zframe.run.entity.MaintainLog;

/**
 * <p>Title: MaintainLogService</p>
 * <p>@Description: 维护日志表接口声明 </p>
 * @author 
 * @date 2018年11月6日 上午11:23:10
 * @version:V1.0
 */
public interface MaintainLogService {

	/**
	 * @Description:维护日志表添加
	 * @param:    
	 * @return: void
	 */
	void saveMaintainLog(MaintainLog maintainLog);
	
}
