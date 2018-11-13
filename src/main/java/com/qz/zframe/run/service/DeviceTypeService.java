package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;

/**
 * <p>Title: DeviceTypeService</p>
 * <p>@Description: 设备类型状态表接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月6日 下午4:28:25
 * @version:V1.0
 */
public interface DeviceTypeService {

	
	/**
	 * @Description:保存设备状态信息
	 * @param: @param deviceType
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveDeviceType(DeviceType deviceType);
	
	
	
	/**
	 * @Description:获取最大的sort值
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity getMaxSort();
	
	
	/**
	 * @Description:根据主键删除信息
	 * @param: @param typeId   
	 * @return: void
	 */
	void removeDeviceTypeById(String typeId);
	
	
	/**
	 * @Description:批量获取信息
	 * @param: @param example
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: List<DeviceType>
	 */
	List<DeviceType> listDeviceType(DeviceTypeExample example,int pageNo , int pageSize);
	
	
	/**
	 * @Description:根据主键进行修改操作
	 * @param: @param deviceType   
	 * @return: void
	 */
	void editDeviceTypeById(DeviceType deviceType);
	
	
	
}
