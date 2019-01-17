package com.qz.zframe.common.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class Role {
	
	@ApiModelProperty(value="角色id",name="roleId",required=false)
	private String roleId;
	@ApiModelProperty(value="上级角色id",name="rolePid",required=false)
    private String rolePid;
	@ApiModelProperty(value="角色名称",name="roleName",required=false)
    private String roleName;
	@ApiModelProperty(value="角色编码",name="roleCode",required=false)
    private String roleCode;
	@ApiModelProperty(value="创建时间",name="createTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;
	@ApiModelProperty(value="角色类型",name="orderNo",required=false)
    private Integer orderNo;
	@ApiModelProperty(value="排序号",name="roleType",required=false)
    private String roleType;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRolePid() {
		return rolePid;
	}
	public void setRolePid(String rolePid) {
		this.rolePid = rolePid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
    
}
