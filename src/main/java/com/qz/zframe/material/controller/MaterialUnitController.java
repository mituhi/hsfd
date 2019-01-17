package com.qz.zframe.material.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.MaterialUnit;
import com.qz.zframe.material.entity.MaterialUnitExample;
import com.qz.zframe.material.entity.MaterialUnitExample.Criteria;
import com.qz.zframe.material.service.MaterialUnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/material/materialUnit")
@Api(tags = "api-material-materialUnit", description = "物资管理-物资单位管理")
public class MaterialUnitController {
	
	@Autowired
	private MaterialUnitService materialUnitService;
	
	@RequestMapping(value = "/listUnit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资单位列表", notes = "")
	public NewPageResult<MaterialUnit>  getMaterialUnitList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "measuringUnitCode", value = "单位编码", required = false) String measuringUnitCode,
			@RequestParam(required = false) @ApiParam(name = "measuringUnitName", value = "单位名称", required = false) String measuringUnitName){
		MaterialUnitExample example = new MaterialUnitExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause("measuring_unit_code asc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(measuringUnitCode)) {
			criteria.andMeasuringUnitCodeLike(measuringUnitCode);
		}
		if (!StringUtils.isBlank(measuringUnitName)) {
			criteria.andMeasuringUnitNameLike(measuringUnitName);
		}
		criteria.andIsDeleteEqualTo("01");//01未删除
		return materialUnitService.getMaterialUnitList(example);
	}
	
	@RequestMapping(value = "/listUnitAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资单位全部列表", notes = "")
	public NewPageResult<MaterialUnit>  getMaterialUnitListAll(
			@RequestParam(required = false) @ApiParam(name = "measuringUnitCode", value = "单位编码", required = false) String measuringUnitCode,
			@RequestParam(required = false) @ApiParam(name = "measuringUnitName", value = "单位名称", required = false) String measuringUnitName){
		MaterialUnitExample example = new MaterialUnitExample();
		example.setIsPage(0);
		example.setOrderByClause("measuring_unit_code asc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(measuringUnitCode)) {
			criteria.andMeasuringUnitCodeLike(measuringUnitCode);
		}
		if (!StringUtils.isBlank(measuringUnitName)) {
			criteria.andMeasuringUnitNameLike(measuringUnitName);
		}
		criteria.andStatusEqualTo("01");//启用状态
		criteria.andIsDeleteEqualTo("01");//01未删除
		return materialUnitService.getMaterialUnitList(example);
	}
	
	@RequestMapping(value = "/detailUnit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资单位详情", notes = "")
	public ResultEntityDetail<MaterialUnit>  getMaterialUnitDetail(@RequestParam(required = true) String measuringUnitId){
		return materialUnitService.getMaterialUnitDetail(measuringUnitId);
	}
	
	@RequestMapping(value = "/saveUnit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增物资单位单位", notes = "")
	public ResultEntity addMaterialUnit(@RequestBody MaterialUnit m){
		return materialUnitService.addMaterialUnit(m);
	}
	
	@RequestMapping(value = "/editUnit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资单位", notes = "")
	public ResultEntity editMaterialUnit(@RequestBody MaterialUnit materialUnit){
		return materialUnitService.editMaterialUnit(materialUnit);
	}
	
	@RequestMapping(value = "/delUnit", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资单位", notes = "")
	public ResultEntity delUnit(@RequestBody List<String> measuringUnitIds){
		return materialUnitService.delUnit(measuringUnitIds);
	}

}
