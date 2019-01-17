package com.qz.zframe.production.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.production.dao.ProductionMonthMapper;
import com.qz.zframe.production.entity.ProductionMonth;
import com.qz.zframe.production.entity.ProductionMonthExample;
import com.qz.zframe.production.service.ProductionMonthService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductionMonthServiceImpl implements ProductionMonthService {

	@Autowired
	private  ProductionMonthMapper  productionMonthMapper;
	@Override
	public PageResultEntity findMonth(ProductionMonthExample ProductionMonthExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = productionMonthMapper.countByExample(ProductionMonthExample);
		resultEntity.setTotal(count);
		List<ProductionMonth> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = productionMonthMapper.selectByExample(ProductionMonthExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addMonth(ProductionMonth productionMonth) {
		ResultEntity resultEntity = new ResultEntity();
		productionMonth.setMonthId(UUIdUtil.getUUID());
		productionMonth.setYear(DateUtil.getDateToYear(productionMonth.getMonthStart()));
		int save = productionMonthMapper.insert(productionMonth);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateMonth(ProductionMonth productionMonth) {
		ResultEntity resultEntity = new ResultEntity();
		ProductionMonth month = productionMonthMapper.selectByPrimaryKey(productionMonth.getMonthId());
		if (month == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			productionMonth.setYear(DateUtil.getDateToYear(productionMonth.getMonthStart()));
			int save = productionMonthMapper.updateByPrimaryKey(productionMonth);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByMonthId(String monthId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<ProductionMonth> list = new ArrayList<ProductionMonth>();
		ProductionMonth productionMonth = productionMonthMapper.selectByPrimaryKey(monthId);
		if (productionMonth == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(productionMonth);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteMonth(List<String> monthIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = productionMonthMapper.deleteByPrimaryKeyList(monthIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

}
