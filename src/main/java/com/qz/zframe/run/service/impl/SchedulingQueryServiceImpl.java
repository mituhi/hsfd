package com.qz.zframe.run.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.run.dao.SchedulingQueryMapper;
import com.qz.zframe.run.entity.SchedulingQuery;
import com.qz.zframe.run.service.SchedulingQueryService;

@Service
@Transactional(rollbackFor=Exception.class)
public class SchedulingQueryServiceImpl implements SchedulingQueryService {

	@Autowired
	private SchedulingQueryMapper schedulingQueryMapper;
	
	
	/**
	 * 排班信息查询
	 */
	@Override
	public List<SchedulingQuery> listSchedulingQuery(SchedulingQuery schedulingQuery) {
		List<SchedulingQuery> list = schedulingQueryMapper.selectSchedulingQuery(schedulingQuery);
		return list;
	}


	/**
	 * 值班人员修改首页
	 */
	@Override
	public List<SchedulingQuery> listUpdateOperator(SchedulingQuery schedulingQuery) {
		List<SchedulingQuery> list = schedulingQueryMapper.queryOperator(schedulingQuery);
		return list;
	}


	/**
	 * 值班人员修改
	 */
	@Override
	public int updateOperator(SchedulingQuery schedulingQuery , String userId) {
		schedulingQuery.setUserId(userId);
		return schedulingQueryMapper.updateOperator(schedulingQuery);
	}

}
