package com.qz.zframe.material.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class DamagedAuditDetail implements Serializable {
    
	private static final long serialVersionUID = -4681814524155709271L;

	
	@ApiModelProperty(name="damagedAuditDetailId",value="损坏件审核详情id",required=true)
	private String damagedAuditDetailId;

	@ApiModelProperty(name="damagedAuditId",value="损坏件审核id",required=true)
    private String damagedAuditId;

	@ApiModelProperty(name="damagedPartsDetailId",value="损坏件详情id",required=true)
    private String damagedPartsDetailId;

	@ApiModelProperty(name="auditStatus",value="审核状态，01送出维修，02报废",required=true)
    private String auditStatus;

	@ApiModelProperty(name="auditNum",value="审核数量",required=false)
    private Integer auditNum;

	@ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;
	
	@ApiModelProperty(name="materialCode",value="物资编码",required=false)
	private String materialCode;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=false)
	private String materialName;
	
	@ApiModelProperty(name="specifications",value="规格型号",required=false)
	private String specifications;
	
	@ApiModelProperty(name="measuringUnit",value="计量单位id",required=false)
	private String measuringUnit;
	
	@ApiModelProperty(name="measuringUnitName",value="计量单位名称",required=false)
	private String measuringUnitName;
	
	@ApiModelProperty(name="materialId",value="物资id",required=true)
    private String materialId;
	
	@ApiModelProperty(name="storageNum",value="物资数量",required=true)
    private Integer storageNum;

	@ApiModelProperty(name="status",value="状态，01报废，02待核定,03送出维修",required=true)
    private String status;
	
	

    public String getDamagedAuditDetailId() {
        return damagedAuditDetailId;
    }

    public void setDamagedAuditDetailId(String damagedAuditDetailId) {
        this.damagedAuditDetailId = damagedAuditDetailId == null ? null : damagedAuditDetailId.trim();
    }

    public String getDamagedAuditId() {
        return damagedAuditId;
    }

    public void setDamagedAuditId(String damagedAuditId) {
        this.damagedAuditId = damagedAuditId == null ? null : damagedAuditId.trim();
    }

    public String getDamagedPartsDetailId() {
        return damagedPartsDetailId;
    }

    public void setDamagedPartsDetailId(String damagedPartsDetailId) {
        this.damagedPartsDetailId = damagedPartsDetailId == null ? null : damagedPartsDetailId.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Integer getAuditNum() {
        return auditNum;
    }

    public void setAuditNum(Integer auditNum) {
        this.auditNum = auditNum;
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

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
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
		this.status = status;
	}

	public String getMeasuringUnitName() {
		return measuringUnitName;
	}

	public void setMeasuringUnitName(String measuringUnitName) {
		this.measuringUnitName = measuringUnitName;
	}
   	
    
}