package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class MaterialUnit implements Serializable {

	private static final long serialVersionUID = -2438530897871709565L;

	@ApiModelProperty(name="measuringUnitId",value="单位Id",required=true)
	private String measuringUnitId;

	@ApiModelProperty(name="measuringUnitCode",value="单位编码",required=true)
    private String measuringUnitCode;

	@ApiModelProperty(name="measuringUnitName",value="单位名称",required=true)
    private String measuringUnitName;

	@ApiModelProperty(name="status",value="状态，01启用，02停用",required=true)
    private String status;

	@ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;

	@ApiModelProperty(name="creater",value="创建人",required=false)
    private String creater;

	@ApiModelProperty(name="createTime",value="创建时间",required=false)
    private Date createTime;

	@ApiModelProperty(name="isDelete",value="删除状态",required=false)
    private String isDelete;

    public String getMeasuringUnitId() {
        return measuringUnitId;
    }

    public void setMeasuringUnitId(String measuringUnitId) {
        this.measuringUnitId = measuringUnitId == null ? null : measuringUnitId.trim();
    }

    public String getMeasuringUnitCode() {
        return measuringUnitCode;
    }

    public void setMeasuringUnitCode(String measuringUnitCode) {
        this.measuringUnitCode = measuringUnitCode == null ? null : measuringUnitCode.trim();
    }

    public String getMeasuringUnitName() {
        return measuringUnitName;
    }

    public void setMeasuringUnitName(String measuringUnitName) {
        this.measuringUnitName = measuringUnitName == null ? null : measuringUnitName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}