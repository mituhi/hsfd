package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class BreakdownKnowledgeBase {

    @ApiModelProperty(name = "knowledgeId", value = "故障id", required = false)
    private String knowledgeId;

    @ApiModelProperty(name = "serialNumber", value = "故障知识编码(流水号)", required = false)
    private String serialNumber;

    @ApiModelProperty(name = "knowledgeDesc", value = "故障知识描述", required = false)
    private String knowledgeDesc;

    @ApiModelProperty(name = "knowledgeName", value = "故障知识名称", required = false)
    private String knowledgeName;

    @ApiModelProperty(name = "maintainer", value = "维护人id", required = true)
    private String maintainer;

    @ApiModelProperty(name = "maintainDate", value = "维护日期", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name = "status", value = "状态", required = false)
    private String status;

    @ApiModelProperty(name = "flowStatus", value = "流程状态", required = false)
    private String flowStatus;

    @ApiModelProperty(name = "breakdownLocation", value = "故障位置id", required = true)
    private String breakdownLocation;

    @ApiModelProperty(name = "breakdownAttribute", value = "故障属性id", required = true)
    private String breakdownAttribute;

    @ApiModelProperty(name = "breakdownCode", value = "故障代码", required = true)
    private String breakdownCode;

    @ApiModelProperty(name = "breakdownDesc", value = "故障描述", required = true)
    private String breakdownDesc;

    @ApiModelProperty(name = "windId", value = "风电场id", required = true)
    private String windId;

    @ApiModelProperty(name = "applicant", value = "申请人id", required = true)
    private String applicant;

    @ApiModelProperty(name = "applyTime", value = "申请时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date applyTime;

    @ApiModelProperty(name = "defectPhenomenon", value = "缺陷现象", required = true)
    private String defectPhenomenon;

    @ApiModelProperty(name = "causeAnalysis", value = "原因分析", required = true)
    private String causeAnalysis;

    @ApiModelProperty(name = "repairProcessDesc", value = "处理过程描述", required = true)
    private String repairProcessDesc;

    @ApiModelProperty(name = "solution", value = "解决方案", required = true)
    private String solution;

    @ApiModelProperty(name = "remark", value = "备注", required = false)
    private String remark;

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getKnowledgeDesc() {
        return knowledgeDesc;
    }

    public void setKnowledgeDesc(String knowledgeDesc) {
        this.knowledgeDesc = knowledgeDesc == null ? null : knowledgeDesc.trim();
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName == null ? null : knowledgeName.trim();
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

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
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

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDefectPhenomenon() {
        return defectPhenomenon;
    }

    public void setDefectPhenomenon(String defectPhenomenon) {
        this.defectPhenomenon = defectPhenomenon == null ? null : defectPhenomenon.trim();
    }

    public String getCauseAnalysis() {
        return causeAnalysis;
    }

    public void setCauseAnalysis(String causeAnalysis) {
        this.causeAnalysis = causeAnalysis == null ? null : causeAnalysis.trim();
    }

    public String getRepairProcessDesc() {
        return repairProcessDesc;
    }

    public void setRepairProcessDesc(String repairProcessDesc) {
        this.repairProcessDesc = repairProcessDesc == null ? null : repairProcessDesc.trim();
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}