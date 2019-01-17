package com.qz.zframe.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.DeployDao;
import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.entity.DeployRole;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.DeployService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;

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
		DeployMain deployMain = deployDao.queryDeployMainById(id);
		List<Deploy> deploys = deployDao.findDeployByMainId(deployMain.getMainId());
		if (CollectionUtils.isNotEmpty(deploys)) {
			deployMain.setDeploys(deploys);
			for (Deploy deploy:deploys) {
				List<Role> roles = deployDao.findRoleByDeployId(deploy.getDeployId());
				if (CollectionUtils.isNotEmpty(roles)) {
					deploy.setRoles(roles);
				}
			}
		}
		return deployMain;
	}

	@Override
	public PageResultEntity addAndUpdateDeployMain(DeployMain deployMain) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (deployMain == null) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("对象为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deployMain.getMainCode())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("流程编号为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deployMain.getMainDeployName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("流程名称为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deployMain.getMainId())) {
			DeployMain dm = deployDao.findDeployMainByCodeOrName(deployMain.getMainCode(), deployMain.getMainDeployName());
			if (dm != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("流程编号或流程名称已存在!");
				return pageResultEntity;
			}
			deployMain.setMainId(UUID.randomUUID().toString().replaceAll("-", ""));
			deployDao.addDeployMain(deployMain);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}else {
			deployDao.updateDeployMain(deployMain);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}
	}

	@Override
	public Deploy queryDeployById(String deployId) throws Exception {
		if (StringUtils.isBlank(deployId)) {
			throw new Exception("请选择流程步骤!");
		}
		Deploy deploy = deployDao.queryDeployById(deployId);
		if (deploy != null) {
			List<Role> roles = deployDao.findRoleByDeployId(deployId);
			deploy.setRoles(roles);
		}
		return deploy;
	}

	@Override
	@Transactional
	public PageResultEntity addAndUpdateDeploy(Deploy deploy) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (deploy == null) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("对象为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deploy.getDeployName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("流程编号为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deploy.getDeployName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("流程名称为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(deploy.getDeployId())) {
			Deploy d = deployDao.findDeployByDeployName(deploy.getDeployName());
			if (d != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("流程步骤名称已存在!");
				return pageResultEntity;
			}
			deploy.setDeployId(UUID.randomUUID().toString().replaceAll("-", ""));
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
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	@Override
	@Transactional
	public PageResultEntity deleteDeploy(List<String> deployIds) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (deployIds == null ) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("请选择需要删除的流程步骤!");
			return pageResultEntity;
		}
		deployDao.deleteDeploy(deployIds);
		deployDao.deleteDeployRoles(deployIds);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	/**
	 * 根据流程编号查询流程信息
	 * @param mainCode
	 * @return
	 */
	@Override
	public DeployMain queryDeployMainByCode(String mainCode) throws Exception {
		if (StringUtils.isBlank(mainCode)) {
			throw new Exception("流程编号不能为空!");
		}
		DeployMain deployMain = deployDao.queryDeployMainByCode(mainCode);
		return deployMain;
	}
}
