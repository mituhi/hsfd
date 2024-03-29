package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface InInventoryMapper extends BaseMapper<InInventory, InInventoryExample, Long>{

	/**
	 * 根据入库单主键删除数据
	 *
	 * @param @param inInventoryId
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int  delByInventory(String inInventoryId);

	/**
	 * 批量删除入库单
	 * 
	 * @param @param inInventoryIds    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteByIds(List<String> inInventoryIds);

	/**
	 * 获取最大入库单号
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String getMaxInInventoryOrder(String inInventoryType);

	/**
	 * 根据code获取是否出库入库
	 */
	String getNegativeByTypeCode(@Param("typeCode") String typeCode);
   
}