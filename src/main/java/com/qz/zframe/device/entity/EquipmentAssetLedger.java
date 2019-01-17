package com.qz.zframe.device.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.material.entity.Material;

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
	
	@JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+08:00")
	
    private Date dateManufacture;
	
	@ApiModelProperty(name = "installDate", value = "安装日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+08:00")
	
    private Date installDate;
	
	@ApiModelProperty(name = "dateDelivery", value = "投运日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+08:00")

    private Date dateDelivery;
	
	@ApiModelProperty(name = "equipmentInformation", value = "设备信息", required = false)
	
    private String equipmentInformation;
	
	@ApiModelProperty(name = "supplier", value = "供应商", required = false)
	
    private String supplier;
	
	@ApiModelProperty(name = "assetStatus", value = "资产状态", required = false)
	
    private String assetStatus;
	
	@ApiModelProperty(name = "assetStatusDate", value = "资产状态变更日期", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GMT+08:00")

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
    @Transient
    private String assetStatusDates;
    @Transient
    private String dateDeliverys;
	@ApiModelProperty(name = "typeName", value = "设备分类名称", required = false)
	@Transient
	private  String typeName;
	@ApiModelProperty(name = "supplierName", value = "供应商名称", required = false)
	@Transient
	private  String supplierName;
	
    @ApiModelProperty(name = "assetStatusName", value = "资产状态名称", required = false)
    @Transient
    private String assetStatusName;//equipmentType
    
   @ApiModelProperty(name = "companyCodeName", value = "公司代码名称", required = false)
	@Transient
	private String companyCodeName;
	
	@ApiModelProperty(name = "maintenanceTeamName", value = "维护班组名称", required = false)
	@Transient
	private String maintenanceTeamName;
	
	@ApiModelProperty(name = "costCenterName", value = "成本中心名称", required = false)
	@Transient
	private String costCenterName;
	
	@ApiModelProperty(name = "departmentName", value = "部门", required = false)
	@Transient
	private String departmentName;
	
	@ApiModelProperty(name = "hierarchyName", value = "层级名称", required = false)
	@Transient
	private String hierarchyName;
  
    @Transient
    private List<String> componentIds;
    @Transient
    //出入的设备参数
    private  List<Components> components;
/*    @Transient
    //接受的物资数据
    private List<Material>  material;*/
    @Transient
	private  Parameters  runParameters;
	@Transient
	private  Parameters  outputParameters;
	@Transient
	private  List<String>  files;
	@Transient
	private List<SpFileUpload>  route;
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
		this.windId = windId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getMaintenanceTeam() {
		return maintenanceTeam;
	}

	public void setMaintenanceTeam(String maintenanceTeam) {
		this.maintenanceTeam = maintenanceTeam;
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
		this.manufacturer = manufacturer;
	}

	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getFixedAssets() {
		return fixedAssets;
	}

	public void setFixedAssets(String fixedAssets) {
		this.fixedAssets = fixedAssets;
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
		this.equipmentInformation = equipmentInformation;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
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
		this.assetCode = assetCode;
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
		this.componentId = componentId;
	}

	public String getOutputId() {
		return outputId;
	}

	public void setOutputId(String outputId) {
		this.outputId = outputId;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public byte[] getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(byte[] enclosure) {
        this.enclosure = enclosure;
    }

	/*public List<String> getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(List<String> enclosure) {
		this.enclosure = enclosure;
	}*/
	
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
		this.positionId = positionId  == null ? null : positionId.trim();
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
/*	 @Transient
	public String getEquipmentType() {
		return equipmentType;
	}
	@Transient
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}*/
	@Transient
	public List<String> getComponentIds() {
		return componentIds;
	}
	@Transient
	public void setComponentIds(List<String> componentIds) {
		this.componentIds = componentIds;
	}
	@Transient
	public String getAssetStatusDates() {
		return assetStatusDates;
	}
	@Transient
	public void setAssetStatusDates(String assetStatusDates) {
		this.assetStatusDates = assetStatusDates;
	}
	@Transient
	public String getDateDeliverys() {
		return dateDeliverys;
	}
	@Transient
	public void setDateDeliverys(String dateDeliverys) {
		this.dateDeliverys = dateDeliverys;
	}

	
	@Transient
	public Parameters getRunParameters() {
		return runParameters;
	}
	/*
	@Transient
	public List<Material> getMaterial() {
		return material;
	}
	@Transient
	public void setMaterial(List<Material> material) {
		this.material = material;
	}*/

	@Transient
	public void setRunParameters(Parameters runParameters) {
		this.runParameters = runParameters;
	}
	@Transient
	public Parameters getOutputParameters() {
		return outputParameters;
	}
	@Transient
	public void setOutputParameters(Parameters outputParameters) {
		this.outputParameters = outputParameters;
	}
	@Transient
	public List<Components> getComponents() {
		return components;
	}
	@Transient
	public void setComponents(List<Components> components) {
		this.components = components;
	}

	
	@Transient
	public String getCompanyCodeName() {
		return companyCodeName;
	}
	@Transient
	public void setCompanyCodeName(String companyCodeName) {
		this.companyCodeName = companyCodeName;
	}
	@Transient
	public String getMaintenanceTeamName() {
		return maintenanceTeamName;
	}
	@Transient
	public void setMaintenanceTeamName(String maintenanceTeamName) {
		this.maintenanceTeamName = maintenanceTeamName;
	}
	@Transient
	public String getCostCenterName() {
		return costCenterName;
	}
	@Transient
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
	@Transient
	public String getDepartmentName() {
		return departmentName;
	}
	@Transient
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Transient
	public String getHierarchyName() {
		return hierarchyName;
	}
	@Transient
	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}
	@Transient
	public List<String> getFiles() {
		return files;
	}
	@Transient
	public void setFiles(List<String> files) {
		this.files = files;
	}
	@Transient
	public List<SpFileUpload> getRoute() {
		return route;
	}
	@Transient
	public void setRoute(List<SpFileUpload> route) {
		this.route = route;
	}

	
	
	
    
}