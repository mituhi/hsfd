package com.qz.zframe.run.controller;

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
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.LogTypeExample.Criteria;
import com.qz.zframe.run.service.LogTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: LogTypeController</p>
 * <p>@Description: 日志类型Controller层 </p>
 * @author 陈汇奇
 * @date 2018年11月7日 下午3:55:40
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/LogType")
@Api(tags = "api-support-api-support-LogType", description = "运行-日志管理-配置-日志类型配置")
public class LogTypeController {

	@Autowired
	private LogTypeService logTypeService;
	
	
	
	/**
	 * @Description:保存信息
	 * @param: @param logType：参数除了id其他全部需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveLogType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "保存日志类型表", value = "保存日志类型表")
	public ResultEntity saveLogType(@RequestBody LogType logType){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//检查字段
		if(StringUtils.isBlank(logType.getDepartment())
				||StringUtils.isBlank(logType.getLogCode())
				||StringUtils.isBlank(logType.getLogName())
				||StringUtils.isBlank(logType.getLogType())
				||StringUtils.isBlank(logType.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//检查名称是否重复
		LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogNameEqualTo(logType.getLogName());
		List<LogType> list = logTypeService.getListByLogName(example);
		
		if(CollectionUtils.isEmpty(list)){
			//字段正常执行保存操作
			logTypeService.saveLogType(logType);
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行成功");
			return resultEntity;
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("名字重复");
			return resultEntity;
		}
		
	}
	
	
	/**
	 * @Description://首页加载数据
	 * @param: @param department
	 * @param: @param logType
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/listLogType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "日志类型首页信息", value = "日志类型首页信息")
	public PageResultEntity listLogType(@RequestParam(required=false) List<String> departments,
			@RequestParam(required=false) String logType,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		LogTypeExample example = new LogTypeExample();
		Criteria criteria = example.createCriteria();
		
		//选择了日志类型
		if(StringUtils.isNotBlank(logType)){
			criteria.andLogTypeEqualTo(logType);
		}

		//选择了部门/风电场
		if(CollectionUtils.isNotEmpty((departments))){
			for (String department : departments) {
				example.or().andDepartmentEqualTo(department);
			}
		}


		
		PageHelper.startPage(pageNo, pageSize);
		List<LogType> list = logTypeService.listLogType(example);
		PageInfo<LogType> pageInfo = new PageInfo<LogType>(list);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
	
	
	/**
	 * @Description:勾选id批量删除
	 * @param: @param logTypeIds   需要的字段：勾选的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeLogType", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removeLogType(@RequestParam List<String> logTypeIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果为空
		if(CollectionUtils.isEmpty(logTypeIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//正常进行删除
		logTypeService.removeLogType(logTypeIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:批量更新
	 * @param: @param LogType
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editLogType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新日志类型表", value = "更新日志类型表")
	public ResultEntity editLogType(@RequestBody List<LogType> LogTypes){
		
		ResultEntity resultEntity = new ResultEntity();
		
		for (LogType logType : LogTypes) {
			logTypeService.editLogTypeById(logType);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getLogType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getLogType(@RequestParam String logTypeId){

	ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(logTypeId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//封装查询条件
		LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogTypeIdEqualTo(logTypeId);
		//执行查询
		List<LogType> list = logTypeService.listLogType(example);
		
		LogType logType = null;
		if(list!=null && list.size() > 0 ){
			logType = list.get(0);
		}
		
		if(logType != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(logType);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}
	
	
}
