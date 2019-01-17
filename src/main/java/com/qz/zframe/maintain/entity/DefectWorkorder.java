package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class DefectWorkorder {

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="workorderId",value="工单编号(流水号)",required=false)
    private String serialNumber;

    @ApiModelProperty(name="breakdownId",value="故障id",required=true)
    private String breakdownId;

    @ApiModelProperty(name="workorderTypeId",value="工单类型id",required=true)
    private String workorderTypeId;

    @ApiModelProperty(name="workorderDesc",value="工单描述",required=true)
    private String workorderDesc;

    @ApiModelProperty(name="maintainer",value="维护人id",required=true)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;

    @ApiModelProperty(name="flowStatus",value="流程状态",required=false)
    private String flowStatus;

    @ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiModelProperty(name="company",value="公司id",required=true)
    private String company;

    @ApiModelProperty(name="department",value="部门",required=true)
    private String department;

    @ApiModelProperty(name="dealMode",value="处理方式id",required=true)
    private String dealMode;

    @ApiModelProperty(name="dutyTeam",value="负责班组",required=true)
    private String dutyTeam;

    @ApiModelProperty(name="dutyHead",value="负责人id",required=true)
    private String dutyHead;

    @ApiModelProperty(name="fillPerson",value="策划人id",required=true)
    private String fillPerson;

    @ApiModelProperty(name="fillTime",value="填报时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date fillTime;

    @ApiModelProperty(name="unitMember",value="本单位工作人员",required=false)
    private String unitMember;

    @ApiModelProperty(name="otherUnitMember",value="外单位工作人员",required=false)
    private String otherUnitMember;

    @ApiModelProperty(name="crewId",value="机组id",required=true)
    private String crewId;

    @ApiModelProperty(name="positionId",value="位置id",required=true)
    private String positionId;

    @ApiModelProperty(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiModelProperty(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiModelProperty(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiModelProperty(name="breakdownDesc",value="故障描述",required=false)
    private String breakdownDesc;

    @ApiModelProperty(name="breakdownCode",value="故障代码",required=false)
    private String breakdownCode;

    @ApiModelProperty(name="activeTime",value="故障激活时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date activeTime;

    @ApiModelProperty(name="recoverTime",value="故障恢复时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date recoverTime;

    @ApiModelProperty(name="downtimeWindspeed",value="停机风速",required=false)
    private String downtimeWindspeed;

    @ApiModelProperty(name="recoverWindspeed",value="恢复风速",required=false)
    private String recoverWindspeed;

    @ApiModelProperty(name="interruptTime",value="中断时间",required=false)
    private String interruptTime;

    @ApiModelProperty(name="electricityLoss",value="损耗电量",required=false)
    private String electricityLoss;

    @ApiModelProperty(name="gridConnectedRecoverTime",value="并网恢复时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date gridConnectedRecoverTime;

    @ApiModelProperty(name="breakdownLocation",value="故障位置id",required=true)
    private String breakdownLocation;

    @ApiModelProperty(name="breakdownAttribute",value="故障属性id",required=true)
    private String breakdownAttribute;

    @ApiModelProperty(name="phenomenon",value="故障现象",required=false)
    private String phenomenon;

    @ApiModelProperty(name="picture",value="图片",required=false)
    private String picture;

    @ApiModelProperty(name="defectRemark",value="备注",required=false)
    private String defectRemark;

    @ApiModelProperty(name="defectAnalysis",value="缺陷分析",required=true)
    private String defectAnalysis;

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

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getBreakdownId() {
        return breakdownId;
    }

    public void setBreakdownId(String breakdownId) {
        this.breakdownId = breakdownId;
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

    public String getDealMode() {
        return dealMode;
    }

    public void setDealMode(String dealMode) {
        this.dealMode = dealMode == null ? null : dealMode.trim();
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

    public Date getFillTime() {
        return fillTime;
    }

    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
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

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId == null ? null : crewId.trim();
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

    public String getBreakdownDesc() {
        return breakdownDesc;
    }

    public void setBreakdownDesc(String breakdownDesc) {
        this.breakdownDesc = breakdownDesc == null ? null : breakdownDesc.trim();
    }

    public String getBreakdownCode() {
        return breakdownCode;
    }

    public void setBreakdownCode(String breakdownCode) {
        this.breakdownCode = breakdownCode == null ? null : breakdownCode.trim();
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(Date recoverTime) {
        this.recoverTime = recoverTime;
    }

    public String getDowntimeWindspeed() {
        return downtimeWindspeed;
    }

    public void setDowntimeWindspeed(String downtimeWindspeed) {
        this.downtimeWindspeed = downtimeWindspeed == null ? null : downtimeWindspeed.trim();
    }

    public String getRecoverWindspeed() {
        return recoverWindspeed;
    }

    public void setRecoverWindspeed(String recoverWindspeed) {
        this.recoverWindspeed = recoverWindspeed == null ? null : recoverWindspeed.trim();
    }

    public String getInterruptTime() {
        return interruptTime;
    }

    public void setInterruptTime(String interruptTime) {
        this.interruptTime = interruptTime == null ? null : interruptTime.trim();
    }

    public String getElectricityLoss() {
        return electricityLoss;
    }

    public void setElectricityLoss(String electricityLoss) {
        this.electricityLoss = electricityLoss == null ? null : electricityLoss.trim();
    }

    public Date getGridConnectedRecoverTime() {
        return gridConnectedRecoverTime;
    }

    public void setGridConnectedRecoverTime(Date gridConnectedRecoverTime) {
        this.gridConnectedRecoverTime = gridConnectedRecoverTime;
    }

    public String getBreakdownLocation() {
        return breakdownLocation;
    }

    public void setBreakdownLocation(String breakdownLocation) {
        this.breakdownLocation = breakdownLocation == null ? null : breakdownLocation.trim();
    }

    public String getBreakdownAttribute() {
        return breakdownAttribute;
    }

    public void setBreakdownAttribute(String breakdownAttribute) {
        this.breakdownAttribute = breakdownAttribute == null ? null : breakdownAttribute.trim();
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon == null ? null : phenomenon.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDefectRemark() {
        return defectRemark;
    }

    public void setDefectRemark(String defectRemark) {
        this.defectRemark = defectRemark == null ? null : defectRemark.trim();
    }

    public String getDefectAnalysis() {
        return defectAnalysis;
    }

    public void setDefectAnalysis(String defectAnalysis) {
        this.defectAnalysis = defectAnalysis == null ? null : defectAnalysis.trim();
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