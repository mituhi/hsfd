package com.qz.zframe.tickets.vo;

import io.swagger.annotations.ApiModelProperty;

public class TicketStatisticsRes {

    @ApiModelProperty(name="windId",value="风电场id",required=false)
    private String windId;

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="applyCount",value="申请数",required=false)
    private String applyCount;

    @ApiModelProperty(name="inProcessCount",value="处理中",required=false)
    private String inProcessCount;

    @ApiModelProperty(name="completeCount",value="完成",required=false)
    private String completeCount;

    @ApiModelProperty(name="invalidCount",value="作废",required=false)
    private String invalidCount;

    @ApiModelProperty(name="completeRate",value="完成率",required=false)
    private String completeRate;

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(String applyCount) {
        this.applyCount = applyCount;
    }

    public String getInProcessCount() {
        return inProcessCount;
    }

    public void setInProcessCount(String inProcessCount) {
        this.inProcessCount = inProcessCount;
    }

    public String getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(String completeCount) {
        this.completeCount = completeCount;
    }

    public String getInvalidCount() {
        return invalidCount;
    }

    public void setInvalidCount(String invalidCount) {
        this.invalidCount = invalidCount;
    }

    public String getCompleteRate() {
        return completeRate;
    }

    public void setCompleteRate(String completeRate) {
        this.completeRate = completeRate;
    }
}
