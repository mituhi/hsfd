package com.qz.zframe.material.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddress.ListView;
import com.qz.zframe.material.entity.StockAddressExample;
import com.qz.zframe.material.entity.StockAddressExample.Criteria;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StockAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 库存地点管理
 * 
 * @author syc
 * @date 2018年11月3日上午11:26:15
 *
 */
@RestController
@RequestMapping("/api/support/stockAddress")
@Api(tags = "api-material-stockAddress", description = "物资管理-库存地管理")
public class StockAddressController {

	@Autowired
	private StockAddressService stockAddressService;


	@RequestMapping(value = "/listAddr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "status启用状态，01启动，02停用,secrchKey搜索关键字")
	public NewPageResult<StockAddress> getStockAddrList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required=false, defaultValue = "1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "status", value = "状态，01启用，02停用", required = false) String status,
			@RequestParam(required = false) @ApiParam(name = "searchKey", value = "关键字搜索，库存地点模糊查询", required = false) String searchKey,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "风电场开始编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "风电场结束编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "superCompetentDepartment", value = "风电场", required = false) String superCompetentDepartment,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场", required = false) String windId) {
		StockAddressExample example = new StockAddressExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("a.create_time asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}
		if(!StringUtils.isBlank(searchKey)){
			criteria.andStockAddNameLike(searchKey);
		}
		if(!StringUtils.isBlank(startArchiteCode)){
			if(!StringUtils.isBlank(endArchiteCode)){
				criteria.andarchitectureCodeBetween(startArchiteCode, endArchiteCode);
			}else{
				criteria.andArchitectureCode(startArchiteCode);
			}
		}
		if(!StringUtils.isBlank(superCompetentDepartment)){
			criteria.andArchitectureIdTo(superCompetentDepartment);
		}
		if(!StringUtils.isBlank(windId)){
			criteria.andArchitectureIdTo(windId);
		}
		criteria.andIsDeleteEqualTo("01");
		return stockAddressService.getStockAddrList(example);
	}
	
	
	
	@RequestMapping(value = "/listAddrAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取全部库存地列表")
	@JsonView({ ListView.class })
	public NewPageResult<StockAddress> getStockAddrListAll(
			@RequestParam(required = false) @ApiParam(name = "searchKey", value = "关键字搜索，库存地点模糊查询", required = false) String searchKey,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "风电场开始编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "风电场结束编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "architectureId", value = "风电场", required = false) String architectureId,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场", required = false) String windId) {
		StockAddressExample example = new StockAddressExample();
		example.setIsPage(0);
		example.setOrderByClause("a.create_time asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		criteria.andStatusEqualTo("01");
		if(!StringUtils.isBlank(searchKey)){
			criteria.andStockAddNameLike(searchKey);
		}
		if(!StringUtils.isBlank(startArchiteCode)){
			if(!StringUtils.isBlank(endArchiteCode)){
				criteria.andarchitectureCodeBetween(startArchiteCode, endArchiteCode);
			}else{
				criteria.andArchitectureCode(startArchiteCode);
			}
		}
		if(!StringUtils.isBlank(architectureId)){
			criteria.andArchitectureIdTo(architectureId);
		}
		if(!StringUtils.isBlank(windId)){
			criteria.andArchitectureIdTo(windId);
		}
		criteria.andIsDeleteEqualTo("01");
		return stockAddressService.getStockAddrList(example);
	}

	@RequestMapping(value = "/detailAddr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取库存地点详情信息", notes = "stockAddId库存地点id")
	public ResultEntityDetail<StockAddress> getGroupdetail(@RequestParam String stockAddId) {
		return stockAddressService.getStockAddrdetailById(stockAddId);
	}

	@RequestMapping(value = "/saveAddr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增库存地点信息", notes = "新增库存地点")
	public ResultEntity addStockAddr(@RequestBody StockAddress stockAddress) throws Exception {
		return stockAddressService.addStockAddr(stockAddress);
	}

	@RequestMapping(value = "/editAddr", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑库存地点信息", notes = "stockAddId库存id为必传")
	@JsonView({ ListView.class })
	public ResultEntity editGroup(@RequestBody StockAddress stockAddress)  throws Exception{
		return stockAddressService.editStockAddr(stockAddress);
	}

	@RequestMapping(value = "/delAddr", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除库存地点", notes = "stockAddIds库存id集合")
	public ResultEntity editGroup(@RequestBody List<String> stockAddIds) {
		return stockAddressService.delStockAddr(stockAddIds);
	}

}
