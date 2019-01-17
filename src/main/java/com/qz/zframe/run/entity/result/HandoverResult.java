package com.qz.zframe.run.entity.result;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: HandoverResult</p>
 * <p>@Description: 交接物品配置页面查询返回结果类封装 </p>
 * @author 
 * @date 2018年11月14日 下午6:12:20
 * @version:V1.0
 */
public class HandoverResult{
	
	@ApiModelProperty(value="交接物品关联表id",name="handoverGoodsRelationId")
	private String handoverGoodsRelationId;

	@ApiModelProperty(value="交接物品表id",name="handoverGoodsId")
	private String handoverGoodsId;

	@ApiModelProperty(value="风电场名称",name="windName")
	private String windName;

	@ApiModelProperty(value="日志名称",name="logName")
	private String logName;

	@ApiModelProperty(value="备注",name="remark")
	private String remark;

	@ApiModelProperty(value="状态",name="status")
	private String status;

	@ApiModelProperty(value="维护人",name="maintainUser")
	private String maintainUser;

	@ApiModelProperty(value="维护时间",name="maintainTime")
	private Date maintainTime;

	@ApiModelProperty(value="物品数量",name="count")
	private int count;

	@ApiModelProperty(value="维护时间（用于导出Excel）",name="maintainTimeStr")
	private String maintainTimeStr;
	

	public String getMaintainTimeStr() {
		return maintainTimeStr;
	}

	public void setMaintainTimeStr(String maintainTimeStr) {
		this.maintainTimeStr = maintainTimeStr;
	}

	public String getHandoverGoodsRelationId() {
		return handoverGoodsRelationId;
	}

	public void setHandoverGoodsRelationId(String handoverGoodsRelationId) {
		this.handoverGoodsRelationId = handoverGoodsRelationId;
	}

	public String getHandoverGoodsId() {
		return handoverGoodsId;
	}

	public void setHandoverGoodsId(String handoverGoodsId) {
		this.handoverGoodsId = handoverGoodsId;
	}

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMaintainUser() {
		return maintainUser;
	}

	public void setMaintainUser(String maintainUser) {
		this.maintainUser = maintainUser;
	}

	public Date getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Date maintainTime) {
		this.maintainTime = maintainTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
