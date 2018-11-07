package com.qz.zframe.run.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.qz.zframe.common.util.ObjectIsBlankUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingManagementExample;
import com.qz.zframe.run.entity.SchedulingManagementExample.Criteria;
import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import com.qz.zframe.run.entity.result.SchedulingManagementResult;
import com.qz.zframe.run.entity.submit.SaveSchedulingManagementSubmit;
import com.qz.zframe.run.service.SchedulingAssociatedService;
import com.qz.zframe.run.service.SchedulingManagementService;
import com.qz.zframe.run.service.SchedulingRuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: SchedulingManagementController</p>
 * <p>@Description: 排班管理控制层 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 上午10:38:07
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/SchedulingManagement")
@Api(tags = "api-support-api-support-SchedulingManagement", description = "运行-排班管理-排班管理")
public class SchedulingManagementController {

	@Autowired
	private SchedulingManagementService schedulingManagementService;
	
	@Autowired
	private SchedulingAssociatedService schedulingAssociatedService;
	
	@Autowired
	private SchedulingRuleService schedulingRuleService;
	
	
	@RequestMapping(value = "/SchedulingManagementIndexPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排班管理信息首页", value = "加载排班管理信息首页数据")
	public PageResultEntity SchedulingManagementIndexPage(@RequestBody SchedulingAssociated schedulingAssociated,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		// 返回对象
		PageResultEntity pageResultEntity = new PageResultEntity();

		SchedulingAssociatedExample example = new SchedulingAssociatedExample();
		// 封装查询条件
		List<SchedulingAssociated> schedulingAssociateds = schedulingAssociatedService.listSchedulingAssociated(example,
				pageNo, pageSize);
		pageResultEntity.setTotal(schedulingAssociatedService.selectCountTotal(example));

		// 声明返回对象集合
		List<SchedulingManagementResult> results = new ArrayList<SchedulingManagementResult>();

		// 不为空
		if (CollectionUtils.isNotEmpty(schedulingAssociateds)) {


			// 遍历查询其他相关表
			for (SchedulingAssociated schedulingAssociatedTemp : schedulingAssociateds) {
				// 返回对象集合元素
				SchedulingManagementResult schedulingManagementResult = new SchedulingManagementResult();
				// 设置排班关联表id
				schedulingManagementResult.setSchedulingAssociatedId(schedulingAssociatedTemp.getId());
				// 封装开始时间，结束时间
				schedulingManagementResult.setStartTime(schedulingAssociatedTemp.getStartTime());
				schedulingManagementResult.setEndTime(schedulingAssociatedTemp.getEndTime());
				// 得到排版管理表id
				String schedulingManagementId = schedulingAssociatedTemp.getSchedulingManagementId();
				// 根据id查询字段
				SchedulingManagement schedulingManagement = schedulingManagementService
						.getSchedulingManagementById(schedulingManagementId);
				// 封装字段 排班表编号 ，排班表， 风电场
				schedulingManagementResult.setSchedulingCode(schedulingManagement.getSchedulingCode());
				schedulingManagementResult.setSchedulingName(schedulingManagement.getSchedulingName());
				schedulingManagementResult.setDepartment(schedulingManagement.getDepartment());
				// 得到排班规则表id
				String schedulingRuleId = schedulingAssociatedTemp.getSchedulingRuleId();
				SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
				// 封装字段 规则编码 ， 规则名称
				schedulingManagementResult.setSchedulingRuleCode(schedulingRule.getSchedulingRuleCode());
				schedulingManagementResult.setSchedulingRule(schedulingRule.getSchedulingRule());
				// 添加到集合中
				results.add(schedulingManagementResult);
			}

		}

		pageResultEntity.setRows(results);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	
	
	/**
	 * @Description:批量获取排班管理信息
	 * @param: @param
	 *             schedulingManagement
	 * @param: @return
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listSchedulingManagement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "批量获取排班管理信息", value = "批量获取排班管理信息")
	public PageResultEntity listSchedulingManagement(@RequestBody SchedulingManagement schedulingManagement,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		
		PageResultEntity resultEntity = new PageResultEntity();

		PageHelper.startPage(pageNo, pageSize);
		
		SchedulingManagementExample example = new SchedulingManagementExample();
		
		// 封装查询信息
		Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(schedulingManagement.getSchedulingManagementId())) {
			criteria.andSchedulingManagementIdEqualTo(schedulingManagement.getSchedulingManagementId());
		}

		if (StringUtils.isNotBlank(schedulingManagement.getDepartment())) {
			criteria.andDepartmentEqualTo(schedulingManagement.getDepartment());
		}

		if (StringUtils.isNotBlank(schedulingManagement.getSchedulingCode())) {
			criteria.andSchedulingCodeEqualTo(schedulingManagement.getSchedulingCode());
		}

		if (StringUtils.isNotBlank(schedulingManagement.getSchedulingName())) {
			criteria.andSchedulingNameEqualTo(schedulingManagement.getSchedulingName());
		}

		// 执行查询
		List<SchedulingManagement> list = schedulingManagementService.listSchedulingManagement(example);
		// 设置返回结果
		PageInfo<SchedulingManagement> pageInfo = new PageInfo<SchedulingManagement>(list);
		resultEntity.setRows(list);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setTotal((int) pageInfo.getTotal());

		return resultEntity;

	}
	
	
	
	
	/**
	 * @Description:排版管理表信息的添加
	 * @param: @param
	 *             schedulingManagement
	 * @param: @return
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveSchedulingManagement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排版管理表信息的添加", value = "排版管理表信息的添加")
	public ResultEntity saveSchedulingManagement(@RequestBody SaveSchedulingManagementSubmit schedulingManagementSubmit) {

		ResultEntity resultEntity = new ResultEntity();
		
		//获取排班管理对象
		SchedulingManagement schedulingManagement = schedulingManagementSubmit.getSchedulingManagement();

		//获取排班关联表集合对象
		List<SchedulingAssociated> list = schedulingManagementSubmit.getSchedulingAssociateds();
		
		// 判断是否缺少字段
		if (StringUtils.isBlank(schedulingManagement.getDepartment())
				|| StringUtils.isBlank(schedulingManagement.getSchedulingCode())
				|| StringUtils.isBlank(schedulingManagement.getSchedulingName())
				||CollectionUtils.isEmpty(list)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//生成id
		String schedulingManagementId = UUID.randomUUID().toString();
		schedulingManagement.setSchedulingManagementId(schedulingManagementId);
		//执行插入操作
		resultEntity = schedulingManagementService.saveSchedulingManagement(schedulingManagement);
		
		//插入完成之后需要对关联表进行相关的操作
		for (SchedulingAssociated schedulingAssociated : list) {
			schedulingAssociated.setSchedulingManagementId(schedulingManagementId);
			//执行插入操作
			schedulingAssociatedService.saveSchedulingAssociated(schedulingAssociated);
		}
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:按规则排班  ---> 点击添加---> 做一次查询   显示必要信息  都在排班规则表中
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/injectSchedulingRuleInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "注入排班规则信息", value = "按规则排班  ---> 点击添加---> 做一次查询   显示必要信息") 
	public PageResultEntity injectSchedulingRuleInfo(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		
		SchedulingRuleExample example = new SchedulingRuleExample();
		// 执行查询操作
		List<SchedulingRule> list = schedulingRuleService.listSchedulingRule(example , pageNo, pageSize);
	
		PageResultEntity pageResultEntity = new PageResultEntity();
		pageResultEntity.setRows(list);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("查询成功");
		return pageResultEntity;
	}
	
	
	
	
	/**
	 * 编辑操作：操作排班关联表进行更新
	 */
	@RequestMapping(value = "/updateSchedulingAssociated", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "排班关联表表的修改", value = "修改排班关联表") 
	public ResultEntity updateSchedulingAssociated(@RequestBody List<SchedulingManagementResult> schedulingManagementResults){
		
		ResultEntity resultEntity = new ResultEntity();
		//检查集合是否为空
		if(CollectionUtils.isNotEmpty(schedulingManagementResults)){
			//循环检查字段是否为空
			for (SchedulingManagementResult schedulingManagementResult : schedulingManagementResults) {
				try {
					//各字段不为null 或者 ''
					boolean falg = ObjectIsBlankUtil.isExistFieldBlank(schedulingManagementResult);
					if(falg){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("缺少字段");
						return resultEntity;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//字段检查完成
			//实现更新操作
			for (SchedulingManagementResult schedulingManagementResult : schedulingManagementResults) {
				//通过排班关联表id，获取对象
				String schedulingAssociatedId = schedulingManagementResult.getSchedulingAssociatedId();
				SchedulingAssociated schedulingAssociated = schedulingAssociatedService.getSchedulingAssociatedById(schedulingAssociatedId);
				
				//修改排班关联表
				schedulingAssociated.setStartTime(schedulingManagementResult.getStartTime());
				schedulingAssociated.setEndTime(schedulingManagementResult.getEndTime());
				
				//执行更新操作
				schedulingAssociatedService.updateSchedulingAssociated(schedulingAssociated);
				
				
				//通过对象获取其他主键id
				
				//获取排版管理表id
				String schedulingManagementId = schedulingAssociated.getSchedulingManagementId();
				//通过id获取排版管理表对象
				SchedulingManagement schedulingManagement = schedulingManagementService.getSchedulingManagementById(schedulingManagementId);
				//重新赋值部门
				schedulingManagement.setDepartment(schedulingManagementResult.getDepartment());
				//重新赋值排班编号
				schedulingManagement.setSchedulingCode(schedulingManagementResult.getSchedulingCode());
				//重新赋值排班表名称
				schedulingManagement.setSchedulingName(schedulingManagementResult.getSchedulingName());
				//执行更新排版管理表信息
				schedulingManagementService.updateSchedulingManagement(schedulingManagement);
				
				
				//获取排班规则表id
				String schedulingRuleId = schedulingAssociated.getSchedulingRuleId();
				//通过id获取排班规则表中对象
				SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
				//重新赋值排班规则编码
				schedulingRule.setSchedulingRuleCode(schedulingManagementResult.getSchedulingRuleCode());
				//重新赋值排班规则名称
				schedulingRule.setSchedulingRule(schedulingManagementResult.getSchedulingRule());
				//执行更新排班规则表信息
				schedulingRuleService.updateSchedulingRule(schedulingRule);
				
			}
			
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		  
		return resultEntity;
	}
	
	
	
	
	
	/**
	 * @Description:删除:勾选列，提交排班关联表id，进行删除操作
	 * @param: @param schedulingAssociateds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeSchedulingAssociated",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="勾选列，提交排班关联表id，进行删除操作", value="删除排班关联表")
	public ResultEntity removeSchedulingAssociated(@RequestBody List<String> schedulingAssociateds){
		return schedulingAssociatedService.removeSchedulingAssociatedById(schedulingAssociateds);
	}
	
	
}
