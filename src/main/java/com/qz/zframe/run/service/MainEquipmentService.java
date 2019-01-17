package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;

/**
 * <p>Title: MainEquipmentService</p>
 * <p>@Description: 电厂主设备接口声明 </p>
 * @author 
 * @date 2018年11月9日 上午11:17:33
 * @version:V1.0
 */
public interface MainEquipmentService {

	/**
	 * @Description:保存主设备
	 * @param: @param mainEquipment
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveMainEquipment(MainEquipment mainEquipment);
	
	
	/**
	 * @Description:获取主设备列表
	 * @param: @param equipmentExample
	 * @param: @return   
	 * @return: List<MainEquipment>
	 */
	PageResultEntity listMainEquipments(MainEquipmentExample equipmentExample);
	
	
	/**
	 * @Description:通过id获取信息
	 * @param: @param MainEquipmentId
	 * @param: @return   
	 * @return: MainEquipment
	 */
	PageResultEntity getMainEquipmentById(String mainEquipmentId);
	
	
	
	/**
	 * @Description:更新主设备
	 * @param: @param mainEquipment
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity updateMainEquipment(MainEquipment mainEquipment);
	/**
	 * @Description:删除主设备
	 * @param: @param mainEquipmentIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity  delete (List<String> mainEquipmentIds);
}
