package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class StandardWorkTicket {

    @ApiModelProperty(name="standardTicketId",value="标准工作票id",required=false)
    private String standardTicketId;

    @ApiModelProperty(name="serialNumber",value="标准工作票号(流水号)",required=false)
    private String serialNumber;

    @ApiModelProperty(name="standardTicketName",value="标准工作票名称",required=false)
    private String standardTicketName;

    @ApiModelProperty(name="ticketTypeId",value="工作票类型id",required=true)
    private String ticketTypeId;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;

    @ApiModelProperty(name="maintainer",value="维护人id",required=true)
    private String maintainer;

    @ApiModelProperty(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiModelProperty(name="crewId",value="机组id",required=true)
    private String crewId;

    @ApiModelProperty(name="workTeam",value="工作班组id",required=true)
    private String workTeam;

    @ApiModelProperty(name="positionId",value="位置id",required=false)
    private String positionId;

    @ApiModelProperty(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiModelProperty(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiModelProperty(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiModelProperty(name="doubleName",value="工作的风电场、升压站名称及设备双重名称",required=true)
    private String doubleName;

    @ApiModelProperty(name="workPlace",value="工作地点或地段",required=true)
    private String workPlace;

    @ApiModelProperty(name="workContent",value="工作内容",required=true)
    private String workContent;

    public String getStandardTicketId() {
        return standardTicketId;
    }

    public void setStandardTicketId(String standardTicketId) {
        this.standardTicketId = standardTicketId == null ? null : standardTicketId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getStandardTicketName() {
        return standardTicketName;
    }

    public void setStandardTicketName(String standardTicketName) {
        this.standardTicketName = standardTicketName == null ? null : standardTicketName.trim();
    }

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId == null ? null : ticketTypeId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer == null ? null : maintainer.trim();
    }

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getCrewId() {
        return crewId;
    }

    public void setCrewId(String crewId) {
        this.crewId = crewId == null ? null : crewId.trim();
    }

    public String getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam == null ? null : workTeam.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc == null ? null : positionDesc.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc == null ? null : equipmentDesc.trim();
    }

    public String getDoubleName() {
        return doubleName;
    }

    public void setDoubleName(String doubleName) {
        this.doubleName = doubleName == null ? null : doubleName.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent == null ? null : workContent.trim();
    }
}