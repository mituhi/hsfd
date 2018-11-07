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
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.entity.MaterialGroupExample;
import com.qz.zframe.material.entity.MaterialGroupExample.Criteria;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.MaterialGroup.ListView;
import com.qz.zframe.material.service.MaterialGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/materialGroup")
@Api(tags = "api-support-materialGroup", description = "物资管理-物资组管理")
public class MaterialGroupController {

	@Autowired
	private MaterialGroupService materialGroupService;

	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资组列表", notes = "isPage默认为1分页，为0时则不分页必传，status启用状态，01启动，02停用，groupCode物资组编码，groupName物资组名称")
	@JsonView({ ListView.class })
	public PageResultEntity getGroupList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(defaultValue = "1") Integer isPage,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String groupCode,
			@RequestParam(required = false) String groupName) {
		MaterialGroupExample materialGroupExample = new MaterialGroupExample();
		materialGroupExample.setPageSize(pageSize);
		materialGroupExample.setPageNo(pageNum);
		materialGroupExample.setIsPage(isPage);
		materialGroupExample.setOrderByClause("create_time asc");
		Criteria criteria = materialGroupExample.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}
		if (!StringUtils.isBlank(groupCode)) {
			criteria.andGroupCodeEqualTo(groupCode);
		}
		if (!StringUtils.isBlank(groupName)) {
			criteria.andGroupNameEqualTo(groupName);
		}
		return materialGroupService.getGroupList(materialGroupExample);
	}

	@RequestMapping(value = "/detailGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资组详情", notes = "materialGroupId物资组id必传")
	public ResultEntity getGroupdetail(@RequestParam String materialGroupId) {
		return materialGroupService.getGroupdetailById(materialGroupId);
	}

	@RequestMapping(value = "/saveGroup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增物资组信息", notes = "新增物资信息")
	public ResultEntity addGroup(@RequestBody MaterialGroup materialGroup) {
		UserInfo userInfo = currentUSerservice.getUserInfo();
		materialGroup.setCreater(userInfo.getUserId());
		materialGroup.setMaterialGroupId(UUIdUtil.getUUID());
		materialGroup.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		return materialGroupService.addGroup(materialGroup);
	}

	@RequestMapping(value = "/editGroup", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资组信息", notes = "materialGroupId物资组id为必传")
	@JsonView({ ListView.class })
	public ResultEntity editGroup(@RequestBody MaterialGroup materialGroup) {
		return materialGroupService.editGroup(materialGroup);
	}

	@RequestMapping(value = "/delGroup", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资组", notes = "删除物资组")
	public ResultEntity editGroup(@RequestBody List<String> materialGroupIds) {
		return materialGroupService.delGroup(materialGroupIds);
	}

	
}
