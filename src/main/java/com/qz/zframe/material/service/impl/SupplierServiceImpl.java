package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.dao.SupplierMapper;
import com.qz.zframe.material.entity.Supplier;
import com.qz.zframe.material.entity.SupplierExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public PageResultEntity getSupplierList(SupplierExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
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
		if (checkSupplierNameOrCodeIsExit(supplier)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("供应商名称或编码已存在!");
			return resultEntity;
		}
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
	private boolean checkSupplierNameOrCodeIsExit(Supplier supplier) {
		SupplierExample example = new SupplierExample();
		example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode())
				.andSupplierNameEqualTo(supplier.getSupplierName());
		example.or().andSupplierCodeEqualTo(supplier.getSupplierCode());
		int count = supplierMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultEntity getSupplierDetail(String supplierId) {
		ResultEntity resultEntity = new ResultEntity();
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
		Supplier supplierInfo = supplierMapper.selectByPrimaryKey(supplier.getSupplierId());
		if (supplierInfo != null) {
			if (!supplierInfo.getSupplierName().equals(supplier.getSupplierName())
					|| !supplierInfo.getSupplierCode().equals(supplier.getSupplierCode())) {
				if (checkSupplierNameOrCodeIsExit(supplier)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("供应商名称或编码已经存在");
					return resultEntity;
				}
			}
		}
		supplierMapper.updateByPrimaryKeySelective(supplier);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
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
