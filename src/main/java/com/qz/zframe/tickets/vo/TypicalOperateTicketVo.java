package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateItem;
import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class TypicalOperateTicketVo extends TypicalOperateTicket {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiParam(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiParam(name="ticketTypeName",value="典型操作票类型名称",required=false)
    private String ticketTypeName;

    private List<OperateItem> operateItemList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public List<OperateItem> getOperateItemList() {
        return operateItemList;
    }

    public void setOperateItemList(List<OperateItem> operateItemList) {
        this.operateItemList = operateItemList;
    }
}
