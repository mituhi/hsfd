package com.qz.zframe.tickets.entity;

public class WorkTicketTypeSafeMeasure {
    private String measureId;

    private String ticketTypeId;

    private String measureType;

    public String getMeasureId() {
        return measureId;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId == null ? null : measureId.trim();
    }

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId == null ? null : ticketTypeId.trim();
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType == null ? null : measureType.trim();
    }
}