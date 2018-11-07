package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingRule {
	
	@ApiModelProperty(value="排班规则id",name="schedulingRuleId")
    private String schedulingRuleId;

	@ApiModelProperty(value="排班规则编码",name="schedulingRuleCode")
    private String schedulingRuleCode;

	@ApiModelProperty(value="排班规则名称",name="schedulingRule")
    private String schedulingRule;

	@ApiModelProperty(value="部门",name="department")
    private String department;

	@ApiModelProperty(value="排班班次",name="schedulingShift")
    private String schedulingShift;

	@ApiModelProperty(value="轮换周期",name="rotationCycle")
    private String rotationCycle;

	@ApiModelProperty(value="是否跨天",name="isAcrossDay")
    private String isAcrossDay;

	@ApiModelProperty(value="横跨天数",name="dayNum")
    private String dayNum;

	@ApiModelProperty(value="状态",name="status")
    private String status;

    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId == null ? null : schedulingRuleId.trim();
    }

    public String getSchedulingRuleCode() {
        return schedulingRuleCode;
    }

    public void setSchedulingRuleCode(String schedulingRuleCode) {
        this.schedulingRuleCode = schedulingRuleCode == null ? null : schedulingRuleCode.trim();
    }

    public String getSchedulingRule() {
        return schedulingRule;
    }

    public void setSchedulingRule(String schedulingRule) {
        this.schedulingRule = schedulingRule == null ? null : schedulingRule.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSchedulingShift() {
        return schedulingShift;
    }

    public void setSchedulingShift(String schedulingShift) {
        this.schedulingShift = schedulingShift == null ? null : schedulingShift.trim();
    }

    public String getRotationCycle() {
        return rotationCycle;
    }

    public void setRotationCycle(String rotationCycle) {
        this.rotationCycle = rotationCycle == null ? null : rotationCycle.trim();
    }

    public String getIsAcrossDay() {
        return isAcrossDay;
    }

    public void setIsAcrossDay(String isAcrossDay) {
        this.isAcrossDay = isAcrossDay == null ? null : isAcrossDay.trim();
    }

    public String getDayNum() {
        return dayNum;
    }

    public void setDayNum(String dayNum) {
        this.dayNum = dayNum == null ? null : dayNum.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}