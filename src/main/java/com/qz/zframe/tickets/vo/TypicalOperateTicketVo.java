package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateItem;
import com.qz.zframe.tickets.entity.TypicalOperateTicket;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class TypicalOperateTicketVo extends TypicalOperateTicket {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="workTeamName",value="工作班组名称",required=false)
    private String workTeamName;

    @ApiModelProperty(name="positionName",value="位置名称",required=false)
    private String positionName;

    @ApiModelProperty(name="equipmentName",value="设备名称",required=false)
    private String equipmentName;

    @ApiModelProperty(name="ticketTypeName",value="典型操作票类型名称",required=false)
    private String ticketTypeName;

    @ApiModelProperty(name="statusName",value="工作班组名称",required=false)
    private String statusName;

    @ApiModelProperty(name="maintainerName",value="维护人姓名",required=false)
    private String maintainerName;

    @ApiModelProperty(name="operateItemList",value="操作项list",required=false)
    private List<OperateItem> operateItemList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getWorkTeamName() {
        return workTeamName;
    }

    public void setWorkTeamName(String workTeamName) {
        this.workTeamName = workTeamName;
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

    public List<OperateItem> getOperateItemList() {
        return operateItemList;
    }

    public void setOperateItemList(List<OperateItem> operateItemList) {
        this.operateItemList = operateItemList;
    }
}
