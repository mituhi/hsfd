package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.WorkorderType;
import io.swagger.annotations.ApiModelProperty;

public class WorkorderTypeVo extends WorkorderType {

    @ApiModelProperty(name = "number", value = "序号", required = false)
    private int number;

    @ApiModelProperty(name = "statusName", value = "维护人姓名", required = false)
    private String statusName;

    @ApiModelProperty(name = "maintainerName", value = "维护人姓名", required = false)
    private String maintainerName;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
}
