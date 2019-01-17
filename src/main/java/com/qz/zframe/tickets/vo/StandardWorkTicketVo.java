package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.StandardWorkTicket;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class StandardWorkTicketVo extends StandardWorkTicket {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="crewName",value="机组名称",required=false)
    private String crewName;

    @ApiModelProperty(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiModelProperty(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiModelProperty(name="ticketTypeName",value="工作票类型名称",required=false)
    private String ticketTypeName;

    @ApiModelProperty(name="workTeamName",value="工作班组名称",required=false)
    private String workTeamName;

    @ApiModelProperty(name="statusName",value="工作班组名称",required=false)
    private String statusName;

    @ApiModelProperty(name="maintainerName",value="维护人姓名",required=false)
    private String maintainerName;

    @ApiModelProperty(name="safeMeasureList",value="安全措施list",required=false)
    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

    @ApiModelProperty(name="riskControlList",value="危险因素控制措施list",required=false)
    private List<WorkTicketRiskControlVo> riskControlList= new ArrayList<>();

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

    public String getWorkTeamName() {
        return workTeamName;
    }

    public void setWorkTeamName(String workTeamName) {
        this.workTeamName = workTeamName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<WorkTicketRiskControlVo> getRiskControlList() {
        return riskControlList;
    }

    public void setRiskControlList(List<WorkTicketRiskControlVo> riskControlList) {
        this.riskControlList = riskControlList;
    }
}
