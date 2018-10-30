package com.qz.zframe.material.entity;
/*
时间段类
 */
public class PeriodTime {
    //时间段id
    private String periodTimeId;
    //周期id
    private String cycleId;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;

    public String getPeriodTimeId() {
        return periodTimeId;
    }

    public void setPeriodTimeId(String periodTimeId) {
        this.periodTimeId = periodTimeId;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
