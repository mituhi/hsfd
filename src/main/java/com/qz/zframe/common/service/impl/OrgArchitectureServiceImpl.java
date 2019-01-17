package com.qz.zframe.common.service.impl;

import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.dao.OrgArchitectureDao;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrgArchitectureServiceImpl implements OrgArchitectureService {

	@Autowired
	private OrgArchitectureDao orgArchitectureDao;

	@Autowired
	private DataDictService dataDictService;

	@Override
	public PageResultEntity queryOrgArchitecture(String architectureType, String architectureName,
			String isDisable, Integer page, Integer size) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex = (page - 1) * size;
		//到第几条数据结束
		int lastIndex = page * size;

		List<OrgArchitecture> list = orgArchitectureDao.findOrgArchitecture(architectureType, architectureName, isDisable, firstIndex, lastIndex);
		if (list == null || list.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			list = makeCodeType(list);
			Integer num = orgArchitectureDao.findOrgArchitectureNum(architectureType, architectureName, isDisable);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	private List<OrgArchitecture> makeCodeType(List<OrgArchitecture> list) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("ORG_TYPE");
		codeTypes.add("IS_TOPLEVEL");
		codeTypes.add("IS_DISABLE");
		codeTypes.add("IS_VIRTUAL_ORG");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
			for(OrgArchitecture oa : list) {
				for(DataDict d : dataDicts) {
					if ("ORG_TYPE".equals(d.getCodeTypeName()) && oa.getArchitectureType().equals(d.getName())) {
						oa.setArchitectureTypeText(d.getTitle());
					}
					if ("IS_TOPLEVEL".equals(d.getCodeTypeName()) && oa.getIsTop().equals(d.getName())) {
						oa.setIsTopText(d.getTitle());
					}
					if ("IS_DISABLE".equals(d.getCodeTypeName()) && oa.getIsDisable().equals(d.getName())) {
						oa.setIsDisableText(d.getTitle());
					}
					if ("IS_VIRTUAL_ORG".equals(d.getCodeTypeName()) && oa.getIsVirtualOrg().equals(d.getName())) {
						oa.setIsVirtualOrgText(d.getTitle());
					}
				}
			}
		}
		return list;
	}

	@Override
	@CodeConvert({
		@CodeType(codeType="ORG_TYPE", nameField="architectureType", titleField="architectureTypeText"),
		@CodeType(codeType="IS_TOPLEVEL", nameField="isTopText", titleField="isTopText"),
		@CodeType(codeType="IS_DISABLE", nameField="isDisable", titleField="isDisableText"),
		@CodeType(codeType="IS_VIRTUAL_ORG", nameField="isVirtualOrg", titleField="isVirtualOrgText")
	})
	public OrgArchitecture queryOrgArchitectureById(String architectureId) throws Exception {
		if (StringUtils.isBlank(architectureId)) {
			throw new Exception("请选择组织架构信息!");
		}
		OrgArchitecture orgArchitecture = orgArchitectureDao.findOrgArchitectureById(architectureId);
		if (orgArchitecture != null && StringUtils.isNotBlank(orgArchitecture.getArchitectureType())) {
			if ("01".equals(orgArchitecture.getArchitectureType())) {
				RegistrationInformation registrationInformation = orgArchitectureDao.findRegistrationInformationByArchitectureId(orgArchitecture.getArchitectureId());
				orgArchitecture.setRegistrationInformation(registrationInformation);
			}
			if ("02".equals(orgArchitecture.getArchitectureType())) {
				WindField windField = orgArchitectureDao.findWindFieldByArchitectureId(orgArchitecture.getArchitectureId());
				orgArchitecture.setWindField(windField);
			}
			if ("03".equals(orgArchitecture.getArchitectureType())) {
				List<OrgArchitectureUser> orgArchitectureUsers = orgArchitectureDao.findOrgArchitectureUserByArchitectureId(orgArchitecture.getArchitectureId());
				orgArchitecture.setOrgArchitectureUsers(orgArchitectureUsers);
			}
			if ("04".equals(orgArchitecture.getArchitectureType())) {
				List<OrgArchitectureTeam> orgArchitectureTeams = orgArchitectureDao.findOrgArchitectureTeamByArchitectureId(orgArchitecture.getArchitectureId());
				orgArchitecture.setOrgArchitectureTeams(orgArchitectureTeams);
			}
			if ("05".equals(orgArchitecture.getArchitectureType())) {
				List<OrgArchitectureCenter> orgArchitectureCenters = orgArchitectureDao.findOrgArchitectureCenterByArchitectureId(orgArchitecture.getArchitectureId());
				orgArchitecture.setOrgArchitectureCenters(orgArchitectureCenters);
			}
		}
		return orgArchitecture;
	}

	@Override
	@Transactional
	public PageResultEntity addAndUpdateOrgArchitecture(OrgArchitecture orgArchitecture) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (orgArchitecture == null) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("对象为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureType())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("组织类型为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureCode())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("组织架构编号为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("组织架构名称为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureId())) {
			OrgArchitecture oa = orgArchitectureDao.findOrgArchitectureByCodeOrName(orgArchitecture.getArchitectureCode(),
					orgArchitecture.getArchitectureName(), orgArchitecture.getArchitectureType());
			if (oa != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("编码或名称已存在!");
				return pageResultEntity;
			}
			orgArchitecture.setArchitectureId(UUID.randomUUID().toString().replaceAll("-", ""));
			orgArchitectureDao.addOrgArchitecture(orgArchitecture);
			if ("01".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getRegistrationInformation() != null) {
				addAndUpdateRegistrationInformation(orgArchitecture.getArchitectureId(), orgArchitecture.getRegistrationInformation());
			}
			if ("02".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getWindField() != null) {
				addAndUpdateWindField(orgArchitecture.getArchitectureId(), orgArchitecture.getWindField());
			}
			if ("03".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureUsers() != null && !orgArchitecture.getOrgArchitectureUsers().isEmpty()) {
				addAndUpdateOrgArchitectureUser(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureUsers());
			}
			if ("04".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureTeams() != null && !orgArchitecture.getOrgArchitectureTeams().isEmpty()) {
				addAndUpdateOrgArchitectureTeam(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureTeams());
			}
			if ("05".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureCenters() != null && !orgArchitecture.getOrgArchitectureCenters().isEmpty()) {
				addAndUpdateOrgArchitectureCenter(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureCenters());
			}
		}else {
			OrgArchitecture oa = orgArchitectureDao.findOrgArchitectureByCodeOrNameNotMe(orgArchitecture.getArchitectureCode(),
					orgArchitecture.getArchitectureName(), orgArchitecture.getArchitectureType(), orgArchitecture.getArchitectureId());
			if (oa != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("编码或名称已存在!");
				return pageResultEntity;
			}
			orgArchitectureDao.updateOrgArchitecture(orgArchitecture);
			if ("01".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getRegistrationInformation() != null) {
				addAndUpdateRegistrationInformation(orgArchitecture.getArchitectureId(), orgArchitecture.getRegistrationInformation());
			}
			if ("02".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getWindField() != null) {
				addAndUpdateWindField(orgArchitecture.getArchitectureId(), orgArchitecture.getWindField());
			}
			if ("03".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureUsers() != null && !orgArchitecture.getOrgArchitectureUsers().isEmpty()) {
				addAndUpdateOrgArchitectureUser(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureUsers());
			}
			if ("04".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureTeams() != null && !orgArchitecture.getOrgArchitectureTeams().isEmpty()) {
				addAndUpdateOrgArchitectureTeam(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureTeams());
			}
			if ("05".equals(orgArchitecture.getArchitectureType()) && orgArchitecture.getOrgArchitectureCenters() != null && !orgArchitecture.getOrgArchitectureCenters().isEmpty()) {
				addAndUpdateOrgArchitectureCenter(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureCenters());
			}
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	@Override
	public RegistrationInformation addAndUpdateRegistrationInformation(String architectureId, RegistrationInformation registrationInformation)
			throws Exception {
		if (registrationInformation == null) {
			throw new Exception("机构注册信息为空!");
		}
		if (StringUtils.isBlank(registrationInformation.getRegistrationId())) {
			registrationInformation.setRegistrationId(UUID.randomUUID().toString().replaceAll("-", ""));
			registrationInformation.setArchitectureId(architectureId);
			orgArchitectureDao.addRegistrationInformation(registrationInformation);
		}else {
			orgArchitectureDao.updateRegistrationInformation(registrationInformation);
		}
		return registrationInformation;
	}

	@Override
	public WindField addAndUpdateWindField(String architectureId, WindField windField) throws Exception {
		if (windField == null) {
			throw new Exception("风电场子信息为空!");
		}
		if (StringUtils.isBlank(windField.getWindId())) {
			windField.setWindId(UUID.randomUUID().toString().replaceAll("-", ""));
			windField.setArchitectureId(architectureId);
			orgArchitectureDao.addWindField(windField);
		}else {
			orgArchitectureDao.updateWindField(windField);
		}
		return windField;
	}

	@Override
	public List<OrgArchitectureUser> addAndUpdateOrgArchitectureUser(String architectureId, List<OrgArchitectureUser> orgArchitectureUsers)
			throws Exception {
		if (orgArchitectureUsers == null || orgArchitectureUsers.isEmpty()) {
			throw new Exception("关联部门人员为空!");
		}
		List<String> ids = new ArrayList<>();
		ids.add(architectureId);
		deleteOrgArchitectureUser(ids);
		for(OrgArchitectureUser oau : orgArchitectureUsers) {
			if (StringUtils.isBlank(oau.getRelaId())) {
				oau.setRelaId(UUID.randomUUID().toString().replaceAll("-", ""));
				oau.setArchitectureId(architectureId);
			}
		}
		orgArchitectureDao.addOrgArchitectureUsers(orgArchitectureUsers);
		return orgArchitectureUsers;
	}

	@Override
	public List<OrgArchitectureTeam> addAndUpdateOrgArchitectureTeam(String architectureId, List<OrgArchitectureTeam> orgArchitectureTeams)
			throws Exception {
		if (orgArchitectureTeams == null || orgArchitectureTeams.isEmpty()) {
			throw new Exception("关联班组人员为空!");
		}
		List<String> ids = new ArrayList<>();
		ids.add(architectureId);
		deleteOrgArchitectureTeam(ids);
		for(OrgArchitectureTeam oat : orgArchitectureTeams) {
			if (StringUtils.isBlank(oat.getRelaId())) {
				oat.setRelaId(UUID.randomUUID().toString().replaceAll("-", ""));
				oat.setArchitectureId(architectureId);
			}
		}
		orgArchitectureDao.addOrgArchitectureTeams(orgArchitectureTeams);
		return orgArchitectureTeams;
	}

	@Override
	public List<OrgArchitectureCenter> addAndUpdateOrgArchitectureCenter(String architectureId, List<OrgArchitectureCenter> orgArchitectureCenters)
			throws Exception {
		if (orgArchitectureCenters == null || orgArchitectureCenters.isEmpty()) {
			throw new Exception("关联成本中心人员为空!");
		}
		List<String> ids = new ArrayList<>();
		ids.add(architectureId);
		deleteOrgArchitectureTeam(ids);
		for(OrgArchitectureCenter oac : orgArchitectureCenters) {
			if (StringUtils.isBlank(oac.getRelaId())) {
				oac.setRelaId(UUID.randomUUID().toString().replaceAll("-", ""));
				oac.setArchitectureId(architectureId);
			}
		}
		orgArchitectureDao.addOrgArchitectureCenters(orgArchitectureCenters);
		return orgArchitectureCenters;
	}

	@Override
	@Transactional
	public PageResultEntity deleteOrgArchitecture(List<String> ids) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (ids == null || ids.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("未选择删除条目!");
			return pageResultEntity;
		}
		List<OrgArchitecture> orgArchitectures = orgArchitectureDao.findOrgArchitectureByIds(ids);
		if (orgArchitectures !=null && !orgArchitectures.isEmpty()) {
			for(OrgArchitecture oa : orgArchitectures) {
				if ("01".equals(oa.getArchitectureType())) {
					List<String> a = new ArrayList<String>();
					a.add(oa.getArchitectureId());
					deleteRegistrationInformation(a);
				}
				if ("02".equals(oa.getArchitectureType())) {
					List<String> a = new ArrayList<String>();
					a.add(oa.getArchitectureId());
					deleteWindField(a);
				}
				if ("03".equals(oa.getArchitectureType())) {
					List<String> a = new ArrayList<String>();
					a.add(oa.getArchitectureId());
					deleteOrgArchitectureUser(a);
				}
				if ("04".equals(oa.getArchitectureType())) {
					List<String> a = new ArrayList<String>();
					a.add(oa.getArchitectureId());
					deleteOrgArchitectureTeam(a);
				}
				if ("05".equals(oa.getArchitectureType())) {
					List<String> a = new ArrayList<String>();
					a.add(oa.getArchitectureId());
					deleteOrgArchitectureCenter(a);
				}
			}
		}
		orgArchitectureDao.deleteOrgArchitecture(ids);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	@Override
	public Integer deleteRegistrationInformation(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteRegistrationInformation(ids);
		return 1;
	}

	@Override
	public Integer deleteWindField(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteWindField(ids);
		return 1;
	}

	@Override
	public Integer deleteOrgArchitectureUser(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteOrgArchitectureUser(ids);
		return 1;
	}

	@Override
	public Integer deleteOrgArchitectureTeam(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteOrgArchitectureTeam(ids);
		return 1;
	}

	@Override
	public Integer deleteOrgArchitectureCenter(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteOrgArchitectureCenter(ids);
		return 1;
	}

	@Override
	public List<OrgArchitecture> queryOrgArchitectureList(String architectureId, String architectureType,
			String architectureName, String superCompetentDepartment) {
		List<OrgArchitecture> list = orgArchitectureDao.queryOrgArchitectureList(architectureId, architectureType, architectureName, superCompetentDepartment);
//		if (list != null && !list.isEmpty()) {
//			
//		}
		return list;
	}

	@Override
	public void deleteRaleOrgArchitectureUser(String userId) throws Exception {
		if (StringUtils.isBlank(userId)) {
			throw new Exception("未选择删除条目");
		}
		orgArchitectureDao.deleteRaleOrgArchitectureUser(userId);
	}

	@Override
	public List<OrgArchitecture> findOrgArchitectureByFid(String architectureId) {
		return orgArchitectureDao.findOrgArchitectureByFid(architectureId);
	}

	@Override
	public String getwindId(String windId) {

		return orgArchitectureDao.getWindIdByCode(windId);
	}
	/**
	 * 根据风电场编号查询部门信息
	 * @param architectureCode
	 * @param architectureType
	 * @return
	 */
	@Override
	public List<OrgArchitecture> queryOrgArchitectureListByCode(String architectureCode, String architectureType) throws Exception {
		if (StringUtils.isBlank(architectureCode)) {
			throw new Exception("组织架构编号不能为空!");
		}
        OrgArchitecture orgArchitecture = orgArchitectureDao.findOrgArchitectureByCodeOrName(architectureCode, "", "02");
		if (orgArchitecture != null) {
		    return orgArchitectureDao.queryOrgArchitectureList("", architectureType, "",orgArchitecture.getArchitectureId());
        }
		return null;
	}
}
