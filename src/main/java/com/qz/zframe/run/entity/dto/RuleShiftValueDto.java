package com.qz.zframe.run.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.run.entity.QianDuanNeed;
import com.qz.zframe.tally.entity.IscUser;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class RuleShiftValueDto {
    @ApiModelProperty(value="排班规则id",name="schedulingRuleId",required=false)
    private String schedulingRuleId;

    @ApiModelProperty(value="班次id",name="shiftId",required=false)
    private String shiftId;

    @ApiModelProperty(value="班次名称",name="shiftName",required=false)
    private String shiftName;

    @ApiModelProperty(value="值次id",name="valueId",required=false)
    private String valueId;

    @ApiModelProperty(value="值次名称",name="valueName",required=false)
    private String valueName;

    @ApiModelProperty(value="日期",name="date",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;

    @ApiModelProperty(value="值次对应名称",name="iscUsers",required=false)
    private List<IscUserDto> iscUsers;

    @ApiModelProperty(value="天次id",name="dayId",required=false)
    private String dayId;

    @ApiModelProperty(value="用户id拼接",name="userIds",required=false)
    private String userIds;

    @ApiModelProperty(value="用户名称拼接",name="userNames",required=false)
    private String userNames;

    @ApiModelProperty(value="班次类实体",name="shifts",required=false)
    private QianDuanNeed shifts;

    public QianDuanNeed getShifts() {
        return shifts;
    }

    public void setShifts(QianDuanNeed shifts) {
        this.shifts = shifts;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<IscUserDto> getIscUsers() {
        return iscUsers;
    }

    public void setIscUsers(List<IscUserDto> iscUsers) {
        this.iscUsers = iscUsers;
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
}
