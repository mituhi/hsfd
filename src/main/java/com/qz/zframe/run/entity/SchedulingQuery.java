package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingQuery {
	@ApiModelProperty(value="开始时间",name="startTime")
    private Date startTime;

	@ApiModelProperty(value="结束时间",name="endTime")
    private Date endTime;

	@ApiModelProperty(value="部门",name="department")
    private String department;

	@ApiModelProperty(value="排班编号",name="schedulingCode")
    private String schedulingCode;

	@ApiModelProperty(value="排班表名称",name="schedulingName")
    private String schedulingName;

	@ApiModelProperty(value="值次名称",name="valueName")
    private String valueName;

	@ApiModelProperty(value="班次名称",name="shiftName")
    private String shiftName;

	@ApiModelProperty(value="用户id",name="userId")
    private String userId;

	@ApiModelProperty(value="排班规则表id",name="schedulingRuleId")
	private String schedulingRuleId;
	
    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId == null ? null : schedulingRuleId.trim();
    }
	
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSchedulingCode() {
        return schedulingCode;
    }

    public void setSchedulingCode(String schedulingCode) {
        this.schedulingCode = schedulingCode == null ? null : schedulingCode.trim();
    }

    public String getSchedulingName() {
        return schedulingName;
    }

    public void setSchedulingName(String schedulingName) {
        this.schedulingName = schedulingName == null ? null : schedulingName.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}