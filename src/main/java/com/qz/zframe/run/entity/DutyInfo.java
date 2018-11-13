package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DutyInfo {
	
	
	@ApiModelProperty(value="值班信息表id",name="dutyInfoId")
    private String dutyInfoId;

	@ApiModelProperty(value="值班日志表id",name="dutyLogId")
    private String dutyLogId;

	@ApiModelProperty(value="启用时间",name="startTime",required = true)
    private Date startTime;

	@ApiModelProperty(value="班次id",name="shiftId")
    private String shiftId;

	@ApiModelProperty(value="班次名称",name="shiftName",required = true)
    private String shiftName;

	@ApiModelProperty(value="值次id",name="valueId")
    private String valueId;

	@ApiModelProperty(value="值次名称",name="valueName",required = true)
    private String valueName;

	@ApiModelProperty(value="值班人员",name="dutyUserIds",required = true)
    private String dutyUserIds;  //值班人员ids（用,隔开）

	@ApiModelProperty(value="接手人",name="successor",required = true)
    private String successor;

    public String getDutyInfoId() {
        return dutyInfoId;
    }

    public void setDutyInfoId(String dutyInfoId) {
        this.dutyInfoId = dutyInfoId == null ? null : dutyInfoId.trim();
    }

    public String getDutyLogId() {
        return dutyLogId;
    }

    public void setDutyLogId(String dutyLogId) {
        this.dutyLogId = dutyLogId == null ? null : dutyLogId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId == null ? null : shiftId.trim();
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public String getDutyUserIds() {
        return dutyUserIds;
    }

    public void setDutyUserIds(String dutyUserIds) {
        this.dutyUserIds = dutyUserIds == null ? null : dutyUserIds.trim();
    }

    public String getSuccessor() {
        return successor;
    }

    public void setSuccessor(String successor) {
        this.successor = successor == null ? null : successor.trim();
    }
}