package com.qz.zframe.run.entity.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>Title: SchedulingQueryResult</p>
 * <p>@Description: 排班查询返回封装类 </p>
 * @author 
 * @date 2018年11月5日 下午1:48:19
 * @version:V1.0
 */
public class SchedulingQueryResult {
	
	private String dutyPersonUpdateId;
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	
	private Date dutyDate;
	
	private String department;
	
	private String schedulingCode;
	
	private String schedulingName;
	
	private String valueName;
	
	private String shiftName;
	
	private String userName;

	private String userId;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDutyPersonUpdateId() {
		return dutyPersonUpdateId;
	}

	public void setDutyPersonUpdateId(String dutyPersonUpdateId) {
		this.dutyPersonUpdateId = dutyPersonUpdateId;
	}

	public Date getDutyDate() {
		return dutyDate;
	}

	public void setDutyDate(Date dutyDate) {
		this.dutyDate = dutyDate;
	}

	public String getSchedulingCode() {
		return schedulingCode;
	}

	public void setSchedulingCode(String schedulingCode) {
		this.schedulingCode = schedulingCode;
	}

	public String getSchedulingName() {
		return schedulingName;
	}

	public void setSchedulingName(String schedulingName) {
		this.schedulingName = schedulingName;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
