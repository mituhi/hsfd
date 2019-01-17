package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.common.entity.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class OrgArchitectureVO {
	
	@ApiModelProperty(value="架构id",name="architectureId",required=false)
	private String architectureId;
	@ApiModelProperty(value="架构编码",name="architectureCode",required=true)
	private String architectureCode;
	@ApiModelProperty(value="架构名称",name="architectureName",required=true)
	private String architectureName;
	@ApiModelProperty(value="描述",name="architectureDescribe",required=false)
	private String architectureDescribe;
	@ApiModelProperty(value="组织类型",name="architectureType",required=true)
	private String architectureType;
	@ApiModelProperty(value="组织类型名称",name="architectureTypeText",required=false)
	private String architectureTypeText;
	@ApiModelProperty(value="是否顶级",name="isTop",required=true)
	private String isTop;
	@ApiModelProperty(value="是否顶级名称",name="isTopText",required=true)
	private String isTopText;
	@ApiModelProperty(value="是否停用",name="isDisable",required=true)
	private String isDisable;
	@ApiModelProperty(value="是否停用名称",name="isDisableText",required=false)
	private String isDisableText;
	@ApiModelProperty(value="是否虚拟组织",name="isVirtualOrg",required=true)
	private String isVirtualOrg;
	@ApiModelProperty(value="是否虚拟组织名称",name="isVirtualOrgText",required=false)
	private String isVirtualOrgText;
	@ApiModelProperty(value="上级主管部门",name="superCompetentDepartment",required=false)
	private String superCompetentDepartment;
	@ApiModelProperty(value="分管领导",name="chargeLeadership",required=false)
	private String chargeLeadership;
	@ApiModelProperty(value="负责人",name="header",required=false)
	private String header;
	@ApiModelProperty(value="负责人名称",name="headerheaderName",required=false)
	private String headerName;
	@ApiModelProperty(value="部门编制",name="departmentCompile",required=false)
	private String departmentCompile;
	@ApiModelProperty(value="成立日期",name="setUpTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date setUpTime;
	@ApiModelProperty(value="撤销日期",name="undoTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date undoTime;
	@ApiModelProperty(value="安全等级",name="securityLevel",required=false)
	private String securityLevel;
	@ApiModelProperty(value="电子邮箱",name="email",required=false)
	private String email;
	@ApiModelProperty(value="电话",name="phone",required=false)
	private String phone;
	@ApiModelProperty(value="传真",name="fax",required=false)
	private String fax;
	@ApiModelProperty(value="工作内容",name="workContent",required=false)
	private String workContent;
	@ApiModelProperty(value="备注",name="remark",required=false)
	private String remark;
	
	@ApiModelProperty(value="机构注册信息",name="registrationInformation",required=false)
	private RegistrationInformation registrationInformation;
	@ApiModelProperty(value="风电场信息",name="windField",required=false)
	private WindField windField;
	@ApiModelProperty(value="部门信息",name="orgArchitectureUser",required=false)
	private List<OrgArchitectureUser> orgArchitectureUsers;
	@ApiModelProperty(value="班组信息",name="orgArchitectureTeams",required=false)
	private List<OrgArchitectureTeam> orgArchitectureTeams;
	@ApiModelProperty(value="成本中心",name="orgArchitectureCenters",required=false)
	private List<OrgArchitectureCenter> orgArchitectureCenters;

	private String youNeed;

	public String getYouNeed() {
		return youNeed;
	}

	public void setYouNeed(String youNeed) {
		this.youNeed = youNeed;
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

	public String getArchitectureName() {
		return architectureName;
	}

	public void setArchitectureName(String architectureName) {
		this.architectureName = architectureName;
	}

	public String getArchitectureDescribe() {
		return architectureDescribe;
	}

	public void setArchitectureDescribe(String architectureDescribe) {
		this.architectureDescribe = architectureDescribe;
	}

	public String getArchitectureType() {
		return architectureType;
	}

	public void setArchitectureType(String architectureType) {
		this.architectureType = architectureType;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(String isDisable) {
		this.isDisable = isDisable;
	}

	public String getIsVirtualOrg() {
		return isVirtualOrg;
	}

	public void setIsVirtualOrg(String isVirtualOrg) {
		this.isVirtualOrg = isVirtualOrg;
	}

	public String getSuperCompetentDepartment() {
		return superCompetentDepartment;
	}

	public void setSuperCompetentDepartment(String superCompetentDepartment) {
		this.superCompetentDepartment = superCompetentDepartment;
	}

	public String getChargeLeadership() {
		return chargeLeadership;
	}

	public void setChargeLeadership(String chargeLeadership) {
		this.chargeLeadership = chargeLeadership;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDepartmentCompile() {
		return departmentCompile;
	}

	public void setDepartmentCompile(String departmentCompile) {
		this.departmentCompile = departmentCompile;
	}

	public Date getSetUpTime() {
		return setUpTime;
	}

	public void setSetUpTime(Date setUpTime) {
		this.setUpTime = setUpTime;
	}

	public Date getUndoTime() {
		return undoTime;
	}

	public void setUndoTime(Date undoTime) {
		this.undoTime = undoTime;
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public RegistrationInformation getRegistrationInformation() {
		return registrationInformation;
	}

	public void setRegistrationInformation(RegistrationInformation registrationInformation) {
		this.registrationInformation = registrationInformation;
	}

	public WindField getWindField() {
		return windField;
	}

	public void setWindField(WindField windField) {
		this.windField = windField;
	}

	public List<OrgArchitectureUser> getOrgArchitectureUsers() {
		return orgArchitectureUsers;
	}

	public void setOrgArchitectureUsers(List<OrgArchitectureUser> orgArchitectureUsers) {
		this.orgArchitectureUsers = orgArchitectureUsers;
	}

	public List<OrgArchitectureTeam> getOrgArchitectureTeams() {
		return orgArchitectureTeams;
	}

	public void setOrgArchitectureTeams(List<OrgArchitectureTeam> orgArchitectureTeams) {
		this.orgArchitectureTeams = orgArchitectureTeams;
	}

	public List<OrgArchitectureCenter> getOrgArchitectureCenters() {
		return orgArchitectureCenters;
	}

	public void setOrgArchitectureCenters(List<OrgArchitectureCenter> orgArchitectureCenters) {
		this.orgArchitectureCenters = orgArchitectureCenters;
	}

	public String getArchitectureTypeText() {
		return architectureTypeText;
	}

	public void setArchitectureTypeText(String architectureTypeText) {
		this.architectureTypeText = architectureTypeText;
	}

	public String getIsTopText() {
		return isTopText;
	}

	public void setIsTopText(String isTopText) {
		this.isTopText = isTopText;
	}

	public String getIsDisableText() {
		return isDisableText;
	}

	public void setIsDisableText(String isDisableText) {
		this.isDisableText = isDisableText;
	}

	public String getIsVirtualOrgText() {
		return isVirtualOrgText;
	}

	public void setIsVirtualOrgText(String isVirtualOrgText) {
		this.isVirtualOrgText = isVirtualOrgText;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

}
