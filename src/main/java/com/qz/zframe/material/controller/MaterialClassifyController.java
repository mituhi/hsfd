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
import com.qz.zframe.material.entity.MaterialClassifyExample;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassify.ListView;
import com.qz.zframe.material.entity.MaterialClassifyExample.Criteria;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialClassifyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/materialClassify")
@Api(tags = "api-support-materialClassify", description = "物资管理-物资分类管理")
public class MaterialClassifyController {

	@Autowired
	private MaterialClassifyService materialClassifyService;

	@Autowired
	private CurrentUserService currentUSerservice;

	@RequestMapping(value = "/listClassify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类列表", notes = "isPage默认为1分页，为0时则不分页必传，status启用状态，01启动，02停用，")
	@JsonView({ ListView.class })
	public PageResultEntity getClassifyList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(defaultValue = "1") Integer isPage,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String classifyName,
			@RequestParam(required = false) String classifyDescribe) {
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("a.create_time desc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}
		if (!StringUtils.isBlank(classifyName)) {
			criteria.andClassifyNameEqualTo(classifyName);
		}
		if (!StringUtils.isBlank(classifyDescribe)) {
			criteria.andClassifyDescribeEqualTo(classifyDescribe);
		}
		return materialClassifyService.getClassifyList(example);
	}

	@RequestMapping(value = "/detailClassify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类详情", notes = "")
	public ResultEntity getClassifyDetail(@RequestParam String materialClassifyId) {

		return materialClassifyService.getClassifyDetail(materialClassifyId);
	}

	@RequestMapping(value = "/saveClassify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "添加物资分类", notes = "非顶级分类，则必传上级分类id")
	public ResultEntity addClassify(@RequestBody MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
		if (materialClassify.getIsTop().equals(EnableStatusEnum.ENABLE_STOP.getCode())) {
			if (StringUtils.isBlank(materialClassify.getSuperiorClassifyId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("当物资分类为非顶级时，必须传入上级类型");
				return resultEntity;
			}
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		materialClassify.setCreater(userInfo.getUserId());
		materialClassify.setMaterialClassifyId(UUIdUtil.getUUID());
		materialClassify.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		return materialClassifyService.addClassify(materialClassify);
	}
	
	@RequestMapping(value = "/editClassify", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资分类", notes = "物资分类id必传")
	public ResultEntity editClassify(@RequestBody MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
			if (StringUtils.isBlank(materialClassify.getMaterialClassifyId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资分类id必传");
				return resultEntity;
		}
		return materialClassifyService.editClassify(materialClassify);
	}

	@RequestMapping(value = "/delClassify", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资组", notes = "删除物资组")
	public ResultEntity editGroup(@RequestBody List<String> materialClassifyIds) {
		return materialClassifyService.delClassify(materialClassifyIds);
	}
	
	
}
