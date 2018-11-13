package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class DataDict {
	@ApiModelProperty(value="ID",name="id",required=false)
	private String id;
	@ApiModelProperty(value="代码分类表主键id",name="codeTypeId",required=true)
	private String codeTypeId;
	@ApiModelProperty(value="代码编号",name="name",required=true)
	private String name;
	@ApiModelProperty(value="代码名称",name="title",required=true)
	private String title;
	@ApiModelProperty(value="扩展字段01",name="content01",required=false)
	private String content01;
	@ApiModelProperty(value="扩展字段02",name="content02",required=false)
	private String content02;
	@ApiModelProperty(value="代码描述",name="description",required=false)
	private String description;
	@ApiModelProperty(value="状态 01:有效;02:无效",name="state",required=true)
	private String state;
	@ApiModelProperty(value="状态翻译",name="statusText",required=false)
	private String statusText;
	@ApiModelProperty(value="显示顺序",name="dispOrder",required=false)
	private int dispOrder;
	@ApiModelProperty(value="代码分类编码",name="codeTypeName",required=false)
	private String codeTypeName;
	@ApiModelProperty(value="代码分类名称",name="codeTypeTitle",required=false)
	private String codeTypeTitle;
	@ApiModelProperty(value="代码分类描述",name="codeTypeDescription",required=false)
	private String codeTypeDescription;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeTypeId() {
		return codeTypeId;
	}
	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent01() {
		return content01;
	}
	public void setContent01(String content01) {
		this.content01 = content01;
	}
	public String getContent02() {
		return content02;
	}
	public void setContent02(String content02) {
		this.content02 = content02;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return state;
	}
	public void setStatus(String state) {
		this.state = state;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public int getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}
	public String getCodeTypeName() {
		return codeTypeName;
	}
	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}
	public String getCodeTypeTitle() {
		return codeTypeTitle;
	}
	public void setCodeTypeTitle(String codeTypeTitle) {
		this.codeTypeTitle = codeTypeTitle;
	}
	public String getCodeTypeDescription() {
		return codeTypeDescription;
	}
	public void setCodeTypeDescription(String codeTypeDescription) {
		this.codeTypeDescription = codeTypeDescription;
	}
	
}
