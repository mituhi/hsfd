package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.MaterialGroupExample;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialGroupMapper extends BaseMapper<MaterialGroup, MaterialGroupExample, Long> {

	/**
	 * 获取物资组名称出现的次数
	 * 
	 * @param @param groupName
	 * @param @return    参数
	 * @return int    返回类型
	 * @throws
	 */
	public int selectGroupName(String groupName);

	/**
	 * 批量更改删除状态
	 * 
	 * @param @param params    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void updateIsdete(Map<String, Object> params);



}