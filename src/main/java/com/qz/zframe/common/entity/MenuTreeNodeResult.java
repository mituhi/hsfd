package com.qz.zframe.common.entity;

import java.util.List;

import com.qz.zframe.isc.service.orgTree.result.ResultMessage;

public class MenuTreeNodeResult extends ResultMessage {
	private List<Res> resList;

    public MenuTreeNodeResult(boolean success, List<Res> resList) {
        super(success);
        this.resList = resList;
    }

    public MenuTreeNodeResult(boolean success, String message) {
        super(success, message);
    }

    public List<Res> getResList() {
        return resList;
    }

    public void setResList(List<Res> resList) {
        this.resList = resList;
    }
}
