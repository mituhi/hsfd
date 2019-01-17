package com.qz.zframe.common.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.common.dao.RoleDao;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.isc.enums.IscRoleTypeEnum;
import com.qz.zframe.isc.helper.IscHelper;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	/**
     * 新增角色信息
     *
     * @param role 角色对象
     * @return Role
     */
    @Override
    public PageResultEntity addRole(Role role) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        // 校验参数
    	if (StringUtils.isBlank(role.getRoleName())) {
    		pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("角色名称为空!");
			return pageResultEntity;
        }
        role.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
        role.setRoleType(getRoleType(role.getRoleType()));
        role.setCreateTime(new Date());
        role.setOrderNo(IscHelper.getOrderNo(role.getOrderNo()));
        roleDao.addRole(role);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }
    
    private static String getRoleType(String roleType) {
        if (StringUtils.isBlank(roleType)) {
            roleType = IscRoleTypeEnum.DEFAULT.getCode();
        }
        return roleType;
    }

    /**
     * 批量删除角色信息
     *
     * @param roleIds 角色id列表
     */
    @Override
    public PageResultEntity deleteRoles(List<String> roleIds) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        if (CollectionUtils.isNotEmpty(roleIds)) {
            // 如果角色下面包含下级，则不允许删除
            Role role;
            for (int i = 0, size = roleIds.size(); i < size; i++) {
                role = new Role();
                role.setRolePid(roleIds.get(i));
                List<Role> roles = findRoleList(role);
                if (CollectionUtils.isNotEmpty(roles)) {
                	pageResultEntity.setCode(ErrorCode.ERROR);
            		pageResultEntity.setMsg("包含下级角色，不能删除!");
            		return pageResultEntity;
                }
            }
            roleDao.deleteRoles(roleIds);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
        }
        pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("角色id为空!");
		return pageResultEntity;
    }
    
    /**
     * 批量获取角色信息
     *
     * @param role 角色对象
     * @return List
     */
    @Override
    public List<Role> findRoleList(Role role) {
        return roleDao.findRoleList(role);
    }

    /**
     * 修改角色信息
     *
     * @param role 角色对象
     */
    @Override
    public PageResultEntity updateRole(Role role) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        roleDao.updateRoleMsg(role);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
        
    }

    /**
     * 批量获取角色信息
     *
     * @param role 角色对象
     * @return List
     */
    @Override
    public PageResultEntity findRoleList(String roleCode, String roleName, Integer page, Integer size) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex = (page - 1) * size;
		//到第几条数据结束
		int lastIndex = page * size;
    	List<Role> roles = roleDao.findRolePage(roleCode, roleName, firstIndex, lastIndex);
    	if (roles == null || roles.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			Integer num = roleDao.findCountRole(roleCode, roleName);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(roles);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
    }

    /**
     * 批量获取用户的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    @Override
    public List<Role> findUserRoleList(String userId) {
        return roleDao.findUserRoleList(userId);
    }

    /**
     * 批量获取用户已分配的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    @Override
    public List<Role> findUserOwnedRoleList(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Collections.emptyList();
        }
        return findUserRoleList(userId);
    }

    /**
     * 批量获取用户未分配的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    @Override
    public List<Role> findUserNoOwnedRoleList(String userId) {
        if (StringUtils.isBlank(userId)) {
            return Collections.emptyList();
        }
        return roleDao.findUserNoOwnedRoleList(userId);
    }

    /**
     * 清空用户角色
     *
     * @param userId 用户id
     */
    @Override
    public PageResultEntity clearUserRole(String userId) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        if (StringUtils.isBlank(userId)) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("用户id为空!");
			return pageResultEntity;
        }
        roleDao.clearUserRole(userId);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }

    /**
     * 根据id查询角色信息
     * @param roleId
     * @return
     * @throws Exception 
     */
	@Override
	public Role queryRoleInfo(String roleId) throws Exception {
		if (StringUtils.isBlank(roleId)) {
			throw new Exception("请选择角色");
		}
		return roleDao.queryRoleInfo(roleId);
	}
}
