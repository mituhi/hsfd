package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.WorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketRiskControl;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketWorkTime;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketVo extends WorkTicket{

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

    @ApiParam(name="standardTicketName",value="标准工作票名称",required=false)
    private String standardTicketName;

    private List<WorkTicketRiskControl> RiskControlList = new ArrayList<>();

    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

    private List<WorkTicketWorkTime> workTimeList = new ArrayList<>();

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

    public String getStandardTicketName() {
        return standardTicketName;
    }

    public void setStandardTicketName(String standardTicketName) {
        this.standardTicketName = standardTicketName;
    }

    public List<WorkTicketRiskControl> getRiskControlList() {
        return RiskControlList;
    }

    public void setRiskControlList(List<WorkTicketRiskControl> riskControlList) {
        RiskControlList = riskControlList;
    }

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<WorkTicketWorkTime> getWorkTimeList() {
        return workTimeList;
    }

    public void setWorkTimeList(List<WorkTicketWorkTime> workTimeList) {
        this.workTimeList = workTimeList;
    }
}
