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

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.PageResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/role")
@Api(tags = { "api-common-role" }, description = "系统管理-角色管理")
public class RoleController {
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value = "条件查询角色信息", notes = "条件查询角色信息")
	@RequestMapping(value = "findRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity findRoleList(
			@RequestParam(required = false)
			@ApiParam(name="roleCode",value="角色编号",required=false) String roleCode,
			@RequestParam(required = false)
			@ApiParam(name="roleName",value="角色名称",required=false) String roleName,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		logger.info("===== 条件查询角色信息 RoleController.findRoleList ===== "
				+ "roleCode:"+roleCode+"roleName:"+roleName);
		return roleService.findRoleList(roleCode, roleName, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据id查询角色信息", notes = "根据id查询角色信息")
	@RequestMapping(value = "queryRoleInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Role> queryRoleInfo(
			@RequestParam(required = false)
			@ApiParam(name="roleId",value="角色id",required=true)String roleId) throws Exception {
		logger.info("===== 根据id查询角色信息 RoleController.queryRoleInfo ===== roleId:"+roleId);
		return new ResponseEntity<Role>(roleService.queryRoleInfo(roleId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增角色信息", notes = "新增角色信息")
	@RequestMapping(value = "addRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addRole(@RequestBody Role role)
			throws Exception {
		logger.info("===== 新增角色信息 RoleController.addRole ===== role:"+role);
		return roleService.addRole(role);
	}
	
	@ApiOperation(value = "修改角色信息", notes = "修改角色信息")
	@RequestMapping(value = "updateRole", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateRole(@RequestBody Role role)
			throws Exception {
		logger.info("===== 修改角色信息 RoleController.updateRole ===== role:"+role);
		return roleService.updateRole(role);
	}
	
	@ApiOperation(value = "删除角色信息", notes = "删除角色信息")
	@RequestMapping(value = "deleteRoles", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteRoles(@RequestParam(required = true) List<String> roleIds) throws Exception {
		logger.info("===== 删除用户信息 RoleController.deleteRoles ===== roleIds:"+roleIds);
		return roleService.deleteRoles(roleIds);
	}
	
	@ApiOperation(value = "批量获取用户的角色信息", notes = "批量获取用户的角色信息")
	@RequestMapping(value = "findUserRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Role>> findUserRoleList(
			@RequestParam(required = false)
			@ApiParam(name="userId",value="用户id",required=true)String userId) throws Exception {
		logger.info("===== 批量获取用户的角色信息 RoleController.findUserRoleList ===== userId:"+userId);
		return new ResponseEntity<List<Role>>(roleService.findUserRoleList(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "批量获取用户已分配的角色信息", notes = "批量获取用户已分配的角色信息")
	@RequestMapping(value = "findUserOwnedRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Role>> findUserOwnedRoleList(
			@RequestParam(required = false)
			@ApiParam(name="userId",value="用户id",required=true)String userId) throws Exception {
		logger.info("===== 批量获取用户已分配的角色信息 RoleController.findUserOwnedRoleList ===== userId:"+userId);
		return new ResponseEntity<List<Role>>(roleService.findUserOwnedRoleList(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取用户未分配的角色信息", notes = "获取用户未分配的角色信息")
	@RequestMapping(value = "findUserNoOwnedRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Role>> findUserNoOwnedRoleList(
			@RequestParam(required = false)
			@ApiParam(name="userId",value="用户id",required=true)String userId) throws Exception {
		logger.info("===== 获取用户未分配的角色信息 RoleController.findUserNoOwnedRoleList ===== userId:"+userId);
		return new ResponseEntity<List<Role>>(roleService.findUserNoOwnedRoleList(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "清空用户角色", notes = "清空用户角色")
	@RequestMapping(value = "clearUserRole", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity clearUserRole(@RequestParam(required = true) String userId) throws Exception {
		logger.info("===== 删除用户信息 RoleController.clearUserRole ===== userId:"+userId);
		return roleService.clearUserRole(userId);
	}
	
	@ApiOperation(value = "获取所有角色信息", notes = "获取所有角色信息")
	@RequestMapping(value = "findAllRoleList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Role>> findAllRoleList() throws Exception {
		logger.info("===== 获取所有角色信息 RoleController.findAllRoleList ===== ");
		return new ResponseEntity<List<Role>>(roleService.findRoleList(null), HttpStatus.OK);
	}
	
}
