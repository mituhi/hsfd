package com.qz.zframe.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ApproveRecord {

    @ApiModelProperty(value="审批id",name="approveId",required=false)
    private String approveId;

    @ApiModelProperty(value="关联id",name="orderId",required=false)
    private String orderId;

    @ApiModelProperty(value="详情id",name="processDetailId",required=false)
    private String processDetailId;

    @ApiModelProperty(value="步骤名称",name="processDetailName",required=false)
    private String processDetailName;

    @ApiModelProperty(value="审批结果",name="approveResult",required=false)
    private String approveResult;

    @ApiModelProperty(value="审批人",name="approveUser",required=false)
    private String approveUser;

    @ApiModelProperty(value="审批人姓名",name="approveUserName",required=false)
    private String approveUserName;

    @ApiModelProperty(value="审批时间",name="approveTime",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date approveTime;

    @ApiModelProperty(value="审批意见",name="approveOpinion",required=false)
    private String approveOpinion;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProcessDetailId() {
        return processDetailId;
    }

    public void setProcessDetailId(String processDetailId) {
        this.processDetailId = processDetailId == null ? null : processDetailId.trim();
    }

    public String getProcessDetailName() {
        return processDetailName;
    }

    public void setProcessDetailName(String processDetailName) {
        this.processDetailName = processDetailName;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult == null ? null : approveResult.trim();
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser == null ? null : approveUser.trim();
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion == null ? null : approveOpinion.trim();
    }
}