package com.qz.zframe.device.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class Components {
	@ApiModelProperty(name = "componentId", value = "设备部件id", required = false)
	
    private String componentId;
	
	@ApiModelProperty(name = "equipmentAssetId", value = "设备资产台账id", required = false)

    private String equipmentAssetId;
	
	@ApiModelProperty(name = "componentCode", value = "部件编号", required = false)

    private String componentCode;
	
	@ApiModelProperty(name = "componentName", value = "部件名称", required = false)

    private String componentName;
	
	@ApiModelProperty(name = "specificationModel", value = "规格型号", required = false)

    private String specificationModel;
	
	@ApiModelProperty(name = "number", value = "数量", required = false)

    private BigDecimal number;
	
	@ApiModelProperty(name = "company", value = "单位", required = false)

    private String company;
	
	@ApiModelProperty(name = "remarks", value = "备注", required = false)

    private String remarks;

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId == null ? null : componentId.trim();
    }

    public String getEquipmentAssetId() {
        return equipmentAssetId;
    }

    public void setEquipmentAssetId(String equipmentAssetId) {
        this.equipmentAssetId = equipmentAssetId == null ? null : equipmentAssetId.trim();
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode == null ? null : componentCode.trim();
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName == null ? null : componentName.trim();
    }

    public String getSpecificationModel() {
        return specificationModel;
    }

    public void setSpecificationModel(String specificationModel) {
        this.specificationModel = specificationModel == null ? null : specificationModel.trim();
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}