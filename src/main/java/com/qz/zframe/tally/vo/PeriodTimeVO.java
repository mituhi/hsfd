package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class PeriodTimeVO {

    //开始时间
    @ApiModelProperty(value="开始时间",name="startTimes",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTimes;
    //结束时间
    @ApiModelProperty(value="结束时间",name="endTimes",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTimes;

    public Date getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(Date startTimes) {
        this.startTimes = startTimes;
    }

    public Date getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(Date endTimes) {
        this.endTimes = endTimes;
    }
}
