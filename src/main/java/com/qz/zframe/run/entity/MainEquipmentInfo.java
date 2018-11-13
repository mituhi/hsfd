package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class MainEquipmentInfo {
	
	@ApiModelProperty(value="主设备信息id",name="mainEquipmentInfoId")
    private String mainEquipmentInfoId;

	@ApiModelProperty(value="设备编码",name="deviceCode",required=true)
    private String deviceCode;

	@ApiModelProperty(value="设备类型",name="deviceType",required=true)
    private String deviceType;

	@ApiModelProperty(value="设备名称",name="deviceName",required=true)
    private String deviceName;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

    public String getMainEquipmentInfoId() {
        return mainEquipmentInfoId;
    }

    public void setMainEquipmentInfoId(String mainEquipmentInfoId) {
        this.mainEquipmentInfoId = mainEquipmentInfoId == null ? null : mainEquipmentInfoId.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}