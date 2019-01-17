package com.qz.zframe.run.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class WorkClassification {
	
	@ApiModelProperty(value="工作分类表id",name="classificationId")
    private String classificationId;

    @ApiModelProperty(value="是否顶级",name="isTop")
    private String isTop;

	@ApiModelProperty(value="分类流水号/编号",name="classificationCode")
    private String classificationCode;

    @ApiModelProperty(value="上级分类编号（如果为最顶级：值为0  ， 如果不为顶级下拉框选择）",name="superiorClassificationId",required = true)
    private String superiorClassificationId;

	@ApiModelProperty(value="分类名称",name="classificationName",required = true)
    private String classificationName;

	@ApiModelProperty(value="任务属性",name="taskProperties",required = false)
    private String taskProperties;

	@ApiModelProperty(value="状态",name="status",required = true)
    private String status;

	@ApiModelProperty(value="维护人",name="maintainer")
    private String maintainer;

	@ApiModelProperty(value="维护时间",name="maintainTime")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date maintainTime;

    @ApiModelProperty(value="创建人",name="creater")
    private String creater;

    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getSuperiorClassificationId() {
        return superiorClassificationId;
    }

    public void setSuperiorClassificationId(String superiorClassificationId) {
        this.superiorClassificationId = superiorClassificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getTaskProperties() {
        return taskProperties;
    }

    public void setTaskProperties(String taskProperties) {
        this.taskProperties = taskProperties;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}