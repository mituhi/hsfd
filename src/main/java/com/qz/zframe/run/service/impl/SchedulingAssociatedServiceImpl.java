package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.SchedulingAssociatedMapper;
import com.qz.zframe.run.dao.SchedulingManagementMapper;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;
import com.qz.zframe.run.service.SchedulingAssociatedService;


/**
 * <p>Title: SchedulingAssociatedServiceImpl</p>
 * <p>@Description: 排班关联表接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月2日 下午5:24:12
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SchedulingAssociatedServiceImpl implements SchedulingAssociatedService {

	@Autowired
	private SchedulingAssociatedMapper schedulingAssociatedMapper;
	
	@Autowired
	private SchedulingManagementMapper schedulingManagementMapper;
	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveSchedulingAssociated(SchedulingAssociated schedulingAssociated) {
		
		//如果为空 生成主键
		if (StringUtils.isBlank(schedulingAssociated.getId())) {
			//生成主键id
			String schedulingAssociatedId = UUID.randomUUID().toString();
			schedulingAssociated.setId(schedulingAssociatedId);
		}
		
		//执行插入操作
		schedulingAssociatedMapper.insert(schedulingAssociated);
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("添加成功");
		return resultEntity;
	}

	
	/**
	 * 批量获取
	 */
	@Override
	public List<SchedulingAssociated> listSchedulingAssociated(SchedulingAssociatedExample schedulingAssociatedExample,
			int pageNo, int pageSize) {
		
		List<SchedulingAssociated> list = Collections.emptyList();
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			list = schedulingAssociatedMapper.selectByExample(schedulingAssociatedExample);
		}
		return list;
	}


	/**
	 * 返回满足条件的总条数
	 */
	@Override
	public int selectCountTotal(SchedulingAssociatedExample schedulingAssociatedExample) {
		int count = schedulingAssociatedMapper.countByExample(schedulingAssociatedExample);
		return count;
	}

	
	/**
	 * 通过id删除信息
	 */
	@Override
	public ResultEntity removeSchedulingAssociatedById(List<String> schedulingAssociateds) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isNotEmpty(schedulingAssociateds)){
			//进行删除操作
			for (String id : schedulingAssociateds) {
				//根据id查询出schedulingManagementId
				SchedulingAssociated schedulingAssociated = schedulingAssociatedMapper.selectByPrimaryKey(id);
				//执行删除
				schedulingAssociatedMapper.deleteByPrimaryKey(id);
				//删除关联的排班管理表
				schedulingManagementMapper.deleteByPrimaryKey(schedulingAssociated.getSchedulingManagementId());
			}
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 通过id查询字段
	 */
	@Override
	public SchedulingAssociated getSchedulingAssociatedById(String schedulingAssociatedId) {
		return schedulingAssociatedMapper.selectByPrimaryKey(schedulingAssociatedId);
	}


	/**
	 * 更新信息
	 */
	@Override
	public ResultEntity updateSchedulingAssociated(SchedulingAssociated schedulingAssociated) {
		ResultEntity resultEntity = new ResultEntity();
		//执行更新
		schedulingAssociatedMapper.updateByPrimaryKeySelective(schedulingAssociated);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
}
