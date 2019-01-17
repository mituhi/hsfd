package com.qz.zframe.material.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.qz.zframe.material.entity.MaterialClassifyExample;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassify.ListView;
import com.qz.zframe.material.entity.MaterialClassifyExample.Criteria;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialClassifyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/materialClassify")
@Api(tags = "api-material-materialClassify", description = "物资管理-物资分类管理")
public class MaterialClassifyController {
	
	private static Logger logger = LoggerFactory.getLogger(MaterialClassifyController.class);

	@Autowired
	private MaterialClassifyService materialClassifyService;


	@RequestMapping(value = "/listClassify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类列表", notes = "isPage默认为1分页，为0时则不分页必传，status启用状态，01启动，02停用，")
	@JsonView({ ListView.class })
	public NewPageResult<MaterialClassify> getClassifyList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false,defaultValue = "1") Integer isPage,
			@RequestParam(required = false)@ApiParam(name = "status", value = "状态，01启用，02停用", required = false) String status,
			@RequestParam(required = false)@ApiParam(name = "classifyName", value = "分类名称", required = false) String classifyName,
			@RequestParam(required = false)@ApiParam(name = "classifyDescribe", value = "分类描述", required = false) String classifyDescribe,
			@RequestParam(required = false)@ApiParam(name = "isTop", value = "是否顶级", required = false) String isTop,
			@RequestParam(required = false)@ApiParam(name = "superiorClassifyId", value = "父级Id", required = false) String superiorClassifyId) throws Exception{
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.setPageSize(pageSize);
		example.setPageNo(pageNum);
		example.setIsPage(isPage);
		example.setOrderByClause("a.classify_name asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}
		if (!StringUtils.isBlank(classifyName)) {
			criteria.andClassifyNameLike(classifyName);
		}
		if (!StringUtils.isBlank(classifyDescribe)) {
			criteria.andClassifyDescribeLike(classifyDescribe);
		}
		if (!StringUtils.isBlank(isTop)) {
			criteria.andIsTopEqualTo(isTop);
		}
		if (!StringUtils.isBlank(superiorClassifyId)) {
			criteria.andSuperiorClassifyIdEqualTo(superiorClassifyId);
		}
		criteria.andIsDeleteEqualTo("01");
		logger.info("====查询物资分类列表MaterialClassifyController.getClassifyList===classifyName:"+classifyName+"===classifyDescribe:"+classifyDescribe);
		return materialClassifyService.getClassifyList(example);
	}

	@RequestMapping(value = "/detailClassify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类详情", notes = "")
	public ResultEntityDetail<MaterialClassify> getClassifyDetail(@RequestParam String materialClassifyId)throws Exception {
		logger.info("====查询物资分类详情MaterialClassifyController.getClassifyDetail===materialClassifyId:"+materialClassifyId);
		return materialClassifyService.getClassifyDetail(materialClassifyId);
	}

	@RequestMapping(value = "/saveClassify", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "添加物资分类", notes = "非顶级分类，则必传上级分类id")
	public ResultEntity addClassify(@RequestBody MaterialClassify materialClassify) {
		logger.info("====新增物资分类详情MaterialClassifyController.addClassify===materialClassify:"+materialClassify);
		return materialClassifyService.addClassify(materialClassify);
	}
	
	@RequestMapping(value = "/editClassify", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资分类", notes = "物资分类id必传")
	public ResultEntity editClassify(@RequestBody MaterialClassify materialClassify) {
		logger.info("====编辑物资分类详情MaterialClassifyController.editClassify===materialClassify:"+materialClassify);
		return materialClassifyService.editClassify(materialClassify);
	}

	@RequestMapping(value = "/delClassify", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资分类", notes = "删除物资分类")
	public ResultEntity delClassify(@RequestBody List<String> materialClassifyIds) {
		logger.info("====删除物资分类MaterialClassifyController.delClassify===materialClassifyIds:"+materialClassifyIds);
		return materialClassifyService.delClassify(materialClassifyIds);
	}
	
	@RequestMapping(value = "/listClassifyAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类下拉框", notes = "")
	public NewPageResult<MaterialClassify> getClassifyListAll(
			@RequestParam(required = false)@ApiParam(name = "classifyName", value = "分类名称", required = false) String classifyName,
			@RequestParam(required = false)@ApiParam(name = "classifyDescribe", value = "分类描述", required = false) String classifyDescribe,
			@RequestParam(required = false)@ApiParam(name = "superiorClassifyId", value = "父级Id", required = false) String superiorClassifyId,
			@RequestParam(required = false)@ApiParam(name = "isTop", value = "父级Id", required = false) String isTop) throws Exception {
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.setIsPage(0);
		example.setOrderByClause("a.classify_name asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());	
	    criteria.andStatusEqualTo("01");
		if (!StringUtils.isBlank(classifyName)) {
			criteria.andClassifyNameLike(classifyName);
		}
		if (!StringUtils.isBlank(classifyDescribe)) {
			criteria.andClassifyDescribeLike(classifyDescribe);
		}
		criteria.andIsTopEqualTo("01");	
		if (!StringUtils.isBlank(superiorClassifyId)) {
			criteria.andSuperiorClassifyIdEqualTo(superiorClassifyId);
		}
		criteria.andIsDeleteEqualTo("01");
		logger.info("====查询物资分类列表MaterialClassifyController.getClassifyList===classifyName:"+classifyName+"===classifyDescribe:"+classifyDescribe);
		return materialClassifyService.getClassifyList(example);
	}
	
	@RequestMapping(value = "/listClassifyNoPages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类下拉框", notes = "")
	public NewPageResult<MaterialClassify> getClassifyListAllNoPages(
			@RequestParam(required = false)@ApiParam(name = "classifyName", value = "分类名称", required = false) String classifyName,
			@RequestParam(required = false)@ApiParam(name = "classifyDescribe", value = "分类描述", required = false) String classifyDescribe,
			@RequestParam(required = false)@ApiParam(name = "superiorClassifyId", value = "父级Id", required = false) String superiorClassifyId,
			@RequestParam(required = false)@ApiParam(name = "isTop", value = "父级Id", required = false) String isTop) throws Exception {
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.setIsPage(0);
		example.setOrderByClause("a.classify_name asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());	
	    criteria.andStatusEqualTo("01");
		if (!StringUtils.isBlank(classifyName)) {
			criteria.andClassifyNameLike(classifyName);
		}
		if (!StringUtils.isBlank(classifyDescribe)) {
			criteria.andClassifyDescribeLike(classifyDescribe);
		}
		if (!StringUtils.isBlank(superiorClassifyId)) {
			criteria.andSuperiorClassifyIdEqualTo(superiorClassifyId);
		}
		criteria.andIsDeleteEqualTo("01");
		logger.info("====查询物资分类列表MaterialClassifyController.getClassifyList===classifyName:"+classifyName+"===classifyDescribe:"+classifyDescribe);
		return materialClassifyService.getClassifyList(example);
	}
	
	
	@RequestMapping(value = "/listClassifyTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资分类树形下拉框", notes = "")
	public NewPageResult<MaterialClassify> getClassifyListTree(
			@RequestParam(required = false)@ApiParam(name = "classifyName", value = "分类名称", required = false) String classifyName,
			@RequestParam(required = false)@ApiParam(name = "classifyDescribe", value = "分类描述", required = false) String classifyDescribe,
			@RequestParam(required = false)@ApiParam(name = "superiorClassifyId", value = "父级Id", required = false) String superiorClassifyId,
			@RequestParam(required = false)@ApiParam(name = "isTop", value = "父级Id", required = false) String isTop) throws Exception {
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.setIsPage(0);
		example.setOrderByClause("a.classify_name asc");
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());	
	    criteria.andStatusEqualTo("01");
		if (!StringUtils.isBlank(classifyName)) {
			criteria.andClassifyNameLike(classifyName);
		}
		if (!StringUtils.isBlank(classifyDescribe)) {
			criteria.andClassifyDescribeLike(classifyDescribe);
		}
		if (!StringUtils.isBlank(superiorClassifyId)) {
			criteria.andSuperiorClassifyIdEqualTo(superiorClassifyId);
		}
		criteria.andIsDeleteEqualTo("01");
		logger.info("====查询物资分类列表MaterialClassifyController.getClassifyList===classifyName:"+classifyName+"===classifyDescribe:"+classifyDescribe);
		return materialClassifyService.getClassifyListAll(example);
	}
	
	
}
