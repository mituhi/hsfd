package com.qz.zframe.material.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

/**
 * 库存表
 * 
 * @author syc
 * @date 2018年11月27日下午2:59:26
 *
 */
public class Inventory implements Serializable{
   
	private static final long serialVersionUID = -7997910579725447380L;
	
	
	@ApiModelProperty(name="inventoryId",value="库存Id",required=true)
	private String inventoryId;

	@ApiModelProperty(name="materialId",value="物资Id",required=true)
    private String materialId;

	@ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

	@ApiModelProperty(name="stockAddId",value="库存地点Id",required=true)
    private String stockAddId;

	@ApiModelProperty(name="inventoryNum",value="当前库存",required=true)
    private Integer inventoryNum;

	@ApiModelProperty(name="inventoryAmount",value="物资金额",required=true)
    private BigDecimal inventoryAmount;

	@ApiModelProperty(name="freezeNum",value="冻结数量",required=false)
    private Integer freezeNum;

	@ApiModelProperty(name="freezeAmount",value="冻结金额",required=false)
    private BigDecimal freezeAmount;

	@ApiModelProperty(name="status",value="物资状态，01正常，02报废，03待审核",required=true)
    private String status;
	
	@ApiModelProperty(name="materialName",value="物资名称",required=true)
    private String materialName;

    @ApiModelProperty(name="materialDesc",value="物资描述",required=true)
    private String materialDesc;
	
	@ApiModelProperty(name="materialCode",value="物资编码",required=true)
    private String materialCode;


    @ApiModelProperty(name="windName",value="风电场名称",required=true)
    private String windName;

    @ApiModelProperty(name="stockAddName",value="库存地名称",required=true)
    private String stockAddName;

	@ApiModelProperty(name="specifications",value="型号规格",required=true)
    private String specifications;

	@ApiModelProperty(name="measuringUnitName",value="基本计量单位名称",required=true)
	private String measuringUnitName;
	
	@ApiModelProperty(name="totalNum",value="物资总库存",required=false)
	private Integer totalNum=0;
	
	@ApiModelProperty(name="totalAmount",value="物资总金额",required=false)
	private BigDecimal totalAmount=BigDecimal.ZERO;
	
	@ApiModelProperty(name="averagePrice",value="移动平均价",required=false)
	private BigDecimal averagePrice=BigDecimal.ZERO;

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

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId == null ? null : stockAddId.trim();
    }

    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public BigDecimal getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(BigDecimal inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Integer getFreezeNum() {
        return freezeNum;
    }

    public void setFreezeNum(Integer freezeNum) {
        this.freezeNum = freezeNum;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
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

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getStockAddName() {
        return stockAddName;
    }

    public void setStockAddName(String stockAddName) {
        this.stockAddName = stockAddName;
    }
}