package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class WorkClassification {
	
	@ApiModelProperty(value="工作分类表id",name="classificationId")
    private String classificationId;

	@ApiModelProperty(value="分类流水号",name="classificationCode")
    private String classificationCode;

	@ApiModelProperty(value="分类名称",name="classificationName",required = true)
    private String classificationName;

	@ApiModelProperty(value="任务属性",name="taskProperties",required = true)
    private String taskProperties;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

	@ApiModelProperty(value="用户id",name="userId")
    private String userId;

	@ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;

	@ApiModelProperty(value="上级分类编号（如果为最顶级：值为0  ， 如果不为顶级下拉框选择）",name="fatClassificationId",required = true)
    private String fatClassificationId;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId == null ? null : classificationId.trim();
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode == null ? null : classificationCode.trim();
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName == null ? null : classificationName.trim();
    }

    public String getTaskProperties() {
        return taskProperties;
    }

    public void setTaskProperties(String taskProperties) {
        this.taskProperties = taskProperties == null ? null : taskProperties.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFatClassificationId() {
        return fatClassificationId;
    }

    public void setFatClassificationId(String fatClassificationId) {
        this.fatClassificationId = fatClassificationId == null ? null : fatClassificationId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}