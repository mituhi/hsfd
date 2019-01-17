package com.qz.zframe.production.controller;

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
import com.qz.zframe.production.entity.ProductionMonth;
import com.qz.zframe.production.entity.ProductionMonthExample;
import com.qz.zframe.production.entity.ProductionMonthExample.Criteria;
import com.qz.zframe.production.service.ProductionMonthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/production/month")
@Api(tags = {"api-support-production-month"}, description = "生产-生产月报")
public class ProductionMonthController {

	private static Logger logger = LoggerFactory.getLogger(ProductionMonthController.class);

	@Autowired
	private ProductionMonthService productionMonthService;

	/**
	 * 获取月报信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 *            年份
	 * @param windCode
	 *            风电场编码
	 */
	@RequestMapping(value = "/findMonth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取月报信息", notes = " 获取月报信息")
	public PageResultEntity findMonth(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "year", value = "年份", required = false) String year,
			@RequestParam(required = false) @ApiParam(name = "windCode", value = "风电场编码", required = false) String windId,
			@RequestParam(required = false) @ApiParam(name = "windCode2", value = "风电场编码", required = false) String windId2) {

		logger.info("===== 生产-生产月报ProductionMonthController.findMonth =====year:" + year + "windId:" + windId
				+ "windId2:" + windId2);

		PageResultEntity resultEntity = new PageResultEntity();
		ProductionMonthExample productionMonthExample = new ProductionMonthExample();
		productionMonthExample.setPageSize(pageSize);
		productionMonthExample.setPageNo(pageNum);
		Criteria criteria = productionMonthExample.createCriteria();
		if (StringUtils.isNotBlank(year)) {
			criteria.andYearEqualTo(year);
		}
		
		if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId)) {
			criteria.andWindIdBetween(windId, windId2);
		}
		resultEntity = productionMonthService.findMonth(productionMonthExample);
		return resultEntity;
	}

	@RequestMapping(value = "/addMonth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增月报信息", notes = "新增月报信息")
	public ResultEntity addaddMonth(@RequestBody ProductionMonth productionMonth) {

		logger.info("===== 生产-生产月报ProductionMonthController.addMonth =====ProductionMonth:" + productionMonth);

		ResultEntity resultEntity = new ResultEntity();
		/*if () {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}*/
		resultEntity = productionMonthService.addMonth(productionMonth);
		return resultEntity;
	}

	@RequestMapping(value = "/updateParameters", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改月报信息", notes = "修改月报信息")
	public ResultEntity updateMonth(@RequestBody ProductionMonth productionMonth) {

		logger.info("===== 生产-生产月报ProductionMonthController.updateMonth =====ProductionMonth:" + productionMonth);

		ResultEntity resultEntity = new ResultEntity();
		if (/*StringUtils.isBlank(productionMonth.getActualCapacity())
				|| StringUtils.isBlank(productionMonth.getAnnualEnergyProduction())
				|| StringUtils.isBlank(productionMonth.getDailyAverageTemperature())
				|| StringUtils.isBlank(productionMonth.getDailyAverageWind())
				|| StringUtils.isBlank(productionMonth.getDailyCapacity())
				|| StringUtils.isBlank(productionMonth.getDailyOnlineShop())
				|| StringUtils.isBlank(productionMonth.getDailyOutput())
				|| StringUtils.isBlank(productionMonth.getPlanStop())
				|| StringUtils.isBlank(productionMonth.getPowerNext())
				|| StringUtils.isBlank(productionMonth.getSchedulingService())
				|| StringUtils.isBlank(productionMonth.getUnscheduledShutdown())*/
				StringUtils.isBlank(productionMonth.getMonthId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = productionMonthService.updateMonth(productionMonth);
		return resultEntity;
	}

	@RequestMapping(value = "/findByMonthId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "查询月报信息详情", notes = "查询月报信息详情")
	public PageResultEntity findByMonthId(
			@RequestParam @ApiParam(name = "monthId", value = "月报id", required = false) String monthId) {

		logger.info("===== 生产-生产月报ProductionMonthController.findMonthId =====monthId:" + monthId);

		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(monthId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中查看的数据");
			return resultEntity;
		}
		resultEntity = productionMonthService.findByMonthId(monthId);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteMonth", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除月报信息", notes = "批量删除月报信息")
	public ResultEntity deleteMonth(@RequestBody List<String> monthIds) {

		logger.info("===== 生产-生产月报ProductionMonthController.deleteMonth =====monthIds:" + monthIds);

		ResultEntity resultEntity = new ResultEntity();
		if (monthIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = productionMonthService.deleteMonth(monthIds);
		return resultEntity;
	}
}
