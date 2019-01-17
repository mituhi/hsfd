package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DutyLog {
	
	@ApiModelProperty(value="值班日志表id",name="dutyLogId")
    private String dutyLogId;

	@ApiModelProperty(value="日志类型表id",name="logTypeId")
    private String logTypeId;

	@ApiModelProperty(value="日志类型",name="logType",required = true)
    private String logType;

	@ApiModelProperty(value="日志名称",name="logName")
    private String logName;

	@ApiModelProperty(value="风电场",name="department",required = true)
    private String department;

	@ApiModelProperty(value="排版管理表id",name="schedulingManagementId")
    private String schedulingManagementId;

	@ApiModelProperty(value="排班表名称",name="schedulingName",required = true)
    private String schedulingName;

	@ApiModelProperty(value="值班人员名称",name="dutyUser")
    private String dutyUser;

	@ApiModelProperty(value="值班人员id，用‘,’隔开",name="dutyUserIds",required = true)
    private String dutyUserIds;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

	@ApiModelProperty(value="是否当面交接班",name="isFaceToFace",required = true)
    private String isFaceToFace;

	@ApiModelProperty(value="电话",name="phone",required = true)
    private String phone;

	@ApiModelProperty(value="备注",name="remark",required = true)
    private String remark;

	@ApiModelProperty(value="当班记事表id，因为是1对多，用‘,’隔开",name="dutyRememberId")
    private String dutyRememberId;

	@ApiModelProperty(value="日志TAB表id，因为是1对多，用‘,’隔开",name="tabId",required = true)
    private String tabId;

	@ApiModelProperty(value="维护人",name="maintainUser")
    private String maintainUser;

	@ApiModelProperty(value="维护日期",name="updateTime")
    private Date updateTime;

    public String getDutyLogId() {
        return dutyLogId;
    }

    public void setDutyLogId(String dutyLogId) {
        this.dutyLogId = dutyLogId == null ? null : dutyLogId.trim();
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

    public String getSchedulingManagementId() {
        return schedulingManagementId;
    }

    public void setSchedulingManagementId(String schedulingManagementId) {
        this.schedulingManagementId = schedulingManagementId == null ? null : schedulingManagementId.trim();
    }

    public String getSchedulingName() {
        return schedulingName;
    }

    public void setSchedulingName(String schedulingName) {
        this.schedulingName = schedulingName == null ? null : schedulingName.trim();
    }

    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser == null ? null : dutyUser.trim();
    }

    public String getDutyUserIds() {
        return dutyUserIds;
    }

    public void setDutyUserIds(String dutyUserIds) {
        this.dutyUserIds = dutyUserIds == null ? null : dutyUserIds.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsFaceToFace() {
        return isFaceToFace;
    }

    public void setIsFaceToFace(String isFaceToFace) {
        this.isFaceToFace = isFaceToFace == null ? null : isFaceToFace.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDutyRememberId() {
        return dutyRememberId;
    }

    public void setDutyRememberId(String dutyRememberId) {
        this.dutyRememberId = dutyRememberId == null ? null : dutyRememberId.trim();
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
    }

    public String getMaintainUser() {
        return maintainUser;
    }

    public void setMaintainUser(String maintainUser) {
        this.maintainUser = maintainUser == null ? null : maintainUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}