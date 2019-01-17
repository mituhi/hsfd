package com.qz.zframe.material.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.w3c.dom.ls.LSInput;

import com.github.pagehelper.Page;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.dao.MaterialMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialServiceImpl implements MaterialService {

	private static Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

	@Autowired
	private MaterialMapper materialMapperMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private InventoryMapper inventoryMapper;

	@Override
	public List<Material> listMaterial(MaterialExample materialExample) {

		return materialMapperMapper.selectByExample(materialExample);
	}

	@Override
	public ResultEntity saveMaterial(Material material) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(material.getMaterialName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资名称不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getSpecifications())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("型号规格不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getMaterialGroupId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getMaterialClassifyId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资状态不可为空");
			return resultEntity;
		}	
		if(StringUtils.isBlank(material.getMeasuringUnit())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位不可为空");
			return resultEntity;
		}
		
		UserInfo userInfo = currentUSerservice.getUserInfo();
		material.setCreater(userInfo.getUserId());
		material.setMaterialId(UUIdUtil.getUUID());
		material.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		String materialCode=commonService.customOrder("01", materialMapperMapper.selectMaxMaterialCode());
		material.setMaterialCode(materialCode);	
		int count = materialMapperMapper.insertSelective(material);
		if (count == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}




	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getMaterialList(MaterialExample materialExample) {
		NewPageResult resultEntity = new NewPageResult();
		int count = materialMapperMapper.countByExample(materialExample);
		resultEntity.setTotal(count);
		List<Material> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialMapperMapper.selectByExample(materialExample);
			for(Material material:list){
				material.setNameAndDescribe(material.getMaterialClassifyName()+" "+material.getMaterialClassifyDescribe());
				InventoryExample inventoryExample = new InventoryExample();
				inventoryExample.createCriteria().andMaterialIdEqualTo(material.getMaterialId()).andWindIdEqualTo(material.getArchitectureCode()).andStatusEqualTo("01");
			
				Inventory inventory=  inventoryMapper.selectAveragePriceExample(inventoryExample);
				if(inventory!=null){
					material.setAveragePrice(inventory.getAveragePrice());//移动平均价
					material.setCurrentStock(inventory.getTotalNum());//总库存
				}else{
					material.setAveragePrice(BigDecimal.ZERO);//移动平均价
					material.setCurrentStock(0);//总库存
				}
			}
		}
		resultEntity.setCode(0);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity updateMaterial(Material material) {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(material.getMaterialName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资名称不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getSpecifications())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("型号规格不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getMaterialGroupId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getMaterialClassifyId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不可为空");
			return resultEntity;
		}
		if(StringUtils.isBlank(material.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资状态不可为空");
			return resultEntity;
		}	
		if(StringUtils.isBlank(material.getMeasuringUnit())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位不可为空");
			return resultEntity;
		}
		int count = materialMapperMapper.updateByPrimaryKeySelective(material);
		if (count == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("编辑失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("编辑成功");
		}
		return resultEntity;
	}

//	@Transactional(rollbackFor = Exception.class)
//	@Override
//	public ResultEntity delMaterial(List<String> materialIds) {
//		ResultEntity resultEntity = new ResultEntity();
//		try {
//			// materialMapperMapper.delMaterial(materialIds);
//			resultEntity.setCode(0);
//			resultEntity.setMsg("删除成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			resultEntity.setCode(-1);
//			resultEntity.setMsg("操作异常");
//		}
//		return resultEntity;
//	}
	
	@Override
	public ResultEntity delMaterial(List<String> materialIds) {
		ResultEntity resultEntity = new ResultEntity();
		Map<String, Object> params = new HashMap<>(2);
		params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
		params.put("materialIds", materialIds);
		materialMapperMapper.updateIsdete(params);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntity detailMaterial(String materialId) {
		ResultEntity resultEntity = new ResultEntity();
		Material material = materialMapperMapper.selectByPrimaryKey(materialId);
		if (material == null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("物资Id不存在");
			logger.debug("错误的materialId{}" + materialId);
		} else {
			//根据物资Id和风电场编码获取库存
			InventoryExample inventoryExample = new InventoryExample();
			inventoryExample.createCriteria().andMaterialIdEqualTo(materialId).andWindIdEqualTo(material.getArchitectureCode()).andStatusEqualTo("01");
			Inventory inventory=  inventoryMapper.selectAveragePriceExample(inventoryExample);
			if(inventory!=null){
				material.setAveragePrice(inventory.getAveragePrice());//移动平均价
				material.setCurrentStock(inventory.getTotalNum());//总库存
			}else{
				material.setAveragePrice(BigDecimal.ZERO);//移动平均价
				material.setCurrentStock(0);//总库存
			}
			material.setNameAndDescribe(material.getMaterialClassifyName()+" "+material.getMaterialClassifyDescribe());
			resultEntity.setCode(0);
			resultEntity.setData(material);
		}
		return resultEntity;
	}

	@Override
	public String getMaxMaterialCode() {
		return materialMapperMapper.selectMaxMaterialCode();
	}

}
