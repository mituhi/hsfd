package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class MaintainLogInfo {

    @ApiParam(name="dayId",value="日志id",required=false)
    private String dayId;

    @ApiParam(name="serialNumber",value="流水号",required=false)
    private String serialNumber;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="dayOfWeek",value="星期",required=true)
    private String dayOfWeek;

    @ApiParam(name="weather",value="天气",required=true)
    private String weather;

    @ApiParam(name="windId",value="风电场",required=true)
    private String windId;

    @ApiParam(name="recordPerson",value="记录人",required=true)
    private String recordPerson;

    @ApiParam(name="maintainTime",value="维护时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date maintainTime;

    @ApiParam(name="onDutyPerson",value="当班人员",required=true)
    private String onDutyPerson;

    @ApiParam(name="remark",value="备注",required=false)
    private String remark;

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId == null ? null : dayId.trim();
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

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek == null ? null : dayOfWeek.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
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

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
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