package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class QianDuanNeed {

    @ApiModelProperty(value="班次id",name="shiftId",required=false)
    private String shiftId;

    @ApiModelProperty(value="值次id",name="valueId",required=false)
    private String valueId;

    @ApiModelProperty(value="值次名称",name="valueName",required=false)
    private String valueName;

    @ApiModelProperty(value="用户id拼接",name="userIds",required=false)
    private String userIds;

    @ApiModelProperty(value="用户名称拼接",name="userNames",required=false)
    private String userNames;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }
}
