package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample.Criteria;
import com.qz.zframe.device.service.EquipmentAssetLedgerService;
import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.DeviceAssociationExample;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.MainEquipmentInfoExample;
import com.qz.zframe.run.entity.result.DeviceAssociationResult;
import com.qz.zframe.run.entity.submit.MainEquipmentSubmit;
import com.qz.zframe.run.service.DeviceAssociationService;
import com.qz.zframe.run.service.LogTypeService;
import com.qz.zframe.run.service.MainEquipmentInfoService;
import com.qz.zframe.run.service.MainEquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: MainEquipmentController</p>
 * <p>@Description: 电厂主设备配置Controller层 </p>
 * @author 
 * @date 2018年11月12日 上午10:32:28
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/MainEquipment")
@Api(tags = "api-support-api-support-MainEquipment", description = "运行-日志管理-配置-电厂主设备配置")
public class MainEquipmentController {
	
	@Autowired
	private MainEquipmentService mainEquipmentService;
	
	@Autowired
	private MainEquipmentInfoService mainEquipmentInfoService;
	
	@Autowired
	private DeviceAssociationService deviceAssociationService;
	@Autowired
	private  EquipmentAssetLedgerService  equipmentAssetLedgerService;
	@Autowired
	private LogTypeService logTypeService;
	
	@RequestMapping(value="/saveMainEquipment",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="保存电厂主设备信息",value="保存电厂主设备信息")
	public ResultEntity saveMainEquipment(@RequestBody MainEquipment mainEquipment){
		ResultEntity resultEntity = new ResultEntity();
		if(mainEquipment==null ) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据为空，不能添加");
			return resultEntity;
		}else {
			if( StringUtils.isBlank(mainEquipment.getLogTypeId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("请选择日志类型");
				return resultEntity;
			}
			resultEntity=mainEquipmentService.saveMainEquipment(mainEquipment);
		    return resultEntity;
		
		}
	}
	
	
	
/*	*//**
	 * @Description:勾选，上传设备关联表ids，进行删除
	 * @param: @param deviceAssociationIds
	 * @param: @return   
	 * @return: ResultEntity
	 *//*
	@RequestMapping(value="/removeMainEquipment",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="移除电厂主设备",value="移除电厂主设备")
	public ResultEntity removeMainEquipment(@RequestParam @ApiParam(name="deviceAssociationIds",value="勾选的deviceAssociationIds") List<String> deviceAssociationIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果集合为空
		if(CollectionUtils.isEmpty(deviceAssociationIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少删除主键");
			return resultEntity;
		}
		
		//数据正常；调用接口删除
		for (String deviceAssociationId : deviceAssociationIds) {
			resultEntity = deviceAssociationService.deleteDeviceAssociationById(deviceAssociationId);
		}
		
		return resultEntity;
	}*/
	
	
	/**
	 * @Description:加载主界面数据
	 * @param: @param searchKey
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value="/listMainEquipment",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="加载主界面数据",value="加载主界面数据")
	public PageResultEntity listMainEquipment(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		 PageResultEntity   resultEntity=new PageResultEntity();
		 MainEquipmentExample equipmentExample=new MainEquipmentExample();
		 equipmentExample.setPageNo(pageNum);
		 equipmentExample.setPageSize(pageSize);
	    com.qz.zframe.run.entity.MainEquipmentExample.Criteria criteria =equipmentExample.createCriteria();
		//如果选择了风电场模糊查询
		if(StringUtils.isNotBlank(searchKey)){
			criteria.andDepartmentLike(searchKey);
		}
		
	    resultEntity=mainEquipmentService.listMainEquipments(equipmentExample);
		return resultEntity;
	}
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			HttpServletResponse response) {
		
		MainEquipment mainEquipment = new MainEquipment();
		
		//如果选择了风电场模糊查询
		if(StringUtils.isNotBlank(searchKey)){
			mainEquipment.setDepartment(searchKey);
		}
		
		PageResultEntity pageResultEntity = deviceAssociationService.listDeviceAssociation(mainEquipment, 0, 0);
		
		List<DeviceAssociationResult> list =  pageResultEntity.getRows();
		
		 
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("department", "电厂名称");
		testMap.put("logType", "日志类型");
		testMap.put("logName", "日志名称");
		testMap.put("count", "设备数量");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "主设备配置", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:点击更新获取一次数据
	 * @param: @param mainEquipmentId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/getMainEquipment",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="根据id 查询详情",value="根据id 查询详情")
	public PageResultEntity getMainEquipment(@RequestParam @ApiParam(name="mainEquipmentId",value="选择的mainEquipmentId") String mainEquipmentId){
		
		PageResultEntity resultEntity = new PageResultEntity();
		if(StringUtils.isBlank(mainEquipmentId)) {
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("未选中id,无法查询结果");
			return resultEntity;
		}else {
			resultEntity=	mainEquipmentService.getMainEquipmentById(mainEquipmentId);
		
		return resultEntity;
		}
	}
	
	
	/**
	 * @Description:点击查看获取一次数据
	 * @param: @param deviceAssociationId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	/*@RequestMapping(value="/viewMainEquipment",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="点击查看：获取对应信息 ",value="点击查看：获取对应信息 ")
	public ResultEntity viewMainEquipment(@RequestParam @ApiParam(name="deviceAssociationId",value="选择的deviceAssociationId") String deviceAssociationId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//创建返回的对象
		MainEquipmentSubmit mainEquipmentSubmit = new MainEquipmentSubmit();
		
		//如果为空返回错误
		if(StringUtils.isBlank(deviceAssociationId)){
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		//如果字段正常
		//通过deviceAssociationId获取对象信息
		DeviceAssociation deviceAssociation = deviceAssociationService.getDeviceAssociationbyId(deviceAssociationId);
		//获取主设备表id
		String mainEquipmentId = deviceAssociation.getMainEquipmentId();
		//通过主设备id获取主设备信息
		MainEquipment mainEquipment = mainEquipmentService.getMainEquipmentById(mainEquipmentId);
		//设置到返回对象中
		mainEquipmentSubmit.setDepartment(mainEquipment.getDepartment());
		mainEquipmentSubmit.setLogName(mainEquipment.getLogName());
		mainEquipmentSubmit.setLogType(mainEquipment.getLogType());
		mainEquipmentSubmit.setLogTypeId(mainEquipment.getLogTypeId());
		//通过主设备表id获取主设备信息表id
		List<DeviceAssociation> list = deviceAssociationService.getgetDeviceAssociationbyMainEqId(mainEquipmentId);
		
		//声明返回对象里的属性
		List<MainEquipmentInfo> equipmentInfos = new ArrayList<MainEquipmentInfo>();
		if(equipmentInfos==null && equipmentInfos.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("执行失败");
			return resultEntity;
		}
		for (DeviceAssociation deviceAssociationTemp : list) {
			//获取主设备信息表id
			String mainEquipmentInfoId = deviceAssociationTemp.getMainEquipmentInfoId();
			//通过id获取对象
			MainEquipmentInfo mainEquipmentInfo = mainEquipmentInfoService.getMainEquipmentInfoById(mainEquipmentInfoId);
			equipmentInfos.add(mainEquipmentInfo);
		}
		//设置到返回对象中
		mainEquipmentSubmit.setEquipmentInfos(equipmentInfos);
		resultEntity.setCode(ErrorCode.SUCCESS);	
		resultEntity.setMsg("执行成功");
		resultEntity.setData(mainEquipmentSubmit);
		return resultEntity;
	}*/
	
	
	
	/***********************在更新界面勾选删除主设备信息表*****************************/
	@RequestMapping(value="/removeMainEquipmentInfo",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="移除电厂主设备信息表",value="移除电厂主设备信息表")
	public ResultEntity removeMainEquipmentInfo(@RequestParam @ApiParam(name="mainEquipmentIds",value="勾选的mainEquipmentIds")List<String> mainEquipmentIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//检查字段
		if(CollectionUtils.isEmpty(mainEquipmentIds)){
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
	
		resultEntity=mainEquipmentService.delete(mainEquipmentIds);
		
		return resultEntity;
	}
	
	
	
	
	
	@RequestMapping(value="/editMainEquipment",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="编辑电厂主设备",value="编辑电厂主设备")
	public ResultEntity editMainEquipment(@RequestBody MainEquipment mainEquipment){
		
		ResultEntity resultEntity = new ResultEntity();
		if(mainEquipment!=null) {
			resultEntity=mainEquipmentService.updateMainEquipment(mainEquipment);
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("编辑数据为空");
			return resultEntity;
		}
		return resultEntity;
	}
	@RequestMapping(value = "/findAssetLedgerAndRun", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备资产台账信息", notes = " 获取设备资产台账信息")
	public PageResultEntity findAssetLedger(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="windId",value="风电场编码",required=false)String windId,
            @RequestParam(required = false)
            @ApiParam(name="equipmentCode",value="设备编码",required=false)String equipmentCode,
            @RequestParam(required = false)
            @ApiParam(name="equipmentName",value="设备名称",required=false)String equipmentName
           ) throws ParseException {
		PageResultEntity resultEntity = new PageResultEntity();
		EquipmentAssetLedgerExample assetLedgerExample=new EquipmentAssetLedgerExample();
		assetLedgerExample.setPageNo(pageNum);
		assetLedgerExample.setPageSize(pageSize);
		
		Criteria criteria =assetLedgerExample.createCriteria();
		if (StringUtils.isNotBlank(windId) ){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(equipmentCode) ){
			criteria.andEquipmentCodeLike(equipmentCode);
		}
		if (StringUtils.isNotBlank(equipmentName) ){
			criteria.andEquipmentNameLike(equipmentName);
		}
		resultEntity =equipmentAssetLedgerService.selectByWindId(assetLedgerExample);
		return resultEntity;
	}
}
