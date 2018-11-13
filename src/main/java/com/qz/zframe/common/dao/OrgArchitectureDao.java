package com.qz.zframe.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.entity.OrgArchitecture;
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
	 * @param isdisable
	 * @return
	 */
	Integer findOrgArchitectureNum(String architectureType, String architectureName, String isDisable);

	/**
	 * 分页条件查询组织架构信息
	 * @param architectureType
	 * @param architectureName
	 * @param isdisable
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	List<OrgArchitecture> findOrgArchitecture(String architectureType, String architectureName, String isDisable,
			int firstIndex, int lastIndex);

	/**
	 * 根据id查询组织架构信息
	 * @param architectureId
	 * @return
	 */
	OrgArchitecture findOrgArchitectureById(String architectureId);

	/**
	 * 根据组织架构id查询机构注册信息
	 * @param architectureId
	 * @return
	 */
	RegistrationInformation findRegistrationInformationByArchitectureId(String architectureId);

	/**
	 * 根据组织架构id查询风电场信息
	 * @param architectureId
	 * @return
	 */
	WindField findWindFieldByArchitectureId(String architectureId);

	/**
	 * 根据组织架构id查询关联部门人员信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitectureUser> findOrgArchitectureUserByArchitectureId(String architectureId);

	/**
	 * 根据组织架构id查询关联班组人员信息
	 * @param architectureId
	 * @return
	 */
	List<OrgArchitectureTeam> findOrgArchitectureTeamByArchitectureId(String architectureId);

	/**
	 * 根据编号或名称查询组织架构信息
	 * @param architectureCode
	 * @param architectureName
	 * @return
	 */
	OrgArchitecture findOrgArchitectureByCodeOrName(String architectureCode, String architectureName);

	/**
	 * 新增组织架构信息
	 * @param orgArchitecture
	 */
	void addOrgArchitecture(OrgArchitecture orgArchitecture);

	/**
	 * 新增机构注册信息
	 * @param orgArchitecture
	 */
	void addRegistrationInformation(RegistrationInformation registrationInformation);

	/**
	 * 新增风场信息
	 * @param orgArchitecture
	 */
	void addWindField(WindField windField);
	
	/**
	 * 批量新增部门关联关系
	 * @param orgArchitectureUsers
	 */
	void addOrgArchitectureUsers(List<OrgArchitectureUser> orgArchitectureUsers);

	/**
	 * 批量新增班组关联关系
	 * @param orgArchitectureUsers
	 */
	void addOrgArchitectureTeams(List<OrgArchitectureTeam> orgArchitectureTeams);

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

}
