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
import com.qz.zframe.production.entity.ProductionWeekly;
import com.qz.zframe.production.entity.ProductionWeeklyExample;
import com.qz.zframe.production.entity.ProductionWeeklyExample.Criteria;
import com.qz.zframe.production.service.ProductionMonthService;
import com.qz.zframe.production.service.ProductionWeeklyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/production/weekly")
@Api(tags = {"api-support-production-weekly"}, description = "生产-生产周报")
public class ProductionWeeklyController {
	
    private static Logger logger = LoggerFactory.getLogger(ProductionWeeklyController.class);
	
	@Autowired
	private ProductionWeeklyService productionWeeklyService;

	/**
	 * 获取周报信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param year
	 *            年份
	 * @param cycle
	 *            周期
	 * @param windCode
	 *            风电场编码
	 */
	@RequestMapping(value = "/findWeekly", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取周报信息", notes = " 获取周报信息")
	public PageResultEntity findWeekly(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "year", value = "年份", required = false) String year,
			@RequestParam(required = false) @ApiParam(name = "cycle", value = "周期", required = false) String cycle,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场编码", required = false) String windId,
			@RequestParam(required = false) @ApiParam(name = "windId2", value = "风电场编码", required = false) String windId2) {

		logger.info("===== 生产-生产周报ProductionWeeklyController.findWeekly =====year:" + year + "cycle:" + cycle
				+ "windId:" + windId + "windId2:" + windId2);

		PageResultEntity resultEntity = new PageResultEntity();
		ProductionWeeklyExample productionWeekExample = new ProductionWeeklyExample();
		productionWeekExample.setPageSize(pageSize);
		productionWeekExample.setPageNo(pageNum);
		Criteria criteria = productionWeekExample.createCriteria();
		if (StringUtils.isNotBlank(year)) {
			criteria.andYearEqualTo(year);
		}
		if (StringUtils.isNotBlank(cycle)) {
			criteria.andYearEqualTo(cycle);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId)) {
			criteria.andWindIdBetween(windId, windId2);
		}
		resultEntity = productionWeeklyService.findWeekly(productionWeekExample);
		return resultEntity;
	}

	@RequestMapping(value = "/addWeekly", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增周报信息", notes = "新增周报信息")
	public ResultEntity addWeekly(@RequestBody ProductionWeekly productionWeekly) {

		logger.info("===== 生产-生产周报ProductionWeeklyController.addWeekly =====ProductionWeekly:" + productionWeekly);

		ResultEntity resultEntity = new ResultEntity();
		/*if (productionWeekly!=null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}*/
		resultEntity = productionWeeklyService.addWeekly(productionWeekly);
		return resultEntity;
	}

	@RequestMapping(value = "/updateWeekly", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改周报信息", notes = "修改周报信息")
	public ResultEntity updateWeekly(@RequestBody ProductionWeekly productionWeekly) {

		logger.info("===== 生产-生产周报ProductionWeeklyController.updateWeekly =====ProductionWeekly:" + productionWeekly);

		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(productionWeekly.getWeekId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = productionWeeklyService.updateWeekly(productionWeekly);
		return resultEntity;
	}

	@RequestMapping(value = "/findByWeeklyId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "查询周报信息详情", notes = "查询周报信息详情")
	public PageResultEntity findByWeeklyId(
			@RequestParam @ApiParam(name = "monthId", value = "月报id", required = false) String WeekId) {

		logger.info("===== 生产-生产周报ProductionWeeklyController.findWeeklyId =====WeekId:" + WeekId);

		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(WeekId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中查看的数据");
			return resultEntity;
		}
		resultEntity = productionWeeklyService.findByWeekId(WeekId);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteWeekly", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除周报信息", notes = "批量删除周报信息")
	public ResultEntity deleteWeekly(@RequestBody List<String> WeekIds) {

		logger.info("===== 生产-生产周报ProductionWeeklyController.deleteWeekly =====WeekIds:" + WeekIds);

		ResultEntity resultEntity = new ResultEntity();
		if (WeekIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = productionWeeklyService.deleteWeekly(WeekIds);
		return resultEntity;
	}
}
