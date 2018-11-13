package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class WorkorderMaterial {

    @ApiParam(name="workorderMaterialId",value="工单物资id",required=false)
    private String workorderMaterialId;

    @ApiParam(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiParam(name="knowledgeId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiParam(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiParam(name="materialNumber",value="物资编码",required=false)
    private String materialNumber;

    @ApiParam(name="materialDesc",value="物资描述",required=false)
    private String materialDesc;

    @ApiParam(name="materialUnit",value="单位",required=false)
    private String materialUnit;

    @ApiParam(name="materialPlanAmount",value="计划数量",required=false)
    private String materialPlanAmount;

    @ApiParam(name="materialCost",value="成本单价",required=false)
    private String materialCost;

    @ApiParam(name="materialActualAmount",value="实际数量",required=false)
    private String materialActualAmount;

    @ApiParam(name="materialActualMoney",value="实际金额",required=false)
    private String materialActualMoney;

    @ApiParam(name="materialWindName",value="风电场名称",required=false)
    private String materialWindName;

    @ApiParam(name="finalReceiveMaterial",value="最终收货",required=false)
    private String finalReceiveMaterial;

    public String getWorkorderMaterialId() {
        return workorderMaterialId;
    }

    public void setWorkorderMaterialId(String workorderMaterialId) {
        this.workorderMaterialId = workorderMaterialId == null ? null : workorderMaterialId.trim();
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

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber == null ? null : materialNumber.trim();
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc == null ? null : materialDesc.trim();
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit == null ? null : materialUnit.trim();
    }

    public String getMaterialPlanAmount() {
        return materialPlanAmount;
    }

    public void setMaterialPlanAmount(String materialPlanAmount) {
        this.materialPlanAmount = materialPlanAmount == null ? null : materialPlanAmount.trim();
    }

    public String getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(String materialCost) {
        this.materialCost = materialCost == null ? null : materialCost.trim();
    }

    public String getMaterialActualAmount() {
        return materialActualAmount;
    }

    public void setMaterialActualAmount(String materialActualAmount) {
        this.materialActualAmount = materialActualAmount == null ? null : materialActualAmount.trim();
    }

    public String getMaterialActualMoney() {
        return materialActualMoney;
    }

    public void setMaterialActualMoney(String materialActualMoney) {
        this.materialActualMoney = materialActualMoney == null ? null : materialActualMoney.trim();
    }

    public String getMaterialWindName() {
        return materialWindName;
    }

    public void setMaterialWindName(String materialWindName) {
        this.materialWindName = materialWindName == null ? null : materialWindName.trim();
    }

    public String getFinalReceiveMaterial() {
        return finalReceiveMaterial;
    }

    public void setFinalReceiveMaterial(String finalReceiveMaterial) {
        this.finalReceiveMaterial = finalReceiveMaterial == null ? null : finalReceiveMaterial.trim();
    }
}