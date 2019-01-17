package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;

/**
 * <p>Title: DutyLogTabService</p>
 * <p>@Description: 值班日志TAB接口声明 </p>
 * @author 
 * @date 2018年11月6日 下午1:30:40
 * @version:V1.0
 */
public interface DutyLogTabService {

	/**
	 * @Description:保存值班日志TAB信息
	 * @param: @param dutyLogTab
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDutyLogTab(DutyLogTab dutyLogTab);
	
	
	/**
	 * @Description:根据查询条件给出集合
	 * @param: @param example
	 * @param: @return   
	 * @return: List<DutyLogTab>
	 */
	List<DutyLogTab> listDutyLogTab(DutyLogTabExample example,int pageNo,int pageSize);
	
	
	
	
	/**
	 * @Description:根据主键进行更新值班日志表
	 * @param: @param dutyLogTab   
	 * @return: void
	 */
	ResultEntity editDutyLogTabById(DutyLogTab dutyLogTab);
	
	
	/**
	 * @Description:根据id删除信息
	 * @param: @param id   
	 * @return: void
	 */
	void removeDutyLogTabById(List<String> tabId);
	
}
