package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class DeviceAssociation {
	
	@ApiModelProperty(value="设备关联表id",name="deviceAssociationId")
    private String deviceAssociationId;

	@ApiModelProperty(value="主设备表id",name="mainEquipmentId")
    private String mainEquipmentId;

	@ApiModelProperty(value="主设备信息表id",name="mainEquipmentInfoId")
    private String mainEquipmentInfoId;

	@ApiModelProperty(value="设备类型状态表id",name="deviceTypeId")
    private String deviceTypeId;

    public String getDeviceAssociationId() {
        return deviceAssociationId;
    }

    public void setDeviceAssociationId(String deviceAssociationId) {
        this.deviceAssociationId = deviceAssociationId == null ? null : deviceAssociationId.trim();
    }

    public String getMainEquipmentId() {
        return mainEquipmentId;
    }

    public void setMainEquipmentId(String mainEquipmentId) {
        this.mainEquipmentId = mainEquipmentId == null ? null : mainEquipmentId.trim();
    }

    public String getMainEquipmentInfoId() {
        return mainEquipmentInfoId;
    }

    public void setMainEquipmentInfoId(String mainEquipmentInfoId) {
        this.mainEquipmentInfoId = mainEquipmentInfoId == null ? null : mainEquipmentInfoId.trim();
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }
}