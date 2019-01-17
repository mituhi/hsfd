package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.ValueTimeMapper;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ValueTime;
import com.qz.zframe.run.entity.ValueTimeExample;
import com.qz.zframe.run.service.ValueTimeService;

/**
 * <p>Title: ValueTimeServiceImpl</p>
 * <p>@Description: 值次实现 </p>
 * @author 
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
	public List<ValueTime> ListValueTime(ValueTimeExample example , int pageNo , int pageSize) {
		
		List<ValueTime> valueTimes = Collections.emptyList();
		
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			valueTimes =valueTimeMapper.selectByExample(example);
		}else{
			valueTimes =valueTimeMapper.selectByExample(example);
		}
		
		/*for(ValueTime  vt:valueTimes) {
			vt.setStatusName(statusName(vt.getStatus()));
		}*/
		return valueTimes;
		
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
		
		ResultEntity resultEntity = new ResultEntity();
		
		for (String id : ids) {
			valueTimeMapper.deleteByPrimaryKey(id);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 批量编辑
	 */
	@Override
	public ResultEntity editRecord(List<ValueTime> valueTimes) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isNotEmpty(valueTimes)) {
			for (ValueTime valueTime : valueTimes) {
				
				//执行更新前，确保排序没有改变:不允许修改排序字段
				ValueTime valueTimeTemp = valueTimeMapper.selectByPrimaryKey(valueTime.getValueId());
				valueTime.setSort(valueTimeTemp.getSort());
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
		ResultEntity resultEntity = new ResultEntity();
		//设置初始值为0
		int sort = 0 ;
			int value = valueTimeMapper.selectCount();
			if(value==0) {
				sort=1;
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("排序序号生成成功");
				resultEntity.setData(sort);
			}else {
				sort=value+1;
				ValueTime values= valueTimeMapper.selectSort(sort);
				if(values!=null) {
					sort=sort+1;
				}
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("排序序号生成成功");
				resultEntity.setData(sort);
			}
		  return resultEntity;
	}

	/**
	 * 根据id查询字段
	 */
	@Override
	public ValueTime getValueTimeById(String id) {
		ValueTime valueTime= valueTimeMapper.selectByPrimaryKey(id);
		/*if(valueTime!=null) {
			valueTime.setStatusName(statusName(valueTime.getStatus()));
		}*/
		return  valueTime;
	}


	/**
	 * 根据值次名称获取ValueTime
	 */
	@Override
	public ValueTime getValueTimeByValueName(String valueName) {
		
		ValueTimeExample example = new ValueTimeExample();
		example.createCriteria().andValueNameEqualTo(valueName);
		List<ValueTime> list = valueTimeMapper.selectByExample(example);
		
		ValueTime valueTime = new ValueTime();
		//查询出来的结果如果不为空 ， 取出第一个
		if(CollectionUtils.isNotEmpty(list)){
			valueTime = list.get(0);
		}
		return valueTime;
	}


	/**
	 * 通过code获取id
	 */
	@Override
	public String getValueTimeIdByValueCode(String valueCode) {
		
		ValueTimeExample example = new ValueTimeExample();
		example.createCriteria().andValueCodeEqualTo(valueCode);
		List<ValueTime> list = valueTimeMapper.selectByExample(example);
		
		if(CollectionUtils.isNotEmpty(list)){
			ValueTime valueTime = list.get(0);
			return valueTime.getValueId();
		}
		
		return null;
	}

	
	/**
	 * 通过schedulingRuleId连表查询值次表信息返回
	 */
	@Override
	public List<ValueTime> getValueTimes(String schedulingRuleId) {
		List<ValueTime> list = valueTimeMapper.getValueTimeBySchedulingRuleId(schedulingRuleId);
		return list;
	}

	public String statusName(String status) {
		if("01".equals(status)) {
		   return "启用";
		}else {
			return "停用";
		}
	}
	

}
