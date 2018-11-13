package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class OrgArchitectureTeam {
	
	@ApiModelProperty(value="关系id",name="relaId",required=false)
	private String relaId;
	@ApiModelProperty(value="架构id",name="architectureId",required=true)
	private String architectureId;
	@ApiModelProperty(value="用户id",name="userId",required=true)
	private String userId;
	@ApiModelProperty(value="用户名称",name="userName",required=false)
	private String userName;
	@ApiModelProperty(value="角色",name="roleName",required=false)
	private String roleName;
	
	public String getRelaId() {
		return relaId;
	}
	public void setRelaId(String relaId) {
		this.relaId = relaId;
	}
	public String getArchitectureId() {
		return architectureId;
	}
	public void setArchitectureId(String architectureId) {
		this.architectureId = architectureId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
