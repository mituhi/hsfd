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

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.ValueTimeExample;
import com.qz.zframe.run.entity.ValueTimeExample.Criteria;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: ValueTimeController </p>
 * <p>@Description: 值次表相关操作</p>
 * @author 
 * @date 2018年10月30日 下午3:22:13
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/ValueTime")
@Api(tags = "api-support-api-support-ValueTime", description = "运行-排班管理-值次管理")
public class ValueTimeController {

	@Autowired
	private ValueTimeService valueTimeService;

	/**
	 * @Description: 批量获取值次表信息
	 * @param: @param valueTime
	 * @param: @param pageNum  当前页
	 * @param: @param pageSize 每页放多少记录
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/getValueTimeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量获取值次表信息", notes = "批量获取值次表信息")
	public PageResultEntity getValueTimeList(@RequestParam(required = false)  @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		PageResultEntity pageResultEntity = new PageResultEntity();
		
		ValueTimeExample example = new ValueTimeExample();
		
		Criteria criteria = example.createCriteria();
		
		//选择了状态
		if(StringUtils.isNotBlank(status)){
			criteria.andStatusEqualTo(status);
		}

		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			criteria.andValueCodeLike(searchKey);
			
			Criteria criteria2 = example.createCriteria();
			
			criteria2.andStatusEqualTo(status);
			criteria2.andValueNameLike(searchKey);
			example.or(criteria2);
		}
		
		
		
		example.setOrderByClause("sort asc");
		//执行查询
		List<ValueTime> list = valueTimeService.ListValueTime(example, pageNum, pageSize);
		//设置返回结果
		PageInfo<ValueTime> pageInfo = new PageInfo<ValueTime>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false)  @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			HttpServletResponse response) {
		
		ValueTimeExample example = new ValueTimeExample();
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andValueCodeLike(searchKey);
			example.or().andValueNameLike(searchKey);
			example.or().andStatusLike(searchKey);
		}
		
		example.setOrderByClause("sort");
		
		List<ValueTime> list = valueTimeService.ListValueTime(example , 0, 0);
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("valueCode", "值次编码");
		testMap.put("valueName", "值次名称");
		testMap.put("status", "状态");
		testMap.put("sort", "排序");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "值次管理", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @Description: 新增值次表信息
	 * @param: @param valueTime 提交的值次表对象 除了id，全部需要
	 * @param: 
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveValueTime",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增值次表信息", notes = "新增值次表")
	public ResultEntity saveValueTime(@RequestBody ValueTime valueTime) {
		
		
		ResultEntity resultEntity = new ResultEntity();
		
		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(valueTime.getSort().toString()) ) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少值次序号字段");
			return resultEntity;
		}
		if( StringUtils.isBlank(valueTime.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少值次状态字段");
			return resultEntity;
		}
				
		if( StringUtils.isBlank(valueTime.getValueCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少值次编码字段");
			return resultEntity;
		} 
		if( StringUtils.isBlank(valueTime.getValueName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少值次名称字段");
			return resultEntity;
		}
		resultEntity = valueTimeService.saveValueTime(valueTime);
		return resultEntity;
	}

	/**
	 * @Description:批量删除值次表信息： 
	 * @param: @param
	 *             ids:表单中需要被删除的值次表id
	 * @param: @return
	 * @return: ResponseEntity<Void>
	 */
	@RequestMapping(value = "/removeValueTimes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除值次表信息", notes = "批量删除值次表信息")
	public ResultEntity removeValueTimes(@RequestParam @ApiParam(name="ids",value="勾选的ids") List<String> ids) {
		
		ResultEntity resultEntity = new ResultEntity();
		resultEntity = valueTimeService.removeValueTimes(ids);
		
		return resultEntity;
	}
	
	
	/**
	 * @Description:批量更新值次表
	 * @param: @param valueTimes：参数为值次表信息所有字段都需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editValueTimes", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量更新值次表信息", notes = "批量更新值次表信息")
	public ResultEntity editValueTimes(@RequestBody List<ValueTime> valueTimes) {
		
		ResultEntity resultEntity = new ResultEntity();

		//检查字段完整性
		if(CollectionUtils.isEmpty(valueTimes)){
			//如果为空返回
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//如果不为空执行更新
		resultEntity = valueTimeService.editRecord(valueTimes);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		
		return resultEntity ;
	}
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getValueTime" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getValueTime(@RequestParam @ApiParam(name="valueTimeId",value="勾选的ids") String valueTimeId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果数据不为空
		if(StringUtils.isNotBlank(valueTimeId)){
			ValueTime valueTime = valueTimeService.getValueTimeById(valueTimeId);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(valueTime);
			return resultEntity ;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("缺少字段");
		return resultEntity;
	}

	/*************************    点击查看：获取对应信息               ***************************/
	@RequestMapping(value="/viewValueTime" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取对应信息详情 ", notes="点击查看：获取对应信息详情")
	public ResultEntity viewValueTime(@RequestParam @ApiParam(name="valueTimeId",value="勾选的id") String valueTimeId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果数据不为空
		if(StringUtils.isNotBlank(valueTimeId)){
			ValueTime valueTime = valueTimeService.getValueTimeById(valueTimeId);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(valueTime);
			return resultEntity ;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("缺少字段");
		return resultEntity;
	}
	
	
	/************************   获取值次下拉框值           ************************************/
	@RequestMapping(value="/getValueSelect" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取值次下拉框值 ", notes="获取值次下拉框值")
	public ResultEntity getValueSelect(){
		ResultEntity resultEntity = new ResultEntity();
		
		ValueTimeExample example = new ValueTimeExample();
		List<ValueTime> list = valueTimeService.ListValueTime(example , 0, 0);
		resultEntity.setData(list);
		
		return resultEntity;
	}
	
	
	
	 /** ********************** 	点击添加：获取排序数字            ***********************/
	 
	@RequestMapping(value="/getSort" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取排序数字 ", notes="获取排序数字  ")
	public ResultEntity getSort(){
		ResultEntity resultEntity = new ResultEntity();
		resultEntity= valueTimeService.getMaxSort();
		return resultEntity;
	}
	
}
