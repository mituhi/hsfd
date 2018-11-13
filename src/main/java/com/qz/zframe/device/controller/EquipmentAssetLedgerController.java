package com.qz.zframe.device.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample.Criteria;
import com.qz.zframe.device.service.EquipmentAssetLedgerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/ledger")
@Api(tags = {"api-support-device-ledger"}, description = "设备-设备资产台账")
public class EquipmentAssetLedgerController {
	@Autowired
	private  EquipmentAssetLedgerService  equipmentAssetLedgerService;
	/**
	 * 设备资产台账 
	 * @param pageNum
	 * @param pageSize
	 * @param equipmentName  设备名称
	 * @param supplier  供应商
	 * @param windId  所属风电场
	 * assetStatus  资产状态
	 * crew   机组
	 * equipmentId  设备分类
	 * dateDelivery  投运日期
	 */
	@RequestMapping(value = "/findAssetLedger", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备资产台账信息", notes = " 获取设备资产台账信息")
	public PageResultEntity findAssetLedger(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="equipmentName",value="设备名称",required=false)String equipmentName,
            @RequestParam(required = false)
            @ApiParam(name="supplier",value="供应商",required=false)String supplier,
            @RequestParam(required = false)
            @ApiParam(name="windId",value="风电场",required=false)String windId,
            @RequestParam(required = false)
            @ApiParam(name="assetStatus",value="资产状态",required=false)String assetStatus,
            @RequestParam(required = false)
            @ApiParam(name="crew",value="机组",required=false)String crew,
            @RequestParam(required = false)
    		@ApiParam(name="equipmentId",value="设备分类",required=false)String equipmentId,
    		@RequestParam(required = false)
	  		@ApiParam(name="dateDelivery",value="投运日期",required=false)Date dateDelivery,
	  		@RequestParam(required = false)
			@ApiParam(name="dateDelivery",value="投运日期",required=false)Date dateDelivery2) {
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentAssetLedgerExample assetLedgerExample=new EquipmentAssetLedgerExample();
		assetLedgerExample.setPageNo(pageNum);
		assetLedgerExample.setPageSize(pageSize);
		assetLedgerExample.setOrderByClause("date_delivery asc");
		Criteria criteria =assetLedgerExample.createCriteria();
		if (StringUtils.isNotBlank(equipmentName) ){
			criteria.andEquipmentNameLike(equipmentName);
		}
		if (StringUtils.isNotBlank(supplier) ){
			criteria.andSupplierLike(supplier);
		}
		if (StringUtils.isNotBlank(windId) ){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(assetStatus) ){
			criteria.andAssetStatusEqualTo(assetStatus);
		}
		if (StringUtils.isNotBlank(crew) ){
			criteria.andCrewEqualTo(crew);
		}
		if (StringUtils.isNotBlank(equipmentId) ){
			criteria.andEquipmentIdEqualTo(equipmentId);
		}
		if (dateDelivery!=null){
			criteria.andDateDeliveryBetween(dateDelivery,dateDelivery2);
		}
		/*if (dateDelivery!=null ){
			criteria.andDateDeliveryEqualTo(dateDelivery2);
		}*/
		resultEntity =equipmentAssetLedgerService.findAssetLedger(assetLedgerExample);
		return resultEntity;
	}

	@RequestMapping(value = "/addAssetLedger", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增设备资产台账信息", notes = "新增设备资产台账信息")
	public ResultEntity addAssetLedger(@RequestBody EquipmentAssetLedger assetLedger) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(assetLedger.getEquipmentCode()) || StringUtils.isBlank(assetLedger.getEquipmentId()) || 
			StringUtils.isBlank(assetLedger.getPositionId()) || StringUtils.isBlank(assetLedger.getWindId()) ||StringUtils.isBlank(assetLedger.getAssetStatus())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
		}
		resultEntity =equipmentAssetLedgerService.addAssetLedger(assetLedger);
		return resultEntity;
	}

	@RequestMapping(value = "/updateAssetLedger", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改设备资产台账信息", notes = "修改设备资产台账信息")
	public ResultEntity updateAssetLedger(@RequestBody EquipmentAssetLedger assetLedger) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(assetLedger.getEquipmentCode()) || StringUtils.isBlank(assetLedger.getEquipmentId()) || 
				StringUtils.isBlank(assetLedger.getPositionId()) || StringUtils.isBlank(assetLedger.getWindId()) ||StringUtils.isBlank(assetLedger.getAssetStatus())){
				
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少必要字段");
			}
		resultEntity =equipmentAssetLedgerService.updateAssetLedger(assetLedger);
		return resultEntity;
	}

	@RequestMapping(value = "/findByEquipmentAssetId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询设备资产台账详情", notes = "查询设备资产台账详情")
	public PageResultEntity findByEquipmentAssetId(@RequestParam(required = true)
	@ApiParam(name="equipmentAssetId",value="设备资产台账id",required=true)String equipmentAssetId) {
		PageResultEntity resultEntity=new PageResultEntity();
		resultEntity =equipmentAssetLedgerService.findByEquipmentAssetId(equipmentAssetId);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteCrew", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除设备资产台账信息", notes = "批量删除设备资产台账信息")
	public ResultEntity deleteAssetLedger(@RequestBody List<String> equipmentAssetIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (equipmentAssetIds==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = equipmentAssetLedgerService.deleteAssetLedger(equipmentAssetIds);
	return resultEntity;
	}
	
	/**
	 * 设备资产台账 
	 * @param pageNum
	 * @param pageSize
	 * @param equipmentName  设备名称
	 * @param supplier  供应商
	 * @param windId  所属风电场
	 * assetStatus  资产状态
	 * crew   机组
	 * equipmentId  设备分类
	 * dateDelivery  投运日期
	 */
	@RequestMapping(value = "/findChange", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 设备资产台账信息变动查询", notes = " 设备资产台账信息变动查询")
	public PageResultEntity findChange(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="equipmentName",value="设备名称",required=false)String equipmentName,
            @RequestParam(required = false)
            @ApiParam(name="supplier",value="供应商",required=false)String supplier,
            @RequestParam(required = false)
            @ApiParam(name="windId",value="风电场",required=false)String windId,
            @RequestParam(required = false)
            @ApiParam(name="assetStatus",value="资产状态",required=false)String assetStatus,
            @RequestParam(required = false)
            @ApiParam(name="crew",value="机组",required=false)String crew,
            @RequestParam(required = false)
    		@ApiParam(name="equipmentId",value="设备分类",required=false)String equipmentId,
    		@RequestParam(required = false)
	  		@ApiParam(name="dateDelivery",value="投运日期",required=false)Date dateDelivery,
	  		@RequestParam(required = false)
			@ApiParam(name="dateDelivery",value="投运日期",required=false)Date dateDelivery2) {
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentAssetLedgerExample assetLedgerExample=new EquipmentAssetLedgerExample();
		assetLedgerExample.setPageNo(pageNum);
		assetLedgerExample.setPageSize(pageSize);
		assetLedgerExample.setOrderByClause("asset_status_date desc");
		Criteria criteria =assetLedgerExample.createCriteria();
		if (StringUtils.isNotBlank(equipmentName) ){
			criteria.andEquipmentNameLike(equipmentName);
		}
		if (StringUtils.isNotBlank(supplier) ){
			criteria.andSupplierLike(supplier);
		}
		if (StringUtils.isNotBlank(windId) ){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(assetStatus) ){
			criteria.andAssetStatusEqualTo(assetStatus);
		}
		if (StringUtils.isNotBlank(crew) ){
			criteria.andCrewEqualTo(crew);
		}
		if (StringUtils.isNotBlank(equipmentId) ){
			criteria.andEquipmentIdEqualTo(equipmentId);
		}
		if (dateDelivery!=null){
			criteria.andDateDeliveryBetween(dateDelivery,dateDelivery2);
		}
		/*if (dateDelivery!=null ){
			criteria.andDateDeliveryEqualTo(dateDelivery2);
		}*/
		resultEntity =equipmentAssetLedgerService.findChange(assetLedgerExample);
		return resultEntity;
}
	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询设备资产台账变动详情", notes = "查询设备资产台账变动详情")
	public PageResultEntity findBysId(@RequestParam(required = true)
	@ApiParam(name="equipmentAssetId",value="设备资产台账id",required=true)String equipmentAssetId) {
		PageResultEntity resultEntity=new PageResultEntity();
		resultEntity =equipmentAssetLedgerService.findById(equipmentAssetId);
		return resultEntity;
	}
}