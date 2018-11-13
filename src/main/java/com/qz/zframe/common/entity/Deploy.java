package com.qz.zframe.common.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qz.zframe.isc.domain.IscRole;

import io.swagger.annotations.ApiModelProperty;

public class Deploy {
	
	@ApiModelProperty(value="流程配置id",name="deployId",required=false)
	private String deployId;
	@ApiModelProperty(value="流程主表id",name="mainId",required=true)
	private String mainId;
	@ApiModelProperty(value="所属流程步骤",name="deploySort",required=false)
	private String deploySort;
	@ApiModelProperty(value="流程步骤名称",name="deployName",required=true)
	private String deployName;
	@ApiModelProperty(value="创建人id",name="creater",required=false)
	private String creater;
	@ApiModelProperty(value="创建时间",name="createTime",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createTime;
	@ApiModelProperty(value="该流程包含的角色",name="roles",required=false)
	private List<IscRole> roles;
	@ApiModelProperty(value="角色id（用于新增修改时传绑定的角色id）",name="roleIds",required=false)
	private List<String> roleIds;

	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getDeploySort() {
		return deploySort;
	}

	public void setDeploySort(String deploySort) {
		this.deploySort = deploySort;
	}

	public String getDeployName() {
		return deployName;
	}

	public void setDeployName(String deployName) {
		this.deployName = deployName;
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

	public List<IscRole> getRoles() {
		return roles;
	}

	public void setRoles(List<IscRole> roles) {
		this.roles = roles;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	
}
