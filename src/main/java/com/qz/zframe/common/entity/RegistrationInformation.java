package com.qz.zframe.common.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class RegistrationInformation {
	
	@ApiModelProperty(value="机构id",name="registrationId",required=false)
	private String registrationId;
	@ApiModelProperty(value="架构id",name="architectureId",required=true)
	private String architectureId;
	@ApiModelProperty(value="机构代码",name="registrationCode",required=true)
	private String registrationCode;
	@ApiModelProperty(value="法定代表人",name="legalRepresentative",required=false)
	private String legalRepresentative;
	@ApiModelProperty(value="行业类别",name="industryType",required=false)
	private String industryType;
	@ApiModelProperty(value="业务板块",name="businessSector",required=false)
	private String businessSector;
	@ApiModelProperty(value="注册类型",name="registrationType",required=false)
	private String registrationType;
	@ApiModelProperty(value="注册日期",name="registrationTime",required=false)
	private Date registrationTime;
	@ApiModelProperty(value="有效起始时间",name="startTime",required=false)
	private Date startTime;
	@ApiModelProperty(value="有效结束时间",name="endTime",required=false)
	private Date endTime;
	@ApiModelProperty(value="注册资本",name="registrationCapital",required=false)
	private String registrationCapital;
	@ApiModelProperty(value="营业执照",name="businessLicense",required=false)
	private String businessLicense;
	@ApiModelProperty(value="国税等级",name="irsLevel",required=false)
	private String irsLevel;
	@ApiModelProperty(value="地税登记",name="taxRegistration",required=false)
	private String taxRegistration;
	@ApiModelProperty(value="注册地址",name="registrationAddress",required=false)
	private String registrationAddress;
	
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getArchitectureId() {
		return architectureId;
	}
	public void setArchitectureId(String architectureId) {
		this.architectureId = architectureId;
	}
	public String getRegistrationCode() {
		return registrationCode;
	}
	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getBusinessSector() {
		return businessSector;
	}
	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}
	public String getRegistrationType() {
		return registrationType;
	}
	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}
	public Date getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRegistrationCapital() {
		return registrationCapital;
	}
	public void setRegistrationCapital(String registrationCapital) {
		this.registrationCapital = registrationCapital;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getIrsLevel() {
		return irsLevel;
	}
	public void setIrsLevel(String irsLevel) {
		this.irsLevel = irsLevel;
	}
	public String getTaxRegistration() {
		return taxRegistration;
	}
	public void setTaxRegistration(String taxRegistration) {
		this.taxRegistration = taxRegistration;
	}
	public String getRegistrationAddress() {
		return registrationAddress;
	}
	public void setRegistrationAddress(String registrationAddress) {
		this.registrationAddress = registrationAddress;
	}
	
}
