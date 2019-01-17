package com.qz.zframe.run.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.run.dao.WorkPerformSearchMapper;
import com.qz.zframe.run.entity.WorkPerformSearch;
import com.qz.zframe.run.entity.submit.WorkPerformSearchSubmit;
import com.qz.zframe.run.service.WorkPerformSearchService;

/**
 * <p>Title: WorkPerformSearchServiceImpl</p>
 * <p>@Description: 任务执行查询接口实现 </p>
 * @author 
 * @date 2018年11月13日 下午5:11:51
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkPerformSearchServiceImpl implements WorkPerformSearchService {

	@Autowired
	private WorkPerformSearchMapper workPerformSearchMapper;
	
	@Override
	public List<WorkPerformSearch> listWorkPerformSearch(WorkPerformSearchSubmit submit) {
		return workPerformSearchMapper.ListworkPerformSearch(submit);
	}

}
