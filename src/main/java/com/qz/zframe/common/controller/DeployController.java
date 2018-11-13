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

import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.service.DeployService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/deploy")
@Api(tags = { "api-common-deploy" }, description = "系统管理-流程管理")
public class DeployController {
	private static Logger logger = LoggerFactory.getLogger(DeployController.class);
	
	@Autowired
	private DeployService deployService;
	
	@ApiOperation(value = "条件查询流程", notes = "条件查询流程")
	@RequestMapping(value = "queryDeployMain", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DeployMain>> queryDeployMain(
			@RequestParam(required = false)
			@ApiParam(name="mainDeployName",value="流程名称",required=false)String mainDeployName) {
		logger.info("===== 条件查询流程主表  DeployController.queryDeployMain ===== mainDeployName:"+mainDeployName);
		List<DeployMain> list = deployService.queryDeployMain(mainDeployName);
		return new ResponseEntity<List<DeployMain>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "根据id查询流程", notes = "根据id查询流程")
	@RequestMapping(value = "queryDeployMainById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DeployMain> queryDeployMainById(
			@RequestParam(required = false)
			@ApiParam(name="id",value="主键id",required=true)String id) throws Exception {
		logger.info("===== 根据id查询流程 DeployController.queryDeployMainById ===== id:"+id);
		DeployMain deployMain = deployService.queryDeployMainById(id);
		return new ResponseEntity<DeployMain>(deployMain, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增流程", notes = "新增流程")
	@RequestMapping(value = "addDeployMain", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DeployMain> addDeployMain(@RequestBody DeployMain deployMain)
			throws Exception {
		logger.info("===== 新增流程 DeployController.addDeployMain ===== deployMain:"+deployMain);
		return new ResponseEntity<DeployMain>(deployService.addAndUpdateDeployMain(deployMain), HttpStatus.OK);
	}
	
	@ApiOperation(value = "修改流程", notes = "修改流程")
	@RequestMapping(value = "updateDeployMain", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DeployMain> updateCodeType(@RequestBody DeployMain deployMain)
			throws Exception {
		logger.info("===== 修改流程 DeployController.updateDeployMain ===== updateDeployMain:"+deployMain);
		return new ResponseEntity<DeployMain>(deployService.addAndUpdateDeployMain(deployMain),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "根据id查询流程步骤", notes = "根据id查询流程步骤")
	@RequestMapping(value = "queryDeployById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Deploy> queryDeployById(
			@RequestParam(required = false)
			@ApiParam(name="deployId",value="主键id",required=true)String deployId) throws Exception {
		logger.info("===== 根据id查询流程步骤 DeployController.queryDeployById ===== deployId:"+deployId);
		Deploy deploy = deployService.queryDeployById(deployId);
		return new ResponseEntity<Deploy>(deploy, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增流程步骤", notes = "新增流程步骤")
	@RequestMapping(value = "addDeploy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Deploy> addDeploy(@RequestBody Deploy deploy)
			throws Exception {
		logger.info("===== 新增流程步骤 DeployController.addDeploy ===== deploy:"+deploy);
		return new ResponseEntity<Deploy>(deployService.addAndUpdateDeploy(deploy), HttpStatus.OK);
	}
	
	@ApiOperation(value = "修改流程步骤", notes = "修改流程步骤")
	@RequestMapping(value = "updateDeploy", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Deploy> updateDeploy(@RequestBody Deploy deploy)
			throws Exception {
		logger.info("===== 修改流程步骤 DeployController.updateDeploy ===== deploy:"+deploy);
		return new ResponseEntity<Deploy>(deployService.addAndUpdateDeploy(deploy),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "删除流程步骤", notes = "删除流程步骤")
	@RequestMapping(value = "deleteDeploy", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> deleteDeploy(@RequestParam(required = true) List<String> deployIds) throws Exception {
		logger.info("===== 删除流程步骤 DeployController.deleteDeploy ===== deployIds:"+deployIds);
		return new ResponseEntity<Integer>(deployService.deleteDeploy(deployIds), HttpStatus.OK);
	}
		
}
