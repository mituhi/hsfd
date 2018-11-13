package com.qz.zframe.run.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.MainEquipmentInfo;

/**
 * <p>Title: MainEquipmentInfoService</p>
 * <p>@Description: 主设备信息接口声明 </p>
 * @author 陈汇奇
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
	
}
