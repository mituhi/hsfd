package com.qz.zframe.production.service;

import java.text.ParseException;
import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.entity.ProductionReports;
import com.qz.zframe.production.entity.ProductionReportsExample;

public interface ProductionReportService {

	 //查询季报信息
	 public	PageResultEntity findReport(ProductionReportsExample productionReportsExample);
     //新增季报信息
	 public ResultEntity  addReport() throws ParseException;
	
}
