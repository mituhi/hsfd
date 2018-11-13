package com.qz.zframe.device.entity;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;


public class CrewInformation {
	@ApiModelProperty(name = "crewId", value = "机组信息id", required = false)

	private String crewId;

	@ApiModelProperty(name = "crewCode", value = "机组编码", required = true)

	private String crewCode;

	@ApiModelProperty(name = "crewName", value = "机组名称", required = false)

	private String crewName;

	@ApiModelProperty(name = "windId", value = "风电场", required = true)

	private String windId;

	@ApiModelProperty(name = "installedCapacity", value = "装机容量", required = false)

	private String installedCapacity;

	@ApiModelProperty(name = "enableDate", value = "启用日期", required = false)

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")

	private Date enableDate;

	@ApiModelProperty(name = "creater", value = "创建人", required = false)

	private String creater;

	@ApiModelProperty(name = "creatDate", value = "创建时间", required = false)

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")

	private Date  creatDate;
	
	@ApiModelProperty(name = "windName", value = "风电场名称", required = false)
	@Transient
    private String windName;
	
	public String getCrewId() {
		return crewId;
	}

	public void setCrewId(String crewId) {
		this.crewId = crewId == null ? null : crewId.trim();
	}

	public String getCrewCode() {
		return crewCode;
	}

	public void setCrewCode(String crewCode) {
		this.crewCode = crewCode == null ? null : crewCode.trim();
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName == null ? null : crewName.trim();
	}

	public String getWindId() {
		return windId;
	}

	public void setWindId(String windId) {
		this.windId = windId == null ? null : windId.trim();
	}

	public String getInstalledCapacity() {
		return installedCapacity;
	}

	public void setInstalledCapacity(String installedCapacity) {
		this.installedCapacity = installedCapacity == null ? null : installedCapacity.trim();
	}

	public Date  getEnableDate() {
		return enableDate;
	}

	public void setEnableDate(Date  enableDate) {
		this.enableDate = enableDate;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	public Date  getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date  creatDate) {
		this.creatDate = creatDate;
	}
	@Transient
	public String getWindName() {
		return windName;
	}
	@Transient
	public void setWindName(String windName) {
		this.windName = windName;
	}
	
	
}