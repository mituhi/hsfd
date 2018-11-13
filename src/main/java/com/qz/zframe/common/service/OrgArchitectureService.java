package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.OrgArchitectureTeam;
import com.qz.zframe.common.entity.OrgArchitectureUser;
import com.qz.zframe.common.entity.RegistrationInformation;
import com.qz.zframe.common.entity.WindField;
import com.qz.zframe.common.util.PageResultEntity;

public interface OrgArchitectureService {

	/**
	 * 条件查询组织架构信息
	 * @param architectureType
	 * @param architectureName
	 * @param isdisable
	 * @param size 
	 * @param page 
	 * @return
	 */
	PageResultEntity queryOrgArchitecture(String architectureType, String architectureName, String isDisable, Integer page, Integer size);

	/**
	 * 根据id查询组织架构信息
	 * @param architectureId
	 * @return
	 * @throws Exception 
	 */
	OrgArchitecture queryOrgArchitectureById(String architectureId) throws Exception;

	/**
	 * 新增修改组织架构
	 * @param orgArchitecture
	 * @return
	 * @throws Exception 
	 */
	OrgArchitecture addAndUpdateOrgArchitecture(OrgArchitecture orgArchitecture) throws Exception;
	
	/**
	 * 新增机构注册信息
	 * @param registrationInformation
	 * @return
	 * @throws Exception 
	 */
	RegistrationInformation addAndUpdateRegistrationInformation(String architectureId, RegistrationInformation registrationInformation) throws Exception;
	
	/**
	 * 新增修改风场信息
	 * @param registrationInformation
	 * @return
	 * @throws Exception 
	 */
	WindField addAndUpdateWindField(String architectureId, WindField windField) throws Exception;
	
	/**
	 * 新增修改部门关联关系
	 * @param orgArchitectureUsers
	 * @return
	 * @throws Exception 
	 */
	List<OrgArchitectureUser> addAndUpdateOrgArchitectureUser(String architectureId, List<OrgArchitectureUser> orgArchitectureUsers) throws Exception;
	
	/**
	 * 新增修改班组关联关系
	 * @param orgArchitectureUsers
	 * @return
	 * @throws Exception 
	 */
	List<OrgArchitectureTeam> addAndUpdateOrgArchitectureTeam(String architectureId, List<OrgArchitectureTeam> orgArchitectureTeams) throws Exception;

	/**
	 * 删除组织架构
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteOrgArchitecture(List<String> ids) throws Exception;
	
	/**
	 * 删除机构注册信息
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteRegistrationInformation(List<String> ids) throws Exception;
	
	/**
	 * 删除风场信息
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteWindField(List<String> ids) throws Exception;
	
	/**
	 * 删除部门关联关系
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteOrgArchitectureUser(List<String> ids) throws Exception;
	
	/**
	 * 删除班组关联关系
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteOrgArchitectureTeam(List<String> ids) throws Exception;

	
}
