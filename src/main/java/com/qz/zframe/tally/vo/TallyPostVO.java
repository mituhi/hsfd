package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class TallyPostVO {
    //流水号
    @ApiModelProperty(value="流水号",name="serialNum",required=false)
    private int serialNum;
    //维护人员
    @ApiModelProperty(value="维护人员",name="maintenancer",required=false)
    private String maintenancer;
    //申请日期
    @ApiModelProperty(value="申请日期",name="maintenanceTime",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date maintenanceTime;
    //路线编码
    @ApiModelProperty(value="路线编码",name="routeCode",required=false)
    private String routeCode;
    //风电场
    @ApiModelProperty(value="风电场",name="windId",required=false)
    private String windId;
    //路线名称
    @ApiModelProperty(value="路线名称",name="routeName",required=false)
    private String routeName;
    //强制次序
    @ApiModelProperty(value="强制次序",name="mandatoryOrder",required=false)
    private String mandatoryOrder;
    //巡检路线备注
    @ApiModelProperty(value="巡检路线备注",name="tallyRouteRemark",required=false)
    private String tallyRouteRemark;
    //周期名称
    @ApiModelProperty(value="周期名称",name="cycleName",required=false)
    private String cycleName;
    //基准日期
    @ApiModelProperty(value="基准日期",name="benchmarkDate",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date benchmarkDate;
    //路线id
    @ApiModelProperty(value="路线id",name="routeId",required=false)
    private String routeId;
    //周期单位
    @ApiModelProperty(value="周期单位",name="cycleUnit",required=false)
    private String cycleUnit;
    //周期
    @ApiModelProperty(value="周期",name="cycle",required=false)
    private String cycle;
    //开始时间
    @ApiModelProperty(value="开始时间",name="startTimes",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private List<Date> startTimes;
    //结束时间
    @ApiModelProperty(value="结束时间",name="endTimes",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private List<Date> endTimes;
    //人员
    @ApiModelProperty(value="人员",name="userNames",required=false)
    private String userNames;

    //身份
    @ApiModelProperty(value="身份（点检执行者0，路线管理者1，漏检负责人2）",name="identity",required=false)
    private String identity;

    //备注人员
    @ApiModelProperty(value="备注-人员那张表的",name="iscUserRemark",required=false)
    private String iscUserRemark;

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

    public String getMandatoryOrder() {
        return mandatoryOrder;
    }

    public void setMandatoryOrder(String mandatoryOrder) {
        this.mandatoryOrder = mandatoryOrder;
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

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
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

    public List<Date> getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(List<Date> startTimes) {
        this.startTimes = startTimes;
    }

    public List<Date> getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(List<Date> endTimes) {
        this.endTimes = endTimes;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIscUserRemark() {
        return iscUserRemark;
    }

    public void setIscUserRemark(String iscUserRemark) {
        this.iscUserRemark = iscUserRemark;
    }
}
