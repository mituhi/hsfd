package com.qz.zframe.maintain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WorkorderWorktype {

    @ApiModelProperty(name="worktypeId",value="工种id",required=false)
    private String worktypeId;

    @ApiModelProperty(name="workorderId",value="缺陷工单id",required=false)
    private String workorderId;

    @ApiModelProperty(name="knowledgeId",value="故障知识id",required=false)
    private String knowledgeId;

    @ApiModelProperty(name="orderId",value="工单id",required=false)
    private String orderId;

    @ApiModelProperty(name="worktypeNumber",value="工种编号",required=false)
    private String worktypeNumber;

    @ApiModelProperty(name="worktypeName",value="工种名称",required=false)
    private String worktypeName;

    @ApiModelProperty(name="worktypeNeedNum",value="需求人数",required=false)
    private String worktypeNeedNum;

    @ApiModelProperty(name="worktypePlanStartTime",value="计划开始时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date worktypePlanStartTime;

    @ApiModelProperty(name="worktypePlanEndTime",value="计划结束时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date worktypePlanEndTime;

    @ApiModelProperty(name="worktypeStandardRate",value="标准费率",required=false)
    private String worktypeStandardRate;

    @ApiModelProperty(name="worktypePlanUseHour",value="计划用时",required=false)
    private String worktypePlanUseHour;

    @ApiModelProperty(name="worktypePlanFee",value="计划费用",required=false)
    private String worktypePlanFee;

    @ApiModelProperty(name="worktypeActualUseHour",value="实际用时",required=false)
    private String worktypeActualUseHour;

    @ApiModelProperty(name="worktypeActualFee",value="实际费用",required=false)
    private String worktypeActualFee;

    public String getWorktypeId() {
        return worktypeId;
    }

    public void setWorktypeId(String worktypeId) {
        this.worktypeId = worktypeId == null ? null : worktypeId.trim();
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

    public String getWorktypeNumber() {
        return worktypeNumber;
    }

    public void setWorktypeNumber(String worktypeNumber) {
        this.worktypeNumber = worktypeNumber == null ? null : worktypeNumber.trim();
    }

    public String getWorktypeName() {
        return worktypeName;
    }

    public void setWorktypeName(String worktypeName) {
        this.worktypeName = worktypeName == null ? null : worktypeName.trim();
    }

    public String getWorktypeNeedNum() {
        return worktypeNeedNum;
    }

    public void setWorktypeNeedNum(String worktypeNeedNum) {
        this.worktypeNeedNum = worktypeNeedNum == null ? null : worktypeNeedNum.trim();
    }

    public Date getWorktypePlanStartTime() {
        return worktypePlanStartTime;
    }

    public void setWorktypePlanStartTime(Date worktypePlanStartTime) {
        this.worktypePlanStartTime = worktypePlanStartTime;
    }

    public Date getWorktypePlanEndTime() {
        return worktypePlanEndTime;
    }

    public void setWorktypePlanEndTime(Date worktypePlanEndTime) {
        this.worktypePlanEndTime = worktypePlanEndTime;
    }

    public String getWorktypeStandardRate() {
        return worktypeStandardRate;
    }

    public void setWorktypeStandardRate(String worktypeStandardRate) {
        this.worktypeStandardRate = worktypeStandardRate == null ? null : worktypeStandardRate.trim();
    }

    public String getWorktypePlanUseHour() {
        return worktypePlanUseHour;
    }

    public void setWorktypePlanUseHour(String worktypePlanUseHour) {
        this.worktypePlanUseHour = worktypePlanUseHour == null ? null : worktypePlanUseHour.trim();
    }

    public String getWorktypePlanFee() {
        return worktypePlanFee;
    }

    public void setWorktypePlanFee(String worktypePlanFee) {
        this.worktypePlanFee = worktypePlanFee == null ? null : worktypePlanFee.trim();
    }

    public String getWorktypeActualUseHour() {
        return worktypeActualUseHour;
    }

    public void setWorktypeActualUseHour(String worktypeActualUseHour) {
        this.worktypeActualUseHour = worktypeActualUseHour == null ? null : worktypeActualUseHour.trim();
    }

    public String getWorktypeActualFee() {
        return worktypeActualFee;
    }

    public void setWorktypeActualFee(String worktypeActualFee) {
        this.worktypeActualFee = worktypeActualFee == null ? null : worktypeActualFee.trim();
    }
}