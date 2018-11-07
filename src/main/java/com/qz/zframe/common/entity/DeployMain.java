package com.qz.zframe.common.entity;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DeployMain {
	
	@ApiModelProperty(value="流程主表id",name="mainId",required=false)
	private String mainId;
	@ApiModelProperty(value="流程编号",name="mainCode",required=true)
	private String mainCode;
	@ApiModelProperty(value="流程名称",name="mainDeployName",required=true)
	private String mainDeployName;
	@ApiModelProperty(value="流程状态 01 启用  02 停用  03 删除",name="mainStatus",required=false)
	private String mainStatus;
	@ApiModelProperty(value="流程编码",name="mainCoding",required=false)
	private String mainCoding;
	@ApiModelProperty(value="流程总步骤",name="mainNum",required=false)
	private String mainNum;
	@ApiModelProperty(value="所属流程中的步骤信息",name="deploys",required=false)
	private List<Deploy> deploys;
	
	public String getMainId() {
		return mainId;
	}
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	public String getMainCode() {
		return mainCode;
	}
	public void setMainCode(String mainCode) {
		this.mainCode = mainCode;
	}
	public String getMainDeployName() {
		return mainDeployName;
	}
	public void setMainDeployName(String mainDeployName) {
		this.mainDeployName = mainDeployName;
	}
	public String getMainStatus() {
		return mainStatus;
	}
	public void setMainStatus(String mainStatus) {
		this.mainStatus = mainStatus;
	}
	public String getMainCoding() {
		return mainCoding;
	}
	public void setMainCoding(String mainCoding) {
		this.mainCoding = mainCoding;
	}
	public String getMainNum() {
		return mainNum;
	}
	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}
	public List<Deploy> getDeploys() {
		return deploys;
	}
	public void setDeploys(List<Deploy> deploys) {
		this.deploys = deploys;
	}
	
}
