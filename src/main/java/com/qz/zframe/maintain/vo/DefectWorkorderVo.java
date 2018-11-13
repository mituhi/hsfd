package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.*;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class DefectWorkorderVo extends DefectWorkorder {

    @ApiParam(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiParam(name = "positionName", value = "位置名称", required = false)
    private String positionName;

    @ApiParam(name = "crewName", value = "机组名称", required = false)
    private String crewName;

    @ApiParam(name = "equipmentName", value = "设备名称", required = false)
    private String equipmentName;

    @ApiParam(name = "workorderTypeName", value = "工单类型名称", required = false)
    private String workorderTypeName;

    @ApiParam(name = "breakdownLocationTitle", value = "故障位置名称", required = false)
    private String breakdownLocationTitle;

    @ApiParam(name = "breakdownAttributeTitle", value = "故障属性名称", required = false)
    private String breakdownAttributeTitle;

    @ApiParam(name = "dealModeTitle", value = "工单类型名称", required = false)
    private String dealModeTitle;

    @ApiParam(name = "workorderProcessList", value = "工序List", required = true)
    private List<WorkorderProcess> workorderProcessList = new ArrayList<>();

    @ApiParam(name = "workorderMaterialList", value = "物资List", required = false)
    private List<WorkorderMaterial> workorderMaterialList = new ArrayList<>();

    @ApiParam(name = "workorderServiceList", value = "服务List", required = false)
    private List<WorkorderService> workorderServiceList = new ArrayList<>();

    @ApiParam(name = "workorderToolList", value = "工器具List", required = false)
    private List<WorkorderTool> workorderToolList = new ArrayList<>();

    @ApiParam(name = "workorderWorktypeList", value = "工种List", required = false)
    private List<WorkorderWorktype> workorderWorktypeList = new ArrayList<>();

    @ApiParam(name = "workorderQualityAcceptance", value = "质量验收", required = false)
    private WorkorderQualityAcceptance workorderQualityAcceptance;

    @ApiParam(name = "workorderDangerPointList", value = "危险点控制List", required = false)
    private List<WorkorderDangerPoint> workorderDangerPointList = new ArrayList<>();

    @ApiParam(name = "workorderSummary", value = "工单总结", required = false)
    private WorkorderSummary workorderSummary;

    public List<WorkorderProcess> getWorkorderProcessList() {
        return workorderProcessList;
    }

    public void setWorkorderProcessList(List<WorkorderProcess> workorderProcessList) {
        this.workorderProcessList = workorderProcessList;
    }

    public List<WorkorderMaterial> getWorkorderMaterialList() {
        return workorderMaterialList;
    }

    public void setWorkorderMaterialList(List<WorkorderMaterial> workorderMaterialList) {
        this.workorderMaterialList = workorderMaterialList;
    }

    public List<WorkorderService> getWorkorderServiceList() {
        return workorderServiceList;
    }

    public void setWorkorderServiceList(List<WorkorderService> workorderServiceList) {
        this.workorderServiceList = workorderServiceList;
    }

    public List<WorkorderTool> getWorkorderToolList() {
        return workorderToolList;
    }

    public void setWorkorderToolList(List<WorkorderTool> workorderToolList) {
        this.workorderToolList = workorderToolList;
    }

    public List<WorkorderWorktype> getWorkorderWorktypeList() {
        return workorderWorktypeList;
    }

    public void setWorkorderWorktypeList(List<WorkorderWorktype> workorderWorktypeList) {
        this.workorderWorktypeList = workorderWorktypeList;
    }

    public WorkorderQualityAcceptance getWorkorderQualityAcceptance() {
        return workorderQualityAcceptance;
    }

    public void setWorkorderQualityAcceptance(WorkorderQualityAcceptance workorderQualityAcceptance) {
        this.workorderQualityAcceptance = workorderQualityAcceptance;
    }

    public List<WorkorderDangerPoint> getWorkorderDangerPointList() {
        return workorderDangerPointList;
    }

    public void setWorkorderDangerPointList(List<WorkorderDangerPoint> workorderDangerPointList) {
        this.workorderDangerPointList = workorderDangerPointList;
    }

    public WorkorderSummary getWorkorderSummary() {
        return workorderSummary;
    }

    public void setWorkorderSummary(WorkorderSummary workorderSummary) {
        this.workorderSummary = workorderSummary;
    }

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

    public String getWorkorderTypeName() {
        return workorderTypeName;
    }

    public void setWorkorderTypeName(String workorderTypeName) {
        this.workorderTypeName = workorderTypeName;
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

    public String getDealModeTitle() {
        return dealModeTitle;
    }

    public void setDealModeTitle(String dealModeTitle) {
        this.dealModeTitle = dealModeTitle;
    }
}
