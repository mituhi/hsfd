package com.qz.zframe.run.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceAssociation;
import com.qz.zframe.run.entity.MainEquipment;
import com.qz.zframe.run.entity.result.DeviceAssociationResult;

/**
 * <p>Title: DeviceAssociationService</p>
 * <p>@Description: 设备关联表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月9日 下午1:07:36
 * @version:V1.0
 */
public interface DeviceAssociationService {

	/**
	 * @Description:保存
	 * @param: @param deviceAssociation
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDeviceAssociation(DeviceAssociation deviceAssociation);
	
	
	/**
	 * @Description:根据id删除信息
	 * @param: @param deviceAssociationId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity deleteDeviceAssociationById(String deviceAssociationId);
	
	
	/**
	 * @Description:批量查询
	 * @param: @param mainEquipment
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	PageResultEntity listDeviceAssociation(MainEquipment mainEquipment , int pageNo,int pageSize);
	
	
	/**
	 * @Description:通过设备关联表id，获取DeviceAssociationResult对象
	 * @param: @param deviceAssociationId
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity getDeviceAssociationResultById(String deviceAssociationId);
	
	
	/**
	 * @Description:更新
	 * @param: @param deviceAssociationResult
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity editDeviceAssociation(DeviceAssociationResult deviceAssociationResult);

	
}


