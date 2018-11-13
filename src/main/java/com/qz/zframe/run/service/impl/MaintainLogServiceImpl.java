package com.qz.zframe.run.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.run.dao.MaintainLogMapper;
import com.qz.zframe.run.entity.MaintainLog;
import com.qz.zframe.run.service.MaintainLogService;

/**
 * <p>Title: MaintainLogServiceImpl</p>
 * <p>@Description: 维护日志表接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月6日 上午11:24:26
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaintainLogServiceImpl implements MaintainLogService{
	

	@Autowired
	private MaintainLogMapper maintainLogMapper;
	
	/**
	 * 维护日志表添加
	 */
	@Override
	public void saveMaintainLog(MaintainLog maintainLog) {
		//生成id
		maintainLog.setId(UUID.randomUUID().toString());
		maintainLogMapper.insert(maintainLog);
	}

}
