package com.qz.zframe.production.controller;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.production.entity.ProductionReports;
import com.qz.zframe.production.entity.ProductionReportsExample;
import com.qz.zframe.production.entity.ProductionReportsExample.Criteria;
import com.qz.zframe.production.service.ProductionReportService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/production/report")
@Api(tags = {"api-support-production-report"}, description = "生产-生产季报")
public class ProductionReportController {
	 private static Logger logger = LoggerFactory.getLogger(ProductionReportController.class);
		
		@Autowired
		private ProductionReportService productionReportService;

		/**
		 * 获取周报信息
		 * 
		 * @param pageNum
		 * @param pageSize
		 * @param year
		 *            年份
		 * @param time
		 *            周期季度
		 * @param windCode
		 *            风电场编码
		 */
		@RequestMapping(value = "/findReport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 获取季报信息", notes = " 获取季报信息")
		public PageResultEntity findReport(@RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "10") Integer pageSize,
				@RequestParam(required = false) @ApiParam(name = "year", value = "年份", required = false) String year,
				@RequestParam(required = false) @ApiParam(name = "time", value = "时间季度", required = false) String time,
				@RequestParam(required = false) @ApiParam(name = "windCode", value = "风电场编码", required = false) String windCode,
				@RequestParam(required = false) @ApiParam(name = "windCode", value = "风电场编码", required = false) String windCode2) {

			logger.info("===== 生产-生产季报ProductionReportController.findReport =====year:" + year + "time:" + time
					+ "windCode:" + windCode + "windCode2:" + windCode2);

			PageResultEntity resultEntity = new PageResultEntity();
			ProductionReportsExample productionReportExample = new ProductionReportsExample();
			productionReportExample.setPageSize(pageSize);
			productionReportExample.setPageNo(pageNum);
			Criteria criteria = productionReportExample.createCriteria();
			if (StringUtils.isNotBlank(year)) {
				criteria.andYearEqualTo(year);
			}
			if (StringUtils.isNotBlank(time)) {
				criteria.andTimeEqualTo(time);
			}
			if (StringUtils.isNotBlank(windCode) && StringUtils.isBlank(windCode2)) {
				criteria.andWindCodeEqualTo(windCode);
			}
			if (StringUtils.isBlank(windCode) && StringUtils.isNotBlank(windCode2)) {
				criteria.andWindCodeEqualTo(windCode2);
			}
			if (StringUtils.isNotBlank(windCode) && StringUtils.isNotBlank(windCode2)) {
				criteria.andWindCodeBetween(windCode, windCode2);
			}
			resultEntity = productionReportService.findReport(productionReportExample);
			return resultEntity;
		}

		@RequestMapping(value = "/addReport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = "新增季报信息", notes = "新增季报信息")
		public ResultEntity addReport() throws ParseException {

			logger.info("===== 生产-生产季报ProductionReportController.addReport =====ProductionReport:");

			ResultEntity resultEntity = new ResultEntity();
			/*if (productionReport==null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少必要字段");
				return resultEntity;
			}*/
			resultEntity = productionReportService.addReport();
			return resultEntity;
		}

}
