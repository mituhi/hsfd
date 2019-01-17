package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketType;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketTypeVo extends WorkTicketType {

    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    @ApiModelProperty(name="maintainerName",value="维护人姓名",required=false)
    private String maintainerName;

    @ApiModelProperty(name="safeMeasureList",value="安全措施list",required=false)
    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

    @ApiModelProperty(name="workHeadList",value="工作负责人list",required=false)
    private List<UserAssoVo> workHeadList = new ArrayList<>();

    @ApiModelProperty(name="signerList",value="签发人list",required=false)
    private List<UserAssoVo> signerList = new ArrayList<>();

    @ApiModelProperty(name="maintainerName",value="许可人list",required=false)
    private List<UserAssoVo> licensorList = new ArrayList<>();

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

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<UserAssoVo> getWorkHeadList() {
        return workHeadList;
    }

    public void setWorkHeadList(List<UserAssoVo> workHeadList) {
        this.workHeadList = workHeadList;
    }

    public List<UserAssoVo> getSignerList() {
        return signerList;
    }

    public void setSignerList(List<UserAssoVo> signerList) {
        this.signerList = signerList;
    }

    public List<UserAssoVo> getLicensorList() {
        return licensorList;
    }

    public void setLicensorList(List<UserAssoVo> licensorList) {
        this.licensorList = licensorList;
    }
}
