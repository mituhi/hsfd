package com.qz.zframe.run.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class ImportantMatter {
	
	@ApiModelProperty(value="重要事项id",name="matterId")
    private String matterId;

	@ApiModelProperty(value="日志类型id",name="logTypeId")
    private String logTypeId;

    @ApiModelProperty(value="日志类型编码",name="logCode")
    private String logCode;

    @ApiModelProperty(value="日志类型名称",name="logTypeId")
    private String logName;

	@ApiModelProperty(value="风电场",name="windCode",required = true)
    private String windCode;

    @ApiModelProperty(value="风电场名称",name="windName",required = true)
    private String windName;

	@ApiModelProperty(value="重要事项",name="importantMatter")
    private String importantMatter;

    @ApiModelProperty(value="维护人",name="updatePerson",required = true)
    private String updatePerson;

    @ApiModelProperty(value="维护人姓名",name="updatePersonName",required = true)
    private String updatePersonName;

	@ApiModelProperty(value="维护时间",name="updateTime",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
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

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId == null ? null : logTypeId.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
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

    public String getImportantMatter() {
        return importantMatter;
    }

    public void setImportantMatter(String importantMatter) {
        this.importantMatter = importantMatter == null ? null : importantMatter.trim();
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}