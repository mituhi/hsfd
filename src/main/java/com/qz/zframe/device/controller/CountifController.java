package com.qz.zframe.device.controller;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.entity.BreakdownInfoExample.Criteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/support/device/countifs")
@Api(tags = {"api-support-device-countifs"}, description = "设备-故障统计")
public class CountifController {
	@Autowired
	private  com.qz.zframe.device.service.CountifService CountifService;
	
	@RequestMapping(value = "/findCountis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 故障统计", notes = "故障统计")
	public PageResultEntity findCounponent(
		@RequestParam(value="pagetype",required = true)String pagetype,
        @RequestParam(value="countType",required = true)String countType,
        @RequestParam(required = false)
  		@ApiParam(name="activeTime",value="故障激活时间",required=false)Date activeTime,
  		@RequestParam(required = false)
		@ApiParam(name="activeTime2",value="故障激活时间",required=false)Date activeTime2
			) {
		PageResultEntity resultEntity=new PageResultEntity();
		resultEntity=CountifService.findCountis(pagetype,countType,activeTime,activeTime2);
		return resultEntity;
	}
	
	@RequestMapping(value = "/findCounponentById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 单个风电场的故障统计", notes = "单个风电场的故障统计")
	public ResultEntity findCounponentById(
	    @RequestParam(required = false)
		@ApiParam(name="windId",value="风电场",required=false)String windId,
        @RequestParam(required = false)
  		@ApiParam(name="activeTime",value="故障激活时间",required=false)Date activeTime,
  		@RequestParam(required = false)
		@ApiParam(name="activeTime2",value="故障激活时间",required=false)Date activeTime2
			) {
		ResultEntity resultEntity=new ResultEntity();
		resultEntity=CountifService.findCountisById(activeTime,activeTime2,windId);
		return resultEntity;
	}
}
