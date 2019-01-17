package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingAssociated {
	@ApiModelProperty(value="排班关联表id",name="id")
    private String associatedId;

	@ApiModelProperty(value="排版管理表id",name="schedulingManagementId")
    private String schedulingManagementId;

	@ApiModelProperty(value="排班规则表id",name="schedulingRuleId",required = true)
    private String schedulingRuleId;

	@ApiModelProperty(value="开始时间",name="startTime",required = true)
    private Date startTime;

	@ApiModelProperty(value="结束时间",name="endTime",required = true)
    private Date endTime;

    

    public String getAssociatedId() {
		return associatedId;
	}

	public void setAssociatedId(String associatedId) {
		this.associatedId = associatedId;
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