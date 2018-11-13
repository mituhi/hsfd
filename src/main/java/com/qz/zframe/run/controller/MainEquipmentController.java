package com.qz.zframe.run.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.BaseResultEntity;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.result.DeviceAssociationResult;
import com.qz.zframe.run.entity.submit.MainEquipmentSubmit;
import com.qz.zframe.run.service.DeviceAssociationService;
import com.qz.zframe.run.service.MainEquipmentInfoService;
import com.qz.zframe.run.service.MainEquipmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: MainEquipmentController</p>
 * <p>@Description: 电厂主设备配置Controller层 </p>
 * @author 陈汇奇
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
	
	@RequestMapping(value="/saveMainEquipment",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="保存电厂主设备信息",value="保存电厂主设备信息")
	public ResultEntity saveMainEquipment(@RequestBody MainEquipmentSubmit mainEquipmentSubmit){
										//还需要有主设备信息内容上传（这个是集合）
		
		ResultEntity resultEntity = new ResultEntity();
		
		//从提交的数据中获取主设备对象
		MainEquipment mainEquipment = mainEquipmentSubmit.getMainEquipment();
		
		//从提交的数据中获取主设备信息对象
		List<MainEquipmentInfo> equipmentInfos = mainEquipmentSubmit.getEquipmentInfos();
		
		//检查电厂主设备字段
		if(StringUtils.isBlank(mainEquipment.getDepartment())
				||StringUtils.isBlank(mainEquipment.getLogType())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("电厂主设备缺少字段");
			return resultEntity;
		}
		
		//检查主设备信息字段....
		for (MainEquipmentInfo mainEquipmentInfo : equipmentInfos) {
			if(StringUtils.isBlank(mainEquipmentInfo.getDeviceCode())
					||StringUtils.isBlank(mainEquipmentInfo.getDeviceName())
					||StringUtils.isBlank(mainEquipmentInfo.getDeviceType())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("电厂主设备信息缺少字段");
				return resultEntity;
			}
			
		}
		
		
		//字段完整
		//设置电厂主设备id
		String mianEquipmentId = UUID.randomUUID().toString();
		mainEquipment.setMainEquipmentId(mianEquipmentId);
		//执行插入操作
		resultEntity = mainEquipmentService.saveMainEquipment(mainEquipment);
		
		if(resultEntity.getCode() !=ErrorCode.SUCCESS){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("插入电厂主设备失败");
			return resultEntity;
		}
		
		
		//插入成功之后：对主设备信息进行插入数据库
		//保存设备信息id集合
		List<String> mainEquipmentInfoIds = new ArrayList<String>();
		for (MainEquipmentInfo mainEquipmentInfo : equipmentInfos) {
			 //设置id
			 String mainEquipmentInfoId = UUID.randomUUID().toString(); 
			 mainEquipmentInfo.setMainEquipmentInfoId(mainEquipmentInfoId);
			 mainEquipmentInfoIds.add(mainEquipmentInfoId);
			 resultEntity = mainEquipmentInfoService.saveMainEquipmentInfo(mainEquipmentInfo);
		}
		
		if(resultEntity.getCode() !=ErrorCode.SUCCESS){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("插入主设备信息失败");
			return resultEntity;
		}
		
		//之前的都执行成功了
		//生成关联表信息
		DeviceAssociation deviceAssociation = new DeviceAssociation();
		//设置主设备id
		deviceAssociation.setMainEquipmentId(mianEquipmentId);
		//设置主设备信息id
		for (String mainEquipmentInfoIdTemp : mainEquipmentInfoIds) {
			deviceAssociation.setMainEquipmentInfoId(mainEquipmentInfoIdTemp);
			//执行插入操作
			deviceAssociationService.saveDeviceAssociation(deviceAssociation);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:勾选，上传设备关联表ids，进行删除
	 * @param: @param deviceAssociationIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeMainEquipment",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="移除电厂主设备",value="移除电厂主设备")
	public ResultEntity removeMainEquipment(@RequestParam List<String> deviceAssociationIds){
		
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
	}
	
	
	/**
	 * @Description:加载主界面数据
	 * @param: @param searchKey
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value="/listMainEquipment",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="加载主界面数据",value="加载主界面数据")
	public PageResultEntity listMainEquipment(@RequestParam(required = false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		MainEquipment mainEquipment = new MainEquipment();
		//如果选择了风电场模糊查询
		if(StringUtils.isNotBlank(searchKey)){
			mainEquipment.setDepartment(searchKey);
		}
		
		return deviceAssociationService.listDeviceAssociation(mainEquipment, pageNo, pageSize);
	}
	
	
	/**
	 * @Description:点击更新获取一次数据
	 * @param: @param deviceAssociationId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/getMainEquipment",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="获取电厂主设备",value="获取电厂主设备")
	public ResultEntity getMainEquipment(@RequestParam String deviceAssociationId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果为空返回错误
		if(StringUtils.isBlank(deviceAssociationId)){
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		//如果字段正常
		resultEntity  = deviceAssociationService.getDeviceAssociationResultById(deviceAssociationId);
		return resultEntity;
	}
	
	
	
	
	@RequestMapping(value="/editMainEquipment",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="编辑电厂主设备",value="编辑电厂主设备")
	public ResultEntity editMainEquipment(@RequestBody DeviceAssociationResult deviceAssociationResult ){
		
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(deviceAssociationResult.getDeviceAssociationId())
				||StringUtils.isBlank(deviceAssociationResult.getDepartment())
				||StringUtils.isBlank(deviceAssociationResult.getLogType())
				||StringUtils.isBlank(deviceAssociationResult.getMainEquipmentId())
				||StringUtils.isBlank(deviceAssociationResult.getLogName())){
			
			resultEntity.setCode(ErrorCode.ERROR);	
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		return deviceAssociationService.editDeviceAssociation(deviceAssociationResult);
	}
	
	

	
	

}
