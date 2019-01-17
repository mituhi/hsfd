package com.qz.zframe.common.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Res {
	
	@ApiModelProperty(value="资源id",name="resId",required=false)
	private String resId;
	@ApiModelProperty(value="上级资源id",name="resPid",required=false)
    private String resPid;
	@ApiModelProperty(value="上级资源name",name="resPidName",required=false)
    private String resPidName;
	@ApiModelProperty(value="资源名称",name="resName",required=false)
    private String resName;
	@ApiModelProperty(value="资源值",name="resValue",required=false)
    private String resValue;
	@ApiModelProperty(value="资源类型",name="resType",required=false)
    private String resType;
	@ApiModelProperty(value="资源类型名称",name="resTypeText",required=false)
    private String resTypeText;
	@ApiModelProperty(value="资源路径",name="resPath",required=false)
    private String resPath;
	@ApiModelProperty(value="资源属性",name="resAttr",required=false)
    private String resAttr;
	@ApiModelProperty(value="排序号",name="orderNo",required=false)
    private Integer orderNo;
	@ApiModelProperty(value="下级资源",name="children",required=false)
    List<Res> children = new ArrayList<>();

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResPid() {
		return resPid;
	}

	public void setResPid(String resPid) {
		this.resPid = resPid;
	}

	public String getResPidName() {
		return resPidName;
	}

	public void setResPidName(String resPidName) {
		this.resPidName = resPidName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResValue() {
		return resValue;
	}

	public void setResValue(String resValue) {
		this.resValue = resValue;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResTypeText() {
		return resTypeText;
	}

	public void setResTypeText(String resTypeText) {
		this.resTypeText = resTypeText;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public String getResAttr() {
		return resAttr;
	}

	public void setResAttr(String resAttr) {
		this.resAttr = resAttr;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public List<Res> getChildren() {
		return children;
	}

	public void setChildren(List<Res> children) {
		this.children = children;
	}
    
}
