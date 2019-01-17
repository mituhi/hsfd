package com.qz.zframe.device.entity.vo;

public class Breakdowns {
	private  String windId;//风电场id
	private  String windName;//风电场名称
	private  String mechanicalClass   ; //主控系统//机械类//故障激活数量
	private  String electricClass ; //变频器系统//电气类//故障恢复数量
	private  String autoControlClass   ;//机舱内//自控类//故障未恢复数量
	private  String communicationClass  ;//机舱外//通讯类//完成率
	private  String supertemperatureClass  ;//偏航系统//超温类//
	private  String hydraulicType  ;//变桨系统//液压类//
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
	public String getMechanicalClass() {
		return mechanicalClass;
	}
	public void setMechanicalClass(String mechanicalClass) {
		this.mechanicalClass = mechanicalClass;
	}
	public String getElectricClass() {
		return electricClass;
	}
	public void setElectricClass(String electricClass) {
		this.electricClass = electricClass;
	}
	public String getAutoControlClass() {
		return autoControlClass;
	}
	public void setAutoControlClass(String autoControlClass) {
		this.autoControlClass = autoControlClass;
	}
	public String getCommunicationClass() {
		return communicationClass;
	}
	public void setCommunicationClass(String communicationClass) {
		this.communicationClass = communicationClass;
	}
	public String getSupertemperatureClass() {
		return supertemperatureClass;
	}
	public void setSupertemperatureClass(String supertemperatureClass) {
		this.supertemperatureClass = supertemperatureClass;
	}
	public String getHydraulicType() {
		return hydraulicType;
	}
	public void setHydraulicType(String hydraulicType) {
		this.hydraulicType = hydraulicType;
	}

	
}
