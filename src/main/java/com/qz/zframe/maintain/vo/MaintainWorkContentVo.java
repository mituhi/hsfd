package com.qz.zframe.maintain.vo;

import com.qz.zframe.maintain.entity.MaintainWorkContent;
import io.swagger.annotations.ApiModelProperty;

public class MaintainWorkContentVo extends MaintainWorkContent {

    @ApiModelProperty(name = "staffName", value = "工作人员姓名,逗号隔开", required = false)
    private String staffName;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
