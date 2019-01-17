package com.qz.zframe.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.authentication.UserPasswordService;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.dao.UserDao;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.service.UserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.isc.IscException;
import com.qz.zframe.isc.domain.IscPwdUpdateRequest;
import com.qz.zframe.isc.helper.IscHelper;
import com.qz.zframe.isc.helper.IscUserHelper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private UserPasswordService userPasswordService;
	
	@Autowired
	private DataDictService dataDictService;
	
	@Autowired
	private OrgArchitectureService orgArchitectureService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public PageResultEntity queryUserInfo(String architectureId, String roleId, String userMsg, String roleCode, Integer page,
			Integer size) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex = (page - 1) * size;
		//到第几条数据结束
		int lastIndex = page * size;
		
		List<UserDto> list = userDao.findUserInfo(architectureId, roleId, userMsg, roleCode, firstIndex, lastIndex);
		if (list == null || list.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			list = makeCodeType(list);
			Integer num = userDao.findUserInfoNum(architectureId, roleId, userMsg, roleCode);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}
	
	@Override
	@CodeConvert({
		@CodeType(codeType="USER_SEX", nameField="userSex", titleField="userSexText"),
		@CodeType(codeType="USER_STATUS", nameField="userStatus", titleField="userStatusText")
	})
	public UserDto queryUserInfo(String userId, String userAccount) throws Exception {
		if (StringUtils.isBlank(userId) && StringUtils.isBlank(userAccount)) {
            throw new IscException("用户ID和用户账号参数必须传一个");
        }

        UserDto user = new UserDto();
        user.setUserId(userId);
        user.setUserAccount(userAccount);

        List<UserDto> users = listUser(user);
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }
        return null;
	}
	
	/**
     * 批量获取用户信息
     *
     * @param user 用户对象
     * @return List
	 * @throws Exception 
     */
    @Override
    public List<UserDto> listUser(UserDto user) throws Exception {
        return makeCodeType(userDao.findUserList(user));
    }

	@Override
	@Transactional
	public PageResultEntity addUser(UserDto user) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		// 校验用户信息
		if (StringUtils.isBlank(user.getUserAccount())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("用户账号为空!");
			return pageResultEntity;
        }
		
		// 根据账号获取用户信息，判断账号是否存在
        UserDto userTemp1 = queryUserInfo(user.getUserId(), null);
        if (userTemp1 != null) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("用户编号已存在!");
			return pageResultEntity;
        }

        // 根据账号获取用户信息，判断账号是否存在
        UserDto userTemp = queryUserInfo(null, user.getUserAccount());
        if (userTemp != null) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("账号已存在!");
			return pageResultEntity;
        }

        // 校验手机号是否存在
        checkMobile(user.getMobile());

//        user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setUserPassword(getPwd(user.getUserPassword()));
        user.setUserSex(IscUserHelper.getUserSex(user.getUserSex()));
        user.setUserStatus(IscUserHelper.getUserStatus(user.getUserStatus()));
        user.setCreateTime(new Date());
        user.setOrderNo(IscHelper.getOrderNo(user.getOrderNo()));
        user.setAdmin(IscUserHelper.getAdmin(user.getAdmin()));

        // 新增用户信息
        userDao.addUser(user);
        if (StringUtils.isNotBlank(user.getArchitectureId())) {
        	relaArchitectureUser(user.getArchitectureId(), user.getUserId());
		}
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
			for(String roleId : user.getRoles()) {
				relaRoleUser(roleId, user.getUserId());
			}
		}
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}
	
	/**
     * 校验手机号码是否存在
     *
     * @param mobile
	 * @throws Exception 
     */
    private void checkMobile(String mobile) throws Exception {
        if (StringUtils.isNotBlank(mobile)) {
            UserDto user = new UserDto();
            user.setMobile(mobile);
            List<UserDto> users = listUser(user);
            if (CollectionUtils.isNotEmpty(users)) {
                throw new IscException("该手机号码已绑定");
            }
        }
    }
    
    /**
     * 获取密码
     *
     * @param pwd 密码
     * @return String
     */
    private String getPwd(String pwd) {
        // 为空，则设置为默认密码
        if (StringUtils.isBlank(pwd)) {
            pwd = userPasswordService.defaultPassword();
        } else {
            // 不为空，则加密处理
            pwd = userPasswordService.encryptPassword(pwd);
        }
        return pwd;
    }

	/**
     * 修改用户信息
     * <p>
     * 根据用户id修改
     * <p>
     * 账号和手机号必须校验唯一性
     *
     * @param user 用户对象
	 * @throws Exception 
     */
    @Override
    @Transactional
    public PageResultEntity updateIscUser(UserDto user) throws Exception {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        // 校验用户信息
    	if (StringUtils.isBlank(user.getUserAccount())) {
    		pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("用户账号为空!");
			return pageResultEntity;
        }
        if (isExistUserAccountExcludeSelf(user.getUserId(), user.getUserAccount())) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("账号 " + user.getUserAccount() + " 已存在！");
			return pageResultEntity;
        }
        if (isExistMobileExcludeSelf(user.getUserId(), user.getMobile())) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("手机号 " + user.getMobile() + " 已绑定其他账号！");
			return pageResultEntity;
        }
        if (StringUtils.isNotBlank(user.getArchitectureId())) {
        	orgArchitectureService.deleteRaleOrgArchitectureUser(user.getUserId());
        	relaArchitectureUser(user.getArchitectureId(), user.getUserId());
		}
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
        	roleService.clearUserRole(user.getUserId());
			for(String roleId : user.getRoles()) {
				relaRoleUser(roleId, user.getUserId());
			}
		}
        userDao.updateIscUser(user);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }
	
	/**
     * 账号除自己以外是否存在
     * <p>
     * 根据账号查询用户，如果用户数量为1，则判断是否是自己
     *
     * @param userId      用户id
     * @param userAccount 用户账号
     * @return boolean，存在：true，不存在：false
	 * @throws Exception 
     */
    private boolean isExistUserAccountExcludeSelf(String userId, String userAccount) throws Exception {
        if (StringUtils.isNotBlank(userAccount)) {
            UserDto user = new UserDto();
            user.setUserAccount(userAccount);
            List<UserDto> users = listUser(user);
            return isExistUserIdExcludeSelf(userId, users);
        }
        return false;
    }
    
    /**
     * 判断除了自己以外userId是否存在于用户列表中
     * <p>
     * 用户列表不空，则不存在
     * 用户列表等于1，则根据userId判断是否为自己，如果是自己也表示不存在
     *
     * @param userId 用户id
     * @param users  用户列表
     * @return boolean，存在：true，不存在：false
     */
    private boolean isExistUserIdExcludeSelf(String userId, List<UserDto> users) {
        if (CollectionUtils.isNotEmpty(users)) {
            if (users.size() == 1) {
                if (userId.equals(users.get(0).getUserId())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * 手机号除了自己以外是否存在
     * <p>
     * 根据手机号查询用户，如果用户数量为1，则根据用户id判断是否为自己
     *
     * @param userId 用户id
     * @param mobile 手机号
     * @return boolean，存在：true，不存在：false
     * @throws Exception 
     */
    private boolean isExistMobileExcludeSelf(String userId, String mobile) throws Exception {
        if (StringUtils.isNotBlank(mobile)) {
            UserDto user = new UserDto();
            user.setMobile(mobile);
            List<UserDto> users = listUser(user);
            return isExistUserIdExcludeSelf(userId, users);
        }
        return false;
    }

    /**
     * 批量删除用户信息
     *
     * @param userIds 用户id列表
     */
	@Override
	public PageResultEntity deleteIscUser(List<String> userIds) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (CollectionUtils.isNotEmpty(userIds)) {
			userDao.deleteIscUsers(userIds);
            // 删除用户关联表相关信息
            removeUserRela(userIds);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
        }
		pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("用户id为空!");
		return pageResultEntity;
	}
	
	/**
     * 删除用户关联表相关信息
     * <p>
     * 1.删除组织用户关系
     * 2.删除角色用户关系
     * </p>
     *
     * @param userIds 用户id列表
     */
    private void removeUserRela(List<String> userIds) {
        // 批量删除部门用户关系
    	userDao.deleteOrgUserRelaInBatch(userIds);
        // 批量删除角色用户关系
    	userDao.deleteRoleUserRelaInBatch(userIds);
    	// 批量删除班组用户关系
    	userDao.deleteTeamUserRelaInBatch(userIds);
    }

    /**
     * 批量获取角色下的用户信息
     *
     * @param roleId 角色id
     * @return List
     * @throws Exception 
     */
	@Override
	public List<UserDto> listRoleUser(String roleId) throws Exception {
		return makeCodeType(userDao.findRoleUserList(roleId));
	}

	@Override
	public void relaRoleUser(String roleId, String userId) {
		if (StringUtils.isNotBlank(roleId) && StringUtils.isNotBlank(userId)) {
            // 新增角色用户关系
            Map<String, Object> params = new HashMap<>(3);
            params.put("relaId", UUID.randomUUID().toString().replaceAll("-", ""));
            params.put("roleId", roleId);
            params.put("userId", userId);
            // 新增角色用户关系
            userDao.addRoleUserRela(params);
        }
	}

	@Override
	public PageResultEntity deleteRelaRoleUser(String roleId, String userId) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (StringUtils.isNotBlank(roleId) && StringUtils.isNotBlank(userId)) {
            Map<String, Object> params = new HashMap<>(2);
            params.put("roleId", roleId);
            params.put("userId", userId);
            // 删除角色用户关系
            userDao.deleteRelaRoleUser(params);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
    		return pageResultEntity;
        }
		pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("用户id或角色id为空!");
		return pageResultEntity;
	}

	@Override
	public PageResultEntity updatePassword(IscPwdUpdateRequest pwdUpdateRequest) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		// 校验密码更新请求对象
        IscUserHelper.checkPwdUpdateRequest(pwdUpdateRequest);
        // 根据账号获取用户信息
        UserDto user = queryUserInfo(null, pwdUpdateRequest.getUserAccount());
        if (!userPasswordService.matchPassword(pwdUpdateRequest.getOldPwd(), user.getUserPassword())) {
            pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("旧密码不正确!");
			return pageResultEntity;
        }
        // 加密
        String newPwd = userPasswordService.encryptPassword(pwdUpdateRequest.getNewPwd());
        Map<String, Object> params = new HashMap<>(2);
        params.put("userAccount", pwdUpdateRequest.getUserAccount());
        params.put("userPassword", newPwd);
        userDao.updatePassword(params);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	@Override
	public PageResultEntity resetPwd(String userId) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		UserDto user = new UserDto();
        user.setUserId(userId);
        user.setUserPassword(userPasswordService.defaultPassword());
        updateIscUser(user);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}

	/**
     * 关联部门用户
     *
     * @param architectureId 部门id
     * @param userId 用户id
     */
	@Override
	public void relaArchitectureUser(String architectureId, String userId) {
		if (StringUtils.isNotBlank(architectureId) && StringUtils.isNotBlank(userId)) {
            // 新增部门用户关系
            Map<String, Object> params = new HashMap<>(3);
            params.put("relaId", UUID.randomUUID().toString().replaceAll("-", ""));
            params.put("architectureId", architectureId);
            params.put("userId", userId);
            // 新增部门用户关系
            userDao.relaArchitectureUser(params);
        }
	}
	
	/**
     * 取消关联部门用户
     *
     * @param architectureId 部门id
     * @param userId 用户id
     */
	@Override
	public PageResultEntity deleteRelaArchitectureUser(String architectureId, String userId) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (StringUtils.isNotBlank(architectureId) && StringUtils.isNotBlank(userId)) {
            Map<String, Object> params = new HashMap<>(2);
            params.put("architectureId", architectureId);
            params.put("userId", userId);
            // 删除部门用户关系
            userDao.deleteRelaArchitectureUser(params);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
    		return pageResultEntity;
        }
		pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("组织机构id或用户id为空!");
		return pageResultEntity;
	}
	
	private List<UserDto> makeCodeType(List<UserDto> list) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("USER_SEX");
		codeTypes.add("USER_STATUS");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
			for(UserDto u : list) {
				for(DataDict d : dataDicts) {
					if ("USER_SEX".equals(d.getCodeTypeName()) && u.getUserSex().equals(d.getName())) {
						u.setUserSexText(d.getTitle());
					}
					if ("USER_STATUS".equals(d.getCodeTypeName()) && u.getUserStatus().equals(d.getName())) {
						u.setUserStatusText(d.getTitle());
					}
				}
			}
		}
		return list;
	}

	/**
	 * 根据角色编码获取用户信息
	 * @param roleCodes
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<UserDto> findUserInfoByRoleCode(List<String> roleCodes) throws Exception {
		if (roleCodes == null || roleCodes.isEmpty()) {
			throw new Exception("角色编码不能为空");
		}
		return userDao.findUserInfoByRoleCode(roleCodes);
	}

	/**
	 * 根据部门id获取用户信息
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<UserDto> queryUserInfoByDeptId(String deptId) throws Exception {
		if (StringUtils.isBlank(deptId)){
			throw new Exception("部门id不能为空!");
		}
		return userDao.queryUserInfoByDeptId(deptId);
	}
}
