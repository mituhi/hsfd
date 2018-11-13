package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.MaintainLogInfo;
import com.qz.zframe.maintain.entity.MaintainWorkContent;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class MaintainLogVo extends MaintainLogInfo {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="workContentList",value="当天工作内容list",required=false)
    private List<MaintainWorkContent> toDayWorkContentList = new ArrayList<>();

    @ApiParam(name="workContentList",value="昨天工作内容list",required=false)
    private List<MaintainWorkContent> yesterdayWorkContentList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public List<MaintainWorkContent> getToDayWorkContentList() {
        return toDayWorkContentList;
    }

    public void setToDayWorkContentList(List<MaintainWorkContent> toDayWorkContentList) {
        this.toDayWorkContentList = toDayWorkContentList;
    }

    public List<MaintainWorkContent> getYesterdayWorkContentList() {
        return yesterdayWorkContentList;
    }

    public void setYesterdayWorkContentList(List<MaintainWorkContent> yesterdayWorkContentList) {
        this.yesterdayWorkContentList = yesterdayWorkContentList;
    }
}
