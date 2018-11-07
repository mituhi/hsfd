package com.qz.zframe.tickets.entity;

public class WorkTicketRiskControl {
    private String measureId;

    private String ticketId;

    private String dangerPoint;

    private String measure;

    private String executePerson;

    public String getMeasureId() {
        return measureId;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId == null ? null : measureId.trim();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getDangerPoint() {
        return dangerPoint;
    }

    public void setDangerPoint(String dangerPoint) {
        this.dangerPoint = dangerPoint == null ? null : dangerPoint.trim();
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public String getExecutePerson() {
        return executePerson;
    }

    public void setExecutePerson(String executePerson) {
        this.executePerson = executePerson == null ? null : executePerson.trim();
    }
}