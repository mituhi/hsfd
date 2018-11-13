package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class StandardWorkTicket {

    @ApiParam(name="standardTicketId",value="标准工作票id",required=false)
    private String standardTicketId;

    @ApiParam(name="serialNumber",value="标准工作票号(流水号)",required=false)
    private String serialNumber;

    @ApiParam(name="standardTicketName",value="标准工作票名称",required=false)
    private String standardTicketName;

    @ApiParam(name="ticketTypeId",value="工作票类型id",required=true)
    private String ticketTypeId;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="maintainer",value="维护人",required=true)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

    @ApiParam(name="crewId",value="机组id",required=true)
    private String crewId;

    @ApiParam(name="workTeam",value="工作班组",required=true)
    private String workTeam;

    @ApiParam(name="positionId",value="位置id",required=false)
    private String positionId;

    @ApiParam(name="positionDesc",value="位置描述",required=false)
    private String positionDesc;

    @ApiParam(name="equipmentId",value="设备id",required=false)
    private String equipmentId;

    @ApiParam(name="equipmentDesc",value="设备描述",required=false)
    private String equipmentDesc;

    @ApiParam(name="doubleName",value="工作的风电场、升压站名称及设备双重名称",required=true)
    private String doubleName;

    @ApiParam(name="workPlace",value="工作地点或地段",required=true)
    private String workPlace;

    @ApiParam(name="workContent",value="工作内容",required=true)
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