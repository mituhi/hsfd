package com.qz.zframe.material.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddressExample;

@Mapper
public interface StockAddressMapper extends BaseMapper<StockAddress, StockAddressExample, Long>{

	/**
	 * 批量删除
	 *
	 * @param @param params
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int updateIsdete(Map<String, Object> params);
   
}