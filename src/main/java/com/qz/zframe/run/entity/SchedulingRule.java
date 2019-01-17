package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SchedulingRule {
	
	@ApiModelProperty(value="排班规则id",name="schedulingRuleId")
    private String schedulingRuleId;

	@ApiModelProperty(value="排班规则编码",name="schedulingRuleCode",required = true)
    private String schedulingRuleCode;

	@ApiModelProperty(value="排班规则名称",name="schedulingRule",required = true)
    private String schedulingRule;

	@ApiModelProperty(value="风电场编码",name="department",required = true)
    private String windCode;

    @ApiModelProperty(value="风电场名称",name="department",required = true)
    private String windName;

	@ApiModelProperty(value="轮换周期",name="rotationCycle",required = true)
    private String rotationCycle;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

    @ApiModelProperty(value="假删除",name="trueId",required = true)
    private String trueId;

    @ApiModelProperty(value="值次ids",name="valueIds",required = true)
    private List<String> valueIds;

    @ApiModelProperty(value="班次ids",name="shiftIds",required = true)
    private List<String> shiftIds;

    public List<String> getValueIds() {
        return valueIds;
    }

    public void setValueIds(List<String> valueIds) {
        this.valueIds = valueIds;
    }

    public List<String> getShiftIds() {
        return shiftIds;
    }

    public void setShiftIds(List<String> shiftIds) {
        this.shiftIds = shiftIds;
    }

    public String getTrueId() {
        return trueId;
    }

    public void setTrueId(String trueId) {
        this.trueId = trueId;
    }

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

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode;
    }

    public String getRotationCycle() {
        return rotationCycle;
    }

    public void setRotationCycle(String rotationCycle) {
        this.rotationCycle = rotationCycle == null ? null : rotationCycle.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

}