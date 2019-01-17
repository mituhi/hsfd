package com.qz.zframe.production.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.dao.OrgArchitectureDao;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.production.dao.ProductionMonthMapper;
import com.qz.zframe.production.dao.ProductionReportsMapper;
import com.qz.zframe.production.entity.MonthStatistics;
import com.qz.zframe.production.entity.ProductionMonth;
import com.qz.zframe.production.entity.ProductionReports;
import com.qz.zframe.production.entity.ProductionReportsExample;
import com.qz.zframe.production.service.ProductionReportService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductionReportServiceImpl implements ProductionReportService {
	@Autowired
	private ProductionReportsMapper productionReportMapper ;
	@Autowired
	private ProductionMonthMapper productionMonthMapper ;
	@Autowired
	private OrgArchitectureDao orgArchitectureDao ;
	@Override
	public PageResultEntity findReport(ProductionReportsExample productionReportsExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = productionReportMapper.countByExample(productionReportsExample);
		resultEntity.setTotal(count);
		List<ProductionReports> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = productionReportMapper.selectByExample(productionReportsExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addReport() throws ParseException {
	ResultEntity resultEntity = new ResultEntity();
		int save=0;
		
		List<OrgArchitecture> orgArchitecture=orgArchitectureDao.findWind();
	    String year=DateUtil.getNowDate();
		int nowYear = Integer.parseInt(year)-1;
		String last=String.valueOf(nowYear);
		/*String month=DateUtil.getDateToMonth(DateUtil.getCurrentQuarterEndTime());
		String monthS=String.valueOf(Integer.parseInt(month)-2);
		String ti=year+"-"+monthS+"-"+"01";
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		Date monthStart=format1.parse(ti);
		Date monthStart2=DateUtil.getCurrentQuarterEndTime();*/
		ProductionReports  report=new  ProductionReports();
		for (OrgArchitecture arc:orgArchitecture) {
			MonthStatistics productionMonth= productionMonthMapper.selectByYearAndWindId(year, arc.getArchitectureCode());
			MonthStatistics  lastProductionMonth=productionMonthMapper.selectByYearAndWindId(last, arc.getArchitectureCode());
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setActualFinish(productionMonth.getMonthCapacity());
			report.setPlanFinish("");
			report.setLastYear(lastProductionMonth.getMonthCapacity());
			Double ss=(Double.parseDouble(productionMonth.getMonthCapacity())/(double)100)*100;
			report.setCompletion(ss.toString());
			report.setYear(year);
			report.setProject("累计季度发电量");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setPlanFinish("0");
			report.setActualFinish(productionMonth.getFullConsumption());
			report.setLastYear(lastProductionMonth.getFullConsumption());
			report.setYear(year);
			report.setProject("累计季度上网电量");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setPlanFinish("0");
			report.setActualFinish(productionMonth.getAbandonedWindPower());
			report.setLastYear(lastProductionMonth.getAbandonedWindPower());
			report.setYear(year);
			report.setProject("累计季度上弃风电量");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setPlanFinish("0");
			Double wind=Double.parseDouble(productionMonth.getAverageWindSpeed())/(double)3;
			Double lastWind=Double.parseDouble(lastProductionMonth.getAverageWindSpeed())/(double)3;
			report.setActualFinish(wind.toString());
			report.setLastYear(lastWind.toString());
			report.setYear(year);
			report.setProject("累计季度平均风速");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setPlanFinish("0");
			report.setActualFinish(productionMonth.getNumberShutdowns());
			report.setLastYear(lastProductionMonth.getNumberShutdowns());
			report.setYear(year);
			report.setProject("累计季度非正常提及次数");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			report=new  ProductionReports();
			report.setReportsId(UUIdUtil.getUUID());
			report.setWindId(productionMonth.getWindId());
			report.setWindName(productionMonth.getWindName());
			report.setWindCode(productionMonth.getWindCode());
			report.setPlanFinish("0");
			report.setActualFinish(productionMonth.getAverageAvailableHours());
			report.setLastYear(lastProductionMonth.getAverageAvailableHours());
			report.setYear(year);
			report.setProject("累计等效利用小时数");
			report.setTime(DateUtil.getSeason());
			save= productionReportMapper.insert(report);
			
		}
		if (save==0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}
	}

