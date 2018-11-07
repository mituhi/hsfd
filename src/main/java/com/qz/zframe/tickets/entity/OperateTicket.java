package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class OperateTicket {

    @ApiParam(name="ticketId",value="操作票id",required=true)
    private String ticketId;

    @ApiParam(name="serialNumber",value="流水号",required=true)
    private String serialNumber;

    @ApiParam(name="ticketTypeId",value="操作票类型id",required=true)
    private String ticketTypeId;

    @ApiParam(name="ticketCode",value="操作票代码",required=true)
    private String ticketCode;

    @ApiParam(name="status",value="状态  1:处理中  2:完成  0:作废",required=false)
    private String status;

    @ApiParam(name="flowStep",value="流程节点",required=false)
    private String flowStep;

    @ApiParam(name="typicalTicketId",value="典型操作票id",required=true)
    private String typicalTicketId;

    @ApiParam(name="windId",value="风电场id",required=false)
    private String windId;

    @ApiParam(name="companyId",value="公司id",required=true)
    private String companyId;

    @ApiParam(name="departments",value="部门id",required=false)
    private String departments;

    @ApiParam(name="applicant",value="申请人",required=true)
    private String applicant;

    @ApiParam(name="applyTime",value="申请时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiParam(name="sender",value="发令人",required=true)
    private String sender;

    @ApiParam(name="receiver",value="收令人",required=true)
    private String receiver;

    @ApiParam(name="position_id",value="位置id",required=true)
    private String location;

    @ApiParam(name="equipment_id",value="设备id",required=false)
    private String equipment;

    @ApiParam(name="crew_id",value="机组id",required=false)
    private String machineSet;

    @ApiParam(name="executer",value="操作人",required=true)
    private String executer;

    @ApiParam(name="supervisior",value="监护人",required=true)
    private String supervisior;

    @ApiParam(name="startTime",value="计划开始时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date startTime;

    @ApiParam(name="endTime",value="计划结束时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date endTime;

    @ApiParam(name="operateContent",value="操作内容",required=true)
    private String operateContent;

    @ApiParam(name="operateItemsIds",value="操作项ids",required=false)
    private String operateItemsIds;

    @ApiParam(name="examineApprovePerson",value="审批人",required=false)
    private String examineApprovePerson;

    @ApiParam(name="orderTime",value="收令时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date orderTime;

    @ApiParam(name="pageSize",value="备注",required=false)
    private String remark;

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

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId == null ? null : ticketTypeId.trim();
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode == null ? null : ticketCode.trim();
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

    public String getTypicalTicketId() {
        return typicalTicketId;
    }

    public void setTypicalTicketId(String typicalTicketId) {
        this.typicalTicketId = typicalTicketId == null ? null : typicalTicketId.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments == null ? null : departments.trim();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getMachineSet() {
        return machineSet;
    }

    public void setMachineSet(String machineSet) {
        this.machineSet = machineSet == null ? null : machineSet.trim();
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    public String getOperateItemsIds() {
        return operateItemsIds;
    }

    public void setOperateItemsIds(String operateItemsIds) {
        this.operateItemsIds = operateItemsIds == null ? null : operateItemsIds.trim();
    }

    public String getExamineApprovePerson() {
        return examineApprovePerson;
    }

    public void setExamineApprovePerson(String examineApprovePerson) {
        this.examineApprovePerson = examineApprovePerson == null ? null : examineApprovePerson.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}