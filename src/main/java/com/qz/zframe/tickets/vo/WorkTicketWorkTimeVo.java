package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.WorkTicketWorkTime;

public class WorkTicketWorkTimeVo extends WorkTicketWorkTime {

    private String workStartHeadName;

    private String workStartLicensorName;

    private String workEndHeadName;

    private String workEndLicensorName;

    public String getWorkStartHeadName() {
        return workStartHeadName;
    }

    public void setWorkStartHeadName(String workStartHeadName) {
        this.workStartHeadName = workStartHeadName;
    }

    public String getWorkStartLicensorName() {
        return workStartLicensorName;
    }

    public void setWorkStartLicensorName(String workStartLicensorName) {
        this.workStartLicensorName = workStartLicensorName;
    }

    public String getWorkEndHeadName() {
        return workEndHeadName;
    }

    public void setWorkEndHeadName(String workEndHeadName) {
        this.workEndHeadName = workEndHeadName;
    }

    public String getWorkEndLicensorName() {
        return workEndLicensorName;
    }

    public void setWorkEndLicensorName(String workEndLicensorName) {
        this.workEndLicensorName = workEndLicensorName;
    }
}
