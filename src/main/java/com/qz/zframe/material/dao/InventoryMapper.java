package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryMapper extends BaseMapper<Inventory, InventoryExample, Long>{
	
	public abstract Inventory selectAveragePriceExample(InventoryExample example);

	//条件+分页查询当前库存
	List<Inventory> getInventoryList(@Param("map") Map<String, String> pageAndCondition);

	//条件查询当前总记录数
	int getTotal(@Param("map") Map<String, String> pageAndCondition);

	/**
	 * 批量更新
	 * 
	 * @param @param inventorieList    参数
	 * @return void    返回类型
	 * @throws
	 */
	public abstract void updateBatch(List<Inventory> inventorieList);
   
}