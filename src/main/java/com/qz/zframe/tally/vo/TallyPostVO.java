package com.qz.zframe.tally.vo;

import java.util.Date;
import java.util.List;

public class TallyPostVO {
    //流水号
    private int serialNum;
    //维护人员
    private String maintenancer;
    //申请日期
    private Date maintenanceTime;
    //路线编码
    private String routeCode;
    //风电场
    private String windId;
    //路线名称
    private String routeName;
    //强制次序
    private String mandatoryOrder;
    //巡检路线备注
    private String tallyRouteRemark;
    //周期名称
    private String cycleName;
    //基准日期
    private Date benchmarkDate;
    //路线id
    private String routeId;
    //周期单位
    private String cycleUnit;
    //周期
    private String cycle;
    //开始时间
    private List<Date> startTimes;
    //结束时间
    private List<Date> endTimes;
    //人员
    private List<String> userNames;

    //身份
    private String identity;

    //备注人员
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

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
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
