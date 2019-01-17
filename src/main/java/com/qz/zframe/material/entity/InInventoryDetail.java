package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

public class InInventoryDetail implements Serializable{
   
	private static final long serialVersionUID = -6662230637317648491L;
	


	public interface ListView extends BaseJsonView {};

	@ApiModelProperty(name="inInventoryDetailId",value="入库单详情id",required=true)
	private String inInventoryDetailId;

	@ApiModelProperty(name="inInventoryId",value="入库单id",required=true)
    private String inInventoryId;

	@ApiModelProperty(name="materialId",value="物资id",required=true)
	@JsonView({ ListView.class })
    private String materialId;

	@ApiModelProperty(name="goodsNum",value="入库数量",required=true)
	@JsonView({ ListView.class })
    private Integer goodsNum;

	@ApiModelProperty(name="taxPrice",value="含税单价",required=false)
	@JsonView({ ListView.class })
    private BigDecimal taxPrice;

	@ApiModelProperty(name="taxAmount",value="含税金额",required=false)
    private BigDecimal taxAmount;

	@ApiModelProperty(name="taxBill",value="税率",required=false)
	@JsonView({ ListView.class })
    private String taxBill;

	@ApiModelProperty(name="unTaxPrice",value="未税单价",required=false)
    private BigDecimal unTaxPrice;

	@ApiModelProperty(name="checkResults",value="验证结果，01合格，02不合格",required=true)
    private String checkResults;

	@ApiModelProperty(name="remark",value="备注",required=false)
	@JsonView({ ListView.class })
    private String remark;

	@ApiModelProperty(name="manufactureDay",value="生产日期,展示用",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date manufactureDay;
	
	@ApiModelProperty(name="manufactureDate",value="生产日期,新增编辑时使用",required=false)
	private String manufactureDate;

	@ApiModelProperty(name="netPrice",value="净价",required=false)
    private BigDecimal netPrice;

	@ApiModelProperty(name="netWorth",value="净值",required=false)
    private BigDecimal netWorth;
	
	@ApiModelProperty(name="materialCode",value="物资编码",required=false)
	@JsonView({ ListView.class })
	private String materialCode;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=false)
	@JsonView({ ListView.class })
	private String materialName;
	
	
	@ApiModelProperty(name="specifications",value="型号规格",required=false)
	@JsonView({ ListView.class })
	private String specifications;
	
	@ApiModelProperty(name="measuringUnit",value="计量单位",required=false)
	private String measuringUnit;

    @ApiModelProperty(name="measuringUnitName",value="计量单位名称",required=false)
    @JsonView({ ListView.class })
	private String measuringUnitName;
	
	

    public String getInInventoryDetailId() {
        return inInventoryDetailId;
    }

    public void setInInventoryDetailId(String inInventoryDetailId) {
        this.inInventoryDetailId = inInventoryDetailId == null ? null : inInventoryDetailId.trim();
    }

    public String getInInventoryId() {
        return inInventoryId;
    }

    public void setInInventoryId(String inInventoryId) {
        this.inInventoryId = inInventoryId == null ? null : inInventoryId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(BigDecimal taxPrice) {
        this.taxPrice = taxPrice;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxBill() {
        return taxBill;
    }

    public void setTaxBill(String taxBill) {
        this.taxBill = taxBill == null ? null : taxBill.trim();
    }

    public BigDecimal getUnTaxPrice() {
        return unTaxPrice;
    }

    public void setUnTaxPrice(BigDecimal unTaxPrice) {
        this.unTaxPrice = unTaxPrice;
    }

    public String getCheckResults() {
        return checkResults;
    }

    public void setCheckResults(String checkResults) {
        this.checkResults = checkResults == null ? null : checkResults.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getManufactureDay() {
        return manufactureDay;
    }

    public void setManufactureDay(Date manufactureDay) {
        this.manufactureDay = manufactureDay;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
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

    public String getMeasuringUnitName() {
        return measuringUnitName;
    }

    public void setMeasuringUnitName(String measuringUnitName) {
        this.measuringUnitName = measuringUnitName;
    }
}