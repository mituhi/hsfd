package com.qz.zframe.run.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/SchedulingQueryIndexPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排班查询信息首页", value = "加载排班查询首页数据")
	public ResultEntity SchedulingQueryIndexPage(@RequestBody SchedulingQuery schedulingQuery) {
		ResultEntity resultEntity = new ResultEntity();
		List<SchedulingQuery> list = schedulingQueryService.listSchedulingQuery(schedulingQuery);
		
		List<SchedulingQueryResult> schedulingQueryResults = new ArrayList<SchedulingQueryResult>();
		//将结果封装
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(list);
		return resultEntity;
	}
	
	
}
