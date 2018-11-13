package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyLogTabMapper;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;
import com.qz.zframe.run.service.DutyLogTabService;

/**
 * <p>Title: DutyLogTabServiceImpl</p>
 * <p>@Description: 值班日志表接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月6日 下午1:40:12
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DutyLogTabServiceImpl implements DutyLogTabService {

	@Autowired
	private DutyLogTabMapper dutyLogTabMapper;
	
	
	/**
	 * 保存值班日志信息
	 */
	@Override
	public ResultEntity saveDutyLogTab(DutyLogTab dutyLogTab) {
		ResultEntity resultEntity = new ResultEntity();
		// 生成id
		dutyLogTab.setTabId(UUID.randomUUID().toString());
		// 执行插入操作
		dutyLogTabMapper.insert(dutyLogTab);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	
	/**
	 * 批量查询值班日志信息
	 */
	@Override
	public List<DutyLogTab> listDutyLogTab(DutyLogTabExample example,int pageNo,int pageSize) {
		
		List<DutyLogTab> dutyLogTabs = Collections.emptyList();
		
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			dutyLogTabs =dutyLogTabMapper.selectByExample(example);
		}else{
			dutyLogTabs =dutyLogTabMapper.selectByExample(example);
		}
		return dutyLogTabs;
		
	}


	
	/**
	 * 更新
	 */
	@Override
	public void editDutyLogTabById(DutyLogTab dutyLogTab) {
		dutyLogTabMapper.updateByPrimaryKeySelective(dutyLogTab);
	}


	/**
	 * 删除
	 */
	@Override
	public void removeDutyLogTabById(String tabId) {
		dutyLogTabMapper.deleteByPrimaryKey(tabId);
	}

}
