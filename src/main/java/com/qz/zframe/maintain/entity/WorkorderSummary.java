package com.qz.zframe.maintain.entity;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.maintain.vo.FileInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class WorkorderSummary {

    @ApiModelProperty(name="summaryId",value="工单总结id",required=false)
    private String summaryId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="summaryProblemDesc",value="问题描述",required=false)
    private String summaryProblemDesc;

    @ApiModelProperty(name="summaryBreakdownPhenomenon",value="故障现象",required=false)
    private String summaryBreakdownPhenomenon;

    @ApiModelProperty(name="summaryBreakdownCause",value="故障原因",required=false)
    private String summaryBreakdownCause;

    @ApiModelProperty(name="summaryRepairBeforeCond",value="修前状况",required=false)
    private String summaryRepairBeforeCond;

    @ApiModelProperty(name="summaryRepairProcessDesc",value="处理过程描述",required=false)
    private String summaryRepairProcessDesc;

    @ApiModelProperty(name="summaryCauseAnalysis",value="原因分析",required=false)
    private String summaryCauseAnalysis;

    @ApiModelProperty(name="summarySolution",value="解决方案",required=false)
    private String summarySolution;

    @ApiModelProperty(name="summaryKonwledgeApply",value="故障知识申请",required=false)
    private String summaryKonwledgeApply;

    @ApiModelProperty(name="summaryAttachment",value="附件",required=false)
    private String summaryAttachment;

    @ApiModelProperty(name = "summaryAttachmentList", value = "工单总结附件列表", required = false)
    private List<FileInfo> summaryAttachmentList = new ArrayList<>();

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
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

    public String getSummaryProblemDesc() {
        return summaryProblemDesc;
    }

    public void setSummaryProblemDesc(String summaryProblemDesc) {
        this.summaryProblemDesc = summaryProblemDesc == null ? null : summaryProblemDesc.trim();
    }

    public String getSummaryBreakdownPhenomenon() {
        return summaryBreakdownPhenomenon;
    }

    public void setSummaryBreakdownPhenomenon(String summaryBreakdownPhenomenon) {
        this.summaryBreakdownPhenomenon = summaryBreakdownPhenomenon == null ? null : summaryBreakdownPhenomenon.trim();
    }

    public String getSummaryBreakdownCause() {
        return summaryBreakdownCause;
    }

    public void setSummaryBreakdownCause(String summaryBreakdownCause) {
        this.summaryBreakdownCause = summaryBreakdownCause == null ? null : summaryBreakdownCause.trim();
    }

    public String getSummaryRepairBeforeCond() {
        return summaryRepairBeforeCond;
    }

    public void setSummaryRepairBeforeCond(String summaryRepairBeforeCond) {
        this.summaryRepairBeforeCond = summaryRepairBeforeCond == null ? null : summaryRepairBeforeCond.trim();
    }

    public String getSummaryRepairProcessDesc() {
        return summaryRepairProcessDesc;
    }

    public void setSummaryRepairProcessDesc(String summaryRepairProcessDesc) {
        this.summaryRepairProcessDesc = summaryRepairProcessDesc == null ? null : summaryRepairProcessDesc.trim();
    }

    public String getSummaryCauseAnalysis() {
        return summaryCauseAnalysis;
    }

    public void setSummaryCauseAnalysis(String summaryCauseAnalysis) {
        this.summaryCauseAnalysis = summaryCauseAnalysis == null ? null : summaryCauseAnalysis.trim();
    }

    public String getSummarySolution() {
        return summarySolution;
    }

    public void setSummarySolution(String summarySolution) {
        this.summarySolution = summarySolution == null ? null : summarySolution.trim();
    }

    public String getSummaryKonwledgeApply() {
        return summaryKonwledgeApply;
    }

    public void setSummaryKonwledgeApply(String summaryKonwledgeApply) {
        this.summaryKonwledgeApply = summaryKonwledgeApply == null ? null : summaryKonwledgeApply.trim();
    }

    public String getSummaryAttachment() {
        return summaryAttachment;
    }

    public void setSummaryAttachment(String summaryAttachment) {
        this.summaryAttachment = summaryAttachment == null ? null : summaryAttachment.trim();
    }

    public List<FileInfo> getSummaryAttachmentList() {
        return summaryAttachmentList;
    }

    public void setSummaryAttachmentList(List<FileInfo> summaryAttachmentList) {
        this.summaryAttachmentList = summaryAttachmentList;
    }
}