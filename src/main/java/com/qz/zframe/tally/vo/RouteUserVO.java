package com.qz.zframe.tally.vo;
/*
路线人员关联表
 */
public class RouteUserVO {
    //关联id
    private String id;
    //路线id
    private String routeId;
    //用户id
    private String userId;
    //是否点检执行者
    private String isPractitioners;
    //是否路线管理者
    private String isManagers;
    //是否漏检负责人
    private String isHead;
    //备注
    private String remark;

    private String architectureName;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsPractitioners() {
        return isPractitioners;
    }

    public void setIsPractitioners(String isPractitioners) {
        this.isPractitioners = isPractitioners;
    }

    public String getIsManagers() {
        return isManagers;
    }

    public void setIsManagers(String isManagers) {
        this.isManagers = isManagers;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArchitectureName() {
        return architectureName;
    }

    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
    }
}
