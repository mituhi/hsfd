package com.qz.zframe.run.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.WorkTaskMapper;
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.WorkTaskExample;
import com.qz.zframe.run.service.WorkTaskService;


/**
 * <p>Title: WorkTaskServiceImpl</p>
 * <p>@Description: 定期任务表接口实现 </p>
 * @author 
 * @date 2018年11月12日 下午3:35:03
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkTaskServiceImpl implements WorkTaskService {

	@Autowired
	private WorkTaskMapper workTaskMapper;
	
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveWorkTask(WorkTask workTask) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//生成id
		workTask.setWorkTaskId(UUID.randomUUID().toString());
		
		//设置创建时间
		workTask.setCreateTime(new Date());
		
		//生成流水号格式： 20181112 1001
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(new Date());//设置当前日期
        String yearStr = calendar.get(Calendar.YEAR)+"";//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        String monthStr = month < 10 ? "0" + month : month + "";
        int day = calendar.get(Calendar.DATE);//获取日	
		
		String randomNum = "";
		for (int i = 0; i < 4; i++) {
			randomNum=randomNum+(int)(0+Math.random()*(10));
		}
		//设置流水号
		workTask.setSerialNum(""+yearStr+monthStr+day+randomNum);
		
		workTaskMapper.insert(workTask);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 批量获取
	 */
	@Override
	public List<WorkTask> listWorkTask(WorkTaskExample example) {
		return workTaskMapper.selectByExample(example);
	}

	/**
	 * 更新
	 */
	@Override
	public ResultEntity updateWorkTask(WorkTask workTask) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		workTaskMapper.updateByPrimaryKeySelective(workTask);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 * 删除
	 */
	@Override
	public ResultEntity deleteWorkTask(String workTaskId) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		workTaskMapper.deleteByPrimaryKey(workTaskId);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 * 通过id获取信息
	 */
	@Override
	public WorkTask getWorkTaskById(String workTaskId) {
		return workTaskMapper.selectByPrimaryKey(workTaskId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
