package com.qz.zframe.common.controller;

import com.qz.zframe.common.entity.CodeConfig;
import com.qz.zframe.common.service.CodeConfigService;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/common/codeConfig")
@Api(tags = { "api-common-codeConfig" }, description = "系统管理-编码管理")
public class CodeConfigController {
	private static Logger logger = LoggerFactory.getLogger(CodeConfigController.class);
	
	@Autowired
	private CodeConfigService codeConfigService;
	
	@ApiOperation(value = "分页查询编码配置信息", notes = "分页查询编码配置信息")
	@RequestMapping(value = "queryCodeConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryCodeConfig(
			@RequestParam(required = false)
			@ApiParam(name="configType",value="配置类型",required=false) String configType,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		logger.info("===== 分页查询编码配置信息 CodeConfigController.queryCodeConfig ===== configType:"+configType);
		return codeConfigService.queryCodeConfig(configType, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据id编码配置信息", notes = "根据id编码配置信息")
	@RequestMapping(value = "queryCodeConfigById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CodeConfig> queryCodeConfigById(
			@RequestParam(required = true)
			@ApiParam(name="configId",value="配置id",required=true)String configId) throws Exception {
		logger.info("===== 根据id编码配置信息 CodeConfigController.queryCodeConfigById ===== configId:"+configId);
		return new ResponseEntity<CodeConfig>(codeConfigService.queryCodeConfigById(configId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增编码配置", notes = "新增编码配置")
	@RequestMapping(value = "addCodeConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity addCodeConfig(@RequestBody CodeConfig codeConfig) throws Exception {
		logger.info("===== 新增编码配置 CodeConfigController.addCodeConfig ===== codeConfig:"+codeConfig);
		return codeConfigService.addCodeConfig(codeConfig);
	}
	
	@ApiOperation(value = "修改编码配置", notes = "修改编码配置")
	@RequestMapping(value = "updateCodeConfig", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity updateCodeConfig(@RequestBody CodeConfig codeConfig) throws Exception {
		logger.info("===== 修改编码配置 CodeConfigController.updateCodeConfig ===== codeConfig:"+codeConfig);
		return codeConfigService.updateCodeConfig(codeConfig);
	}
	
	@ApiOperation(value = "删除编码配置", notes = "删除编码配置")
	@RequestMapping(value = "deleteCodeConfig", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity deleteCodeConfig(
			@RequestParam(required = true)
			@ApiParam(name="configIds",value="配置id",required=true)List<String> configIds) {
		logger.info("===== 删除编码配置 CodeConfigController.deleteCodeConfig ===== configIds:"+configIds);
		return codeConfigService.deleteCodeConfig(configIds);
	}

//	@ApiOperation(value = "根据条件查询配置值", notes = "根据条件查询配置值")
//	@RequestMapping(value = "findValueByMsg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public String findValueByMsg(
//			@RequestParam(required = true)
//			@ApiParam(name="configType",value="配置类型",required=true)String configType,
//			@RequestParam(required = false)
//			@ApiParam(name="businessCode",value="配置类型",required=false)String businessCode) throws Exception {
//		logger.info("===== 根据条件查询配置值 CodeConfigController.findValueByMsg ===== configType:"+configType+"businessCode:"+businessCode);
//		return codeConfigService.findValueByMsg(configType, businessCode);
//	}
}
