package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.UserAssoInfo;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class OperateTicketTypeVo extends OperateTicketType {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    private List<UserAssoInfo> executerList = new ArrayList<>();

    private List<UserAssoInfo> supervisiorList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public List<UserAssoInfo> getExecuterList() {
        return executerList;
    }

    public void setExecuterList(List<UserAssoInfo> executerList) {
        this.executerList = executerList;
    }

    public List<UserAssoInfo> getSupervisiorList() {
        return supervisiorList;
    }

    public void setSupervisiorList(List<UserAssoInfo> supervisiorList) {
        this.supervisiorList = supervisiorList;
    }
}
