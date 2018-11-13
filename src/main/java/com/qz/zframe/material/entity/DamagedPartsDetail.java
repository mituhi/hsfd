package com.qz.zframe.material.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class DamagedPartsDetail implements Serializable {
	
	private static final long serialVersionUID = 5759881383898571453L;

	@ApiModelProperty(name="damagedPartsDetailId",value="损坏件详情id",required=true)
	private String damagedPartsDetailId;

	@ApiModelProperty(name="damagedPartsId",value="损坏件id",required=true)
    private String damagedPartsId;

	@ApiModelProperty(name="materialId",value="物资id",required=true)
    private String materialId;

	@ApiModelProperty(name="storageNum",value="物资数量",required=true)
    private Integer storageNum;

	@ApiModelProperty(name="status",value="状态，01报废，02待核定",required=true)
    private String status;

	@ApiModelProperty(name="remark",value="说明备注",required=false)
    private String remark;

	@ApiModelProperty(name="materialCode",value="物资编码",required=false)
	private String materialCode;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=false)
	private String materialName;
	
	@ApiModelProperty(name="specifications",value="规格型号",required=false)
	private String specifications;
	
	@ApiModelProperty(name="measuringUnit",value="计量单位",required=false)
	private String measuringUnit; 
	
	
    public String getDamagedPartsDetailId() {
        return damagedPartsDetailId;
    }

    public void setDamagedPartsDetailId(String damagedPartsDetailId) {
        this.damagedPartsDetailId = damagedPartsDetailId == null ? null : damagedPartsDetailId.trim();
    }

    public String getDamagedPartsId() {
        return damagedPartsId;
    }

    public void setDamagedPartsId(String damagedPartsId) {
        this.damagedPartsId = damagedPartsId == null ? null : damagedPartsId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}
     
}