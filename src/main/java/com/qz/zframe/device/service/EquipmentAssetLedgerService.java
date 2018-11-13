package com.qz.zframe.device.service;

import java.util.List;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;

public interface EquipmentAssetLedgerService {
	   //查询设备资产台账信息
		 public	PageResultEntity findAssetLedger(EquipmentAssetLedgerExample assetLedgerExample);
	    //新增位设备资产台账信息
		 public ResultEntity  addAssetLedger(EquipmentAssetLedger assetLedger);
		//修改设备资产台账信息
		 public ResultEntity  updateAssetLedger(EquipmentAssetLedger assetLedger);
		 //查询设备资产台账信息详情
		 public  PageResultEntity  findByEquipmentAssetId(String equipmentAssetId);
		 //批量设备资产台账信息
		 public   ResultEntity  deleteAssetLedger(List<String> equipmentAssetIds);
		 //设备资产台账信息变动查询
		 public	PageResultEntity  findChange(EquipmentAssetLedgerExample assetLedgerExample);
		 public  PageResultEntity  findById(String equipmentAssetId);
}
