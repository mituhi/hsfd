package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkTicket {

    @ApiModelProperty(name="ticketId",value="工作票id",required=false)
    private String ticketId;

    @ApiModelProperty(name="serialNumber",value="工作票号(流水号)",required=false)
    private String serialNumber;

    @ApiModelProperty(name="workTicketTypeId",value="工作票类型id",required=true)
    private String workTicketTypeId;

    @ApiModelProperty(name="standardTicketId",value="标准工作票id",required=false)
    private String standardTicketId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="maintainer",value="维护人id",required=false)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;

    @ApiModelProperty(name="flowStatus",value="流程节点id",required=false)
    private String flowStatus;

    @ApiModelProperty(name="workPosition",value="流程节点id",required=false)
    private String workPosition;

    @ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiModelProperty(name="crewId",value="机组id",required=true)
    private String crewId;

    @ApiModelProperty(name="applicant",value="申请人id",required=false)
    private String applicant;

    @ApiModelProperty(name="applyTime",value="申请时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiModelProperty(name="workTeam",value="工作班组id",required=true)
    private String workTeam;

    @ApiModelProperty(name="workHead",value="工作负责人id",required=true)
    private String workHead;

    @ApiModelProperty(name="positionId",value="位置id",required=false)
    private String positionId;

    @ApiModelProperty(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiModelProperty(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiModelProperty(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiModelProperty(name="workMember",value="工作成员ids",required=false)
    private String workMember;

    @ApiModelProperty(name="memberNum",value="共几人",required=false)
    private Integer memberNum;

    @ApiModelProperty(name="planStartTime",value="计划开始时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planStartTime;

    @ApiModelProperty(name="planEndTime",value="计划结束时间",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date planEndTime;

    @ApiModelProperty(name="doubleNaem",value="工作的风电场、升压站名称及设备双重名称",required=true)
    private String doubleNaem;

    @ApiModelProperty(name="workPlace",value="工作地点或地段",required=true)
    private String workPlace;

    @ApiModelProperty(name="workContent",value="工作内容",required=true)
    private String workContent;

    @ApiModelProperty(name="workCondition",value="工作条件",required=false)
    private String workCondition;

    @ApiModelProperty(name="signer",value="签发人id",required=false)
    private String signer;

    @ApiModelProperty(name="signTime",value="签发时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date signTime;

    @ApiModelProperty(name="runMainPerson",value="运维人员id",required=false)
    private String runMainPerson;

    @ApiModelProperty(name="receiveHead",value="收到工作票工作负责人",required=false)
    private String receiveHead;

    @ApiModelProperty(name="receiveTime",value="收到工作票时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date receiveTime;

    @ApiModelProperty(name="sceneLicensor",value="现场许可人id",required=false)
    private String sceneLicensor;

    @ApiModelProperty(name="runLicensor",value="运行值班许可人id",required=false)
    private String runLicensor;

    @ApiModelProperty(name="licenseStartTime",value="许可开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date licenseStartTime;

    @ApiModelProperty(name="workTeamOpinion",value="工作班组人员确认工作任务和安全措施",required=false)
    private String workTeamOpinion;

    @ApiModelProperty(name="headChangeTo",value="负责人变更为id",required=false)
    private String headChangeTo;

    @ApiModelProperty(name="headChangeSigner",value="变更签发人id",required=false)
    private String headChangeSigner;

    @ApiModelProperty(name="headChanegTime",value="变更签发时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date headChanegTime;

    @ApiModelProperty(name="delayTime",value="有效期延期至",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date delayTime;

    @ApiModelProperty(name="delayHead",value="延期工作负责人id",required=false)
    private String delayHead;

    @ApiModelProperty(name="delayHeadSignTime",value="延期工作负责人签名时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date delayHeadSignTime;

    @ApiModelProperty(name="delayLicensor",value="延期许可人id",required=false)
    private String delayLicensor;

    @ApiModelProperty(name="delayLicensorSignTime",value="许可人签名时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date delayLicensorSignTime;

    @ApiModelProperty(name="workEndHead",value="工作结束工作负责人id",required=false)
    private String workEndHead;

    @ApiModelProperty(name="workEndLicensor",value="工作结束许可人id",required=false)
    private String workEndLicensor;

    @ApiModelProperty(name="workEndTime",value="工作结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date workEndTime;

    @ApiModelProperty(name="ticketEndLicensor",value="工作票终结许可人id",required=false)
    private String ticketEndLicensor;

    @ApiModelProperty(name="ticketEndTime",value="工作票终结时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date ticketEndTime;

    @ApiModelProperty(name="unuseWireNumber",value="未拆除或未拉开的接地线编号",required=false)
    private String unuseWireNumber;

    @ApiModelProperty(name="unuseWireNum",value="未拆除或未拉开的接地线共几组",required=false)
    private Integer unuseWireNum;

    @ApiModelProperty(name="knifeCarNum",value="接地刀闸(小车)共几副(台)",required=false)
    private Integer knifeCarNum;

    @ApiModelProperty(name="guardian",value="专职监护人id",required=false)
    private String guardian;

    @ApiModelProperty(name="guardianPlaceAndCont",value="负责监护地点及具体工作",required=false)
    private String guardianPlaceAndCont;

    @ApiModelProperty(name="guardianOtherThing",value="负责监护其他事项",required=false)
    private String guardianOtherThing;

    @ApiModelProperty(name="evaluation",value="评价人id",required=false)
    private String evaluation;

    @ApiModelProperty(name="evaluationCont",value="评价情况",required=false)
    private String evaluationCont;

    @ApiModelProperty(name="evaluationTime",value="评价时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date evaluationTime;

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

    public String getWorkTicketTypeId() {
        return workTicketTypeId;
    }

    public void setWorkTicketTypeId(String workTicketTypeId) {
        this.workTicketTypeId = workTicketTypeId == null ? null : workTicketTypeId.trim();
    }

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
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

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus == null ? null : flowStatus.trim();
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
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

    public String getDoubleNaem() {
        return doubleNaem;
    }

    public void setDoubleNaem(String doubleNaem) {
        this.doubleNaem = doubleNaem == null ? null : doubleNaem.trim();
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

    public String getRunMainPerson() {
        return runMainPerson;
    }

    public void setRunMainPerson(String runMainPerson) {
        this.runMainPerson = runMainPerson == null ? null : runMainPerson.trim();
    }

    public String getReceiveHead() {
        return receiveHead;
    }

    public void setReceiveHead(String receiveHead) {
        this.receiveHead = receiveHead == null ? null : receiveHead.trim();
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getSceneLicensor() {
        return sceneLicensor;
    }

    public void setSceneLicensor(String sceneLicensor) {
        this.sceneLicensor = sceneLicensor == null ? null : sceneLicensor.trim();
    }

    public String getRunLicensor() {
        return runLicensor;
    }

    public void setRunLicensor(String runLicensor) {
        this.runLicensor = runLicensor == null ? null : runLicensor.trim();
    }

    public Date getLicenseStartTime() {
        return licenseStartTime;
    }

    public void setLicenseStartTime(Date licenseStartTime) {
        this.licenseStartTime = licenseStartTime;
    }

    public String getWorkTeamOpinion() {
        return workTeamOpinion;
    }

    public void setWorkTeamOpinion(String workTeamOpinion) {
        this.workTeamOpinion = workTeamOpinion == null ? null : workTeamOpinion.trim();
    }

    public String getHeadChangeTo() {
        return headChangeTo;
    }

    public void setHeadChangeTo(String headChangeTo) {
        this.headChangeTo = headChangeTo == null ? null : headChangeTo.trim();
    }

    public String getHeadChangeSigner() {
        return headChangeSigner;
    }

    public void setHeadChangeSigner(String headChangeSigner) {
        this.headChangeSigner = headChangeSigner == null ? null : headChangeSigner.trim();
    }

    public Date getHeadChanegTime() {
        return headChanegTime;
    }

    public void setHeadChanegTime(Date headChanegTime) {
        this.headChanegTime = headChanegTime;
    }

    public Date getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Date delayTime) {
        this.delayTime = delayTime;
    }

    public String getDelayHead() {
        return delayHead;
    }

    public void setDelayHead(String delayHead) {
        this.delayHead = delayHead == null ? null : delayHead.trim();
    }

    public Date getDelayHeadSignTime() {
        return delayHeadSignTime;
    }

    public void setDelayHeadSignTime(Date delayHeadSignTime) {
        this.delayHeadSignTime = delayHeadSignTime;
    }

    public String getDelayLicensor() {
        return delayLicensor;
    }

    public void setDelayLicensor(String delayLicensor) {
        this.delayLicensor = delayLicensor == null ? null : delayLicensor.trim();
    }

    public Date getDelayLicensorSignTime() {
        return delayLicensorSignTime;
    }

    public void setDelayLicensorSignTime(Date delayLicensorSignTime) {
        this.delayLicensorSignTime = delayLicensorSignTime;
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

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getTicketEndLicensor() {
        return ticketEndLicensor;
    }

    public void setTicketEndLicensor(String ticketEndLicensor) {
        this.ticketEndLicensor = ticketEndLicensor == null ? null : ticketEndLicensor.trim();
    }

    public Date getTicketEndTime() {
        return ticketEndTime;
    }

    public void setTicketEndTime(Date ticketEndTime) {
        this.ticketEndTime = ticketEndTime;
    }

    public String getUnuseWireNumber() {
        return unuseWireNumber;
    }

    public void setUnuseWireNumber(String unuseWireNumber) {
        this.unuseWireNumber = unuseWireNumber == null ? null : unuseWireNumber.trim();
    }

    public Integer getUnuseWireNum() {
        return unuseWireNum;
    }

    public void setUnuseWireNum(Integer unuseWireNum) {
        this.unuseWireNum = unuseWireNum;
    }

    public Integer getKnifeCarNum() {
        return knifeCarNum;
    }

    public void setKnifeCarNum(Integer knifeCarNum) {
        this.knifeCarNum = knifeCarNum;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian == null ? null : guardian.trim();
    }

    public String getGuardianPlaceAndCont() {
        return guardianPlaceAndCont;
    }

    public void setGuardianPlaceAndCont(String guardianPlaceAndCont) {
        this.guardianPlaceAndCont = guardianPlaceAndCont == null ? null : guardianPlaceAndCont.trim();
    }

    public String getGuardianOtherThing() {
        return guardianOtherThing;
    }

    public void setGuardianOtherThing(String guardianOtherThing) {
        this.guardianOtherThing = guardianOtherThing == null ? null : guardianOtherThing.trim();
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getEvaluationCont() {
        return evaluationCont;
    }

    public void setEvaluationCont(String evaluationCont) {
        this.evaluationCont = evaluationCont == null ? null : evaluationCont.trim();
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }
}