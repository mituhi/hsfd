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
import com.qz.zframe.material.entity.SupplierExample;
import com.qz.zframe.material.entity.Supplier;
import com.qz.zframe.material.entity.Supplier.ListView;
import com.qz.zframe.material.entity.SupplierExample.Criteria;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 供应商信息管理
 * 
 * @author syc
 * @date 2018年10月31日下午3:51:28
 *
 */
@RestController
@RequestMapping("/api/support/supplier")
@Api(tags = "api-support-supplier", description = "物资管理-供应商管理")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	

	@RequestMapping(value = "/listSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取供应商列表", notes = "supplierCode供应商编码，supplierName供应商名称" )
	@JsonView({ListView.class})
	public PageResultEntity listSupplier(@RequestParam(required = false) Integer pageNum,@RequestParam(required=false)Integer pageSize,
			@RequestParam(required=false) String supplierCode,@RequestParam(required=false,value="供应商名称") String supplierName){
		SupplierExample example = new SupplierExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setOrderByClause("create_time desc");
		Criteria criteria  =example.createCriteria();
		if (!StringUtils.isBlank(supplierCode)) {
			criteria.andSupplierCodeEqualTo(supplierCode);
		}
		if (!StringUtils.isBlank(supplierName)) {
			criteria.andSupplierNameLike(supplierName);
		}
		return supplierService.getSupplierList(example);
	}
	
	@RequestMapping(value = "/detailSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取供应商详情", notes = "supplierId供应商id" )
	public ResultEntity getSupplierDetail(@RequestParam String supplierId){
		return supplierService.getSupplierDetail(supplierId);
	}
	
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增供应商", notes = "新增供应商" )
	public ResultEntity addSupplier(@RequestBody(required = false) Supplier supplier){
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(supplier.getSupplierCode())||StringUtils.isBlank(supplier.getSupplierName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("参数不足");
			return resultEntity;
		}
        UserInfo userInfo = currentUSerservice.getUserInfo();
        supplier.setSupplierId(UUIdUtil.getUUID());
        supplier.setCreater(userInfo.getUserId());
        supplier.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		resultEntity = supplierService.addSupplier(supplier);
		return resultEntity;		
	}
	
	@RequestMapping(value = "/editSupplier", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑供应商信息", notes = "supplierId供应商id,必传" )
	public ResultEntity editSupplier(@RequestBody(required = false) Supplier supplier){
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(supplier.getSupplierId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("参数不足");
			return resultEntity;
		}
		resultEntity = supplierService.editSupplier(supplier);
		return resultEntity;		
	}
	@RequestMapping(value = "/delSupplier", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除供应商信息", notes = "删除供应商信息" )
	public ResultEntity delSupplier(@RequestBody  List<String> supplierIds){
		return supplierService.delSupplier(supplierIds);
	}
	
}
