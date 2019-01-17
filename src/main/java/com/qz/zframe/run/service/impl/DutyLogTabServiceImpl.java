package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.qz.zframe.authentication.CurrentUserService;
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
 * @author 
 * @date 2018年11月6日 下午1:40:12
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DutyLogTabServiceImpl implements DutyLogTabService {

	@Autowired
	private DutyLogTabMapper dutyLogTabMapper;

	@Autowired
	private CurrentUserService currentUserService;
	
	
	/**
	 * 保存值班日志信息
	 */
	@Override
	public ResultEntity saveDutyLogTab(DutyLogTab dutyLogTab) {
		ResultEntity resultEntity = new ResultEntity();

		// 生成id
		dutyLogTab.setTabId(UUID.randomUUID().toString());
		//生成编码
		DutyLogTabExample dutyLogTabExample = new DutyLogTabExample();
		dutyLogTabExample.createCriteria().andTabCodeIsNotNull();
		int i = dutyLogTabMapper.countByExample(dutyLogTabExample);
		dutyLogTab.setTabCode(String.valueOf(i+1));
		//添加维护人
		dutyLogTab.setMaintainer(currentUserService.getId());
		//添加维护时间
		dutyLogTab.setMaintainTime(new Date());

		// 执行插入操作
		dutyLogTabMapper.insertSelective(dutyLogTab);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("信息已保存");
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
	public ResultEntity editDutyLogTabById(DutyLogTab dutyLogTab) {
		ResultEntity resultEntity = new ResultEntity();

		//修改维护时间
		dutyLogTab.setMaintainTime(new Date());

		dutyLogTabMapper.updateByPrimaryKeySelective(dutyLogTab);

		resultEntity.setMsg("修改成功");
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}


	/**
	 * 删除
	 */
	@Override
	public void removeDutyLogTabById(List<String> tabId) {

		DutyLogTabExample dutyLogTabExample = new DutyLogTabExample();
		dutyLogTabExample.createCriteria().andTabIdIn(tabId);
		dutyLogTabMapper.deleteByExample(dutyLogTabExample);

	}

}
