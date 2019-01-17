package com.qz.zframe.production.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.dao.ProductionYearMapper;
import com.qz.zframe.production.entity.ProductionReports;
import com.qz.zframe.production.entity.ProductionYear;
import com.qz.zframe.production.entity.ProductionYearExample;
import com.qz.zframe.production.service.ProductionYearService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductionYearServiceImpl implements ProductionYearService {
	@Autowired
	private ProductionYearMapper productionYearMapper;
	@Override
	public PageResultEntity findYear(ProductionYearExample productionYearExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = productionYearMapper.countByExample(productionYearExample);
		resultEntity.setTotal(count);
		List<ProductionYear> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = productionYearMapper.selectByExample(productionYearExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addYear(ProductionYear productionYear) {
		ResultEntity resultEntity = new ResultEntity();
		List<ProductionYear> list = productionYearMapper.insert(productionYear);
		if (list.size() <= 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

}
