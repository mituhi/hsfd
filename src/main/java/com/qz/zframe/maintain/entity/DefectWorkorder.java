package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class DefectWorkorder {

    @ApiParam(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiParam(name="workorderId",value="工单编号(流水号)",required=false)
    private String serialNumber;

    @ApiParam(name="workorderCode",value="工单代码",required=false)
    private String workorderCode;

    @ApiParam(name="workorderTypeId",value="工单类型id",required=true)
    private String workorderTypeId;

    @ApiParam(name="workorderDesc",value="工单描述",required=true)
    private String workorderDesc;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="company",value="公司",required=true)
    private String company;

    @ApiParam(name="dealMode",value="处理方式",required=true)
    private String dealMode;

    @ApiParam(name="dutyTeam",value="负责班组",required=true)
    private String dutyTeam;

    @ApiParam(name="dutyHead",value="负责人",required=true)
    private String dutyHead;

    @ApiParam(name="fillPerson",value="策划人",required=true)
    private String fillPerson;

    @ApiParam(name="fillTime",value="填报时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date fillTime;

    @ApiParam(name="unitMember",value="本单位工作人员",required=false)
    private String unitMember;

    @ApiParam(name="otherUnitMember",value="外单位工作人员",required=false)
    private String otherUnitMember;

    @ApiParam(name="crewId",value="机组",required=true)
    private String crewId;

    @ApiParam(name="positionId",value="位置id",required=true)
    private String positionId;

    @ApiParam(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiParam(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiParam(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiParam(name="breakdownDesc",value="故障描述",required=false)
    private String breakdownDesc;

    @ApiParam(name="breakdownCode",value="故障代码",required=false)
    private String breakdownCode;

    @ApiParam(name="activeTime",value="故障激活时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date activeTime;

    @ApiParam(name="recoverTime",value="故障恢复时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date recoverTime;

    @ApiParam(name="downtimeWindspeed",value="停机风速",required=false)
    private String downtimeWindspeed;

    @ApiParam(name="recoverWindspeed",value="恢复风速",required=false)
    private String recoverWindspeed;

    @ApiParam(name="interruptTime",value="中断时间",required=false)
    private String interruptTime;

    @ApiParam(name="electricityLoss",value="损耗电量",required=false)
    private String electricityLoss;

    @ApiParam(name="gridConnectedRecoverTime",value="并网恢复时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date gridConnectedRecoverTime;

    @ApiParam(name="breakdownLocation",value="故障位置id",required=false)
    private String breakdownLocation;

    @ApiParam(name="breakdownAttribute",value="故障属性id",required=false)
    private String breakdownAttribute;

    @ApiParam(name="phenomenon",value="故障现象",required=false)
    private String phenomenon;

    @ApiParam(name="picture",value="图片",required=false)
    private String picture;

    @ApiParam(name="defectRemark",value="备注",required=false)
    private String defectRemark;

    @ApiParam(name="defectAnalysis",value="缺陷分析",required=false)
    private String defectAnalysis;

    @ApiParam(name="planStartTime",value="计划开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planStartTime;

    @ApiParam(name="planEndTime",value="计划结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planEndTime;

    @ApiParam(name="planWorkHour",value="计划工时",required=false)
    private String planWorkHour;

    @ApiParam(name="planMaterialFee",value="计划材料费",required=false)
    private String planMaterialFee;

    @ApiParam(name="planServiceFee",value="计划服务费",required=false)
    private String planServiceFee;

    @ApiParam(name="actualCompleteTime",value="实际完成时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date actualCompleteTime;

    @ApiParam(name="attachment",value="附件",required=false)
    private String attachment;

    @ApiParam(name="equipmentStatusRequirement1",value="一次设备状态要求",required=false)
    private String equipmentStatusRequirement1;

    @ApiParam(name="equipmentStatusRequirement2",value="二次设备状态要求",required=false)
    private String equipmentStatusRequirement2;

    @ApiParam(name="otherRequirement",value="其他要求",required=false)
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