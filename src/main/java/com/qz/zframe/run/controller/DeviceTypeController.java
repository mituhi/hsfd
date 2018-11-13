package com.qz.zframe.run.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.service.DeviceTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p>Title: DeviceTypeController</p>
 * <p>@Description:设备类型状态Controller层  </p>
 * @author 陈汇奇
 * @date 2018年11月6日 下午4:34:43
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/DeviceType")
@Api(tags = "api-support-api-support-DeviceType", description = "运行-日志管理-配置-设备类型状态配置")
public class DeviceTypeController {

	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	
	/** ********************** 	点击添加：获取排序数字            ***********************/
	
	@RequestMapping(value="/getSort" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取排序数字 ", notes="获取排序数字  ")
	public ResultEntity getSort(){
		ResultEntity resultEntity = new ResultEntity();
		resultEntity = deviceTypeService.getMaxSort();
		return resultEntity;
	}
	

	/**
	 * @Description:保存设备类型状态信息
	 * @param: @param deviceType： 除了id,updateTime,remark其他属性值都需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveDeviceType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "保存设备类型状态表", value = "保存设备类型状态表")
	public ResultEntity saveDeviceType(@RequestBody DeviceType deviceType){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//判断属性值是否为空
		if(StringUtils.isBlank(deviceType.getDeviceType())
				||StringUtils.isBlank(deviceType.getDeviceStatus())
				||StringUtils.isBlank(deviceType.getSort()+"")){
			//存在为空
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//字段正常，执行插入操作
		resultEntity = deviceTypeService.saveDeviceType(deviceType);
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:勾选id批量删除
	 * @param: @param typeIds   需要的字段：勾选的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removedeviceType", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removedeviceType(@RequestParam List<String> typeIds){

		ResultEntity resultEntity = new ResultEntity();
				
		if(CollectionUtils.isEmpty(typeIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		for (String typeId : typeIds) {
			deviceTypeService.removeDeviceTypeById(typeId);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	/**
	 * @Description:模糊查询设备类型状态表
	 * @param: @param searchKey：查询关键字：可选
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDeviceType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "模糊查询设备类型状态表", value = "模糊查询设备类型状态表")
	public PageResultEntity listDeviceType(@RequestParam(required = false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DeviceTypeExample example = new DeviceTypeExample();
		
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andDeviceTypeLike(searchKey);
			example.or().andDeviceStatusLike(searchKey);
		}
		
		//执行查询
		List<DeviceType> list = deviceTypeService.listDeviceType(example, pageNo, pageSize);
		
		//设置返回结果
		PageInfo<DeviceType> pageInfo = new PageInfo<DeviceType>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	
	/**
	 * @Description:批量更新操作
	 * @param: @param deviceTypes：id , deviceType , deviceStatus ：不允许修改sort字段 
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDeviceType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新设备类型状态表", value = "更新设备类型状态表")
	public ResultEntity editDeviceType(@RequestBody List<DeviceType> deviceTypes){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//查看集合是否为空
		if(CollectionUtils.isEmpty(deviceTypes)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//查看字段值是否完整
		for (DeviceType deviceType : deviceTypes) {
			if(StringUtils.isBlank(deviceType.getTypeId())
					||StringUtils.isBlank(deviceType.getDeviceType())
					||StringUtils.isBlank(deviceType.getDeviceStatus())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少字段");
				return resultEntity;
			}
		}
		
		//数据准备就绪
		//循环根据主键进行更新操作
		for (DeviceType deviceType : deviceTypes) {
			deviceTypeService.editDeviceTypeById(deviceType);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getDeviceType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getDeviceType(@RequestParam String typeId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isEmpty(typeId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//封装查询条件
		DeviceTypeExample example = new DeviceTypeExample();
		example.createCriteria().andTypeIdEqualTo(typeId);
		//执行查询
		List<DeviceType> list = deviceTypeService.listDeviceType(example , 0, 0);
		
		DeviceType type = null;
		if(list!=null && list.size() > 0 ){
			type = list.get(0);
		}
		
		if(type != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(type);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}
	
	
	
}
