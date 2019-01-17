package com.qz.zframe.material.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.controller.DataDictController;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
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
@Api(tags = "api-material-materialGroup", description = "物资管理-物资组管理")
public class MaterialGroupController {
	
	private static Logger logger = LoggerFactory.getLogger(MaterialGroupController.class);

	@Autowired
	private MaterialGroupService materialGroupService;


	@RequestMapping(value = "/listGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资组列表", notes = "isPage默认为1分页，为0时则不分页必传，status启用状态，01启动，02停用，groupCode物资组编码，groupName物资组名称")
	@JsonView({ ListView.class })
	public NewPageResult<MaterialGroup> getGroupList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false,defaultValue = "1") Integer isPage,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String groupCode,
			@RequestParam(required = false) String groupName) throws Exception {
		MaterialGroupExample materialGroupExample = new MaterialGroupExample();
		materialGroupExample.setPageSize(pageSize);
		materialGroupExample.setPageNo(pageNum);
		materialGroupExample.setIsPage(isPage);
		materialGroupExample.setOrderByClause("group_code asc");
		Criteria criteria = materialGroupExample.createCriteria();
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}
		if (!StringUtils.isBlank(groupCode)) {
			criteria.andGroupCodeLike(groupCode);
		}
		if (!StringUtils.isBlank(groupName)) {
			criteria.andGroupNameLike(groupName);
		}
		logger.info("====查询物资分组列表MaterialGroupController.getGroupList===status:"+status+"====groupCode:"+groupCode+"====groupName:"+groupName);
		criteria.andIsDeleteEqualTo("01");
		return 	materialGroupService.getGroupList(materialGroupExample);
	}
	
	@RequestMapping(value = "/listGroupAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资组不分页的全部列表", notes = "")
	@JsonView({ ListView.class })
	public NewPageResult<MaterialGroup> getGroupListAll(
			@RequestParam(required = false) String groupCode,
			@RequestParam(required = false) String groupName) throws Exception {
		MaterialGroupExample materialGroupExample = new MaterialGroupExample();
		materialGroupExample.setIsPage(0);
		materialGroupExample.setOrderByClause("group_code asc");
		Criteria criteria = materialGroupExample.createCriteria();
			criteria.andStatusEqualTo("01");
		if (!StringUtils.isBlank(groupCode)) {
			criteria.andGroupCodeLike(groupCode);
		}
		if (!StringUtils.isBlank(groupName)) {
			criteria.andGroupNameLike(groupName);
		}
		criteria.andIsDeleteEqualTo("01");
		return 	materialGroupService.getGroupList(materialGroupExample);
	}

	@RequestMapping(value = "/detailGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资组详情", notes = "materialGroupId物资组id必传")
	@ResponseBody
	public ResultEntity getGroupdetail(@RequestParam String materialGroupId) throws Exception{
		logger.info("====获取物资组详情MaterialGroupController.getGroupdetail====materialGroupId:"+materialGroupId);
		return materialGroupService.getGroupdetailById(materialGroupId);
	}

	@RequestMapping(value = "/saveGroup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增物资组信息", notes = "新增物资信息")
	public ResultEntity addGroup(@RequestBody MaterialGroup materialGroup) {	
		logger.info("====新增物资组MaterialGroupController.addGroup====MaterialGroup:"+materialGroup);
		return materialGroupService.addGroup(materialGroup);
	}

	@RequestMapping(value = "/editGroup", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资组信息", notes = "materialGroupId物资组id为必传")
	@JsonView({ ListView.class })
	public ResultEntity editGroup(@RequestBody MaterialGroup materialGroup) {
		logger.info("====编辑物资组MaterialGroupController.editGroup====MaterialGroup:"+materialGroup);
		return materialGroupService.editGroup(materialGroup);
	}

	@RequestMapping(value = "/delGroup", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资组", notes = "删除物资组")
	public ResultEntity editGroup(@RequestBody List<String> materialGroupIds) {
		logger.info("====删除物资组MaterialGroupController.editGroup====materialGroupIds:"+materialGroupIds);
		return materialGroupService.delGroup(materialGroupIds);
	}

	
}
