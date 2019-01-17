package com.qz.zframe.material.service;

import java.util.List;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseTypeExample;

public interface StoreHouseTypeService {

	/**
	 * 获取出库类型列表
	 *
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<StoreHouseType> getStoreHouseTypeList(StoreHouseTypeExample example);

	/**
	 * 获取出库类型详情
	 * 
	 * @param @param typeId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntityDetail<StoreHouseType> getStoreHouseTypeDetail(String typeId);

	/**
	 * 新增出库类型
	 * 
	 * @param @param storeHouseType
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addStoreHouseType(StoreHouseType storeHouseType);

	/**
	 * 编辑出库类型信息
	 * 
	 * @param @param storeHouseType
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editStoreHouseType(StoreHouseType storeHouseType);

	/**
	 * 批量删除出库类型
	 * 
	 * @param @param typeIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delStoreHouseType(List<String> typeIds);

}
