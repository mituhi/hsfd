package com.qz.zframe.maintain.vo;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.maintain.entity.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class DefectWorkorderVo extends DefectWorkorder {

    @ApiModelProperty(name = "flowSort", value = "流程步数", required = false)
    private String flowSort;

    @ApiModelProperty(name = "pictureList", value = "图片数组", required = false)
    private List<FileInfo> pictureList;

    @ApiModelProperty(name = "attachmentList", value = "附件数组", required = false)
    private List<FileInfo> attachmentList;

    @ApiModelProperty(name = "unitMemberNames", value = "本单位工作组人员姓名", required = false)
    private String unitMemberNames;

    @ApiModelProperty(name = "unitMemberArray", value = "本单位工作组人员id数组", required = false)
    private String[] unitMemberArray;

    @ApiModelProperty(name = "fileIds", value = "文件id数组", required = false)
    private String[] fileIds;

    @ApiModelProperty(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiModelProperty(name = "positionName", value = "位置名称", required = false)
    private String positionName;

    @ApiModelProperty(name = "crewName", value = "机组名称", required = false)
    private String crewName;

    @ApiModelProperty(name = "equipmentName", value = "设备名称", required = false)
    private String equipmentName;

    @ApiModelProperty(name = "workorderTypeName", value = "工单类型名称", required = false)
    private String workorderTypeName;

    @ApiModelProperty(name = "breakdownLocationTitle", value = "故障位置名称", required = false)
    private String breakdownLocationTitle;

    @ApiModelProperty(name = "breakdownAttributeTitle", value = "故障属性名称", required = false)
    private String breakdownAttributeTitle;

    @ApiModelProperty(name = "dealModeTitle", value = "工单类型名称", required = false)
    private String dealModeTitle;

    @ApiModelProperty(name = "statusName", value = "状态名称", required = false)
    private String statusName;

    @ApiModelProperty(name = "flowStatusName", value = "流程节点名称", required = false)
    private String flowStatusName;

    @ApiModelProperty(name = "examAndApprOpinion", value = "审批意见", required = false)
    private String examAndApprOpinion;

    @ApiModelProperty(name = "maintainerName", value = "维护人姓名", required = false)
    private String maintainerName;

    @ApiModelProperty(name = "dutyHeadName", value = "负责人姓名", required = false)
    private String dutyHeadName;

    @ApiModelProperty(name = "fillPersonName", value = "填报人姓名", required = false)
    private String fillPersonName;

    @ApiModelProperty(name = "workorderQualityAcceptance", value = "质量验收", required = false)
    private WorkorderQualityAcceptance workorderQualityAcceptance;

    @ApiModelProperty(name = "workorderDangerPointList", value = "危险点控制List", required = false)
    private List<WorkorderDangerPoint> workorderDangerPointList = new ArrayList<>();

    @ApiModelProperty(name = "companyName", value = "公司名称", required = false)
    private String companyName;

    @ApiModelProperty(name = "departmentName", value = "部门名称", required = false)
    private String departmentName;

    @ApiModelProperty(name = "dutyTeamName", value = "负责班组名称", required = false)
    private String dutyTeamName;

    @ApiModelProperty(name = "workorderProcessList", value = "工序List", required = true)
    private List<WorkorderProcess> workorderProcessList = new ArrayList<>();

    @ApiModelProperty(name = "workorderMaterialList", value = "物资List", required = false)
    private List<WorkorderMaterialVo> workorderMaterialList = new ArrayList<>();

    @ApiModelProperty(name = "workorderServiceList", value = "服务List", required = false)
    private List<WorkorderService> workorderServiceList = new ArrayList<>();

    @ApiModelProperty(name = "workorderToolList", value = "工器具List", required = false)
    private List<WorkorderTool> workorderToolList = new ArrayList<>();

    @ApiModelProperty(name = "workorderWorktypeList", value = "工种List", required = false)
    private List<WorkorderWorktype> workorderWorktypeList = new ArrayList<>();

    @ApiModelProperty(name = "workorderSummary", value = "工单总结", required = false)
    private WorkorderSummary workorderSummary;

    @ApiModelProperty(name = "workTicketForWorkorederVoList", value = "关联工作票list", required = false)
    private List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList = new ArrayList<>();

    @ApiModelProperty(name = "operateTicketForWorkorderVoList", value = "关联操作票list", required = false)
    private List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList = new ArrayList<>();

    public String getUnitMemberNames() {
        return unitMemberNames;
    }

    public void setUnitMemberNames(String unitMemberNames) {
        this.unitMemberNames = unitMemberNames;
    }

    public String[] getUnitMemberArray() {
        return unitMemberArray;
    }

    public void setUnitMemberArray(String[] unitMemberArray) {
        this.unitMemberArray = unitMemberArray;
    }

    public String[] getFileIds() {
        return fileIds;
    }

    public void setFileIds(String[] fileIds) {
        this.fileIds = fileIds;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getWorkorderTypeName() {
        return workorderTypeName;
    }

    public void setWorkorderTypeName(String workorderTypeName) {
        this.workorderTypeName = workorderTypeName;
    }

    public String getBreakdownLocationTitle() {
        return breakdownLocationTitle;
    }

    public void setBreakdownLocationTitle(String breakdownLocationTitle) {
        this.breakdownLocationTitle = breakdownLocationTitle;
    }

    public String getBreakdownAttributeTitle() {
        return breakdownAttributeTitle;
    }

    public void setBreakdownAttributeTitle(String breakdownAttributeTitle) {
        this.breakdownAttributeTitle = breakdownAttributeTitle;
    }

    public String getDealModeTitle() {
        return dealModeTitle;
    }

    public void setDealModeTitle(String dealModeTitle) {
        this.dealModeTitle = dealModeTitle;
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

    public String getDutyHeadName() {
        return dutyHeadName;
    }

    public void setDutyHeadName(String dutyHeadName) {
        this.dutyHeadName = dutyHeadName;
    }

    public String getFillPersonName() {
        return fillPersonName;
    }

    public void setFillPersonName(String fillPersonName) {
        this.fillPersonName = fillPersonName;
    }

    public WorkorderQualityAcceptance getWorkorderQualityAcceptance() {
        return workorderQualityAcceptance;
    }

    public void setWorkorderQualityAcceptance(WorkorderQualityAcceptance workorderQualityAcceptance) {
        this.workorderQualityAcceptance = workorderQualityAcceptance;
    }

    public List<WorkorderDangerPoint> getWorkorderDangerPointList() {
        return workorderDangerPointList;
    }

    public void setWorkorderDangerPointList(List<WorkorderDangerPoint> workorderDangerPointList) {
        this.workorderDangerPointList = workorderDangerPointList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDutyTeamName() {
        return dutyTeamName;
    }

    public void setDutyTeamName(String dutyTeamName) {
        this.dutyTeamName = dutyTeamName;
    }

    public List<WorkorderProcess> getWorkorderProcessList() {
        return workorderProcessList;
    }

    public void setWorkorderProcessList(List<WorkorderProcess> workorderProcessList) {
        this.workorderProcessList = workorderProcessList;
    }

    public List<WorkorderMaterialVo> getWorkorderMaterialList() {
        return workorderMaterialList;
    }

    public void setWorkorderMaterialList(List<WorkorderMaterialVo> workorderMaterialList) {
        this.workorderMaterialList = workorderMaterialList;
    }

    public List<WorkorderService> getWorkorderServiceList() {
        return workorderServiceList;
    }

    public void setWorkorderServiceList(List<WorkorderService> workorderServiceList) {
        this.workorderServiceList = workorderServiceList;
    }

    public List<WorkorderTool> getWorkorderToolList() {
        return workorderToolList;
    }

    public void setWorkorderToolList(List<WorkorderTool> workorderToolList) {
        this.workorderToolList = workorderToolList;
    }

    public List<WorkorderWorktype> getWorkorderWorktypeList() {
        return workorderWorktypeList;
    }

    public void setWorkorderWorktypeList(List<WorkorderWorktype> workorderWorktypeList) {
        this.workorderWorktypeList = workorderWorktypeList;
    }

    public WorkorderSummary getWorkorderSummary() {
        return workorderSummary;
    }

    public void setWorkorderSummary(WorkorderSummary workorderSummary) {
        this.workorderSummary = workorderSummary;
    }

    public List<WorkTicketForWorkorederVo> getWorkTicketForWorkorederVoList() {
        return workTicketForWorkorederVoList;
    }

    public void setWorkTicketForWorkorederVoList(List<WorkTicketForWorkorederVo> workTicketForWorkorederVoList) {
        this.workTicketForWorkorederVoList = workTicketForWorkorederVoList;
    }

    public List<OperateTicketForWorkorderVo> getOperateTicketForWorkorderVoList() {
        return operateTicketForWorkorderVoList;
    }

    public void setOperateTicketForWorkorderVoList(List<OperateTicketForWorkorderVo> operateTicketForWorkorderVoList) {
        this.operateTicketForWorkorderVoList = operateTicketForWorkorderVoList;
    }

    public List<FileInfo> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<FileInfo> pictureList) {
        this.pictureList = pictureList;
    }

    public List<FileInfo> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<FileInfo> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getFlowSort() {
        return flowSort;
    }

    public void setFlowSort(String flowSort) {
        this.flowSort = flowSort;
    }
}
