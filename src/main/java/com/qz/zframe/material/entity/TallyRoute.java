package com.qz.zframe.material.entity;

import java.util.Date;

/*
点检路线表
 */
public class TallyRoute {
    //路线id
    private String routeId;
    //路线名称
    private String routeName;
    //路线编码
    private String routeCode;
    //所属风电场
    private String windId;
    //强制次序
    private String mandatoryOrder;
    //备注
    private String remark;
    //维护人
    private String maintenancer;
    //维护日期
    private Date maintenanceTime;
    //流水号
    private int serialNum;

    public TallyRoute() {
    }

    public TallyRoute(String routeId, String routeName, String routeCode, String windId, String mandatoryOrder, String remark, String maintenancer, Date maintenanceTime, int serialNum) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.routeCode = routeCode;
        this.windId = windId;
        this.mandatoryOrder = mandatoryOrder;
        this.remark = remark;
        this.maintenancer = maintenancer;
        this.maintenanceTime = maintenanceTime;
        this.serialNum = serialNum;
    }

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

    public String getMandatoryOrder() {
        return mandatoryOrder;
    }

    public void setMandatoryOrder(String mandatoryOrder) {
        this.mandatoryOrder = mandatoryOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return "TallyRoute{" +
                "routeId='" + routeId + '\'' +
                ", routeName='" + routeName + '\'' +
                ", routeCode='" + routeCode + '\'' +
                ", windId='" + windId + '\'' +
                ", mandatoryOrder='" + mandatoryOrder + '\'' +
                ", remark='" + remark + '\'' +
                ", maintenancer='" + maintenancer + '\'' +
                ", maintenanceTime=" + maintenanceTime +
                ", serialNum=" + serialNum +
                '}';
    }
}
