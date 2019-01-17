package com.qz.zframe.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.common.service.UserService;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.isc.domain.IscPwdUpdateRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/user")
@Api(tags = { "api-common-user" }, description = "系统管理-用户管理")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "条件查询用户信息", notes = "条件查询用户信息")
	@RequestMapping(value = "queryUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryUser(
			@RequestParam(required = false)
			@ApiParam(name="architectureId",value="部门id",required=false) String architectureId,
			@RequestParam(required = false)
			@ApiParam(name="roleId",value="角色id",required=false) String roleId,
			@RequestParam(required = false)
			@ApiParam(name="roleCode",value="角色编号",required=false) String roleCode,
			@RequestParam(required = false)
			@ApiParam(name="userMsg",value="用户账号或姓名",required=false) String userMsg,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) throws Exception {
		logger.info("===== 条件查询用户信息 UserController.queryUser ===== "
				+ "architectureId:"+architectureId+"roleId:"+roleId+"userMsg:"+userMsg);
		return userService.queryUserInfo(architectureId, roleId, userMsg, roleCode, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据id或账号查询用户信息", notes = "根据id或账号查询用户信息")
	@RequestMapping(value = "queryUserInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDto> queryUserInfo(
			@RequestParam(required = false)
			@ApiParam(name="userId",value="用户id",required=false)String userId,
			@RequestParam(required = false)
			@ApiParam(name="userAccount",value="用户账号",required=false)String userAccount) throws Exception {
		logger.info("===== 根据id或账号查询用户信息 UserController.queryUserInfo ===== userId:"+userId+"userAccount:"+userAccount);
		UserDto iscUser = userService.queryUserInfo(userId, userAccount);
		return new ResponseEntity<UserDto>(iscUser, HttpStatus.OK);
	}
	
	@ApiOperation(value = "批量获取用户信息", notes = "批量获取用户信息")
	@RequestMapping(value = "listUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserDto>> listUser(@RequestBody UserDto iscUser) throws Exception {
		logger.info("===== 批量获取用户信息 UserController.listUser ===== iscUser:"+iscUser);
		List<UserDto> iscUsers = userService.listUser(iscUser);
		return new ResponseEntity<List<UserDto>>(iscUsers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "addIscUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addIscUser(@RequestBody UserDto iscUser)
			throws Exception {
		logger.info("===== 新增用户 UserController.addIscUser ===== iscUser:"+iscUser);
		return userService.addUser(iscUser);
	}
	
	@ApiOperation(value = "修改用户信息", notes = "修改用户信息")
	@RequestMapping(value = "updateIscUser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateIscUser(@RequestBody UserDto iscUser)
			throws Exception {
		logger.info("===== 修改用户信息 UserController.updateIscUser ===== iscUser:"+iscUser);
		return userService.updateIscUser(iscUser);
	}
	
	@ApiOperation(value = "删除用户信息", notes = "删除用户信息")
	@RequestMapping(value = "deleteIscUser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteIscUser(@RequestParam(required = true) List<String> userIds) throws Exception {
		logger.info("===== 删除用户信息 UserController.deleteIscUser ===== userIds:"+userIds);
		return userService.deleteIscUser(userIds);
	}
	
	@ApiOperation(value = "根据角色id获取用户信息", notes = "根据角色id获取用户信息")
	@RequestMapping(value = "queryUserInfoByRoleId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserDto>> queryUserInfoByRoleId(
			@RequestParam(required = false)
			@ApiParam(name="roleId",value="角色id",required=true)String roleId) throws Exception {
		logger.info("===== 根据角色id获取用户信息 UserController.queryUserInfoByRoleId ===== roleId:"+roleId);
		List<UserDto> iscUsers = userService.listRoleUser(roleId);
		return new ResponseEntity<List<UserDto>>(iscUsers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "根据角色编码获取用户信息", notes = "根据角色编码获取用户信息")
	@RequestMapping(value = "queryUserInfoByRoleCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserDto>> queryUserInfoByRoleCode(
			@RequestParam(required = false)
			@ApiParam(name="roleCodes",value="角色编码",required=true) List<String> roleCodes) throws Exception {
		logger.info("===== 根据角色编码获取用户信息 UserController.queryUserInfoByRoleCode ===== roleCodes:"+roleCodes);
		List<UserDto> iscUsers = userService.findUserInfoByRoleCode(roleCodes);
		return new ResponseEntity<List<UserDto>>(iscUsers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "关联角色用户", notes = "关联角色用户")
	@RequestMapping(value = "relaRoleUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> relaRoleUser(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=true)String userId,
		@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=true)String roleId)
			throws Exception {
		logger.info("===== 关联角色用户 UserController.relaRoleUser ===== userId:"+userId+"roleId:"+roleId);
		userService.relaRoleUser(roleId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "取消关联角色用户", notes = "取消关联角色用户")
	@RequestMapping(value = "deleteRelaRoleUser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteRelaRoleUser(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=true)String userId,
		@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=true)String roleId)
			throws Exception {
		logger.info("===== 取消关联角色用户 UserController.deleteRelaRoleUser ===== userId:"+userId+"roleId:"+roleId);
		return userService.deleteRelaRoleUser(roleId, userId);
	}
	
	@ApiOperation(value = "修改密码", notes = "修改密码")
	@RequestMapping(value = "updatePassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updatePassword(@RequestBody IscPwdUpdateRequest iscPwdUpdateRequest)
			throws Exception {
		logger.info("===== 修改密码 UserController.updatePassword ===== iscPwdUpdateRequest:"+iscPwdUpdateRequest);
		return userService.updatePassword(iscPwdUpdateRequest);
	}
	
	@ApiOperation(value = "重置密码", notes = "重置密码")
	@RequestMapping(value = "resetPwd", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity resetPwd(@RequestParam(required = false)
	@ApiParam(name="userId",value="用户id",required=true)String userId)
			throws Exception {
		logger.info("===== 重置密码 UserController.resetPwd ===== userId:"+userId);
		return userService.resetPwd(userId);
	}
	
	@ApiOperation(value = "关联部门用户", notes = "关联部门用户")
	@RequestMapping(value = "relaArchitectureUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> relaArchitectureUser(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=true)String userId,
		@RequestParam(required = false)
		@ApiParam(name="architectureId",value="部门id",required=true)String architectureId)
			throws Exception {
		logger.info("===== 关联部门用户 UserController.relaArchitectureUser ===== userId:"+userId+"architectureId:"+architectureId);
		userService.relaArchitectureUser(architectureId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "取消关联部门用户", notes = "取消关联部门用户")
	@RequestMapping(value = "deleteRelaArchitectureUser", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteRelaArchitectureUser(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=true)String userId,
		@RequestParam(required = false)
		@ApiParam(name="architectureId",value="部门id",required=true)String architectureId)
			throws Exception {
		logger.info("===== 取消关联部门用户 UserController.deleteRelaArchitectureUser ===== userId:"+userId+"architectureId:"+architectureId);
		return userService.deleteRelaArchitectureUser(architectureId, userId);
	}

	@ApiOperation(value = "根据部门id获取用户信息", notes = "根据部门id获取用户信息")
	@RequestMapping(value = "queryUserInfoByDeptId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserDto>> queryUserInfoByDeptId(
			@RequestParam(required = false)
			@ApiParam(name="deptId",value="部门id",required=true)String deptId) throws Exception {
		logger.info("===== 根据部门id获取用户信息 UserController.queryUserInfoByDeptId ===== deptId:"+deptId);
		List<UserDto> iscUsers = userService.queryUserInfoByDeptId(deptId);
		return new ResponseEntity<List<UserDto>>(iscUsers, HttpStatus.OK);
	}
}
