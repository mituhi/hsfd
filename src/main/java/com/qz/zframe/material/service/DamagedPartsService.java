package com.qz.zframe.material.service;

import java.text.ParseException;
import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.DamagedParts;
import com.qz.zframe.material.entity.DamagedPartsExample;

public interface DamagedPartsService {

	/**
	 * 获取损坏件列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<DamagedParts> getDamagedPartsList(DamagedPartsExample example);

	/**
	 * 获取损坏件入库详情
	 * 
	 * @param @param damagedPartsId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntityDetail<DamagedParts> getDamagedPartsDetails(String damagedPartsId);

	/**
	 * 新增损坏件
	 * 
	 * @param @param damagedParts
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addDamagedParts(DamagedParts damagedParts) throws ParseException;

	/**
	 * 编辑
	 * 
	 * @param @param damagedParts
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editDamagedParts(DamagedParts damagedParts) throws ParseException;

	/**
	 * 删除损坏件
	 * 
	 * @param @param damagedPartsIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delDamagedParts(List<String> damagedPartsIds);

}
