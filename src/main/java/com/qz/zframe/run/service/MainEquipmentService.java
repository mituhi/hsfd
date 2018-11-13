package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.MainEquipmentExample;

/**
 * <p>Title: MainEquipmentService</p>
 * <p>@Description: 电厂主设备接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月9日 上午11:17:33
 * @version:V1.0
 */
public interface MainEquipmentService {

	/**
	 * @Description:保存
	 * @param: @param mainEquipment
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveMainEquipment(MainEquipment mainEquipment);
	
	
	/**
	 * @Description:获取
	 * @param: @param equipmentExample
	 * @param: @return   
	 * @return: List<MainEquipment>
	 */
	List<MainEquipment> listMainEquipments(MainEquipmentExample equipmentExample);
	
	
	
}
