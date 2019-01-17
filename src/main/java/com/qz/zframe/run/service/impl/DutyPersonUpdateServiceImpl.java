package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyPersonUpdateMapper;
import com.qz.zframe.run.entity.DutyPersonUpdate;
import com.qz.zframe.run.entity.DutyPersonUpdateExample;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.result.SchedulingQueryResult;
import com.qz.zframe.run.entity.submit.DutyPersonUpdateSubmit;
import com.qz.zframe.run.service.DutyPersonUpdateService;
import com.qz.zframe.run.service.SchedulingQueryService;
import com.qz.zframe.run.service.ShiftService;
import com.qz.zframe.run.service.ValueTimeService;

/**
 * <p>Title: DutyPersonUpdateServiceImpl</p>
 * <p>@Description: 值班人员修改接口实现类 </p>
 * @author
 * @date 2018年11月21日 下午2:55:47
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DutyPersonUpdateServiceImpl implements DutyPersonUpdateService {

	@Autowired
	private DutyPersonUpdateMapper dutyPersonUpdateMapper;
	
	@Autowired
	private SchedulingQueryService schedulingQueryService;
	
	@Autowired
	private ShiftService shiftService;
	
	@Autowired
	private ValueTimeService valueTimeService;
	
	/**
	 * 保存操作
	 */
	@Override
	public ResultEntity saveDutyPersonUpdate(SchedulingManagement schedulingManagement,
			List<SchedulingAssociated> associateds) {
		
		//风场
		String department = schedulingManagement.getDepartment();
		
		//排班表
		String schedulingName = schedulingManagement.getSchedulingName();
		
		
		//遍历保存值班人员修改
		for (SchedulingAssociated schedulingAssociated : associateds) {
			//知道开始时间：排班表   部门：  调用接口查询信息
			Date startTime = schedulingAssociated.getStartTime();
			
			//排班规则表id
			String schedulingRuleId = schedulingAssociated.getSchedulingRuleId();
			
			//创建查询条件
			SchedulingQuery schedulingQuery = new SchedulingQuery();
			schedulingQuery.setStartTime(startTime);
			schedulingQuery.setSchedulingName(schedulingName);
			schedulingQuery.setDepartment(department);
			schedulingQuery.setSchedulingRuleId(schedulingRuleId);
			
			List<SchedulingQuery> list = schedulingQueryService.listUpdateOperator(schedulingQuery);
			
			
			//遍历
			//创建返回对象
			List<SchedulingQuery> result = new ArrayList<SchedulingQuery>();

			for (SchedulingQuery schedulingQueryTemp : list) {
				boolean falg = true;
				// 从集合中查找是否是同一值班人员
				for (SchedulingQuery schedulingQueryTemp3 : result) {
					// 如果字段都相同，则当日当班次为一起的人员，合并userid返回（这里先使用id返回）
					if (schedulingQueryTemp3.getDepartment().equals(schedulingQueryTemp.getDepartment())
							&& schedulingQueryTemp3.getSchedulingCode().equals(schedulingQueryTemp.getSchedulingCode())
							&& schedulingQueryTemp3.getShiftName().equals(schedulingQueryTemp.getShiftName())
							&& schedulingQueryTemp3.getValueName().equals(schedulingQueryTemp.getValueName())) {
							
						schedulingQueryTemp3.setUserId(schedulingQueryTemp3.getUserId() + "," + schedulingQueryTemp.getUserId());
						falg = false;
						break;
					}
				}
				if (falg) {
					result.add(schedulingQueryTemp);
				}

			}
			
			//得到类似于：
			/**
			 * {
			      "startTime": "2018-10-31T16:00:00.000+0000",
			      "endTime": "2018-11-29T16:00:00.000+0000",
			      "department": "长兴有限公司",
			      "schedulingCode": "1001",
			      "schedulingName": "电厂排班表",
			      "valueName": "1值",
			      "shiftName": "日班",
			      "userId": "测试人员idA,测试人员idB",
			      "schedulingRuleId": null
			    },
			    {
			      "startTime": "2018-10-31T16:00:00.000+0000",
			      "endTime": "2018-11-29T16:00:00.000+0000",
			      "department": "长兴有限公司",
			      "schedulingCode": "1001",
			      "schedulingName": "电厂排班表",
			      "valueName": "1值",
			      "shiftName": "夜班",
			      "userId": "测试人员A,测试人员B",
			      "schedulingRuleId": null
			    },
			 * 
			 * 
			 */
			
			//遍历保存至值班人员修改表中，具体到每一天
			for (SchedulingQuery schedulingQuery2 : result) {
				//开始时间
				Date startTime2 = schedulingQuery2.getStartTime();
				//结束时间
				Date endTime = schedulingQuery2.getEndTime();
				
				//值次名称
				String valueName = schedulingQuery2.getValueName();
				//通过名称获取id
				ValueTime valueTime = valueTimeService.getValueTimeByValueName(valueName);
				
				//班次名称
				String shiftName = schedulingQuery2.getShiftName();
				//通过名称获取id
				Shift shift = shiftService.getShiftByShiftName(shiftName);
			
				//设置人员id：是以,隔开的字符串
				//dutyPersonUpdate.setDutyUsersId(schedulingQuery2.getUserId());
				
				//从开始时间到结束时间： 一天一天添加
				Date saveDate = startTime2;
				
				List<DutyPersonUpdate> dutyPersonUpdates = new ArrayList<DutyPersonUpdate>();
				//当当前保存的时候大于等于开始，并且小于等于结束时间   执行
				while(saveDate.getTime() >=startTime2.getTime() && saveDate.getTime() <=endTime.getTime()){
					
					//创建保存对象
					DutyPersonUpdate dutyPersonUpdate = new DutyPersonUpdate();
					
					//设置排班关联表id
					dutyPersonUpdate.setSchedulingAssociatedId(schedulingAssociated.getAssociatedId());
					//设置值次id
					dutyPersonUpdate.setValueId(valueTime.getValueId());
					//设置班次id
					dutyPersonUpdate.setShiftId(shift.getShiftId());
					
					//设置人员id：是以,隔开的字符串
					String userIds = schedulingQuery2.getUserId();
					if(userIds.contains(",")){
						//得到userid集合
						String[] userIdArr = userIds.split(",");
						
						for (String userId : userIdArr) {
							dutyPersonUpdate.setDutyUsersId(userId);
							//主键
							dutyPersonUpdate.setDutyPersonUpdateId(UUID.randomUUID().toString());
							//设置值班时间
							dutyPersonUpdate.setDutyDate(saveDate);
							//执行保存到集合
							dutyPersonUpdates.add(dutyPersonUpdate);
						}
					}else{
						dutyPersonUpdate.setDutyUsersId(userIds);
						//主键
						dutyPersonUpdate.setDutyPersonUpdateId(UUID.randomUUID().toString());
						//设置值班时间
						dutyPersonUpdate.setDutyDate(saveDate);
						//执行保存到集合
						dutyPersonUpdates.add(dutyPersonUpdate);
					}
					
					////主键
					//dutyPersonUpdate.setDutyPersonUpdateId(UUID.randomUUID().toString());
					////设置值班时间
					//dutyPersonUpdate.setDutyDate(saveDate);
					////执行保存操作
					//dutyPersonUpdates.add(dutyPersonUpdate);
					
					//时间后移一天
					saveDate = DateUtil.getAddDate(saveDate, 1);
				}
				
				//dutyPersonUpdateMapper.insert(dutyPersonUpdate);
				dutyPersonUpdateMapper.addDutyPersonUpdateList(dutyPersonUpdates);
			}
			
		}
		
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	

	/**
	 * 封装查询条件查找对象
	 */
	@Override
	public List<SchedulingQueryResult> getDutyPersonUpdateBySubmit(DutyPersonUpdateSubmit dutyPersonUpdateSubmit) {
		return dutyPersonUpdateMapper.listDutyPersonUpdate(dutyPersonUpdateSubmit);
	}


	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveDutyPersonUpdate(DutyPersonUpdate dutyPersonUpdate) {
		ResultEntity resultEntity = new ResultEntity();
		dutyPersonUpdateMapper.insert(dutyPersonUpdate);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 根据id删除
	 */
	@Override
	public int deleteDutyPersonUpdate(String dutyPersonUpdateId) {
		return dutyPersonUpdateMapper.deleteByPrimaryKey(dutyPersonUpdateId);
	}


	/**
	 * 删除
	 */
	@Override
	public int deleteDutyPersonUpdateByExample(DutyPersonUpdateExample example) {
		return dutyPersonUpdateMapper.deleteByExample(example);
	}


	
	/**
	 * 根据查询条件查询
	 */
	@Override
	public List<SchedulingQueryResult> getSchedulingQueryBySubmit(DutyPersonUpdateSubmit dutyPersonUpdateSubmit) {
		return dutyPersonUpdateMapper.listSchedulingQuery(dutyPersonUpdateSubmit);
	}


	/**
	 * 批量插入
	 */
	@Override
	public int addDutyPersonUpdate(List<DutyPersonUpdate> dutyPersonUpdates) {
		return dutyPersonUpdateMapper.addDutyPersonUpdateList(dutyPersonUpdates);
	}

}
