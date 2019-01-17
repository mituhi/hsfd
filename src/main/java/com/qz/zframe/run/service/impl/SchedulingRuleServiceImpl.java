package com.qz.zframe.run.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.qz.zframe.run.entity.*;
import com.qz.zframe.run.entity.dto.IscUserDto;
import com.qz.zframe.run.entity.dto.RuleShiftValueDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.RuleShiftValueMapper;
import com.qz.zframe.run.dao.SchedulingAssociatedMapper;
import com.qz.zframe.run.dao.SchedulingRuleMapper;
import com.qz.zframe.run.dao.UserValueTimeMapper;
import com.qz.zframe.run.service.SchedulingRuleService;

/**
 * <p>Title: SchedulingRuleServiceImpl</p>
 * <p>@Description: 排班规则实现 </p>
 * @author 
 * @date 2018年11月1日 下午12:46:07
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulingRuleServiceImpl implements SchedulingRuleService {

	@Autowired
	private SchedulingRuleMapper schedulingRuleMapper;
	
	@Autowired
	private SchedulingAssociatedMapper schedulingAssociatedMapper;
	
	@Autowired
	private UserValueTimeMapper userValueTimeMapper;
	
	@Autowired
	private RuleShiftValueMapper ruleShiftValueMapper;
	
	/**
	 * 批量获取
	 */
	@Override
	public List<SchedulingRule> listSchedulingRule(String windCode,int pageNo,int pageSize) {
		List<SchedulingRule> schedulingRules = Collections.emptyList();
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			return schedulingRuleMapper.selectByWindCode(windCode);
		}else{
			return schedulingRuleMapper.selectByWindCode(windCode);
		}
	}
	
	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveSchedulingRule(SchedulingRule schedulingRule) {
        //1.假删 0存在 1删除
		schedulingRule.setTrueId("0");
		//2.执行插入
		schedulingRuleMapper.insert(schedulingRule);
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("添加成功");
		return resultEntity;
	}

	
	/**
	 * 批量删除
	 */
	@Override
	public ResultEntity removeSchedulingRule(List<String> schedulingRuleIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(CollectionUtils.isNotEmpty(schedulingRuleIds)){
			
			//遍历删除
			for (String id : schedulingRuleIds) {
				
				schedulingRuleMapper.deleteById(id);
				
				//需要删除关联的相关信息表  两张
				//删除人员值次关联表
			/*	UserValueTimeExample userValueTimeExample = new UserValueTimeExample();
				userValueTimeExample.createCriteria().andSchedulingRuleIdEqualTo(id);
				userValueTimeMapper.deleteByExample(userValueTimeExample);*/
				
				//删除排班班次值次关联表
			/*	RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
				ruleShiftValueExample.createCriteria().andSchedulingRuleIdEqualTo(id);
				ruleShiftValueMapper.deleteByExample(ruleShiftValueExample);*/
				
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行失败,请选择删除的项");
		}
		
		return resultEntity;
	}
	
	
	
	/**
	 * 批量编辑
	 */
	@Override
	public ResultEntity editSchedulingRule(List<SchedulingRule> schedulingRules) {
		
		ResultEntity resultEntity = new ResultEntity();
		if(CollectionUtils.isNotEmpty(schedulingRules)){
			for (SchedulingRule schedulingRule : schedulingRules) {
				schedulingRuleMapper.updateByPrimaryKeySelective(schedulingRule);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行失败");
		}
			
		return resultEntity;
	}


	/**
	 * 根据主键查询信息
	 */
	@Override
	public SchedulingRule getSchedulingRuleById(String schedulingRuleId) {
		return schedulingRuleMapper.selectByPrimaryKey(schedulingRuleId);
	}


	/**
	 * 获取总记录数
	 */
	@Override
	public int getCount(SchedulingRuleExample example) {
		return schedulingRuleMapper.countByExample(example);
	}


	/**
	 * 单条记录的更新
	 */
	@Override
	public ResultEntity updateSchedulingRule(SchedulingRule schedulingRule) {
		ResultEntity resultEntity = new ResultEntity();
		schedulingRule.setTrueId("0");
		schedulingRuleMapper.updateByPrimaryKeySelective(schedulingRule);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 根据规则编码获取排班规则表
	 */
	@Override
	public SchedulingRule getSchedulingRuleBySchedulingRuleCode(String SchedulingRuleCode) {
		
		SchedulingRuleExample example = new SchedulingRuleExample();
		example.createCriteria().andSchedulingRuleCodeEqualTo(SchedulingRuleCode);
		
		List<SchedulingRule> list = schedulingRuleMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			SchedulingRule schedulingRule = list.get(0);
			return schedulingRule;
		}
		return null;
	}


	/**
	 * 根据排班规则名称查询
	 */
	@Override
	public SchedulingRule getSchedulingRuleBySchedulingRuleName(String schedulingRulename) {
		
		SchedulingRuleExample example = new SchedulingRuleExample();
		example.createCriteria().andSchedulingRuleCodeEqualTo(schedulingRulename);
		
		List<SchedulingRule> list = schedulingRuleMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			SchedulingRule schedulingRule = list.get(0);
			return schedulingRule;
		}
		return null;
	}

	@Override
	public List<Shift> getShifts(String schedulingRuleId) {
		return schedulingRuleMapper.getShifts(schedulingRuleId);
	}

	@Override
	public int findSchedulingRuleCode(String schedulingRuleCode) {
		return schedulingRuleMapper.findSchedulingRuleCode(schedulingRuleCode);
	}

	@Override
	public String count() {
		String count=schedulingRuleMapper.count()+1+"";
		return count;
	}

	@Override
	public int countBySchedulingRuleId(String schedulingRuleId) {
		return schedulingRuleMapper.countBySchedulingRuleId(schedulingRuleId);
	}

	@Override
	public int countBySchedulingRuleCode(String schedulingRuleCode) {
		return schedulingRuleMapper.countBySchedulingRuleCode(schedulingRuleCode);
	}

	@Override
	public String findSchedulingRuleCodeById(String schedulingRuleId) {
		return schedulingRuleMapper.findSchedulingRuleCodeById(schedulingRuleId);
	}

	@Override
	public ResultEntity findShiftValueUsers(Example example) {

		ResultEntity resultEntity=new ResultEntity();
        //1.判断非空
		if (StringUtils.isBlank(example.getSchedulingRuleId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少规则id！");
			return resultEntity;
		}
		if(StringUtils.isBlank(example.getStartTime().toString())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少开始时间!");
			return resultEntity;
		}
		if(StringUtils.isBlank(example.getEndTime().toString())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少结束时间!");
			return resultEntity;
		}
        //2.减出时间
		int day= (int) ((example.getEndTime().getTime()-example.getStartTime().getTime())/(24*60*60*1000));
		if (day<0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("开始结束时间不对!");
			return resultEntity;
		}

		List<Integer> list=new ArrayList<Integer>();
		for (int i=1;i<=day+1;i++){
			list.add(i);
		}
		//3.查出所有天次
		//3.1 规则总天次大于结束减去开始
		//3.1.1查出最大的天次
		String maxDayId=schedulingRuleMapper.findMaxDayIdBySchedulingRuleId(example.getSchedulingRuleId());
		if (StringUtils.isBlank(maxDayId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排班班次值次关联表没有配置!");
			return resultEntity;
		}
		int dayIdNum=new Integer(maxDayId);
		if (dayIdNum>=(day+1)){
			//3.1.2 直接查出对应的排班规则
			List<RuleShiftValueDto> ruleShiftValueDtoList=schedulingRuleMapper.findRuleShiftValueDto(example.getSchedulingRuleId(),list);
			if (ruleShiftValueDtoList==null||ruleShiftValueDtoList.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据库没有数据或者数据有问题!");
				return resultEntity;
			}
			//3.1.3 匹配具体数据
			List<RuleShiftValueDto> ruleShiftValueDtos=new ArrayList<RuleShiftValueDto>();
			for (RuleShiftValueDto ruleShiftValueDto:ruleShiftValueDtoList){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(example.getStartTime());
				rightNow.add(Calendar.DAY_OF_YEAR,new Integer(ruleShiftValueDto.getDayId())-1);
				Date dt1=rightNow.getTime();
				ruleShiftValueDto.setDate(dt1);
				List<IscUserDto> iscUserDtos=schedulingRuleMapper.findIscUserDto(example.getSchedulingRuleId(),ruleShiftValueDto.getValueId());
				if (iscUserDtos==null||iscUserDtos.isEmpty()){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("用户值次数据有问题!");
					return resultEntity;
				}
				StringBuilder sbUserIds=new StringBuilder();
				StringBuilder sbUserNames=new StringBuilder();
				for (IscUserDto iscUserDto:iscUserDtos){
					sbUserIds.append(iscUserDto.getUserId()+",");
					sbUserNames.append(iscUserDto.getUserName()+",");
				}
				String userIds=sbUserIds.toString().substring(0,sbUserIds.toString().length()-1);
				String userNames=sbUserNames.toString().substring(0,sbUserNames.toString().length()-1);
				ruleShiftValueDto.setUserIds(userIds);
				ruleShiftValueDto.setUserNames(userNames);
				ruleShiftValueDto.setIscUsers(iscUserDtos);
				ruleShiftValueDtos.add(ruleShiftValueDto);
			}
			resultEntity.setData(ruleShiftValueDtos);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("成功！");
		}else if (dayIdNum<(day+1)){
			//3.2 规则总天次小于结束减去开始
			//3.2.1 直接查出所有排班规则
			List<RuleShiftValueDto> ruleShiftValueDtoList=schedulingRuleMapper.findRuleShiftValueDtoByschedulingRuleId(example.getSchedulingRuleId());
			if (ruleShiftValueDtoList==null||ruleShiftValueDtoList.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据库没有数据或者数据有问题!");
				return resultEntity;
			}
			//3.2.2 循环出要求的天数对应的排班规则
			List<RuleShiftValueDto> ruleShiftValueDtoListForNeed=new ArrayList<RuleShiftValueDto>();
			Map<String,List> mapR=new HashMap<String, List>();
			List<String> dayIds=schedulingRuleMapper.findDayIdsBySchedulingRuleId(example.getSchedulingRuleId());
			for (String dayId:dayIds){
				List<RuleShiftValueDto> ruleShiftValueDtos=new ArrayList<RuleShiftValueDto>();
				mapR.put(dayId,ruleShiftValueDtos);
			}
			for (RuleShiftValueDto ruleShiftValueDto:ruleShiftValueDtoList){
				String dayId=ruleShiftValueDto.getDayId();
				List<RuleShiftValueDto> list2=mapR.get(dayId);
				list2.add(ruleShiftValueDto);
				mapR.put(dayId,list2);
			}
		   	for (int i=1;i<=day+1;i++){
		   		int t=i;
				while (t>dayIdNum){
					t=t-dayIdNum;
				}
				List<RuleShiftValueDto> ruleShiftValueDtos=mapR.get(t+"");
				for (RuleShiftValueDto ruleShiftValueDto:ruleShiftValueDtos){
					RuleShiftValueDto ruleShiftValueDtoNew=new RuleShiftValueDto();
					BeanUtils.copyProperties(ruleShiftValueDto,ruleShiftValueDtoNew);
					ruleShiftValueDtoNew.setDayId(i+"");
					ruleShiftValueDtoListForNeed.add(ruleShiftValueDtoNew);
				}
			}
			//3.2.3 匹配具体数据
			List<RuleShiftValueDto> ruleShiftValueDtos=new ArrayList<RuleShiftValueDto>();
			List<IscUserDto> iscUserDtos=schedulingRuleMapper.findIscUserDtoBySchedulingRuleId(example.getSchedulingRuleId());
			List<String> valueIds=schedulingRuleMapper.findValueIdsBySchedulingRuleId(example.getSchedulingRuleId());
            Map<String,List> map=new HashMap<String,List>();
            for (String valueId:valueIds){
            	List<IscUserDto> listUser=new ArrayList<IscUserDto>();
            	map.put(valueId,listUser);
			}
            for (IscUserDto iscUserDto:iscUserDtos){
            	String valueId=iscUserDto.getValueId();
				List<IscUserDto> list2=map.get(valueId);
				list2.add(iscUserDto);
				map.put(valueId,list2);
			}
			for (RuleShiftValueDto ruleShiftValueDto:ruleShiftValueDtoListForNeed){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(example.getStartTime());
				rightNow.add(Calendar.DAY_OF_YEAR,new Integer(ruleShiftValueDto.getDayId())-1);
				Date dt1=rightNow.getTime();
				ruleShiftValueDto.setDate(dt1);

				StringBuilder sbUserIds=new StringBuilder();
				StringBuilder sbUserNames=new StringBuilder();

					List<IscUserDto> iscUserDtos1=map.get(ruleShiftValueDto.getValueId());
					for (IscUserDto iscUserDto:iscUserDtos1){
						sbUserIds.append(iscUserDto.getUserId()+",");
						sbUserNames.append(iscUserDto.getUserName()+",");
					}

				String userIds=sbUserIds.toString().substring(0,sbUserIds.toString().length()-1);
				String userNames=sbUserNames.toString().substring(0,sbUserNames.toString().length()-1);
				ruleShiftValueDto.setUserIds(userIds);
				ruleShiftValueDto.setUserNames(userNames);
				ruleShiftValueDto.setIscUsers(iscUserDtos);
				ruleShiftValueDtos.add(ruleShiftValueDto);
			}
			resultEntity.setData(ruleShiftValueDtos);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("成功！");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity findShiftValueUsers(String schedulingRuleId, String startTime, String currentTime) throws ParseException {
		ResultEntity resultEntity=new ResultEntity();
		//1.判断非空
		if (StringUtils.isBlank(schedulingRuleId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少规则id!");
			return resultEntity;
		}
		if (StringUtils.isBlank(startTime)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少开始时间!");
			return resultEntity;
		}
		if (StringUtils.isBlank(currentTime)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少当前时间!");
			return resultEntity;
		}
		//2.
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int day= (int) ((sdf.parse(currentTime).getTime()-sdf.parse(startTime).getTime())/(24*60*60*1000));
		if (day<0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("当前时间和开始时间不对!");
			return resultEntity;
		}
		String dayId=(day+1)+"";
		String maxDayId=schedulingRuleMapper.findMaxDayIdBySchedulingRuleId(schedulingRuleId);
		if (StringUtils.isBlank(maxDayId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排班班次值次关联表没有配置!");
			return resultEntity;
		}
		int dayIdNum=new Integer(maxDayId);
		List<RuleShiftValueDto> ruleShiftValueDtoList=new ArrayList<RuleShiftValueDto>();
		//3.小于直接查
        if (dayIdNum>=(day+1)){
			ruleShiftValueDtoList=schedulingRuleMapper.findRuleShiftValueDtoByschedulingRuleIdAndDayId(schedulingRuleId,dayId);
			if (ruleShiftValueDtoList==null||ruleShiftValueDtoList.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据库没有数据或者数据有问题!");
				return resultEntity;
			}
		}else if (dayIdNum<(day+1)){
        	//4.大于换算再查
        	int t=day+1;
			while (t>dayIdNum){
				t=t-dayIdNum;
			}
			ruleShiftValueDtoList=schedulingRuleMapper.findRuleShiftValueDtoByschedulingRuleIdAndDayId(schedulingRuleId,(t+""));
			if (ruleShiftValueDtoList==null||ruleShiftValueDtoList.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据库没有数据或者数据有问题!");
				return resultEntity;
			}
		}

		List<RuleShiftValueDto> ruleShiftValueDtos=new ArrayList<RuleShiftValueDto>();
		for (RuleShiftValueDto ruleShiftValueDto:ruleShiftValueDtoList){
			QianDuanNeed shifts=new QianDuanNeed();
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(sdf.parse(startTime));
			rightNow.add(Calendar.DAY_OF_YEAR,day);
			Date dt1=rightNow.getTime();
			ruleShiftValueDto.setDate(dt1);
			List<IscUserDto> iscUserDtos=schedulingRuleMapper.findIscUserDto(schedulingRuleId,ruleShiftValueDto.getValueId());
			if (iscUserDtos==null||iscUserDtos.isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("用户值次数据有问题!");
				return resultEntity;
			}
			StringBuilder sbUserIds=new StringBuilder();
			StringBuilder sbUserNames=new StringBuilder();
			for (IscUserDto iscUserDto:iscUserDtos){
				sbUserIds.append(iscUserDto.getUserId()+",");
				sbUserNames.append(iscUserDto.getUserName()+",");
			}
			String userIds=sbUserIds.toString().substring(0,sbUserIds.toString().length()-1);
			String userNames=sbUserNames.toString().substring(0,sbUserNames.toString().length()-1);
			ruleShiftValueDto.setUserIds(userIds);
			ruleShiftValueDto.setUserNames(userNames);
			ruleShiftValueDto.setIscUsers(iscUserDtos);
			shifts.setShiftId(ruleShiftValueDto.getShiftId());
			shifts.setUserIds(userIds);
			shifts.setUserNames(userNames);
			shifts.setValueId(ruleShiftValueDto.getValueId());
			shifts.setValueName(ruleShiftValueDto.getValueName());
			ruleShiftValueDto.setShifts(shifts);
			ruleShiftValueDtos.add(ruleShiftValueDto);
		}

		resultEntity.setData(ruleShiftValueDtos);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("成功！");
		return resultEntity;
	}

	@Override
	public List<String> findValueIdsBySchedulingRuleById(String schedulingRuleId) {
		return schedulingRuleMapper.findValueIdsBySchedulingRuleById(schedulingRuleId);
	}

	@Override
	public List<String> findShiftIdsBySchedulingRuleById(String schedulingRuleId) {
		return schedulingRuleMapper.findShiftIdsBySchedulingRuleById(schedulingRuleId);
	}


}
