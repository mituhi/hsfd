package com.qz.zframe.production.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.entity.ProductionMonth;
import com.qz.zframe.production.entity.ProductionMonthExample;

public interface ProductionMonthService {
	     //查询月报报信息
		 public	PageResultEntity findMonth(ProductionMonthExample ProductionMonthExample);
	     //新增月报信息
		 public ResultEntity  addMonth(ProductionMonth productionMonth);
		 //修改月报信息
		 public ResultEntity  updateMonth(ProductionMonth productionMonth);
		 //查询月报信息详情
		 public  PageResultEntity  findByMonthId(String monthId);
		 //批量删除月报信息
		 public   ResultEntity  deleteMonth(List<String> monthIds);
}
