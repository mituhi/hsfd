package com.qz.zframe.material.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseTypeExample;



@Mapper
public interface StoreHouseTypeMapper extends BaseMapper<StoreHouseType, StoreHouseTypeExample, Long>{

	/**
	 * 批量将出库类型设为删除状态
	 * 
	 * @param @param params
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int updateIsdete(Map<String, Object> params);
   
}