package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.dao.StoreHouseTypeMapper;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseTypeExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StoreHouseTypeService;

@Service
public class StoreHouseTypeServiceImpl implements StoreHouseTypeService {

	@Autowired
	private StoreHouseTypeMapper storeHoseTypeMapper;

	@Override
	public PageResultEntity getStoreHouseTypeList(StoreHouseTypeExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = storeHoseTypeMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<StoreHouseType> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = storeHoseTypeMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Override
	public ResultEntity getStoreHouseTypeDetail(String typeId) {
		ResultEntity resultEntity = new ResultEntity();
		StoreHouseType storeHouseType = storeHoseTypeMapper.selectByPrimaryKey(typeId);
		if (storeHouseType == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存类型不存在");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(storeHouseType);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public ResultEntity addStoreHouseType(StoreHouseType storeHouseType) {
		ResultEntity resultEntity = new ResultEntity();
		if (checkTypeIsExitByStoreName(storeHouseType.getTypeName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型名称重复");
			return resultEntity;
		}
		if (checkTypeIsExitByStoreCode(storeHouseType.getTypeCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型编码重复");
			return resultEntity;
		}
		storeHoseTypeMapper.insertSelective(storeHouseType);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 添加库存类型时判断类型编码是否存在
	 */
	private boolean checkTypeIsExitByStoreCode(String typeCode) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.createCriteria().andTypeCodeEqualTo(typeCode).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		int count = storeHoseTypeMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 添加出库类型时，判断类型名称是否已存在
	 */
	private boolean checkTypeIsExitByStoreName(String typeName) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.createCriteria().andTypeNameEqualTo(typeName).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		int count = storeHoseTypeMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultEntity editStoreHouseType(StoreHouseType storeHouseType) {
		ResultEntity resultEntity = new ResultEntity();
		StoreHouseType storeHouseInfo = storeHoseTypeMapper.selectByPrimaryKey(storeHouseType.getTypeId());
		if(storeHouseInfo!=null){
			if(!storeHouseInfo.getTypeName().equals(storeHouseType.getTypeName())){
				if (checkTypeIsExitByStoreName(storeHouseType.getTypeName())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("出库类型名称重复");
					return resultEntity;
				}
			}
			if(!storeHouseInfo.getTypeCode().equals(storeHouseType.getTypeCode())){
				if (checkTypeIsExitByStoreCode(storeHouseType.getTypeName())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("出库类型编码重复");
					return resultEntity;
				}
			}
		}	
		storeHoseTypeMapper.updateByPrimaryKeySelective(storeHouseType);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public ResultEntity delStoreHouseType(List<String> typeIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(typeIds.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存id集合为空");
			return resultEntity;
		}
	    Map<String, Object> params = new HashMap<>(2);
	    params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
	    params.put("typeIds", typeIds);
	    storeHoseTypeMapper.updateIsdete(params);
	    resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
