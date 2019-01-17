package com.qz.zframe.device.entity;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createTime;

	private String runIs;

	private String outputIs;

	public String getParameterId() {
		return parameterId;
	}

	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getRunIs() {
		return runIs;
	}

	public void setRunIs(String runIs) {
		this.runIs = runIs;
	}

	public String getOutputIs() {
		return outputIs;
	}

	public void setOutputIs(String outputIs) {
		this.outputIs = outputIs;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	
	
}