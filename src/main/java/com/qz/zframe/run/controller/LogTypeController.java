package com.qz.zframe.run.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.LogTypeExample.Criteria;
import com.qz.zframe.run.service.LogTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: LogTypeController</p>
 * <p>@Description: 日志类型Controller层 </p>
 * @author 
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
		if (StringUtils.isBlank(logType.getWindCode())) {
			resultEntity.setMsg("风电场不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(logType.getLogName())) {
			resultEntity.setMsg("日志类型名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(logType.getStatus())) {
			resultEntity.setMsg("状态不能为空");
			return resultEntity;
		}

		//检查名称是否重复
		/*LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogNameEqualTo(logType.getLogName());
		List<LogType> list = logTypeService.getListByLogName(example);
		if (CollectionUtils.isNotEmpty(list)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型名称已存在");
			return resultEntity;
		}*/
		
		//字段正常执行保存操作
		logTypeService.saveLogType(logType);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	/**
	 * @Description://首页加载数据
	 * @param: @param department
	 * @param: @param logType
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/listLogType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "列表查询", value = "列表查询")
	public PageResultEntity listLogType(
			@RequestParam(required=false)@ApiParam(name="windCodeStart",value="风电场") String windCodeStart,
			@RequestParam(required=false)@ApiParam(name="windCodeEnd",value="风电场")String windCodeEnd,
			@RequestParam(required=false)@ApiParam(name="logCode",value="日志类型编码") String logCode,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		LogTypeExample example = new LogTypeExample();
		example.setOrderByClause("log_code");
		Criteria criteria = example.createCriteria();

		//选择了日志类型
		if(StringUtils.isNotBlank(logCode)){
			criteria.andLogTypeEqualTo(logCode);
		}
		//选择了两个风电场  范围查询
		if(StringUtils.isNoneBlank(windCodeStart) && StringUtils.isNoneBlank(windCodeEnd)){
			criteria.andWindCodeBetween(windCodeStart,windCodeEnd);
		}
		//选择一个风电场
		if (StringUtils.isNoneBlank(windCodeStart) && StringUtils.isBlank(windCodeEnd)) {
			criteria.andWindCodeEqualTo(windCodeStart);
		}

		PageHelper.startPage(pageNum, pageSize);
		List<LogType> list = logTypeService.listLogType(example);
		PageInfo<LogType> pageInfo = new PageInfo<LogType>(list);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}

	@RequestMapping(value = "/EnableListLogType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "启用的日志类型下拉框", value = "启用的日志类型下拉框")
	public ResultEntity EnableListLogType(
		@RequestParam(required=false)@ApiParam(name="windCodeStart",value="风电场") String windCode){
		ResultEntity resultEntity = new ResultEntity();

		LogTypeExample example = new LogTypeExample();
		example.setOrderByClause("log_code");
		example.createCriteria().andStatusEqualTo("01");
        if(StringUtils.isNotBlank(windCode)) {
        	example.createCriteria().andWindCodeEqualTo(windCode);	
        	
        }
		List<LogType> list = logTypeService.listLogType(example);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("信息已保存");
		resultEntity.setData(list);
		return resultEntity;
	}
	
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(
			@RequestParam(required=false)@ApiParam(name="windCodeStart",value="风电场") String windCodeStart,
			@RequestParam(required=false)@ApiParam(name="windCodeEnd",value="风电场")String windCodeEnd,
			@RequestParam(required=false)@ApiParam(name="logCode",value="日志类型编码") String logCode,
			HttpServletResponse response) {
		
		LogTypeExample example = new LogTypeExample();
		Criteria criteria = example.createCriteria();
		
		//选择了日志类型
		if(StringUtils.isNotBlank(logCode)){
			criteria.andLogTypeEqualTo(logCode);
		}

		//选择了两个风电场 范围查询
		if(StringUtils.isNoneBlank(windCodeStart) && StringUtils.isNoneBlank(windCodeEnd)){
			criteria.andWindCodeBetween(windCodeStart,windCodeEnd);
		}
		//选择一个风电场 只查询选择的风电场
		if (StringUtils.isNoneBlank(windCodeStart) && StringUtils.isBlank(windCodeEnd)) {
			criteria.andWindCodeEqualTo(windCodeStart);
		}

		List<LogType> list = logTypeService.listLogType(example);
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("department", "风场名称");
		testMap.put("logCode", "日志类型");
		testMap.put("logName", "日志名称");
		testMap.put("status", "状态");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "日志类型", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * @Description:勾选id批量删除
	 * @param: @param logTypeIds   需要的字段：勾选的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeLogType", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removeLogType(@RequestParam @ApiParam(name="logTypeIds",value="勾选的ids")List<String> logTypeIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果为空
		if(CollectionUtils.isEmpty(logTypeIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}
		
		//正常进行删除
		logTypeService.removeLogType(logTypeIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
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
	public ResultEntity editLogType(@RequestBody LogType logType){
		
		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(logType.getLogTypeId())) {
			resultEntity.setMsg("日志id不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(logType.getWindCode())) {
			resultEntity.setMsg("风电场不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(logType.getLogName())) {
			resultEntity.setMsg("日志类型名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(logType.getStatus())) {
			resultEntity.setMsg("状态不能为空");
			return resultEntity;
		}

		//检查名称是否重复
		/*LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogNameEqualTo(logType.getLogName()).andLogTypeIdNotEqualTo(logType.getLogTypeId());
		List<LogType> list = logTypeService.getListByLogName(example);
		if (CollectionUtils.isNotEmpty(list)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型名称已存在");
			return resultEntity;
		}*/
		
		logTypeService.editLogTypeById(logType);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
	}
	
	
	@RequestMapping(value="/getLogType" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="详情查询 ", notes="详情查询")
	public ResultEntity getLogType(@RequestParam @ApiParam(name="logTypeId",value="选择的id") String logTypeId){

	ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(logTypeId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
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
			resultEntity.setMsg("查询成功");
			resultEntity.setData(logType);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}

}
