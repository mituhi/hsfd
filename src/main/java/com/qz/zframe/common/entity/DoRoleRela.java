package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 待办角色关联表
 */
public class DoRoleRela {

    @ApiModelProperty(value="关联id",name="relaId",required=false)
    private String relaId;
    @ApiModelProperty(value="角色id",name="roleId",required=false)
    private String roleId;
    @ApiModelProperty(value="代办id",name="doId",required=false)
    private String doId;

    public String getRelaId() {
        return relaId;
    }

    public void setRelaId(String relaId) {
        this.relaId = relaId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDoId() {
        return doId;
    }

    public void setDoId(String doId) {
        this.doId = doId;
    }
}
