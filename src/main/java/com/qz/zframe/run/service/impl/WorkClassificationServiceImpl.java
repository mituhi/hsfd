package com.qz.zframe.run.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
 * @author 陈汇奇
 * @date 2018年11月12日 上午11:22:40
 * @version:V1.0
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class WorkClassificationServiceImpl implements WorkClassificationService {

	@Autowired
	private WorkClassificationMapper workClassificationMapper;
	
	
	/**
	 * 保存
	 */
	@Override
	public ResultEntity saveWorkClassification(WorkClassification workClassification) {
		
		//如果没有id:设置
		if(StringUtils.isEmpty(workClassification.getClassificationId())){
			workClassification.setClassificationId(UUID.randomUUID().toString());
		}
		
		//设置创建时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(date);
		
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		workClassification.setCreateTime(date);
		
		
		//生成流水号格式： 20181112 1001
		Date now = new Date();
		int year = now.getYear();
		int mouth = now.getMonth();
		int day = now.getDay();
		
		String randomNum = "";
		for (int i = 0; i < 4; i++) {
			randomNum=randomNum+(int)(0+Math.random()*(10));
		}
		//设置流水号
		workClassification.setClassificationCode(year+mouth+day+randomNum);
		
		
		workClassificationMapper.insert(workClassification);
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
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
	public void deleteWorkClassificationById(String classificationId) {
		workClassificationMapper.deleteByPrimaryKey(classificationId);
	}



	/**
	 * 更新
	 */
	@Override
	public ResultEntity editWorkClassification(WorkClassification workClassification) {
		ResultEntity resultEntity = new ResultEntity();
		
		workClassificationMapper.updateByPrimaryKeySelective(workClassification);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
