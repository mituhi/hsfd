package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.submit.DeleteUpdateOperatorSubmit;
import com.qz.zframe.run.service.SchedulingQueryService;
import com.qz.zframe.run.service.UserValueTimeService;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/UpdateOperatorController")
@Api(tags = "api-support-api-support-UpdateOperatorController", description = "运行-排班管理-值班人员修改")
public class UpdateOperatorController {
	
	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	@Autowired
	private ValueTimeService valueTimeService;
	
	@Autowired
	private UserValueTimeService userValueTimeService;
	
	/**
	 * @Description:加载值班人员修改首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/updateOperatorIndexPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班人员信息首页", value = "加载值班人员修改首页数据")
	public PageResultEntity updateOperatorIndexPage(@RequestParam(required=false) String shiftName,
			@RequestParam(required=false) String schedulingName,@RequestParam(required=false) String date,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		
		PageResultEntity pageResultEntity = new PageResultEntity();

		SchedulingQuery schedulingQuery = new SchedulingQuery() ;
		
		//选择了班次
		if(StringUtils.isNotBlank(shiftName)){
			schedulingQuery.setShiftName(shiftName);
		}

		//选择了排班表
		if(StringUtils.isNotBlank(schedulingName)){
			schedulingQuery.setSchedulingName(schedulingName);
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//选择了日期
		if(StringUtils.isNotBlank(date)){
			//对日期字段进行转换：格式：2018-11-7  第一：转换出错，第二：返回PageResultEntity
			System.out.println(date);
			Date dateChoose = null;
			try {
				dateChoose = format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(dateChoose != null){
				//日期转换成功：进行设置
				schedulingQuery.setStartTime(dateChoose);
			}
		}else{
			Date dateChoose = new Date();
			schedulingQuery.setStartTime(dateChoose);
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<SchedulingQuery> list = schedulingQueryService.listUpdateOperator(schedulingQuery);
		
		//创建返回对象
		List<SchedulingQuery> result = new ArrayList<SchedulingQuery>();
		
		for (SchedulingQuery schedulingQueryTemp : list) {
			boolean falg = true;
			//从集合中查找是否是同一值班人员
			for (SchedulingQuery schedulingQueryTemp3 : result) {
				//如果字段都相同，则当日当班次为一起的人员，合并user名字返回（这里先使用id返回）
				if(schedulingQueryTemp3.getDepartment().equals(schedulingQueryTemp.getDepartment())
						&& schedulingQueryTemp3.getSchedulingCode().equals(schedulingQueryTemp.getSchedulingCode())
						&& schedulingQueryTemp3.getShiftName().equals(schedulingQueryTemp.getShiftName())
						&& schedulingQueryTemp3.getValueName().equals(schedulingQueryTemp.getValueName()))
				{
					
					schedulingQueryTemp3.setUserId(schedulingQueryTemp3.getUserId()+","+schedulingQueryTemp.getUserId());
					falg = false;
					break;
				}
			}
			if(falg){
				result.add(schedulingQueryTemp);
			}
			
		}
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(result);
		pageResultEntity.setTotal(result.size());
		return pageResultEntity;
	}
	
//	@RequestMapping(value = "/updateOperatorIndexPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes = "值班人员信息首页", value = "加载值班人员修改首页数据")
//	public ResultEntity updateOperatorIndexPage(@RequestBody SchedulingQuery schedulingQuery) {
//		ResultEntity resultEntity = new ResultEntity();
//		List<SchedulingQuery> list = schedulingQueryService.listUpdateOperator(schedulingQuery);
//		
//		//创建返回对象
//		List<SchedulingQuery> result = new ArrayList<SchedulingQuery>();
//		
//		for (SchedulingQuery schedulingQueryTemp : list) {
//			boolean falg = true;
//			//从集合中查找是否是同一值班人员
//			for (SchedulingQuery schedulingQueryTemp3 : result) {
//				//如果字段都相同，则当日当班次为一起的人员，合并user名字返回（这里先使用id返回）
//				if(schedulingQueryTemp3.getDepartment().equals(schedulingQueryTemp.getDepartment())
//						&& schedulingQueryTemp3.getSchedulingCode().equals(schedulingQueryTemp.getSchedulingCode())
//						&& schedulingQueryTemp3.getShiftName().equals(schedulingQueryTemp.getShiftName()))
//				{
//					
//					schedulingQueryTemp3.setUserId(schedulingQueryTemp3.getUserId()+","+schedulingQueryTemp.getUserId());
//					falg = false;
//					break;
//				}
//			}
//			if(falg){
//				result.add(schedulingQueryTemp);
//			}
//			
//		}
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setMsg("执行成功");
//		resultEntity.setData(result);
//		return resultEntity;
//	}
	
	
	/**
	 * @Description:更新值班人员信息
	 * @param: @param schedulingQuery: 需要要得字段：valueName值次名称, shiftName班次名称, schedulingName排班表名称
	 *  							 加上修改之后的  user_id 数组
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editOperator", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新值班人员信息", value = "更新值班人员信息")
	public ResultEntity editOperator(@RequestBody SchedulingQuery schedulingQuery,@RequestParam(required = true) List<String> userIds) {
		ResultEntity resultEntity = new ResultEntity();
		
		//必须字段进行检查
		if(StringUtils.isBlank(schedulingQuery.getValueName()) 
				|| StringUtils.isBlank(schedulingQuery.getShiftName())
				|| StringUtils.isBlank(schedulingQuery.getSchedulingName())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//字段完整,循环进行更新
		for (String userId : userIds) {
			schedulingQueryService.updateOperator(schedulingQuery,userId);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
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
	public ResultEntity removeUpdateOperator(@RequestParam List<DeleteUpdateOperatorSubmit> deleteUpdateOperatorSubmits) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isEmpty(deleteUpdateOperatorSubmits)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//如果字段正常
		for (DeleteUpdateOperatorSubmit deleteUpdateOperatorSubmit : deleteUpdateOperatorSubmits) {
			//获取值次名称
			String valueName = deleteUpdateOperatorSubmit.getValueName();
			//通过值次名称获取值次对象
			ValueTime valueTime = valueTimeService.getValueTimeByValueName(valueName);
			//知道userId , valueId , schedulingRuleId 删除用户关联表
			//创建userValueTime对象
			UserValueTime userValueTime = new UserValueTime();
			userValueTime.setSchedulingRuleId(deleteUpdateOperatorSubmit.getSchedulingRuleId());
			userValueTime.setValueId(valueTime.getValueId());
			
			//获取用户id集合对象
			List<String> userIds = deleteUpdateOperatorSubmit.getUserId();
			if(CollectionUtils.isNotEmpty(userIds)){
				//用户ids不为空
				for (String userId : userIds) {
					userValueTime.setUserId(userId);
					//批量删除操作
					userValueTimeService.deleteUserValueTime(userValueTime);
				}
			}
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	/**
	 * @Description:
	 * @param: @param date：选中的时间：可选参数
	 * @param: @param schedulingRuleId
	 * @param: @param valueName
	 * @param: @param shiftName
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/getSchedulingQuery" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getSchedulingQuery(@RequestParam String date,
			@RequestParam String schedulingRuleId,@RequestParam String valueName,@RequestParam String shiftName){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(date)
				||StringUtils.isBlank(schedulingRuleId)
				||StringUtils.isBlank(valueName)
				||StringUtils.isBlank(shiftName)){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;			
		}
		
		//字段正常
		SchedulingQuery schedulingQuery = new SchedulingQuery() ;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateChoose = null;
		try {
			dateChoose = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("时间解析异常");
			return resultEntity;
		}
		
		schedulingQuery.setStartTime(dateChoose);
		schedulingQuery.setShiftName(shiftName);
		schedulingQuery.setSchedulingRuleId(schedulingRuleId);
		schedulingQuery.setValueName(valueName);

		
		List<SchedulingQuery> list = schedulingQueryService.listUpdateOperator(schedulingQuery);
		
		//创建返回对象
		List<SchedulingQuery> result = new ArrayList<SchedulingQuery>();

		for (SchedulingQuery schedulingQueryTemp : list) {
			boolean falg = true;
			// 从集合中查找是否是同一值班人员
			for (SchedulingQuery schedulingQueryTemp3 : result) {
				// 如果字段都相同，则当日当班次为一起的人员，合并user名字返回（这里先使用id返回）
				if (schedulingQueryTemp3.getDepartment().equals(schedulingQueryTemp.getDepartment())
						&& schedulingQueryTemp3.getSchedulingCode().equals(schedulingQueryTemp.getSchedulingCode())
						&& schedulingQueryTemp3.getShiftName().equals(schedulingQueryTemp.getShiftName())
						&& schedulingQueryTemp3.getValueName().equals(schedulingQueryTemp.getValueName())) {

					schedulingQueryTemp3.setUserId(schedulingQueryTemp3.getUserId() + "," + schedulingQueryTemp.getUserId());
					falg = false;
					break;
				}
			}
			if (falg) {
				result.add(schedulingQueryTemp);
			}

		}
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(result);
		return resultEntity;
	}
	
	
	
	
	
	
	
}
