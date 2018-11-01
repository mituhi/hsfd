package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TallyRouterUserVO {
    private int serialNum;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date currentDate;
    private String userName;

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

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
}
