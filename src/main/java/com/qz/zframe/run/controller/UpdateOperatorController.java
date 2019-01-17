package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.ObjectIsBlankUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyPersonUpdate;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.entity.submit.DutyPersonUpdateSubmit;
import com.qz.zframe.run.service.DutyPersonUpdateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/UpdateOperatorController")
@Api(tags = "api-support-api-support-UpdateOperatorController", description = "运行-排班管理-值班人员修改")
public class UpdateOperatorController {
	
	
	@Autowired
	private DutyPersonUpdateService dutyPersonUpdateService;
	
	
	/**
	 * @Description:加载值班人员修改首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/updateOperatorIndexPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班人员信息首页", value = "加载值班人员修改首页数据")
	public PageResultEntity updateOperatorIndexPage(@RequestParam(required=false)@ApiParam(name="shiftId",value="班次名称") String shiftId,
			@RequestParam(required=false)@ApiParam(name="schedulingName",value="排班表") String schedulingName,
			@RequestParam(required=false)@ApiParam(name="date",value="时间") String date,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		
		PageResultEntity pageResultEntity = new PageResultEntity();

		DutyPersonUpdateSubmit dutyPersonUpdateSubmit = new DutyPersonUpdateSubmit();
		
		if(StringUtils.isNotBlank(shiftId)){
			dutyPersonUpdateSubmit.setShiftId(shiftId);
		}
		
		if(StringUtils.isNotBlank(schedulingName)){
			dutyPersonUpdateSubmit.setSchedulingName(schedulingName);
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotBlank(date)){
			Date parseDate = null;
			try {
				parseDate = format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(parseDate == null){
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("时间解析错误");
				return pageResultEntity;
			}
			dutyPersonUpdateSubmit.setDate(parseDate);
		}else{
			//如果没有选择时间：默认加载系统时间下为条件
			Date dateNow = new Date();
			dutyPersonUpdateSubmit.setDefaultDate(dateNow);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<SchedulingQueryResult> list = dutyPersonUpdateService.getDutyPersonUpdateBySubmit(dutyPersonUpdateSubmit);
		
		List<SchedulingQueryResult> result = new ArrayList<SchedulingQueryResult>();
		
		//如果存在相同的值次，班次 则合并
		for (SchedulingQueryResult schedulingQueryResult : list) {
			
			//如果集合为空
			if(CollectionUtils.isEmpty(result)){
				result.add(schedulingQueryResult);
			}else{
				boolean flag = true;
				//集合不为空：遍历
				for (SchedulingQueryResult schedulingQueryResultTemp : result) {
					if(schedulingQueryResultTemp.getValueName().equals(schedulingQueryResult.getValueName())
							&& schedulingQueryResultTemp.getShiftName().equals(schedulingQueryResult.getShiftName())
							&& schedulingQueryResultTemp.getDutyDate().toString().equals(schedulingQueryResult.getDutyDate().toString())){
						//如果属性值相同:名字合并
						schedulingQueryResultTemp.setUserId(schedulingQueryResultTemp.getUserId()+","+schedulingQueryResult.getUserId());
						schedulingQueryResultTemp.setUserName(schedulingQueryResultTemp.getUserName()+","+schedulingQueryResult.getUserName());
						result.add(schedulingQueryResultTemp);
						flag = false;
						break;
					}
				}
				if(flag){
					result.add(schedulingQueryResult);
				}
			}
			
		}
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(result);
		pageResultEntity.setTotal(result.size());
		return pageResultEntity;
	}
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required=false)@ApiParam(name="shiftName",value="班次名称") String shiftId,
			@RequestParam(required=false)@ApiParam(name="schedulingName",value="排班表") String schedulingName,
			@RequestParam(required=false)@ApiParam(name="date",value="时间") String date,
			HttpServletResponse response) {
		
		
		DutyPersonUpdateSubmit dutyPersonUpdateSubmit = new DutyPersonUpdateSubmit();
		
		if(StringUtils.isNotBlank(shiftId)){
			dutyPersonUpdateSubmit.setShiftId(shiftId);
		}
		
		if(StringUtils.isNotBlank(schedulingName)){
			dutyPersonUpdateSubmit.setSchedulingName(schedulingName);
		}
		
		if(StringUtils.isNotBlank(date)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parseDate = null;
			try {
				parseDate = format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(parseDate == null){
				return ;
			}
			dutyPersonUpdateSubmit.setDate(parseDate);
		}
		
		List<SchedulingQueryResult> list = dutyPersonUpdateService.getDutyPersonUpdateBySubmit(dutyPersonUpdateSubmit);
		
		List<SchedulingQueryResult> result = new ArrayList<SchedulingQueryResult>();
		
		//如果存在相同的值次，班次 则合并
		for (SchedulingQueryResult schedulingQueryResult : list) {
			
			//如果集合为空
			if(CollectionUtils.isEmpty(result)){
				result.add(schedulingQueryResult);
			}else{
				boolean flag = true;
				//集合不为空：遍历
				for (SchedulingQueryResult schedulingQueryResultTemp : result) {
					if(schedulingQueryResultTemp.getValueName().equals(schedulingQueryResult.getValueName())
							&& schedulingQueryResultTemp.getShiftName().equals(schedulingQueryResult.getShiftName())
							&& schedulingQueryResultTemp.getDutyDate().toString().equals(schedulingQueryResult.getDutyDate().toString())){
						//如果属性值相同:名字合并
						schedulingQueryResultTemp.setUserId(schedulingQueryResultTemp.getUserId()+","+schedulingQueryResult.getUserId());
						schedulingQueryResultTemp.setUserName(schedulingQueryResultTemp.getUserName()+","+schedulingQueryResult.getUserName());
						result.add(schedulingQueryResultTemp);
						flag = false;
						break;
					}
				}
				if(flag){
					result.add(schedulingQueryResult);
				}
			}
			
		}
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		
		testMap.put("dutyDate", "值班日期");
		testMap.put("department", "风场");
		testMap.put("schedulingCode", "排班编号");
		testMap.put("schedulingName", "排班表名称");
		testMap.put("valueName", "值次名称");
		testMap.put("shiftName", "班次名称");
		testMap.put("userName", "人员");
		
		try {
			String fileName = ExcelUtil.listToExcel2(result, testMap, "值班人员更新", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * @Description:
	 * @param: @param schedulingQuery   勾选删除数据上传：必须schedulingRuleId排班规则id ，userId用户id， valueName值次id
	 * @param: @param userIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeUpdateOperator", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除值班人员信息", value = "删除值班人员信息")
	public ResultEntity removeUpdateOperator(@RequestBody List<String> dutyPersonUpdateIds) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isEmpty(dutyPersonUpdateIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//如果字段正常
		for (String dutyPersonUpdateId : dutyPersonUpdateIds) {
			dutyPersonUpdateService.deleteDutyPersonUpdate(dutyPersonUpdateId);
		}
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getSchedulingQuery" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getSchedulingQuery(@RequestParam @ApiParam(name="dutyPersonUpdateId",value="值班人员修改id",required = true) String dutyPersonUpdateId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(dutyPersonUpdateId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		DutyPersonUpdateSubmit dutyPersonUpdateSubmit = new DutyPersonUpdateSubmit();
		dutyPersonUpdateSubmit.setDutyPersonUpdateId(dutyPersonUpdateId);
		
		List<SchedulingQueryResult> list = dutyPersonUpdateService.getDutyPersonUpdateBySubmit(dutyPersonUpdateSubmit);
		
		if(list.size()>0){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(list.get(0));
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("未找到信息");
		return resultEntity;
	}
	
	
	
	
	/*************************    点击查看：获取对应信息               ***************************/

	@RequestMapping(value="/viewSchedulingQuery" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取对应信息 ", notes="点击查看：获取对应信息")
	public ResultEntity viewSchedulingQuery(@RequestParam @ApiParam(name="dutyPersonUpdateId",value="值班人员修改id",required = true) String dutyPersonUpdateId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(dutyPersonUpdateId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		DutyPersonUpdateSubmit dutyPersonUpdateSubmit = new DutyPersonUpdateSubmit();
		dutyPersonUpdateSubmit.setDutyPersonUpdateId(dutyPersonUpdateId);
		
		List<SchedulingQueryResult> list = dutyPersonUpdateService.getDutyPersonUpdateBySubmit(dutyPersonUpdateSubmit);
		
		if(list.size()>0){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(list.get(0));
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("未找到信息");
		return resultEntity;
	}
	

	
	/**
	 * @Description:值班人员修改
	 * @param: @param dutyPersonUpdateId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editOperator", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新值班人员信息", value = "更新值班人员信息")
	public ResultEntity editOperator(@RequestBody @ApiParam(name="dutyPersonUpdate",value="值班人员修改对象",required = true) DutyPersonUpdate dutyPersonUpdate){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//检查字段
		try {
			if(ObjectIsBlankUtil.isExistFieldBlank(dutyPersonUpdate)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少字段");
				return resultEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//检查正常
		
		
		//先删除  --- >  添加  --- >  更新
		dutyPersonUpdateService.deleteDutyPersonUpdate(dutyPersonUpdate.getDutyPersonUpdateId());
		
		//得到值班人员id
		String dutyUsersId = dutyPersonUpdate.getDutyUsersId();
		
		if(dutyUsersId.contains(",")){
			//如果包含,
			String[] userIdArr = dutyUsersId.split(",");
			for (String userId : userIdArr) {
				//重新生成id
				dutyPersonUpdate.setDutyPersonUpdateId(UUID.randomUUID().toString());
				//添加
				dutyPersonUpdate.setDutyUsersId(userId);
				dutyPersonUpdateService.saveDutyPersonUpdate(dutyPersonUpdate);
			}
		}else{
			//重新生成id
			dutyPersonUpdate.setDutyPersonUpdateId(UUID.randomUUID().toString());
			//添加
			dutyPersonUpdate.setDutyUsersId(dutyUsersId);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
		
	
	
	
	
	
}
