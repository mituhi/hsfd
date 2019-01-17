package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateItem;
import com.qz.zframe.tickets.entity.OperateTicket;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class OperateTicketVo extends OperateTicket {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="crewName",value="机组名称",required=false)
    private String crewName;

    @ApiModelProperty(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiModelProperty(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiModelProperty(name="ticketTypeName",value="操作票类型名称",required=false)
    private String ticketTypeName;

    @ApiModelProperty(name="typicalTicketName",value="典型操作票名称",required=false)
    private String typicalTicketName;

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

    @ApiModelProperty(name="senderName",value="发令人姓名",required=false)
    private String senderName;

    @ApiModelProperty(name="receiverName",value="收令人姓名",required=false)
    private String receiverName;

    @ApiModelProperty(name="executerName",value="操作人姓名",required=false)
    private String executerName;

    @ApiModelProperty(name="supervisiorName",value="监护人姓名",required=false)
    private String supervisiorName;

    @ApiModelProperty(name="operateItemList",value="操作项list",required=false)
    private List<OperateItem> operateItemList = new ArrayList<>();

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

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getTypicalTicketName() {
        return typicalTicketName;
    }

    public void setTypicalTicketName(String typicalTicketName) {
        this.typicalTicketName = typicalTicketName;
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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getExecuterName() {
        return executerName;
    }

    public void setExecuterName(String executerName) {
        this.executerName = executerName;
    }

    public String getSupervisiorName() {
        return supervisiorName;
    }

    public void setSupervisiorName(String supervisiorName) {
        this.supervisiorName = supervisiorName;
    }

    public List<OperateItem> getOperateItemList() {
        return operateItemList;
    }

    public void setOperateItemList(List<OperateItem> operateItemList) {
        this.operateItemList = operateItemList;
    }
}
