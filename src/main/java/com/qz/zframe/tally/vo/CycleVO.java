package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.tally.entity.Cycle;
import com.qz.zframe.tally.entity.PeriodTime;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class CycleVO {
    //周期id
    @ApiModelProperty(value="周期id",name="cycleId",required=false)
    private String cycleId;
    //路线id
    @ApiModelProperty(value="路线id",name="routeId",required=false)
    private String routeId;
    //周期名称
    @ApiModelProperty(value="周期名称",name="cycleName",required=false)
    private String cycleName;
    //周期单位
    @ApiModelProperty(value="周期单位",name="cycleUnit",required=false)
    private String cycleUnit;
    //基准日期
    @ApiModelProperty(value="基准日期",name="benchmarkDate",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date benchmarkDate;
    //周期
    @ApiModelProperty(value="周期",name="cycle",required=false)
    private String cycle;

    private List<PeriodTime> periodTimeList;

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public Date getBenchmarkDate() {
        return benchmarkDate;
    }

    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public List<PeriodTime> getPeriodTimeList() {
        return periodTimeList;
    }

    public void setPeriodTimeList(List<PeriodTime> periodTimeList) {
        this.periodTimeList = periodTimeList;
    }
}
