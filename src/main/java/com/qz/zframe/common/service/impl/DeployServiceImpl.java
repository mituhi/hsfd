package com.qz.zframe.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.DeployDao;
import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.entity.DeployRole;
import com.qz.zframe.common.service.DeployService;
import com.qz.zframe.isc.domain.IscRole;

@Service
public class DeployServiceImpl implements DeployService {
	
	@Autowired
	private DeployDao deployDao;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Override
	public List<DeployMain> queryDeployMain(String mainDeployName) {
		List<DeployMain> list = null;
		if (StringUtils.isBlank(mainDeployName)) {
			list = deployDao.findAllDeploy();
		}else {
			list = deployDao.findDeployMainByName("%"+mainDeployName+"%");
		}
		if (list != null && !list.isEmpty()) {
			for(DeployMain dm : list) {
				List<Deploy> deploys = deployDao.findDeployByMainId(dm.getMainId());
				dm.setDeploys(deploys);
			}
		}
		return list;
	}

	@Override
	public DeployMain queryDeployMainById(String id) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception("请选择流程!");
		}
		return deployDao.queryDeployMainById(id);
	}

	@Override
	public DeployMain addAndUpdateDeployMain(DeployMain deployMain) throws Exception {
		if (deployMain == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(deployMain.getMainCode())) {
			throw new Exception("流程编号为空!");
		}
		if (StringUtils.isBlank(deployMain.getMainDeployName())) {
			throw new Exception("流程名称为空!");
		}
		if (StringUtils.isBlank(deployMain.getMainId())) {
			DeployMain dm = deployDao.findDeployMainByCodeOrName(deployMain.getMainCode(), deployMain.getMainDeployName());
			if (dm != null) {
				throw new Exception("流程编号或流程名称已存在!");
			}
			deployMain.setMainId(UUID.randomUUID().toString());
			deployDao.addDeployMain(deployMain);
		}else {
			deployDao.updateDeployMain(deployMain);
		}
		return deployMain;
	}

	@Override
	public Deploy queryDeployById(String deployId) throws Exception {
		if (StringUtils.isBlank(deployId)) {
			throw new Exception("请选择流程步骤!");
		}
		Deploy deploy = deployDao.queryDeployById(deployId);
		if (deploy != null) {
			List<IscRole> roles = deployDao.findRoleByDeployId(deployId);
			deploy.setRoles(roles);
		}
		return deploy;
	}

	@Override
	@Transactional
	public Deploy addAndUpdateDeploy(Deploy deploy) throws Exception {
		if (deploy == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(deploy.getDeployName())) {
			throw new Exception("流程编号为空!");
		}
		if (StringUtils.isBlank(deploy.getDeployName())) {
			throw new Exception("流程名称为空!");
		}
		if (StringUtils.isBlank(deploy.getDeployId())) {
			Deploy d = deployDao.findDeployByDeployName(deploy.getDeployName());
			if (d != null) {
				throw new Exception("流程步骤名称已存在!");
			}
			deploy.setDeployId(UUID.randomUUID().toString());
			deploy.setCreater(currentUserService.getId());
			deploy.setCreateTime(new Date());
			deployDao.addDeploy(deploy);
		}else {
			deployDao.updateDeploy(deploy);
			deployDao.deleteDeployRole(deploy.getDeployId());
		}
		List<String> roleIds = deploy.getRoleIds();
		if (roleIds !=null && !roleIds.isEmpty()) {
			List<DeployRole> deployRoles = new ArrayList<DeployRole>();
			for(String roleId : roleIds) {
				DeployRole deployRole = new DeployRole();
				deployRole.setRelaId(UUID.randomUUID().toString());
				deployRole.setDeployId(deploy.getDeployId());
				deployRole.setRoleId(roleId);
				deployRoles.add(deployRole);
			}
			deployDao.addDeployRole(deployRoles);
		}
		return deploy;
	}

	@Override
	@Transactional
	public Integer deleteDeploy(List<String> deployIds) throws Exception {
		if (deployIds == null ) {
			throw new Exception("请选择需要删除的流程步骤");
		}
		deployDao.deleteDeploy(deployIds);
		deployDao.deleteDeployRoles(deployIds);
		return 1;
	}

}
