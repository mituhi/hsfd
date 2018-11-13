package com.qz.zframe.tickets.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class TypicalOperateTicket {

    @ApiParam(name="typicalTicketId",value="典型操作票id",required=false)
    private String typicalTicketId;

    @ApiParam(name="serialNumber",value="典型操作票号(流水号)",required=false)
    private String serialNumber;

    @ApiParam(name="typicalTicketName",value="典型操作票名称",required=false)
    private String typicalTicketName;

    @ApiParam(name="operTicketTypeId",value="操作票类型id",required=true)
    private String operTicketTypeId;

    @ApiParam(name="maintainer",value="维护人",required=false)
    private String maintainer;

    @ApiParam(name="maintainDate",value="维护日期",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainDate;

    @ApiParam(name="status",value="状态",required=false)
    private String status;

    @ApiParam(name="windId",value="风电场id",required=true)
    private String windId;

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

    @ApiParam(name="operateContent",value="操作内容",required=true)
    private String operateContent;

    @ApiParam(name="remark",value="备注",required=false)
    private String remark;

    public String getTypicalTicketId() {
        return typicalTicketId;
    }

    public void setTypicalTicketId(String typicalTicketId) {
        this.typicalTicketId = typicalTicketId == null ? null : typicalTicketId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getTypicalTicketName() {
        return typicalTicketName;
    }

    public void setTypicalTicketName(String typicalTicketName) {
        this.typicalTicketName = typicalTicketName;
    }

    public String getOperTicketTypeId() {
        return operTicketTypeId;
    }

    public void setOperTicketTypeId(String operTicketTypeId) {
        this.operTicketTypeId = operTicketTypeId == null ? null : operTicketTypeId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
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
        this.positionId = positionId;
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
        this.equipmentId = equipmentId;
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc == null ? null : equipmentDesc.trim();
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}