package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class OperateTicket {

    @ApiParam(name="ticketId",value="操作票id",required=false)
    private String ticketId;

    @ApiParam(name="serialNumber",value="操作票号(流水号)",required=false)
    private String serialNumber;

    @ApiParam(name="operTicketTypeId",value="操作票类型id",required=true)
    private String operTicketTypeId;

    @ApiParam(name="typicalTicketId",value="典型操作票id",required=false)
    private String typicalTicketId;

    @ApiParam(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiParam(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="flowStep",value="流程节点",required=false)
    private String flowStep;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="crewId",value="机组id",required=true)
    private String crewId;

    @ApiParam(name="applicant",value="申请人",required=false)
    private String applicant;

    @ApiParam(name="applyTime",value="申请时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiParam(name="sender",value="发令人",required=true)
    private String sender;

    @ApiParam(name="receiver",value="受令人",required=true)
    private String receiver;

    @ApiParam(name="sendTime",value="发令时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date sendTime;

    @ApiParam(name="workTeam",value="工作班组",required=true)
    private String workTeam;

    @ApiParam(name="executer",value="操作人",required=true)
    private String executer;

    @ApiParam(name="supervisior",value="监护人",required=true)
    private String supervisior;

    @ApiParam(name="operStartTime",value="操作开始时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date operStartTime;

    @ApiParam(name="operEndTime",value="操作结束时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date operEndTime;

    @ApiParam(name="positionId",value="位置id",required=false)
    private String positionId;

    @ApiParam(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiParam(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiParam(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiParam(name="operateContent",value="操作内容",required=true)
    private String operateContent;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getOperTicketTypeId() {
        return operTicketTypeId;
    }

    public void setOperTicketTypeId(String operTicketTypeId) {
        this.operTicketTypeId = operTicketTypeId == null ? null : operTicketTypeId.trim();
    }

    public String getTypicalTicketId() {
        return typicalTicketId;
    }

    public void setTypicalTicketId(String typicalTicketId) {
        this.typicalTicketId = typicalTicketId == null ? null : typicalTicketId.trim();
    }

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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
        this.status = status == null ? null : status.trim();
    }

    public String getFlowStep() {
        return flowStep;
    }

    public void setFlowStep(String flowStep) {
        this.flowStep = flowStep == null ? null : flowStep.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId == null ? null : crewId.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam == null ? null : workTeam.trim();
    }

    public String getExecuter() {
        return executer;
    }

    public void setExecuter(String executer) {
        this.executer = executer == null ? null : executer.trim();
    }

    public String getSupervisior() {
        return supervisior;
    }

    public void setSupervisior(String supervisior) {
        this.supervisior = supervisior == null ? null : supervisior.trim();
    }

    public Date getOperStartTime() {
        return operStartTime;
    }

    public void setOperStartTime(Date operStartTime) {
        this.operStartTime = operStartTime;
    }

    public Date getOperEndTime() {
        return operEndTime;
    }

    public void setOperEndTime(Date operEndTime) {
        this.operEndTime = operEndTime;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc == null ? null : positionDesc.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc == null ? null : equipmentDesc.trim();
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }
}