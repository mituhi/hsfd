package com.qz.zframe.run.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.UserValueTimeMapper;
import com.qz.zframe.run.dao.ValueTimeMapper;
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
	
	@Autowired
	private ValueTimeMapper valueTimeMapper;
	
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

	
	


}
