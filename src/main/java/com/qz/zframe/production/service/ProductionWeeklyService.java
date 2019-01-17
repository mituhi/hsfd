package com.qz.zframe.production.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.entity.ProductionWeekly;
import com.qz.zframe.production.entity.ProductionWeeklyExample;

public interface ProductionWeeklyService {
	 //查询周报信息
	 public	PageResultEntity findWeekly(ProductionWeeklyExample productionWeeklyExample);
     //新增周报信息
	 public ResultEntity  addWeekly(ProductionWeekly productionWeekly);
	 //修改周报信息
	 public ResultEntity  updateWeekly(ProductionWeekly productionWeekly);
	 //查询周报信息详情
	 public  PageResultEntity  findByWeekId(String weekId);
	 //批量删除周报信息
	 public   ResultEntity  deleteWeekly(List<String> weekIds);
}
