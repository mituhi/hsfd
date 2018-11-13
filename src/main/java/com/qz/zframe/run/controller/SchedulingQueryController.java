package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.service.SchedulingQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/SchedulingQuery")
@Api(tags = "api-support-api-support-SchedulingQuery", description = "运行-排班管理-排班查询")
public class SchedulingQueryController {

	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	
	/**
	 * @Description:加载排班查询信息首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/SchedulingQueryIndexPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排班查询信息首页", value = "加载排班查询首页数据")
	public ResultEntity SchedulingQueryIndexPage(@RequestParam(required = true) String department,
			@RequestParam(required = true) String schedulingName ,@RequestParam(required = false)String date) {
		
		//department：风电场       schedulingName：排班表名称      date:开始时间：格式  2018-11-00
		
		ResultEntity resultEntity = new ResultEntity();
		SchedulingQuery schedulingQuery = new SchedulingQuery();
		
		if(StringUtils.isBlank(department) || StringUtils.isBlank(schedulingName)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//设置风电场
		schedulingQuery.setDepartment(department);
		
		//设置排班表名称
		schedulingQuery.setSchedulingName(schedulingName);
		
		//设置时间
		//选择了日期
		if(StringUtils.isNotBlank(date)){
			//对日期字段进行转换：格式：上传给我的：2018-11-01
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
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
			//使用默认时间
			Date dateNow = new Date();
			//使之成为月初第一天
			dateNow.setDate(1);
			schedulingQuery.setStartTime(dateNow);
		}
		
		
		List<SchedulingQuery> list = schedulingQueryService.listSchedulingQuery(schedulingQuery);
		
		List<SchedulingQueryResult> schedulingQueryResults = new ArrayList<SchedulingQueryResult>();
		//将结果封装
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(list);
		return resultEntity;
	}
	
	
}
