package com.qz.zframe.tickets.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.tickets.entity.WorkTicketType;
import com.qz.zframe.tickets.entity.WorkTicketTypeSafeMeasure;
import com.qz.zframe.tickets.entity.WorkTicketTypeUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTicketTypeVo extends WorkTicketType{

    private List<WorkTicketTypeSafeMeasure> safeMeasureList = new ArrayList<>();

    private List<WorkTicketTypeUser> workHeadList = new ArrayList<>();

    private List<WorkTicketTypeUser> signerList = new ArrayList<>();

    private List<WorkTicketTypeUser> licensorList = new ArrayList<>();

    public List<WorkTicketTypeSafeMeasure> getSafeMeasureList() {
        return safeMeasureList;
    }

    public void setSafeMeasureList(List<WorkTicketTypeSafeMeasure> safeMeasureList) {
        this.safeMeasureList = safeMeasureList;
    }

    public List<WorkTicketTypeUser> getWorkHeadList() {
        return workHeadList;
    }

    public void setWorkHeadList(List<WorkTicketTypeUser> workHeadList) {
        this.workHeadList = workHeadList;
    }

    public List<WorkTicketTypeUser> getSignerList() {
        return signerList;
    }

    public void setSignerList(List<WorkTicketTypeUser> signerList) {
        this.signerList = signerList;
    }

    public List<WorkTicketTypeUser> getLicensorList() {
        return licensorList;
    }

    public void setLicensorList(List<WorkTicketTypeUser> licensorList) {
        this.licensorList = licensorList;
    }


}
