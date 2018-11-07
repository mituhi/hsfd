package com.qz.zframe.run.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.UserValueTime;

/**
 * <p>Title: UserValueTimeService</p>
 * <p>@Description: 人员值次关联表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月2日 上午10:27:23
 * @version:V1.0
 */
public interface UserValueTimeService {

	/**
	 * @Description:保存操作
	 * @param: @param userValueTime
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveUserValueTime(UserValueTime userValueTime);
	
	
	
	
	
}
