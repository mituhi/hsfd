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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.entity.submit.DutyPersonUpdateSubmit;
import com.qz.zframe.run.service.DutyPersonUpdateService;
import com.qz.zframe.run.service.SchedulingQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: SchedulingQueryController</p>
 * <p>@Description: 排班查询 </p>
 * @author 
 * @date 2018年11月16日 下午5:41:22
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/SchedulingQuery")
@Api(tags = "api-support-api-support-SchedulingQuery", description = "运行-排班管理-排班查询")
public class SchedulingQueryController {

	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	@Autowired
	private DutyPersonUpdateService dutyPersonUpdateService;
	
	
	/**
	 * @Description:加载排班查询信息首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/SchedulingQueryIndexPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排班查询信息首页", value = "加载排班查询首页数据")
	public ResultEntity SchedulingQueryIndexPage(@RequestParam(required = true)@ApiParam(name="department",value="风电场", required = true) String department,
			@RequestParam(required = true)@ApiParam(name="schedulingName",value="排班表",required = true) String schedulingName,
			@RequestParam(required = false)@ApiParam(name="date",value="时间") String date) {
		
		//department：风电场       schedulingName：排班表名称      date:开始时间：格式  2018-11-00
		
		ResultEntity resultEntity = new ResultEntity();
		
		DutyPersonUpdateSubmit dutyPersonUpdateSubmit = new DutyPersonUpdateSubmit();
		
		
		if(StringUtils.isBlank(department) || StringUtils.isBlank(schedulingName)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//设置风电场
		dutyPersonUpdateSubmit.setDepartment(department);
		
		//设置排班表名称
		dutyPersonUpdateSubmit.setSchedulingName(schedulingName);
		
		//设置时间
		//选择了日期
		Date monthOfLastDate = null;
		if(StringUtils.isNotBlank(date)){
			//对日期字段进行转换：格式：上传给我的：2018-11-01
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date dateChoose = null;
			try {
				dateChoose = format.parse(date);
				//找到该月最后一天日期
				monthOfLastDate = DateUtil.getMonthEnd(dateChoose);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(dateChoose != null){
				//日期转换成功：进行设置
				dutyPersonUpdateSubmit.setDate(dateChoose);
				//设置
				dutyPersonUpdateSubmit.setMonthOfLastDate(monthOfLastDate);
			}
		}else{
			//使用默认时间
			Date dateNow = new Date();
			//使之成为月初第一天
			dateNow.setDate(1);
			
			//获取该月最后一天日期
			monthOfLastDate = DateUtil.getMonthEnd(dateNow);
			
			dutyPersonUpdateSubmit.setDefaultDate(dateNow);
			dutyPersonUpdateSubmit.setMonthOfLastDate(monthOfLastDate);
			
		}
		
		//得到结果集
		List<SchedulingQueryResult> list = dutyPersonUpdateService.getSchedulingQueryBySubmit(dutyPersonUpdateSubmit);
		
		//创建返回结果
		List<SchedulingQueryResult> result= new ArrayList<SchedulingQueryResult>();
		
		for (SchedulingQueryResult schedulingQueryResult : list) {
			if(CollectionUtils.isEmpty(result)){
				//如果保存结果的集合为空
				//直接add
				result.add(schedulingQueryResult);
			}else{
				//如果不为空：
				
				//默认在集合中不存在该条记录
				boolean flag = true;
				for (SchedulingQueryResult schedulingQueryResultTemp : result) {
					//如果班次,时间相同则合并人员
					if(schedulingQueryResultTemp.getDutyDate().toString().equals(schedulingQueryResult.getDutyDate().toString())
							&& schedulingQueryResultTemp.getShiftName().equals(schedulingQueryResult.getShiftName())){
						
						schedulingQueryResultTemp.setUserName(schedulingQueryResultTemp.getUserName()+","+schedulingQueryResult.getUserName());
						flag = false;
						break;
					}
				}
				
				if(flag){
					result.add(schedulingQueryResult);
				}
			}
			
			
		}
		 
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(result);
		return resultEntity;
	}
	
	
}
