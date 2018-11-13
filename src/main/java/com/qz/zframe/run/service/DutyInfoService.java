package com.qz.zframe.run.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyInfo;

/**
 * <p>Title: DutyInfoService</p>
 * <p>@Description: 值班信息表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月8日 下午3:43:19
 * @version:V1.0
 */
public interface DutyInfoService {

	/**
	 * @Description:保存
	 * @param: @param dutyInfo
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyInfo(DutyInfo dutyInfo);
	
}
