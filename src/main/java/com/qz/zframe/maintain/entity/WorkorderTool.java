package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class WorkorderTool {

    @ApiParam(name="toolId",value="工器具id",required=false)
    private String toolId;

    @ApiParam(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiParam(name="knowledgeId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiParam(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiParam(name="toolNumber",value="工器具编码",required=false)
    private String toolNumber;

    @ApiParam(name="toolDesc",value="工器具描述",required=false)
    private String toolDesc;

    @ApiParam(name="toolPlanAmount",value="计划数量",required=false)
    private String toolPlanAmount;

    @ApiParam(name="toolUnit",value="单位",required=false)
    private String toolUnit;

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId == null ? null : toolId.trim();
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

    public String getToolNumber() {
        return toolNumber;
    }

    public void setToolNumber(String toolNumber) {
        this.toolNumber = toolNumber == null ? null : toolNumber.trim();
    }

    public String getToolDesc() {
        return toolDesc;
    }

    public void setToolDesc(String toolDesc) {
        this.toolDesc = toolDesc == null ? null : toolDesc.trim();
    }

    public String getToolPlanAmount() {
        return toolPlanAmount;
    }

    public void setToolPlanAmount(String toolPlanAmount) {
        this.toolPlanAmount = toolPlanAmount == null ? null : toolPlanAmount.trim();
    }

    public String getToolUnit() {
        return toolUnit;
    }

    public void setToolUnit(String toolUnit) {
        this.toolUnit = toolUnit == null ? null : toolUnit.trim();
    }
}