package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyLogMapper;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogExample;
import com.qz.zframe.run.service.DutyLogService;

@Service
@Transactional(rollbackFor=Exception.class)
public class DutyLogServiceImpl implements DutyLogService {
	
	@Autowired
	private DutyLogMapper dutyLogMapper;
	

	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveDutyLog(DutyLog dutyLog) {
		
		ResultEntity resultEntity = new ResultEntity();
		//如果id没有值
		if(StringUtils.isEmpty(dutyLog.getDutyLogId())){
			dutyLog.setDutyLogId(UUID.randomUUID().toString());
		}
		
		dutyLogMapper.insert(dutyLog);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	/**
	 * 模糊查询
	 */
	@Override
	public List<DutyLog> listDutyLog(DutyLogExample example) {
		return dutyLogMapper.selectByExample(example);
	}


	
	/**
	 * 删除
	 */
	@Override
	public void deleteDutyLogById(List<String> dutyLogIds) {
		if(CollectionUtils.isNotEmpty(dutyLogIds)){
			//执行删除
			for (String dutyLogId : dutyLogIds) {
				dutyLogMapper.deleteByPrimaryKey(dutyLogId);
			}
		}
	}

	
	
	/**
	 * 更新
	 */
	@Override
	public void updateDutyLog(DutyLog dutyLog) {
		dutyLogMapper.updateByPrimaryKeySelective(dutyLog);
	}

}
