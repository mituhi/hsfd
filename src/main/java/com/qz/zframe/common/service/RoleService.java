package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.util.PageResultEntity;

public interface RoleService {
	
	/**
     * 新增角色信息
     *
     * @param role 角色对象
     * @return Role
     */
    PageResultEntity addRole(Role role);

    /**
     * 批量删除角色信息
     *
     * @param roleIds 角色id列表
     * @return 
     */
    PageResultEntity deleteRoles(List<String> roleIds);

    /**
     * 修改角色信息
     *
     * @param role 角色对象
     * @return 
     */
    PageResultEntity updateRole(Role role);

    /**
     * 批量获取角色信息
     * @param role
     * @return
     */
    List<Role> findRoleList(Role role);
    
    /**
     * 获取角色信息
     * @param roleCode
     * @param roleName
     * @param page
     * @param size
     * @return
     */
    PageResultEntity findRoleList(String roleCode, String roleName, Integer page, Integer size);

    /**
     * 批量获取用户的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    List<Role> findUserRoleList(String userId);

    /**
     * 批量获取用户已分配的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    List<Role> findUserOwnedRoleList(String userId);

    /**
     * 获取用户未分配的角色信息
     *
     * @param userId 用户id
     * @return List
     */
    List<Role> findUserNoOwnedRoleList(String userId);

    /**
     * 清空用户角色
     *
     * @param userId 用户id
     * @return 
     */
    PageResultEntity clearUserRole(String userId);

    /**
     * 根据id查询角色信息
     * @param roleId
     * @return
     * @throws Exception 
     */
	Role queryRoleInfo(String roleId) throws Exception;

}
