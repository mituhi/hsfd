package com.qz.zframe.run.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.service.SchedulingQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/UpdateOperatorController")
@Api(tags = "api-support-api-support-UpdateOperatorController", description = "运行-排班管理-值班人员修改")
public class UpdateOperatorController {
	
	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	
	/**
	 * @Description:加载值班人员修改首页
	 * @param: @param schedulingQuery
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/updateOperatorIndexPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班人员信息首页", value = "加载值班人员修改首页数据")
	public ResultEntity updateOperatorIndexPage(@RequestBody SchedulingQuery schedulingQuery) {
		ResultEntity resultEntity = new ResultEntity();
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
						&& schedulingQueryTemp3.getShiftName().equals(schedulingQueryTemp.getShiftName()))
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
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(result);
		return resultEntity;
	}
	
	
	/**
	 * @Description:更新值班人员信息
	 * @param: @param schedulingQuery: 需要要得字段：valueName , shiftName , schedulingName  加上修改之后的 user_id 数组
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/updateOperator", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新值班人员信息", value = "更新值班人员信息")
	public ResultEntity updateOperator(@RequestBody SchedulingQuery schedulingQuery,@RequestParam(required = true) List<String> userIds) {
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
	
	
	
	
	
	
	
	
}
