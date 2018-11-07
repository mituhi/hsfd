package com.qz.zframe.tickets.vo;

public class TicketStatisticsRes {

    private String windId;

    private String windName;

    private String applyCount;

    private String inProcessCount;

    private String completeCount;

    private String invalidCount;

    private String completeRate;

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(String applyCount) {
        this.applyCount = applyCount;
    }

    public String getInProcessCount() {
        return inProcessCount;
    }

    public void setInProcessCount(String inProcessCount) {
        this.inProcessCount = inProcessCount;
    }

    public String getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(String completeCount) {
        this.completeCount = completeCount;
    }

    public String getInvalidCount() {
        return invalidCount;
    }

    public void setInvalidCount(String invalidCount) {
        this.invalidCount = invalidCount;
    }

    public String getCompleteRate() {
        return completeRate;
    }

    public void setCompleteRate(String completeRate) {
        this.completeRate = completeRate;
    }
}
