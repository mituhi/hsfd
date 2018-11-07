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
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.entity.StoreHouseTypeExample;
import com.qz.zframe.material.entity.StoreHouseTypeExample.Criteria;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseType.ListView;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StoreHouseTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/storeHouseType")
@Api(tags = "api-support-storeHouseType", description = "物资管理-出库类型")
public class StoreHouseTypeController {

	@Autowired
	private StoreHouseTypeService storeHouseTypeService;

	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取出库类型列表", notes = "isPage默认为1分页，为0时则不分页必传，typeCode类型编码，typeName类型名称")
	@JsonView({ ListView.class })
	public PageResultEntity getStoreHouseTypeList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(defaultValue = "1") Integer isPage,
			@RequestParam(required = false) String typeCode,
			@RequestParam(required = false) String typeName) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("create_time asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(typeCode)) {
			criteria.andTypeCodeEqualTo(typeCode);
		}
		if (!StringUtils.isBlank(typeName)) {
			criteria.andTypeNameEqualTo(typeName);
		}
		return storeHouseTypeService.getStoreHouseTypeList(example);
	}

	@RequestMapping(value = "/detailType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "出库类型详情", notes = "typeId出库类型id")
	public ResultEntity getStoreHouseTypeDetail(@RequestParam String typeId) {
		return storeHouseTypeService.getStoreHouseTypeDetail(typeId);
	}

	@RequestMapping(value = "/saveType", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增出库类型", notes = "新增出库类型")
	public ResultEntity addStoreHouseType(@RequestBody StoreHouseType storeHouseType) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(storeHouseType.getTypeName()) || StringUtils.isBlank(storeHouseType.getTypeCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少参数");
			return resultEntity;
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		storeHouseType.setCreater(userInfo.getUserId());
		storeHouseType.setTypeId(UUIdUtil.getUUID());
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

}
