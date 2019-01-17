package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkorderType {

    @ApiModelProperty(name="workorderTypeId",value="工单类型id",required=false)
    private String workorderTypeId;

    @ApiModelProperty(name="workorderTypeCode",value="工单类型编码(自定义)",required=true)
    private String workorderTypeCode;

    @ApiModelProperty(name="workorderTypeName",value="工单类型名称",required=true)
    private String workorderTypeName;

    @ApiModelProperty(name="status",value="状态  1:启用  2:停用  0:删除",required=false)
    private String status;

    @ApiModelProperty(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;
    @ApiModelProperty(name="statusText",value="状态名称",required=false)
    private String statusText;

    public String getWorkorderTypeId() {
        return workorderTypeId;
    }

    public void setWorkorderTypeId(String workorderTypeId) {
        this.workorderTypeId = workorderTypeId == null ? null : workorderTypeId.trim();
    }

    public String getWorkorderTypeCode() {
        return workorderTypeCode;
    }

    public void setWorkorderTypeCode(String workorderTypeCode) {
        this.workorderTypeCode = workorderTypeCode == null ? null : workorderTypeCode.trim();
    }

    public String getWorkorderTypeName() {
        return workorderTypeName;
    }

    public void setWorkorderTypeName(String workorderTypeName) {
        this.workorderTypeName = workorderTypeName == null ? null : workorderTypeName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer == null ? null : maintainer.trim();
    }

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}