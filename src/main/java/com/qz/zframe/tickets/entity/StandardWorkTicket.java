package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class StandardWorkTicket {

    @ApiParam(name="standardTicketId",value="标准工作票id",required=true)
    private String standardTicketId;

    @ApiParam(name="serialNumber",value="流水号",required=true)
    private String serialNumber;

    @ApiParam(name="standardTicketName",value="标准工作票名称",required=true)
    private String standardTicketName;

    @ApiParam(name="ticketTypeId",value="工作票类型id",required=true)
    private String ticketTypeId;

    @ApiParam(name="ticketTypeName",value="工作票类型名称",required=true)
    private String ticketTypeName;

    @ApiParam(name="status",value="状态  1:启用  2:停用  0:删除",required=true)
    private String status;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="position_id",value="位置id",required=true)
    private String location;

    @ApiParam(name="equipment_id",value="设备id",required=true)
    private String equipment;

    @ApiParam(name="workPlace",value="工作地点",required=true)
    private String workPlace;

    @ApiParam(name="workContent",value="工作内容",required=true)
    private String workContent;

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getStandardTicketName() {
        return standardTicketName;
    }

    public void setStandardTicketName(String standardTicketName) {
        this.standardTicketName = standardTicketName == null ? null : standardTicketName.trim();
    }

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId == null ? null : ticketTypeId.trim();
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName == null ? null : ticketTypeName.trim();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent == null ? null : workContent.trim();
    }
}