package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;

/**
 * <p>Title: LogTypeService</p>
 * <p>@Description:日志类型接口声明  </p>
 * @author 陈汇奇
 * @date 2018年11月7日 下午3:54:13
 * @version:V1.0
 */
public interface LogTypeService {

	
	/**
	 * @Description:保存日志类型信息
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveLogType(LogType LogType);
	
	
	/**
	 * @Description:根据主键删除
	 * @param: @param logTypeIds   
	 * @return: void
	 */
	void removeLogType(List<String> logTypeIds);
	
	
	/**
	 * @Description:修改
	 * @param: @param logType
	 * @param: @return   
	 * @return: ResultEntity
	 */
	void editLogTypeById(LogType logType);
	
	
	/**
	 * @Description:批量查询
	 * @param: @param example
	 * @param: @return   
	 * @return: List<LogType>
	 */
	List<LogType> listLogType(LogTypeExample example);
	
	
	/**
	 * @Description:根据日志名称获取对象
	 * @param: @param example
	 * @param: @return   
	 * @return: List<LogType>
	 */
	List<LogType> getListByLogName(LogTypeExample example);
	
	
	
	/**
	 * @Description:根据日志类型获取对象
	 * @param: @param example
	 * @param: @return   
	 * @return: LogType
	 */
	LogType getLogTypeByLogType(LogTypeExample example);
	
}
