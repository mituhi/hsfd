package com.qz.zframe.maintain.vo;

import io.swagger.annotations.ApiModelProperty;

public class WorkorderVoForMaterial {

    @ApiModelProperty(name="serialNumber",value="工单号",required=false)
    private String serialNumber;

    @ApiModelProperty(name="workorderDesc",value="工单描述",required=false)
    private String workorderDesc;

    @ApiModelProperty(name="windId",value="风电场id",required=false)
    private String windId;

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="departmentId",value="部门id",required=false)
    private String departmentId;

    @ApiModelProperty(name="departmentName",value="部门名称",required=false)
    private String departmentName;

    @ApiModelProperty(name="applicant",value="申请人id",required=false)
    private String applicant;

    @ApiModelProperty(name="applicantName",value="申请人名称",required=false)
    private String applicantName;

    @ApiModelProperty(name="applyTime",value="申请人名称",required=false)
    private String applyTime;

    @ApiModelProperty(name="value",value="工单号",required=false)
    private String value;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getWorkorderDesc() {
        return workorderDesc;
    }

    public void setWorkorderDesc(String workorderDesc) {
        this.workorderDesc = workorderDesc;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
