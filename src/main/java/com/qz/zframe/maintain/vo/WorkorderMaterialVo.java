package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.WorkorderMaterial;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class WorkorderMaterialVo extends WorkorderMaterial {

    @ApiModelProperty(name="materialCode",value="物资编码",required=false)
    private String materialCode;

    @ApiModelProperty(name="materialName",value="物资名称",required=false)
    private String materialName;

    @ApiModelProperty(name="materialDesc",value="物资描述",required=false)
    private String materialDesc;

    @ApiModelProperty(name="unit",value="单位",required=false)
    private String unit;

    @ApiModelProperty(name="cost",value="移动评价价",required=false)
    private BigDecimal cost;

    @ApiModelProperty(name="windId",value="风电场id",required=false)
    private String windId;

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="stockAddId",value="库存地id",required=false)
    private String stockAddId;

    @ApiModelProperty(name="stockAddName",value="库存地名称",required=false)
    private String stockAddName;

    @ApiModelProperty(name="unitName",value="单位名称",required=false)
    private String unitName;

    @ApiModelProperty(name="specifications",value="规格",required=false)
    private String specifications;

    @ApiModelProperty(name="inventoryNum",value="库存数量",required=false)
    private String inventoryNum;

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId;
    }

    public String getStockAddName() {
        return stockAddName;
    }

    public void setStockAddName(String stockAddName) {
        this.stockAddName = stockAddName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(String inventoryNum) {
        this.inventoryNum = inventoryNum;
    }
}
