package com.qz.zframe.run.controller;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.service.DutyRememberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * <p>Title: DutyRememberController</p>
 * <p>@Description:当班记事Controller层  </p>
 * @author 
 * @date 2018年11月16日 下午5:39:29
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/DutyRemember")
@Api(tags = "api-support-api-support-DutyRemember", description = "运行-日志管理-配置-值班日志配置-当班记事")
public class DutyRememberController {

	@Autowired
	private DutyRememberService dutyRememberService;
	
	
	@RequestMapping(value = "/getRememberTheme", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "获取记事主题", value = "获取记事主题")
	public ResultEntity getRememberTheme(){
		
		ResultEntity resultEntity = new ResultEntity();
		
		Set<String> set = dutyRememberService.getRememberTheme();
		if(set !=null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(set);
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("没有查询到记事主题");
		return resultEntity;
	}
	
	
	
	@RequestMapping(value = "/removeDutyRemember", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除当担记事信息", value = "删除当担记事信息")
	public ResultEntity removeDutyRemember(@RequestParam @ApiParam(name="dutyRememberIds",value="记事表ids") List<String> dutyRememberIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isEmpty(dutyRememberIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		for (String dutyRememberId : dutyRememberIds) {
			resultEntity = dutyRememberService.deleteDutyRemember(dutyRememberId);
		}
		return resultEntity;
	}
	
	
}
