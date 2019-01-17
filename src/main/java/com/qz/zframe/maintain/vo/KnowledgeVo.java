package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeVo extends BreakdownKnowledgeBase {

    @ApiModelProperty(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiModelProperty(name = "breakdownLocationTitle", value = "故障位置名称", required = false)
    private String breakdownLocationTitle;

    @ApiModelProperty(name = "breakdownAttributeTitle", value = "故障属性名称", required = false)
    private String breakdownAttributeTitle;

    @ApiModelProperty(name = "statusName", value = "状态名称", required = false)
    private String statusName;

    @ApiModelProperty(name = "flowStatusName", value = "流程状态名称", required = false)
    private String flowStatusName;

    @ApiModelProperty(name = "examAndApprOpinion", value = "审批意见", required = false)
    private String examAndApprOpinion;

    @ApiModelProperty(name = "maintainerName", value = "维护人姓名", required = false)
    private String maintainerName;

    @ApiModelProperty(name = "applicantName", value = "维护人姓名", required = false)
    private String applicantName;

    @ApiModelProperty(name = "workorderProcessList", value = "工序List", required = true)
    private List<WorkorderProcess> workorderProcessList = new ArrayList<>();

    @ApiModelProperty(name = "workorderMaterialList", value = "物资List", required = false)
    private List<WorkorderMaterial> workorderMaterialList = new ArrayList<>();

    @ApiModelProperty(name = "workorderServiceList", value = "服务List", required = false)
    private List<WorkorderService> workorderServiceList = new ArrayList<>();

    @ApiModelProperty(name = "workorderToolList", value = "工器具List", required = false)
    private List<WorkorderTool> workorderToolList = new ArrayList<>();

    @ApiModelProperty(name = "workorderWorktypeList", value = "工种List", required = false)
    private List<WorkorderWorktype> workorderWorktypeList = new ArrayList<>();

    @ApiModelProperty(name = "workorderDangerPointList", value = "危险点控制List", required = false)
    private List<WorkorderDangerPoint> workorderDangerPointList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public List<WorkorderProcess> getWorkorderProcessList() {
        return workorderProcessList;
    }

    public void setWorkorderProcessList(List<WorkorderProcess> workorderProcessList) {
        this.workorderProcessList = workorderProcessList;
    }

    public List<WorkorderMaterial> getWorkorderMaterialList() {
        return workorderMaterialList;
    }

    public void setWorkorderMaterialList(List<WorkorderMaterial> workorderMaterialList) {
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

    public List<WorkorderDangerPoint> getWorkorderDangerPointList() {
        return workorderDangerPointList;
    }

    public void setWorkorderDangerPointList(List<WorkorderDangerPoint> workorderDangerPointList) {
        this.workorderDangerPointList = workorderDangerPointList;
    }
}
