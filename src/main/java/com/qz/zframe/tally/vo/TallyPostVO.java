package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class TallyPostVO {
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
    //开始时间
    @ApiModelProperty(value="开始时间",name="startTimes",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private List<Date> startTimes;
    //结束时间
    @ApiModelProperty(value="结束时间",name="endTimes",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private List<Date> endTimes;
    //人员
    @ApiModelProperty(value="人员",name="userNames",required=true)
    private String userNames;
    //人员
    @ApiModelProperty(value="用户id",name="userId",required=true)
    private String userId;

    //身份
    @ApiModelProperty(value="身份（点检执行者0，路线管理者1，漏检负责人2）",name="identity",required=true)
    private String identity;

    //部门
    @ApiModelProperty(value="部门",name="department",required=true)
    private String department;



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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
