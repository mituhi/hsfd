package com.qz.zframe.tally.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/*
时间段类
 */
public class PeriodTime {
    //时间段id
    private String periodTimeId;
    //开始时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    //结束时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public String getPeriodTimeId() {
        return periodTimeId;
    }

    public void setPeriodTimeId(String periodTimeId) {
        this.periodTimeId = periodTimeId;
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
}
