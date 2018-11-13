package com.qz.zframe.run.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyRemember;

/**
 * <p>Title: DutyRememberService</p>
 * <p>@Description: 值班记事表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月8日 上午11:09:04
 * @version:V1.0
 */
public interface DutyRememberService {
	
	
	/**
	 * @Description:保存
	 * @param: @param dutyRemember
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyRemember(DutyRemember dutyRemember);
	
	
	
	
}
