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
@Api(tags = "api-material-supplier", description = "物资管理-供应商管理")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	

	@RequestMapping(value = "/listSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取供应商列表", notes = "supplierCode供应商编码，supplierName供应商名称" )
	@JsonView({ListView.class})
	public NewPageResult<Supplier> listSupplier(@RequestParam(required = false) Integer pageNum,@RequestParam(required=false)Integer pageSize,
			@RequestParam(required=false) String supplierCode,@RequestParam(required=false) String supplierName,@RequestParam(required = false,defaultValue = "1") Integer isPage){
		SupplierExample example = new SupplierExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("create_time desc");
		Criteria criteria  =example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(supplierCode)) {
			criteria.andSupplierCodeLike(supplierCode);
		}
		if (!StringUtils.isBlank(supplierName)) {
			criteria.andSupplierNameLike(supplierName);
		}
		criteria.andIsDeleteEqualTo("01");
		return supplierService.getSupplierList(example);
	}
	
	@RequestMapping(value = "/listSupplierAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取供应商全部列表", notes = "supplierCode供应商编码，supplierName供应商名称" )
	@JsonView({ListView.class})
	public NewPageResult<Supplier> listSupplierAll(
			@RequestParam(required=false) String supplierCode,@RequestParam(required=false) String supplierName){
		SupplierExample example = new SupplierExample();
		example.setIsPage(0);
		example.setOrderByClause("create_time desc");
		Criteria criteria  =example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(supplierCode)) {
			criteria.andSupplierCodeLike(supplierCode);
		}
		if (!StringUtils.isBlank(supplierName)) {
			criteria.andSupplierNameLike(supplierName);
		}
		criteria.andSupplierStatusEqualTo("01");
		criteria.andIsDeleteEqualTo("01");
		return supplierService.getSupplierList(example);
	}
	
	@RequestMapping(value = "/detailSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取供应商详情", notes = "supplierId供应商id" )
	public ResultEntityDetail<Supplier> getSupplierDetail(@RequestParam String supplierId){
		return supplierService.getSupplierDetail(supplierId);
	}
	
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增供应商", notes = "新增供应商" )
	public ResultEntity addSupplier(@RequestBody(required = false) Supplier supplier){
		return supplierService.addSupplier(supplier);		
	}
	
	@RequestMapping(value = "/editSupplier", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑供应商信息", notes = "supplierId供应商id,必传" )
	public ResultEntity editSupplier(@RequestBody(required = false) Supplier supplier){
		return supplierService.editSupplier(supplier);		
	}
	@RequestMapping(value = "/delSupplier", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除供应商信息", notes = "删除供应商信息" )
	public ResultEntity delSupplier(@RequestBody  List<String> supplierIds){
		return supplierService.delSupplier(supplierIds);
	}
	
}
