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
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddress.ListView;
import com.qz.zframe.material.entity.StockAddressExample;
import com.qz.zframe.material.entity.StockAddressExample.Criteria;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StockAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 库存地点管理
 * 
 * @author syc
 * @date 2018年11月3日上午11:26:15
 *
 */
@RestController
@RequestMapping("/api/support/stockAddress")
@Api(tags = "api-support-stockAddress", description = "物资管理-库存地管理")
public class StockAddressController {

	@Autowired
	private StockAddressService stockAddressService;

	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listAddr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取库存地点列表", notes = "isPage默认为1分页，为0时则不分页，status启用状态，01启动，02停用,secrchKey搜索关键字")
	@JsonView({ ListView.class })
	public PageResultEntity getStockAddrList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(defaultValue = "1") Integer isPage,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String secrchKey) {
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
		if (!StringUtils.isBlank(secrchKey)) {
			criteria.andStockAddNameLike(secrchKey);
		}
		return stockAddressService.getStockAddrList(example);
	}

	@RequestMapping(value = "/detailAddr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取库存地点详情信息", notes = "stockAddId库存地点id")
	public ResultEntity getGroupdetail(@RequestParam String stockAddId) {
		return stockAddressService.getStockAddrdetailById(stockAddId);
	}

	@RequestMapping(value = "/saveAddr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增库存地点信息", notes = "新增库存地点")
	public ResultEntity addStockAddr(@RequestBody StockAddress stockAddress) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(stockAddress.getStockAddCode()) || StringUtils.isBlank(stockAddress.getStockAddName())
				|| StringUtils.isBlank(stockAddress.getStockAddAttr()) || StringUtils.isBlank(stockAddress.getStatus())
				|| StringUtils.isBlank(stockAddress.getWindId()) || StringUtils.isBlank(stockAddress.getRemark())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少参数");
			return resultEntity;
		}

		UserInfo userInfo = currentUSerservice.getUserInfo();
		stockAddress.setCreater(userInfo.getUserId());
		stockAddress.setStockAddId(UUIdUtil.getUUID());
		stockAddress.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		resultEntity = stockAddressService.addStockAddr(stockAddress);
		return resultEntity;
	}

	@RequestMapping(value = "/editAddr", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑库存地点信息", notes = "stockAddId库存id为必传")
	@JsonView({ ListView.class })
	public ResultEntity editGroup(@RequestBody StockAddress stockAddress) {
		return stockAddressService.editStockAddr(stockAddress);
	}

	@RequestMapping(value = "/delAddr", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除库存地点", notes = "stockAddIds库存id集合")
	public ResultEntity editGroup(@RequestBody List<String> stockAddIds) {
		return stockAddressService.delStockAddr(stockAddIds);
	}

}
