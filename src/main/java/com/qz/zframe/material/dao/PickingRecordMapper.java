package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.PickingRecord;
import com.qz.zframe.material.entity.PickingRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PickingRecordMapper extends BaseMapper<PickingRecord, PickingRecordExample, Long> {

	/**
	 * 获取
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String selectMaxOrder();

	/**
	 * 获取最大单号
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String getMaxPickingOrder();

	void deleteByPickingId(List<String> pickingIds);
   
}