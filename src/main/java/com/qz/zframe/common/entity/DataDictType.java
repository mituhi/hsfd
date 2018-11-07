package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

public class DataDictType {
	
	@ApiModelProperty(value="ID",name="id",required=false)
	private String id;
	@ApiModelProperty(value="分类编码",name="name",required=true)
	private String name;
	@ApiModelProperty(value="分类名称",name="title",required=true)
	private String title;
	@ApiModelProperty(value="分类描述",name="description",required=false)
	private String description;
	@ApiModelProperty(value="父id",name="parentId",required=false)
	private String parentId;
	@ApiModelProperty(value="显示顺序",name="dispOrder",required=false)
	private String dispOrder;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(String dispOrder) {
		this.dispOrder = dispOrder;
	}
	
}
