package com.qz.zframe.material.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.StoreHouseTypeMapper;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseTypeExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StoreHouseTypeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class StoreHouseTypeServiceImpl implements StoreHouseTypeService {

	@Autowired
	private StoreHouseTypeMapper storeHoseTypeMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@Autowired
	private DataDictService dataDictService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getStoreHouseTypeList(StoreHouseTypeExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
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

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getStoreHouseTypeDetail(String typeId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
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
		if (StringUtils.isBlank(storeHouseType.getTypeName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型名称不可为空");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(storeHouseType.getTypeCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型编码不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(storeHouseType.getIsNegative())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出入库类别不可为空");
			return resultEntity;
		}
		
		if (!StringUtils.isBlank(storeHouseType.getTypeCode())) {
			 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		     Matcher m = p.matcher(storeHouseType.getTypeCode());
			 if (m.find()) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("出入库类型不可包含中文");
				return resultEntity;
			}
		}
		
		
		if (checkTypeIsExitByStoreName(storeHouseType)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型名称重复");
			return resultEntity;
		}
		if (checkTypeIsExitByStoreCode(storeHouseType)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型编码重复");
			return resultEntity;
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		storeHouseType.setCreater(userInfo.getUserId());
		storeHouseType.setTypeId(UUIdUtil.getUUID());
		storeHouseType.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		storeHouseType.setCreateTime(new Date());
		storeHoseTypeMapper.insertSelective(storeHouseType);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 添加库存类型时判断类型编码是否存在
	 */
	private boolean checkTypeIsExitByStoreCode(StoreHouseType s) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		if(!StringUtils.isBlank(s.getTypeId())){	
			example.createCriteria().andTypeCodeEqualTo(s.getTypeCode()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andTypeIdNotEqualTo(s.getTypeId());
		}else{
			example.createCriteria().andTypeCodeEqualTo(s.getTypeCode()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		}
		
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
	private boolean checkTypeIsExitByStoreName(StoreHouseType s) {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		if(!StringUtils.isBlank(s.getTypeId())){	
			example.createCriteria().andTypeNameEqualTo(s.getTypeName()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andTypeIdNotEqualTo(s.getTypeId());
		}else{
			example.createCriteria().andTypeNameEqualTo(s.getTypeName()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		}
		
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
		if (StringUtils.isBlank(storeHouseType.getTypeName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型名称不能为空");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(storeHouseType.getTypeCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出库类型编码不能为空");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(storeHouseType.getIsNegative())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("出入库类别不可为空");
			return resultEntity;
		}	
		
		if (!StringUtils.isBlank(storeHouseType.getTypeCode())) {
			 Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		     Matcher m = p.matcher(storeHouseType.getTypeCode());
			 if (m.find()) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("出入库类型不可包含中文");
				return resultEntity;
			}
		}
		
		StoreHouseType storeHouseInfo = storeHoseTypeMapper.selectByPrimaryKey(storeHouseType.getTypeId());
		if(storeHouseInfo!=null){
			if(!storeHouseInfo.getTypeName().equals(storeHouseType.getTypeName())){
				if (checkTypeIsExitByStoreName(storeHouseType)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("出库类型名称重复");
					return resultEntity;
				}
			}
			if(!storeHouseInfo.getTypeCode().equals(storeHouseType.getTypeCode())){
				if (checkTypeIsExitByStoreCode(storeHouseType)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("出库类型编码重复");
					return resultEntity;
				}
			}
		}
		if(StringUtils.isBlank(storeHouseType.getSuperTypeId())){
			storeHouseType.setSuperTypeId("");
		}else{
			if(!storeHouseType.getIsNegative().equals("01")){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("冲销类型出库类别必须为出库");
				return resultEntity;
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
		for(String typeId:typeIds){
			StoreHouseTypeExample example = new StoreHouseTypeExample();
			example.createCriteria().andSuperTypeIdEqualTo(typeId).andIsDeleteEqualTo("01");
			int count =storeHoseTypeMapper.countByExample(example);
			if(count>0){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("请先删除所关联的冲销类型");
				return resultEntity;
			}
		}
	    Map<String, Object> params = new HashMap<>(2);
	    params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
	    params.put("typeIds", typeIds);
	    storeHoseTypeMapper.updateIsdete(params);
	    resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
