package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;

/**
 * <p>Title: WorkClassificationService</p>
 * <p>@Description: 工作分类表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月12日 上午11:21:30
 * @version:V1.0
 */
public interface WorkClassificationService {
	
	/**
	 * @Description:保存
	 * @param: @param workClassification
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveWorkClassification(WorkClassification workClassification);
	
	
	/**
	 * @Description:批量获取
	 * @param: @param example
	 * @param: @return   
	 * @return: List<WorkClassification>
	 */
	List<WorkClassification> listWorkClassification(WorkClassificationExample example);
	

	/**
	 * @Description:根据id删除
	 * @param: @param classificationId   
	 * @return: void
	 */
	void deleteWorkClassificationById(String classificationId);
	
	
	
	/**
	 * @Description:跟新
	 * @param: @param workClassification
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity editWorkClassification(WorkClassification workClassification);
	
	
	
}
