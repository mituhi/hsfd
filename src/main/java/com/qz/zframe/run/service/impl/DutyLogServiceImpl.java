package com.qz.zframe.run.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyInfoMapper;
import com.qz.zframe.run.dao.DutyLogMapper;
import com.qz.zframe.run.dao.DutyLogTabMapper;
import com.qz.zframe.run.dao.DutyRememberMapper;
import com.qz.zframe.run.dao.RuleShiftValueMapper;
import com.qz.zframe.run.dao.SchedulingAssociatedMapper;
import com.qz.zframe.run.dao.SchedulingManagementMapper;
import com.qz.zframe.run.dao.ShiftMapper;
import com.qz.zframe.run.dao.UserValueTimeMapper;
import com.qz.zframe.run.dao.ValueTimeMapper;
import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.entity.DutyInfoExample;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogExample;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyRemember;
import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingManagementExample;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.UserValueTimeExample;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.SchedulingAssociatedExample.Criteria;
import com.qz.zframe.run.entity.result.DutyLogResult;
import com.qz.zframe.run.entity.result.DutyLogUpdateResult;
import com.qz.zframe.run.service.DutyLogService;

@Service
@Transactional(rollbackFor=Exception.class)
public class DutyLogServiceImpl implements DutyLogService {
	
	@Autowired
	private DutyLogMapper dutyLogMapper;
	
	@Autowired
	private DutyRememberMapper dutyRememberMapper;

	@Autowired
	private DutyLogTabMapper dutyLogTabMapper;
	
	@Autowired
	private DutyInfoMapper dutyInfoMapper;
	
	@Autowired
	private SchedulingManagementMapper schedulingManagementMapper;
	
	@Autowired
	private SchedulingAssociatedMapper schedulingAssociatedMapper;
	
	@Autowired
	private ShiftMapper shiftMapper;
	
	@Autowired
	private RuleShiftValueMapper ruleShiftValueMapper;
	
	@Autowired
	private ValueTimeMapper valueTimeMapper;
	
	@Autowired
	private UserValueTimeMapper userValueTimeMapper;
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveDutyLog(DutyLog dutyLog) {
		
		ResultEntity resultEntity = new ResultEntity();
		//如果id没有值
		if(StringUtils.isEmpty(dutyLog.getDutyLogId())){
			dutyLog.setDutyLogId(UUID.randomUUID().toString());
		}
		
		dutyLogMapper.insert(dutyLog);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	/**
	 * 模糊查询
	 */
	@Override
	public List<DutyLog> listDutyLog(DutyLogExample example) {
		return dutyLogMapper.selectByExample(example);
	}


	
	/**
	 * 删除
	 */
	@Override
	public void deleteDutyLogById(List<String> dutyLogIds) {
		if(CollectionUtils.isNotEmpty(dutyLogIds)){
			//执行删除
			for (String dutyLogId : dutyLogIds) {
				dutyLogMapper.deleteByPrimaryKey(dutyLogId);
			}
		}
	}

	
	
	/**
	 * 更新
	 */
	@Override
	public void updateDutyLog(DutyLog dutyLog) {
		dutyLogMapper.updateByPrimaryKeySelective(dutyLog);
	}


	/**
	 * 点击更新获取数据
	 */
	@Override
	public DutyLogUpdateResult getDutyLogUpdateResult(String dutyLogId) {
		
		//创建返回对象
		DutyLogUpdateResult dutyLogUpdateResult = new DutyLogUpdateResult();
		
		DutyLog dutyLog= null;
		List<DutyRemember> dutyRemembers = new ArrayList<DutyRemember>();;
		List<DutyLogTab> dutyLogTabs = new ArrayList<DutyLogTab>();
		DutyInfo dutyInfo = new DutyInfo();

		
		//通过dutyLogId获取值班日志对象
		dutyLog = dutyLogMapper.selectByPrimaryKey(dutyLogId);
		
		//通过值班日志对象获取记事id
		String dutyRememberIds = dutyLog.getDutyRememberId();
		
		if(dutyRememberIds.contains(",")){
			//如果包含,    解析
			String[] dutyRememberIdsArr = dutyRememberIds.split(",");
			//循环遍历获取对象
			for (String id : dutyRememberIdsArr) {
				DutyRemember dutyRemember = dutyRememberMapper.selectByPrimaryKey(id);
				dutyRemembers.add(dutyRemember);
			}
		}else{
			//不包含,
			DutyRemember dutyRemember = dutyRememberMapper.selectByPrimaryKey(dutyRememberIds);
			dutyRemembers.add(dutyRemember);
		}
		
		//通过dutyLog对象获取值班日志Tab
		String tabId = dutyLog.getTabId();
		if(tabId.contains(",")){
			//如果包含,    解析
			String[] tabIdArr = tabId.split(",");
			//循环遍历获取对象
			for (String id : tabIdArr) {
				DutyLogTab dutyLogTab = dutyLogTabMapper.selectByPrimaryKey(id);
				dutyLogTabs.add(dutyLogTab);
			}
		}else{
			//不包含,
			DutyLogTab dutyLogTab = dutyLogTabMapper.selectByPrimaryKey(tabId);
			dutyLogTabs.add(dutyLogTab);
		}
		
		//通过值班日志表id获取值班信息表
		DutyInfoExample example = new DutyInfoExample();
		example.createCriteria().andDutyLogIdEqualTo(dutyLogId);
		List<DutyInfo> list = dutyInfoMapper.selectByExample(example);
		
		if(list.size()>0){
			dutyInfo = list.get(0);
		}
		
		dutyLogUpdateResult.setDutyInfo(dutyInfo);
		dutyLogUpdateResult.setDutyLog(dutyLog);
		dutyLogUpdateResult.setDutyLogTabs(dutyLogTabs);
		dutyLogUpdateResult.setDutyRemembers(dutyRemembers);
		
		return dutyLogUpdateResult;
	}


	/**
	 *  选择启用时间，选择班次，获取值次，值班人员	schedulingName:排班表名称
	 */
	@Override
	public ResultEntity getDutyLogResult(String schedulingName, String startTime, String shiftName) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		SchedulingManagement schedulingManagement = null;
		
		SchedulingManagementExample exampleTemp1 = new SchedulingManagementExample();
		exampleTemp1.createCriteria().andSchedulingNameEqualTo(schedulingName);
		List<SchedulingManagement> listSchedulingManagement = schedulingManagementMapper.selectByExample(exampleTemp1);
		if(CollectionUtils.isNotEmpty(listSchedulingManagement)){
			//1：通过排班表名称获取排版管理表id
			 schedulingManagement = listSchedulingManagement.get(0);
		}

		
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
		List<SchedulingAssociated> listSchedulingAssociated = schedulingAssociatedMapper.selectByExample(example);
		
		SchedulingAssociated schedulingAssociated = null ;
		if(listSchedulingAssociated!=null && listSchedulingAssociated.size()>=0){
			 schedulingAssociated = listSchedulingAssociated.get(0);
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		
		
		//得到排班规则表id
		String schedulingRuleId = schedulingAssociated.getSchedulingRuleId();
			
		//3：根据班次名称 获取 班次id
		ShiftExample shiftExample = new ShiftExample();
		shiftExample.createCriteria().andShiftNameEqualTo(shiftName);

		// 执行查询操作
		List<Shift> list = shiftMapper.selectByExample(shiftExample);
		
		Shift shift = new Shift() ;
		// 如果不为空
		if (CollectionUtils.isNotEmpty(list)) {
			 shift = list.get(0);
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		
		//获取班次id
		String shiftId = shift.getShiftId();
		
		
		//4：根据排班规则表id 班次id ，获取值次id
		RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
		ruleShiftValueExample.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId).andShiftIdEqualTo(shiftId);
		
		List<RuleShiftValue> ruleShiftValues = ruleShiftValueMapper.selectByExample(ruleShiftValueExample);
		
		if(ruleShiftValues==null || ruleShiftValues.size() == 0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询出错");
			return resultEntity;
		}
		 
		RuleShiftValue ruleShiftValue = ruleShiftValues.get(0);
		//获取值次id
		String valueId = ruleShiftValue.getValueId();
		
		//根据值次id获取值次名称
		ValueTime valueTime = valueTimeMapper.selectByPrimaryKey(valueId);
		
		//得到值次名称
		String valueName = valueTime.getValueName();
		
		
		UserValueTimeExample userValueTimeExample = new UserValueTimeExample();
		userValueTimeExample.createCriteria().andValueIdEqualTo(valueId).andSchedulingRuleIdEqualTo(schedulingRuleId);
		
		//根据值次id，排班规则id，获取用户id
		List<UserValueTime> UserValueTimes = userValueTimeMapper.selectByExample(userValueTimeExample);
		
		
		//集合用来保存用户ids
		List<String> userIds = new ArrayList<String>();
		//获取
		for (UserValueTime userValueTime : UserValueTimes) {
			userIds.add(userValueTime.getUserId());
		}
		
		//创建返回结果
		DutyLogResult dutyLogResult = new DutyLogResult();
		//值次名称
		dutyLogResult.setValueName(valueName);
		//userids
		dutyLogResult.setUserIds(userIds);


		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setData(dutyLogResult);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
