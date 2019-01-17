package com.qz.zframe.material.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ScrapDetail implements Serializable{
	
	private static final long serialVersionUID = -4358247237495460500L;

	@ApiModelProperty(name="scrapDetailId",value="报废详情id",required=true)
	private String scrapDetailId;

	@ApiModelProperty(name="scrapId",value="报废id",required=true)
    private String scrapId;

	@ApiModelProperty(name="damagedPartsDetailId",value="损坏件入库详情id",required=true)
    private String damagedPartsDetailId;

	@ApiModelProperty(name="scrapNum",value="报废数量",required=true)
    private Integer scrapNum;

	@ApiModelProperty(name="scrapReason",value="报废原因",required=false)
    private String scrapReason;

	@ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;

	@ApiModelProperty(name="stockAddId",value="库存地点id",required=true)
    private String stockAddId;
    
	@ApiModelProperty(name="stockAddName",value="库存地点名称",required=true)
    private String stockAddName;
	
	@ApiModelProperty(name="materialId",value="物资id",required=false)
	private String materialId;
	
	@ApiModelProperty(name="materialCode",value="物资编码",required=false)
	private String materialCode;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=false)
	private String materialName;
	
	@ApiModelProperty(name="specifications",value="型号规格",required=false)
	private String specifications;
	
	@ApiModelProperty(name="measuringUnitName",value="单位",required=false)
	private String measuringUnitName;
	
	@ApiModelProperty(name="storageNum",value="损坏件入库管理",required=false)
	private Integer storageNum;
	
    public String getScrapDetailId() {
        return scrapDetailId;
    }

    public void setScrapDetailId(String scrapDetailId) {
        this.scrapDetailId = scrapDetailId == null ? null : scrapDetailId.trim();
    }

    public String getScrapId() {
        return scrapId;
    }

    public void setScrapId(String scrapId) {
        this.scrapId = scrapId == null ? null : scrapId.trim();
    }

    public String getDamagedPartsDetailId() {
        return damagedPartsDetailId;
    }

    public void setDamagedPartsDetailId(String damagedPartsDetailId) {
        this.damagedPartsDetailId = damagedPartsDetailId == null ? null : damagedPartsDetailId.trim();
    }

    public Integer getScrapNum() {
        return scrapNum;
    }

    public void setScrapNum(Integer scrapNum) {
        this.scrapNum = scrapNum;
    }

    public String getScrapReason() {
        return scrapReason;
    }

    public void setScrapReason(String scrapReason) {
        this.scrapReason = scrapReason == null ? null : scrapReason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId == null ? null : stockAddId.trim();
    }

	public String getStockAddName() {
		return stockAddName;
	}

	public void setStockAddName(String stockAddName) {
		this.stockAddName = stockAddName;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
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

	public String getMeasuringUnitName() {
		return measuringUnitName;
	}

	public void setMeasuringUnitName(String measuringUnitName) {
		this.measuringUnitName = measuringUnitName;
	}

	public Integer getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(Integer storageNum) {
		this.storageNum = storageNum;
	}
     
}