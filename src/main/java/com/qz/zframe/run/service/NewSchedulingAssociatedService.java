package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.NewSchedulingAssociated;
import com.qz.zframe.run.entity.NewSchedulingAssociatedExample;

public interface NewSchedulingAssociatedService {

	/**
	 * 排班管理列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return NewPageResult<NewSchedulingAssociated>    返回类型
	 * @throws
	 */
	public NewPageResult<NewSchedulingAssociated> getSchedulingAssociatedList(NewSchedulingAssociatedExample example);

	/**
	 * 查询排班管理详情
	 * 
	 * @param @param associatedId
	 * @param @return    参数
	 * @return NewPageResult<NewSchedulingAssociated>    返回类型
	 * @throws
	 */
	public NewPageResult<NewSchedulingAssociated> getSchedulingAssociatedDetail(String associatedId);

	/**
	 * 新增排班管理
	 * 
	 * @param @param newSchedulingAssociated
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity saveSchedulingAssociated(NewSchedulingAssociated newSchedulingAssociated);

	/**
	 * 编辑排班管理
	 * 
	 * @param @param newSchedulingAssociated
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editSchedulingAssociated(NewSchedulingAssociated newSchedulingAssociated);

	/**
	 * 批量删除排管管理详情
	 * 
	 * @param @param associatedDetailIds
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity delAssociatedDetail(List<String> associatedDetailIds);

}
