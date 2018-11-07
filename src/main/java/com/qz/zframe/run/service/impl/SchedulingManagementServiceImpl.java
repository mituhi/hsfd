package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.SchedulingManagementMapper;
import com.qz.zframe.run.entity.SchedulingManagement;
import com.qz.zframe.run.entity.SchedulingManagementExample;
import com.qz.zframe.run.service.SchedulingManagementService;

/**
 * <p>Title: SchedulingManagementServiceImpl</p>
 * <p>@Description:排班管理实现  </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:27:49
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SchedulingManagementServiceImpl implements SchedulingManagementService {

	@Autowired
	private SchedulingManagementMapper schedulingManagementMapper;
	
	/**
	 * 批量获取
	 */
	@Override
	public List<SchedulingManagement> listSchedulingManagement(SchedulingManagementExample example) {
		List<SchedulingManagement> list = schedulingManagementMapper.selectByExample(example);
		return list;
	}
	
	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveSchedulingManagement(SchedulingManagement schedulingManagement) {
		
		//如果为空
		if(StringUtils.isBlank(schedulingManagement.getSchedulingManagementId())){
			//生成id
			String id = UUID.randomUUID().toString();
			schedulingManagement.setSchedulingManagementId(id);
		}
		
		//执行插入操作
		schedulingManagementMapper.insert(schedulingManagement);
		
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("添加成功");
		return resultEntity;
	}


	/**
	 * 根据主键查询字段
	 */
	@Override
	public SchedulingManagement getSchedulingManagementById(String schedulingManagementId) {
		return schedulingManagementMapper.selectByPrimaryKey(schedulingManagementId);
	}


	
	/**
	 * 更新排版管理表信息
	 */
	@Override
	public ResultEntity updateSchedulingManagement(SchedulingManagement schedulingManagement) {
		ResultEntity resultEntity = new ResultEntity();
		//执行更新
		schedulingManagementMapper.updateByPrimaryKeySelective(schedulingManagement);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
		
	}

}
