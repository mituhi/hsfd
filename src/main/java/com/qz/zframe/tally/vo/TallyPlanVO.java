package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class TallyPlanVO {
    @ApiModelProperty(value="线路名称",name="routeName",required=false)
    private String routeName;
    @ApiModelProperty(value="线路编码",name="routeCode",required=false)
    private String routeCode;
    @ApiModelProperty(value="风电场",name="windId",required=false)
    private String windId;
    @ApiModelProperty(value="周期",name="cycleUnit",required=false)
    private String cycle;
    @ApiModelProperty(value="周期单位",name="cycle",required=false)
    private String cycleUnit;
    @ApiModelProperty(value="开始时间",name="startTime",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty(value="结束时间",name="endTime",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty(value="点检人",name="userNames",required=false)
    private List<String> userNames;
    @ApiModelProperty(value="线路id",name="routeId",required=false)
    private String routeId;
    @ApiModelProperty(value="剩余时间",name="surplusTime",required=false)
    private String surplusTime;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

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

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
    }

    public String getSurplusTime() {
        return surplusTime;
    }

    public void setSurplusTime(String surplusTime) {
        this.surplusTime = surplusTime;
    }
}
