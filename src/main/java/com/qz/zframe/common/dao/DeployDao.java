package com.qz.zframe.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.entity.DeployRole;
import com.qz.zframe.common.entity.Role;

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
	List<DeployMain> findDeployMainByName(@Param("mainDeployName") String mainDeployName);

	/**
	 * 根据mainId查询流程子表信息
	 * @return
	 */
	List<Deploy> findDeployByMainId(@Param("mainId") String mainId);

	/**
	 * 根据id查询流程主表
	 * @return
	 */
	DeployMain queryDeployMainById(@Param("id") String id);

	/**
	 * 根据流程编号或流程名称查询流程信息
	 * @param mainCode
	 * @param mainDeployName
	 * @return
	 */
	DeployMain findDeployMainByCodeOrName(@Param("mainCode") String mainCode, @Param("mainDeployName") String mainDeployName);

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
	Deploy queryDeployById(@Param("deployId") String deployId);

	/**
	 * 根据流程步骤名称查询流程步骤
	 * @param deployName
	 * @return
	 */
	Deploy findDeployByDeployName(@Param("deployName") String deployName);

	/**
	 * 新增流程步骤
	 * @param deploy
	 */
	void addDeploy(Deploy deploy);

	/**
	 * 新增流程步骤角色关联关系
	 * @param deployRoles
	 */
	void addDeployRole(List<DeployRole> deployRoles);

	/**
	 * 修改流程步骤
	 * @param deploy
	 */
	void updateDeploy(Deploy deploy);

	/**
	 * 删除流程步骤角色关联关系
	 * @param deployId
	 */
	void deleteDeployRole(@Param("deployId") String deployId);

	/**
	 * 删除流程步骤
	 * @param deployIds
	 */
	void deleteDeploy(List<String> deployIds);

	
	/**
	 * 批量删除流程步骤角色关联关系
	 * @param deployIds
	 */
	void deleteDeployRoles(List<String> deployIds);

	/**
	 * 根据流程步骤id查询关联角色信息
	 * @param deployId
	 * @return
	 */
	List<Role> findRoleByDeployId(@Param("deployId") String deployId);

	/**
	 * 根据流程编号查询流程信息
	 * @param mainCode
	 * @return
	 */
    DeployMain queryDeployMainByCode(String mainCode);
}
