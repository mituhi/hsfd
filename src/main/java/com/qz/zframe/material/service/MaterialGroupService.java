package com.qz.zframe.material.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.MaterialGroupExample;

public interface MaterialGroupService {

	/**
	 * 获取物资分组列表
	 * 
	 * @param @param materialGroupExample
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<MaterialGroup> getGroupList(MaterialGroupExample materialGroupExample)  throws Exception;

	/**
	 * 根据物资组id获取详情
	 * 
	 * @param @param materialGroupId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity getGroupdetailById(String materialGroupId)throws Exception;

	/**
	 * 新增物资组
	 * 
	 * @param @param materialGroupId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addGroup(MaterialGroup materialGroupId);

	/**
	 * 编辑物资组信息
	 * 
	 * @param @param materialGroup
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editGroup(MaterialGroup materialGroup);

	/**
	 * 批量删除物资组
	 * 
	 * @param @param materialGroupIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delGroup(List<String> materialGroupIds);

}
