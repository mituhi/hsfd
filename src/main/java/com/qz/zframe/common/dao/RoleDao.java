package com.qz.zframe.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.entity.Role;

@Mapper
public interface RoleDao {

	/**
	 * 新增角色信息
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * 批量删除角色信息
	 * @param roleIds
	 */
	void deleteRoles(List<String> roleIds);

	/**
	 * 修改角色信息
	 * @param role
	 */
	void updateRoleMsg(Role role);

	/**
	 * 获取角色信息
	 * @param role
	 * @return
	 */
	List<Role> findRolePage(@Param("roleCode") String roleCode, @Param("roleName") String roleName, 
			@Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

	/**
	 * 批量获取用户的角色信息
	 * @param role
	 * @return
	 */
	List<Role> findUserRoleList(@Param("userId") String userId);

	/**
	 * 批量获取用户未分配的角色信息
	 * @param userId
	 * @return
	 */
	List<Role> findUserNoOwnedRoleList(@Param("userId") String userId);

	/**
	 * 清空用户角色
	 * @param userId
	 */
	void clearUserRole(@Param("userId") String userId);

	/**
	 * 获取角色数量
	 * @param roleCode
	 * @param roleName
	 * @return
	 */
	Integer findCountRole(@Param("roleCode") String roleCode, @Param("roleName") String roleName);

	/**
	 * 批量获取角色信息
	 * @param role
	 * @return
	 */
	List<Role> findRoleList(Role role);

	/**
	 * 根据id查询角色信息
	 * @param roleId
	 * @return
	 */
	Role queryRoleInfo(@Param("roleId") String roleId);

}
