package com.qz.zframe.device.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentClassificationExample;
import com.qz.zframe.device.entity.EquipmentClassificationExample.Criteria;
import com.qz.zframe.device.service.EquipmentClassificationService;
import com.qz.zframe.material.entity.Material;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/support/device")
@Api(tags = "api-support-device", description = "设备")
public class EquipmentClassificationController {

	@Autowired
	private EquipmentClassificationService equipmentClassificationService;



	/**
	 * 获取设备信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param typeName
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/findEquipment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备信息", notes = " 获取设备信息")
	public PageResultEntity findEquipment(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) String typeName){
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		equipmentExample.setPageSize(pageSize);
		equipmentExample.setPageNo(pageNum);
		//equipmentExample.setOrderByClause("sort desc");
		Criteria criteria =equipmentExample.createCriteria();
		if (StringUtils.isNotBlank(typeName) ){
			criteria.andTypeNameLike(typeName);
		}
		resultEntity = equipmentClassificationService.findEquipment(equipmentExample);
		return resultEntity;
	}
	/**
	 * 新增物资
	 * 
	 * @param material
	 * @return
	 */
	@RequestMapping(value = "/addEquipment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增设备分类", notes = "新增设备分类")
    public ResultEntity addEquipment(@RequestBody EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(equipmentClassification.getEquipmentType()) || StringUtils.isBlank(equipmentClassification.getEquipmentTypeDescribe()) ||
		    StringUtils.isBlank(equipmentClassification.getIsToplevel()) || StringUtils.isBlank(equipmentClassification.getTypeName()) ||
			StringUtils.isBlank(equipmentClassification.getOutputId()) || StringUtils.isBlank(equipmentClassification.getRunId()) ||
			StringUtils.isBlank(equipmentClassification.getStatus()) || StringUtils.isBlank(equipmentClassification.getSuperiorEquipment()) ||	
			StringUtils.isBlank(equipmentClassification.getSuperiorEquipmentDescribe()) || StringUtils.isBlank(equipmentClassification.getSuperiorEquipmentName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = equipmentClassificationService.addEquipment(equipmentClassification);
        return resultEntity;
    }
	
	@RequestMapping(value = "/updateEquipment", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改设备分类", notes = "修改设备分类")
    public ResultEntity updateEquipment(@RequestBody EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(equipmentClassification.getEquipmentType()) || StringUtils.isBlank(equipmentClassification.getEquipmentTypeDescribe()) ||
		    StringUtils.isBlank(equipmentClassification.getIsToplevel()) || StringUtils.isBlank(equipmentClassification.getTypeName()) ||
			StringUtils.isBlank(equipmentClassification.getOutputId()) || StringUtils.isBlank(equipmentClassification.getRunId()) ||
			StringUtils.isBlank(equipmentClassification.getStatus()) || StringUtils.isBlank(equipmentClassification.getSuperiorEquipment()) ||	
			StringUtils.isBlank(equipmentClassification.getSuperiorEquipmentDescribe()) || StringUtils.isBlank(equipmentClassification.getSuperiorEquipmentName()) ||
			StringUtils.isBlank(equipmentClassification.getEquipmentId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = equipmentClassificationService.updateEquipment(equipmentClassification);
        return resultEntity;
    }
	
	
	@RequestMapping(value = "/deleteEquipment", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除设备分类", notes = "删除设备分类")
    public ResultEntity deleteEquipment(@RequestParam String equipmentId) {
		ResultEntity resultEntity = new ResultEntity();
		if (equipmentId==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = equipmentClassificationService.deleteEquipment(equipmentId);
        return resultEntity;
    }
	
	@RequestMapping(value = "/findByEquipmentId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询设备分类详情", notes = "查询设备分类详情")
    public PageResultEntity findByEquipmentId(@RequestParam String equipmentId) {
		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(equipmentId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中查看的数据");
			return resultEntity;
		}
		resultEntity = equipmentClassificationService.findByEquipmentId(equipmentId);
        return resultEntity;
    }
	
	@RequestMapping(value = "/deleteEquipments", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除设备分类", notes = "批量删除设备分类")
    public ResultEntity deleteEquipments(@RequestParam List<String> equipmentIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (equipmentIds==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = equipmentClassificationService.deleteEquipments(equipmentIds);
        return resultEntity;
    }
	
	@RequestMapping(value = "/findStructure", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备分类顶层结构", notes = " 获取设备分类顶层结构")
	public PageResultEntity findStructure(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize
			){
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		equipmentExample.setPageSize(pageSize);
		equipmentExample.setPageNo(pageNum);
		resultEntity = equipmentClassificationService.findStructure();
		return resultEntity;
	}
	@RequestMapping(value = "/findStructureList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备分类结构", notes = " 获取设备分类结构")
	public PageResultEntity findStructureList(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = true) String superiorEquipment){
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		equipmentExample.setPageSize(pageSize);
		equipmentExample.setPageNo(pageNum);
		resultEntity = equipmentClassificationService.findStructureList(superiorEquipment);
		return resultEntity;
	}
}
