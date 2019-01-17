package com.qz.zframe.device.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.qz.zframe.device.service.PositionEncodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/support/device")
@Api(tags = "api-support-device", description = "设备-设备分类")
public class EquipmentClassificationController {

	private static Logger logger = LoggerFactory.getLogger(EquipmentClassificationController.class);
	
	@Autowired
	private EquipmentClassificationService equipmentClassificationService;

	@Autowired
	private PositionEncodeService positionEncodeService;

	/**
	 * 获取设备信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param typeName  分类名称
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/findEquipment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备信息", notes = " 获取设备信息")
	public PageResultEntity findEquipment(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
	        @ApiParam(name="equipmentType",value="设备分类名称",required=false)String equipmentType){
		
		logger.info("===== 设备-设备分类EquipmentClassificationController.findEquipment ===== equipmentType:"+equipmentType);
		
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		equipmentExample.setPageSize(pageSize);
		equipmentExample.setPageNo(pageNum);
		equipmentExample.setOrderByClause("create_time asc");
		Criteria criteria =equipmentExample.createCriteria();
		if (StringUtils.isNotBlank(equipmentType) ){
			criteria.andEquipmentTypeLike(equipmentType);
		}
		resultEntity = equipmentClassificationService.findEquipment(equipmentExample);
		return resultEntity;
	}
	/**
	 * 新增设备分类
	 */
	@RequestMapping(value = "/addEquipment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增设备分类", notes = "新增设备分类")
    public ResultEntity addEquipment(@RequestBody EquipmentClassification equipmentClassification) {
		
		logger.info("===== 设备-设备分类EquipmentClassificationController.addEquipment ===== EquipmentClassification:"+equipmentClassification);
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(equipmentClassification.getEquipmentType())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备分类必要字段");
			return resultEntity;
		} 
		resultEntity = equipmentClassificationService.addEquipment(equipmentClassification);
        return resultEntity;
    }
	
	@RequestMapping(value = "/updateEquipment", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改设备分类", notes = "修改设备分类")
    public ResultEntity updateEquipment(@RequestBody EquipmentClassification equipmentClassification) {
		
		logger.info("===== 设备-设备分类EquipmentClassificationController.updateEquipment ===== EquipmentClassification:"+equipmentClassification);
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(equipmentClassification.getEquipmentType())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备分类必要字段");
		     return resultEntity;
		} 
		if(	StringUtils.isBlank(equipmentClassification.getEquipmentId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据进行编辑");
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
    public PageResultEntity findByEquipmentId(@RequestParam(required = true)@ApiParam(name="equipmentId",value="设备分类id",required=true) String equipmentId) {
		
		logger.info("===== 设备-设备分类EquipmentClassificationController.findByEquipmentId ===== equipmentId:"+equipmentId);
		
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
    public ResultEntity deleteEquipments(@RequestParam(required = true) List<String> equipmentIds) {
		
		logger.info("===== 设备-设备分类EquipmentClassificationController.deleteEquipments===== equipmentIds:"+equipmentIds);
		
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
	public PageResultEntity findStructure(){
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		resultEntity = equipmentClassificationService.findStructure();
		return resultEntity;
	}
	@RequestMapping(value = "/findStructureList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备分类结构", notes = " 获取设备分类结构")
	public PageResultEntity findStructureList(
			@RequestParam(required = true) String equipmentId){
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		resultEntity = equipmentClassificationService.findStructureList(equipmentId);
		return resultEntity;
	}
}
