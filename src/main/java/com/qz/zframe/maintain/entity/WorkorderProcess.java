package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiModelProperty;

public class WorkorderProcess {

    @ApiModelProperty(name="processId",value="工序id",required=false)
    private String processId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="knowledgeId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="processNumber",value="编号",required=true)
    private String processNumber;

    @ApiModelProperty(name="processDesc",value="工序描述",required=true)
    private String processDesc;

    @ApiModelProperty(name="processExternal",value="外部",required=false)
    private String processExternal;

    @ApiModelProperty(name="processPlanWorkHours",value="计划工时",required=false)
    private String processPlanWorkHours;

    @ApiModelProperty(name="processPlanPersonNum",value="计划人数",required=false)
    private String processPlanPersonNum;

    @ApiModelProperty(name="processActualWorkHours",value="实际工时",required=false)
    private String processActualWorkHours;

    @ApiModelProperty(name="processActualPersonNum",value="实际人数",required=false)
    private String processActualPersonNum;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc == null ? null : processDesc.trim();
    }

    public String getProcessExternal() {
        return processExternal;
    }

    public void setProcessExternal(String processExternal) {
        this.processExternal = processExternal == null ? null : processExternal.trim();
    }

    public String getProcessPlanWorkHours() {
        return processPlanWorkHours;
    }

    public void setProcessPlanWorkHours(String processPlanWorkHours) {
        this.processPlanWorkHours = processPlanWorkHours == null ? null : processPlanWorkHours.trim();
    }

    public String getProcessPlanPersonNum() {
        return processPlanPersonNum;
    }

    public void setProcessPlanPersonNum(String processPlanPersonNum) {
        this.processPlanPersonNum = processPlanPersonNum == null ? null : processPlanPersonNum.trim();
    }

    public String getProcessActualWorkHours() {
        return processActualWorkHours;
    }

    public void setProcessActualWorkHours(String processActualWorkHours) {
        this.processActualWorkHours = processActualWorkHours == null ? null : processActualWorkHours.trim();
    }

    public String getProcessActualPersonNum() {
        return processActualPersonNum;
    }

    public void setProcessActualPersonNum(String processActualPersonNum) {
        this.processActualPersonNum = processActualPersonNum == null ? null : processActualPersonNum.trim();
    }
}