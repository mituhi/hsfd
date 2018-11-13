package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class WindField {
	
	@ApiModelProperty(value="风电场id",name="windId",required=false)
	private String windId;
	@ApiModelProperty(value="架构id",name="architectureId",required=false)
	private String architectureId;
	@ApiModelProperty(value="风场名称",name="windName",required=false)
	private String windName;
	@ApiModelProperty(value="状态",name="windStatus",required=false)
	private String windStatus;
	@ApiModelProperty(value="是否有价值",name="isValuable",required=false)
	private String isValuable;
	@ApiModelProperty(value="备注",name="remark",required=false)
	private String remark;
	
	public String getWindId() {
		return windId;
	}
	public void setWindId(String windId) {
		this.windId = windId;
	}
	public String getArchitectureId() {
		return architectureId;
	}
	public void setArchitectureId(String architectureId) {
		this.architectureId = architectureId;
	}
	public String getWindName() {
		return windName;
	}
	public void setWindName(String windName) {
		this.windName = windName;
	}
	public String getWindStatus() {
		return windStatus;
	}
	public void setWindStatus(String windStatus) {
		this.windStatus = windStatus;
	}
	public String getIsValuable() {
		return isValuable;
	}
	public void setIsValuable(String isValuable) {
		this.isValuable = isValuable;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
