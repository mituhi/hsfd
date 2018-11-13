package com.qz.zframe.run.entity.result;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: DeviceAssociationResult</p>
 * <p>@Description: 电厂主设备配置返回结果封装类 </p>
 * @author 陈汇奇
 * @date 2018年11月9日 下午3:06:14
 * @version:V1.0
 */
public class DeviceAssociationResult {

	@ApiModelProperty(value = "设备关联表id", name = "deviceAssociationId",required=true)
	private String deviceAssociationId;

	@ApiModelProperty(value = "主设备表id", name = "mainEquipmentId",required=true)
	private String mainEquipmentId;

	@ApiModelProperty(value = "主设备信息表id", name = "mainEquipmentInfoId")
	private String mainEquipmentInfoId;

	@ApiModelProperty(value = "风电场", name = "department",required=true)
	private String department;

	@ApiModelProperty(value = "日志类型", name = "logType",required=true)
	private String logType;

	@ApiModelProperty(value = "日志名称", name = "logName",required=true)
	private String logName;

	
	@ApiModelProperty(value = "设备数量", name = "count",required=true)
	private Integer count;
	
	public String getDeviceAssociationId() {
		return deviceAssociationId;
	}

	public void setDeviceAssociationId(String deviceAssociationId) {
		this.deviceAssociationId = deviceAssociationId;
	}

	public String getMainEquipmentId() {
		return mainEquipmentId;
	}

	public void setMainEquipmentId(String mainEquipmentId) {
		this.mainEquipmentId = mainEquipmentId;
	}

	public String getMainEquipmentInfoId() {
		return mainEquipmentInfoId;
	}

	public void setMainEquipmentInfoId(String mainEquipmentInfoId) {
		this.mainEquipmentInfoId = mainEquipmentInfoId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
