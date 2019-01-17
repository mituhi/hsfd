package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiModelProperty;

public class OperateItem {

    @ApiModelProperty(name="itemId",value="操作项id",required=false)
    private String itemId;

    @ApiModelProperty(name="ticketId",value="操作票id",required=false)
    private String ticketId;

    @ApiModelProperty(name="typicalTicketId",value="典型操作票id",required=false)
    private String typicalTicketId;

    @ApiModelProperty(name="itemNumber",value="操作项编号",required=false)
    private Integer itemNumber;

    @ApiModelProperty(name="itemContent",value="操作项内容",required=false)
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

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }
}