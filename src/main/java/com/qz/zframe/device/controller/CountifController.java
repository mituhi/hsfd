package com.qz.zframe.device.controller;

import java.text.ParseException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/support/device/countifs")
@Api(tags = {"api-support-device-countifs"}, description = "设备-故障统计")
public class CountifController {
	
	private static Logger logger = LoggerFactory.getLogger(CountifController.class);
	
	@Autowired
	private  com.qz.zframe.device.service.CountifService CountifService;
	
	@RequestMapping(value = "/findCountis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 故障统计", notes = "故障统计")
	public PageResultEntity findCountis(
		@RequestParam(value="pagetype",required = true,defaultValue = "01")String pageType,
        @RequestParam(value="countType",required = true,defaultValue = "01")String countType,
        @RequestParam(required = false)
  		@ApiParam(name="activeTime",value="故障激活时间",required=false)String activeTime,
  		@RequestParam(required = false)
		@ApiParam(name="activeTime2",value="故障激活时间",required=false)String activeTime2
			) throws ParseException {
		logger.info("===== 设备-故障统计CountifController.findCountis =====pagetype: "+pageType+"countType:"+countType);
		PageResultEntity resultEntity=new PageResultEntity();
		Date date=null;
		Date date2=null;
		if(StringUtils.isBlank(pageType)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少页面类型必要字段");
			return resultEntity;
		}
		if(StringUtils.isBlank(countType)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少统计类型必要字段");
			return resultEntity;
		}
		if(StringUtils.isNotBlank(activeTime)  || StringUtils.isBlank(activeTime2)) {
			 date= DateUtil.getStringToDate(activeTime);
		}
		if(StringUtils.isBlank(activeTime)  || StringUtils.isNotBlank(activeTime2)) {
			 date2= DateUtil.getStringToDate(activeTime2);
		}
	    if (StringUtils.isNotBlank(activeTime) && StringUtils.isNotBlank(activeTime2) ){
	    	 date= DateUtil.getStringToDate(activeTime);
			 date2= DateUtil.getStringToDate(activeTime2);
	    }
	    resultEntity=CountifService.findCountis(pageType,countType,date,date2);
		return resultEntity;
	}
	
	@RequestMapping(value = "/findCountisById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 单个风电场的故障统计", notes = "单个风电场的故障统计")
	public PageResultEntity findCountisById(
	    @RequestParam(required = false)
		@ApiParam(name="windId",value="风电场",required=false)String windId,
        @RequestParam(required = false)
  		@ApiParam(name="activeTime",value="故障激活时间",required=false)String activeTime,
  		@RequestParam(required = false)
		@ApiParam(name="activeTime2",value="故障激活时间",required=false)String activeTime2
			) throws ParseException {
		logger.info("===== 设备-故障统计CountifController.findCountisById ===== windId:"+windId);
		PageResultEntity resultEntity=new PageResultEntity();
		Date date= DateUtil.getStringToDate(activeTime);
		Date date2= DateUtil.getStringToDate(activeTime2);
		resultEntity=CountifService.findCountisById(date,date2,windId);
		return resultEntity;
	}
	
	@RequestMapping(value = "/findCountisExcel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 导出故障统计", notes = "导出故障统计")
	public String findCountisExcel(
	    HttpServletResponse response,
	    @RequestParam(required = false, defaultValue = "故障统计信息")String sheetName,
		@RequestParam(value="pagetype",required = true)String pageType,
        @RequestParam(value="countType",required = true)String countType,
        @RequestParam(required = false)
  		@ApiParam(name="activeTime",value="故障激活时间",required=false)String activeTime,
  		@RequestParam(required = false)String activeTime2
			) throws Exception {
		logger.info("===== 设备-故障统计CountifController.findCountis =====pagetype: "+pageType+"countType:"+countType);
		
		Date date= DateUtil.getStringToDate(activeTime);
		Date date2=DateUtil.getStringToDate(activeTime2);
		return  CountifService.ExportExcl(pageType, countType, date, date2, response, sheetName);
	}
}
