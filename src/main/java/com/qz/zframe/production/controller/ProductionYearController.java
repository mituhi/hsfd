package com.qz.zframe.production.controller;

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
import com.qz.zframe.production.entity.ProductionYear;
import com.qz.zframe.production.entity.ProductionYearExample;
import com.qz.zframe.production.entity.ProductionYearExample.Criteria;
import com.qz.zframe.production.service.ProductionYearService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@RequestMapping("/api/support/production/year")
@Api(tags = {"api-support-production-year"}, description = "生产-生产年报")
public class ProductionYearController {
	private static Logger logger = LoggerFactory.getLogger(ProductionYearController .class);

	@Autowired
	private ProductionYearService productionYearService;

	/**
	 * 获取年报信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 *            年份
	 * @param windCode
	 *            风电场编码
	 */
	@RequestMapping(value = "/findYear", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取年报信息", notes = " 获取年报信息")
	public PageResultEntity findYear(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "year", value = "年份", required = false) String year,
			@RequestParam(required = false) @ApiParam(name = "windCode", value = "风电场编码", required = false) String windCode,
			@RequestParam(required = false) @ApiParam(name = "windCode2", value = "风电场编码", required = false) String windCode2) {

		logger.info("===== 生产-生产年报ProductionYearController.findYear =====year:" + year + "windCode:" + windCode
				+ "windCode2:" + windCode2);

		PageResultEntity resultEntity = new PageResultEntity();
		ProductionYearExample productionYearExample = new ProductionYearExample();
		productionYearExample.setPageSize(pageSize);
		productionYearExample.setPageNo(pageNum);
		Criteria criteria = productionYearExample.createCriteria();
		if (StringUtils.isNotBlank(year)) {
			criteria.andYearEqualTo(year);
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
		resultEntity = productionYearService.findYear(productionYearExample);
		return resultEntity;
	}

	@RequestMapping(value = "/addYear", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增年报信息", notes = "新增年报信息")
	public ResultEntity addYear(@RequestBody ProductionYear productionYear) {

		logger.info("===== 生产-生产年报ProductionMonthController.addYear =====ProductionYear:" + productionYear);

		ResultEntity resultEntity = new ResultEntity();
		if (productionYear==null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = productionYearService.addYear(productionYear);
		return resultEntity;
	}
}
