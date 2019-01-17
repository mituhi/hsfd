package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 领料单详情信息
 * 
 * @author syc
 * @date 2018年11月19日下午4:27:33
 *
 */
public class PickingRecordDetail implements Serializable{
   
	private static final long serialVersionUID = -3496764211581195178L;

	@ApiModelProperty(name="pickingDetailId",value="领料详情id",required=true)
	private String pickingDetailId;

	@ApiModelProperty(name="pickingId",value="领料id",required=true)
    private String pickingId;

	@ApiModelProperty(name="materialId",value="物资id",required=true)
    private String materialId;

	
	@ApiModelProperty(name="returnPickingDetailId",value="退料时领用id",required=false)
    private String returnPickingDetailId;

	@ApiModelProperty(name="recipientsNum",value="领用数量",required=true)
    private Integer recipientsNum;

	@ApiModelProperty(name="returnNum",value="已退数量",required=false)
    private Integer returnNum;

	@ApiModelProperty(name="refundableNum",value="可退数量",required=false)
    private Integer refundableNum;

	@ApiModelProperty(name="price",value="单价",required=false)
    private BigDecimal price;

	@ApiModelProperty(name="amount",value="金额",required=false)
    private BigDecimal amount;

	@ApiModelProperty(name="inInventoryId",value="入库id",required=false)
    private String inInventoryId;

	@ApiModelProperty(name="purpose",value="用途",required=false)
    private String purpose;

	@ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;
	
	@ApiModelProperty(name="materialCode",value="物资编码",required=false)
	private String materialCode;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=false)
	private String materialName;
	
	@ApiModelProperty(name="specifications",value="规格型号",required=false)
	private String specifications;
	
	
	@ApiModelProperty(name="measuringUnitName",value="物资单位名称",required=false)
	private String measuringUnitName;
	
	@ApiModelProperty(name="workorderMaterialId",value="工单领料信息Id",required=false)
	private String workorderMaterialId;

    public String getPickingDetailId() {
        return pickingDetailId;
    }

    public void setPickingDetailId(String pickingDetailId) {
        this.pickingDetailId = pickingDetailId == null ? null : pickingDetailId.trim();
    }

    public String getPickingId() {
        return pickingId;
    }

    public void setPickingId(String pickingId) {
        this.pickingId = pickingId == null ? null : pickingId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getReturnPickingDetailId() {
        return returnPickingDetailId;
    }

    public void setReturnPickingDetailId(String returnPickingDetailId) {
        this.returnPickingDetailId = returnPickingDetailId == null ? null : returnPickingDetailId.trim();
    }

    public Integer getRecipientsNum() {
        return recipientsNum;
    }

    public void setRecipientsNum(Integer recipientsNum) {
        this.recipientsNum = recipientsNum;
    }

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public Integer getRefundableNum() {
        return refundableNum;
    }

    public void setRefundableNum(Integer refundableNum) {
        this.refundableNum = refundableNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInInventoryId() {
        return inInventoryId;
    }

    public void setInInventoryId(String inInventoryId) {
        this.inInventoryId = inInventoryId == null ? null : inInventoryId.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
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

	public String getMeasuringUnitName() {
		return measuringUnitName;
	}

	public void setMeasuringUnitName(String measuringUnitName) {
		this.measuringUnitName = measuringUnitName;
	}

	public String getWorkorderMaterialId() {
		return workorderMaterialId;
	}

	public void setWorkorderMaterialId(String workorderMaterialId) {
		this.workorderMaterialId = workorderMaterialId;
	}
    
}