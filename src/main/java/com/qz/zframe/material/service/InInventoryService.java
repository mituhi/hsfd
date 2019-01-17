package com.qz.zframe.material.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventoryDetail;
import com.qz.zframe.material.entity.InInventoryDetailExample;
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
	public NewPageResult<InInventory> getListInInventory(InInventoryExample example);

	/**
	 * 新增入库单
	 * 
	 * @param @param inInventory
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity saveInInventory(InInventory inInventory) throws Exception;

	/**
	 * 获取入库单详情
	 * 
	 * @param @param inInventoryId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntityDetail<InInventory> getDetailInInventory(String inInventoryId);

	/**
	 * 编辑入库信息
	 * 
	 * @param @param inInventory
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editInInventory(InInventory inInventory) throws Exception;

	/**
	 * 删除入库单
	 * 
	 * @param @param inInventoryIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delInInventory(List<String> inInventoryIds);

	/**
	 * 获取入库单最大单号
	 * @Title: getMaxInInventoryOrder
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String getMaxInInventoryOrder(String inInventoryType);

	public ResultEntity updateOrderStatus(InInventory inInventory) throws Exception;

	/**
	 * 获取入库单中物资明细列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<InInventoryDetail> getStageInventoryDetailList(InInventoryDetailExample example);

	/**
	 * 导入物资
	 * 
	 * @param @param file
	 * @param @return    参数
	 * @return NewPageResult<InInventoryDetail>    返回类型
	 * @throws
	 */
	public NewPageResult<InInventoryDetail> importMaterial(MultipartFile file);

}
