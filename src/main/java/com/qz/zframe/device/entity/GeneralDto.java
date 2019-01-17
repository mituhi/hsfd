package com.qz.zframe.device.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GeneralDto {
    private String id;
    private String userId;
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
    
    
    
}
