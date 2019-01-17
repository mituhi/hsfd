package com.qz.zframe.run.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.qz.zframe.authentication.CurrentUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.WorkClassificationMapper;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.service.WorkClassificationService;

/**
 * <p>Title: WorkClassificationServiceImpl</p>
 * <p>@Description: 工作分类接口实现 </p>
 * @author 
 * @date 2018年11月12日 上午11:22:40
 * @version:V1.0
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class WorkClassificationServiceImpl implements WorkClassificationService {

	@Autowired
	private WorkClassificationMapper workClassificationMapper;

	@Autowired
	private CurrentUserService currentUserService;
	
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveWorkClassification(WorkClassification workClassification) {
		ResultEntity resultEntity = new ResultEntity();

		//设置id
		workClassification.setClassificationId(UUID.randomUUID().toString());
		//设置创建人
		workClassification.setCreater(currentUserService.getId());
		//设置创建时间
		workClassification.setCreateTime(new Date());
		//设置维护人
		workClassification.setMaintainer(currentUserService.getId());
		//设置维护时间
		workClassification.setMaintainTime(new Date());

		//设置流水号
		WorkClassificationExample workClassificationExample = new WorkClassificationExample();
		workClassificationExample.createCriteria().andClassificationCodeIsNotNull();
		int i = workClassificationMapper.countByExample(workClassificationExample);
		workClassification.setClassificationCode(String.valueOf(10001+i));

		workClassificationMapper.insertSelective(workClassification);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("信息已保存");
		return resultEntity;
	}

	/**
	 * 批量获取
	 */
	@Override
	public List<WorkClassification> listWorkClassification(WorkClassificationExample example) {
		return workClassificationMapper.selectByExample(example);
	}



	@Override
	public void deleteWorkClassificationById(List<String> classificationIds) {
		WorkClassificationExample workClassificationExample = new WorkClassificationExample();
		workClassificationExample.createCriteria().andClassificationIdIn(classificationIds);
		workClassificationMapper.deleteByExample(workClassificationExample);
	}

	/**
	 * 更新
	 */
	@Override
	public ResultEntity editWorkClassification(WorkClassification workClassification) {
		ResultEntity resultEntity = new ResultEntity();

		workClassification.setMaintainer(currentUserService.getId());
		workClassification.setMaintainTime(new Date());
		workClassificationMapper.updateByPrimaryKeySelective(workClassification);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 * 获取
	 */
	@Override
	public WorkClassification getWorkClassificationById(String workClassificationId) {
		return workClassificationMapper.selectByPrimaryKey(workClassificationId);
	}

}
