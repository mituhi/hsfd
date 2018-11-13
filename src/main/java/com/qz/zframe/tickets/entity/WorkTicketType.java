package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class WorkTicketType {

    @ApiParam(name="workTicketTypeId",value="工作票类型id",required=false)
    private String workTicketTypeId;

    @ApiParam(name="ticketTypeNumber",value="工作票类型编号",required=false)
    private String ticketTypeNumber;

    @ApiParam(name="ticketTypeDesc",value="工作票类型描述",required=false)
    private String ticketTypeDesc;

    @ApiParam(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeName;

    @ApiParam(name="maintainer",value="维护人",required=false)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="remark",value="备注",required=false)
    private String remark;

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
}