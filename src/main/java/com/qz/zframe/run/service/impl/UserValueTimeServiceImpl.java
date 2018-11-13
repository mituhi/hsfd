package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.UserValueTimeMapper;
import com.qz.zframe.run.entity.UserValueTime;
import com.qz.zframe.run.entity.UserValueTimeExample;
import com.qz.zframe.run.service.UserValueTimeService;


/**
 * <p>Title: UserValueTimeServiceImpl</p>
 * <p>@Description: 人员值次关联表接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月2日 上午10:29:40
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserValueTimeServiceImpl implements UserValueTimeService {

	
	@Autowired
	private UserValueTimeMapper userValueTimeMapper;
	
	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveUserValueTime(UserValueTime userValueTime) {
		
		ResultEntity resultEntity = new ResultEntity();
		//生成id
		String id = UUID.randomUUID().toString();
		userValueTime.setId(id);
		//执行插入操作
		userValueTimeMapper.insert(userValueTime);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	@Override
	public ResultEntity deleteUserValueTime(UserValueTime userValueTime) {
		
		UserValueTimeExample example = new UserValueTimeExample();
		//设置删除条件
		example.createCriteria()
			.andUserIdEqualTo(userValueTime.getUserId())
			.andValueIdEqualTo(userValueTime.getValueId())
			.andSchedulingRuleIdEqualTo(userValueTime.getSchedulingRuleId());
		
		//执行删除操作
		userValueTimeMapper.deleteByExample(example);
		
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 *
	 * 排班规则表id 值次id ，获取值次，userid
	 */

	@Override
	public List<UserValueTime> getUserValueTimeByValueIdAndSchedulingRuleId(String valueId, String schedulingRuleId) {
		
		UserValueTimeExample example = new UserValueTimeExample();
		example.createCriteria().andValueIdEqualTo(valueId).andSchedulingRuleIdEqualTo(schedulingRuleId);
		
		List<UserValueTime> list = userValueTimeMapper.selectByExample(example);
		
		if(list!=null && list.size()>=0){
			return list;
		}
		
		return null;
	}

	
	/**
	 * 通过值次id和排班规则id删除记录
	 */
	@Override
	public ResultEntity deleteUserValueTimeBySchedulingRuleIdAndValueId(String valueId, String schedulingRuleId) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		UserValueTimeExample example = new UserValueTimeExample();
		//封装查询条件
		example.createCriteria().andValueIdEqualTo(valueId).andSchedulingRuleIdEqualTo(schedulingRuleId);
		//执行删除
		userValueTimeMapper.deleteByExample(example);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	


	
	


}
