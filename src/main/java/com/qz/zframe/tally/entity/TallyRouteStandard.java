package com.qz.zframe.tally.entity;

public class TallyRouteStandard {
    //关联表主键di
    private String id;
    //路线id
    private String routeId;
    //标准id
    private String standardId;
    //周期id
    private String cycleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }
}
