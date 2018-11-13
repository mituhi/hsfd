package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.*;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeVo extends BreakdownKnowledgeBase {

    @ApiParam(name = "windName", value = "风电场名称", required = false)
    private String windName;

    @ApiParam(name = "breakdownLocationName", value = "故障位置名称", required = false)
    private String breakdownLocationName;

    @ApiParam(name = "breakdownAttributeName", value = "故障属性名称", required = false)
    private String breakdownAttributeName;

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

    @ApiParam(name = "workorderDangerPointList", value = "危险点控制List", required = false)
    private List<WorkorderDangerPoint> workorderDangerPointList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getBreakdownLocationName() {
        return breakdownLocationName;
    }

    public void setBreakdownLocationName(String breakdownLocationName) {
        this.breakdownLocationName = breakdownLocationName;
    }

    public String getBreakdownAttributeName() {
        return breakdownAttributeName;
    }

    public void setBreakdownAttributeName(String breakdownAttributeName) {
        this.breakdownAttributeName = breakdownAttributeName;
    }

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

    public List<WorkorderDangerPoint> getWorkorderDangerPointList() {
        return workorderDangerPointList;
    }

    public void setWorkorderDangerPointList(List<WorkorderDangerPoint> workorderDangerPointList) {
        this.workorderDangerPointList = workorderDangerPointList;
    }
}
