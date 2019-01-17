package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.OperateTicketType;
import com.qz.zframe.tickets.entity.UserAssoInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class OperateTicketTypeVo extends OperateTicketType {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="maintainerName",value="维护人姓名",required=false)
    private String maintainerName;

    @ApiModelProperty(name="executerList",value="操作人list",required=false)
    private List<UserAssoVo> executerList = new ArrayList<>();

    @ApiModelProperty(name="supervisiorList",value="监护人list",required=false)
    private List<UserAssoVo> supervisiorList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getMaintainerName() {
        return maintainerName;
    }

    public void setMaintainerName(String maintainerName) {
        this.maintainerName = maintainerName;
    }


    public List<UserAssoVo> getExecuterList() {
        return executerList;
    }

    public void setExecuterList(List<UserAssoVo> executerList) {
        this.executerList = executerList;
    }

    public List<UserAssoVo> getSupervisiorList() {
        return supervisiorList;
    }

    public void setSupervisiorList(List<UserAssoVo> supervisiorList) {
        this.supervisiorList = supervisiorList;
    }
}
