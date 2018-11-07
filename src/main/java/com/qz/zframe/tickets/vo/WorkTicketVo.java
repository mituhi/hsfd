package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketRiskControl;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketVo extends WorkTicket{

    private List<WorkTicketRiskControl> workTicketRiskControlList = new ArrayList<>();

    public List<WorkTicketRiskControl> getWorkTicketRiskControlList() {
        return workTicketRiskControlList;
    }

    public void setWorkTicketRiskControlList(List<WorkTicketRiskControl> workTicketRiskControlList) {
        this.workTicketRiskControlList = workTicketRiskControlList;
    }
}
