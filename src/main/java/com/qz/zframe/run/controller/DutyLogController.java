package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogExample;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;
import com.qz.zframe.run.entity.DutyRemember;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import com.qz.zframe.run.entity.SchedulingAssociatedExample.Criteria;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.result.DutyLogResult;
import com.qz.zframe.run.entity.submit.DutyLogSubmit;
import com.qz.zframe.run.service.DutyInfoService;
import com.qz.zframe.run.service.DutyLogService;
import com.qz.zframe.run.service.DutyLogTabService;
import com.qz.zframe.run.service.DutyRememberService;
import com.qz.zframe.run.service.LogTypeService;
import com.qz.zframe.run.service.RuleShiftValueService;
import com.qz.zframe.run.service.SchedulingAssociatedService;
import com.qz.zframe.run.service.SchedulingManagementService;
import com.qz.zframe.run.service.ShiftService;
import com.qz.zframe.run.service.UserValueTimeService;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: DutyLogController</p>
 * <p>@Description: 值班日志配置 </p>
 * @author 陈汇奇
 * @date 2018年11月12日 上午10:44:05
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/DutyLog")
@Api(tags = "api-support-api-support-DutyLog", description = "运行-日志管理-配置-值班日志配置")
public class DutyLogController {

	@Autowired
	private DutyLogService dutyLogService;
	
	@Autowired
	private DutyLogTabService dutyLogTabService;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private LogTypeService logTypeService;
	
	@Autowired
	private SchedulingManagementService schedulingManagementService;
	
	@Autowired
	private DutyRememberService dutyRememberService;
	
	@Autowired
	private SchedulingAssociatedService schedulingAssociatedService;
	
	@Autowired
	private ShiftService shiftService;
	
	@Autowired
	private UserValueTimeService userValueTimeService;
	
	@Autowired
	private RuleShiftValueService ruleShiftValueService;
	
	@Autowired
	private ValueTimeService valueTimeService;
	
	@Autowired
	private DutyInfoService dutyInfoService;
	
	/**
	 * @Description:保存操作
	 * @param: @param dutyLog
	 * @param: @param dutyRemember
	 * @param: @param dutyLogTab
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveDutyLog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班日志表信息添加", value = "值班日志表信息添加")
	public ResultEntity saveDutyLog(@RequestBody DutyLogSubmit dutyLogSubmit){
		
		//从提交对象中取出
		DutyLog dutyLog = dutyLogSubmit.getDutyLog();
		DutyRemember dutyRemember = dutyLogSubmit.getDutyRemember();
		DutyInfo dutyInfo = dutyLogSubmit.getDutyInfo();
		
		//创建返回对象
		ResultEntity resultEntity = new ResultEntity();
		
		//生成值班日志表：dutyLogId
		String dutyLogId = UUID.randomUUID().toString();
		   
		//生成当班记事表：dutyId
		String dutyId = UUID.randomUUID().toString();
		
		
		//通过日志类型查找日志id
		
		LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogTypeEqualTo(dutyLog.getLogType());
		LogType logType = logTypeService.getLogTypeByLogType(example);
		
		if(logType==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型查找失败");
			return resultEntity;
		}
		
		//通过排班表获取排版管理表id
		String schedulingName = dutyLog.getSchedulingName();
		SchedulingManagement schedulingManagement = schedulingManagementService.getSchedulingManagementBySchedulingName(schedulingName);
		
		
		//完善字段
		dutyLog.setDutyLogId(dutyLogId);
		//日志类型id
		dutyLog.setLogTypeId(logType.getLogTypeId());
		//日志名称
		dutyLog.setLogName(logType.getLogName());
		//排版管理表id
		dutyLog.setSchedulingManagementId(schedulingManagement.getSchedulingManagementId());
		
		//值班人员:先用ids
		//*****
		
		//当班记事表id
		dutyLog.setDutyRememberId(dutyId);

		//维护人
		/**
		 * 暂未登录：模拟
		 */
		//dutyLog.setMaintainUser(currentUserService.getUsername());
		dutyLog.setMaintainUser("zzz");
		
		//维护日期
		dutyLog.setUpdateTime(new Date());
		
		//执行保存值班日志表操作
		resultEntity = dutyLogService.saveDutyLog(dutyLog);
		
		//执行成功之后保存：运行记事
		//设置id
		dutyRemember.setDutyId(dutyId);
		
		
		//设置记事人
		/**
		 * 暂未登录：模拟
		 */
		//dutyRemember.setRemember(currentUserService.getUsername());
		dutyRemember.setRemember("zzz");
		
		//设置值班日志表id
		dutyRemember.setRunLogId(dutyLogId);
		//设置时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(date);
		dutyRemember.setRememberTime(dateString);
		
		//执行保存记事表操作
		dutyRememberService.saveDutyRemember(dutyRemember);
		
		
		//准备保存值班信息表信息
		//设置值班日志表id
		dutyInfo.setDutyLogId(dutyLogId);
		//设置值班启用时间
		String shiftName = dutyInfo.getShiftName();
		//根据班次名称获取id
		Shift shift = shiftService.getShiftByShiftName(shiftName);
		//设置班次id
		dutyInfo.setShiftId(shift.getShiftId());
		//根据值次获取id
		ValueTime valueTime = valueTimeService.getValueTimeByValueName(dutyInfo.getValueName());
		//设置值次id
		dutyInfo.setValueId(valueTime.getValueId());
		/**
		 * 这里值班人员提交是个问题
		 */
		
		//执行插入
		dutyInfoService.saveDutyInfo(dutyInfo);
		
		
		//通过班次id和值次id查询排班规则id
		
		
		//更新人员值次关联表
		
		//知道排班规则表id，值次id，更新userId
		RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
		ruleShiftValueExample.createCriteria().andShiftIdEqualTo(shift.getShiftId()).andValueIdEqualTo(valueTime.getValueId());
		List<RuleShiftValue> list = ruleShiftValueService.getRuleShiftValues(ruleShiftValueExample, 0, 0);
		RuleShiftValue ruleShiftValue;
		if(list!=null && list.size() >= 0){
			 ruleShiftValue = list.get(0);
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("更新人员值次关联表失败");
			return resultEntity;
		}
		
		//先删除--->再添加
		userValueTimeService.deleteUserValueTimeBySchedulingRuleIdAndValueId(valueTime.getValueId(), ruleShiftValue.getSchedulingRuleId());
		
		//添加：如果userid是集合
		String userIds = dutyInfo.getDutyUserIds();
		if(userIds.contains(",")){
			String[] userIdArr = userIds.split(",");
			for (String userId : userIdArr) {
				//执行保存操作
				UserValueTime userValueTime = new UserValueTime();
				userValueTime.setSchedulingRuleId(ruleShiftValue.getSchedulingRuleId());
				userValueTime.setUserId(userId);
				userValueTime.setValueId(valueTime.getValueId());
				userValueTimeService.saveUserValueTime(userValueTime);
			}
		}else{
			//如果userid就是一个
			UserValueTime userValueTime = new UserValueTime();
			userValueTime.setSchedulingRuleId(ruleShiftValue.getSchedulingRuleId());
			userValueTime.setUserId(userIds);
			userValueTime.setValueId(valueTime.getValueId());
			userValueTimeService.saveUserValueTime(userValueTime);
		}
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * 点击选择日志TAB
	 */
	@RequestMapping(value = "/chooseLogTAB", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "获取日志TAB", value = "获取日志TAB")
	public PageResultEntity chooseLogTAB(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DutyLogTabExample example = new DutyLogTabExample();
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example, pageNo, pageSize);
		// 设置返回结果
		PageInfo<DutyLogTab> pageInfo = new PageInfo<DutyLogTab>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	/**
	 * 选择启用时间，选择班次，获取值次，值班人员
	 */
	@RequestMapping(value = "/getValueAndUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "选择启用时间，选择班次，获取值次，值班人员", value = "选择启用时间，选择班次，获取值次，值班人员")
	public ResultEntity getValueAndUsers(@RequestParam String schedulingName,
			@RequestParam String startTime , @RequestParam String shiftName){

		ResultEntity resultEntity = new ResultEntity();
		
		//1：通过排班表名称获取排版管理表id
		SchedulingManagement schedulingManagement = schedulingManagementService.getSchedulingManagementBySchedulingName(schedulingName);
		
		//得到schedulingManagementId
		String schedulingManagementId = schedulingManagement.getSchedulingManagementId();
		
		//2：通过排版管理表id 和 启用时间 查询得到 排班规则表id
		SchedulingAssociatedExample example = new SchedulingAssociatedExample();
		Criteria criteria = example.createCriteria();
		
		//设置时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startTimeDate = null;
		try {
			startTimeDate = format.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("时间解析出错");
			return resultEntity;
		}
		
		//封装查询条件
		criteria.andStartTimeLessThanOrEqualTo(startTimeDate);
		criteria.andEndTimeGreaterThanOrEqualTo(startTimeDate);
		criteria.andSchedulingManagementIdEqualTo(schedulingManagementId);
		
		//执行查询
		List<SchedulingAssociated> list = schedulingAssociatedService.listSchedulingAssociated(example, 0, 0);
		SchedulingAssociated schedulingAssociated = null ;
		if(list!=null && list.size()>=0){
			 schedulingAssociated = list.get(0);
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		//得到排班规则表id
		String schedulingRuleId = schedulingAssociated.getSchedulingRuleId();
			
		//3：根据班次名称 获取 班次id
		Shift shift = shiftService.getShiftByShiftName(shiftName);
		if(shift==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		
		//获取班次id
		String shiftId = shift.getShiftId();
		
		
		//4：根据排班规则表id 班次id ，获取值次id
		RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
		ruleShiftValueExample.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId).andShiftIdEqualTo(shiftId);
		
		List<RuleShiftValue> ruleShiftValues = ruleShiftValueService.getRuleShiftValues(ruleShiftValueExample, 0, 0);
		if(ruleShiftValues==null || ruleShiftValues.size() == 0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		 
		RuleShiftValue ruleShiftValue = ruleShiftValues.get(0);
		//获取值次id
		String valueId = ruleShiftValue.getValueId();
		
		//根据值次id获取值次名称
		ValueTime valueTime = valueTimeService.getValueTimeById(valueId);
		//得到值次名称
		String valueName = valueTime.getValueName();
		
		//根据值次id，排班规则id，获取用户id
		List<UserValueTime> listReslut = userValueTimeService.getUserValueTimeByValueIdAndSchedulingRuleId(valueId, schedulingRuleId);
		
		
		//集合用来保存用户ids
		List<String> userIds = new ArrayList<String>();
		//获取
		for (UserValueTime userValueTime : listReslut) {
			userIds.add(userValueTime.getUserId());
		}
		
		//创建返回结果
		DutyLogResult dutyLogResult = new DutyLogResult();
		//值次名称
		dutyLogResult.setValueName(valueName);
		//userids
		dutyLogResult.setUserIds(userIds);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(dutyLogResult);
		return resultEntity;
		
	}
	
	
	/**
	 * @Description:加载值班日志配置首页数据
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDutyLog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "加载值班日志配置首页数据", value = "加载值班日志配置首页数据")
	public PageResultEntity listDutyLog(@RequestParam(required=false) List<String> departments,
			@RequestParam(required=false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		//声明返回对象
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		//进行模糊查询
		DutyLogExample example = new DutyLogExample();
		
		//如果输入了日志名称
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.createCriteria().andLogNameLike(searchKey);
		}

		//如果选择了部门
		if(CollectionUtils.isNotEmpty(departments)){
			for (String department : departments) {
				example.or().andDepartmentEqualTo(department);
			}
		}
		
		//设置分页
		PageHelper.startPage(pageNo, pageSize);
		
		//执行查询操作
		List<DutyLog> list = dutyLogService.listDutyLog(example);
		
		PageInfo<DutyLog> pageInfo = new PageInfo<DutyLog>(list);
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		
		return pageResultEntity;
	}
	
	
	
	
	/**
	 * @Description:勾选值班日志信息上传id，执行删除操作
	 * @param: @param dutyLogIds
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/removeDutyLog", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除值班日志表信息", value = "删除值班日志表信息")
	public ResultEntity removeDutyLog(@RequestParam List<String> dutyLogIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isNotEmpty(dutyLogIds)){
			dutyLogService.deleteDutyLogById(dutyLogIds);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:更新值班日志表信息
	 * @param: @param dutyLog
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDutyLog", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新值班日志表信息", value = "更新值班日志表信息")
	public ResultEntity editDutyLog(@RequestBody DutyLog dutyLog){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//检查各字段是否都提交
		if(StringUtils.isBlank(dutyLog.getDepartment())
				||StringUtils.isBlank(dutyLog.getLogType())
				||StringUtils.isBlank(dutyLog.getLogName())
				||StringUtils.isBlank(dutyLog.getDutyUser())
				||StringUtils.isBlank(dutyLog.getIsFaceToFace())
				||StringUtils.isBlank(dutyLog.getMaintainUser())
				||StringUtils.isBlank(dutyLog.getUpdateTime()+"")
				||StringUtils.isBlank(dutyLog.getStatus())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
			
		//字段都正常
		//执行更新操作
		dutyLogService.updateDutyLog(dutyLog);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getDutyLog" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getDutyLog(@RequestParam String dutyLogId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(dutyLogId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//封装查询条件
		DutyLogExample example = new DutyLogExample();
		example.createCriteria().andDutyLogIdEqualTo(dutyLogId);
		//执行查询
		List<DutyLog> list = dutyLogService.listDutyLog(example);
		
		DutyLog dutyLog = null;
		if(list!=null && list.size() > 0 ){
			dutyLog = list.get(0);
		}
		
		if(dutyLog != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(dutyLog);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
	}
	
	
	
	
	
	
}
