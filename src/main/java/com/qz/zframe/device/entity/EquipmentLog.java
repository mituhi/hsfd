package com.qz.zframe.device.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EquipmentLog {
  
	private  String logId;
	private  String userId;
	private  String userName;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private  Date date;
	private  String funcation ;
	private  String moduleId;
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFuncation() {
		return funcation;
	}
	public void setFuncation(String funcation) {
		this.funcation = funcation;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	
	
}
