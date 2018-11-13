package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DeviceType {
	
	@ApiModelProperty(value="设备类型状态表id",name="typeId")
    private String typeId;

	@ApiModelProperty(value="设备类型",name="deviceType")
    private String deviceType;

	@ApiModelProperty(value="设备状态",name="deviceStatus")
    private String deviceStatus;

	@ApiModelProperty(value="排序",name="sort")
    private Integer sort;

	@ApiModelProperty(value="更新时间",name="updateTime")
    private Date updateTime;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}