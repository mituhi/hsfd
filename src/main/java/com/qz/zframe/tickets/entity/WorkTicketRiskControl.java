package com.qz.zframe.tickets.entity;

import io.swagger.annotations.ApiParam;

public class WorkTicketRiskControl {

    @ApiParam(name="measureId",value="危险因素控制措施id",required=false)
    private String measureId;

    @ApiParam(name="ticketId",value="工作票id",required=false)
    private String ticketId;

    @ApiParam(name="standardTicketId",value="标准工作票id",required=false)
    private String standardTicketId;

    @ApiParam(name="measureNumber",value="编号",required=false)
    private String measureNumber;

    @ApiParam(name="dangerPoint",value="危险点",required=false)
    private String dangerPoint;

    @ApiParam(name="workCondition",value="危险因素控制措施",required=false)
    private String measure;

    @ApiParam(name="measureExecutor",value="落实人",required=false)
    private String measureExecutor;

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

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
    }

    public String getMeasureNumber() {
        return measureNumber;
    }

    public void setMeasureNumber(String measureNumber) {
        this.measureNumber = measureNumber == null ? null : measureNumber.trim();
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

    public String getMeasureExecutor() {
        return measureExecutor;
    }

    public void setMeasureExecutor(String measureExecutor) {
        this.measureExecutor = measureExecutor == null ? null : measureExecutor.trim();
    }
}