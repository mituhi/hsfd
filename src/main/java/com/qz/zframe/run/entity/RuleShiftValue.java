package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class RuleShiftValue {
	@ApiModelProperty(value="排班班次值次关联表id",name="id")
    private String id;

	@ApiModelProperty(value="排班规则表id",name="schedulingRuleId")
    private String schedulingRuleId;

	@ApiModelProperty(value="班次表id",name="shiftId")
    private String shiftId;

	@ApiModelProperty(value="值次表id",name="valueId")
    private String valueId;

    @ApiModelProperty(value="天次Id",name="dayId")
    private String dayId;

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId == null ? null : schedulingRuleId.trim();
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId == null ? null : shiftId.trim();
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }
}