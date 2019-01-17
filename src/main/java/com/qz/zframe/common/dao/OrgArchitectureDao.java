package com.qz.zframe.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.OrgArchitectureCenter;
import com.qz.zframe.common.entity.OrgArchitectureTeam;
import com.qz.zframe.common.entity.OrgArchitectureUser;
import com.qz.zframe.common.entity.RegistrationInformation;
import com.qz.zframe.common.entity.WindField;

@Mapper
public interface OrgArchitectureDao {

	/**
	 * 条件查询组织架构数量
	 * @param architectureType
	 * @param architectureName
	 * @param isDisable
	 * @return
	 */
	Integer findOrgArchitectureNum(@Param("architectureType") String architectureType, 
			@Param("architectureName") String architectureName, @Param("isDisable") String isDisable);

	/**
	 * 分页条件查询组织架构信息
	 * @param architectureType
	 * @param architectureName
	 * @param isDisable
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	List<OrgArchitecture> findOrgArchitecture(@Param("architectureType") String architectureType, 
			@Param("architectureName") String architectureName, @Param("isDisable") String isDisable,
			@Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

	/**
	 * 根据id查询组织架构信息
	 * @param architectureId
	 * @return
	 */
	OrgArchitecture findOrgArchitectureById(@Param("architectureId") String architectureId);

	/**
	 * 根据组织架构id查询机构注册信息
	 * @param architectureId
	 * @return
	 */
	RegistrationInformation findRegistrationInformationByArchitectureId(@Param("architectureId") String architectureId);

	/**
	 * 根据组织架构id查询风电场信息
	 * @param architectureId
	 * @return
	 */
	WindField findWindFieldByArchitectureId(@Param("architectureId") String architectureId);

	/**
	 * 根据组织架构id查询关联部门人员信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitectureUser> findOrgArchitectureUserByArchitectureId(@Param("architectureId") String architectureId);

	/**
	 * 根据组织架构id查询关联班组人员信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitectureTeam> findOrgArchitectureTeamByArchitectureId(@Param("architectureId") String architectureId);
	
	/**
	 * 根据组织架构id查询关联成本中心人员信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitectureCenter> findOrgArchitectureCenterByArchitectureId(@Param("architectureId") String architectureId);

	/**
	 * 根据编号或名称查询组织架构信息
	 * @param architectureCode
	 * @param architectureName
	 * @param architectureType 
	 * @return
	 */
	OrgArchitecture findOrgArchitectureByCodeOrName(@Param("architectureCode") String architectureCode, 
			@Param("architectureName") String architectureName, @Param("architectureType") String architectureType);
	
	/**
	 * 根据编号或名称查询组织架构信息不包括自己
	 * @param architectureCode
	 * @param architectureName
	 * @param architectureType 
	 * @param architectureId 
	 * @return
	 */
	OrgArchitecture findOrgArchitectureByCodeOrNameNotMe(@Param("architectureCode") String architectureCode, 
			@Param("architectureName") String architectureName, @Param("architectureType") String architectureType,
			@Param("architectureId") String architectureId);

	/**
	 * 新增组织架构信息
	 * @param orgArchitecture
	 */
	void addOrgArchitecture(OrgArchitecture orgArchitecture);

	/**
	 * 新增机构注册信息
	 * @param registrationInformation
	 */
	void addRegistrationInformation(RegistrationInformation registrationInformation);

	/**
	 * 新增风场信息
	 * @param windField
	 */
	void addWindField(WindField windField);
	
	/**
	 * 批量新增部门关联关系
	 * @param orgArchitectureUsers
	 */
	void addOrgArchitectureUsers(List<OrgArchitectureUser> orgArchitectureUsers);

	/**
	 * 批量新增班组关联关系
	 * @param orgArchitectureTeams
	 */
	void addOrgArchitectureTeams(List<OrgArchitectureTeam> orgArchitectureTeams);
	
	/**
	 * 批量新增成本中心关联关系
	 * @param orgArchitectureCenters
	 */
	void addOrgArchitectureCenters(List<OrgArchitectureCenter> orgArchitectureCenters);

	/**
	 * 批量删除组织架构
	 * @param ids
	 */
	void deleteOrgArchitecture(List<String> ids);

	/**
	 * 删除机构注册信息
	 * @param ids
	 */
	void deleteRegistrationInformation(List<String> ids);

	/**
	 * 删除风场信息
	 * @param ids
	 */
	void deleteWindField(List<String> ids);

	/**
	 * 删除部门关联关系
	 * @param ids
	 */
	void deleteOrgArchitectureUser(List<String> ids);

	/**
	 * 删除班组关联关系
	 * @param ids
	 */
	void deleteOrgArchitectureTeam(List<String> ids);
	
	/**
	 * 删除成本中心关联关系
	 * @param ids
	 */
	void deleteOrgArchitectureCenter(List<String> ids);

	/**
	 * 批量查询组织架构信息
	 * @param ids
	 * @return
	 */
	List<OrgArchitecture> findOrgArchitectureByIds(List<String> ids);

	/**
	 * 修改组织架构信息
	 * @param orgArchitecture
	 */
	void updateOrgArchitecture(OrgArchitecture orgArchitecture);

	/**
	 * 修改机构注册信息
	 * @param registrationInformation
	 */
	void updateRegistrationInformation(RegistrationInformation registrationInformation);

	/**
	 * 修改风场信息
	 * @param windField
	 */
	void updateWindField(WindField windField);
	 
	 /**
	 * 查询风场信息
	 * 
	 */
	List<OrgArchitecture> findWind();
     //查询公司
	List<OrgArchitecture> findCompany();
	 //查询部门
	List<OrgArchitecture> findSection();
	//查询维护班组
	List<OrgArchitecture> findTeamGroup();
	/**
	 * 查询组织架构信息列表
	 * @param architectureId
	 * @param architectureType
	 * @param architectureName
	 * @param superCompetentDepartment 
	 * @return
	 */
	List<OrgArchitecture> queryOrgArchitectureList(@Param("architectureId") String architectureId, 
			@Param("architectureType") String architectureType,
			@Param("architectureName") String architectureName, 
			@Param("superCompetentDepartment") String superCompetentDepartment);

	/**
	 * 根据userId删除部门用户关联信息
	 * @param userId
	 */
	void deleteRaleOrgArchitectureUser(@Param("userId") String userId);

	/**
	 * 根据父id查询组织架构信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitecture> findOrgArchitectureByFid(@Param("architectureId") String architectureId);

	/**
	 * 根据风电场编码查询风电场Id
	 * @param @param windId
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	String getWindIdByCode(String windId);

	/**
	 * 根据风电场编号查询部门信息
	 * @param architectureCode
	 * @return
	 */
    List<OrgArchitecture> queryOrgArchitectureListByCode(@Param("architectureCode") String architectureCode);
}
