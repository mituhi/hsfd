package com.qz.zframe.material.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventory.ListView;
import com.qz.zframe.material.entity.InInventoryExample;
import com.qz.zframe.material.entity.InInventoryExample.Criteria;
import com.qz.zframe.material.enums.InInventoryTypeEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.InInventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/inInventory")
@Api(tags = "api-support-inInventory", description = "物资管理-入库单管理")
public class InInventoryController {
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 

	@Autowired
	private InInventoryService inInventoryService;
	
	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listInInventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "入库单列表", notes = "")
	@JsonView({ ListView.class })
	public PageResultEntity getListInInventory(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "goodsDescribed", value = "入库描述", required = false) String goodsDescribed,
			@RequestParam(required = false) @ApiParam(name = "inInventoryOrder", value = "入库单号", required = false) String inInventoryOrder,
			@RequestParam(required = false) @ApiParam(name = "inInventoryTime", value = "入库日期", required = false) String inInventoryTime,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场id", required = false) String windId,
			@RequestParam(required = false) @ApiParam(name = "stockAddId", value = "库存地id", required = false) String stockAddId,
			@RequestParam(required = false) @ApiParam(name = "supplierId", value = "供应商id", required = false) String supplierId) throws ParseException {
		InInventoryExample example = new InInventoryExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause("a.create_time desc");
		Criteria criteria = example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andInInventoryTypeEqualTo(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		if (!StringUtils.isBlank(goodsDescribed)) {
			criteria.andGoodsDescribedLike(goodsDescribed);
		}
		if (!StringUtils.isBlank(inInventoryOrder)) {
			criteria.andInInventoryOrderEqualTo(inInventoryOrder);
		}
		if (!StringUtils.isBlank(inInventoryTime)) {
			criteria.andInInventoryTimeEqualTo(format.parse(inInventoryTime));
		}
		if (!StringUtils.isBlank(windId)) {
			criteria.andWindIdEqualTo(windId);
		}
		if (!StringUtils.isBlank(stockAddId)) {
			criteria.andStockAddIdEqualTo(stockAddId);
		}
		if (!StringUtils.isBlank(supplierId)) {
			criteria.andSupplierIdEqualTo(supplierId);
		}
		criteria.andInInventoryTypeEqualTo(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		return inInventoryService.getListInInventory(example);
	}
	
	@RequestMapping(value = "/saveInInventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增入库单", notes = "")
	public ResultEntity saveInInventory(@RequestBody InInventory inInventory) throws ParseException{
		ResultEntity resultEntity = new ResultEntity();
		if(inInventory.getInInventoryDetails().size() ==0||inInventory.getInInventoryDetails().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少物资明细");
			return resultEntity;
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		inInventory.setCreater(userInfo.getUserId());
		inInventory.setInInventoryType(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		inInventory.setInInventoryTime(format.parse(inInventory.getInInventoryDate()));
		return inInventoryService.saveInInventory(inInventory);
	}
	
	@RequestMapping(value = "/detailInInventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "入库单详情", notes = "")
	public ResultEntity getDetailInInventory(@RequestParam String inInventoryId){
		return inInventoryService.getDetailInInventory(inInventoryId);
	}

	
	@RequestMapping(value = "/editInInventory", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增损坏件入库", notes = "")
	public ResultEntity editInInventory(@RequestBody InInventory inInventory) throws ParseException{	
		return inInventoryService.editInInventory(inInventory);
	}
	
	@RequestMapping(value = "/delInInventory", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除", notes = "")
	public ResultEntity delInInventory(@RequestBody List<String> inInventoryIds) throws ParseException{	
		return inInventoryService.delInInventory(inInventoryIds);
	}


}
