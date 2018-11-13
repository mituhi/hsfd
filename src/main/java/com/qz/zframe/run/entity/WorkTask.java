package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class WorkTask {
	@ApiModelProperty(value="工作任务表id",name="workTaskId")
    private String workTaskId;

	@ApiModelProperty(value="工作分类表id",name="classificationId",required = true)
    private String classificationId;

	@ApiModelProperty(value="流水号/计划编号",name="serialNum")
    private String serialNum;

	@ApiModelProperty(value="风电场id",name="windId",required = true)
    private String windId;

	@ApiModelProperty(value="负责部门/负责班组",name="depart",required = true)
    private String depart;

	@ApiModelProperty(value="负责人",name="userId",required = true)
    private String userId;

	@ApiModelProperty(value="工作名称",name="workName",required = true)
    private String workName;

	@ApiModelProperty(value="工作描述",name="workDescribe")
    private String workDescribe;

	@ApiModelProperty(value="位置",name="address")
    private String address;

    @ApiModelProperty(value="设备",name="equipment")
    private String equipment;

    @ApiModelProperty(value="机组",name="unit")
    private String unit;

    @ApiModelProperty(value="开始时间",name="startTime",required = true)
    private Date startTime;

    @ApiModelProperty(value="频率时间/工作周期",name="rateTime",required = true)
    private Date rateTime;

    @ApiModelProperty(value="失效时间",name="failureTime")
    private Date failureTime;

    @ApiModelProperty(value="任务提前期",name="leadTime",required = true)
    private Integer leadTime;

    @ApiModelProperty(value="执行时限",name="executionTime",required = true)
    private Integer executionTime;

    @ApiModelProperty(value="状态",name="status",required = true)
    private String status;

    @ApiModelProperty(value="文件id",name="fileId")
    private String fileId;

    @ApiModelProperty(value="负责人名称",name="username")
    private String username;

    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;

    @ApiModelProperty(value="创建人",name="createUser")
    private String createUser;

    public String getWorkTaskId() {
        return workTaskId;
    }

    public void setWorkTaskId(String workTaskId) {
        this.workTaskId = workTaskId == null ? null : workTaskId.trim();
    }

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId == null ? null : classificationId.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }
}