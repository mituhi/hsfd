package com.qz.zframe.production.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.entity.ProductionYear;
import com.qz.zframe.production.entity.ProductionYearExample;


public interface ProductionYearService {
	 //查询年报信息
	 public	PageResultEntity findYear(ProductionYearExample productionYearExample);
    //新增年报信息
	 public ResultEntity  addYear(ProductionYear productionYear);
}
