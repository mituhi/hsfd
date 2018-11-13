package com.qz.zframe.material.service;

import java.text.ParseException;
import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventoryExample;

public interface InInventoryService {

	/**
	 * 获取入库单列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public PageResultEntity getListInInventory(InInventoryExample example);

	/**
	 * 新增入库单
	 * 
	 * @param @param inInventory
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity saveInInventory(InInventory inInventory);

	/**
	 * 获取入库单详情
	 * 
	 * @param @param inInventoryId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity getDetailInInventory(String inInventoryId);

	/**
	 * 编辑入库信息
	 * 
	 * @param @param inInventory
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editInInventory(InInventory inInventory) throws ParseException;

	/**
	 * 删除入库单
	 * 
	 * @param @param inInventoryIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delInInventory(List<String> inInventoryIds);

}
