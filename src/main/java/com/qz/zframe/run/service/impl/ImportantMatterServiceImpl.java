package com.qz.zframe.run.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	

	/**
	 * 添加
	 */
	@Override
	public void saveImportantMatter(ImportantMatter importantMatter) {
		//生成id
		importantMatter.setMatterId(UUID.randomUUID().toString());
		//设置修改时间
		importantMatter.setUpdateTime(new Date());
		//执行插入
		importantMatterMapper.insert(importantMatter);
	}

	/**
	 * 删除
	 */
	@Override
	public void removeImportantMatterByIds(List<String> ImportantMatterId) {
		for (String matterId : ImportantMatterId) {
			importantMatterMapper.deleteByPrimaryKey(matterId);
		}
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
		importantMatterMapper.updateByPrimaryKeySelective(importantMatter);
	}

}
