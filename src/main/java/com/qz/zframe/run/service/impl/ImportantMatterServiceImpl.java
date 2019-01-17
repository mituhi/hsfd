package com.qz.zframe.run.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.qz.zframe.authentication.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.run.dao.ImportantMatterMapper;
import com.qz.zframe.run.entity.ImportantMatter;
import com.qz.zframe.run.entity.ImportantMatterExample;
import com.qz.zframe.run.service.ImportantMatterService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ImportantMatterServiceImpl implements ImportantMatterService {
	
	@Autowired
	private ImportantMatterMapper importantMatterMapper;

	@Autowired
	private CurrentUserService currentUserService;
	
	/**
	 * 添加
	 */
	@Override
	public void saveImportantMatter(ImportantMatter importantMatter) {

		//生成id
		importantMatter.setMatterId(UUID.randomUUID().toString());
		//设置维护人
		importantMatter.setUpdatePerson(currentUserService.getId());
		//设置维护时间
		importantMatter.setUpdateTime(new Date());
		//执行插入
		importantMatterMapper.insertSelective(importantMatter);

	}

	/**
	 * 删除
	 */
	@Override
	public void removeImportantMatterByIds(List<String> importantMatterId) {

		ImportantMatterExample importantMatterExample = new ImportantMatterExample();
		importantMatterExample.createCriteria().andMatterIdIn(importantMatterId);
		importantMatterMapper.deleteByExample(importantMatterExample);

	}

	
	/**
	 * 查询
	 */
	@Override
	public List<ImportantMatter> listImportantMatter(ImportantMatterExample example) {
		List<ImportantMatter> list = importantMatterMapper.selectByExample(example);
		return list;
	}

	
	/**
	 * 编辑
	 */
	@Override
	public void editImportantMatterById(ImportantMatter importantMatter) {

		//设置维护人
		importantMatter.setUpdatePerson(currentUserService.getId());
		//设置维护时间
		importantMatter.setUpdateTime(new Date());
		//插入数据库
		importantMatterMapper.updateByPrimaryKeySelective(importantMatter);
	}

}
