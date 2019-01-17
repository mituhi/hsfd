package com.qz.zframe.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.entity.UserDto;

@Mapper
public interface UserDao {

	/**
	 * 分页查询用户信息
	 * @param architectureId
	 * @param roleId
	 * @param userMsg
	 * @param roleCode 
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	List<UserDto> findUserInfo(@Param("architectureId") String architectureId, @Param("roleId") String roleId, 
			@Param("userMsg") String userMsg, @Param("roleCode") String roleCode, @Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

	/**
	 * 查询用户数量
	 * @param architectureId
	 * @param roleId
	 * @param userMsg
	 * @return
	 */
	Integer findUserInfoNum(@Param("architectureId") String architectureId, @Param("roleId") String roleId, 
			@Param("userMsg") String userMsg, @Param("roleCode") String roleCode);

	/**
	 * 批量获取用户信息
	 * @param user
	 * @return
	 */
	List<UserDto> findUserList(UserDto user);

	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(UserDto user);

	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateIscUser(UserDto user);

	/**
	 * 批量删除用户信息
	 * @param userIds
	 */
	void deleteIscUsers(List<String> userIds);

	/**
	 * 批量删除部门用户关系
	 * @param userIds
	 */
	void deleteOrgUserRelaInBatch(List<String> userIds);

	/**
	 * 批量删除角色用户关
	 * @param userIds
	 */
	void deleteRoleUserRelaInBatch(List<String> userIds);

	/**
	 * 批量删除班组用户关系
	 * @param userIds
	 */
	void deleteTeamUserRelaInBatch(List<String> userIds);

	/**
	 * 批量获取角色下的用户信息
	 * @param roleId
	 * @return
	 */
	List<UserDto> findRoleUserList(@Param("roleId") String roleId);

	/**
	 * 关联角色用户
	 * @param params
	 */
	void addRoleUserRela(Map<String, Object> params);

	/**
	 * 删除角色用户关系
	 * @param params
	 */
	void deleteRelaRoleUser(Map<String, Object> params);

	/**
	 * 修改密码
	 * @param params
	 */
	void updatePassword(Map<String, Object> params);

	/**
	 * 新增部门用户关系
	 * @param params
	 */
	void relaArchitectureUser(Map<String, Object> params);

	/**
     * 取消关联部门用户
     * @param params
     */
	void deleteRelaArchitectureUser(Map<String, Object> params);

	/**
	 * 根据角色编码获取用户信息
	 * @param roleCodes
	 * @return
	 */
	List<UserDto> findUserInfoByRoleCode(List<String> roleCodes);

	/**
	 * 根据部门id获取用户信息
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
    List<UserDto> queryUserInfoByDeptId(@Param("deptId") String deptId);
}
