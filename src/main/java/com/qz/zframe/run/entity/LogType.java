package com.qz.zframe.run.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LogType {
	
	@ApiModelProperty(value="日志类型id",name="logTypeId")
    private String logTypeId;

	@ApiModelProperty(value="日志类型表部门",name="department",required = false)
    private String department;

    @ApiModelProperty(value="风电场编码",name="windCode",required = true)
    private String windCode;

    @ApiModelProperty(value="风电场名称",name="windName",required = false)
    private String windName;

	@ApiModelProperty(value="日志类型",name="logType",required = false)
    private String logType;

	@ApiModelProperty(value="日志编码",name="logCode",required = true)
    private String logCode;

	@ApiModelProperty(value="日志名称",name="logName",required = true)
    private String logName;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

    @ApiModelProperty(value="状态名称",name="statusName",required = true)
    private String statusName;

	@ApiModelProperty(value="维护人",name="maintainer",required = false)
    private String maintainer;

	@ApiModelProperty(value="维护日期",name="maintainTime",required = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date maintainTime;

    public String getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId == null ? null : logTypeId.trim();
    }

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }
}