package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkTicketWorkTime {

    @ApiModelProperty(name="workTimeId",value="开工收工工作时间id",required=false)
    private String workTimeId;

    @ApiModelProperty(name="ticketId",value="工作票id",required=false)
    private String ticketId;

    @ApiModelProperty(name="workTimeNumber",value="编号",required=false)
    private String workTimeNumber;

    @ApiModelProperty(name="workStartTime",value="工作开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date workStartTime;

    @ApiModelProperty(name="workStartHead",value="工作开始负责人id",required=false)
    private String workStartHead;

    @ApiModelProperty(name="workStartLicensor",value="工作开始许可人id",required=false)
    private String workStartLicensor;

    @ApiModelProperty(name="workEndTime",value="工作结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date workEndTime;

    @ApiModelProperty(name="workEndHead",value="工作结束负责人id",required=false)
    private String workEndHead;

    @ApiModelProperty(name="workEndLicensor",value="工作结束许可人id",required=false)
    private String workEndLicensor;

    public String getWorkTimeId() {
        return workTimeId;
    }

    public void setWorkTimeId(String workTimeId) {
        this.workTimeId = workTimeId == null ? null : workTimeId.trim();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getWorkTimeNumber() {
        return workTimeNumber;
    }

    public void setWorkTimeNumber(String workTimeNumber) {
        this.workTimeNumber = workTimeNumber == null ? null : workTimeNumber.trim();
    }

    public Date getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Date workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkStartHead() {
        return workStartHead;
    }

    public void setWorkStartHead(String workStartHead) {
        this.workStartHead = workStartHead == null ? null : workStartHead.trim();
    }

    public String getWorkStartLicensor() {
        return workStartLicensor;
    }

    public void setWorkStartLicensor(String workStartLicensor) {
        this.workStartLicensor = workStartLicensor == null ? null : workStartLicensor.trim();
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getWorkEndHead() {
        return workEndHead;
    }

    public void setWorkEndHead(String workEndHead) {
        this.workEndHead = workEndHead == null ? null : workEndHead.trim();
    }

    public String getWorkEndLicensor() {
        return workEndLicensor;
    }

    public void setWorkEndLicensor(String workEndLicensor) {
        this.workEndLicensor = workEndLicensor == null ? null : workEndLicensor.trim();
    }
}