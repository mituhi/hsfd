package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.run.entity.WorkPerformSearch;
import com.qz.zframe.run.entity.submit.WorkPerformSearchSubmit;


/**
 * <p>Title: WorkPerformSearchService</p>
 * <p>@Description:任务执行页面查询接口声明 </p>
 * @author 
 * @date 2018年11月13日 下午5:07:17
 * @version:V1.0
 */
public interface WorkPerformSearchService {

	
	/**
	 * @Description:批量获取
	 * @param: @param example
	 * @param: @return   
	 * @return: List<WorkPerformSearch>
	 */
	List<WorkPerformSearch> listWorkPerformSearch(WorkPerformSearchSubmit submit);
	
}
