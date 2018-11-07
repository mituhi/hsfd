package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TallyPlanVO {
    @ApiModelProperty(value="线路",name="routeName",required=false)
    private String routeName;
    @ApiModelProperty(value="开始时间",name="startTime",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty(value="结束时间",name="endTime",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty(value="负责人",name="maintenancer",required=false)
    private String maintenancer;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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

    public String getMaintenancer() {
        return maintenancer;
    }

    public void setMaintenancer(String maintenancer) {
        this.maintenancer = maintenancer;
    }
}
