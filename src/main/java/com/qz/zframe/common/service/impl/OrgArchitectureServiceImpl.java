package com.qz.zframe.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.common.dao.OrgArchitectureDao;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.OrgArchitectureTeam;
import com.qz.zframe.common.entity.OrgArchitectureUser;
import com.qz.zframe.common.entity.RegistrationInformation;
import com.qz.zframe.common.entity.WindField;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;

@Service
public class OrgArchitectureServiceImpl implements OrgArchitectureService {
	
	@Autowired
	private OrgArchitectureDao orgArchitectureDao;
	
	@Override
	public PageResultEntity queryOrgArchitecture(String architectureType, String architectureName,
			String isDisable, Integer page, Integer size) {
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
			Integer num = orgArchitectureDao.findOrgArchitectureNum(architectureType, architectureName, isDisable);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	@Override
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
		}
		return orgArchitecture;
	}

	@Override
	@Transactional
	public OrgArchitecture addAndUpdateOrgArchitecture(OrgArchitecture orgArchitecture) throws Exception {
		if (orgArchitecture == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureType())) {
			throw new Exception("组织类型为空!");
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureCode())) {
			throw new Exception("组织架构编号为空!");
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureName())) {
			throw new Exception("组织架构名称为空!");
		}
		if (StringUtils.isBlank(orgArchitecture.getArchitectureId())) {
			OrgArchitecture oa = orgArchitectureDao.findOrgArchitectureByCodeOrName(orgArchitecture.getArchitectureCode(), orgArchitecture.getArchitectureName());
			if (oa != null) {
				throw new Exception("编码或名称已存在!");
			}
			orgArchitecture.setArchitectureId(UUID.randomUUID().toString());
			orgArchitectureDao.addOrgArchitecture(orgArchitecture);
			if ("01".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateRegistrationInformation(orgArchitecture.getArchitectureId(), orgArchitecture.getRegistrationInformation());
			}
			if ("02".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateWindField(orgArchitecture.getArchitectureId(), orgArchitecture.getWindField());
			}
			if ("03".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateOrgArchitectureUser(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureUsers());
			}
			if ("04".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateOrgArchitectureTeam(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureTeams());
			}
		}else {
			orgArchitectureDao.updateOrgArchitecture(orgArchitecture);
			if ("01".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateRegistrationInformation(orgArchitecture.getArchitectureId(), orgArchitecture.getRegistrationInformation());
			}
			if ("02".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateWindField(orgArchitecture.getArchitectureId(), orgArchitecture.getWindField());
			}
			if ("03".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateOrgArchitectureUser(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureUsers());
			}
			if ("04".equals(orgArchitecture.getArchitectureType())) {
				addAndUpdateOrgArchitectureTeam(orgArchitecture.getArchitectureId(), orgArchitecture.getOrgArchitectureTeams());
			}
		}
		return orgArchitecture;
	}

	@Override
	public RegistrationInformation addAndUpdateRegistrationInformation(String architectureId, RegistrationInformation registrationInformation)
			throws Exception {
		if (registrationInformation == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(registrationInformation.getRegistrationId())) {
			registrationInformation.setRegistrationId(UUID.randomUUID().toString());
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
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(windField.getWindId())) {
			windField.setWindId(UUID.randomUUID().toString());
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
			throw new Exception("对象为空!");
		}
		List<String> ids = new ArrayList<>();
		ids.add(architectureId);
		deleteOrgArchitectureUser(ids);
		for(OrgArchitectureUser oau : orgArchitectureUsers) {
			if (StringUtils.isBlank(oau.getRelaId())) {
				oau.setRelaId(UUID.randomUUID().toString());
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
			throw new Exception("对象为空!");
		}
		List<String> ids = new ArrayList<>();
		ids.add(architectureId);
		deleteOrgArchitectureTeam(ids);
		for(OrgArchitectureTeam oat : orgArchitectureTeams) {
			if (StringUtils.isBlank(oat.getRelaId())) {
				oat.setRelaId(UUID.randomUUID().toString());
				oat.setArchitectureId(architectureId);
			}
		}
		orgArchitectureDao.addOrgArchitectureTeams(orgArchitectureTeams);
		return orgArchitectureTeams;
	}
	
	@Override
	@Transactional
	public Integer deleteOrgArchitecture(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("未选择删除条目");
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
			}
		}
		orgArchitectureDao.deleteOrgArchitecture(ids);
		return 1;
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

}
