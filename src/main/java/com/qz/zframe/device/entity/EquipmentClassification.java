package com.qz.zframe.device.entity;

public class EquipmentClassification {
    private String equipmentId;

    private String equipmentType;

    private String typeName;

    private String superiorEquipment;

    private String superiorEquipmentDescribe;

    private String superiorEquipmentName;

    private String status;

    private String isToplevel;

    private String equipmentTypeDescribe;

    private String outputId;

    private String runId;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getSuperiorEquipment() {
        return superiorEquipment;
    }

    public void setSuperiorEquipment(String superiorEquipment) {
        this.superiorEquipment = superiorEquipment == null ? null : superiorEquipment.trim();
    }

    public String getSuperiorEquipmentDescribe() {
        return superiorEquipmentDescribe;
    }

    public void setSuperiorEquipmentDescribe(String superiorEquipmentDescribe) {
        this.superiorEquipmentDescribe = superiorEquipmentDescribe == null ? null : superiorEquipmentDescribe.trim();
    }

    public String getSuperiorEquipmentName() {
        return superiorEquipmentName;
    }

    public void setSuperiorEquipmentName(String superiorEquipmentName) {
        this.superiorEquipmentName = superiorEquipmentName == null ? null : superiorEquipmentName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsToplevel() {
        return isToplevel;
    }

    public void setIsToplevel(String isToplevel) {
        this.isToplevel = isToplevel == null ? null : isToplevel.trim();
    }

    public String getEquipmentTypeDescribe() {
        return equipmentTypeDescribe;
    }

    public void setEquipmentTypeDescribe(String equipmentTypeDescribe) {
        this.equipmentTypeDescribe = equipmentTypeDescribe == null ? null : equipmentTypeDescribe.trim();
    }

    public String getOutputId() {
        return outputId;
    }

    public void setOutputId(String outputId) {
        this.outputId = outputId == null ? null : outputId.trim();
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId == null ? null : runId.trim();
    }

}