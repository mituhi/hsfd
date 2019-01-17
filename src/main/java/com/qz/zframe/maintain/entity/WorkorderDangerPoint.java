package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiModelProperty;

public class WorkorderDangerPoint {

    @ApiModelProperty(name="dangerPointId",value="危险点id",required=false)
    private String dangerPointId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="workorderId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="dangerNumber",value="编号",required=false)
    private String dangerNumber;

    @ApiModelProperty(name="dangerDangerSource",value="危险源",required=false)
    private String dangerDangerSource;

    @ApiModelProperty(name="dangerPreMeasures",value="危险点预控措施",required=false)
    private String dangerPreMeasures;

    public String getDangerPointId() {
        return dangerPointId;
    }

    public void setDangerPointId(String dangerPointId) {
        this.dangerPointId = dangerPointId == null ? null : dangerPointId.trim();
    }

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDangerNumber() {
        return dangerNumber;
    }

    public void setDangerNumber(String dangerNumber) {
        this.dangerNumber = dangerNumber == null ? null : dangerNumber.trim();
    }

    public String getDangerDangerSource() {
        return dangerDangerSource;
    }

    public void setDangerDangerSource(String dangerDangerSource) {
        this.dangerDangerSource = dangerDangerSource == null ? null : dangerDangerSource.trim();
    }

    public String getDangerPreMeasures() {
        return dangerPreMeasures;
    }

    public void setDangerPreMeasures(String dangerPreMeasures) {
        this.dangerPreMeasures = dangerPreMeasures == null ? null : dangerPreMeasures.trim();
    }
}