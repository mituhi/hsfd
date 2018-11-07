package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.BreakdownInfo;
import io.swagger.annotations.ApiParam;

public class BreakdownVo extends BreakdownInfo {

    @ApiParam(name="modeName",value="处理方式名称",required=false)
    private String modeName;

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="teamName",value="班组名称",required=false)
    private String teamName;

    @ApiParam(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiParam(name="crewName",value="机组名称",required=false)
    private String  crewName;

    @ApiParam(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiParam(name="locationName",value="故障位置名称",required=false)
    private String locationName;

    @ApiParam(name="attribute",value="故障属性名称",required=false)
    private String attributeName;

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}
