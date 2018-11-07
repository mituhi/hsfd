package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class UserValueTime {
	
	@ApiModelProperty(value="人员值次id",name="id")
    private String id;
	
	@ApiModelProperty(value="值次id",name="valueId")
    private String valueId;

	@ApiModelProperty(value="排班规则id",name="schedulingRuleId")
    private String schedulingRuleId;

	@ApiModelProperty(value="用户id",name="userId")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }

    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId == null ? null : schedulingRuleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}