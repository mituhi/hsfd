package com.qz.zframe.device.entity;

import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;


public class Parameters {
	@ApiModelProperty(name = "parameterId", value = "技术参数id", required = false)

	private String parameterId;

	@ApiModelProperty(name = "output", value = "出场技术参数id", required = false)

	private String output;

	@ApiModelProperty(name = "run", value = "运行技术参数id", required = false)

	private String run;

	@ApiModelProperty(name = "parameterCode", value = "参数编号", required = true)

	private String parameterCode;

	@ApiModelProperty(name = "parameterName", value = "参数名称", required = true)

	private String parameterName;

	@ApiModelProperty(name = "type", value = "数据类型", required = true)

	private String type;

	@ApiModelProperty(name = "company", value = "单位", required = true)

	private String company;

	@ApiModelProperty(name = "status", value = "状态", required = true)

	private String status;

	@ApiModelProperty(name = "statusName", value = "状态名称", required = false)
	@Transient
	private String statusName;
	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId == null ? null : parameterId.trim();
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output == null ? null : output.trim();
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run == null ? null : run.trim();
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
	@Transient
	public String getStatusName() {
		return statusName;
	}
	@Transient
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}