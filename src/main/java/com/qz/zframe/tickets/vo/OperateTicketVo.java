package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateItem;
import com.qz.zframe.tickets.entity.OperateTicket;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class OperateTicketVo extends OperateTicket {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="crewName",value="机组名称",required=false)
    private String crewName;

    @ApiParam(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiParam(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiParam(name="ticketTypeName",value="操作票类型名称",required=false)
    private String ticketTypeName;

    @ApiParam(name="typicalTicketName",value="典型操作票名称",required=false)
    private String typicalTicketName;

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
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

    public String getTypicalTicketName() {
        return typicalTicketName;
    }

    public void setTypicalTicketName(String typicalTicketName) {
        this.typicalTicketName = typicalTicketName;
    }

    private List<OperateItem> operateItemsList = new ArrayList<>();

    public List<OperateItem> getOperateItemsList() {
        return operateItemsList;
    }

    public void setOperateItemsList(List<OperateItem> operateItemsList) {
        this.operateItemsList = operateItemsList;
    }
}
