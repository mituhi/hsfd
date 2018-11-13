package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.UserAssoInfo;
import com.qz.zframe.tickets.entity.WorkTicketSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketType;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketTypeVo extends WorkTicketType {

    @ApiParam(name="windName",value="风电场名称",required=false)
    private String windName;

    private List<WorkTicketSafeMeasure> safeMeasureList = new ArrayList<>();

    private List<UserAssoInfo> workHeadList = new ArrayList<>();

    private List<UserAssoInfo> signerList = new ArrayList<>();

    private List<UserAssoInfo> licensorList = new ArrayList<>();

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public List<WorkTicketSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<UserAssoInfo> getWorkHeadList() {
        return workHeadList;
    }

    public void setWorkHeadList(List<UserAssoInfo> workHeadList) {
        this.workHeadList = workHeadList;
    }

    public List<UserAssoInfo> getSignerList() {
        return signerList;
    }

    public void setSignerList(List<UserAssoInfo> signerList) {
        this.signerList = signerList;
    }

    public List<UserAssoInfo> getLicensorList() {
        return licensorList;
    }

    public void setLicensorList(List<UserAssoInfo> licensorList) {
        this.licensorList = licensorList;
    }
}
