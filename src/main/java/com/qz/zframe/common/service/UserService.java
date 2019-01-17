package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.isc.domain.IscPwdUpdateRequest;

public interface UserService {

	/**
	 * 条件查询用户信息
	 * @param architectureId
	 * @param roleId
	 * @param userMsg
	 * @param roleCode 
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity queryUserInfo(String architectureId, String roleId, String userMsg, String roleCode, Integer page, Integer size) throws Exception;

	/**
     * 获取用户信息
     * <p>根据用户id或用户账号获取用户信息，两个参数传其一即可</p>
     *
     * @param userId      用户id
     * @param userAccount 用户账号
     * @return IscUser
	 * @throws Exception 
     */
    UserDto queryUserInfo(String userId, String userAccount) throws Exception;
    
    /**
     * 批量获取用户信息
     *
     * @param user 用户对象
     * @return List
     * @throws Exception 
     */
    List<UserDto> listUser(UserDto user) throws Exception;
    
    /**
     * 新增用户信息
     *
     * @param user 用户对象
     * @return IscUser
     * @throws Exception 
     */
    PageResultEntity addUser(UserDto user) throws Exception;
    
    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @throws Exception 
     */
    PageResultEntity updateIscUser(UserDto user) throws Exception;

    
    /**
     * 批量删除用户信息
     *
     * @param userIds 用户id列表
     */
	PageResultEntity deleteIscUser(List<String> userIds);
	
	/**
     * 批量获取角色下的用户信息
     *
     * @param roleId 角色id
     * @return List
	 * @throws Exception 
     */
    List<UserDto> listRoleUser(String roleId) throws Exception;
    
    /**
     * 关联角色用户
     *
     * @param roleId 角色id
     * @param userId 用户id
     */
    void relaRoleUser(String roleId, String userId);

    /**
     * 取消关联角色用户
     *
     * @param roleId 角色id
     * @param userId 用户id
     * @return 
     */
    PageResultEntity deleteRelaRoleUser(String roleId, String userId);
    
    /**
     * 修改密码
     *
     * @param pwdUpdateRequest 密码修改请求对象
     * @return 
     * @throws Exception 
     */
    PageResultEntity updatePassword(IscPwdUpdateRequest pwdUpdateRequest) throws Exception;
	
	/**
     * 重置密码
     *
     * @param userId 用户id
	 * @return 
	 * @throws Exception 
     */
    PageResultEntity resetPwd(String userId) throws Exception;

    /**
     * 关联部门用户
     *
     * @param architectureId 部门id
     * @param userId 用户id
     */
	void relaArchitectureUser(String architectureId, String userId);

	/**
     * 取消关联部门用户
     *
     * @param architectureId 部门id
     * @param userId 用户id
	 * @return 
     */
	PageResultEntity deleteRelaArchitectureUser(String architectureId, String userId);

	/**
	 * 根据角色编码获取用户信息
	 * @param roleCodes
	 * @return
	 * @throws Exception 
	 */
	List<UserDto> findUserInfoByRoleCode(List<String> roleCodes) throws Exception;

	/**
	 * 根据部门id获取用户信息
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
    List<UserDto> queryUserInfoByDeptId(String deptId) throws Exception;
}
