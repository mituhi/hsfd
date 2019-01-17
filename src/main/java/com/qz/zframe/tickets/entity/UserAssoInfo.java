package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiModelProperty;

public class UserAssoInfo {

    @ApiModelProperty(name="assoId",value="关联id",required=false)
    private String assoId;

    @ApiModelProperty(name="workTicketTypeId",value="工作票类型id",required=false)
    private String workTicketTypeId;

    @ApiModelProperty(name="operTicketTypeId",value="操作票类型id",required=false)
    private String operTicketTypeId;

    @ApiModelProperty(name="userNumbet",value="编号",required=false)
    private String userNumbet;

    @ApiModelProperty(name="userId",value="人员id",required=false)
    private String userId;

    @ApiModelProperty(name="userWorkNumber",value="人员工号",required=false)
    private String userWorkNumber;

    @ApiModelProperty(name="userName",value="人员名称",required=false)
    private String userName;

    @ApiModelProperty(name="userUnit",value="单位",required=false)
    private String userUnit;

    @ApiModelProperty(name="userType",value="人员类型",required=false)
    private String userType;

    public String getAssoId() {
        return assoId;
    }

    public void setAssoId(String assoId) {
        this.assoId = assoId == null ? null : assoId.trim();
    }

    public String getWorkTicketTypeId() {
        return workTicketTypeId;
    }

    public void setWorkTicketTypeId(String workTicketTypeId) {
        this.workTicketTypeId = workTicketTypeId == null ? null : workTicketTypeId.trim();
    }

    public String getOperTicketTypeId() {
        return operTicketTypeId;
    }

    public void setOperTicketTypeId(String operTicketTypeId) {
        this.operTicketTypeId = operTicketTypeId == null ? null : operTicketTypeId.trim();
    }

    public String getUserNumbet() {
        return userNumbet;
    }

    public void setUserNumbet(String userNumbet) {
        this.userNumbet = userNumbet == null ? null : userNumbet.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserWorkNumber() {
        return userWorkNumber;
    }

    public void setUserWorkNumber(String userWorkNumber) {
        this.userWorkNumber = userWorkNumber == null ? null : userWorkNumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(String userUnit) {
        this.userUnit = userUnit == null ? null : userUnit.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}