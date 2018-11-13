package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.WorkTicketRiskControl;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class StandardWorkTicketVo extends StandardWorkTicket {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiParam(name="crewName",value="机组名称",required=false)
    private String crewName;

    @ApiParam(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiParam(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiParam(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeName;

    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

   private List<WorkTicketRiskControl> riskControlList= new ArrayList<>();

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

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<WorkTicketRiskControl> getRiskControlList() {
        return riskControlList;
    }

    public void setRiskControlList(List<WorkTicketRiskControl> riskControlList) {
        this.riskControlList = riskControlList;
    }
}
