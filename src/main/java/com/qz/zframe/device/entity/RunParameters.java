package com.qz.zframe.device.entity;

import io.swagger.annotations.ApiModelProperty;


public class RunParameters {
	@ApiModelProperty(name = "runId", value = "运行技术参数id", required = false)

	private String runId;

	@ApiModelProperty(name = "equipmentAssetId", value = "设备资产台账id", required = false)

	private String equipmentAssetId;

	@ApiModelProperty(name = "technicalId", value = "技术参数表id", required = false)

	private String technicalId;

	@ApiModelProperty(name = "technicalType", value = "技术参数类型", required = false)

	private String technicalType;

	@ApiModelProperty(name = "parameterCode", value = "参数编号", required = false)

	private String parameterCode;

	@ApiModelProperty(name = "parameterName", value = "参数名称", required = false)

	private String parameterName;

	@ApiModelProperty(name = "type", value = "数据类型", required = false)

	private String type;

	@ApiModelProperty(name = "numberValue", value = "数字值", required = false)

	private String numberValue;

	@ApiModelProperty(name = "company", value = "单位", required = false)

	private String company;

	@ApiModelProperty(name = "alphabetValue", value = "字母值", required = false)

	private String alphabetValue;

	@ApiModelProperty(name = "importantGrade", value = "重要等级", required = false)

	private String importantGrade;

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId == null ? null : runId.trim();
	}

	public String getEquipmentAssetId() {
		return equipmentAssetId;
	}

	public void setEquipmentAssetId(String equipmentAssetId) {
		this.equipmentAssetId = equipmentAssetId == null ? null : equipmentAssetId.trim();
	}

	public String getTechnicalId() {
		return technicalId;
	}

	public void setTechnicalId(String technicalId) {
		this.technicalId = technicalId == null ? null : technicalId.trim();
	}

	public String getTechnicalType() {
		return technicalType;
	}

	public void setTechnicalType(String technicalType) {
		this.technicalType = technicalType == null ? null : technicalType.trim();
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode == null ? null : parameterCode.trim();
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName == null ? null : parameterName.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(String numberValue) {
		this.numberValue = numberValue == null ? null : numberValue.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getAlphabetValue() {
		return alphabetValue;
	}

	public void setAlphabetValue(String alphabetValue) {
		this.alphabetValue = alphabetValue == null ? null : alphabetValue.trim();
	}

	public String getImportantGrade() {
		return importantGrade;
	}

	public void setImportantGrade(String importantGrade) {
		this.importantGrade = importantGrade == null ? null : importantGrade.trim();
	}
}