package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.qz.zframe.run.dao.UserValueTimeMapper;
import com.qz.zframe.run.entity.UserValueTimeExample;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.RuleShiftValueMapper;
import com.qz.zframe.run.entity.RuleShiftValue;
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.service.RuleShiftValueService;

/**
 * <p>Title: RuleShiftValueServiceImpl</p>
 * <p>@Description: 规则班次值次实现 </p>
 * @author 
 * @date 2018年11月1日 下午4:56:27
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RuleShiftValueServiceImpl implements RuleShiftValueService {

	@Autowired
	private RuleShiftValueMapper ruleShiftValueMapper;
	@Autowired
	private UserValueTimeMapper userValueTimeMapper;
	

	/**
	 * 返回指定page， pageSize 的记录
	 */
	@Override
	public List<RuleShiftValue> getRuleShiftValues(RuleShiftValueExample example, int pageNo, int pageSize) {
		List<RuleShiftValue> ruleShiftValueList = Collections.emptyList();
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			ruleShiftValueList = ruleShiftValueMapper.selectByExample(example);
		}else{
			ruleShiftValueList = ruleShiftValueMapper.selectByExample(example);
		}
		return ruleShiftValueList;
	}


	/**
	 * 删除指定id的规则班次值次信息
	 */
	@Override
	public ResultEntity removeRuleShiftValue(List<String> ruleShiftValueIds) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isNotEmpty(ruleShiftValueIds)){
			for (String ruleShiftValueId : ruleShiftValueIds) {
				//执行删除操作
				ruleShiftValueMapper.deleteByPrimaryKey(ruleShiftValueId);
			}
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选择数据");
		}
		return resultEntity;
	}


	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveRuleShiftValue(RuleShiftValue ruleShiftValue) {
		
		//生成id
		String id = (UUID.randomUUID()+"").replaceAll("-","");
		ruleShiftValue.setId(id);
		
		//执行插入操作
		ruleShiftValueMapper.insert(ruleShiftValue);
		ResultEntity resultEntity = new ResultEntity();
		resultEntity .setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	@Override
	public List<RuleShiftValue> getRuleShiftValuesBySchedulingRuleId(String schedulingRuleId) {
		return ruleShiftValueMapper.getRuleShiftValuesBySchedulingRuleId(schedulingRuleId);
	}


	/**
	 * 通过排班规则id删除信息
	 */
	@Override
	public ResultEntity removeRuleShiftValueBySchedulingRuleId(String schedulingRuleId) {
		
		RuleShiftValueExample example = new RuleShiftValueExample();
		example.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId);
		
		ruleShiftValueMapper.deleteByExample(example);

		/*UserValueTimeExample example2 = new UserValueTimeExample();
		example.createCriteria().andSchedulingRuleIdEqualTo(schedulingRuleId);

		userValueTimeMapper.deleteByExample(example2);*/
		userValueTimeMapper.deleteBySchedulingRuleId(schedulingRuleId);

		ResultEntity resultEntity = new ResultEntity();
		resultEntity .setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
