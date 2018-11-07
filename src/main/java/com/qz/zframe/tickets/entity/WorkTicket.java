package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class WorkTicket {

    @ApiParam(name="ticketId",value="工作票id",required=true)
    private String ticketId;

    @ApiParam(name="serialNumber",value="流水号",required=true)
    private String serialNumber;

    @ApiParam(name="ticketTypeId",value="工作票类型id",required=true)
    private String ticketTypeId;

    @ApiParam(name="ticketCode",value="工作票代码",required=true)
    private String ticketCode;

    @ApiParam(name="status",value="状态 1:处理中  2:完成  0:作废",required=false)
    private String status;

    @ApiParam(name="flowStatus",value="流程节点",required=false)
    private String flowStatus;

    @ApiParam(name="standardTicketId",value="标准工作票id",required=true)
    private String standardTicketId;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="companyId",value="公司id",required=false)
    private String companyId;

    @ApiParam(name="departmentId",value="部门id",required=true)
    private String departments;

    @ApiParam(name="applicant",value="申请人",required=true)
    private String applicant;

    @ApiParam(name="applyTime",value="申请时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiParam(name="workTeamId",value="工作班组",required=true)
    private String workTeam;

    @ApiParam(name="workHead",value="工作负责人",required=true)
    private String workHead;

    @ApiParam(name="safetyOfficer",value="安全员",required=true)
    private String safetyOfficer;

    @ApiParam(name="positionId",value="位置id",required=true)
    private String location;

    @ApiParam(name="equipmentId",value="设备id",required=false)
    private String equipment;

    @ApiParam(name="crewId",value="机组id",required=false)
    private String machineSet;

    @ApiParam(name="workMember",value="工作成员",required=true)
    private String workMember;

    @ApiParam(name="memberNum",value="共几人",required=true)
    private Integer memberNum;

    @ApiParam(name="workUnit",value="工作单位",required=true)
    private String workUnit;

    @ApiParam(name="otherUnitMember",value="外单位人员",required=false)
    private String otherUnitMember;

    @ApiParam(name="startTime",value="开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date startTime;

    @ApiParam(name="endTime",value="结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date endTime;

    @ApiParam(name="workPlace",value="工作地点",required=true)
    private String workPlace;

    @ApiParam(name="workContent",value="工作内容",required=true)
    private String workContent;

    @ApiParam(name="workCondition",value="工作条件",required=false)
    private String workCondition;

    @ApiParam(name="securityMeasure",value="安全措施",required=false)
    private String securityMeasure;

    @ApiParam(name="supSecurityMeasure",value="辅助安措",required=false)
    private String supSecurityMeasure;

    @ApiParam(name="measureIds",value="危险因素控制措施ids",required=false)
    private String measureIds;

    @ApiParam(name="signer",value="签收人",required=false)
    private String signer;

    @ApiParam(name="signTime",value="签收时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date signTime;

    @ApiParam(name="licenseStartTime",value="许可开始时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date licenseStartTime;

    @ApiParam(name="licenseEndTime",value="许可结束时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date licenseEndTime;

    @ApiParam(name="licensor",value="许可人",required=false)
    private String licensor;

    @ApiParam(name="workEndTime",value="工作完成时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date workEndTime;

    @ApiParam(name="opinion",value="审批意见",required=false)
    private String opinion;

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

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus == null ? null : flowStatus.trim();
    }

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
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

    public String getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam == null ? null : workTeam.trim();
    }

    public String getWorkHead() {
        return workHead;
    }

    public void setWorkHead(String workHead) {
        this.workHead = workHead == null ? null : workHead.trim();
    }

    public String getSafetyOfficer() {
        return safetyOfficer;
    }

    public void setSafetyOfficer(String safetyOfficer) {
        this.safetyOfficer = safetyOfficer == null ? null : safetyOfficer.trim();
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

    public String getWorkMember() {
        return workMember;
    }

    public void setWorkMember(String workMember) {
        this.workMember = workMember == null ? null : workMember.trim();
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getOtherUnitMember() {
        return otherUnitMember;
    }

    public void setOtherUnitMember(String otherUnitMember) {
        this.otherUnitMember = otherUnitMember == null ? null : otherUnitMember.trim();
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

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent == null ? null : workContent.trim();
    }

    public String getWorkCondition() {
        return workCondition;
    }

    public void setWorkCondition(String workCondition) {
        this.workCondition = workCondition == null ? null : workCondition.trim();
    }

    public String getSecurityMeasure() {
        return securityMeasure;
    }

    public void setSecurityMeasure(String securityMeasure) {
        this.securityMeasure = securityMeasure == null ? null : securityMeasure.trim();
    }

    public String getSupSecurityMeasure() {
        return supSecurityMeasure;
    }

    public void setSupSecurityMeasure(String supSecurityMeasure) {
        this.supSecurityMeasure = supSecurityMeasure == null ? null : supSecurityMeasure.trim();
    }

    public String getMeasureIds() {
        return measureIds;
    }

    public void setMeasureIds(String measureIds) {
        this.measureIds = measureIds == null ? null : measureIds.trim();
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer == null ? null : signer.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getLicenseStartTime() {
        return licenseStartTime;
    }

    public void setLicenseStartTime(Date licenseStartTime) {
        this.licenseStartTime = licenseStartTime;
    }

    public Date getLicenseEndTime() {
        return licenseEndTime;
    }

    public void setLicenseEndTime(Date licenseEndTime) {
        this.licenseEndTime = licenseEndTime;
    }

    public String getLicensor() {
        return licensor;
    }

    public void setLicensor(String licensor) {
        this.licensor = licensor == null ? null : licensor.trim();
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }
}