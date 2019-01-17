package com.qz.zframe.material.entity;

public class WorkOrderMaterials {
    private String workorderMaterialId;

    private String workorderId;

    private String knowledgeId;

    private String orderId;

    private String inventoryId;

    private String materialId;

    private String materialPlanAmount;

    private String materialActualAmount;

    private String materialActualMoney;

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

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getMaterialPlanAmount() {
        return materialPlanAmount;
    }

    public void setMaterialPlanAmount(String materialPlanAmount) {
        this.materialPlanAmount = materialPlanAmount == null ? null : materialPlanAmount.trim();
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

    public String getFinalReceiveMaterial() {
        return finalReceiveMaterial;
    }

    public void setFinalReceiveMaterial(String finalReceiveMaterial) {
        this.finalReceiveMaterial = finalReceiveMaterial == null ? null : finalReceiveMaterial.trim();
    }
}