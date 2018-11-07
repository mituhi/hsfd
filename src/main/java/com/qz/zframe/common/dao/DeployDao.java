package com.qz.zframe.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;

@Mapper
public interface DeployDao {

	/**
	 * 获取所有流程主表信息
	 * @return
	 */
	List<DeployMain> findAllDeploy();

	/**
	 * 根据名称模糊查询流程主表信息
	 * @return
	 */
	List<DeployMain> findDeployMainByName(String mainDeployName);

	/**
	 * 根据mainId查询流程子表信息
	 * @return
	 */
	List<Deploy> findDeployByMainId(String mainId);

	/**
	 * 根据id查询流程主表
	 * @return
	 */
	DeployMain queryDeployMainById(String id);

	/**
	 * 根据流程编号或流程名称查询流程信息
	 * @param mainCode
	 * @param mainDeployName
	 * @return
	 */
	DeployMain findDeployMainByCodeOrName(String mainCode, String mainDeployName);

	/**
	 * 新增流程
	 * @param deployMain
	 */
	void addDeployMain(DeployMain deployMain);

	/**
	 * 修改流程
	 * @param deployMain
	 */
	void updateDeployMain(DeployMain deployMain);

	/**
	 * 根据id查询流程步骤
	 * @param deployId
	 * @return
	 */
	Deploy queryDeployById(String deployId);

}
