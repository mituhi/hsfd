package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.common.entity.Common;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.run.entity.*;
import com.qz.zframe.tally.entity.IscUser;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingRuleExample.Criteria;
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
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: SchedulingRuleController</p>
 * <p>@Description: 排班规则控制层 </p>
 * @author 
 * @date 2018年10月31日 下午4:47:52
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/SchedulingRule")
@Api(tags = "api-support-api-support-SchedulingRule", description = "运行-排班管理-排班规则")
@Transactional(rollbackFor = Exception.class)
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

	@Autowired
	private OrgArchitectureService orgArchitectureService;

	@Autowired
	private CommonService commonService;

	
	
	
	/**
	 * @Description:新增排班规则信息
	 * @param: @param saveSchedulingRuleSubmit
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveSchedulingRule",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="新增排班规则信息",value="新增排班规则信息")
	public ResultEntity saveSchedulingRule(@RequestBody SaveSchedulingRuleSubmit saveSchedulingRuleSubmit){
		ResultEntity resultEntity = new ResultEntity();//声明返回对象
		SchedulingRule schedulingRule = saveSchedulingRuleSubmit.getSchedulingRule();//从json数据串中获取 schedulingRule 对象
		List<UserValueCodeResult> userValueCodeResults = saveSchedulingRuleSubmit.getUserValueCodeResults();//从json数据串中获取封装好的 userId, valueCode 集合对象
		List<ShiftValueCodeResult> shiftValueCodeResults = saveSchedulingRuleSubmit.getShiftValueCodeResults();//从json数据串中获取封装好的 shiftCode, valueCode 集合对象
		// 一 判断字段是否异常（为空）
		if (shiftValueCodeResults==null||shiftValueCodeResults.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段轮值值别或者排班班次，添加失败");
			return resultEntity;
		}else if (userValueCodeResults==null||userValueCodeResults.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少值次人员相关，添加失败");
			return resultEntity;
		} else if (StringUtils.isBlank(schedulingRule.getSchedulingRuleCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段排班编号，添加失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getSchedulingRule())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段排班规则，添加失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getWindCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段风电场，添加失败");
			return resultEntity;
		}else if (schedulingRuleService.findSchedulingRuleCode(schedulingRule.getSchedulingRuleCode())>0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排班编号重复，添加失败");
			return resultEntity;
		} else if (schedulingRuleService.countBySchedulingRuleCode(schedulingRule.getSchedulingRuleCode())>0){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("重复规则编号，添加失败");
				return resultEntity;
		}else{
			//二 所有字段正常
			//1.添加 schedulingRule 字段
			//1.1生成id
			String schedulingRuleId=schedulingRuleService.count();
			schedulingRule.setSchedulingRuleId(schedulingRuleId);
			//1.2调用接口 保存排班规则主表
			schedulingRuleService.saveSchedulingRule(schedulingRule);
			//2.插入成功之后接着添加关联的用户值次关联表
			for (UserValueCodeResult valueCodeResult : userValueCodeResults) {
				String valueTimeId = valueCodeResult.getValueTimeId();//值次Id
				String userId = valueCodeResult.getUserId();//用户id
				//2.1.如果用户id包含,
				if(userId.contains(",")){
					String[] userIdArr = userId.split(",");
					for (String userIdTemp : userIdArr) {
						//2.1.1封装人员值次关联表信息
						UserValueTime userValueTime = new UserValueTime();
						userValueTime.setSchedulingRuleId(schedulingRuleId);
						userValueTime.setUserId(userIdTemp);
						userValueTime.setValueId(valueTimeId);
						//2.1.2调用接口保存用户值次关联表
						userValueTimeService.saveUserValueTime(userValueTime);
					}
				}else{
					UserValueTime userValueTime = new UserValueTime();
					
					userValueTime.setSchedulingRuleId(schedulingRuleId);
					userValueTime.setUserId(userId);
					userValueTime.setValueId(valueTimeId);
					//调用接口保存用户值次关联表
					userValueTimeService.saveUserValueTime(userValueTime);
				}
			}
			
			//插入成功之后接着添加关联的 排班班次值次关联表
			for (ShiftValueCodeResult shiftValueCodeResult : shiftValueCodeResults) {
				//值次Id
				String valueId = shiftValueCodeResult.getValueId();
				//班次Id
				String shiftId = shiftValueCodeResult.getShiftId();
				//t天次Id
				String dayId = shiftValueCodeResult.getDayId();
				//封装排班班次值次对象
				RuleShiftValue ruleShiftValue = new RuleShiftValue();
				ruleShiftValue.setSchedulingRuleId(schedulingRuleId);
				ruleShiftValue.setShiftId(shiftId);
				ruleShiftValue.setValueId(valueId);
				ruleShiftValue.setDayId(dayId);
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
	public PageResultEntity listSchedulingRule(@RequestParam(required = false) @ApiParam(name="windCode",value="风电场") String windCode,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();

		// 执行查询操作
		List<SchedulingRule> list = schedulingRuleService.listSchedulingRule(windCode, pageNum, pageSize);
		
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
				schedulingRuleResult.setWindCode(schedulingRuleTemp.getWindCode());
				schedulingRuleResult.setRotationCycle(schedulingRuleTemp.getRotationCycle());
				schedulingRuleResult.setStatus(schedulingRuleTemp.getStatus());
				schedulingRuleResult.setWindName(schedulingRuleTemp.getWindName());

				List<ValueTime> valueTimes = valueTimeService.getValueTimes(schedulingRuleTemp.getSchedulingRuleId());
				if (valueTimes==null||valueTimes.isEmpty()){
					pageResultEntity.setCode(ErrorCode.ERROR);
					pageResultEntity.setMsg("没有对应的值次数据！");
					return pageResultEntity;
				}
				//创建存放valueCode集合
				Set<String> valueCodes = new HashSet<String>();
				StringBuilder sb=new StringBuilder();
				//如果不为空
				if (CollectionUtils.isNotEmpty(valueTimes)) {
					for (ValueTime valueTime : valueTimes) {
						valueCodes.add(valueTime.getValueCode());
						sb.append(valueTime.getValueName()+",");
					}
					String s=sb.toString();
					schedulingRuleResult.setValueCodes(s.substring(0,s.length()-1));
					schedulingRuleResult.setValueCodeList(valueCodes);
				}
                List<Shift> shifts=schedulingRuleService.getShifts(schedulingRuleTemp.getSchedulingRuleId());
				StringBuilder sb2=new StringBuilder();
				if (CollectionUtils.isNotEmpty(shifts)){
					for (Shift shift:shifts){
						sb2.append(shift.getShiftName()+",");
					}
					String s2=sb2.toString();
					schedulingRuleResult.setShifts(s2.substring(0,s2.length()-1));
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
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false) @ApiParam(name="departments",value="风电场") List<String> departments,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			HttpServletResponse response) {
		
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
		List<SchedulingRule> list = schedulingRuleService.listSchedulingRule(null, 0, 0);
		
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
				schedulingRuleResult.setWindCode(schedulingRuleTemp.getWindCode());
				schedulingRuleResult.setRotationCycle(schedulingRuleTemp.getRotationCycle());
				schedulingRuleResult.setStatus(schedulingRuleTemp.getStatus());
				
				
				List<ValueTime> valueTimes = valueTimeService.getValueTimes(schedulingRuleTemp.getSchedulingRuleId());
				//创建存放valueName集合
				Set<String> valueNames = new HashSet<String>();
				//如果不为空
				if (CollectionUtils.isNotEmpty(valueTimes)) {
					for (ValueTime valueTime : valueTimes) {
						valueNames.add(valueTime.getValueName());
					}
					schedulingRuleResult.setValueCodeList(valueNames);
				}
				results.add(schedulingRuleResult);
			}
		}	
		
		//遍历结果集合：设置值别字段在Excel中并排显示
		for (SchedulingRuleResult schedulingRuleResult : results) {
			if(CollectionUtils.isNotEmpty(schedulingRuleResult.getValueCodeList())){
				
			//获取值次集合
			Set<String> valueNameList = schedulingRuleResult.getValueCodeList();
			//存放到一起
			String valueNameStr = "";
			for (String valueName : valueNameList) {
				valueNameStr = valueNameStr + valueName + ",";
			}
			//去掉最后的,
			valueNameStr = valueNameStr.substring(0, valueNameStr.length()-1);
			//设置
			schedulingRuleResult.setValueCodeStr(valueNameStr);
			}
		}

		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("schedulingRuleCode", "班次规则编码");
		testMap.put("schedulingRule", "排班规则名称");
		testMap.put("department", "风电场");
		testMap.put("rotationCycle", "轮换周期");
		testMap.put("valueCodeStr", "值别");
		testMap.put("status", "状态");
		
		try {
			String fileName = ExcelUtil.listToExcel2(results, testMap, "排班规则", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
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
	public ResultEntity removeSchedulingRule(@RequestParam @ApiParam(name="schedulingRuleIds",value="勾选的schedulingRuleId") List<String> schedulingRuleIds){
		return schedulingRuleService.removeSchedulingRule(schedulingRuleIds);
	}
	
	
	
	/**
	 * @Description:更新排班规则表
	 * @param: @param schedulingRules
	 * @param: @return   
	 * @return: ResultEntity
	 */
	
	@RequestMapping(value="/editSchedulingRule" , method=RequestMethod.PUT , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="更新排班规则表",value="更新排班规则表")
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
		// 判断字段是否异常（为空）
		if (shiftValueCodeResults==null||shiftValueCodeResults.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段轮值值别或者排班班次，更新失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getSchedulingRuleCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段排班编号，更新失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getSchedulingRule())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段排班规则，更新失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getWindCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段风电场，更新失败");
			return resultEntity;
		}else if (StringUtils.isBlank(schedulingRule.getSchedulingRuleId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段排班规则id，更新失败");
			return resultEntity;
		} else if (schedulingRuleService.countBySchedulingRuleId(schedulingRule.getSchedulingRuleId())==0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("无效排班规则id，更新失败");
			return resultEntity;
		} else if ((!(schedulingRuleService.findSchedulingRuleCodeById(schedulingRule.getSchedulingRuleId()).equals(schedulingRule.getSchedulingRuleCode())))&&(schedulingRuleService.countBySchedulingRuleCode(schedulingRule.getSchedulingRuleCode())>0)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("重复规则编号，更新失败");
			return resultEntity;
		}
		else{
			//所有字段正常
			//调用更新接口
			schedulingRuleService.updateSchedulingRule(schedulingRule);
			
			//根据排班规则id删除排班班次值次关联表  在执行插入   即为更新
			ruleShiftValueService.removeRuleShiftValueBySchedulingRuleId(schedulingRule.getSchedulingRuleId());
			
			//执行插入操作
			for (UserValueCodeResult valueCodeResult : userValueCodeResults) {
				//值次Id
				String valueTimeId = valueCodeResult.getValueTimeId();
				//用户id
				String userId = valueCodeResult.getUserId();
				//如果用户id包含,
				if(userId.contains(",")){
					String[] userIdArr = userId.split(",");
					for (String userIdTemp : userIdArr) {
						//封装人员值次关联表信息
						UserValueTime userValueTime = new UserValueTime();

						userValueTime.setSchedulingRuleId(schedulingRule.getSchedulingRuleId());
						userValueTime.setUserId(userIdTemp);
						userValueTime.setValueId(valueTimeId);
						//调用接口保存用户值次关联表
						userValueTimeService.saveUserValueTime(userValueTime);
					}
				}else{
					UserValueTime userValueTime = new UserValueTime();

					userValueTime.setSchedulingRuleId(schedulingRule.getSchedulingRuleId());
					userValueTime.setUserId(userId);
					userValueTime.setValueId(valueTimeId);
					//调用接口保存用户值次关联表
					userValueTimeService.saveUserValueTime(userValueTime);
				}
			}
			
			//插入成功之后接着添加关联的 排班班次值次关联表
			for (ShiftValueCodeResult shiftValueCodeResult : shiftValueCodeResults) {
				//值次code
				String valueTimeId = shiftValueCodeResult.getValueId();
				//班次code
				String shiftId = shiftValueCodeResult.getShiftId();

				String dayId=shiftValueCodeResult.getDayId();
				//封装排班班次值次对象
				RuleShiftValue ruleShiftValue = new RuleShiftValue();
				ruleShiftValue.setSchedulingRuleId(schedulingRule.getSchedulingRuleId());
				ruleShiftValue.setShiftId(shiftId);
				ruleShiftValue.setValueId(valueTimeId);
				ruleShiftValue.setDayId(dayId);
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
	public ResultEntity getSchedulingRule(@RequestParam @ApiParam(name="schedulingRuleId",value="勾选的schedulingRuleId") String schedulingRuleId) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		//返回的对象信息：SaveSchedulingRuleSubmit saveSchedulingRuleSubmit

		SaveSchedulingRuleSubmit saveSchedulingRuleSubmit = new SaveSchedulingRuleSubmit();

		//1.通过排班规则表查询排班规则信息
		SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
		List<String> valueIdsS=schedulingRuleService.findValueIdsBySchedulingRuleById(schedulingRuleId);
		List<String> shiftIdsS=schedulingRuleService.findShiftIdsBySchedulingRuleById(schedulingRuleId);
		if (schedulingRule==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有排班规则！！");
			return resultEntity;
		}
        schedulingRule.setShiftIds(shiftIdsS);
		schedulingRule.setValueIds(valueIdsS);
		//设置排班规则信息
		saveSchedulingRuleSubmit.setSchedulingRule(schedulingRule);

		//2.得到集合
		List<RuleShiftValue> ruleShiftValues = ruleShiftValueService.getRuleShiftValuesBySchedulingRuleId(schedulingRuleId);
		if (ruleShiftValues==null||ruleShiftValues.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有找到规则相应的排班值次班次！！");
			return resultEntity;
		}

		//创建返回的值次-班次code的集合对象
		List<ShiftValueCodeResult> shiftValueCodeResults = new ArrayList<ShiftValueCodeResult>();

		//保存值次id集合
		List<String> valueIds = new ArrayList<String>();

		//遍历得到值次-班次code的集合
		for (RuleShiftValue ruleShiftValue : ruleShiftValues) {
			String valueId=ruleShiftValue.getValueId();
			ShiftValueCodeResult shiftValueCodeResult = new ShiftValueCodeResult();
			shiftValueCodeResult.setShiftId(ruleShiftValue.getShiftId());//班次
			shiftValueCodeResult.setValueId(valueId);//值次
			shiftValueCodeResult.setDayId(ruleShiftValue.getDayId());//天次
			shiftValueCodeResults.add(shiftValueCodeResult);
			if(!valueIds.contains(valueId)){
				valueIds.add(valueId);
			}
		}

		saveSchedulingRuleSubmit.setShiftValueCodeResults(shiftValueCodeResults);

		//存放用户id，值次编码集合
		List<UserValueCodeResult> userValueCodeResults = new ArrayList<UserValueCodeResult>();

		//通过排班规则表查询人员值次关联表
		for (String valueId : valueIds) {
			//里面对应了值班人员---》指定排班规则---》指定值次---》指定班次的值班人员
			List<UserValueTime> list = userValueTimeService.getUserValueTimeByValueIdAndSchedulingRuleId(valueId, schedulingRuleId);
			if (list==null||list.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("没有找到规则相应的值次人员！！");
				return resultEntity;
			}
			UserValueCodeResult userValueCodeResult = new UserValueCodeResult();
			List<IscUser> iscUsers=new ArrayList<IscUser>();
			for (UserValueTime userValueTime : list) {
				IscUser iscUser=new IscUser();
				String userId = userValueTime.getUserId();
				iscUser.setUserId(userId);
				Common userBaseMsg = commonService.findUserBaseMsg(userId);
				if (userBaseMsg==null){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("没有找到id对应的人员！！");
					return resultEntity;
				}
				iscUser.setUserName(userBaseMsg.getUserName());
                iscUsers.add(iscUser);
			}
			userValueCodeResult.setValueTimeId(valueId);
			userValueCodeResult.setUsers(iscUsers);
			userValueCodeResults.add(userValueCodeResult);
		}

		saveSchedulingRuleSubmit.setUserValueCodeResults(userValueCodeResults);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(saveSchedulingRuleSubmit);
		return resultEntity;


	}
	
	/*************************    点击查看：获取对应信息               ***************************/
	@RequestMapping(value="/viewSchedulingRule" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取对应信息 ", notes="点击查看：获取对应信息")
	public ResultEntity viewSchedulingRule(@RequestParam @ApiParam(name="schedulingRuleId",value="勾选的schedulingRuleId") String schedulingRuleId){

		//返回的对象信息：SaveSchedulingRuleSubmit saveSchedulingRuleSubmit
		
		SaveSchedulingRuleSubmit saveSchedulingRuleSubmit = new SaveSchedulingRuleSubmit();
		
		//通过排班规则表查询排班规则信息
		SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
		
		//设置排班规则信息
		saveSchedulingRuleSubmit.setSchedulingRule(schedulingRule);

		//通过排班规则表查询排班班次值次关联表
		RuleShiftValueExample example = new RuleShiftValueExample();
		example.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId);
		
		//得到集合
		List<RuleShiftValue> ruleShiftValues = ruleShiftValueService.getRuleShiftValues(example, 0, 0);
		
		//创建返回的值次-班次code的集合对象
		List<ShiftValueCodeResult> shiftValueCodeResults = new ArrayList<ShiftValueCodeResult>();
		
		//保存值次id集合
		List<String> valueIds = new ArrayList<String>();
		
		//遍历得到值次-班次code的集合
		for (RuleShiftValue ruleShiftValue : ruleShiftValues) {
			ShiftValueCodeResult shiftValueCodeResult = new ShiftValueCodeResult();
			//通过id获取对象
			ValueTime valueTime = valueTimeService.getValueTimeById(ruleShiftValue.getValueId());
			//保存值次id
			valueIds.add(valueTime.getValueId());
			//通过id获取对象
			Shift shift = shiftService.getShiftByShiftId(ruleShiftValue.getShiftId());
			shiftValueCodeResult.setShiftId(shift.getShiftCode());
			shiftValueCodeResult.setValueId(valueTime.getValueCode());
			shiftValueCodeResults.add(shiftValueCodeResult);
		}
		
		saveSchedulingRuleSubmit.setShiftValueCodeResults(shiftValueCodeResults);
		
		//存放用户id，值次编码集合
		List<UserValueCodeResult> userValueCodeResults = new ArrayList<UserValueCodeResult>();
		
		//通过排班规则表查询人员值次关联表
		for (String valueId : valueIds) {
			//里面对应了值班人员---》指定排班规则---》指定值次---》指定班次的值班人员
			List<UserValueTime> list = userValueTimeService.getUserValueTimeByValueIdAndSchedulingRuleId(valueId, schedulingRuleId);
			UserValueCodeResult userValueCodeResult = new UserValueCodeResult();
			
			for (UserValueTime userValueTime : list) {
				userValueCodeResult.setUserId(userValueTime.getUserId());
				String valueId2 = userValueTime.getValueId();
				//通过valueid获取对象
				ValueTime valueTime = valueTimeService.getValueTimeById(valueId2);
				userValueCodeResult.setValueTimeId(valueTime.getValueCode());
				userValueCodeResults.add(userValueCodeResult);
			}
		}
		
		saveSchedulingRuleSubmit.setUserValueCodeResults(userValueCodeResults);
		
		ResultEntity resultEntity = new ResultEntity();
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(saveSchedulingRuleSubmit);
		return resultEntity;
		
		
	}

	@ApiOperation(value="排班额外接口", notes="通过排班规则Id和相应时间" ,httpMethod="GET")
	@RequestMapping("GetShiftValueUsers")
	@ResponseBody
	public ResultEntity GetShiftValueUsers(
			@RequestParam @ApiParam(name="schedulingRuleId",value="排班规则id")String schedulingRuleId,
			@RequestParam @ApiParam(name="startTime",value="开始时间")String startTime,
			@RequestParam @ApiParam(name="endTime",value="结束时间")String endTime
	) throws ParseException {
		Example example=new Example();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		example.setSchedulingRuleId(schedulingRuleId);
		example.setStartTime(sdf.parse(startTime));
		example.setEndTime(sdf.parse(endTime));
		ResultEntity resultEntity=schedulingRuleService.findShiftValueUsers(example);
		return resultEntity;
	}

	@ApiOperation(value="排班额外接口(根据当前日期)", notes="通过排班规则Id和相应时间" ,httpMethod="GET")
	@RequestMapping("GetShiftValueUsersByCurrentTime")
	@ResponseBody
	public ResultEntity GetShiftValueUsersByCurrentTime(
			@RequestParam @ApiParam(name="schedulingRuleId",value="排班规则id")String schedulingRuleId,
			@RequestParam @ApiParam(name="startTime",value="开始时间")String startTime,
			@RequestParam @ApiParam(name="currentTime",value="当前时间")String currentTime
	) throws ParseException {
		ResultEntity resultEntity=new ResultEntity();

		resultEntity=schedulingRuleService.findShiftValueUsers(schedulingRuleId, startTime, currentTime);

		return resultEntity;
	}
	
}
