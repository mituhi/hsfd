package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.SchedulingRuleExample;
import com.qz.zframe.run.entity.UserValueTimeExample;
import com.qz.zframe.run.service.SchedulingRuleService;

/**
 * <p>Title: SchedulingRuleServiceImpl</p>
 * <p>@Description: 排班规则实现 </p>
 * @author 陈汇奇
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
	public List<SchedulingRule> listSchedulingRule(SchedulingRuleExample example,int pageNo,int pageSize) {
		List<SchedulingRule> schedulingRules = Collections.emptyList();
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			return schedulingRuleMapper.selectByExample(example);
		}else{
			return schedulingRuleMapper.selectByExample(example);
		}
	}
	
	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveSchedulingRule(SchedulingRule schedulingRule) {

		if(StringUtils.isBlank(schedulingRule.getSchedulingRuleId())){
			//生成id
			String schedulingRuleId = UUID.randomUUID().toString();
			schedulingRule.setSchedulingRuleId(schedulingRuleId);
		}
		//执行插入
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
				
				schedulingRuleMapper.deleteByPrimaryKey(id);
				
				//需要删除关联的相关信息表  三张
				///删除排班关联表信息
				SchedulingAssociatedExample example = new SchedulingAssociatedExample();
				example.createCriteria().andSchedulingRuleIdEqualTo(id);
				schedulingAssociatedMapper.deleteByExample(example);
				
				//删除人员值次关联表
				UserValueTimeExample userValueTimeExample = new UserValueTimeExample();
				userValueTimeExample.createCriteria().andSchedulingRuleIdEqualTo(id);
				userValueTimeMapper.deleteByExample(userValueTimeExample);
				
				//删除排班班次值次关联表
				RuleShiftValueExample ruleShiftValueExample = new RuleShiftValueExample();
				ruleShiftValueExample.createCriteria().andSchedulingRuleIdEqualTo(id);
				userValueTimeExample.createCriteria().andSchedulingRuleIdEqualTo(id);
				ruleShiftValueMapper.deleteByExample(ruleShiftValueExample);
				
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


	
	
}
