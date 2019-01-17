package com.qz.zframe.run.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

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
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.isc.domain.IscUser;
import com.qz.zframe.isc.service.IscUserService;
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
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.result.DutyLogUpdateResult;
import com.qz.zframe.run.entity.submit.DutyLogSubmit;
import com.qz.zframe.run.service.DutyInfoService;
import com.qz.zframe.run.service.DutyLogService;
import com.qz.zframe.run.service.DutyLogTabService;
import com.qz.zframe.run.service.DutyRememberService;
import com.qz.zframe.run.service.LogTypeService;
import com.qz.zframe.run.service.RuleShiftValueService;
import com.qz.zframe.run.service.SchedulingManagementService;
import com.qz.zframe.run.service.ShiftService;
import com.qz.zframe.run.service.UserValueTimeService;
import com.qz.zframe.run.service.ValueTimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: DutyLogController</p>
 * <p>@Description: 值班日志配置 </p>
 * @author 
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
	private ShiftService shiftService;
	
	@Autowired
	private UserValueTimeService userValueTimeService;
	
	@Autowired
	private RuleShiftValueService ruleShiftValueService;
	
	@Autowired
	private ValueTimeService valueTimeService;
	
	@Autowired
	private DutyInfoService dutyInfoService;
	
	@Autowired
	private IscUserService iscUserService;
	
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
		
		//创建返回对象
		ResultEntity resultEntity = new ResultEntity();

		//从提交对象中取出
		//值班日志对象
		DutyLog dutyLog = dutyLogSubmit.getDutyLog();
		
		//记事对象
		List<DutyRemember> dutyRemembers = dutyLogSubmit.getDutyRemembers();
		
		//值班信息对象
		DutyInfo dutyInfo = dutyLogSubmit.getDutyInfo();
		
		
		//生成值班日志表：dutyLogId
		String dutyLogId = UUID.randomUUID().toString();
		   
		//生成当班记事表：dutyId
		String dutyRememberIds = "";
		for (DutyRemember dutyRemember : dutyRemembers) {
			String dutyId = UUID.randomUUID().toString();
			dutyRemember.setDutyId(dutyId);
			dutyRememberIds = dutyRememberIds + dutyId +",";
		}
		
		if(StringUtils.isNotBlank(dutyRememberIds)){
			//去掉,
			dutyRememberIds = dutyRememberIds.substring(0, dutyRememberIds.length()-1);
			//设置到值班日志中
			dutyLog.setDutyRememberId(dutyRememberIds);
		}
		
		
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
		
		//值班人员ids:先用ids:值班人员使用  id1,id2格式上传
		String dutyUserIds = dutyLog.getDutyUserIds();
		
		//通过值班人员ids设置值班人员名称
		String dutyUserName = "";
		if(dutyUserIds.contains(",")){
			String[] dutyUserIdsArr = dutyUserIds.split(",");
			for (String userId : dutyUserIdsArr) {
				//从数据库中查找对应的人名
				IscUser user = iscUserService.getUser(userId, null);
				if(user == null){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("人员查找失败");
					return resultEntity;
				}else{
					dutyUserName = dutyUserName + user.getUserName() + ",";
				}
			}
			//去掉最后的,
			dutyUserName  = dutyUserName.substring(0, dutyUserName.length()-1);
			
		}else{
			IscUser user = iscUserService.getUser(dutyUserIds, null);
			if(user == null){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("人员查找失败");
				return resultEntity;
			}
		}
		
		//设置值班人员
		dutyLog.setDutyUser(dutyUserName);
		
		//维护人
		dutyLog.setMaintainUser(currentUserService.getUsername());
		
		//维护日期
		dutyLog.setUpdateTime(new Date());
		
		//执行保存值班日志表操作
		resultEntity = dutyLogService.saveDutyLog(dutyLog);
		
		//执行成功之后保存：运行记事
		
		//执行保存记事表操作
		for (DutyRemember dutyRemember : dutyRemembers) {
			dutyRememberService.saveDutyRemember(dutyRemember);
		}
		
		
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
		 * 值班信息初始化：值班人员:上传id1,id2
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
	public PageResultEntity chooseLogTAB(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DutyLogTabExample example = new DutyLogTabExample();
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example, pageNum, pageSize);
		// 设置返回结果
		PageInfo<DutyLogTab> pageInfo = new PageInfo<DutyLogTab>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	/**
	 * 选择启用时间，选择班次，获取值次，值班人员			schedulingName:排班表名称
	 */
	@RequestMapping(value = "/getValueAndUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "选择启用时间，选择班次，获取值次，值班人员", value = "选择启用时间，选择班次，获取值次，值班人员")
	public ResultEntity getValueAndUsers(@RequestParam String schedulingName,
			@RequestParam String startTime , @RequestParam String shiftName){

		return dutyLogService.getDutyLogResult(schedulingName, startTime, shiftName);
		
	}
	
	
	/**
	 * @Description:加载值班日志配置首页数据
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDutyLog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "加载值班日志配置首页数据", value = "加载值班日志配置首页数据")
	public PageResultEntity listDutyLog(@RequestParam(required=false)@ApiParam(name="departments",value="风场") List<String> departments,
			@RequestParam(required=false)@ApiParam(name="searchKey",value="关键字查询",required=false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
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
		PageHelper.startPage(pageNum, pageSize);
		
		//执行查询操作
		List<DutyLog> list = dutyLogService.listDutyLog(example);
		
		PageInfo<DutyLog> pageInfo = new PageInfo<DutyLog>(list);
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		
		return pageResultEntity;
	}
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required=false)@ApiParam(name="departments",value="风场") List<String> departments,
			@RequestParam(required=false)@ApiParam(name="searchKey",value="关键字查询",required=false) String searchKey,
			HttpServletResponse response) {
		
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
		

		//执行查询操作
		List<DutyLog> list = dutyLogService.listDutyLog(example);
		
		
		/**
		 *  {
		      "dutyLogId": "1",
		      "logTypeId": "1",
		      "logType": "logType1",
		      "logName": "logName1",
		      "department": "department",
		      "schedulingManagementId": "1",
		      "schedulingName": "电厂排班表",
		      "dutyUser": "xxx",      这里的值班人员是基本信息那块的值班人员
		      "dutyUserIds": "xxx",  这里的值班人员ids是基本信息那块的ids
		      "status": "1",
		      "isFaceToFace": "1",
		      "phone": "12345678901xxx",
		      "remark": "备注xxx",
		      "dutyRememberId": "a4fb3b20-ee9a-4ec0-abdd-39669162f49a,1c9affae-70e8-4691-950a-1767767dcc2f",
		      "tabId": "1",
		      "maintainUser": "admin",
		      "updateTime": "2018-11-16T10:58:40.000+0000"
    		}
		 */
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//使用备注字段作为维护日期
		for (DutyLog dutyLog : list) {
			dutyLog.setRemark(format.format(dutyLog.getUpdateTime()));
		}
		
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("department", "风电场名称");
		testMap.put("logType", "日志类型");
		testMap.put("logName", "日志名称");
		testMap.put("dutyUser", "值班人员");
		testMap.put("isFaceToFace", "当面交接差");
		testMap.put("maintainUser", "维护人");
		testMap.put("remark", "维护日期");
		testMap.put("status", "状态");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "值班日志配置", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @Description:勾选值班日志信息上传id，执行删除操作
	 * @param: @param dutyLogIds
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/removeDutyLog", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除值班日志表信息", value = "删除值班日志表信息")
	public ResultEntity removeDutyLog(@RequestParam @ApiParam(name="dutyLogIds",value="值班日志id") List<String> dutyLogIds){
		
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
	 * @param: @param
	 * dutyLog
	 * @param: @return
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDutyLog", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新值班日志表信息", value = "更新值班日志表信息")
	public ResultEntity editDutyLog(@RequestBody DutyLogSubmit dutyLogSubmit) {

		// 创建返回对象
		ResultEntity resultEntity = new ResultEntity();

		// 从提交对象中取出
		// 值班日志对象
		DutyLog dutyLog = dutyLogSubmit.getDutyLog();

		// 记事对象
		List<DutyRemember> dutyRemembers = dutyLogSubmit.getDutyRemembers();

		// 值班信息对象
		DutyInfo dutyInfo = dutyLogSubmit.getDutyInfo();

		// 通过日志类型查找日志id

		LogTypeExample example = new LogTypeExample();
		example.createCriteria().andLogTypeEqualTo(dutyLog.getLogType());
		LogType logType = logTypeService.getLogTypeByLogType(example);

		if (logType == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型查找失败");
			return resultEntity;
		}

		// 通过排班表获取排版管理表id
		String schedulingName = dutyLog.getSchedulingName();
		SchedulingManagement schedulingManagement = schedulingManagementService
				.getSchedulingManagementBySchedulingName(schedulingName);

		// 完善字段
		// dutyLog.setDutyLogId(dutyLogId);
		// 日志类型id
		dutyLog.setLogTypeId(logType.getLogTypeId());
		// 日志名称
		dutyLog.setLogName(logType.getLogName());
		// 排版管理表id
		dutyLog.setSchedulingManagementId(schedulingManagement.getSchedulingManagementId());

		// 值班人员:先用ids:值班人员使用 id1,id2格式上传
		//通过值班人员ids设置值班人员名称
		String dutyUserIds = dutyLog.getDutyUserIds();
		
		String dutyUserName = "";
		if(dutyUserIds.contains(",")){
			String[] dutyUserIdsArr = dutyUserIds.split(",");
			for (String userId : dutyUserIdsArr) {
				//从数据库中查找对应的人名
				IscUser user = iscUserService.getUser(userId, null);
				if(user == null){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("人员查找失败");
					return resultEntity;
				}else{
					dutyUserName = dutyUserName + user.getUserName() + ",";
				}
			}
			//去掉最后的,
			dutyUserName  = dutyUserName.substring(0, dutyUserName.length()-1);
			
		}else{
			IscUser user = iscUserService.getUser(dutyUserIds, null);
			if(user == null){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("人员查找失败");
				return resultEntity;
			}
		}
		
		//设置值班人员
		dutyLog.setDutyUser(dutyUserName);
		
		
		
		// 维护人
		dutyLog.setMaintainUser(currentUserService.getUsername());
		// dutyLog.setMaintainUser("zzz");

		// 维护日期
		dutyLog.setUpdateTime(new Date());

		

		// 执行更新之后更新：运行记事

		// 更新记事主题信息
		for (DutyRemember dutyRemember : dutyRemembers) {
			if (StringUtils.isBlank(dutyRemember.getDutyId())) {
				// 如果为空，就新增
				String dutyId = UUID.randomUUID().toString();
				dutyRemember.setDutyId(dutyId);
				//执行插入
				dutyRememberService.saveDutyRemember(dutyRemember);
				// 加入到值班日志中
				String dutyRememberId = dutyLog.getDutyRememberId();
				if (StringUtils.isEmpty(dutyRememberId)) {
					dutyRememberId = dutyId;
				} else {
					dutyRememberId = dutyRememberId + "," + dutyId;
				}
				dutyLog.setDutyRememberId(dutyRememberId);
			} else {
				// 如果不为空：更新
				dutyRememberService.updateDutyRemember(dutyRemember);
			}
		}

		
		// 执行更新值班日志表操作
		dutyLogService.updateDutyLog(dutyLog);
		
		// 准备更新值班信息表信息

		// 先删除
		dutyInfoService.deleteDutyInfoById(dutyInfo.getDutyInfoId());

		// 设置值班日志表id
		dutyInfo.setDutyLogId(dutyLog.getDutyLogId());
		// 设置值班启用时间
		String shiftName = dutyInfo.getShiftName();
		// 根据班次名称获取id
		Shift shift = shiftService.getShiftByShiftName(shiftName);
		// 设置班次id
		dutyInfo.setShiftId(shift.getShiftId());
		// 根据值次获取id
		ValueTime valueTime = valueTimeService.getValueTimeByValueName(dutyInfo.getValueName());
		// 设置值次id
		dutyInfo.setValueId(valueTime.getValueId());

		/**
		 * 值班信息初始化：值班人员:上传id1,id2
		 */

		// 执行插入
		dutyInfoService.saveDutyInfo(dutyInfo);

		// 通过班次id和值次id查询排班规则id

		// 更新人员值次关联表

		// 知道排班规则表id，值次id，更新userId
		RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
		ruleShiftValueExample.createCriteria().andShiftIdEqualTo(shift.getShiftId())
				.andValueIdEqualTo(valueTime.getValueId());
		List<RuleShiftValue> list = ruleShiftValueService.getRuleShiftValues(ruleShiftValueExample, 0, 0);
		RuleShiftValue ruleShiftValue;
		if (list != null && list.size() >= 0) {
			ruleShiftValue = list.get(0);
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("更新人员值次关联表失败");
			return resultEntity;
		}

		// 先删除--->再添加
		userValueTimeService.deleteUserValueTimeBySchedulingRuleIdAndValueId(valueTime.getValueId(),
				ruleShiftValue.getSchedulingRuleId());

		// 添加：如果userid是集合
		String userIds = dutyInfo.getDutyUserIds();
		if (userIds.contains(",")) {
			String[] userIdArr = userIds.split(",");
			for (String userId : userIdArr) {
				// 执行保存操作
				UserValueTime userValueTime = new UserValueTime();
				userValueTime.setSchedulingRuleId(ruleShiftValue.getSchedulingRuleId());
				userValueTime.setUserId(userId);
				userValueTime.setValueId(valueTime.getValueId());
				userValueTimeService.saveUserValueTime(userValueTime);
			}
		} else {
			// 如果userid就是一个
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
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getDutyLog" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getDutyLog(@RequestParam @ApiParam(name="dutyLogId",value="值班日志id") String dutyLogId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(dutyLogId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		DutyLogUpdateResult dutyLogUpdateResult = dutyLogService.getDutyLogUpdateResult(dutyLogId);
		resultEntity.setData(dutyLogUpdateResult);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	
	}

	
	/*************************    点击查看：获取对应信息               ***************************/
	@RequestMapping(value="/viewDutyLog" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity viewDutyLog(@RequestParam @ApiParam(name="dutyLogId",value="值班日志id") String dutyLogId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(dutyLogId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		DutyLogUpdateResult dutyLogUpdateResult = dutyLogService.getDutyLogUpdateResult(dutyLogId);
		resultEntity.setData(dutyLogUpdateResult);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
		
	}
	
	
}
