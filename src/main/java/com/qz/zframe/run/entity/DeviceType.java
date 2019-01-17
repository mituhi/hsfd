package com.qz.zframe.run.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class DeviceType {
	
	@ApiModelProperty(value="设备类型状态表id",name="typeId")
    private String typeId;

	@ApiModelProperty(value="设备类型",name="deviceType")
    private String deviceType;

	@ApiModelProperty(value="设备状态",name="deviceStatus")
    private String deviceStatus;

    @ApiModelProperty(value="状态名称",name="statusName")
    private String statusName;

	@ApiModelProperty(value="排序",name="sort")
    private Integer sort;

	@JsonFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value="更新时间",name="updateTime")
    private Date updateTime;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;
	
	@ApiModelProperty(value="更新时间(用于导出Excel:无需理会)",name="updateTime")
    private String updateTimeStr;
	

    public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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