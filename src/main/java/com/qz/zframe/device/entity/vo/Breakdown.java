package com.qz.zframe.device.entity.vo;


public class Breakdown{
   
	private  String windId;//风电场id
	private  String windName;//风电场名称
	private  String A ; //主控系统//机械类//故障激活数量
	private  String B; //变频器系统//电气类//故障恢复数量
	private  String C;//机舱内//自控类//故障未恢复数量
	private  String D;//机舱外//通讯类//完成率
	private  String E;//偏航系统//超温类//
	private  String F;//变桨系统//液压类//
	private  String G;//其他设备//

	public String getA() {
		return A;
	}
	public String getB() {
		return B;
	}
	public String getC() {
		return C;
	}
	public String getD() {
		return D;
	}
	public String getE() {
		return E;
	}
	public String getF() {
		return F;
	}
	public String getG() {
		return G;
	}
	public void setA(String a) {
		A = a;
	}
	public void setB(String b) {
		B = b;
	}
	public void setC(String c) {
		C = c;
	}
	public void setD(String d) {
		D = d;
	}
	public void setE(String e) {
		E = e;
	}
	public void setF(String f) {
		F = f;
	}
	public void setG(String g) {
		G = g;
	}

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

	
	
	
	
	
	
}
