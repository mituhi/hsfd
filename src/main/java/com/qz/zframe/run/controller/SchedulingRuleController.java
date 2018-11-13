package com.qz.zframe.run.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.result.SchedulingRuleResult;
import com.qz.zframe.run.entity.result.ShiftValueCodeResult;
import com.qz.zframe.run.entity.result.UserValueCodeResult;
import com.qz.zframe.run.entity.submit.SaveSchedulingRuleSubmit;
import com.qz.zframe.run.service.RuleShiftValueService;
import com.qz.zframe.run.service.SchedulingRuleService;
import com.qz.zframe.run.service.ShiftService;
import com.qz.zframe.run.service.UserValueTimeService;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: SchedulingRuleController</p>
 * <p>@Description: 排班规则控制层 </p>
 * @author 陈汇奇
 * @date 2018年10月31日 下午4:47:52
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/SchedulingRule")
@Api(tags = "api-support-api-support-SchedulingRule", description = "运行-排班管理-排班规则")
public class SchedulingRuleController {

	@Autowired
	private SchedulingRuleService schedulingRuleService;
	
	@Autowired
	private RuleShiftValueService ruleShiftValueService;
	
	@Autowired
	private ValueTimeService valueTimeService;
	
	@Autowired
	private UserValueTimeService userValueTimeService;
	
	@Autowired
	private ShiftService shiftService;
	
	
	
	/**
	 * @Description:新增排班规则信息
	 * @param: @param saveSchedulingRuleSubmit
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveSchedulingRule",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="新增排班规则信息",value="新增排班规则信息")
	public ResultEntity saveSchedulingRule(@RequestBody SaveSchedulingRuleSubmit saveSchedulingRuleSubmit){
		
		//声明返回对象
		ResultEntity resultEntity = new ResultEntity();
		
		//从json数据串中获取 schedulingRule 对象
		SchedulingRule schedulingRule = saveSchedulingRuleSubmit.getSchedulingRule();
		
		//从json数据串中获取封装好的 userId, valueCode 集合对象
		List<UserValueCodeResult> userValueCodeResults = saveSchedulingRuleSubmit.getUserValueCodeResults();
		
		//从json数据串中获取封装好的 shiftCode, valueCode 集合对象
		List<ShiftValueCodeResult> shiftValueCodeResults = saveSchedulingRuleSubmit.getShiftValueCodeResults();
		
		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(schedulingRule.getDayNum()) || StringUtils.isBlank(schedulingRule.getDepartment())
				|| StringUtils.isBlank(schedulingRule.getIsAcrossDay())
				|| StringUtils.isBlank(schedulingRule.getRotationCycle())
				|| StringUtils.isBlank(schedulingRule.getSchedulingRule())
				|| StringUtils.isBlank(schedulingRule.getSchedulingRuleCode())
				|| StringUtils.isBlank(schedulingRule.getSchedulingShift())
				|| StringUtils.isBlank(schedulingRule.getStatus())
				|| CollectionUtils.isEmpty(shiftValueCodeResults)
				|| CollectionUtils.isEmpty(shiftValueCodeResults)) {
			
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段，添加失败");
			return resultEntity;
		}else{
			//所有字段正常
			//添加 schedulingRule 字段
			
			//生成id
			String schedulingRuleId = UUID.randomUUID().toString();
			schedulingRule.setSchedulingRuleId(schedulingRuleId);
			
			//调用接口
			schedulingRuleService.saveSchedulingRule(schedulingRule);
			
			//插入成功之后接着添加关联的用户值次关联表
			for (UserValueCodeResult valueCodeResult : userValueCodeResults) {
				//值次code
				String valueCode = valueCodeResult.getValueCode();
				//通过值次code获取值次id
				String valueTimeId = valueTimeService.getValueTimeIdByValueCode(valueCode);
				//用户id
				String userId = valueCodeResult.getUserId();
				//封装人员值次关联表信息
				UserValueTime userValueTime = new UserValueTime();
				
				userValueTime.setSchedulingRuleId(schedulingRuleId);
				userValueTime.setUserId(userId);
				userValueTime.setValueId(valueTimeId);
				//调用接口保存用户值次关联表
				userValueTimeService.saveUserValueTime(userValueTime);
			}
			
			//插入成功之后接着添加关联的 排班班次值次关联表
			for (ShiftValueCodeResult shiftValueCodeResult : shiftValueCodeResults) {
				//值次code
				String valueCode = shiftValueCodeResult.getValueCode();
				//通过值次code获取值次id
				String valueTimeId = valueTimeService.getValueTimeIdByValueCode(valueCode);
				//班次code
				String shiftCode = shiftValueCodeResult.getShiftCode();
				//通过班次code获取班次id
				String shiftId = shiftService.getShiftIdByCode(shiftCode);
				//封装排班班次值次对象
				RuleShiftValue ruleShiftValue = new RuleShiftValue();
				ruleShiftValue.setSchedulingRuleId(schedulingRuleId);
				ruleShiftValue.setShiftId(shiftId);
				ruleShiftValue.setValueId(valueTimeId);
				ruleShiftValueService.saveRuleShiftValue(ruleShiftValue);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			return resultEntity;
		}
	}
	
	
	
	
	
	/**
	 * @Description:模糊查询排班规则表首页数据
	 * @param: @param schedulingRule
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	
	@RequestMapping(value="/listSchedulingRule" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="模糊查询排班规则表首页数据",value="模糊查询排班规则表首页数据")
	public PageResultEntity listSchedulingRule(@RequestParam(required = false) List<String> departments,@RequestParam(required = false) String status,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		SchedulingRuleExample example = new SchedulingRuleExample();

		//如果状态值一栏选中
		if(StringUtils.isNotBlank(status)){
			//设置模糊查询
			example.createCriteria().andStatusEqualTo(status);
		}

		//如果部门选中（可以是多个）
		if(CollectionUtils.isNotEmpty(departments)){
			//设置模糊查询
			for (String department : departments) {
				example.or().andDepartmentEqualTo(department);
			}
		}
		
		// 执行查询操作
		List<SchedulingRule> list = schedulingRuleService.listSchedulingRule(example, pageNo, pageSize);
		
		
		//声明返回的集合对象
		List<SchedulingRuleResult> results = new ArrayList<SchedulingRuleResult>();
		
		if(CollectionUtils.isNotEmpty(list)){
			//遍历获取值次名称
			for (SchedulingRule schedulingRuleTemp : list) {
				
				SchedulingRuleResult schedulingRuleResult = new SchedulingRuleResult();
				//设置返回的schedulingRules属性值
				schedulingRuleResult.setSchedulingRuleId(schedulingRuleTemp.getSchedulingRuleId());
				schedulingRuleResult.setSchedulingRuleCode(schedulingRuleTemp.getSchedulingRuleCode());
				schedulingRuleResult.setSchedulingRule(schedulingRuleTemp.getSchedulingRule());
				schedulingRuleResult.setDepartment(schedulingRuleTemp.getDepartment());
				schedulingRuleResult.setRotationCycle(schedulingRuleTemp.getRotationCycle());
				schedulingRuleResult.setStatus(schedulingRuleTemp.getStatus());
				
				
				List<ValueTime> valueTimes = valueTimeService.getValueTimes(schedulingRuleTemp.getSchedulingRuleId());
				//创建存放valueCode集合
				Set<String> valueCodes = new HashSet<String>();
				//如果不为空
				if (CollectionUtils.isNotEmpty(valueTimes)) {
					for (ValueTime valueTime : valueTimes) {
						valueCodes.add(valueTime.getValueCode());
					}
					schedulingRuleResult.setValueCodeList(valueCodes);
				}
				results.add(schedulingRuleResult);
			}
			
			PageInfo<SchedulingRule> pageInfo = new PageInfo<SchedulingRule>(list);
			pageResultEntity.setRows(results);
			pageResultEntity.setTotal((int)pageInfo.getTotal());
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setMsg("查询成功");
			
			return pageResultEntity;
		}else{
			return pageResultEntity;
		}
		
	}
	
	
	
	
	/**
	 * @Description:根据排班规则表 id 批量删除排班规则表信息
	 * @param: @param schedulingRuleId：勾选被删除的排班规则id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeSchedulingRule",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="勾选复选框按钮进行删除", value="删除排班规则表信息")
	public ResultEntity removeSchedulingRule(@RequestParam List<String> schedulingRuleIds){
		return schedulingRuleService.removeSchedulingRule(schedulingRuleIds);
	}
	
	/**
	 * @Description:批量更新排班规则表
	 * @param: @param schedulingRules
	 * @param: @return   
	 * @return: ResultEntity
	 */
	/*
	@RequestMapping(value="/editSchedulingRule" , method=RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="批量更新排班规则表",value="批量更新排班规则表")
	public ResultEntity editSchedulingRule(@RequestBody List<SchedulingRule> schedulingRules){
		
		ResultEntity resultEntity = new ResultEntity();
		//检查修改之后的字段是否为空
		if (CollectionUtils.isNotEmpty(schedulingRules)) {
			for (SchedulingRule schedulingRule : schedulingRules) {
				try {
					boolean fieldBlank = ObjectIsBlankUtil.isExistFieldBlank(schedulingRule);
					if(fieldBlank){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("请填写完整");
						return resultEntity;
					}
				} catch (Exception e) {
					e.printStackTrace();
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("未知错误");
					return resultEntity;
				}
			}
			
		}
		return schedulingRuleService.editSchedulingRule(schedulingRules);
	}
	*/
	
	
	/**
	 * @Description:批量更新排班规则表
	 * @param: @param schedulingRules
	 * @param: @return   
	 * @return: ResultEntity
	 */
	
	@RequestMapping(value="/editSchedulingRule" , method=RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="批量更新排班规则表",value="批量更新排班规则表")
	public ResultEntity editSchedulingRule(@RequestBody SaveSchedulingRuleSubmit saveSchedulingRuleSubmit){
		
		//声明返回对象
		ResultEntity resultEntity = new ResultEntity();
		
		//从json数据串中获取 schedulingRule 对象    有id值
		SchedulingRule schedulingRule = saveSchedulingRuleSubmit.getSchedulingRule();
		
		//从json数据串中获取封装好的 userId, valueCode 集合对象
		List<UserValueCodeResult> userValueCodeResults = saveSchedulingRuleSubmit.getUserValueCodeResults();
		
		//从json数据串中获取封装好的 shiftCode, valueCode 集合对象
		List<ShiftValueCodeResult> shiftValueCodeResults = saveSchedulingRuleSubmit.getShiftValueCodeResults();
				
		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(schedulingRule.getDayNum()) || StringUtils.isBlank(schedulingRule.getDepartment())
				|| StringUtils.isBlank(schedulingRule.getIsAcrossDay())
				|| StringUtils.isBlank(schedulingRule.getRotationCycle())
				|| StringUtils.isBlank(schedulingRule.getSchedulingRule())
				|| StringUtils.isBlank(schedulingRule.getSchedulingRuleCode())
				|| StringUtils.isBlank(schedulingRule.getSchedulingShift())
				|| StringUtils.isBlank(schedulingRule.getStatus())
				|| CollectionUtils.isEmpty(shiftValueCodeResults)
				|| CollectionUtils.isEmpty(shiftValueCodeResults)) {
			
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段，添加失败");
			return resultEntity;
		}else{
			//所有字段正常
			//调用更新接口
			schedulingRuleService.updateSchedulingRule(schedulingRule);
			
			//根据排班规则id删除排班班次值次关联表  在执行插入   即为更新
			ruleShiftValueService.removeRuleShiftValueBySchedulingRuleId(schedulingRule.getSchedulingRuleId());
			
			//执行插入操作
			for (UserValueCodeResult valueCodeResult : userValueCodeResults) {
				//值次code
				String valueCode = valueCodeResult.getValueCode();
				//通过值次code获取值次id
				String valueTimeId = valueTimeService.getValueTimeIdByValueCode(valueCode);
				//用户id
				String userId = valueCodeResult.getUserId();
				//封装人员值次关联表信息
				UserValueTime userValueTime = new UserValueTime();
				
				userValueTime.setSchedulingRuleId(schedulingRule.getSchedulingRuleId());
				userValueTime.setUserId(userId);
				userValueTime.setValueId(valueTimeId);
				//调用接口保存用户值次关联表
				userValueTimeService.saveUserValueTime(userValueTime);
			}
			
			//插入成功之后接着添加关联的 排班班次值次关联表
			for (ShiftValueCodeResult shiftValueCodeResult : shiftValueCodeResults) {
				//值次code
				String valueCode = shiftValueCodeResult.getValueCode();
				//通过值次code获取值次id
				String valueTimeId = valueTimeService.getValueTimeIdByValueCode(valueCode);
				//班次code
				String shiftCode = shiftValueCodeResult.getShiftCode();
				//通过班次code获取班次id
				String shiftId = shiftService.getShiftIdByCode(shiftCode);
				//封装排班班次值次对象
				RuleShiftValue ruleShiftValue = new RuleShiftValue();
				ruleShiftValue.setSchedulingRuleId(schedulingRule.getSchedulingRuleId());
				ruleShiftValue.setShiftId(shiftId);
				ruleShiftValue.setValueId(valueTimeId);
				ruleShiftValueService.saveRuleShiftValue(ruleShiftValue);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			return resultEntity;
		}
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getSchedulingRule" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getSchedulingRule(@RequestParam String schedulingRuleId){
		
		ResultEntity resultEntity = new ResultEntity();

		// 如果数据不为空
		if (StringUtils.isNotBlank(schedulingRuleId)) {
			
			
			SchedulingRuleExample example = new SchedulingRuleExample();
			example.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId);
			
			// 执行查询操作
			List<SchedulingRule> list = schedulingRuleService.listSchedulingRule(example, 0, 0);
			
			
			//声明返回的对象
			List<SchedulingRuleResult> results = new ArrayList<SchedulingRuleResult>();
			
			if(CollectionUtils.isNotEmpty(list)){
				//遍历获取值次名称
				for (SchedulingRule schedulingRuleTemp : list) {
					
					SchedulingRuleResult schedulingRuleResult = new SchedulingRuleResult();
					//设置返回的schedulingRules属性值
					schedulingRuleResult.setSchedulingRuleId(schedulingRuleTemp.getSchedulingRuleId());
					schedulingRuleResult.setSchedulingRuleCode(schedulingRuleTemp.getSchedulingRuleCode());
					schedulingRuleResult.setSchedulingRule(schedulingRuleTemp.getSchedulingRule());
					schedulingRuleResult.setDepartment(schedulingRuleTemp.getDepartment());
					schedulingRuleResult.setRotationCycle(schedulingRuleTemp.getRotationCycle());
					schedulingRuleResult.setStatus(schedulingRuleTemp.getStatus());
					
					
					List<ValueTime> valueTimes = valueTimeService.getValueTimes(schedulingRuleTemp.getSchedulingRuleId());
					//创建存放valueCode集合
					Set<String> valueCodes = new HashSet<String>();
					//如果不为空
					if (CollectionUtils.isNotEmpty(valueTimes)) {
						for (ValueTime valueTime : valueTimes) {
							valueCodes.add(valueTime.getValueCode());
						}
						schedulingRuleResult.setValueCodeList(valueCodes);
					}
					results.add(schedulingRuleResult);
				}
				
			}
			
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(results);
			return resultEntity;
		}
		
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("缺少字段");
		return resultEntity;

	}
	
	
	
	
}
