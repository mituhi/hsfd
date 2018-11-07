package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateItems;
import com.qz.zframe.tickets.entity.OperateTicket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperateTicketVo extends OperateTicket {

    private List<OperateItems> operateItemsList = new ArrayList<>();

    public List<OperateItems> getOperateItemsList() {
        return operateItemsList;
    }

    public void setOperateItemsList(List<OperateItems> operateItemsList) {
        this.operateItemsList = operateItemsList;
    }
}
