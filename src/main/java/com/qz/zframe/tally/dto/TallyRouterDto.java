package com.qz.zframe.tally.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TallyRouterDto {
    @ApiModelProperty(value="路线的名称",name="routeName",required=false)
    private String routeName;
    @ApiModelProperty(value="路线编码",name="routeCode",required=false)
    private String routeCode;
    @ApiModelProperty(value="所属风电场",name="windId",required=false)
    private String windId;
    @ApiModelProperty(value="点检周期名称",name="cycleName",required=false)
    private String cycleName;
    @ApiModelProperty(value="路线ID",name="routeId",required=false)
    private String routeId;

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

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

}
