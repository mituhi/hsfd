package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingAssociated {
	@ApiModelProperty(value="排班关联表id",name="id")
    private String id;

	@ApiModelProperty(value="排版管理表id",name="schedulingManagementId")
    private String schedulingManagementId;

	@ApiModelProperty(value="排班规则表id",name="schedulingRuleId")
    private String schedulingRuleId;

	@ApiModelProperty(value="开始时间",name="startTime")
    private Date startTime;

	@ApiModelProperty(value="结束时间",name="endTime")
    private Date endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchedulingManagementId() {
        return schedulingManagementId;
    }

    public void setSchedulingManagementId(String schedulingManagementId) {
        this.schedulingManagementId = schedulingManagementId == null ? null : schedulingManagementId.trim();
    }

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
}