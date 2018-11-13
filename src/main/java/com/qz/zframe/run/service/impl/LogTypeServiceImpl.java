package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.LogTypeMapper;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.service.LogTypeService;

@Service
@Transactional(rollbackFor=Exception.class)
public class LogTypeServiceImpl implements LogTypeService {

	@Autowired
	private LogTypeMapper logTypeMapper;
	
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveLogType(LogType logType) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//生成id
		logType.setLogTypeId(UUID.randomUUID().toString());
		
		/*需要判断一下字段是否可以重复*/
		
		logTypeMapper.insert(logType);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	/**
	 * 删除
	 */
	@Override
	public void removeLogType(List<String> logTypeIds) {
		//是否为空
		if(CollectionUtils.isNotEmpty(logTypeIds)){
			for (String logTypeId : logTypeIds) {
				logTypeMapper.deleteByPrimaryKey(logTypeId);
			}
		}
	}

	/**
	 * 更新操作
	 */
	@Override
	public void editLogTypeById(LogType logType) {
		
		//更新日志类型表：字段要求
		logTypeMapper.updateByPrimaryKeySelective(logType);
	}
	
	
	/**
	 * 查询
	 */
	@Override
	public List<LogType> listLogType(LogTypeExample example) {
		return logTypeMapper.selectByExample(example);
	}


	@Override
	public List<LogType> getListByLogName(LogTypeExample example) {
		List<LogType> list = logTypeMapper.selectByExample(example);
		return list;
	}

	
	/**
	 * 根据日志类型获取对象
	 */
	@Override
	public LogType getLogTypeByLogType(LogTypeExample example) {
		
		List<LogType> list = logTypeMapper.selectByExample(example);
		if(list!=null && list.size() >0){
			return list.get(0);
		}
		
		return null;
	}

}
