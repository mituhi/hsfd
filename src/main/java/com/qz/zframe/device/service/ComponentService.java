package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.Components;
import com.qz.zframe.device.entity.ComponentsExample;

public interface ComponentService {

	/**
	 * 查询设备部件信息
	 * 
	 * @param components
	 * @return
	 */
	public PageResultEntity findComponent(ComponentsExample componentsExample);

	/**
	 * 删除设备部件信息
	 * 
	 * @param components
	 * @return
	 */
	public ResultEntity deleteComponent(List<String> componentsIds);

	/**
	 * // 添加设备部件信息
	 * 
	 * @param components
	 * @return
	 */

	public ResultEntity addComponent(Components components);

	/**
	 * // 修改设备部件信息
	 * 
	 * @param components
	 * @return
	 */

	public ResultEntity updateComponent(Components components);

	/**
	 * //查询设备部件的详情
	 * 
	 * @param components
	 * @return
	 */

	public PageResultEntity findById(String componentId);

	/*
	 * //保存数据到设备部件表 public ResultEntity addRrecord(List<Components> componts);
	 */

}
