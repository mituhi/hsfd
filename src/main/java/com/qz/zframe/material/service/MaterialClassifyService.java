package com.qz.zframe.material.service;

import java.util.List;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassifyExample;
public interface MaterialClassifyService {

	/**
	 * 获取物资分组列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<MaterialClassify> getClassifyList(MaterialClassifyExample example)throws Exception;

	/**
	 * 新增物资分类
	 * 
	 * @param @param materialClassify
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addClassify(MaterialClassify materialClassify);

	/**
	 * 获取物资分类详情信息
	 * 
	 * @param @param materialClassifyId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntityDetail<MaterialClassify> getClassifyDetail(String materialClassifyId) throws Exception;

	/**
	 * 编辑物资分类信息
	 * 
	 * @param @param materialClassify
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editClassify(MaterialClassify materialClassify);

	/**
	 * 批量删除物资分类（修改状态）
	 * 
	 * @param @param materialClassifyIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delClassify(List<String> materialClassifyIds);

	NewPageResult<MaterialClassify> getClassifyListAll(MaterialClassifyExample example);



}
