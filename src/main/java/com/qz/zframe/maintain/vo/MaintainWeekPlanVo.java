package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.MaintainWeekPlan;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class MaintainWeekPlanVo extends MaintainWeekPlan {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name = "statusName", value = "状态名称", required = false)
    private String statusName;

    @ApiModelProperty(name = "maintainerName", value = "维护人姓名", required = false)
    private String maintainerName;

    @ApiModelProperty(name="recordPersonName",value="记录人姓名",required=false)
    private String recordPersonName;

    @ApiModelProperty(name="onDutyPersonName",value="当班人员姓名,逗号隔开",required=false)
    private String onDutyPersonName;

    @ApiModelProperty(name="workContentList",value="本周工作内容list",required=false)
    private List<MaintainWorkContentVo> thisWeekWorkContentList = new ArrayList<>();

    @ApiModelProperty(name="workContentList",value="上周工作内容list",required=false)
    private List<MaintainWorkContentVo> lastWeekWorkContentList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
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

    public String getRecordPersonName() {
        return recordPersonName;
    }

    public void setRecordPersonName(String recordPersonName) {
        this.recordPersonName = recordPersonName;
    }

    public String getOnDutyPersonName() {
        return onDutyPersonName;
    }

    public void setOnDutyPersonName(String onDutyPersonName) {
        this.onDutyPersonName = onDutyPersonName;
    }

    public List<MaintainWorkContentVo> getThisWeekWorkContentList() {
        return thisWeekWorkContentList;
    }

    public void setThisWeekWorkContentList(List<MaintainWorkContentVo> thisWeekWorkContentList) {
        this.thisWeekWorkContentList = thisWeekWorkContentList;
    }

    public List<MaintainWorkContentVo> getLastWeekWorkContentList() {
        return lastWeekWorkContentList;
    }

    public void setLastWeekWorkContentList(List<MaintainWorkContentVo> lastWeekWorkContentList) {
        this.lastWeekWorkContentList = lastWeekWorkContentList;
    }
}
