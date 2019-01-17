package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class TallyPostVOW {
    //流水号
    @ApiModelProperty(value="流水号",name="serialNum",required=true)
    private int serialNum;
    //维护人员
    @ApiModelProperty(value="维护人员",name="maintenancer",required=true)
    private String maintenancer;
    //申请日期
    @ApiModelProperty(value="申请日期",name="maintenanceTime",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date maintenanceTime;
    //路线编码
    @ApiModelProperty(value="路线编码",name="routeCode",required=true)
    private String routeCode;
    //风电场
    @ApiModelProperty(value="风电场",name="windId",required=true)
    private String windId;
    //路线名称
    @ApiModelProperty(value="路线名称",name="routeName",required=true)
    private String routeName;
    //强制次序
    @ApiModelProperty(value="状态",name="status",required=true)
    private String status;
    //巡检路线备注
    @ApiModelProperty(value="巡检路线备注",name="tallyRouteRemark",required=false)
    private String tallyRouteRemark;
    //周期名称
    @ApiModelProperty(value="周期名称",name="cycleName",required=true)
    private String cycleName;
    //基准日期
    @ApiModelProperty(value="基准日期",name="benchmarkDate",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date benchmarkDate;

    //周期单位
    @ApiModelProperty(value="周期单位",name="cycleUnit",required=true)
    private String cycleUnit;
    //周期
    @ApiModelProperty(value="周期",name="cycle",required=true)
    private String cycle;

    //private List<PeriodTimeVO> periodTimeVOS;



    //路线id
    @ApiModelProperty(value="路线id（新增时不用填，修改时必填）",name="department",required=false)
    private String routeId;

    @ApiModelProperty(value="序号（不要填，自动生成）",name="cycleId",required=false)
    private String cycleId;


    private List<RouteUserVO3> routeUsers;

    public List<RouteUserVO3> getRouteUsers() {
        return routeUsers;
    }

    public void setRouteUsers(List<RouteUserVO3> routeUsers) {
        this.routeUsers = routeUsers;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getMaintenancer() {
        return maintenancer;
    }

    public void setMaintenancer(String maintenancer) {
        this.maintenancer = maintenancer;
    }

    public Date getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }


    public String getTallyRouteRemark() {
        return tallyRouteRemark;
    }

    public void setTallyRouteRemark(String tallyRouteRemark) {
        this.tallyRouteRemark = tallyRouteRemark;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public Date getBenchmarkDate() {
        return benchmarkDate;
    }

    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }

}
