package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.OrgArchitectureCenter;
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
	 * @param isDisable
	 * @param size 
	 * @param page 
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity queryOrgArchitecture(String architectureType, String architectureName, String isDisable, Integer page, Integer size) throws Exception;

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
	PageResultEntity addAndUpdateOrgArchitecture(OrgArchitecture orgArchitecture) throws Exception;
	
	/**
	 * 新增机构注册信息
	 * @param registrationInformation
	 * @return
	 * @throws Exception 
	 */
	RegistrationInformation addAndUpdateRegistrationInformation(String architectureId, RegistrationInformation registrationInformation) throws Exception;
	
	/**
	 * 新增修改风场信息
	 * @param architectureId
	 * @param windField
	 * @return
	 * @throws Exception 
	 */
	WindField addAndUpdateWindField(String architectureId, WindField windField) throws Exception;
	
	/**
	 * 新增修改部门关联关系
	 * @param architectureId
	 * @param orgArchitectureUsers
	 * @return
	 * @throws Exception 
	 */
	List<OrgArchitectureUser> addAndUpdateOrgArchitectureUser(String architectureId, List<OrgArchitectureUser> orgArchitectureUsers) throws Exception;
	
	/**
	 * 新增修改成本中心关联关系
	 * @param architectureId
	 * @param orgArchitectureCenters
	 * @return
	 * @throws Exception 
	 */
	List<OrgArchitectureCenter> addAndUpdateOrgArchitectureCenter(String architectureId, List<OrgArchitectureCenter> orgArchitectureCenters) throws Exception;
	
	/**
	 * 新增修改班组关联关系
	 * @param architectureId
	 * @param orgArchitectureTeams
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
	PageResultEntity deleteOrgArchitecture(List<String> ids) throws Exception;
	
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
	
	/**
	 * 删除成本中心关联关系
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteOrgArchitectureCenter(List<String> ids) throws Exception;

	/**
	 * 查询组织架构信息列表
	 * @param architectureId
	 * @param architectureType
	 * @param architectureName
	 * @param superCompetentDepartment 
	 * @return
	 */
	List<OrgArchitecture> queryOrgArchitectureList(String architectureId, String architectureType,
			String architectureName, String superCompetentDepartment);

	/**
	 * 根据userId删除部门用户关联信息
	 * @param userId
	 * @throws Exception 
	 */
	void deleteRaleOrgArchitectureUser(String userId) throws Exception;
	
	/**
	 * 根据父id查询组织架构信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitecture> findOrgArchitectureByFid(String architectureId);

	/**
	 * 根据风电场编码查询风电场Id
	 * @param @param windId
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String getwindId(String windId);

	/**
	 * 根据风电场编号查询部门信息
	 * @param architectureCode
	 * @param architectureType
	 * @return
	 */
    List<OrgArchitecture> queryOrgArchitectureListByCode(String architectureCode, String architectureType) throws Exception;
}
