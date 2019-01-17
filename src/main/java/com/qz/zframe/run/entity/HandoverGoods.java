package com.qz.zframe.run.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class HandoverGoods implements Serializable{
	
	private static final long serialVersionUID = -1465243198909475001L;

	@ApiModelProperty(value="交接物品表id",name="handoverGoodsId",required=true)
    private String handoverGoodsId;

	@ApiModelProperty(value="序号",name="serialNum",required=false)
    private String serialNum;

	@ApiModelProperty(value="风电场编码",name="windCode",required=true)
    private String windCode;

	@ApiModelProperty(value="风电场名称",name="windName",required=false)
    private String windName;

	@ApiModelProperty(value="日志类型",name="logName",required=false)
    private String logName;

	@ApiModelProperty(value="日志类型id",name="logId",required=true)
    private String logTypeId;

	@ApiModelProperty(value="维护人ID",name="maintainUser")
    private String maintainUser;
	
	@ApiModelProperty(value="维护人名称",name="maintainUserName")
    private String maintainUserName;

	@ApiModelProperty(value="状态,01启用，02停用",name="status",required=true)
    private String status;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

	@ApiModelProperty(value="维护时间",name="maintainTime")
    private Date maintainTime;
	
	@ApiModelProperty(value="物品数量",name="goodNum")
	private Integer goodNum;
	
	private List<Goods> goods;

	public String getHandoverGoodsId() {
		return handoverGoodsId;
	}

	public void setHandoverGoodsId(String handoverGoodsId) {
		this.handoverGoodsId = handoverGoodsId;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getWindCode() {
		return windCode;
	}

	public void setWindCode(String windCode) {
		this.windCode = windCode;
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

	public String getLogTypeId() {
		return logTypeId;
	}

	public void setLogTypeId(String logTypeId) {
		this.logTypeId = logTypeId;
	}

	public String getMaintainUser() {
		return maintainUser;
	}

	public void setMaintainUser(String maintainUser) {
		this.maintainUser = maintainUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getMaintainTime() {
		return maintainTime;
	}

	public void setMaintainTime(Date maintainTime) {
		this.maintainTime = maintainTime;
	}

	public Integer getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public String getMaintainUserName() {
		return maintainUserName;
	}

	public void setMaintainUserName(String maintainUserName) {
		this.maintainUserName = maintainUserName;
	}  

}