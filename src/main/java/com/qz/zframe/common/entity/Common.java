package com.qz.zframe.common.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户基本信息
 */
public class Common {
	
	@ApiModelProperty(value="用户id",name="userId",required=false)
	private String userId;
	@ApiModelProperty(value="用户名称",name="userName",required=false)
	private String userName;
	@ApiModelProperty(value="当前时间",name="nowTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date timeForDay;
	@ApiModelProperty(value="当前时间",name="nowTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date imeForSeconds;
	@ApiModelProperty(value="用户所属风电场id",name="windId",required=false)
	private String windId;
	@ApiModelProperty(value="用户所属风电场名称",name="windName",required=false)
	private String windName;
	@ApiModelProperty(value="用户所属风电场编号",name="windCode",required=false)
	private String windCode;
	@ApiModelProperty(value="用户所属风电场类型",name="windType",required=false)
	private String windType;
	@ApiModelProperty(value="用户所属部门id",name="deptId",required=false)
	private String deptId;
	@ApiModelProperty(value="用户所属部门编号",name="deptCode",required=false)
	private String deptCode;
	@ApiModelProperty(value="用户所属部门名称",name="deptName",required=false)
	private String deptName;
	@ApiModelProperty(value="用户所属部门类型",name="deptType",required=false)
	private String deptType;
	@ApiModelProperty(value="用户所属公司id",name="companyId",required=false)
	private String companyId;
	@ApiModelProperty(value="用户所属公司编号",name="companyCode",required=false)
	private String companyCode;
	@ApiModelProperty(value="用户所属公司名称",name="companyName",required=false)
	private String companyName;
	@ApiModelProperty(value="用户所属公司类型",name="companyType",required=false)
	private String companyType;
	@ApiModelProperty(value="用户所属班组id",name="teamId",required=false)
	private String teamId;
	@ApiModelProperty(value="用户所属班组编号",name="teamCode",required=false)
	private String teamCode;
	@ApiModelProperty(value="用户所属班组名称",name="teamName",required=false)
	private String teamName;
	@ApiModelProperty(value="用户所属班组类型",name="teamType",required=false)
	private String teamType;
	@ApiModelProperty(value="用户角色",name="roles",required=false)
	private List<Role> roles;
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
	public Date getTimeForDay() {
		return timeForDay;
	}
	public void setTimeForDay(Date timeForDay) {
		this.timeForDay = timeForDay;
	}
	public Date getImeForSeconds() {
		return imeForSeconds;
	}
	public void setImeForSeconds(Date imeForSeconds) {
		this.imeForSeconds = imeForSeconds;
	}

	public String getWindId() {
		return windId;
	}

	public void setWindId(String windId) {
		this.windId = windId;
	}

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getWindCode() {
		return windCode;
	}

	public void setWindCode(String windCode) {
		this.windCode = windCode;
	}

	public String getWindType() {
		return windType;
	}

	public void setWindType(String windType) {
		this.windType = windType;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
