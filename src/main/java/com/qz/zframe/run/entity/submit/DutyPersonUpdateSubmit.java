package com.qz.zframe.run.entity.submit;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>Title: DutyPersonUpdateSubmit</p>
 * <p>@Description: 封装值班人员查询条件类 </p>
 * @author
 * @date 2018年11月21日 下午6:04:26
 * @version:V1.0
 */
public class DutyPersonUpdateSubmit {
	
	//值班人员修改id
	private String dutyPersonUpdateId;
	//班次id
	private String shiftId;
	//排班名称
	private String schedulingName;
	//日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	//默认查询时间
	private Date defaultDate;
	
	//默认查询时间的改月最后一天日期
	private Date monthOfLastDate;
	
	//风电场
	private String department;
	
	
	public Date getMonthOfLastDate() {
		return monthOfLastDate;
	}

	public void setMonthOfLastDate(Date monthOfLastDate) {
		this.monthOfLastDate = monthOfLastDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDefaultDate() {
		return defaultDate;
	}

	public void setDefaultDate(Date defaultDate) {
		this.defaultDate = defaultDate;
	}

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public String getSchedulingName() {
		return schedulingName;
	}

	public void setSchedulingName(String schedulingName) {
		this.schedulingName = schedulingName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDutyPersonUpdateId() {
		return dutyPersonUpdateId;
	}

	public void setDutyPersonUpdateId(String dutyPersonUpdateId) {
		this.dutyPersonUpdateId = dutyPersonUpdateId;
	}
	
	
	
}
