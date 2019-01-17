package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingManagement {
	@ApiModelProperty(value="排班管理id",name="schedulingManagementId")
    private String schedulingManagementId;

	@ApiModelProperty(value="排班管理编号",name="schedulingCode",required = true)
    private String schedulingCode;

	@ApiModelProperty(value="排班表名称",name="schedulingName",required = true)
    private String schedulingName;

	@ApiModelProperty(value="部门",name="department",required = true)
    private String department;

    public String getSchedulingManagementId() {
        return schedulingManagementId;
    }

    public void setSchedulingManagementId(String schedulingManagementId) {
        this.schedulingManagementId = schedulingManagementId == null ? null : schedulingManagementId.trim();
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}