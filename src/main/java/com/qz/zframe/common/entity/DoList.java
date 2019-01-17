package com.qz.zframe.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * 待办信息表
 */
public class DoList {

    @ApiModelProperty(value="代办id",name="doId",required=false)
    private String doId;
    @ApiModelProperty(value="任务id",name="taskId",required=false)
    private String taskId;
    @ApiModelProperty(value="任务编号",name="taskCode",required=false)
    private String taskCode;
    @ApiModelProperty(value="任务描述",name="taskDescribe",required=false)
    private String taskDescribe;
    @ApiModelProperty(value="任务类型",name="taskType",required=false)
    private String taskType;
    @ApiModelProperty(value="创建时间",name="createTime",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;
    @ApiModelProperty(value="角色",name="roles",required=false)
    private List<Role> roles;
    @ApiModelProperty(value="角色id",name="roleStr",required=false)
    private List<DoRoleRela> doRoleRelas;
    @ApiModelProperty(value="任务类型名称",name="taskTypeText",required=false)
    private String taskTypeText;

    public String getDoId() {
        return doId;
    }

    public void setDoId(String doId) {
        this.doId = doId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<DoRoleRela> getDoRoleRelas() {
        return doRoleRelas;
    }

    public void setDoRoleRelas(List<DoRoleRela> doRoleRelas) {
        this.doRoleRelas = doRoleRelas;
    }

    public String getTaskTypeText() {
        return taskTypeText;
    }

    public void setTaskTypeText(String taskTypeText) {
        this.taskTypeText = taskTypeText;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }
}
