package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TallyUnCheckedVO {
    //风电场
    private String windId;
    //路线名称
    private String routeName;
    //开始时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date benchmarkDate;
    //结束时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;
    //计划执行人名
    private List<String> userNames;
    //实际执行人名
    private String practitionerName;
    //未检数量
    private String uncheckedQuantity;
    //已检数量
    private String checkedQuantity;
    //总数
    private String total;
    //漏检率
    private String leakageRate;
    //已备注数量
    private String volumeRemarks;
    //备注详情
    private String volumeDetails;
    //周期
    private String cycle;
    //周期单位
    private String cycleUnit;

    private String routeId;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
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

    public Date getBenchmarkDate() {
        return benchmarkDate;
    }

    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public String getUncheckedQuantity() {
        return uncheckedQuantity;
    }

    public void setUncheckedQuantity(String uncheckedQuantity) {
        this.uncheckedQuantity = uncheckedQuantity;
    }

    public String getCheckedQuantity() {
        return checkedQuantity;
    }

    public void setCheckedQuantity(String checkedQuantity) {
        this.checkedQuantity = checkedQuantity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLeakageRate() {
        return leakageRate;
    }

    public void setLeakageRate(String leakageRate) {
        this.leakageRate = leakageRate;
    }

    public String getVolumeRemarks() {
        return volumeRemarks;
    }

    public void setVolumeRemarks(String volumeRemarks) {
        this.volumeRemarks = volumeRemarks;
    }

    public String getVolumeDetails() {
        return volumeDetails;
    }

    public void setVolumeDetails(String volumeDetails) {
        this.volumeDetails = volumeDetails;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }
}
