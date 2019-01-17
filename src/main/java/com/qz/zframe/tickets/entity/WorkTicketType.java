package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkTicketType {

    @ApiModelProperty(name="workTicketTypeId",value="工作票类型id",required=false)
    private String workTicketTypeId;

    @ApiModelProperty(name="ticketTypeNumber",value="工作票类型编号",required=false)
    private String ticketTypeNumber;

    @ApiModelProperty(name="ticketTypeDesc",value="工作票类型描述",required=false)
    private String ticketTypeDesc;

    @ApiModelProperty(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeName;

    @ApiModelProperty(name="maintainer",value="维护人id",required=false)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;

    @ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;

    @ApiModelProperty(name="createTime",value="创建时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;

    public String getWorkTicketTypeId() {
        return workTicketTypeId;
    }

    public void setWorkTicketTypeId(String workTicketTypeId) {
        this.workTicketTypeId = workTicketTypeId == null ? null : workTicketTypeId.trim();
    }

    public String getTicketTypeNumber() {
        return ticketTypeNumber;
    }

    public void setTicketTypeNumber(String ticketTypeNumber) {
        this.ticketTypeNumber = ticketTypeNumber;
    }

    public String getTicketTypeDesc() {
        return ticketTypeDesc;
    }

    public void setTicketTypeDesc(String ticketTypeDesc) {
        this.ticketTypeDesc = ticketTypeDesc == null ? null : ticketTypeDesc.trim();
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName == null ? null : ticketTypeName.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}