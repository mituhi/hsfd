package com.qz.zframe.device.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;


public class EquipmentAssetLedger {
	@ApiModelProperty(name = "equipmentAssetId", value = "设备资产台账id", required = false)
	
    private String equipmentAssetId;
	
	@ApiModelProperty(name = "equipmentCode", value = "设备编码", required = false)
	
    private String equipmentCode;
	
	@ApiModelProperty(name = "equipmentName", value = "设备名称", required = false)
	
    private String equipmentName;
	
	@ApiModelProperty(name = "positionCode", value = "位置编码", required = false)
	@Transient
    private String positionCode;
	
	@ApiModelProperty(name = "positionName", value = "位置名称", required = false)
	@Transient
    private String positionName;
	
	@ApiModelProperty(name = "windId", value = "风电场", required = false)
	
    private String windId;
	
	@ApiModelProperty(name = "department", value = "部门", required = false)
	
    private String department;
	
	@ApiModelProperty(name = "hierarchy", value = "层级", required = false)
	
    private String hierarchy;
	
	@ApiModelProperty(name = "crew", value = "机组", required = false)
	
    private String crew;
	
	@ApiModelProperty(name = "companyCode", value = "公司代码", required = false)
	
    private String companyCode;
	
	@ApiModelProperty(name = "costCenter", value = "成本中心", required = false)
	
    private String costCenter;
	
	@ApiModelProperty(name = "maintenanceTeam", value = "维护班组", required = false)
	
    private String maintenanceTeam;
	
	@ApiModelProperty(name = "address", value = "地理位置", required = false)
	
    private BigDecimal address;
	
	@ApiModelProperty(name = "manufacturer", value = "制造商家", required = false)
	
    private String manufacturer;
	
	@ApiModelProperty(name = "equipmentNumber", value = "设备号", required = false)
	
    private String equipmentNumber;
	
	@ApiModelProperty(name = "fixedAssets", value = "固定资产", required = false)
	
    private String fixedAssets;
	
	@ApiModelProperty(name = "dateManufacture", value = "生产日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	
    private Date dateManufacture;
	
	@ApiModelProperty(name = "installDate", value = "安装日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	
    private Date installDate;
	
	@ApiModelProperty(name = "dateDelivery", value = "投运日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")

    private Date dateDelivery;
	
	@ApiModelProperty(name = "equipmentInformation", value = "设备信息", required = false)
	
    private String equipmentInformation;
	
	@ApiModelProperty(name = "supplier", value = "供应商", required = false)
	
    private String supplier;
	
	@ApiModelProperty(name = "assetStatus", value = "资产状态", required = false)
	
    private String assetStatus;
	
	@ApiModelProperty(name = "assetStatusDate", value = "资产状态变更日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")

    private Date assetStatusDate;
	
	@ApiModelProperty(name = "assetCode", value = "资产编码", required = false)
	
    private String assetCode;
	
	@ApiModelProperty(name = "assetValue", value = "资产原值", required = false)
	
    private BigDecimal assetValue;
	
	@ApiModelProperty(name = "monthlyDepreciationRate", value = "月折旧率%", required = false)
	
    private BigDecimal monthlyDepreciationRate;
	
	@ApiModelProperty(name = "componentId", value = "设备部件id", required = false)
	
    private String componentId;
	
	@ApiModelProperty(name = "outputId", value = "出场技术参数id", required = false)
	
    private String outputId;
	
	@ApiModelProperty(name = "runId", value = "运行技术参数id", required = false)
	
    private String runId;
	
	@ApiModelProperty(name = "equipmentId", value = "设备分类id", required = false)
	
	private  String equipmentId;
	
	@ApiModelProperty(name = "positionId", value = "位置id", required = false)
	
	private  String positionId;
	
	@ApiModelProperty(name = "enclosure", value = "附件", required = false)
	
    private byte[] enclosure;
	
	@ApiModelProperty(name = "windName", value = "风电场名称", required = false)
	@Transient
	private  String windName;
	
	@ApiModelProperty(name = "crewName", value = "机组名称", required = false)
	@Transient
	private  String crewName;
	
	@ApiModelProperty(name = "typeName", value = "设备分类名称", required = false)
	@Transient
	private  String typeName;
	@ApiModelProperty(name = "equipmentType", value = "设备分类", required = false)
	@Transient
	private  String equipmentType;
	@ApiModelProperty(name = "supplierName", value = "供应商名称", required = false)
	@Transient
	private  String supplierName;
	
    @ApiModelProperty(name = "assetStatusName", value = "资产状态名称", required = false)
    @Transient
    private String assetStatusName;
    public String getEquipmentAssetId() {
        return equipmentAssetId;
    }

    public void setEquipmentAssetId(String equipmentAssetId) {
        this.equipmentAssetId = equipmentAssetId == null ? null : equipmentAssetId.trim();
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }
    @Transient
    public String getPositionCode() {
        return positionCode;
    }
    @Transient
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }
    @Transient
    public String getPositionName() {
        return positionName;
    }
    @Transient
    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy == null ? null : hierarchy.trim();
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew == null ? null : crew.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter == null ? null : costCenter.trim();
    }

    public String getMaintenanceTeam() {
        return maintenanceTeam;
    }

    public void setMaintenanceTeam(String maintenanceTeam) {
        this.maintenanceTeam = maintenanceTeam == null ? null : maintenanceTeam.trim();
    }

    public BigDecimal getAddress() {
        return address;
    }

    public void setAddress(BigDecimal address) {
        this.address = address;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
    }

    public String getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(String fixedAssets) {
        this.fixedAssets = fixedAssets == null ? null : fixedAssets.trim();
    }

    public Date getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(Date dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getEquipmentInformation() {
        return equipmentInformation;
    }

    public void setEquipmentInformation(String equipmentInformation) {
        this.equipmentInformation = equipmentInformation == null ? null : equipmentInformation.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus == null ? null : assetStatus.trim();
    }

    public Date getAssetStatusDate() {
        return assetStatusDate;
    }

    public void setAssetStatusDate(Date assetStatusDate) {
        this.assetStatusDate = assetStatusDate;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode == null ? null : assetCode.trim();
    }

    public BigDecimal getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(BigDecimal assetValue) {
        this.assetValue = assetValue;
    }

    public BigDecimal getMonthlyDepreciationRate() {
        return monthlyDepreciationRate;
    }

    public void setMonthlyDepreciationRate(BigDecimal monthlyDepreciationRate) {
        this.monthlyDepreciationRate = monthlyDepreciationRate;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId == null ? null : componentId.trim();
    }

    public String getOutputId() {
        return outputId;
    }

    public void setOutputId(String outputId) {
        this.outputId = outputId == null ? null : outputId.trim();
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId == null ? null : runId.trim();
    }

    public byte[] getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(byte[] enclosure) {
        this.enclosure = enclosure;
    }

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId  == null ? null : runId.trim();
	}
	@Transient
	public String getWindName() {
		return windName;
	}
	@Transient
	public void setWindName(String windName) {
		this.windName = windName;
	}
	@Transient
	public String getCrewName() {
		return crewName;
	}
	@Transient
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	@Transient
	public String getTypeName() {
		return typeName;
	}
	@Transient
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Transient
	public String getSupplierName() {
		return supplierName;
	}
	@Transient
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	 @Transient
	public String getAssetStatusName() {
		return assetStatusName;
	}
	 @Transient
	public void setAssetStatusName(String assetStatusName) {
		this.assetStatusName = assetStatusName;
	}
	 @Transient
	public String getEquipmentType() {
		return equipmentType;
	}
	@Transient
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
    
}