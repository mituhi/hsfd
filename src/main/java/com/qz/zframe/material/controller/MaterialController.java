package com.qz.zframe.material.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.Material.ListView;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.entity.MaterialExample.Criteria;
import com.qz.zframe.material.entity.WindField;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 物资管理
 * 
 * @ClassName: MaterialController
 * @author syc
 * @date 2018年10月31日上午9:37:27
 *
 */
@RestController
@RequestMapping("/api/support/material")
@Api(tags = "api-support-material", description = "物资管理")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@Autowired
	private CurrentUserService currentUSerservice;

	/**
	 * 获取物资信息列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param materialType
	 * @param materialCode
	 * @param materialDescribe
	 * @return
	 */
	@JsonView({ ListView.class })
	@RequestMapping(value = "/listMaterial", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资列表", notes = "materialCode物资编码，materialDescribe物资描述，windId风电场id")
	public PageResultEntity getMaterialList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String windId,
			@RequestParam(required = false) String materialCode,
			@RequestParam(required = false) String materialDescribe,
			@RequestParam(required = false) String searchKey) {
		PageResultEntity resultEntity = new PageResultEntity();
		MaterialExample materialExample = new MaterialExample();
		materialExample.setPageSize(pageSize);
		materialExample.setPageNo(pageNum);
		materialExample.setOrderByClause("a.create_time desc");
		Criteria criteria = materialExample.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(materialDescribe)) {
			criteria.andMaterialDescribeEqualTo(materialDescribe);
		}
		if (!StringUtils.isBlank(materialCode)) {
			criteria.andMaterialCodeEqualTo(materialCode);
		}
		if (!StringUtils.isBlank(windId)) {
			criteria.andWindIdEqualTo(windId);
		}
		if (!StringUtils.isBlank(searchKey)) {
			criteria.andMaterialCodeLike(searchKey);
			materialExample.or().andMaterialNameLike(searchKey);
			materialExample.or().andMaterialDescribeLike(searchKey);
			materialExample.or().andSpecificationsLike(searchKey);
		}
		resultEntity = materialService.getMaterialList(materialExample);
		return resultEntity;
	}

	/**
	 * 新增物资
	 * 
	 * @param material
	 * @return
	 */
	@RequestMapping(value = "/saveMaterial", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增物资", notes = "新增物资信息")
	public ResultEntity saveUser(@RequestBody Material material) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(material.getMaterialCode()) || StringUtils.isBlank(material.getMaterialClassifyId())
				|| StringUtils.isBlank(material.getMaterialName())
				|| StringUtils.isBlank(material.getMaterialGroupId())
				|| StringUtils.isBlank(material.getStatus())
				|| StringUtils.isBlank(material.getSpecifications())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少参数");
			return resultEntity;
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		material.setCreater(userInfo.getUserId());
		material.setMaterialId(UUIdUtil.getUUID());
		material.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		resultEntity = materialService.saveMaterial(material);
		return resultEntity;
	}

	/**
	 * 编辑物资信息
	 * 
	 * @param @param material @param @return 参数 @return ResultEntity
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/updateMaterial", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑物资信息", notes = "materialId物资id必传")
	public ResultEntity updateMaterial(@RequestBody Material material) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(material.getMaterialId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少参数");
			return resultEntity;
		}
		resultEntity = materialService.updateMaterial(material);
		return resultEntity;
	}

	/**
	 * 批量删除物资信息
	 * 
	 * @param @param materialIds @param @return 参数 @return ResultEntity
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/delMaterial", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除物资信息", notes = "批量删除，传入List<string>集合")
	public ResultEntity delMaterial(@RequestBody List<String> materialIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isNotEmpty(materialIds)) {
			resultEntity = materialService.delMaterial(materialIds);
		}
		return resultEntity;
	}


	/**
	 * 获取物资详情信息
	 * 
	 * @param @param materialId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/detailMaterial", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "查看物资详情", notes = "materialId物资id为必传")
	public ResultEntity detailMaterial(@RequestParam String materialId){
		return materialService.detailMaterial(materialId);
	}
	
}
