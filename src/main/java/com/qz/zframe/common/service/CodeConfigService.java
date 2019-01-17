package com.qz.zframe.common.service;

import com.qz.zframe.common.entity.CodeConfig;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;

import java.util.List;

public interface CodeConfigService {

	/**
	 * 分页查询编码配置信息
	 * @param configType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResultEntity queryCodeConfig(String configType, Integer pageNum, Integer pageSize);

	/**
	 * 根据id编码配置信息
	 * @param configId
	 * @return
	 * @throws Exception
	 */
	CodeConfig queryCodeConfigById(String configId) throws Exception;

	/**
	 * 新增编码配置
	 * @param codeConfig
	 * @return
	 * @throws Exception
	 */
	ResultEntity addCodeConfig(CodeConfig codeConfig) throws Exception;

	/**
	 * 修改编码配置
	 * @param codeConfig
	 * @return
	 * @throws Exception
	 */
	ResultEntity updateCodeConfig(CodeConfig codeConfig) throws Exception;

	/**
	 * 删除编码配置
	 * @param configIds
	 * @return
	 */
	ResultEntity deleteCodeConfig(List<String> configIds);

	/**
	 * 根据条件判断编码配置信息是否已经配置过
	 * @param configType
	 * @param businessCode
	 * @return
	 * @throws Exception
	 */
	boolean checkCodeConfigByMsg(String configType, String businessCode) throws Exception;

	/**
	 * 根据条件查询配置值
	 * @param configType
	 * @param businessCode
	 * @return
	 * @throws Exception
	 */
	String findValueByMsg(String configType, String businessCode) throws Exception;
}
