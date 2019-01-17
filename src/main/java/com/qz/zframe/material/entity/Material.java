package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 物资信息
 * 
 * @ClassName: Material
 * @author syc
 * @date 2018年11月3日下午2:52:33
 *
 */
public class Material implements Serializable{
   
	private static final long serialVersionUID = 852273358055545860L;
	
	public interface ListView extends BaseJsonView {};

	
	@ApiModelProperty(name="materialId",value="物资id",required=true)
	@JsonView({ ListView.class })
	private String materialId;
	
	
	@ApiModelProperty(name="materialName",value="物资名称",required=true)
	@JsonView({ ListView.class })
    private String materialName;

	
	@ApiModelProperty(name="materialCode",value="物资编码",required=true)
	@JsonView({ ListView.class })
    private String materialCode;


	@ApiModelProperty(name="specifications",value="型号规格",required=true)
	@JsonView({ ListView.class })
    private String specifications;

	
	
	@ApiModelProperty(name="materialDescribe",value="物资描述",required=true)
	@JsonView({ ListView.class })
    private String materialDescribe;

	
	@ApiModelProperty(name="materialGroupId",value="物资分组id",required=true)
    private String materialGroupId;
    
    
    
	@ApiModelProperty(name="materialGroupName",value="物资分组名称",required=false)
    private String materialGroupName;

    
	@ApiModelProperty(name="materialClassifyId",value="物资分类id",required=true)
    private String materialClassifyId;
    
    
	@ApiModelProperty(name="materialClassifyName",value="物资分类名称",required=false)
    @JsonView({ ListView.class })
    private String materialClassifyName;
	
	@ApiModelProperty(name="materialClassifyDescribe",value="物资分类描述",required=false)
    @JsonView({ ListView.class })
    private String materialClassifyDescribe;

   
	@ApiModelProperty(name="status",value="状态，01启用，02停用",required=true)
    @JsonView({ ListView.class })
    private String status;

    
	@ApiModelProperty(name="abcLogo",value="ABC标识",required=false)
    private String abcLogo;

    
	@ApiModelProperty(name="materialNum",value="图号",required=false)
    private String materialNum;

   
	@ApiModelProperty(name="materialTexture",value="材质",required=false)
    private String materialTexture;

	@ApiModelProperty(name="measuringUnit",value="基本计量单位id",required=true)
    private String measuringUnit;
	
	
	@ApiModelProperty(name="measuringUnitName",value="基本计量单位名称",required=true)
	@JsonView({ ListView.class })
	private String measuringUnitName;

   
    @ApiModelProperty(name="supplierId",value="供应商id",required=true)
    private String supplierId;
    
   
    @ApiModelProperty(name="supplierName",value="供应商名称",required=false)
    private String supplierName;

    
    @ApiModelProperty(name="architectureCode",value="风电场编码",required=true)
    private String architectureCode;
    
   
    @ApiModelProperty(name="architectureName",value="风电场名称",required=true)
    private String architectureName;

    
    @ApiModelProperty(name="isGuarantee",value="是否有保质期，01时，02否",required=true)
    private String isGuarantee;

   
    @ApiModelProperty(name="guaranteeDays",value="保质期天",required=false)
    private Integer guaranteeDays;

    
    @ApiModelProperty(name="isConStock",value="是否控制库存，01时，02否",required=true)
    private String isConStock;

    
    @ApiModelProperty(name="maxStock",value="库存上限",required=false)
    private Integer maxStock;

   
    @ApiModelProperty(name="minStock",value="库存下限",required=false)
    private Integer minStock;

    
    @ApiModelProperty(name="isBatchCon",value="是否批次管理,01是，02否",required=false)
    private String isBatchCon;

  
    @ApiModelProperty(name="safetyStock",value="安全库存",required=false)
    private Integer safetyStock;

  
    @ApiModelProperty(name="currentStock",value="当前库存",required=false)
    @JsonView({ ListView.class })
    private Integer currentStock;

    @ApiModelProperty(name="averagePrice",value="移动平均价",required=false)
    private BigDecimal averagePrice=BigDecimal.ZERO;

    private String isDelete;

    private String creater;

    private Date createTime;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;
    
    @ApiModelProperty(name="nameAndDescribe",value="物资分类+描述拼接",required=false)
    private String nameAndDescribe;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getMaterialDescribe() {
        return materialDescribe;
    }

    public void setMaterialDescribe(String materialDescribe) {
        this.materialDescribe = materialDescribe == null ? null : materialDescribe.trim();
    }

    public String getMaterialGroupId() {
        return materialGroupId;
    }

    public void setMaterialGroupId(String materialGroupId) {
        this.materialGroupId = materialGroupId == null ? null : materialGroupId.trim();
    }

    public String getMaterialClassifyId() {
        return materialClassifyId;
    }

    public void setMaterialClassifyId(String materialClassifyId) {
        this.materialClassifyId = materialClassifyId == null ? null : materialClassifyId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAbcLogo() {
        return abcLogo;
    }

    public void setAbcLogo(String abcLogo) {
        this.abcLogo = abcLogo == null ? null : abcLogo.trim();
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum == null ? null : materialNum.trim();
    }

    public String getMaterialTexture() {
        return materialTexture;
    }

    public void setMaterialTexture(String materialTexture) {
        this.materialTexture = materialTexture == null ? null : materialTexture.trim();
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit == null ? null : measuringUnit.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getIsGuarantee() {
        return isGuarantee;
    }

    public void setIsGuarantee(String isGuarantee) {
        this.isGuarantee = isGuarantee == null ? null : isGuarantee.trim();
    }

    public Integer getGuaranteeDays() {
        return guaranteeDays;
    }

    public void setGuaranteeDays(Integer guaranteeDays) {
        this.guaranteeDays = guaranteeDays;
    }

    public String getIsConStock() {
        return isConStock;
    }

    public void setIsConStock(String isConStock) {
        this.isConStock = isConStock == null ? null : isConStock.trim();
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public String getIsBatchCon() {
        return isBatchCon;
    }

    public void setIsBatchCon(String isBatchCon) {
        this.isBatchCon = isBatchCon == null ? null : isBatchCon.trim();
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4 == null ? null : extend4.trim();
    }

	public String getMaterialGroupName() {
		return materialGroupName;
	}

	public void setMaterialGroupName(String materialGroupName) {
		this.materialGroupName = materialGroupName;
	}

	public String getMaterialClassifyName() {
		return materialClassifyName;
	}

	public void setMaterialClassifyName(String materialClassifyName) {
		this.materialClassifyName = materialClassifyName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getMeasuringUnitName() {
		return measuringUnitName;
	}

	public void setMeasuringUnitName(String measuringUnitName) {
		this.measuringUnitName = measuringUnitName;
	}

	public String getArchitectureCode() {
		return architectureCode;
	}

	public void setArchitectureCode(String architectureCode) {
		this.architectureCode = architectureCode;
	}

	public String getArchitectureName() {
		return architectureName;
	}

	public void setArchitectureName(String architectureName) {
		this.architectureName = architectureName;
	}

	public String getMaterialClassifyDescribe() {
		return materialClassifyDescribe;
	}

	public void setMaterialClassifyDescribe(String materialClassifyDescribe) {
		this.materialClassifyDescribe = materialClassifyDescribe;
	}

	public String getNameAndDescribe() {
		return nameAndDescribe;
	}

	public void setNameAndDescribe(String nameAndDescribe) {
		this.nameAndDescribe = nameAndDescribe;
	}   
	
	
    
}