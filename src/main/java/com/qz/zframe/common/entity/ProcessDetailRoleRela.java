package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class ProcessDetailRoleRela {

    @ApiModelProperty(value="关系id",name="relaId",required=false)
    private String relaId;

    @ApiModelProperty(value="详情id",name="processDetailId",required=false)
    private String processDetailId;

    @ApiModelProperty(value="角色id",name="roleId",required=false)
    private String roleId;

    public String getRelaId() {
        return relaId;
    }

    public void setRelaId(String relaId) {
        this.relaId = relaId == null ? null : relaId.trim();
    }

    public String getProcessDetailId() {
        return processDetailId;
    }

    public void setProcessDetailId(String processDetailId) {
        this.processDetailId = processDetailId == null ? null : processDetailId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}