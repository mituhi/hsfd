package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ImportantMatter {
	
	@ApiModelProperty(value="重要事项id",name="matterId")
    private String matterId;

	@ApiModelProperty(value="日志类型id",name="logTypeId")
    private String logTypeId;

	@ApiModelProperty(value="日志类型",name="logType",required = true)
    private String logType;

	@ApiModelProperty(value="日志名称",name="logName",required = true)
    private String logName;

	@ApiModelProperty(value="部门/风电场",name="department",required = true)
    private String department;

	@ApiModelProperty(value="主要事项",name="importantMatter")
    private String importantMatter;

	@ApiModelProperty(value="更新时间",name="updateTime",required = true)
    private Date updateTime;

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId == null ? null : matterId.trim();
    }

    public String getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId == null ? null : logTypeId.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getImportantMatter() {
        return importantMatter;
    }

    public void setImportantMatter(String importantMatter) {
        this.importantMatter = importantMatter == null ? null : importantMatter.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}