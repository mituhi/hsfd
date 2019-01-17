package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class ProcessDetail {

    @ApiModelProperty(value="详情id",name="processDetailId",required=false)
    private String processDetailId;

    @ApiModelProperty(value="流程主表id",name="processId",required=false)
    private String processId;

    @ApiModelProperty(value="步骤",name="sort",required=false)
    private Integer sort;

    @ApiModelProperty(value="名称",name="name",required=false)
    private String name;

    @ApiModelProperty(value="状态",name="status",required=false)
    private String status;

    @ApiModelProperty(value="流程详情与角色关联列表",name="processDetailRoleRelas",required=false)
    private List<ProcessDetailRoleRela> processDetailRoleRelas = new ArrayList<>();

    public String getProcessDetailId() {
        return processDetailId;
    }

    public void setProcessDetailId(String processDetailId) {
        this.processDetailId = processDetailId == null ? null : processDetailId.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public List<ProcessDetailRoleRela> getProcessDetailRoleRelas() {
        return processDetailRoleRelas;
    }

    public void setProcessDetailRoleRelas(List<ProcessDetailRoleRela> processDetailRoleRelas) {
        this.processDetailRoleRelas = processDetailRoleRelas;
    }
}