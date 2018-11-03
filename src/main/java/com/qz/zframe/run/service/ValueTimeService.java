package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.ValueTime;

/**
 * <p>Title: ValueTimeService</p>
 * <p>@Description: 接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:27:29
 * @version:V1.0
 */
public interface ValueTimeService {

	/**
	 * @Description:批量获取值次信息
	 * @param: @param valueTime
	 * @param: @return   
	 * @return: List<ValueTime>
	 */
	List<ValueTime> ListValueTime(ValueTime valueTime);

	/**
	 * @Description:添加值次信息
	 * @param: @param valueTime
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveValueTime(ValueTime valueTime);

	/**
	 * @Description:批量移除值次信息
	 * @param: @param ids
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeValueTimes(List<String> ids);

	/**
	 * @Description:批量编辑值次信息
	 * @param: @param valueTimes
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity editRecord(List<ValueTime> valueTimes);

	/**
	 * @Description:获取最大的sort值
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity getMaxSort();
	
	
	/**
	 * @Description:通过id查询字段
	 * @param: @param id
	 * @param: @return   
	 * @return: ValueTime
	 */
	ValueTime getValueTimeById(String id);
	
	
}

