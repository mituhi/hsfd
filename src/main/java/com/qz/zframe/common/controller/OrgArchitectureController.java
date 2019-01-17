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

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.util.PageResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/common/orgArchitecture")
@Api(tags = { "api-common-orgArchitecture" }, description = "系统管理-组织架构管理")
public class OrgArchitectureController {
	private static Logger logger = LoggerFactory.getLogger(OrgArchitectureController.class);
	
	@Autowired
	private OrgArchitectureService orgArchitectureService;
	
	@ApiOperation(value = "条件查询组织架构信息", notes = "条件查询组织架构信息")
	@RequestMapping(value = "queryOrgArchitecture", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity queryOrgArchitecture(
			@RequestParam(required = true)
			@ApiParam(name="architectureType",value="组织类型",required=true) String architectureType,
			@RequestParam(required = false)
			@ApiParam(name="architectureName",value="架构名称",required=false) String architectureName,
			@RequestParam(required = false)
			@ApiParam(name="isdisable",value="是否停用",required=false) String isDisable,
			@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) throws Exception {
		logger.info("===== 条件查询组织架构信息 OrgArchitectureController.queryOrgArchitecture ====="
				+ " architectureType:"+architectureType + "architectureName:"+architectureName + "isDisable:"+isDisable);
		PageResultEntity pageorgan = orgArchitectureService.queryOrgArchitecture(architectureType, architectureName, isDisable, pageNum, pageSize);
		return pageorgan;
	}
	
	@ApiOperation(value = "查询组织架构信息列表", notes = "查询组织架构信息列表")
	@RequestMapping(value = "queryOrgArchitectureList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<OrgArchitecture>> queryOrgArchitectureList(
			@RequestParam(required = false)
			@ApiParam(name="architectureId",value="架构id",required=false)String architectureId,
			@RequestParam(required = false)
			@ApiParam(name="architectureType",value="组织类型",required=false) String architectureType,
			@RequestParam(required = false)
			@ApiParam(name="architectureName",value="架构名称",required=false) String architectureName,
			@RequestParam(required = false)
			@ApiParam(name="superCompetentDepartment",value="上级主管部门id",required=false) String superCompetentDepartment) throws Exception {
		logger.info("===== 查询组织架构信息列表 OrgArchitectureController.queryOrgArchitectureList ===== "
				+ "architectureId:"+architectureId+"architectureType:"+architectureType
				+ "architectureName:"+architectureName);
		List<OrgArchitecture> orgArchitectures = orgArchitectureService.queryOrgArchitectureList(architectureId, 
				architectureType, architectureName, superCompetentDepartment);
		return new ResponseEntity<List<OrgArchitecture>>(orgArchitectures, HttpStatus.OK);
	}
	
	@ApiOperation(value = "根据id查询组织架构信息", notes = "根据id查询组织架构信息")
	@RequestMapping(value = "queryOrgArchitectureById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<OrgArchitecture> queryOrgArchitectureById(
			@RequestParam(required = false)
			@ApiParam(name="architectureId",value="架构id",required=true)String architectureId) throws Exception {
		logger.info("===== 根据id查询组织架构信息 OrgArchitectureController.queryOrgArchitectureById ===== architectureId:"+architectureId);
		OrgArchitecture orgArchitecture = orgArchitectureService.queryOrgArchitectureById(architectureId);
		return new ResponseEntity<OrgArchitecture>(orgArchitecture, HttpStatus.OK);
	}
	
	@ApiOperation(value = "新增组织架构", notes = "新增组织架构")
	@RequestMapping(value = "addOrgArchitecture", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity addOrgArchitecture(@RequestBody OrgArchitecture orgArchitecture)
			throws Exception {
		logger.info("===== 新增组织架构 OrgArchitectureController.addOrgArchitecture ===== orgArchitecture:"+orgArchitecture);
		return orgArchitectureService.addAndUpdateOrgArchitecture(orgArchitecture);
	}
	
	@ApiOperation(value = "修改组织架构", notes = "修改组织架构")
	@RequestMapping(value = "updateOrgArchitecture", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity updateOrgArchitecture(@RequestBody OrgArchitecture orgArchitecture)
			throws Exception {
		logger.info("===== 修改组织架构 OrgArchitectureController.updateOrgArchitecture ===== orgArchitecture:"+orgArchitecture);
		return orgArchitectureService.addAndUpdateOrgArchitecture(orgArchitecture);
	}
	
	@ApiOperation(value = "删除组织架构", notes = "删除组织架构")
	@RequestMapping(value = "deleteOrgArchitecture", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity deleteOrgArchitecture(@RequestParam(required = true) List<String> ids) throws Exception {
		logger.info("===== 删除组织架构 OrgArchitectureController.deleteOrgArchitecture ===== ids:"+ids);
		return orgArchitectureService.deleteOrgArchitecture(ids);
	}
	
	@ApiOperation(value = "根据父id查询组织架构信息", notes = "根据父id查询组织架构信息")
	@RequestMapping(value = "findOrgArchitectureByFid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<OrgArchitecture>> findOrgArchitectureByFid(
			@RequestParam(required = false)
			@ApiParam(name="architectureId",value="架构id",required=false)String architectureId) throws Exception {
		logger.info("===== 根据父id查询组织架构信息 OrgArchitectureController.findOrgArchitectureByFid ===== "
				+ "architectureId:"+architectureId);
		List<OrgArchitecture> orgArchitectures = orgArchitectureService.findOrgArchitectureByFid(architectureId);
		return new ResponseEntity<List<OrgArchitecture>>(orgArchitectures, HttpStatus.OK);
	}

	@ApiOperation(value = "根据风电场编号查询部门或班组信息", notes = "根据风电场编号查询部门或班组信息")
	@RequestMapping(value = "queryOrgArchitectureListByCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<OrgArchitecture>> queryOrgArchitectureListByCode(
			@RequestParam(required = true)
			@ApiParam(name="architectureCode",value="风电场编号",required=true)String architectureCode,
			@RequestParam(required = true)
			@ApiParam(name="architectureType",value="组织架构类型 03部门 04班组",required=true)String architectureType) throws Exception {
		logger.info("===== 根据风电场编号查询部门或班组信息 OrgArchitectureController.queryOrgArchitectureListByCode ===== "
				+ "architectureCode:"+architectureCode+"architectureType:"+architectureType);
		List<OrgArchitecture> orgArchitectures = orgArchitectureService.queryOrgArchitectureListByCode(architectureCode, architectureType);
		return new ResponseEntity<List<OrgArchitecture>>(orgArchitectures, HttpStatus.OK);
	}

}
