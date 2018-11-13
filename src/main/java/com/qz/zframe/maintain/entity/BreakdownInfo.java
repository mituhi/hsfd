package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class BreakdownInfo {

    @ApiParam(name="breakdownId",value="故障id",required=false)
    private String breakdownId;

    @ApiParam(name="serialNumber",value="(故障编号)流水号",required=false)
    private String serialNumber;

    @ApiParam(name="breakdownCode",value="故障代码",required=false)
    private String breakdownCode;

    @ApiParam(name="breakdownDesc",value="故障描述",required=true)
    private String breakdownDesc;

    @ApiParam(name="maintainer",value="维护人",required=false)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="dealwithMode",value="处理方式",required=false)
    private String dealwithMode;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="company",value="公司",required=false)
    private String company;

    @ApiParam(name="dealwithTeam",value="处理(负责)班组",required=true)
    private String dealwithTeam;

    @ApiParam(name="dealwithPerson",value="处理(负责)人",required=true)
    private String dealwithPerson;

    @ApiParam(name="fillPerson",value="填报人",required=false)
    private String fillPerson;

    @ApiParam(name="positionId",value="位置id",required=true)
    private String positionId;

    @ApiParam(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiParam(name="crewId",value="机组id",required=false)
    private String crewId;

    @ApiParam(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiParam(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiParam(name="vaneSpeed",value="叶轮转速",required=false)
    private String vaneSpeed;

    @ApiParam(name="bladeTorque1",value="叶片1扭矩",required=false)
    private String bladeTorque1;

    @ApiParam(name="bladeTorque2",value="叶片2扭矩",required=false)
    private String bladeTorque2;

    @ApiParam(name="bladeTorque3",value="叶片3扭矩",required=false)
    private String bladeTorque3;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String interruptTime;

    @ApiParam(name="electricityLoss",value="损失电量",required=false)
    private String electricityLoss;

    @ApiParam(name="gridConnectedRecoverTime",value="并网恢复时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date gridConnectedRecoverTime;

    @ApiParam(name="breakdownLocation",value="故障位置id",required=true)
    private String breakdownLocation;

    @ApiParam(name="breakdownAttribute",value="故障属性id",required=true)
    private String breakdownAttribute;

    @ApiParam(name="maximumLoad",value="最大负荷",required=false)
    private String maximumLoad;

    @ApiParam(name="systemBusbar110",value="110kv系统母线",required=false)
    private String systemBusbar110;

    @ApiParam(name="systemBusbar35",value="35kv系统母线",required=false)
    private String systemBusbar35;

    @ApiParam(name="systemBusbar400",value="400kv系统母线",required=false)
    private String systemBusbar400;

    @ApiParam(name="workorderNumber",value="故障工单号",required=false)
    private String workorderNumber;

    @ApiParam(name="workorderStatus",value="故障工单状态",required=false)
    private String workorderStatus;

    @ApiParam(name="workorderDesc",value="工单描述",required=false)
    private String workorderDesc;

    @ApiParam(name="workorderType",value="工单类型",required=false)
    private String workorderType;

    @ApiParam(name="phenomenon",value="故障现象",required=false)
    private String phenomenon;

    @ApiParam(name="remark",value="图片",required=false)
    private String picture;

    @ApiParam(name="remark",value="备注",required=false)
    private String remark;

    public String getBreakdownId() {
        return breakdownId;
    }

    public void setBreakdownId(String breakdownId) {
        this.breakdownId = breakdownId == null ? null : breakdownId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getBreakdownCode() {
        return breakdownCode;
    }

    public void setBreakdownCode(String breakdownCode) {
        this.breakdownCode = breakdownCode == null ? null : breakdownCode.trim();
    }

    public String getBreakdownDesc() {
        return breakdownDesc;
    }

    public void setBreakdownDesc(String breakdownDesc) {
        this.breakdownDesc = breakdownDesc == null ? null : breakdownDesc.trim();
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

    public String getDealwithMode() {
        return dealwithMode;
    }

    public void setDealwithMode(String dealwithMode) {
        this.dealwithMode = dealwithMode;
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
        this.company = company;
    }

    public String getDealwithTeam() {
        return dealwithTeam;
    }

    public void setDealwithTeam(String dealwithTeam) {
        this.dealwithTeam = dealwithTeam;
    }

    public String getDealwithPerson() {
        return dealwithPerson;
    }

    public void setDealwithPerson(String dealwithPerson) {
        this.dealwithPerson = dealwithPerson == null ? null : dealwithPerson.trim();
    }

    public String getFillPerson() {
        return fillPerson;
    }

    public void setFillPerson(String fillPerson) {
        this.fillPerson = fillPerson;
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

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId == null ? null : crewId.trim();
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

    public String getVaneSpeed() {
        return vaneSpeed;
    }

    public void setVaneSpeed(String vaneSpeed) {
        this.vaneSpeed = vaneSpeed == null ? null : vaneSpeed.trim();
    }

    public String getBladeTorque1() {
        return bladeTorque1;
    }

    public void setBladeTorque1(String bladeTorque1) {
        this.bladeTorque1 = bladeTorque1 == null ? null : bladeTorque1.trim();
    }

    public String getBladeTorque2() {
        return bladeTorque2;
    }

    public void setBladeTorque2(String bladeTorque2) {
        this.bladeTorque2 = bladeTorque2 == null ? null : bladeTorque2.trim();
    }

    public String getBladeTorque3() {
        return bladeTorque3;
    }

    public void setBladeTorque3(String bladeTorque3) {
        this.bladeTorque3 = bladeTorque3 == null ? null : bladeTorque3.trim();
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
        this.interruptTime = interruptTime;
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
        this.breakdownLocation = breakdownLocation;
    }

    public String getBreakdownAttribute() {
        return breakdownAttribute;
    }

    public void setBreakdownAttribute(String breakdownAttribute) {
        this.breakdownAttribute = breakdownAttribute;
    }

    public String getMaximumLoad() {
        return maximumLoad;
    }

    public void setMaximumLoad(String maximumLoad) {
        this.maximumLoad = maximumLoad == null ? null : maximumLoad.trim();
    }

    public String getSystemBusbar110() {
        return systemBusbar110;
    }

    public void setSystemBusbar110(String systemBusbar110) {
        this.systemBusbar110 = systemBusbar110 == null ? null : systemBusbar110.trim();
    }

    public String getSystemBusbar35() {
        return systemBusbar35;
    }

    public void setSystemBusbar35(String systemBusbar35) {
        this.systemBusbar35 = systemBusbar35 == null ? null : systemBusbar35.trim();
    }

    public String getSystemBusbar400() {
        return systemBusbar400;
    }

    public void setSystemBusbar400(String systemBusbar400) {
        this.systemBusbar400 = systemBusbar400 == null ? null : systemBusbar400.trim();
    }

    public String getWorkorderNumber() {
        return workorderNumber;
    }

    public void setWorkorderNumber(String workorderNumber) {
        this.workorderNumber = workorderNumber;
    }

    public String getWorkorderStatus() {
        return workorderStatus;
    }

    public void setWorkorderStatus(String workorderStatus) {
        this.workorderStatus = workorderStatus;
    }

    public String getWorkorderDesc() {
        return workorderDesc;
    }

    public void setWorkorderDesc(String workorderDesc) {
        this.workorderDesc = workorderDesc;
    }

    public String getWorkorderType() {
        return workorderType;
    }

    public void setWorkorderType(String workorderType) {
        this.workorderType = workorderType;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}