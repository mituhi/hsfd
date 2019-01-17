package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkorderInfo {

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="serialNumber",value="工单号(流水号)",required=false)
    private String serialNumber;

    @ApiModelProperty(name="workorderCode",value="工单代码",required=false)
    private String workorderCode;

    @ApiModelProperty(name="workorderTypeId",value="工单类型id",required=false)
    private String workorderTypeId;

    @ApiModelProperty(name="workorderDesc",value="工单描述",required=false)
    private String workorderDesc;

    @ApiModelProperty(name="maintainer",value="维护人id",required=false)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;

    @ApiModelProperty(name="flowStatus",value="流程节点id",required=false)
    private String flowStatus;

    @ApiModelProperty(name="windId",value="风电场id",required=false)
    private String windId;

    @ApiModelProperty(name="company",value="公司id",required=false)
    private String company;

    @ApiModelProperty(name="department",value="部门id",required=false)
    private String department;

    @ApiModelProperty(name="crewId",value="机组id",required=false)
    private String crewId;

    @ApiModelProperty(name="dutyTeam",value="负责班组id",required=false)
    private String dutyTeam;

    @ApiModelProperty(name="dutyHead",value="负责人id",required=false)
    private String dutyHead;

    @ApiModelProperty(name="fillPerson",value="填报人id",required=false)
    private String fillPerson;

    @ApiModelProperty(name="schemeTime",value="策划时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date schemeTime;

    @ApiModelProperty(name="unitMember",value="本单位人员ids,逗号隔开",required=false)
    private String unitMember;

    @ApiModelProperty(name="otherUnitMember",value="外单位人员姓名,逗号隔开",required=false)
    private String otherUnitMember;

    @ApiModelProperty(name="positionId",value="位置id",required=false)
    private String positionId;

    @ApiModelProperty(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiModelProperty(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiModelProperty(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiModelProperty(name="planStartTime",value="计划开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planStartTime;

    @ApiModelProperty(name="planEndTime",value="计划结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planEndTime;

    @ApiModelProperty(name="planWorkHour",value="计划工时",required=false)
    private String planWorkHour;

    @ApiModelProperty(name="planMaterialFee",value="计划材料费",required=false)
    private String planMaterialFee;

    @ApiModelProperty(name="planServiceFee",value="计划服务费",required=false)
    private String planServiceFee;

    @ApiModelProperty(name="actualCompleteTime",value="实际完成时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date actualCompleteTime;

    @ApiModelProperty(name="attachment",value="附件",required=false)
    private String attachment;

    @ApiModelProperty(name="equipmentStatusRequirement1",value="一次设备状态要求",required=false)
    private String equipmentStatusRequirement1;

    @ApiModelProperty(name="equipmentStatusRequirement2",value="二次设备状态要求",required=false)
    private String equipmentStatusRequirement2;

    @ApiModelProperty(name="otherRequirement",value="其他要求",required=false)
    private String otherRequirement;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getWorkorderCode() {
        return workorderCode;
    }

    public void setWorkorderCode(String workorderCode) {
        this.workorderCode = workorderCode == null ? null : workorderCode.trim();
    }

    public String getWorkorderTypeId() {
        return workorderTypeId;
    }

    public void setWorkorderTypeId(String workorderTypeId) {
        this.workorderTypeId = workorderTypeId == null ? null : workorderTypeId.trim();
    }

    public String getWorkorderDesc() {
        return workorderDesc;
    }

    public void setWorkorderDesc(String workorderDesc) {
        this.workorderDesc = workorderDesc == null ? null : workorderDesc.trim();
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

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId == null ? null : crewId.trim();
    }

    public String getDutyTeam() {
        return dutyTeam;
    }

    public void setDutyTeam(String dutyTeam) {
        this.dutyTeam = dutyTeam == null ? null : dutyTeam.trim();
    }

    public String getDutyHead() {
        return dutyHead;
    }

    public void setDutyHead(String dutyHead) {
        this.dutyHead = dutyHead == null ? null : dutyHead.trim();
    }

    public String getFillPerson() {
        return fillPerson;
    }

    public void setFillPerson(String fillPerson) {
        this.fillPerson = fillPerson == null ? null : fillPerson.trim();
    }

    public Date getSchemeTime() {
        return schemeTime;
    }

    public void setSchemeTime(Date schemeTime) {
        this.schemeTime = schemeTime;
    }

    public String getUnitMember() {
        return unitMember;
    }

    public void setUnitMember(String unitMember) {
        this.unitMember = unitMember == null ? null : unitMember.trim();
    }

    public String getOtherUnitMember() {
        return otherUnitMember;
    }

    public void setOtherUnitMember(String otherUnitMember) {
        this.otherUnitMember = otherUnitMember == null ? null : otherUnitMember.trim();
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

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getPlanWorkHour() {
        return planWorkHour;
    }

    public void setPlanWorkHour(String planWorkHour) {
        this.planWorkHour = planWorkHour == null ? null : planWorkHour.trim();
    }

    public String getPlanMaterialFee() {
        return planMaterialFee;
    }

    public void setPlanMaterialFee(String planMaterialFee) {
        this.planMaterialFee = planMaterialFee == null ? null : planMaterialFee.trim();
    }

    public String getPlanServiceFee() {
        return planServiceFee;
    }

    public void setPlanServiceFee(String planServiceFee) {
        this.planServiceFee = planServiceFee == null ? null : planServiceFee.trim();
    }

    public Date getActualCompleteTime() {
        return actualCompleteTime;
    }

    public void setActualCompleteTime(Date actualCompleteTime) {
        this.actualCompleteTime = actualCompleteTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getEquipmentStatusRequirement1() {
        return equipmentStatusRequirement1;
    }

    public void setEquipmentStatusRequirement1(String equipmentStatusRequirement1) {
        this.equipmentStatusRequirement1 = equipmentStatusRequirement1 == null ? null : equipmentStatusRequirement1.trim();
    }

    public String getEquipmentStatusRequirement2() {
        return equipmentStatusRequirement2;
    }

    public void setEquipmentStatusRequirement2(String equipmentStatusRequirement2) {
        this.equipmentStatusRequirement2 = equipmentStatusRequirement2 == null ? null : equipmentStatusRequirement2.trim();
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement == null ? null : otherRequirement.trim();
    }

}