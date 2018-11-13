package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class BreakdownLocation {

    @ApiParam(name="locationId",value="故障位置id",required=false)
    private String locationId;

    @ApiParam(name="locationName",value="故障位置名称",required=false)
    private String locationName;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId == null ? null : locationId.trim();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }
}