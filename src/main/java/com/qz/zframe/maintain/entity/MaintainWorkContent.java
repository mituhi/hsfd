package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiModelProperty;

public class MaintainWorkContent {

    @ApiModelProperty(name="workContentId",value="工作内容id",required=false)
    private String workContentId;

    @ApiModelProperty(name="dayId",value="日志id",required=false)
    private String dayId;

    @ApiModelProperty(name="weekId",value="维护周计划id",required=false)
    private String weekId;

    @ApiModelProperty(name="contentNumber",value="编号",required=false)
    private String contentNumber;

    @ApiModelProperty(name="workPlace",value="工作地点",required=false)
    private String workPlace;

    @ApiModelProperty(name="workTask",value="工作任务",required=false)
    private String workTask;

    @ApiModelProperty(name="staff",value="工作人员",required=false)
    private String staff;

    @ApiModelProperty(name="isComplete",value="是否完成",required=false)
    private String isComplete;

    @ApiModelProperty(name="workContentType",value="工作内容类型",required=false)
    private String workContentType;

    public String getWorkContentId() {
        return workContentId;
    }

    public void setWorkContentId(String workContentId) {
        this.workContentId = workContentId == null ? null : workContentId.trim();
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId == null ? null : dayId.trim();
    }

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId == null ? null : weekId.trim();
    }

    public String getContentNumber() {
        return contentNumber;
    }

    public void setContentNumber(String contentNumber) {
        this.contentNumber = contentNumber == null ? null : contentNumber.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getWorkTask() {
        return workTask;
    }

    public void setWorkTask(String workTask) {
        this.workTask = workTask == null ? null : workTask.trim();
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff == null ? null : staff.trim();
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete == null ? null : isComplete.trim();
    }

    public String getWorkContentType() {
        return workContentType;
    }

    public void setWorkContentType(String workContentType) {
        this.workContentType = workContentType == null ? null : workContentType.trim();
    }
}