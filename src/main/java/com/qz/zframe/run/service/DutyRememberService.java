package com.qz.zframe.run.service;

import java.util.List;
import java.util.Set;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyRemember;

/**
 * <p>Title: DutyRememberService</p>
 * <p>@Description: 值班记事表接口声明 </p>
 * @author 
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
	
	
	/**
	 * @Description:根据主键删除
	 * @param: @param dutyRememberId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteDutyRemember(String dutyRememberId);
	
	
	
	/**
	 * @Description:更新
	 * @param: @param dutyRemember
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateDutyRemember(DutyRemember dutyRemember);
	
	
	
	/**
	 * @Description:获取所有的对象
	 * @param: @return   
	 * @return: List<DutyRemember>
	 */
	List<DutyRemember> getDutyRememberList();
	
	
	/**
	 * @Description:获取主题
	 * @param: @return   
	 * @return: Set<String>
	 */
	Set<String> getRememberTheme();
	
}
