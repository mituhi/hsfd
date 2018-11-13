package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.BreakdownInfo;
import io.swagger.annotations.ApiParam;

public class BreakdownRes extends BreakdownInfo {

    @ApiParam(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiParam(name = "positionName", value = "位置名称", required = false)
    private String positionName;

    @ApiParam(name = "crewName", value = "机组名称", required = false)
    private String crewName;

    @ApiParam(name = "equipmentName", value = "设备名称", required = false)
    private String equipmentName;

    @ApiParam(name = "breakdownLocationTitle", value = "故障位置名称", required = false)
    private String breakdownLocationTitle;

    @ApiParam(name = "breakdownAttributeTitle", value = "故障属性名称", required = false)
    private String breakdownAttributeTitle;

    @ApiParam(name = "dealwithModeTitle", value = "故障处理方式", required = false)
    private String dealwithModeTitle;

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
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

    public String getBreakdownLocationTitle() {
        return breakdownLocationTitle;
    }

    public void setBreakdownLocationTitle(String breakdownLocationTitle) {
        this.breakdownLocationTitle = breakdownLocationTitle;
    }

    public String getBreakdownAttributeTitle() {
        return breakdownAttributeTitle;
    }

    public void setBreakdownAttributeTitle(String breakdownAttributeTitle) {
        this.breakdownAttributeTitle = breakdownAttributeTitle;
    }

    public String getDealwithModeTitle() {
        return dealwithModeTitle;
    }

    public void setDealwithModeTitle(String dealwithModeTitle) {
        this.dealwithModeTitle = dealwithModeTitle;
    }
}