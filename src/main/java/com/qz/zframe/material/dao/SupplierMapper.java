package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.material.entity.Supplier;
import com.qz.zframe.material.entity.SupplierExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierMapper extends BaseMapper<Supplier, SupplierExample, Long> {

	/**
	 * 批量修改状态
	 * 
	 * @param @param params
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int updateIsdete(Map<String, Object> params);
	
	public List<Supplier> selectSupplier();

}