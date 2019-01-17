package com.qz.zframe.device.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;


public class PositionEncode {
	@ApiModelProperty(name = "positionId", value = "位置id", required = false)

	private String positionId;

	@ApiModelProperty(name = "positionCode", value = "位置编码", required = true)

	private String positionCode;

	@ApiModelProperty(name = "positionName", value = "位置名称", required = false)

	private String positionName;

	@ApiModelProperty(name = "superiorPosition", value = "上级位置", required = true)

	private String superiorPosition;
	@ApiModelProperty(name = "superiorPositionName", value = "上级位置名称", required = true)

	private String superiorPositionName;
	

	@ApiModelProperty(name = "windId", value = "风电场", required = true)

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

	@ApiModelProperty(name = "status", value = "是否顶级", required = false)

	private String status;

	@ApiModelProperty(name = "isToplevel", value = "是否启用状态", required = false)

	private String isToplevel;
	
	@ApiModelProperty(name = "windName", value = "风电场", required = false)
	@Transient
	private  String windName;
	
	@ApiModelProperty(name = "crewName", value = "机组名称", required = false)
	@Transient
	private  String crewName;
	
	@ApiModelProperty(name = "statusName", value = "状态名称", required = false)
	@Transient
	private String statusName;
	
	@ApiModelProperty(name = "isTopLevelName", value = "是否顶级名称", required = false)
	@Transient
	private String isToplevelName;
	
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date  createTime;
	@ApiModelProperty(name = "positionEncodes", value = "子数据", required = false)
	private List<PositionEncode> positionEncodes;

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId == null ? null : positionId.trim();
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode == null ? null : positionCode.trim();
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName == null ? null : positionName.trim();
	}

	public String getSuperiorPosition() {
		return superiorPosition;
	}

	public void setSuperiorPosition(String superiorPosition) {
		this.superiorPosition = superiorPosition == null ? null : superiorPosition.trim();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsToplevel() {
		return isToplevel;
	}

	public void setIsToplevel(String isToplevel) {
		this.isToplevel = isToplevel;
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
	public String getStatusName() {
		return statusName;
	}
	@Transient
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Transient
	public String getIsToplevelName() {
		return isToplevelName;
	}
	@Transient
	public void setIsToplevelName(String isToplevelName) {
		this.isToplevelName = isToplevelName;
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
	public String getHierarchyName() {
		return hierarchyName;
	}
	@Transient
	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}

	public String getSuperiorPositionName() {
		return superiorPositionName;
	}

	public void setSuperiorPositionName(String superiorPositionName) {
		this.superiorPositionName = superiorPositionName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Transient
	public String getDepartmentName() {
		return departmentName;
	}
	@Transient
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<PositionEncode> getPositionEncodes() {
		return positionEncodes;
	}

	public void setPositionEncodes(List<PositionEncode> positionEncodes) {
		this.positionEncodes = positionEncodes;
	}
  
	
}