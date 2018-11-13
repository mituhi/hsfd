package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class WorkorderService {

    @ApiParam(name="serviceId",value="服务id",required=false)
    private String serviceId;

    @ApiParam(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiParam(name="knowledgeId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiParam(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiParam(name="serviceNumber",value="服务编码",required=false)
    private String serviceNumber;

    @ApiParam(name="serviceDesc",value="服务描述",required=false)
    private String serviceDesc;

    @ApiParam(name="serviceUnit",value="单位",required=false)
    private String serviceUnit;

    @ApiParam(name="servicePlanAmount",value="计划数量",required=false)
    private String servicePlanAmount;

    @ApiParam(name="serviceCost",value="成本单价",required=false)
    private String serviceCost;

    @ApiParam(name="serviceActualAmount",value="实际数量",required=false)
    private String serviceActualAmount;

    @ApiParam(name="serviceActualMoney",value="实际金额",required=false)
    private String serviceActualMoney;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
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

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber == null ? null : serviceNumber.trim();
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc == null ? null : serviceDesc.trim();
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit == null ? null : serviceUnit.trim();
    }

    public String getServicePlanAmount() {
        return servicePlanAmount;
    }

    public void setServicePlanAmount(String servicePlanAmount) {
        this.servicePlanAmount = servicePlanAmount == null ? null : servicePlanAmount.trim();
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost == null ? null : serviceCost.trim();
    }

    public String getServiceActualAmount() {
        return serviceActualAmount;
    }

    public void setServiceActualAmount(String serviceActualAmount) {
        this.serviceActualAmount = serviceActualAmount == null ? null : serviceActualAmount.trim();
    }

    public String getServiceActualMoney() {
        return serviceActualMoney;
    }

    public void setServiceActualMoney(String serviceActualMoney) {
        this.serviceActualMoney = serviceActualMoney == null ? null : serviceActualMoney.trim();
    }
}