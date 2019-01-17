package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.BreakdownInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BreakdownVo extends BreakdownInfo {

    @ApiModelProperty(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiModelProperty(name = "positionName", value = "位置名称", required = false)
    private String positionName;

    @ApiModelProperty(name = "crewName", value = "机组名称", required = false)
    private String crewName;

    @ApiModelProperty(name = "equipmentName", value = "设备名称", required = false)
    private String equipmentName;

    @ApiModelProperty(name = "breakdownLocationTitle", value = "故障位置名称", required = false)
    private String breakdownLocationTitle;

    @ApiModelProperty(name = "breakdownAttributeTitle", value = "故障属性名称", required = false)
    private String breakdownAttributeTitle;

    @ApiModelProperty(name = "breakdownSourceTitle", value = "故障来源名称", required = false)
    private String breakdownSourceTitle;

    @ApiModelProperty(name = "dealTeamName", value = "处理班组名称", required = false)
    private String dealTeamName;

    @ApiModelProperty(name = "companyName", value = "公司名称", required = false)
    private String companyName;

    @ApiModelProperty(name = "statusName", value = "状态名称", required = false)
    private String statusName;

    @ApiModelProperty(name = "maintainerName", value = "维护人姓名", required = false)
    private String maintainerName;

    @ApiModelProperty(name = "dealwithPersonName", value = "处理(负责)人姓名", required = false)
    private String dealwithPersonName;

    @ApiModelProperty(name = "fillPersonName", value = "填报人姓名", required = false)
    private String fillPersonName;

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

    public String getBreakdownSourceTitle() {
        return breakdownSourceTitle;
    }

    public void setBreakdownSourceTitle(String breakdownSourceTitle) {
        this.breakdownSourceTitle = breakdownSourceTitle;
    }

    public String getDealTeamName() {
        return dealTeamName;
    }

    public void setDealTeamName(String dealTeamName) {
        this.dealTeamName = dealTeamName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    public String getDealwithPersonName() {
        return dealwithPersonName;
    }

    public void setDealwithPersonName(String dealwithPersonName) {
        this.dealwithPersonName = dealwithPersonName;
    }

    public String getFillPersonName() {
        return fillPersonName;
    }

    public void setFillPersonName(String fillPersonName) {
        this.fillPersonName = fillPersonName;
    }
}