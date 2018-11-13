package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class MaintainWeekPlan {

    @ApiParam(name="weekId",value="周计划id",required=false)
    private String weekId;

    @ApiParam(name="serialNumber",value="流水人",required=false)
    private String serialNumber;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainTime",value="维护时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date maintainTime;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="startDate",value="开始日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date startDate;

    @ApiParam(name="endDate",value="结束日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date endDate;

    @ApiParam(name="weekOfYear",value="周",required=true)
    private String weekOfYear;

    @ApiParam(name="windId",value="风电场",required=true)
    private String windId;

    @ApiParam(name="recordPerson",value="记录人",required=true)
    private String recordPerson;

    @ApiParam(name="onDutyPerson",value="当班人员",required=true)
    private String onDutyPerson;

    @ApiParam(name="remark",value="备注",required=false)
    private String remark;

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId == null ? null : weekId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer == null ? null : maintainer.trim();
    }

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(String weekOfYear) {
        this.weekOfYear = weekOfYear == null ? null : weekOfYear.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getRecordPerson() {
        return recordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson == null ? null : recordPerson.trim();
    }

    public String getOnDutyPerson() {
        return onDutyPerson;
    }

    public void setOnDutyPerson(String onDutyPerson) {
        this.onDutyPerson = onDutyPerson == null ? null : onDutyPerson.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}