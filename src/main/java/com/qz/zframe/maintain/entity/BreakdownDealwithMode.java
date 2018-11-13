package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class BreakdownDealwithMode {

    @ApiParam(name="modeId",value="故障处理方式",required=false)
    private String modeId;

    @ApiParam(name="modeName",value="故障处理方式名称",required=false)
    private String modeName;

    public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId == null ? null : modeId.trim();
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName == null ? null : modeName.trim();
    }
}