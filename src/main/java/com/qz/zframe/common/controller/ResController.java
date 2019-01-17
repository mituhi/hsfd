package com.qz.zframe.common.controller;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
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

import com.qz.zframe.common.entity.Res;
import com.qz.zframe.common.service.ResService;
import com.qz.zframe.common.util.PageResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/res")
@Api(tags = { "api-common-res" }, description = "系统管理-菜单管理")
public class ResController {
	private static Logger logger = LoggerFactory.getLogger(ResController.class);
	
	@Autowired
	private ResService resService;
	
	@ApiOperation(value = "条件查询菜单信息", notes = "条件查询菜单信息")
	@RequestMapping(value = "queryRes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryRes(
			@RequestParam(required = false)
			@ApiParam(name="resValue",value="菜单编号",required=false) String resValue,
			@RequestParam(required = false)
			@ApiParam(name="resName",value="菜单名称",required=false) String resName,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		logger.info("===== 条件查询菜单信息 ResController.queryRes ===== "
				+ "resValue:"+resValue+"resName:"+resName);
		return resService.queryResPage(resValue, resName, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据id查询菜单信息", notes = "根据id查询菜单信息")
	@RequestMapping(value = "queryResInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Res> queryResInfo(
			@RequestParam(required = false)
			@ApiParam(name="resId",value="菜单id",required=true)String resId) throws Exception {
		logger.info("===== 根据id查询菜单信息 ResController.queryResInfo ===== resId:"+resId);
		return new ResponseEntity<Res>(resService.queryResInfo(resId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "批量获取菜单信息", notes = "批量获取菜单信息")
	@RequestMapping(value = "findResList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Res>> findResList(@RequestBody Res res) {
		logger.info("===== 批量获取菜单信息 ResController.findResList ===== " + "res:"+res);
		return new ResponseEntity<List<Res>>(resService.findResList(res), HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增菜单", notes = "新增菜单")
	@RequestMapping(value = "addRes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addRes(@RequestBody Res res) {
		logger.info("===== 新增菜单 ResController.addRes ===== res:"+res);
		return resService.addRes(res);
	}
	
	@ApiOperation(value = "修改菜单", notes = "修改菜单")
	@RequestMapping(value = "updateRes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateRes(@RequestBody Res res)
			throws Exception {
		logger.info("===== 修改菜单 ResController.updateRes ===== res:"+res);
		resService.updateRes(res);
		return resService.updateRes(res);
	}
	
	@ApiOperation(value = "批量删除菜单", notes = "批量删除菜单")
	@RequestMapping(value = "deleteResInBatch", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteResInBatch(@RequestParam(required = true) List<String> resIds) {
		logger.info("===== 批量删除菜单 ResController.deleteIscUser ===== resIds:"+resIds);
		return resService.deleteResInBatch(resIds);
	}
	
	@ApiOperation(value = "批量获取角色下的菜单", notes = "批量获取角色下的菜单")
	@RequestMapping(value = "findRoleResList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Res>> findRoleResList(@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId) {
		logger.info("===== 批量获取角色下的菜单 ResController.findRoleResList ===== " + "roleId:"+roleId);
		return new ResponseEntity<List<Res>>(resService.findRoleResList(roleId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "关联角色资源", notes = "关联角色资源")
	@RequestMapping(value = "relaRoleRes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> relaRoleRes(@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId,
		@RequestParam(required = false)
		@ApiParam(name="resId",value="资源id",required=false) String resId)
			throws Exception {
		logger.info("===== 关联角色资源 ResController.relaRoleRes ===== roleId:"+roleId + "resId:"+resId);
		resService.relaRoleRes(roleId, resId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "取消关联角色资源", notes = "取消关联角色资源")
	@RequestMapping(value = "removeRelaRoleRes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity removeRelaRoleRes(@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId,
		@RequestParam(required = false)
		@ApiParam(name="resId",value="资源id",required=false) String resId)
			throws Exception {
		logger.info("===== 关联角色资源 ResController.removeRelaRoleRes ===== roleId:"+roleId + "resId:"+resId);
		return resService.removeRelaRoleRes(roleId, resId);
	}
	
	@ApiOperation(value = "批量获取用户的菜单", notes = "批量获取用户的菜单")
	@RequestMapping(value = "listUserRes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Res>> listUserRes(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=false) String userId) {
		logger.info("===== 批量获取用户的菜单 ResController.listUserRes ===== " + "userId:"+userId);
		return new ResponseEntity<List<Res>>(resService.listUserRes(userId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取资源树 用户角色参数二选一", notes = "获取资源树 用户角色参数二选一")
	@RequestMapping(value = "queryTreeMenuInfoList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Res>> queryTreeMenuInfoList(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=false) String userId,
		@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId) {
		logger.info("===== 获取资源树 用户角色参数二选一 ResController.queryTreeMenuInfoList ===== " 
		+ "userId:"+userId + "roleId:"+roleId);
		return new ResponseEntity<List<Res>>(resService.queryTreeMenuInfoList(userId, roleId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取菜单树", notes = "获取菜单树")
	@RequestMapping(value = "getMenuTreeData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Res>> getMenuTreeData(@RequestParam(required = false)
		@ApiParam(name="userId",value="用户id",required=false) String userId,
		@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId) {
		logger.info("===== 获取菜单树 ResController.getMenuTreeData ===== " 
		+ "userId:"+userId + "roleId:"+roleId);
		return new ResponseEntity<List<Res>>(resService.getMenuTreeData(userId, roleId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "批量关联角色资源", notes = "批量关联角色资源")
	@RequestMapping(value = "relaRoleResBatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> relaRoleResBatch(@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId,
		@RequestParam(required = false)
		@ApiParam(name="resIds",value="资源id",required=false) List<String> resIds)
			throws Exception {
		logger.info("===== 批量关联角色资源 ResController.relaRoleResBatch ===== roleId:"+roleId + "resIds:"+resIds);
		resService.relaRoleResBatch(roleId, resIds);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "清空角色资源", notes = "清空角色资源")
	@RequestMapping(value = "clearRoleRes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity clearRoleRes(@RequestParam(required = false)
		@ApiParam(name="roleId",value="角色id",required=false) String roleId) {
		logger.info("===== 清空角色资源 ResController.clearRoleRes ===== roleId:"+roleId);
		return resService.clearRoleRes(roleId);
	}
	
	@ApiOperation(value = "获取完整资源树", notes = "获取完整资源树")
	@RequestMapping(value = "findAllResList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Res> findAllResList() {
		logger.info("===== 获取完整资源树 ResController.findAllResList ===== ");
		return new ResponseEntity<Res>(resService.findAllResList(), HttpStatus.OK);
	}

	@ApiOperation(value = "根据菜单id获取用户是否有进入菜单的权限", notes = "根据菜单id获取用户是否有进入菜单的权限")
	@RequestMapping(value = "queryPermissions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity queryPermissions(
			@RequestParam(required = false)
			@ApiParam(name="resId",value="菜单id",required=false) String resId) {
		logger.info("===== 根据菜单id获取用户是否有进入菜单的权限 ResController.queryPermissions ===== " + "resId:"+resId);
		return resService.queryPermissions(resId);
	}

	@ApiOperation(value = "根据菜单id获取按钮信息", notes = "根据菜单id获取按钮信息")
	@RequestMapping(value = "queryButton", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity queryButton(
			@RequestParam(required = false)
			@ApiParam(name="resId",value="菜单id",required=false) String resId) {
		logger.info("===== 根据菜单id获取按钮信息 ResController.queryButton ===== " + "resId:"+resId);
		return resService.queryButton(resId);
	}
}
