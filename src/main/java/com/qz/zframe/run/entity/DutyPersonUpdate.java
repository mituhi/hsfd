package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class DutyPersonUpdate {
	
	@ApiModelProperty(value="值班人员修改表id",name="dutyPersonUpdateId",required = true)
    private String dutyPersonUpdateId;

	@ApiModelProperty(value="排班关联表id",name="schedulingAssociatedId",required = true)
    private String schedulingAssociatedId;

	@ApiModelProperty(value="值次id",name="valueId",required = true)
    private String valueId;

	@ApiModelProperty(value="班次id",name="shiftId",required = true)
    private String shiftId;

	@ApiModelProperty(value="值班日期",name="dutyDate",required = true)
    private Date dutyDate;

	@ApiModelProperty(value="值班人员id/如果是多个人员采用 id1,id2...上传（逗号隔开）",name="dutyUsersId",required = true)
    private String dutyUsersId;

    public String getDutyPersonUpdateId() {
        return dutyPersonUpdateId;
    }

    public void setDutyPersonUpdateId(String dutyPersonUpdateId) {
        this.dutyPersonUpdateId = dutyPersonUpdateId == null ? null : dutyPersonUpdateId.trim();
    }

    public String getSchedulingAssociatedId() {
        return schedulingAssociatedId;
    }

    public void setSchedulingAssociatedId(String schedulingAssociatedId) {
        this.schedulingAssociatedId = schedulingAssociatedId == null ? null : schedulingAssociatedId.trim();
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId == null ? null : shiftId.trim();
    }

    public Date getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }

    public String getDutyUsersId() {
        return dutyUsersId;
    }

    public void setDutyUsersId(String dutyUsersId) {
        this.dutyUsersId = dutyUsersId == null ? null : dutyUsersId.trim();
    }
}