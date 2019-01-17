package com.qz.zframe.device.entity;

import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
public class EquipmentClassification {
	@ApiModelProperty(name = "equipmentId", value = "设备分类id", required = false)

	private String equipmentId;

	@ApiModelProperty(name = "equipmentType", value = "设备分类", required = true)

	private String equipmentType;

	@ApiModelProperty(name = "typeName", value = "设备分类名称", required = false)

	private String typeName;

	@ApiModelProperty(name = "superiorEquipment", value = "上级设备分类", required = true)

	private String superiorEquipment;

	@ApiModelProperty(name = "superiorEquipmentDescribe", value = "上级设备描述", required = false)

	private String superiorEquipmentDescribe;

	@ApiModelProperty(name = "superiorEquipmentName", value = "上级设备名称", required = false)

	private String superiorEquipmentName;

	@ApiModelProperty(name = "status", value = "状态", required = false)
	private String status;

	@ApiModelProperty(name = "isToplevel", value = "是否顶级", required = false)

	private String isToplevel;

	@ApiModelProperty(name = "equipmentTypeDescribe", value = "设备分类描述", required = false)

	private String equipmentTypeDescribe;

	@ApiModelProperty(name = "outputId", value = "出场技术参数id", required = false)
	private String outputId;

	@ApiModelProperty(name = "runId", value = "运行技术参数id", required = false)
	private String runId;
	
	@ApiModelProperty(name = "statusName", value = "状态名称", required = false)
	@Transient
	private String statusName;
	
	@ApiModelProperty(name = "isToplevelName", value = "是否顶级名称", required = false)
	@Transient
	private String isToplevelName;
	
	@Transient
	private  Parameters  runParameters;
	
	@Transient
	private  Parameters  outputParameters;
     
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private  Date  createTime;
	
	
	
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
	public Parameters getRunParameters() {
		return runParameters;
	}
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
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}