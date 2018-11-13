package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiParam;

public class OperateItem {

    @ApiParam(name="itemId",value="操作项id",required=false)
    private String itemId;

    @ApiParam(name="ticketId",value="操作票id",required=false)
    private String ticketId;

    @ApiParam(name="typicalTicketId",value="典型操作票id",required=false)
    private String typicalTicketId;

    @ApiParam(name="itemNumber",value="操作项编号",required=false)
    private String itemNumber;

    @ApiParam(name="itemContent",value="操作项内容",required=false)
    private String itemContent;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getTypicalTicketId() {
        return typicalTicketId;
    }

    public void setTypicalTicketId(String typicalTicketId) {
        this.typicalTicketId = typicalTicketId == null ? null : typicalTicketId.trim();
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber == null ? null : itemNumber.trim();
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }
}