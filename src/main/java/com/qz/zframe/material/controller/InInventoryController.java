package com.qz.zframe.material.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventoryDetailExample;
import com.qz.zframe.material.entity.InInventoryDetail;
import com.qz.zframe.material.entity.InInventoryDetail.ListView;
import com.qz.zframe.material.entity.InInventoryExample;
import com.qz.zframe.material.entity.InInventoryExample.Criteria;
import com.qz.zframe.material.enums.InInventoryTypeEnum;
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
	public NewPageResult<InInventory> getListInInventory(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "goodsDescribed", value = "入库描述", required = false) String goodsDescribed,
			@RequestParam(required = false) @ApiParam(name = "inInventoryOrder", value = "入库单号", required = false) String inInventoryOrder,
			@RequestParam(required = false) @ApiParam(name = "inInventoryTime", value = "入库日期", required = false) String inInventoryTime,
			@RequestParam(required = false) @ApiParam(name = "stockAddId", value = "库存地id", required = false) String stockAddId,
			@RequestParam(required = false) @ApiParam(name = "stockAddName", value = "库存地名称", required = false) String stockAddName,
			@RequestParam(required = false) @ApiParam(name = "supplierId", value = "供应商id", required = false) String supplierId,
			@RequestParam(required = false) @ApiParam(name = "supplierName", value = "供应商名称", required = false) String supplierName,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "开始的风电场编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "结束的风电场编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "architectureId", value = "风电场id", required = false) String architectureId) throws ParseException {
		InInventoryExample example = new InInventoryExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause("a.create_time desc");
	
		Criteria criteria = example.createCriteria().andInInventoryTypeEqualTo(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		if (!StringUtils.isBlank(goodsDescribed)) {
			criteria.andGoodsDescribedLike(goodsDescribed);
		}
		if (!StringUtils.isBlank(inInventoryOrder)) {
			criteria.andInInventoryOrderLike(inInventoryOrder);
		}
		if (!StringUtils.isBlank(inInventoryTime)) {
			criteria.andInInventoryTimeEqualTo(format.parse(inInventoryTime));
		}
	
		if (!StringUtils.isBlank(stockAddId)) {
			criteria.andStockAddIdEqualTo(stockAddId);
		}
		if (!StringUtils.isBlank(supplierId)) {
			criteria.andSupplierIdEqualTo(supplierId);
		}
		if(!StringUtils.isBlank(startArchiteCode)){
			if(!StringUtils.isBlank(endArchiteCode)){
				criteria.andarchitectureCodeBetween(startArchiteCode, startArchiteCode);
			}else{
				criteria.andarchitectureCodeEqualTo(startArchiteCode);
			}
		}
		if(!StringUtils.isBlank(architectureId)){
			criteria.andArchitectureIdEqualTo(architectureId);
		}
		if(!StringUtils.isBlank(stockAddName)){
			criteria.andStockNameLikeTo(stockAddName);
		}
		if(!StringUtils.isBlank(supplierName)){
			criteria.andSupplierNameLikeTo(supplierName);
		}
		
		UserInfo userInfo = currentUSerservice.getUserInfo();
		criteria.andCreaterIdEqualTos(userInfo.getUserId());
		criteria.andInInventoryTypeEqualTo(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		return inInventoryService.getListInInventory(example);
	}
	
	@RequestMapping(value = "/saveInInventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增入库单", notes = "")
	public ResultEntity saveInInventory(@RequestBody InInventory inInventory) throws Exception{
		ResultEntity resultEntity = new ResultEntity();
		if(inInventory.getInInventoryDetails().size() ==0||inInventory.getInInventoryDetails().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少物资明细");
			return resultEntity;
		}
		inInventory.setInInventoryType(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		return inInventoryService.saveInInventory(inInventory);
	}
	
	@RequestMapping(value = "/detailInInventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "入库单详情", notes = "")
	public ResultEntityDetail<InInventory> getDetailInInventory(@RequestParam String inInventoryId){
		return inInventoryService.getDetailInInventory(inInventoryId);
	}

	
	@RequestMapping(value = "/editInInventory", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑入库单信息", notes = "")
	public ResultEntity editInInventory(@RequestBody InInventory inInventory) throws Exception{
		inInventory.setInInventoryType(InInventoryTypeEnum.ORDINARY_INITIAL.getCode());
		return inInventoryService.editInInventory(inInventory);
	}
	
	@RequestMapping(value = "/delInInventory", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除", notes = "")
	public ResultEntity delInInventory(@RequestBody List<String> inInventoryIds) throws ParseException{	
		return inInventoryService.delInInventory(inInventoryIds);
	}
	
	@RequestMapping(value = "/editStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "审批", notes = "")
	public ResultEntity updateOrderStatus(@RequestBody InInventory inInventory){
		ResultEntity resultEntity = new ResultEntity();
		try {
			resultEntity = inInventoryService.updateOrderStatus(inInventory);
		} catch (Exception e) {
			resultEntity.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return resultEntity;
	}
	
	@RequestMapping(value = "/listInventoryDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "入库单物资明细列表", notes = "isPage是否分页，为0时不分页，不传或传入1实现分页")
	public NewPageResult<InInventoryDetail> getStageInventoryDetailList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,@RequestParam(required = false,defaultValue="0") Integer isPage,@RequestParam(required = true) @ApiParam(name = "inInventoryId", value = "入库单主键id", required = true) String inInventoryId){
		InInventoryDetailExample example = new InInventoryDetailExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.createCriteria().andInInventoryIdEqualTo(inInventoryId);
		return inInventoryService.getStageInventoryDetailList(example);
	}

	
	@RequestMapping(value="/importMaterial",method = RequestMethod.POST)
	@ApiOperation(value = "导入物资列表", notes = "")
	@JsonView({ ListView.class })
	public NewPageResult<InInventoryDetail> importMaterial(MultipartFile file)throws Exception{
		
		return inInventoryService.importMaterial(file);
	}

}
