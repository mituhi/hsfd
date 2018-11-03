package com.qz.zframe.run.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;

import com.qz.zframe.run.dao.ValueTimeMapper;

import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.ValueTimeExample;
import com.qz.zframe.run.service.ValueTimeService;

/**
 * <p>Title: ValueTimeServiceImpl</p>
 * <p>@Description: 值次实现 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:46:49
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ValueTimeServiceImpl implements ValueTimeService {

	@Autowired
	private ValueTimeMapper valueTimeMapper;


	
	/**
	 * 批量获取
	 */
	@Override
	public List<ValueTime> ListValueTime(ValueTime valueTime) {
		return valueTimeMapper.listValueTime(valueTime);
	}

	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveValueTime(ValueTime valueTime) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//判断 sort 字段是否重复
		ValueTimeExample example = new ValueTimeExample();
		example.createCriteria().andSortEqualTo(valueTime.getSort());
		
		//执行查询
		List<ValueTime> list = valueTimeMapper.selectByExample(example);
		
		//如果集合有数据，则sort已存在，插入失败
		if(CollectionUtils.isNotEmpty(list)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排序值重复");
			return resultEntity;
		}
		
		// 生成id
		String id = UUID.randomUUID().toString();

		valueTime.setValueId(id);
		
		//执行插入操作
		valueTimeMapper.insert(valueTime);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("添加成功");
		return resultEntity;
	}

	@Override
	public ResultEntity removeValueTimes(List<String> ids) {
		return null;
	}


	/**
	 * 批量编辑
	 */
	@Override
	public ResultEntity editRecord(List<ValueTime> valueTimes) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isNotEmpty(valueTimes)) {
			for (ValueTime valueTime : valueTimes) {
				valueTimeMapper.updateByPrimaryKeySelective(valueTime);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行失败");
		}

		return resultEntity;
	}

	@Override
	public ResultEntity getMaxSort() {
		return null;
	}


	/**
	 * 根据id查询字段
	 */
	@Override
	public ValueTime getValueTimeById(String id) {
		return valueTimeMapper.selectByPrimaryKey(id);
	}

}
