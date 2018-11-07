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
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: ValueTimeController </p>
 * <p>@Description: 值次表相关操作</p>
 * 
 * @author 陈汇奇
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
	@RequestMapping(value = "/getValueTimeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量获取值次表信息", notes = "批量获取值次表信息")
	public PageResultEntity getValueTimeList(@RequestBody(required = false) ValueTime valueTime,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		PageResultEntity resultEntity = new PageResultEntity();

		PageHelper.startPage(pageNum, pageSize);
		// 执行查询
		List<ValueTime> list = valueTimeService.ListValueTime(valueTime);
		// 设置返回结果
		PageInfo<ValueTime> pageInfo = new PageInfo<ValueTime>(list);
		resultEntity.setRows(list);
		resultEntity.setTotal((int) pageInfo.getTotal());
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}
	
	/**
	 * @Description: 新增值次表信息
	 * @param: @param valueTime 提交的值次表对象
	 * @param: 
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveValueTime",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增值次表信息", notes = "新增值次表")
	public ResultEntity saveValueTime(@RequestBody ValueTime valueTime) {

		ResultEntity resultEntity = new ResultEntity();

		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(valueTime.getSort().toString()) || StringUtils.isBlank(valueTime.getStatus())
				|| StringUtils.isBlank(valueTime.getValueCode()) || StringUtils.isBlank(valueTime.getValueName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
		} else {
			// 调用接口保存信息
			resultEntity = valueTimeService.saveValueTime(valueTime);
		}
		return resultEntity;
	}

	/**
	 * @Description:批量删除值次表信息
	 * @param: @param
	 *             ids
	 * @param: @return
	 * @return: ResponseEntity<Void>
	 */
	@RequestMapping(value = "/removeValueTimes", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除值次表信息", notes = "批量删除值次表信息")
	public ResultEntity removeValueTimes(@RequestBody List<String> ids) {
		
		ResultEntity resultEntity = valueTimeService.removeValueTimes(ids);
		return resultEntity;
	}
	
	

	
	
	
	 /** ********************** 	点击添加：获取排序数字            ***********************/
	 
	@RequestMapping(value="/getSort" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取排序数字 ", notes="获取排序数字  ")
	public ResultEntity getSort(){
		ResultEntity resultEntity = new ResultEntity();
		resultEntity = valueTimeService.getMaxSort();
		return resultEntity;
	}
	
}
