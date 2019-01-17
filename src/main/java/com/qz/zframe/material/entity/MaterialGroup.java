package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 物资分组
 * 
 * @author syc
 * @date 2018年11月1日上午10:43:19
 *
 */
public class MaterialGroup implements Serializable {

	private static final long serialVersionUID = -5889193983418462045L;

	public interface ListView extends BaseJsonView {};

	@ApiModelProperty(name="materialGroupId",value="物资分组id",required=true)
	@JsonView({ ListView.class })
	private String materialGroupId;


	@ApiModelProperty(name="groupCode",value="物资分组编码",required=true)
	@JsonView({ ListView.class })
	private String groupCode;


	@ApiModelProperty(name="groupName",value="物资分组名称",required=true)
	@JsonView({ ListView.class })
	private String groupName;

	@ApiModelProperty(name="status",value="物资分组状态，01启用，02停用",required=true)
	@JsonView({ ListView.class })
	private String status;
	
	@ApiModelProperty(name="groupStatusText",value="物资分组状态文本",required=false)
	@JsonView({ ListView.class })
	private String groupStatusText;

	@ApiModelProperty(name="remark",value="备注",required=false)
	@JsonView({ ListView.class })
	private String remark;


	@ApiModelProperty(name="sort",value="排序",required=false)
	private String sort;

	@ApiModelProperty(name="isDelete",value="删除状态",required=false)
	private String isDelete;


	@ApiModelProperty(name="creater",value="创建人",required=false)
	private String creater;

	@ApiModelProperty(name="createTime",value="创建时间",required=false)
	private Date createTime;

	public String getMaterialGroupId() {
		return materialGroupId;
	}

	public void setMaterialGroupId(String materialGroupId) {
		this.materialGroupId = materialGroupId == null ? null : materialGroupId.trim();
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode == null ? null : groupCode.trim();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort == null ? null : sort.trim();
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
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

	public String getGroupStatusText() {
		return groupStatusText;
	}

	public void setGroupStatusText(String groupStatusText) {
		this.groupStatusText = groupStatusText;
	}
	
	
}