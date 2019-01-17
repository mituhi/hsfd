package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiModelProperty;

public class WorkorderQualityAcceptance {

    @ApiModelProperty(name="qualityAcceptanceId",value="质量验收id",required=false)
    private String qualityAcceptanceId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="acceptanceEvaluation",value="验收评价",required=false)
    private String acceptanceEvaluation;

    @ApiModelProperty(name="acceptanceRemark",value="备注",required=false)
    private String acceptanceRemark;

    public String getQualityAcceptanceId() {
        return qualityAcceptanceId;
    }

    public void setQualityAcceptanceId(String qualityAcceptanceId) {
        this.qualityAcceptanceId = qualityAcceptanceId == null ? null : qualityAcceptanceId.trim();
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

    public String getAcceptanceEvaluation() {
        return acceptanceEvaluation;
    }

    public void setAcceptanceEvaluation(String acceptanceEvaluation) {
        this.acceptanceEvaluation = acceptanceEvaluation == null ? null : acceptanceEvaluation.trim();
    }

    public String getAcceptanceRemark() {
        return acceptanceRemark;
    }

    public void setAcceptanceRemark(String acceptanceRemark) {
        this.acceptanceRemark = acceptanceRemark == null ? null : acceptanceRemark.trim();
    }
}