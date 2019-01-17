package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Process {

    @ApiModelProperty(value="流程主表id",name="processId",required=false)
    private String processId;

    @ApiModelProperty(value="关联id",name="orderId",required=false)
    private String orderId;

    @ApiModelProperty(value="流程步骤",name="processSort",required=false)
    private Integer processSort;

    @ApiModelProperty(value="流程类型",name="processType",required=false)
    private String processType;

    @ApiModelProperty(value="流程状态",name="processStatus",required=false)
    private String processStatus;

    @ApiModelProperty(value="创建时间",name="createTime",required=false)
    private Date createTime;

    @ApiModelProperty(value="流程详情列表",name="processDetails",required=false)
    private List<ProcessDetail> processDetails = new ArrayList<>();

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getProcessSort() {
        return processSort;
    }

    public void setProcessSort(Integer processSort) {
        this.processSort = processSort;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType == null ? null : processType.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ProcessDetail> getProcessDetails() {
        return processDetails;
    }

    public void setProcessDetails(List<ProcessDetail> processDetails) {
        this.processDetails = processDetails;
    }
}