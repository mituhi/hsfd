package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketVo extends WorkTicket{

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="crewName",value="机组名称",required=false)
    private String crewName;

    @ApiModelProperty(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiModelProperty(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiModelProperty(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeNumber;

    @ApiModelProperty(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeName;

    @ApiModelProperty(name="standardTicketName",value="标准工作票名称",required=false)
    private String standardTicketName;

    @ApiModelProperty(name="statusName",value="状态名称",required=false)
    private String statusName;

    @ApiModelProperty(name="flowStatusName",value="流程节点名称",required=false)
    private String flowStatusName;

    @ApiModelProperty(name="workTeamName",value="工作班组名称",required=false)
    private String workTeamName;

    @ApiModelProperty(name = "examAndApprOpinion", value = "审批意见", required = false)
    private String examAndApprOpinion;

    @ApiModelProperty(name="maintainerName",value="维护人姓名",required=false)
    private String maintainerName;

    @ApiModelProperty(name="applicantName",value="申请人姓名",required=false)
    private String applicantName;

    @ApiModelProperty(name="workHeadName",value="工作负责人姓名",required=false)
    private String workHeadName;

    @ApiModelProperty(name="workMemberNames",value="工作成员姓名",required=false)
    private String workMemberNames;

    @ApiModelProperty(name="signerName",value="签发人姓名",required=false)
    private String signerName;

    @ApiModelProperty(name="runMainPersonName",value="运维人员姓名",required=false)
    private String runMainPersonName;

    @ApiModelProperty(name="receiveHeadName",value="收到工作票工作负责人姓名",required=false)
    private String receiveHeadName;

    @ApiModelProperty(name="sceneLicensorName",value="现场许可人姓名",required=false)
    private String sceneLicensorName;

    @ApiModelProperty(name="runLicensorName",value="运行值班许可人姓名",required=false)
    private String runLicensorName;

    @ApiModelProperty(name="headChangeToName",value="变更的负责人姓名",required=false)
    private String headChangeToName;

    @ApiModelProperty(name="headChangeSignerName",value="变更的签发人姓名",required=false)
    private String headChangeSignerName;

    @ApiModelProperty(name="delayHeadName",value="延期工作负责人姓名",required=false)
    private String delayHeadName;

    @ApiModelProperty(name="delayLicensorName",value="延期许可人姓名",required=false)
    private String delayLicensorName;

    @ApiModelProperty(name="workEndHeadName",value="工作结束工作负责人姓名",required=false)
    private String workEndHeadName;

    @ApiModelProperty(name="workEndLicensorName",value="工作结束许可人姓名",required=false)
    private String workEndLicensorName;

    @ApiModelProperty(name="ticketEndLicensorName",value="工作票终结许可人姓名",required=false)
    private String ticketEndLicensorName;

    @ApiModelProperty(name="guardianName",value="专职监护人姓名",required=false)
    private String guardianName;

    @ApiModelProperty(name="evaluationName",value="评价人姓名",required=false)
    private String evaluationName;

    @ApiModelProperty(name="maintainerName",value="安全措施list",required=false)
    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

    @ApiModelProperty(name="RiskControlList",value="危险因素控制措施list",required=false)
    private List<WorkTicketRiskControlVo> RiskControlList = new ArrayList<>();

    @ApiModelProperty(name="maintainerName",value="开工收工时间list",required=false)
    private List<WorkTicketWorkTimeVo> workTimeList = new ArrayList<>();

    @ApiModelProperty(name="workMemberNames",value="工作成员names",required=false)
    private String[] workMemberNames2;

    @ApiModelProperty(name="流程步数",value="flowSort",required=false)
    private String flowSort;

    @ApiModelProperty(name="流程名称",value="flowName",required=false)
    private String flowName;

    public String[] getWorkMemberNames2() {
        return workMemberNames2;
    }

    public void setWorkMemberNames2(String[] workMemberNames2) {
        this.workMemberNames2 = workMemberNames2;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getTicketTypeNumber() {
        return ticketTypeNumber;
    }

    public void setTicketTypeNumber(String ticketTypeNumber) {
        this.ticketTypeNumber = ticketTypeNumber;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getStandardTicketName() {
        return standardTicketName;
    }

    public void setStandardTicketName(String standardTicketName) {
        this.standardTicketName = standardTicketName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getFlowStatusName() {
        return flowStatusName;
    }

    public void setFlowStatusName(String flowStatusName) {
        this.flowStatusName = flowStatusName;
    }

    public String getWorkTeamName() {
        return workTeamName;
    }

    public void setWorkTeamName(String workTeamName) {
        this.workTeamName = workTeamName;
    }

    public String getExamAndApprOpinion() {
        return examAndApprOpinion;
    }

    public void setExamAndApprOpinion(String examAndApprOpinion) {
        this.examAndApprOpinion = examAndApprOpinion;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getWorkHeadName() {
        return workHeadName;
    }

    public void setWorkHeadName(String workHeadName) {
        this.workHeadName = workHeadName;
    }

    public String getWorkMemberNames() {
        return workMemberNames;
    }

    public void setWorkMemberNames(String workMemberNames) {
        this.workMemberNames = workMemberNames;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public String getRunMainPersonName() {
        return runMainPersonName;
    }

    public void setRunMainPersonName(String runMainPersonName) {
        this.runMainPersonName = runMainPersonName;
    }

    public String getReceiveHeadName() {
        return receiveHeadName;
    }

    public void setReceiveHeadName(String receiveHeadName) {
        this.receiveHeadName = receiveHeadName;
    }

    public String getSceneLicensorName() {
        return sceneLicensorName;
    }

    public void setSceneLicensorName(String sceneLicensorName) {
        this.sceneLicensorName = sceneLicensorName;
    }

    public String getRunLicensorName() {
        return runLicensorName;
    }

    public void setRunLicensorName(String runLicensorName) {
        this.runLicensorName = runLicensorName;
    }

    public String getHeadChangeToName() {
        return headChangeToName;
    }

    public void setHeadChangeToName(String headChangeToName) {
        this.headChangeToName = headChangeToName;
    }

    public String getHeadChangeSignerName() {
        return headChangeSignerName;
    }

    public void setHeadChangeSignerName(String headChangeSignerName) {
        this.headChangeSignerName = headChangeSignerName;
    }

    public String getDelayHeadName() {
        return delayHeadName;
    }

    public void setDelayHeadName(String delayHeadName) {
        this.delayHeadName = delayHeadName;
    }

    public String getDelayLicensorName() {
        return delayLicensorName;
    }

    public void setDelayLicensorName(String delayLicensorName) {
        this.delayLicensorName = delayLicensorName;
    }

    public String getWorkEndHeadName() {
        return workEndHeadName;
    }

    public void setWorkEndHeadName(String workEndHeadName) {
        this.workEndHeadName = workEndHeadName;
    }

    public String getWorkEndLicensorName() {
        return workEndLicensorName;
    }

    public void setWorkEndLicensorName(String workEndLicensorName) {
        this.workEndLicensorName = workEndLicensorName;
    }

    public String getTicketEndLicensorName() {
        return ticketEndLicensorName;
    }

    public void setTicketEndLicensorName(String ticketEndLicensorName) {
        this.ticketEndLicensorName = ticketEndLicensorName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public void setEvaluationName(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<WorkTicketRiskControlVo> getRiskControlList() {
        return RiskControlList;
    }

    public void setRiskControlList(List<WorkTicketRiskControlVo> riskControlList) {
        RiskControlList = riskControlList;
    }

    public List<WorkTicketWorkTimeVo> getWorkTimeList() {
        return workTimeList;
    }

    public void setWorkTimeList(List<WorkTicketWorkTimeVo> workTimeList) {
        this.workTimeList = workTimeList;
    }

    public String getFlowSort() {
        return flowSort;
    }

    public void setFlowSort(String flowSort) {
        this.flowSort = flowSort;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
}
