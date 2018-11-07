package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingAssociatedExample;

/**
 * <p>Title: SchedulingAssociatedService</p>
 * <p>@Description:排班关联表接口声明  </p>
 * @author 陈汇奇
 * @date 2018年11月2日 下午5:21:33
 * @version:V1.0
 */
public interface SchedulingAssociatedService {

	
	/**
	 * @Description:保存排班关联表
	 * @param: @param schedulingAssociated
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveSchedulingAssociated(SchedulingAssociated schedulingAssociated);
	
	
	
	/**
	 * @Description:批量获取SchedulingAssociated信息
	 * @param: @param schedulingAssociatedExample
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: List<SchedulingAssociated>
	 */
	List<SchedulingAssociated> listSchedulingAssociated(SchedulingAssociatedExample schedulingAssociatedExample,int pageNo,int pageSize);
	
	
	/**
	 * @Description:返回满足条件的总条数
	 * @param: @param schedulingAssociatedExample
	 * @param: @return   
	 * @return: int
	 */
	int selectCountTotal(SchedulingAssociatedExample schedulingAssociatedExample);
	
	
	
	/**
	 * @Description:通过id删除信息
	 * @param: @param schedulingAssociateds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeSchedulingAssociatedById(List<String> schedulingAssociateds);
	
	
	
	/**
	 * @Description:通过id查询字段
	 * @param: @param schedulingAssociatedId
	 * @param: @return   
	 * @return: SchedulingAssociated
	 */
	SchedulingAssociated getSchedulingAssociatedById(String schedulingAssociatedId);
	
	
	
	/**
	 * @Description:修改字段信息
	 * @param: @param schedulingAssociated
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateSchedulingAssociated(SchedulingAssociated schedulingAssociated);
	
	
	
}
