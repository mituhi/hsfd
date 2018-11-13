package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiParam;

public class WorkTicketSafeMeasure {

    @ApiParam(name="safeId",value="安全措施id",required=false)
    private String safeId;

    @ApiParam(name="ticketId",value="工作票id",required=false)
    private String ticketId;

    @ApiParam(name="standardTicketId",value="标准工作票id",required=false)
    private String standardTicketId;

    @ApiParam(name="ticketTypeId",value="工作票类型id",required=false)
    private String ticketTypeId;

    @ApiParam(name="safeNumber",value="编号",required=false)
    private String safeNumber;

    @ApiParam(name="safeTitle",value="措施类型",required=false)
    private String safeTitle;

    @ApiParam(name="safeContent",value="措施内容",required=false)
    private String safeContent;

    public String getSafeId() {
        return safeId;
    }

    public void setSafeId(String safeId) {
        this.safeId = safeId == null ? null : safeId.trim();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
    }

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId == null ? null : ticketTypeId.trim();
    }

    public String getSafeNumber() {
        return safeNumber;
    }

    public void setSafeNumber(String safeNumber) {
        this.safeNumber = safeNumber == null ? null : safeNumber.trim();
    }

    public String getSafeTitle() {
        return safeTitle;
    }

    public void setSafeTitle(String safeTitle) {
        this.safeTitle = safeTitle == null ? null : safeTitle.trim();
    }

    public String getSafeContent() {
        return safeContent;
    }

    public void setSafeContent(String safeContent) {
        this.safeContent = safeContent == null ? null : safeContent.trim();
    }
}