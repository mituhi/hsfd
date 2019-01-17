package com.qz.zframe.run.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.run.entity.DeviceAssociationExample;
import com.qz.zframe.run.entity.MainEquipmentInfo;
import com.qz.zframe.run.entity.MainEquipmentInfoExample;

/**
 * <p>Title: MainEquipmentInfoService</p>
 * <p>@Description: 主设备信息接口声明 </p>
 * @author 
 * @date 2018年11月9日 上午11:44:14
 * @version:V1.0
 */
public interface MainEquipmentInfoService {

	
	/**
	 * @Description:保存主设备信息
	 * @param: @param equipmentInfo
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveMainEquipmentInfo(MainEquipmentInfo equipmentInfo);
	
	
	/**
	 * @Description:通过id获取
	 * @param: @param MainEquipmentInfoId
	 * @param: @return   
	 * @return: MainEquipmentInfo
	 */
	MainEquipmentInfo getMainEquipmentInfoById(String mainEquipmentInfoId);
	
	
	/**
	 * @Description:更新
	 * @param: @param mainEquipmentInfo
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateMainEquipmentInfo(MainEquipmentInfo mainEquipmentInfo);
	
	/*PageResultEntity  selectByWindId(EquipmentAssetLedgerExample assetLedgerExample);*/
	void deleteByExample(MainEquipmentInfoExample example);
}
