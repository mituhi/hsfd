package com.qz.zframe.maintain.entity;

public class MaintainWorkContent {
    private String workContentId;

    private String dayId;

    private String weekId;

    private String contentNumber;

    private String workPlace;

    private String workTask;

    private String staff;

    private String isComplete;

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