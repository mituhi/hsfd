package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.WorkPerformMapper;
import com.qz.zframe.run.entity.WorkPerform;
import com.qz.zframe.run.entity.WorkPerformExample;
import com.qz.zframe.run.service.WorkPerformService;


/**
 * <p>Title: WorkPerformServiceImpl</p>
 * <p>@Description: 任务执行接口实现 </p>
 * @author 
 * @date 2018年11月13日 上午10:07:09
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkPerformServiceImpl implements WorkPerformService {

	@Autowired
	private WorkPerformMapper workPerformMapper;
	
	/**
	 * 保存任务执行操作
	 */
	@Override
	public ResultEntity saveWorkPerform(WorkPerform workPerform) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//没有id
		workPerform.setWorkTaskId(UUID.randomUUID().toString());
		
		//执行保存操作
		workPerformMapper.insert(workPerform);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	/**
	 * 通过查询条件批量获取信息
	 */
	@Override
	public List<WorkPerform> listWorkPerform(WorkPerformExample example) {
		return workPerformMapper.selectByExample(example);
	}


	/**
	 * 删除
	 */
	@Override
	public void deleteWorkPerformById(String performId) {
		workPerformMapper.deleteByPrimaryKey(performId);
	}


	/**
	 * 更新
	 */
	@Override
	public ResultEntity updateWorkPerform(WorkPerform workPerform) {
		ResultEntity resultEntity = new ResultEntity();
		
		workPerformMapper.updateByPrimaryKeySelective(workPerform);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 通过id获取对象
	 */
	@Override
	public WorkPerform getWorkPerformById(String performId) {
		return workPerformMapper.selectByPrimaryKey(performId);
	}


	
	/**
	 * 修改完成状态
	 */
	@Override
	public ResultEntity doneWorkPerform(String performId, String completeStatus) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		WorkPerform workPerform = new WorkPerform();
		//设置id
		workPerform.setPerformId(performId);
		//设置完成状态：  使用 1 为完成      0为未完成    -1 为不执行   （待定）
		workPerform.setCompleteStatus(completeStatus);
		//执行修改
		workPerformMapper.updateByPrimaryKeySelective(workPerform);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
