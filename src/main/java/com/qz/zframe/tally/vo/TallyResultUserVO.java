package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TallyResultUserVO {
    @ApiModelProperty(value="流水号",name="serialNum",required=false)
    private String serialNum;
    @ApiModelProperty(value="申请日期",name="currentDate",required=false)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date currentDate;
    @ApiModelProperty(value="申请人",name="userName",required=false)
    private String userName;




    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}
