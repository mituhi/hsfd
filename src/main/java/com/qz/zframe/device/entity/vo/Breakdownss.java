package com.qz.zframe.device.entity.vo;

public class Breakdownss {
	private  String windId;//风电场id
	private  String windName;//风电场名称
	private  String numberFailuresActivated    ; //主控系统//机械类//故障激活数量
	private  String numberFailureRecovery  ; //变频器系统//电气类//故障恢复数量
	private  String failureToRecoverQuantity    ;//机舱内//自控类//故障未恢复数量
	private  String completionRate ;//机舱外//通讯类//完成率
	public String getWindId() {
		return windId;
	}
	public void setWindId(String windId) {
		this.windId = windId;
	}
	public String getWindName() {
		return windName;
	}
	public void setWindName(String windName) {
		this.windName = windName;
	}
	public String getNumberFailuresActivated() {
		return numberFailuresActivated;
	}
	public void setNumberFailuresActivated(String numberFailuresActivated) {
		this.numberFailuresActivated = numberFailuresActivated;
	}
	public String getNumberFailureRecovery() {
		return numberFailureRecovery;
	}
	public void setNumberFailureRecovery(String numberFailureRecovery) {
		this.numberFailureRecovery = numberFailureRecovery;
	}
	public String getFailureToRecoverQuantity() {
		return failureToRecoverQuantity;
	}
	public void setFailureToRecoverQuantity(String failureToRecoverQuantity) {
		this.failureToRecoverQuantity = failureToRecoverQuantity;
	}
	public String getCompletionRate() {
		return completionRate;
	}
	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}
	
	
	
}
