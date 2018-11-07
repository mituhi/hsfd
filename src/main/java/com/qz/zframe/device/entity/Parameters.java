package com.qz.zframe.device.entity;

import io.swagger.annotations.ApiParam;

public class Parameters {
	@ApiParam(name = "parameterId", value = "技术参数id", required = false)

	private String parameterId;

	@ApiParam(name = "output", value = "出场技术参数id", required = false)

	private String output;

	@ApiParam(name = "run", value = "运行技术参数id", required = false)

	private String run;

	@ApiParam(name = "parameterCode", value = "参数编号", required = true)

	private String parameterCode;

	@ApiParam(name = "parameterName", value = "参数名称", required = true)

	private String parameterName;

	@ApiParam(name = "type", value = "数据类型", required = true)

	private String type;

	@ApiParam(name = "company", value = "单位", required = true)

	private String company;

	@ApiParam(name = "status", value = "状态", required = true)

	private String status;

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
}