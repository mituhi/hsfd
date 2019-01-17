package com.qz.zframe.run.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

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

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.service.DeviceTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * <p>Title: DeviceTypeController</p>
 * <p>@Description:设备类型状态Controller层  </p>
 * @author 
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

		if (StringUtils.isBlank(deviceType.getDeviceType())) {
			resultEntity.setMsg("设备类型名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(deviceType.getDeviceStatus())) {
			resultEntity.setMsg("设备类型状态不能为空");
			return resultEntity;
		}
		if (deviceType.getSort()==null) {
			resultEntity.setMsg("设备类型排序不能为空");
			return resultEntity;
		}else {
			if (!Pattern.matches("^[1-9]+[0-9]*$", String.valueOf(deviceType.getSort()))) {
				resultEntity.setMsg("设备类型排序格式不正确");
				return resultEntity;
			}
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
	public ResultEntity removedeviceType(@RequestParam  @ApiParam(name="typeIds",value="勾选的id",required=true) List<String> typeIds){

		ResultEntity resultEntity = new ResultEntity();
				
		if(CollectionUtils.isEmpty(typeIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}

		deviceTypeService.removeDeviceTypeById(typeIds);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}
	
	
	/**
	 * @Description:模糊查询设备类型状态表
	 * @param: @param searchKey：查询关键字：可选
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDeviceType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "列表查询", value = "列表查询")
	public PageResultEntity listDeviceType(@RequestParam(required = false)  @ApiParam(name="searchKey",value="搜索关键字",required=false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DeviceTypeExample example = new DeviceTypeExample();
		example.setOrderByClause("update_time desc");

		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andDeviceTypeLike(searchKey);
			example.or().andDeviceStatusLike(searchKey);
		}
		
		//执行查询
		List<DeviceType> list = deviceTypeService.listDeviceType(example, pageNum, pageSize);
		
		//设置返回结果
		PageInfo<DeviceType> pageInfo = new PageInfo<DeviceType>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("查询成功");
		return pageResultEntity;
	}

	@RequestMapping(value = "/distinctListDeviceType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "设备类型状态下拉框", value = "设备类型状态下拉框")
	public ResultEntity distinctListDeviceType(){

		ResultEntity resultEntity = new ResultEntity();

		//执行查询
		List<DeviceType> list = deviceTypeService.distinctListDeviceType();

		//设置返回结果

		resultEntity.setData(list);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		return resultEntity;
	}
	
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false)  @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			HttpServletResponse response) {
		
		DeviceTypeExample example = new DeviceTypeExample();
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andDeviceTypeLike(searchKey);
			example.or().andDeviceStatusLike(searchKey);
		}
		
		example.setOrderByClause("sort");
		
		//执行查询
		List<DeviceType> list = deviceTypeService.listDeviceType(example, 0, 0);
		
		//设置时间格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		for (DeviceType deviceType : list) {
			Date updateTime = deviceType.getUpdateTime();
			String updateTimeStr = format.format(updateTime);
			deviceType.setUpdateTimeStr(updateTimeStr);
		}
		
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("deviceType", "设置类型");
		testMap.put("deviceStatus", "设备状态");
		testMap.put("sort", "排序");
		testMap.put("updateTimeStr", "修改时间");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "设备类型状态", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @Description:批量更新操作
	 * @param: @param deviceTypes：id , deviceType , deviceStatus ：不允许修改sort字段 
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDeviceType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新设备类型状态表", value = "更新设备类型状态表")
	public ResultEntity editDeviceType(@RequestBody DeviceType deviceType){
		
		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(deviceType.getDeviceType())) {
			resultEntity.setMsg("设备类型名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(deviceType.getDeviceStatus())) {
			resultEntity.setMsg("设备类型状态不能为空");
			return resultEntity;
		}
		if (deviceType.getSort()==null) {
			resultEntity.setMsg("设备类型排序不能为空");
			return resultEntity;
		}else {
			if (!Pattern.matches("^[1-9]+[0-9]*$", String.valueOf(deviceType.getSort()))) {
				resultEntity.setMsg("设备类型排序格式不正确");
				return resultEntity;
			}
		}
		
		//数据准备就绪
		deviceTypeService.editDeviceTypeById(deviceType);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getDeviceType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="详情查询 ", notes="详情查询")
	public ResultEntity getDeviceType(@RequestParam @ApiParam(name="typeId",value="类型id",required=true) String typeId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isEmpty(typeId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
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
			resultEntity.setMsg("查询成功");
			resultEntity.setData(type);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}
	
	/*@RequestMapping(value="/viewDeviceType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取对应信息 ", notes="点击查看：获取对应信息")*/
	public ResultEntity viewDeviceType(@RequestParam @ApiParam(name="typeId",value="类型id",required=true) String typeId){
		
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
			resultEntity.setMsg("查询成功");
			resultEntity.setData(type);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}
	
	
	
}
