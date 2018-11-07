package com.qz.zframe.device.entity;

import io.swagger.annotations.ApiParam;

public class PositionEncode {
	@ApiParam(name = "positionId", value = "位置id", required = false)

	private String positionId;

	@ApiParam(name = "positionCode", value = "位置编码", required = true)

	private String positionCode;

	@ApiParam(name = "positionName", value = "位置名称", required = false)

	private String positionName;

	@ApiParam(name = "superiorPosition", value = "上级位置", required = true)

	private String superiorPosition;

	@ApiParam(name = "windId", value = "风电场", required = true)

	private String windId;

	@ApiParam(name = "department", value = "部门", required = false)

	private String department;

	@ApiParam(name = "hierarchy", value = "层级", required = false)

	private String hierarchy;

	@ApiParam(name = "crew", value = "机组", required = false)

	private String crew;

	@ApiParam(name = "companyCode", value = "公司代码", required = false)

	private String companyCode;

	@ApiParam(name = "costCenter", value = "成本中心", required = false)

	private String costCenter;

	@ApiParam(name = "maintenanceTeam", value = "维护班组", required = false)

	private String maintenanceTeam;

	@ApiParam(name = "status", value = "是否顶级", required = false)

	private String status;

	@ApiParam(name = "isToplevel", value = "是否启用状态", required = false)

	private String isToplevel;

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

}