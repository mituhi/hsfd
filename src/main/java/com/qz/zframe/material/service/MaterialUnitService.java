package com.qz.zframe.material.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.MaterialUnit;
import com.qz.zframe.material.entity.MaterialUnitExample;

public interface MaterialUnitService {

	/**
	 * 获取物资单位列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return NewPageResult<MaterialUnit>    返回类型
	 * @throws
	 */
	public NewPageResult<MaterialUnit> getMaterialUnitList(MaterialUnitExample example);

	/**
	 * 获取物资单位详情
	 * 
	 * @param @param measuringUnitId
	 * @param @return    参数
	 * @return ResultEntityDetail<MaterialUnit>    返回类型
	 * @throws
	 */
	public ResultEntityDetail<MaterialUnit> getMaterialUnitDetail(String measuringUnitId);

	/**
	 * 新增单位
	 * 
	 * @param @param m
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addMaterialUnit(MaterialUnit m);

	/**
	 * 编辑物资单位
	 * 
	 * @param @param materialUnit
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editMaterialUnit(MaterialUnit materialUnit);

	/**
	 * 批量删除
	 * 
	 * @param @param measuringUnitIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delUnit(List<String> measuringUnitIds);
	

}
