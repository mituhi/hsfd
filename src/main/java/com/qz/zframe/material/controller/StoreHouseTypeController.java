package com.qz.zframe.material.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
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
import com.qz.zframe.material.entity.StoreHouseTypeExample;
import com.qz.zframe.material.entity.StoreHouseTypeExample.Criteria;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseType.ListView;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StoreHouseTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/storeHouseType")
@Api(tags = "api-material-storeHouseType", description = "物资管理-出库类型")
public class StoreHouseTypeController {

	@Autowired
	private StoreHouseTypeService storeHouseTypeService;

	@RequestMapping(value = "/listType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取出库类型列表", notes = "isPage默认为1分页，为0时则不分页必传，typeCode类型编码，typeName类型名称")
	@JsonView({ ListView.class })
	public NewPageResult<StoreHouseType> getStoreHouseTypeList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false,defaultValue = "1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "typeCode", value = "出库类型", required = false)String typeCode,
			@RequestParam(required = false) @ApiParam(name = "typeName", value = "出库类型名称", required = false) String typeName) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("a.type_code asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(typeCode)) {
			criteria.andTypeCodeLike(typeCode);
		}
		if (!StringUtils.isBlank(typeName)) {
			criteria.andTypeNameLike(typeName);
		}
		criteria.andIsDeleteEqualTo("01");
		return storeHouseTypeService.getStoreHouseTypeList(example);
	}

	@RequestMapping(value = "/detailType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "出库类型详情", notes = "typeId出库类型id")
	public ResultEntityDetail<StoreHouseType> getStoreHouseTypeDetail(@RequestParam String typeId) {
		return storeHouseTypeService.getStoreHouseTypeDetail(typeId);
	}

	@RequestMapping(value = "/saveType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增出库类型", notes = "新增出库类型")
	public ResultEntity addStoreHouseType(@RequestBody StoreHouseType storeHouseType) {
		return storeHouseTypeService.addStoreHouseType(storeHouseType);
	}

	@RequestMapping(value = "/editType", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑出库类型信息", notes = "编辑出库类型信息")
	public ResultEntity editStoreHouseType(@RequestBody StoreHouseType storeHouseType) {
		return storeHouseTypeService.editStoreHouseType(storeHouseType);
	}
	
	@RequestMapping(value = "/delType", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除出库类型", notes = "typeIds为出库类型集合")
	public ResultEntity delStoreHouseType(@RequestBody List<String> typeIds) {
		return storeHouseTypeService.delStoreHouseType(typeIds);
	}

	@RequestMapping(value = "/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "查询出关联出入库类型下拉框", notes = "isPage默认为1分页，为0时则不分页必传，typeCode类型编码，typeName类型名称")
	@JsonView({ ListView.class })
	public NewPageResult<StoreHouseType> getStoreHouseTypeLists(
			@RequestParam(required = false) @ApiParam(name = "typeId", value = "出库类型Id", required = false) String typeId) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.setIsPage(0);
		example.setOrderByClause("a.type_code asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
//		if (!StringUtils.isBlank(typeId)) {
//			criteria.andSuperTypeIdNotEqualTo(typeId);
//		}
		criteria.andSuperTypeIdIsNull();
		criteria.andIsDeleteEqualTo("01");
		criteria.andCodeNotLike("2");
		return storeHouseTypeService.getStoreHouseTypeList(example);
	}
	
	
}
