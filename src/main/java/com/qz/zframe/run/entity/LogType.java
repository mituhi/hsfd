package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class LogType {
	
	@ApiModelProperty(value="日志类型id",name="logTypeId")
    private String logTypeId;

	@ApiModelProperty(value="日志类型表部门",name="department",required = true)
    private String department;

	@ApiModelProperty(value="日志类型",name="logType",required = true)
    private String logType;

	@ApiModelProperty(value="日志编码",name="logCode",required = true)
    private String logCode;

	@ApiModelProperty(value="日志名称",name="logName",required = true)
    private String logName;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

    public String getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId == null ? null : logTypeId.trim();
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

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode == null ? null : logCode.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}