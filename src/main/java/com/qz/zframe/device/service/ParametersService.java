package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;

public interface ParametersService {
	
	/**
	 * //查询技术参数信息
	 * 
	 * @param parametersExample
	 * @param type
	 * @return
	 */
	public PageResultEntity findParameters(ParametersExample parametersExample, String type);

	/**
	 * //新增技术参数信息
	 * 
	 * @param parameters
	 * @return
	 */

	public ResultEntity addParameters(Parameters parameters);

	/**
	 * //修改技术参数信息
	 * 
	 * @param parameters
	 * @return
	 */
	public ResultEntity updateParameters(Parameters parameters);

	/**
	 * //查询技术参数信息详情
	 * 
	 * @param parameterId
	 * @return
	 */

	public PageResultEntity findByParameterId(String parameterId);

	/**
	 * //批量删除技术参数信息
	 * 
	 * @param parameterIds
	 * @return
	 */

	public ResultEntity deleteParameters(List<String> parameterIds);
}
