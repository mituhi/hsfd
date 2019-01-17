package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.service.SchedulingQueryService;

import io.swagger.annotations.Api;

/**
 * <p>Title: RunLogController</p>
 * <p>@Description: 日记记录Controller层----对应运行日志表 </p>
 * @author 
 * @date 2018年11月14日 上午11:11:35
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/RunLog")
@Api(tags = "api-support-api-support-RunLog", description = "运行-运行管理-日志记录")
public class RunLogController {

	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	
	
	/***********************点击添加，获取当前日期的班次值次值班人员信息*****************************/
	
	public ResultEntity getSchedulingQueryInfo(){
		
		SchedulingQuery schedulingQuery = new SchedulingQuery();
		
		//当前时间传进去：
		Date now = new Date();
		//对日期字段进行转换：格式：上传给我的：2018-11-01
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateChoose = null;
		
		try {
			String StringNow = format.format(now);
			dateChoose = format.parse(StringNow);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(dateChoose != null){
			//日期转换成功：进行设置
			schedulingQuery.setStartTime(dateChoose);
		}
		
		//设置当前时间为
		
		
		
		//通过时间直接获取排班表信息
		//得到集合
		List<SchedulingQuery> schedulingQueryList = schedulingQueryService.listSchedulingQuery(schedulingQuery);
		
		//对数据进行封装
		
		
		
		
		
		return null;
	}
	
	
	
	
}
