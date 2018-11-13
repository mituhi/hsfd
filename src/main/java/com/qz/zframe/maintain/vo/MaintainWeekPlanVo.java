package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.MaintainWeekPlan;
import com.qz.zframe.maintain.entity.MaintainWorkContent;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class MaintainWeekPlanVo extends MaintainWeekPlan {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="workContentList",value="本周工作内容list",required=false)
    private List<MaintainWorkContent> thisWeekWorkContentList = new ArrayList<>();

    @ApiParam(name="workContentList",value="上周工作内容list",required=false)
    private List<MaintainWorkContent> lastWeekWorkContentList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public List<MaintainWorkContent> getThisWeekWorkContentList() {
        return thisWeekWorkContentList;
    }

    public void setThisWeekWorkContentList(List<MaintainWorkContent> thisWeekWorkContentList) {
        this.thisWeekWorkContentList = thisWeekWorkContentList;
    }

    public List<MaintainWorkContent> getLastWeekWorkContentList() {
        return lastWeekWorkContentList;
    }

    public void setLastWeekWorkContentList(List<MaintainWorkContent> lastWeekWorkContentList) {
        this.lastWeekWorkContentList = lastWeekWorkContentList;
    }
}
