package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class WorkPerformSearch {
	@ApiModelProperty(value="任务执行id",name="performId")
    private String performId;

	@ApiModelProperty(value="任务编号",name="serialNum")
    private String serialNum;

	@ApiModelProperty(value="工作名称",name="workName")
    private String workName;

	@ApiModelProperty(value="工作描述",name="workDescribe")
    private String workDescribe;

	@ApiModelProperty(value="负责班组",name="depart")
    private String depart;

	@ApiModelProperty(value="负责人",name="userId")
    private String userId;

	@ApiModelProperty(value="负责人名字",name="username")
    private String username;

	@ApiModelProperty(value="处理人",name="dealPeople")
    private String dealPeople;

	@ApiModelProperty(value="发起时间",name="startTime")
    private Date startTime;
	
	@ApiModelProperty(value="发起时间(导出Excel专用--可忽略)",name="startTimeStr")
	private String startTimeStr;

	@ApiModelProperty(value="计划完成时间",name="completeTime")
    private Date completeTime;

	@ApiModelProperty(value="计划完成时间(导出Excel专用--可忽略)",name="completeTimeStr")
	private String completeTimeStr;
	
	@ApiModelProperty(value="实际完成时间",name="endTime")
    private Date endTime;
	
	@ApiModelProperty(value="实际完成时间(导出Excel专用--可忽略)",name="endTimeStr")
	private String endTimeStr;

	@ApiModelProperty(value="完成状态",name="completeStatus")
    private String completeStatus;

	@ApiModelProperty(value="位置",name="address")
    private String address;

	@ApiModelProperty(value="机组",name="unit")
    private String unit;

	@ApiModelProperty(value="创建人",name="createUser")
    private String createUser;

    public String getPerformId() {
        return performId;
    }

    public void setPerformId(String performId) {
        this.performId = performId == null ? null : performId.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getWorkDescribe() {
        return workDescribe;
    }

    public void setWorkDescribe(String workDescribe) {
        this.workDescribe = workDescribe == null ? null : workDescribe.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDealPeople() {
        return dealPeople;
    }

    public void setDealPeople(String dealPeople) {
        this.dealPeople = dealPeople == null ? null : dealPeople.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus == null ? null : completeStatus.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getCompleteTimeStr() {
		return completeTimeStr;
	}

	public void setCompleteTimeStr(String completeTimeStr) {
		this.completeTimeStr = completeTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
    
    
    
}