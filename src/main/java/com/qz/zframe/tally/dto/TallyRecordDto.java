package com.qz.zframe.tally.dto;

import java.util.Date;

public class TallyRecordDto {
    //主键id
    private String recordId;
    //路线id
    private String routeId;
    //点检人姓名
    private String practitionerName;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //标准数量
    private String StandardQuantity;
    //记录数量
    private String recordNumber;
    //报警数量
    private String alarmNumber;
    //已处理报警数量
    private String processedAlerts;

    private String windId;

    private String routeName;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
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

    public String getStandardQuantity() {
        return StandardQuantity;
    }

    public void setStandardQuantity(String standardQuantity) {
        StandardQuantity = standardQuantity;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getAlarmNumber() {
        return alarmNumber;
    }

    public void setAlarmNumber(String alarmNumber) {
        this.alarmNumber = alarmNumber;
    }

    public String getProcessedAlerts() {
        return processedAlerts;
    }

    public void setProcessedAlerts(String processedAlerts) {
        this.processedAlerts = processedAlerts;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
