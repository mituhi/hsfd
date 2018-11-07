package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 物资分类
 * 
 * @author syc
 * @date 2018年11月1日上午10:44:22
 *
 */
public class MaterialClassify implements Serializable {

	private static final long serialVersionUID = -3404684235497599150L;

	public interface ListView extends BaseJsonView {};

	
	@ApiModelProperty(name="materialClassifyId",value="物资分类id",required=true)
	@JsonView({ ListView.class })
	private String materialClassifyId;

	
	@ApiModelProperty(name="classifyName",value="物资分类名称",required=true)
	@JsonView({ ListView.class })
	private String classifyName;

	/**
	 * 物资分类描述
	 */
	@ApiModelProperty(name="classifyDescribe",value="物资分类描述",required=true)
	@JsonView({ ListView.class })
	private String classifyDescribe;

	@ApiModelProperty(name="isTop",value="是否顶级，01是，02否",required=true)
	@JsonView({ ListView.class })
	private String isTop;

	
	@ApiModelProperty(name="superiorClassifyId",value="上级分类id",required=true)
	@JsonView({ ListView.class })
	private String superiorClassifyId;
	
	@ApiModelProperty(name="superiorClassifyName",value="上级分类名称",required=false)
	@JsonView({ ListView.class })
	private String superiorClassifyName;

	@ApiModelProperty(name="status",value="状态，01启用，02停用",required=true)
	@JsonView({ ListView.class })
	private String status;

	
	@ApiModelProperty(name="remark",value="备注",required=false)
	@JsonView({ ListView.class })
	private String remark;

	@ApiModelProperty(name="sort",value="sort",required=false)
	private String sort;

	@ApiModelProperty(name="isDelete",value="删除状态，01是，02否",required=false)
	private String isDelete;

	@ApiModelProperty(name="creater",value="创建人",required=false)
	private String creater;

	@ApiModelProperty(name="createTime",value="创建时间",required=false)
	private Date createTime;

	public String getMaterialClassifyId() {
		return materialClassifyId;
	}

	public void setMaterialClassifyId(String materialClassifyId) {
		this.materialClassifyId = materialClassifyId == null ? null : materialClassifyId.trim();
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName == null ? null : classifyName.trim();
	}

	public String getClassifyDescribe() {
		return classifyDescribe;
	}

	public void setClassifyDescribe(String classifyDescribe) {
		this.classifyDescribe = classifyDescribe == null ? null : classifyDescribe.trim();
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop == null ? null : isTop.trim();
	}

	public String getSuperiorClassifyId() {
		return superiorClassifyId;
	}

	public void setSuperiorClassifyId(String superiorClassifyId) {
		this.superiorClassifyId = superiorClassifyId == null ? null : superiorClassifyId.trim();
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

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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

	public String getSuperiorClassifyName() {
		return superiorClassifyName;
	}

	public void setSuperiorClassifyName(String superiorClassifyName) {
		this.superiorClassifyName = superiorClassifyName;
	}
	
	
}