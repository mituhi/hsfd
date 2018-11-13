package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class DeployRole {
	
	@ApiModelProperty(value="关系id",name="relaId",required=true)
	private String relaId;
	@ApiModelProperty(value="流程配置id",name="deployId",required=true)
	private String deployId;
	@ApiModelProperty(value="角色id",name="roleId",required=true)
	private String roleId;
	public String getRelaId() {
		return relaId;
	}
	public void setRelaId(String relaId) {
		this.relaId = relaId;
	}
	public String getDeployId() {
		return deployId;
	}
	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
