package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.SupplierMapper;
import com.qz.zframe.material.entity.Supplier;
import com.qz.zframe.material.entity.SupplierExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.SupplierService;

@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Autowired
	private CurrentUserService currentUSerservice;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getSupplierList(SupplierExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = supplierMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<Supplier> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = supplierMapper.selectByExample(example);
		}
		pageResultEntity.setCode(0);
		pageResultEntity.setRows(list);

		return pageResultEntity;
	}

	@Override
	public ResultEntity addSupplier(Supplier supplier) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(supplier.getSupplierName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商名称不可为空");
			return resultEntity;
		}else{
			if (checkSupplierNameIsExit(supplier)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("供应商名称已存在!");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(supplier.getSupplierCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商编码不可为空");
			return resultEntity;
		}else{
			if (checkSupplierCodeIsExit(supplier)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("供应商编码已存在!");
				return resultEntity;
			}
		}
		
		if (StringUtils.isBlank(supplier.getSupplierStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("状态不可为空");
			return resultEntity;
		}
		
		UserInfo userInfo = currentUSerservice.getUserInfo();
		supplier.setSupplierId(UUIdUtil.getUUID());
		supplier.setCreater(userInfo.getUserId());
		supplier.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		supplierMapper.insertSelective(supplier);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 判断供应商名称或者编码是否存在
	 * 
	 * @param @param
	 *            supplier @param @return 参数 @return boolean 返回类型 @throws
	 */
	private boolean checkSupplierNameIsExit(Supplier supplier) {
		SupplierExample example = new SupplierExample();
		if (!StringUtils.isBlank(supplier.getSupplierId())) {
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andSupplierIdNotEqualTo(supplier.getSupplierId()).andSupplierNameEqualTo(supplier.getSupplierName());
		} else {
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andSupplierNameEqualTo(supplier.getSupplierName());
		}
		int count = supplierMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getSupplierDetail(String supplierId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
		Supplier supplier = supplierMapper.selectByPrimaryKey(supplierId);
		if (supplier == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商不存在");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(supplier);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity editSupplier(Supplier supplier) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(supplier.getSupplierName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商名称不可为空");
			return resultEntity;
		}else{
			if (checkSupplierNameIsExit(supplier)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("供应商名称已存在!");
				return resultEntity;
			}
		}
		
		if (StringUtils.isBlank(supplier.getSupplierCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商编码不可为空");
			return resultEntity;
		}else{
			if (checkSupplierCodeIsExit(supplier)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("供应商编码已经存在");
				return resultEntity;

			}
			
		}
		
		
		if (StringUtils.isBlank(supplier.getSupplierStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("状态不可为空");
			return resultEntity;
		}

		
		supplierMapper.updateByPrimaryKeySelective(supplier);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	private boolean checkSupplierCodeIsExit(Supplier supplier) {
		SupplierExample example = new SupplierExample();
		if (!StringUtils.isBlank(supplier.getSupplierId())) {
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andSupplierIdNotEqualTo(supplier.getSupplierId()).andSupplierNameEqualTo(supplier.getSupplierName());
		} else {
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andSupplierCodeEqualTo(supplier.getSupplierCode());
		}
		int count = supplierMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultEntity delSupplier(List<String> supplierIds) {
		ResultEntity resultEntity = new ResultEntity();
		Map<String, Object> params = new HashMap<>(2);
		params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
		params.put("supplierIds", supplierIds);
		supplierMapper.updateIsdete(params);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
