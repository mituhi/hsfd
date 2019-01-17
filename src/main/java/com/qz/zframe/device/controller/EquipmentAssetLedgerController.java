package com.qz.zframe.device.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.RegexUtils;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample.Criteria;
import com.qz.zframe.device.service.EquipmentAssetLedgerService;
import com.qz.zframe.file.FileException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/ledger")
@Api(tags = {"api-support-device-ledger"}, description = "设备-设备资产台账")
public class EquipmentAssetLedgerController {
	
	private static Logger logger = LoggerFactory.getLogger(EquipmentAssetLedgerController.class);
	
	@Autowired
	private  EquipmentAssetLedgerService  equipmentAssetLedgerService;
	
	@Autowired
	private CommonService commonService;
	
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
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/findAssetLedger", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备资产台账信息", notes = " 获取设备资产台账信息")
	public PageResultEntity findAssetLedger(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="equipmentName",value="设备名称",required=false)String equipmentName,
            @RequestParam(required = false)
            @ApiParam(name="supplier",value="供应商",required=false)String supplier,
            @RequestParam(required = false)
            @ApiParam(name="windId",value="风电场",required=false)String windId,
            @RequestParam(required = false)
            @ApiParam(name="windId2",value="风电场",required=false)String windId2,
            @RequestParam(required = false)
            @ApiParam(name="assetStatus",value="资产状态",required=false)String assetStatus,
            @RequestParam(required = false)
            @ApiParam(name="crew",value="机组",required=false)String crew,
            @RequestParam(required = false)
    		@ApiParam(name="equipmentId",value="设备分类",required=false)String equipmentId,
    		@RequestParam(required = false)
	  		@ApiParam(name="dateDelivery",value="投运日期",required=false)String dateDelivery,
	  		@RequestParam(required = false)
			@ApiParam(name="dateDelivery2",value="投运日期",required=false)String dateDelivery2) throws ParseException {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findAssetLedger =====equipmentName:"+equipmentName
				+"supplier:"+supplier+"windId:"+windId+"assetStatus:"+assetStatus+"crew:"+crew+"equipmentId:"+equipmentId+"dateDelivery:"+dateDelivery,dateDelivery);
		
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentAssetLedgerExample assetLedgerExample=new EquipmentAssetLedgerExample();
		assetLedgerExample.setPageNo(pageNum);
		assetLedgerExample.setPageSize(pageSize);
		assetLedgerExample.setOrderByClause("e.equipment_code asc");
		Criteria criteria =assetLedgerExample.createCriteria();
		if (StringUtils.isNotBlank(equipmentName) ){
			criteria.andEquipmentNameLike(equipmentName);
		}
		if (StringUtils.isNotBlank(supplier) ){
			criteria.andSupplierLike(supplier);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isBlank(windId2)){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId2)){
			criteria.andWindIdBetween(windId,windId2);
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
		if(StringUtils.isNotBlank(dateDelivery)  && StringUtils.isBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery);
			criteria.andDateDeliveryEqualTo(date);
		}
		if(StringUtils.isBlank(dateDelivery)  && StringUtils.isNotBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryLessThanOrEqualTo(date);
		}
		if (StringUtils.isNotBlank(dateDelivery) && StringUtils.isNotBlank(dateDelivery2) ){
			Date date= DateUtil.getStringToDate(dateDelivery);
			Date date2= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryBetween(date,date2);
		}
		/*if (dateDelivery!=null ){
			criteria.andDateDeliveryEqualTo(dateDelivery2);
		}*/
		resultEntity =equipmentAssetLedgerService.findAssetLedger(assetLedgerExample);
		return resultEntity;
	}
    @ResponseBody
	@RequestMapping(value = "/addAssetLedger", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增设备资产台账信息", notes = "新增设备资产台账信息")
	public ResultEntity addAssetLedger(@RequestBody EquipmentAssetLedger assetLedger) {
    	//, produces = MediaType.APPLICATION_JSON_UTF8_VALUE
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.addAssetLedger =====EquipmentAssetLedger:"+assetLedger);
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(assetLedger.getEquipmentCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备编码必要字段");
			return resultEntity;
		} 
       if(StringUtils.isBlank(assetLedger.getEquipmentId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备分类必要字段");
			return resultEntity;
        } 
		if(StringUtils.isBlank(assetLedger.getPositionId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少位置位置必要字段");
			return resultEntity;
		} 
        if(StringUtils.isBlank(assetLedger.getWindId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少风电场必要字段");
			return resultEntity;
        } 
        if(StringUtils.isBlank(assetLedger.getAssetStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少资产状态必要字段");
			return resultEntity;
		}
        if(StringUtils.isBlank(assetLedger.getEquipmentName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备名称必要字段");
			return resultEntity;
		}
        if(StringUtils.isNotBlank(assetLedger.getAssetValue().toString())) {
			boolean check1 = RegexUtils.checkDecimals(assetLedger.getAssetValue().toString());
			if(check1==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("资产原值填入的数据有误，请重新填写,资产原值需要填入数字加小数格式的数据");
				return resultEntity;
			}
        }
		if(StringUtils.isNotBlank(assetLedger.getMonthlyDepreciationRate().toString())) {
				boolean check2 = RegexUtils.checkDecimals(assetLedger.getAssetValue().toString());
				if(check2==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("月折旧率填入的数据有误，请重新填写,月折旧率需要填入数字加小数格式的数据");
				return resultEntity;
		}
		}
		resultEntity =equipmentAssetLedgerService.addAssetLedger(assetLedger);
		return resultEntity;
	}

	@RequestMapping(value = "/updateAssetLedger", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改设备资产台账信息", notes = "修改设备资产台账信息")
	public ResultEntity updateAssetLedger(@RequestBody EquipmentAssetLedger assetLedger) throws Exception {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.updateAssetLedger =====EquipmentAssetLedger:"+assetLedger);
		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(assetLedger.getEquipmentCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备编码必要字段");
			return resultEntity;
		} 
        if(StringUtils.isBlank(assetLedger.getEquipmentId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备分类必要字段");
			return resultEntity;
        } 
		if(StringUtils.isBlank(assetLedger.getPositionId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少位置位置必要字段");
			return resultEntity;
		} 
        if(StringUtils.isBlank(assetLedger.getWindId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少风电场必要字段");
			return resultEntity;
        } 
        if(StringUtils.isBlank(assetLedger.getAssetStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少资产状态必要字段");
			return resultEntity;
		}
		if(StringUtils.isBlank(assetLedger.getEquipmentAssetId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选中数据进行编辑");
				return resultEntity;
		}
		if(StringUtils.isBlank(assetLedger.getEquipmentName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少设备名称必要字段");
			return resultEntity;
		}
		if(StringUtils.isNotBlank(assetLedger.getAssetValue().toString())) {
			boolean check1 = RegexUtils.checkDecimals(assetLedger.getAssetValue().toString());
			if(check1==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("资产原值填入的数据有误，请重新填写,资产原值需要填入数字加小数格式的数据");
				return resultEntity;
			}
        }
		if(StringUtils.isNotBlank(assetLedger.getMonthlyDepreciationRate().toString())) {
				boolean check2 = RegexUtils.checkDecimals(assetLedger.getAssetValue().toString());
				if(check2==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("月折旧率填入的数据有误，请重新填写,月折旧率需要填入数字加小数格式的数据");
				return resultEntity;
		}
		}
		resultEntity =equipmentAssetLedgerService.updateAssetLedger(assetLedger);
		return resultEntity;
	}

	@RequestMapping(value = "/findByEquipmentAssetId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "查询设备资产台账详情", notes = "查询设备资产台账详情")
	public PageResultEntity findByEquipmentAssetId(
			@RequestParam(required = true) @ApiParam(name = "equipmentAssetId", value = "设备资产台账id", required = true) String equipmentAssetId)
			throws FileException {

		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findByEquipmentAssetId =====equipmentAssetId:"
				+ equipmentAssetId);

		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(equipmentAssetId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中编辑的数据");
			return resultEntity;
		} else {
			resultEntity = equipmentAssetLedgerService.findByEquipmentAssetId(equipmentAssetId);
		}
		return resultEntity;
	}

	@RequestMapping(value = "/deleteAssetLedger", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除设备资产台账信息", notes = "批量删除设备资产台账信息")
	public ResultEntity deleteAssetLedger(@RequestParam(required = true) List<String> equipmentAssetIds) throws Exception {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findByEquipmentAssetId =====equipmentAssetIds:"+equipmentAssetIds);
		
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
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/findChange", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 设备资产台账信息变动查询", notes = " 设备资产台账信息变动查询")
	public PageResultEntity findChange(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="equipmentName",value="设备名称",required=false)String equipmentName,
            @RequestParam(required = false)
            @ApiParam(name="supplier",value="供应商",required=false)String supplier,
            @RequestParam(required = false)
            @ApiParam(name="windId",value="风电场",required=false)String windId,
            @RequestParam(required = false)
            @ApiParam(name="windId2",value="风电场",required=false)String windId2,
            @RequestParam(required = false)
            @ApiParam(name="assetStatus",value="资产状态",required=false)String assetStatus,
            @RequestParam(required = false)
            @ApiParam(name="crew",value="机组",required=false)String crew,
            @RequestParam(required = false)
    		@ApiParam(name="equipmentId",value="设备分类",required=false)String equipmentId,
    		@RequestParam(required = false)
	  		@ApiParam(name="dateDelivery",value="投运日期",required=false)String dateDelivery,
	  		@RequestParam(required = false)
			@ApiParam(name="dateDelivery2",value="投运日期",required=false)String dateDelivery2) throws ParseException {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findChange =====equipmentName:"+equipmentName
				+"supplier:"+supplier+"windId:"+windId+"assetStatus:"+assetStatus+"crew:"+crew+"equipmentId:"+equipmentId+"dateDelivery:"+dateDelivery,dateDelivery);
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
		if (StringUtils.isNotBlank(windId) && StringUtils.isBlank(windId2)){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId2)){
			criteria.andWindIdBetween(windId,windId2);
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
		if(StringUtils.isNotBlank(dateDelivery)  && StringUtils.isBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery);
			criteria.andDateDeliveryEqualTo(date);
		}
		if(StringUtils.isBlank(dateDelivery)  && StringUtils.isNotBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryLessThanOrEqualTo(date);
		}
		if (StringUtils.isNotBlank(dateDelivery) && StringUtils.isNotBlank(dateDelivery2) ){
			Date date= DateUtil.getStringToDate(dateDelivery);
			Date date2= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryBetween(date,date2);
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
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findById =====equipmentAssetId:"+equipmentAssetId);
		
		PageResultEntity resultEntity=new PageResultEntity();
		resultEntity =equipmentAssetLedgerService.findById(equipmentAssetId);
		return resultEntity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResultEntity upload(MultipartFile file, HttpServletRequest request)
			throws Exception {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.upload =====file:"+file);
		ResultEntity resultEntity = new ResultEntity();
		SpFileUpload map = commonService.fileUpload(file, "01");
		if (map != null) {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(map);
			resultEntity.setMsg("上传成功");
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("上传失败");
		return resultEntity;
	}
	
	/*@ApiOperation(value = "删除ftp文件", notes = "删除ftp文件")
	@RequestMapping(value = "removeFile", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity removeFile(@RequestParam(required = true)
			@ApiParam(name="fileId",value="文件id",required=true)String fileId) throws Exception {
		logger.info("===== 删除ftp文件 CommonController.deleteCodeType ===== fileId:"+fileId);
		return commonService.removeFile(fileId);
	}*/
	
	@RequestMapping(value = "/findChangeExcel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 导出设备资产台账信息变动查询", notes = " 导出设备资产台账信息变动查询")
	public String ExportExcl(
			HttpServletResponse response,
	        @RequestParam(required = false,defaultValue = "设备资产台账信息变动查询信息")String sheetName,
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
	  		@ApiParam(name="dateDelivery",value="投运日期",required=false)String dateDelivery,
	  		@RequestParam(required = false)
			@ApiParam(name="dateDelivery2",value="投运日期",required=false)String dateDelivery2) throws Exception {
		
		logger.info("===== 设备-设备资产台账EquipmentAssetLedgerController.findChange =====equipmentName:"+equipmentName
				+"supplier:"+supplier+"windId:"+windId+"assetStatus:"+assetStatus+"crew:"+crew+"equipmentId:"+equipmentId+"dateDelivery:"+dateDelivery,dateDelivery);
		EquipmentAssetLedgerExample assetLedgerExample=new EquipmentAssetLedgerExample();
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
		if(StringUtils.isNotBlank(dateDelivery)  && StringUtils.isBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery);
			criteria.andDateDeliveryEqualTo(date);
		}
		if(StringUtils.isBlank(dateDelivery)  && StringUtils.isNotBlank(dateDelivery2)) {
			Date date= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryLessThan(date);
		}
		if (StringUtils.isNotBlank(dateDelivery) && StringUtils.isNotBlank(dateDelivery2) ){
			Date date= DateUtil.getStringToDate(dateDelivery);
			Date date2= DateUtil.getStringToDate(dateDelivery2);
			criteria.andDateDeliveryBetween(date,date2);
		}
		return 	equipmentAssetLedgerService.ExportExcl(assetLedgerExample, response, sheetName);
	
}
	
	
	@ApiOperation(value = "删除ftp文件", notes = "删除ftp文件")
	@RequestMapping(value = "removeFiles", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity removeFile(@RequestParam(required = true)
			@ApiParam(name="fileId",value="文件id",required=true)List<String> fileId) throws Exception  {
		logger.info("===== 删除ftp文件 CommonController.deleteCodeType ===== fileId:"+fileId);
		ResultEntity resultEntity=new ResultEntity();
		if(fileId==null && fileId.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除文件的id为空");
			return  resultEntity;
		}else {																												
			resultEntity=equipmentAssetLedgerService.removeFile(fileId);
		}
		return resultEntity;
	}
	@RequestMapping(value = "/closeDown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "关闭", notes = "关闭")
	public ResultEntity  closeDown(@RequestBody EquipmentAssetLedger assetLedger) throws Exception {
		
		logger.info("===== 关闭EquipmentAssetLedgerController.closeDown =====EquipmentAssetLedger:"+assetLedger);
		ResultEntity  resultEntity=new  ResultEntity();
		if(assetLedger!=null) {
		    resultEntity=equipmentAssetLedgerService.closeDown(assetLedger);
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据为空");
			return  resultEntity;
		}
		 return resultEntity;
	}
}