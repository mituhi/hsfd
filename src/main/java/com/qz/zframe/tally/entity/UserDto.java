package com.qz.zframe.tally.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class UserDto {
	
	@ApiModelProperty(value="用户id",name="userId",required=false)
    private String userId;
	@ApiModelProperty(value="用户账号",name="userAccount",required=false)
    private String userAccount;
	@ApiModelProperty(value="用户密码",name="userPassword",required=false)
    private String userPassword;
	@ApiModelProperty(value="用户名称",name="userName",required=false)
    private String userName;
	@ApiModelProperty(value="用户性别编码",name="userSex",required=false)
    private String userSex;
	@ApiModelProperty(value="用户性别名称",name="userSexText",required=false)
    private String userSexText;
	@ApiModelProperty(value="手机号码",name="mobile",required=false)
    private String mobile;
	@ApiModelProperty(value="用户状态编码",name="userStatus",required=false)
    private String userStatus;
	@ApiModelProperty(value="用户状态名称",name="userStatusText",required=false)
    private String userStatusText;
	@ApiModelProperty(value="密码错误次数",name="pwdErrorCount",required=false)
    private Integer pwdErrorCount;
	@ApiModelProperty(value="是否管理员",name="admin",required=false)
    private String admin;
	@ApiModelProperty(value="创建时间",name="createTime",required=false)
    private Date createTime;
	@ApiModelProperty(value="锁定时间",name="lockTime",required=false)
    private Date lockTime;
	@ApiModelProperty(value="顺序号",name="orderNo",required=false)
    private Integer orderNo;
	@ApiModelProperty(value="用户角色",name="roleName",required=false)
    private String roleName;
	@ApiModelProperty(value="所属部门名称",name="architectureName",required=false)
    private String architectureName;
	@ApiModelProperty(value="所属部门编号",name="architectureCode",required=false)
	private String architectureCode;

    /**
     * 扩展字段
     */
    private String extend1;
    private String extend2;
    private String extend3;
    private String extend4;

    @ApiModelProperty(value="用户角色",name="roles",required=false)
    private List<String> roles;
    @ApiModelProperty(value="部门id",name="architectureId",required=false)
    private String architectureId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserSexText() {
		return userSexText;
	}

	public void setUserSexText(String userSexText) {
		this.userSexText = userSexText;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserStatusText() {
		return userStatusText;
	}

	public void setUserStatusText(String userStatusText) {
		this.userStatusText = userStatusText;
	}

	public Integer getPwdErrorCount() {
		return pwdErrorCount;
	}

	public void setPwdErrorCount(Integer pwdErrorCount) {
		this.pwdErrorCount = pwdErrorCount;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getArchitectureName() {
		return architectureName;
	}

	public void setArchitectureName(String architectureName) {
		this.architectureName = architectureName;
	}

	public String getArchitectureId() {
		return architectureId;
	}

	public void setArchitectureId(String architectureId) {
		this.architectureId = architectureId;
	}

	public String getArchitectureCode() {
		return architectureCode;
	}

	public void setArchitectureCode(String architectureCode) {
		this.architectureCode = architectureCode;
	}
}
