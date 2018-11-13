package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class MainEquipment {
	
	@ApiModelProperty(value="主设备id",name="mainEquipmentId")
    private String mainEquipmentId;

	@ApiModelProperty(value="风电场",name="department",required=true)
    private String department;

	@ApiModelProperty(value="日志类型",name="logType",required=true)
    private String logType;

	@ApiModelProperty(value="值班日志表id",name="logTypeId")
    private String logTypeId;

	@ApiModelProperty(value="日志名称",name="logName")
    private String logName;

    public String getMainEquipmentId() {
        return mainEquipmentId;
    }

    public void setMainEquipmentId(String mainEquipmentId) {
        this.mainEquipmentId = mainEquipmentId == null ? null : mainEquipmentId.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId == null ? null : logTypeId.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }
}