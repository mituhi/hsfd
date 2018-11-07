package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiParam;

import java.util.Date;

public class TypicalOperateTicket {

    @ApiParam(name="typicalTicketId",value="典型操作票id",required=true)
    private String typicalTicketId;

    @ApiParam(name="serialNumber",value="流水号",required=true)
    private String serialNumber;

    @ApiParam(name="typicalTickeCode",value="典型操作票代码",required=true)
    private String typicalTickeCode;

    @ApiParam(name="ticketTypeId",value="操作票类型id",required=true)
    private String ticketTypeId;

    @ApiParam(name="ticketTypeName",value="操作票类型名称",required=true)
    private String ticketTypeName;

    @ApiParam(name="status",value="状态  1:启用  2:停用  0:删除",required=true)
    private String status;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    private Date maintainDate;

    @ApiParam(name="localtion_position",value="当前页",required=true)
    private String localtion;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="equipment_id",value="设备id",required=true)
    private String equipment;

    @ApiParam(name="dapartment_id",value="部门id",required=true)
    private String dapartments;

    @ApiParam(name="operateContent",value="操作内容",required=true)
    private String operateContent;

    @ApiParam(name="operateItemsIds",value="操作项ids",required=false)
    private String operateItemsIds;

    public String getTypicalTicketId() {
        return typicalTicketId;
    }

    public void setTypicalTicketId(String typicalTicketId) {
        this.typicalTicketId = typicalTicketId == null ? null : typicalTicketId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getTypicalTickeCode() {
        return typicalTickeCode;
    }

    public void setTypicalTickeCode(String typicalTickeCode) {
        this.typicalTickeCode = typicalTickeCode == null ? null : typicalTickeCode.trim();
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

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion == null ? null : localtion.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getDapartments() {
        return dapartments;
    }

    public void setDapartments(String dapartments) {
        this.dapartments = dapartments == null ? null : dapartments.trim();
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    public String getOperateItemsIds() {
        return operateItemsIds;
    }

    public void setOperateItemsIds(String operateItemsIds) {
        this.operateItemsIds = operateItemsIds == null ? null : operateItemsIds.trim();
    }
}