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

import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.DataDictType;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.PageResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/dataDict")
@Api(tags = { "api-common-dataDict" }, description = "系统管理-标准代码管理")
public class DataDictController {
	private static Logger logger = LoggerFactory.getLogger(DataDictController.class);
	
	@Autowired
	private DataDictService dataDictService;
	
	@ApiOperation(value = "根据类型查询编码分类", notes = "根据类型查询编码分类")
	@RequestMapping(value = "queryCodeType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryCodeType(
			@RequestParam(required = false)
			@ApiParam(name="codeType",value="分类编码",required=false) String codeType,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		logger.info("===== 根据类型查询编码分类 DataDictController.queryCodeByCodeType ===== codeType:"+codeType);
		return dataDictService.queryCodeType(codeType, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据id查询编码分类", notes = "根据id查询编码分类")
	@RequestMapping(value = "queryCodeTypeyById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DataDictType> queryCodeTypeById(
			@RequestParam(required = false)
			@ApiParam(name="id",value="主键id",required=true)String id) throws Exception {
		logger.info("===== 根据id查询编码分类 DataDictController.queryCodeTypeById ===== id:"+id);
		DataDictType dataDictType = dataDictService.queryCodeTypeById(id);
		return new ResponseEntity<DataDictType>(dataDictType, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增编码分类", notes = "新增编码分类")
	@RequestMapping(value = "addCodeType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addCodeType(@RequestBody DataDictType dataDictType)
			throws Exception {
		logger.info("===== 新增编码分类 DataDictController.addCodeType ===== dataDictType:"+dataDictType);
		return dataDictService.addAndUpdateCodeType(dataDictType);
	}
	
	@ApiOperation(value = "修改编码分类", notes = "修改编码分类")
	@RequestMapping(value = "updateCodeType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateCodeType(@RequestBody DataDictType dataDictType)
			throws Exception {
		logger.info("===== 修改编码分类 DataDictController.updateCodeType ===== dataDictType:"+dataDictType);
		return dataDictService.addAndUpdateCodeType(dataDictType);
	}
	
	@ApiOperation(value = "删除编码分类", notes = "删除编码分类")
	@RequestMapping(value = "deleteCodeType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteCodeType(@RequestParam(required = true) List<String> ids) throws Exception {
		logger.info("===== 删除编码分类 DataDictController.deleteCodeType ===== ids:"+ids);
		return dataDictService.deleteCodeType(ids);
	}
	
	@ApiOperation(value = "根据类型查询编码", notes = "根据类型查询编码")
	@RequestMapping(value = "queryCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryCode(@RequestParam(required = false) String codeType,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		logger.info("===== 根据类型查询编码 DataDictController.queryCode ===== codeType:"+codeType);
		return dataDictService.queryCode(codeType, pageNum, pageSize);
	}
	
	@ApiOperation(value = "根据类型查询编码列表", notes = "根据类型查询编码列表")
	@RequestMapping(value = "queryCodeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DataDict>> queryCodeList(@RequestParam(required = false) String codeType) {
		logger.info("===== 根据类型查询编码列表 DataDictController.queryCodeList ===== codeType:"+codeType);
		return new ResponseEntity<List<DataDict>>(dataDictService.queryCodeList(codeType), HttpStatus.OK);
	}
	
	@ApiOperation(value = "根据id查询编码", notes = "根据id查询编码")
	@RequestMapping(value = "queryCodeById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DataDict> queryCodeById(
			@RequestParam(required = false)
			@ApiParam(name="id",value="主键id",required=true)String id) throws Exception {
		logger.info("===== 根据id查询编码 DataDictController.queryCodeById ===== id:"+id);
		DataDict dataDict = dataDictService.queryCodeById(id);
		return new ResponseEntity<DataDict>(dataDict, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增编码", notes = "新增编码")
	@RequestMapping(value = "addCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addCode(@RequestBody DataDict dataDict)
			throws Exception {
		logger.info("===== 新增编码分类 DataDictController.addCode ===== dataDict:"+dataDict);
		return dataDictService.addAndUpdateCode(dataDict);
	}
	
	@ApiOperation(value = "修改编码", notes = "修改编码")
	@RequestMapping(value = "updateCode", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateCode(@RequestBody DataDict dataDict)
			throws Exception {
		logger.info("===== 修改编码 DataDictController.updateCode ===== dataDict:"+dataDict);
		return dataDictService.addAndUpdateCode(dataDict);
	}
	
	@ApiOperation(value = "删除编码", notes = "删除编码")
	@RequestMapping(value = "deleteCode", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteCode(@RequestParam(required = true) List<String> ids) throws Exception {
		logger.info("===== 删除编码 DataDictController.deleteCode ===== ids:"+ids);
		return dataDictService.deleteCode(ids);
	}
		
}
