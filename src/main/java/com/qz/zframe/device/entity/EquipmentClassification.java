package com.qz.zframe.device.entity;

import io.swagger.annotations.ApiParam;

public class EquipmentClassification {
	@ApiParam(name = "equipmentId", value = "设备分类id", required = false)

	private String equipmentId;

	@ApiParam(name = "equipmentType", value = "设备分类", required = true)

	private String equipmentType;

	@ApiParam(name = "typeName", value = "设备分类名称", required = false)

	private String typeName;

	@ApiParam(name = "superiorEquipment", value = "上级设备分类", required = true)

	private String superiorEquipment;

	@ApiParam(name = "superiorEquipmentDescribe", value = "上级设备描述", required = false)

	private String superiorEquipmentDescribe;

	@ApiParam(name = "superiorEquipmentName", value = "上级设备名称", required = false)

	private String superiorEquipmentName;

	@ApiParam(name = "status", value = "状态", required = false)
	private String status;

	@ApiParam(name = "isToplevel", value = "是否顶级", required = false)

	private String isToplevel;

	@ApiParam(name = "equipmentTypeDescribe", value = "设备分类描述", required = false)

	private String equipmentTypeDescribe;

	@ApiParam(name = "outputId", value = "出场技术参数id", required = false)
	private String outputId;

	@ApiParam(name = "runId", value = "运行技术参数id", required = false)
	private String runId;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId == null ? null : equipmentId.trim();
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType == null ? null : equipmentType.trim();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	public String getSuperiorEquipment() {
		return superiorEquipment;
	}

	public void setSuperiorEquipment(String superiorEquipment) {
		this.superiorEquipment = superiorEquipment == null ? null : superiorEquipment.trim();
	}

	public String getSuperiorEquipmentDescribe() {
		return superiorEquipmentDescribe;
	}

	public void setSuperiorEquipmentDescribe(String superiorEquipmentDescribe) {
		this.superiorEquipmentDescribe = superiorEquipmentDescribe == null ? null : superiorEquipmentDescribe.trim();
	}

	public String getSuperiorEquipmentName() {
		return superiorEquipmentName;
	}

	public void setSuperiorEquipmentName(String superiorEquipmentName) {
		this.superiorEquipmentName = superiorEquipmentName == null ? null : superiorEquipmentName.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getIsToplevel() {
		return isToplevel;
	}

	public void setIsToplevel(String isToplevel) {
		this.isToplevel = isToplevel == null ? null : isToplevel.trim();
	}

	public String getEquipmentTypeDescribe() {
		return equipmentTypeDescribe;
	}

	public void setEquipmentTypeDescribe(String equipmentTypeDescribe) {
		this.equipmentTypeDescribe = equipmentTypeDescribe == null ? null : equipmentTypeDescribe.trim();
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

}