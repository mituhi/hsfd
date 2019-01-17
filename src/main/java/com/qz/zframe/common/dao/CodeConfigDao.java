package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.CodeConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeConfigDao {

	/**
	 * 分页查询编码配置信息
	 * @param configType
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	List<CodeConfig> queryCodeConfig(@Param("configType") String configType, @Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

	/**
	 * 查询编码配置信息条数
	 * @param configType
	 * @return
	 */
	Integer queryCodeConfigNum(@Param("configType") String configType);

	/**
	 * 根据id编码配置信息
	 * @param configId
	 * @return
	 */
	CodeConfig queryCodeConfigById(@Param("configId") String configId);

	/**
	 * 新增编码配置
	 * @param codeConfig
	 * @return
	 */
	int addCodeConfig(CodeConfig codeConfig);

	/**
	 * 修改编码配置
	 * @param codeConfig
	 * @return
	 */
	int updateCodeConfig(CodeConfig codeConfig);

	/**
	 * 删除编码配置
	 * @param configIds
	 * @return
	 */
	int deleteCodeConfig(List<String> configIds);

	/**
	 * 根据条件查询编码配置信息
	 * @param configType
	 * @param businessCode
	 * @return
	 */
	List<CodeConfig> findConfigByMsg(@Param("configType") String configType, @Param("businessCode") String businessCode);
}
