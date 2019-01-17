package com.qz.zframe.material.controller;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.entity.MaterialExample.Criteria;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
@Api(tags = "api-material-material", description = "物资管理")
public class MaterialController {

	@Autowired
	private MaterialService materialService;


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
	@RequestMapping(value = "/listMaterial", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资列表", notes = "materialCode物资编码，materialDescribe物资描述，windId风电场id")
	public NewPageResult<Material> getMaterialList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required=false, defaultValue = "1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "materialCode", value = "物资编码", required = false) String materialCode,
			@RequestParam(required = false) @ApiParam(name = "materialDescribe", value = "物资描述", required = false) String materialDescribe,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "风电场开始编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "风电场结束编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "architectureId", value = "风电场Id", required = false) String architectureId	,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场Id", required = false) String windId,	
			@RequestParam(required = false) @ApiParam(name = "materialName", value = "物资名称模糊查询", required = false) String materialName,
			@RequestParam(required = false) @ApiParam(name = "status", value = "物资状态，01启用，02停用", required = false) String status	
			) {
		MaterialExample materialExample = new MaterialExample();
		materialExample.setPageSize(pageSize);
		materialExample.setPageNo(pageNum);
		materialExample.setIsPage(isPage);
		materialExample.setOrderByClause("a.create_time desc");
		Criteria criteria = materialExample.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(materialDescribe)) {
			criteria.andMaterialDescribeLike(materialDescribe);
		}
		if (!StringUtils.isBlank(materialCode)) {
			criteria.andMaterialCodeEqualTo(materialCode);
		}	
		if(!StringUtils.isBlank(startArchiteCode)){
			if(!StringUtils.isBlank(endArchiteCode)){
				criteria.andArchitectuerBetween(startArchiteCode, endArchiteCode);
			}else{
				criteria.andArchitectuerEqualTo(startArchiteCode);
			}
		}
		if(!StringUtils.isBlank(architectureId)){
			criteria.andWindIdEqualTo(architectureId);
		}
		if(!StringUtils.isBlank(windId)){
			criteria.andWindIdEqualTo(windId);
		}
		if(!StringUtils.isBlank(materialName)){
			criteria.andMaterialNameLike(materialName);
		}
		if(!StringUtils.isBlank(status)){
			criteria.andStatusEqualTo(status);
		}
		criteria.andIsDeleteEqualTo("01");
		return materialService.getMaterialList(materialExample);
	}
	
	@RequestMapping(value = "/listMaterialAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取物资全部列表", notes = "")
	public NewPageResult<Material> getMaterialListAll(
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required=false, defaultValue = "1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "materialCode", value = "物资编码", required = false) String materialCode,
			@RequestParam(required = false) @ApiParam(name = "materialDescribe", value = "物资描述", required = false) String materialDescribe,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "风电场开始编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "风电场结束编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "architectureId", value = "风电场Id", required = false) String architectureId	,
			@RequestParam(required = false) @ApiParam(name = "windId", value = "风电场Id", required = false) String windId,	
			@RequestParam(required = false) @ApiParam(name = "materialName", value = "物资名称模糊查询", required = false) String materialName,
			@RequestParam(required = false) @ApiParam(name = "status", value = "物资状态，01启用，02停用", required = false) String status,	
			@RequestParam(required = false) @ApiParam(name = "supplierId", value = "供应商id", required = false) String supplierId	
			) {
		MaterialExample materialExample = new MaterialExample();
		materialExample.setPageSize(pageSize);
		materialExample.setPageNo(pageNum);
		materialExample.setIsPage(isPage);//
		materialExample.setOrderByClause("a.create_time desc");
		Criteria criteria = materialExample.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		if (!StringUtils.isBlank(materialDescribe)) {
			criteria.andMaterialDescribeLike(materialDescribe);
		}
		if (!StringUtils.isBlank(materialCode)) {
			criteria.andMaterialCodeEqualTo(materialCode);
		}	
		if(!StringUtils.isBlank(startArchiteCode)){
			if(!StringUtils.isBlank(endArchiteCode)){
				criteria.andArchitectuerBetween(startArchiteCode, endArchiteCode);
			}else{
				criteria.andArchitectuerEqualTo(startArchiteCode);
			}
		}
		if(!StringUtils.isBlank(architectureId)){
			criteria.andWindIdEqualTo(architectureId);
		}
		if(!StringUtils.isBlank(windId)){
			criteria.andWindIdEqualTo(windId);
		}
		if(!StringUtils.isBlank(materialName)){
			criteria.andMaterialNameLike(materialName);
		}
		if(!StringUtils.isBlank(supplierId)){
			criteria.andSupplierIdEqualTo(supplierId);
		}
		criteria.andStatusEqualTo("01");
		criteria.andIsDeleteEqualTo("01");
		return materialService.getMaterialList(materialExample);
	}

	/**
	 * 新增物资
	 * 
	 * @param material
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/saveMaterial", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增物资", notes = "新增物资信息")
	public ResultEntity saveUser(@RequestBody Material material) throws Exception {		
		return materialService.saveMaterial(material);
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
		return materialService.updateMaterial(material);
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
	@ResponseBody
	public ResultEntity detailMaterial(@RequestParam String materialId){
		return materialService.detailMaterial(materialId);
	}
	
}
