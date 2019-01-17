package com.qz.zframe.maintain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class OperateTicketForWorkorderVo {

    @ApiModelProperty(name = "ticketId", value = "操作票id", required = false)
    private String ticketId;

    @ApiModelProperty(name = "serialNumber", value = "操作票号", required = false)
    private String serialNumber;

    @ApiModelProperty(name = "workTeam", value = "工作班组id", required = false)
    private String workTeam;

    @ApiModelProperty(name = "workTeamName", value = "工作班组名称", required = false)
    private String workTeamName;

    @ApiModelProperty(name = "ticketTypeName", value = "操作票类型名称", required = false)
    private String ticketTypeName;

    @ApiModelProperty(name = "status", value = "状态", required = false)
    private String status;

    @ApiModelProperty(name = "statusName", value = "状态名称", required = false)
    private String statusName;

    @ApiModelProperty(name = "applicant", value = "申请人", required = false)
    private String applicant;

    @ApiModelProperty(name = "applicantName", value = "申请人姓名", required = false)
    private String applicantName;

    @ApiModelProperty(name = "applyTime", value = "申请时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiModelProperty(name = "operateContent", value = "操作内容", required = false)
    private String operateContent;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam;
    }

    public String getWorkTeamName() {
        return workTeamName;
    }

    public void setWorkTeamName(String workTeamName) {
        this.workTeamName = workTeamName;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }
}
