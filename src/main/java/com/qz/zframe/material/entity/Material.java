package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

/**
 * 物资信息相关
 * 
 * @author 17931
 */
public class Material implements Serializable{
	

	private static final long serialVersionUID = -2464392060976996962L;

	public interface ListView extends BaseJsonView{};
	
    /**
     * 物资主键id
     */
	@JsonView({ListView.class})
    private String materialId;

    /**
     * 物资编码
     */
	@JsonView({ListView.class})
    private String materialCode;

    /**
     * 物资名称
     */
	@JsonView({ListView.class})
    private String materialName;

    /**
     * 物资描述
     */
	@JsonView({ListView.class})
    private String materialDescribe;

    /**
     * 物资分类
     */
	@JsonView({ListView.class})
    private String materialType;

    /**
     * 计量单位
     */
	@JsonView({ListView.class})
    private String measuringUnit;

    /**
     * 规格型号
     */
	@JsonView({ListView.class})
    private String specifications;

    /**
     * 物资数量
     */
	@JsonView({ListView.class})
    private BigDecimal materialNum;

    /**
     * 风电场id
     */
    private String windId;
    
    /**
     * 图号
     */
    private String graphNumber;

    /**
     * 物资属性id
     */
    private String materialPropertyId;

    /**
     * 物资组id
     */
    private String materialGroupId;

    /**
     * ABC标识
     */
    private String identification;

    /**
     * 是否固定资产，0否1是
     */
    private String isFixed;

    /**
     * 品牌/产地
     */
    private String productionAddress;

    /**
     * 是否有保质期，0否1是
     */
    private String isGuarantee;

    /**
     * 保质期限
     */
    private String qualityGuaranteePeriod;

    /**
     * 材质技术参数
     */
    private String materialParameter;

    /**
     * 排序
     */
    private String sort;

    /**
     * 是否控制库存
     */
    private String isControlStock;

    /**
     * 库存上限
     */
    private Integer stockMax;

    /**
     * 库存下限
     */
    private Integer stockMin;

    /**
     * 是否删除，0否1是
     */
    private String isDelete;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getMaterialDescribe() {
        return materialDescribe;
    }

    public void setMaterialDescribe(String materialDescribe) {
        this.materialDescribe = materialDescribe == null ? null : materialDescribe.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit == null ? null : measuringUnit.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public BigDecimal getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(BigDecimal materialNum) {
        this.materialNum = materialNum;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getGraphNumber() {
        return graphNumber;
    }

    public void setGraphNumber(String graphNumber) {
        this.graphNumber = graphNumber == null ? null : graphNumber.trim();
    }

    public String getMaterialPropertyId() {
        return materialPropertyId;
    }

    public void setMaterialPropertyId(String materialPropertyId) {
        this.materialPropertyId = materialPropertyId == null ? null : materialPropertyId.trim();
    }

    public String getMaterialGroupId() {
        return materialGroupId;
    }

    public void setMaterialGroupId(String materialGroupId) {
        this.materialGroupId = materialGroupId == null ? null : materialGroupId.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(String isFixed) {
        this.isFixed = isFixed == null ? null : isFixed.trim();
    }

    public String getProductionAddress() {
        return productionAddress;
    }

    public void setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress == null ? null : productionAddress.trim();
    }

    public String getIsGuarantee() {
        return isGuarantee;
    }

    public void setIsGuarantee(String isGuarantee) {
        this.isGuarantee = isGuarantee == null ? null : isGuarantee.trim();
    }

    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod == null ? null : qualityGuaranteePeriod.trim();
    }

    public String getMaterialParameter() {
        return materialParameter;
    }

    public void setMaterialParameter(String materialParameter) {
        this.materialParameter = materialParameter == null ? null : materialParameter.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getIsControlStock() {
        return isControlStock;
    }

    public void setIsControlStock(String isControlStock) {
        this.isControlStock = isControlStock == null ? null : isControlStock.trim();
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
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
}