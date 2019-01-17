package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.WorkTicketRiskControl;

public class WorkTicketRiskControlVo extends WorkTicketRiskControl {

    private String measureExecutorName;

    public String getMeasureExecutorName() {
        return measureExecutorName;
    }

    public void setMeasureExecutorName(String measureExecutorName) {
        this.measureExecutorName = measureExecutorName;
    }
}
