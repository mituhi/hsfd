package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.EquipmentAssetLedgerMapper;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.device.service.EquipmentAssetLedgerService;
@Service
@Transactional(rollbackFor = Exception.class)
public class EquipmentAssetLedgerServiceImpl implements EquipmentAssetLedgerService {
	@Autowired
	private   EquipmentAssetLedgerMapper assetLedgerMapper;
	@Override
	public PageResultEntity findAssetLedger(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.countByExample(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = assetLedgerMapper.selectByExample(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);     
		return resultEntity;
	}

	@Override
	public ResultEntity addAssetLedger(EquipmentAssetLedger assetLedger) {
		ResultEntity resultEntity = new ResultEntity();
		assetLedger.setEquipmentAssetId(UUIdUtil.getUUID());
		int save = assetLedgerMapper.insert(assetLedger);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateAssetLedger(EquipmentAssetLedger assetLedger) {
		ResultEntity resultEntity = new ResultEntity();
		EquipmentAssetLedger ledger = assetLedgerMapper.selectByPrimaryKey(assetLedger.getEquipmentAssetId());
		if (ledger == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = assetLedgerMapper.updateByPrimaryKey(assetLedger);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByEquipmentAssetId(String equipmentAssetId) {
		PageResultEntity resultEntity=new PageResultEntity();
		List<EquipmentAssetLedger> list=new ArrayList<EquipmentAssetLedger>();
		EquipmentAssetLedger equipmentAssetLedger = assetLedgerMapper.selectByPrimaryKey(equipmentAssetId);
		if (equipmentAssetLedger == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(equipmentAssetLedger);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list); 
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteAssetLedger(List<String> EquipmentAssetIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete=assetLedgerMapper.deleteByPrimaryKeyList(EquipmentAssetIds);
		if(delete<0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		}else{
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
	return resultEntity;
	}

	@Override
	public PageResultEntity findChange(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.countByExamples(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = assetLedgerMapper.selectByExamples(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);     
		return resultEntity;
	}

	@Override
	public PageResultEntity findById(String equipmentAssetId) {
		PageResultEntity resultEntity=new PageResultEntity();
		List<EquipmentAssetLedger> list=new ArrayList<EquipmentAssetLedger>();
		EquipmentAssetLedger equipmentAssetLedger = assetLedgerMapper.selectByPrimaryKeys(equipmentAssetId);
		if (equipmentAssetLedger == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(equipmentAssetLedger);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list); 
		}
		return resultEntity;
	}

}
