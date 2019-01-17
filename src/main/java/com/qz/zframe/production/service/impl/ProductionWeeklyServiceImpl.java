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
import com.qz.zframe.production.dao.ProductionWeeklyMapper;
import com.qz.zframe.production.entity.ProductionWeekly;
import com.qz.zframe.production.entity.ProductionWeeklyExample;
import com.qz.zframe.production.service.ProductionWeeklyService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductionWeeklyServiceImpl implements ProductionWeeklyService {
    @Autowired
	private  ProductionWeeklyMapper  productionWeeklyMapper;
	@Override
	public PageResultEntity findWeekly(ProductionWeeklyExample productionWeeklyExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = productionWeeklyMapper.countByExample(productionWeeklyExample);
		resultEntity.setTotal(count);
		List<ProductionWeekly> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = productionWeeklyMapper.selectByExample(productionWeeklyExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addWeekly(ProductionWeekly productionWeekly) {
		ResultEntity resultEntity = new ResultEntity();
		productionWeekly.setWeekId(UUIdUtil.getUUID());
		productionWeekly.setYear(DateUtil.getDateToYear(productionWeekly.getWeekStart()));
		boolean  apple=DateUtil.getDateForWeeek(productionWeekly.getWeekStart(),productionWeekly.getWeekEnd());
		if (apple==false) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("时间选择错误，不是同一周内的时间，请重新选择时间");
		}
		productionWeekly.setCycle("第"+DateUtil.getWeek(productionWeekly.getWeekStart())+"周");
		int save = productionWeeklyMapper.insert(productionWeekly);
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
	public ResultEntity updateWeekly(ProductionWeekly productionWeekly) {
		ResultEntity resultEntity = new ResultEntity();
		ProductionWeekly week = productionWeeklyMapper.selectByPrimaryKey(productionWeekly.getWeekId());
		if (week == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			productionWeekly.setYear(DateUtil.getDateToYear(productionWeekly.getWeekStart()));
			boolean  apple=DateUtil.getDateForWeeek(productionWeekly.getWeekStart(),productionWeekly.getWeekEnd());
			if (apple==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("时间选择错误，不是同一周内的时间，请重新选择时间");
			}
			productionWeekly.setCycle("第"+DateUtil.getWeek(productionWeekly.getWeekStart())+"周");
			int save = productionWeeklyMapper.updateByKey(productionWeekly);
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
	public PageResultEntity findByWeekId(String weekId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<ProductionWeekly> list = new ArrayList<ProductionWeekly>();
		ProductionWeekly productionWeekly = productionWeeklyMapper.selectByPrimaryKey(weekId);
		if (productionWeekly == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(productionWeekly);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteWeekly(List<String> weekIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = productionWeeklyMapper.deleteByPrimaryKeyList(weekIds);
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
