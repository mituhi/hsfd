package com.qz.zframe.material.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddressExample;

public interface StockAddressService {

	/**
	 * 获取库存地点列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public PageResultEntity getStockAddrList(StockAddressExample example);

	/**
	 * 获取库存地点详情
	 * 
	 * @param @param materialGroupId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity getStockAddrdetailById(String stockAddId);

	/**
	 * 新增库存地点
	 * 
	 * @param @param stockAddress
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addStockAddr(StockAddress stockAddress);

	/**
	 * 编辑库存地点信息
	 * 
	 * @param @param stockAddress
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editStockAddr(StockAddress stockAddress);

	/**
	 * 删除库存地址，假删除
	 * 
	 * @param @param stockAddIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delStockAddr(List<String> stockAddIds);

}
