package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.util.PageResultEntity;

public interface DeployService {

	/**
	 * 条件查询流程主表
	 * @param mainDeployName
	 * @return
	 */
	List<DeployMain> queryDeployMain(String mainDeployName);

	/**
	 * 根据id查询流程主表
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	DeployMain queryDeployMainById(String id) throws Exception;

	/**
	 * 新增修改流程
	 * @param deployMain
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity addAndUpdateDeployMain(DeployMain deployMain) throws Exception;

	/**
	 * 根据id查询流程步骤
	 * @param deployId
	 * @return
	 * @throws Exception 
	 */
	Deploy queryDeployById(String deployId) throws Exception;

	/**
	 * 新增修改流程步骤
	 * @param deploy
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity addAndUpdateDeploy(Deploy deploy) throws Exception;

	/**
	 * 删除流程步骤
	 * @param deployIds
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity deleteDeploy(List<String> deployIds) throws Exception;

	/**
	 * 根据流程编号查询流程信息
	 * @param mainCode
	 * @return
	 */
    DeployMain queryDeployMainByCode(String mainCode) throws Exception;
}
