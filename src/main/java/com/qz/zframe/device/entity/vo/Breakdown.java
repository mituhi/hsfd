package com.qz.zframe.device.entity.vo;


public class Breakdown{
   
	private  String windId;//风电场id
	private  String windName;//风电场名称
	private  String masterControlSystem  ; //主控系统//机械类//故障激活数量
	private  String frequencyConverterSystem ; //变频器系统//电气类//故障恢复数量
	private  String cabin ;//机舱内//自控类//故障未恢复数量
	private  String outsideTheCabin ;//机舱外//通讯类//完成率
	private  String yawSystem ;//偏航系统//超温类//
	private  String paddleSystem ;//变桨系统//液压类//
	private  String otherEquipment ;//其他设备//
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
	public String getMasterControlSystem() {
		return masterControlSystem;
	}
	public void setMasterControlSystem(String masterControlSystem) {
		this.masterControlSystem = masterControlSystem;
	}
	public String getFrequencyConverterSystem() {
		return frequencyConverterSystem;
	}
	public void setFrequencyConverterSystem(String frequencyConverterSystem) {
		this.frequencyConverterSystem = frequencyConverterSystem;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getOutsideTheCabin() {
		return outsideTheCabin;
	}
	public void setOutsideTheCabin(String outsideTheCabin) {
		this.outsideTheCabin = outsideTheCabin;
	}
	public String getYawSystem() {
		return yawSystem;
	}
	public void setYawSystem(String yawSystem) {
		this.yawSystem = yawSystem;
	}
	public String getPaddleSystem() {
		return paddleSystem;
	}
	public void setPaddleSystem(String paddleSystem) {
		this.paddleSystem = paddleSystem;
	}
	public String getOtherEquipment() {
		return otherEquipment;
	}
	public void setOtherEquipment(String otherEquipment) {
		this.otherEquipment = otherEquipment;
	}
	
	
	

}
