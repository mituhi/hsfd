package com.qz.zframe.run.entity.submit;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: WorkPerformSearchSubmit</p>
 * <p>@Description: 工作执行查询页面提交的查询条件封装类 </p>
 * @author 
 * @date 2018年11月13日 下午4:23:44
 * @version:V1.0
 */
public class WorkPerformSearchSubmit {
	
	//工作执行表主键
	private String performId;
	
	// 任务分类
	private String classificationName;
	// 机组
	private String unit;
	// 负责班组
	private String depart;
	// 风场
	private List<String> windIds;
	// 状态 -----这个是完成状态
	private String status;
	// 关键字
	private String searchKey;
	// 计划开始时间--起
	private Date startTime;
	// 计划开始时间--止
	private Date endTime;
	
	

	public String getPerformId() {
		return performId;
	}

	public void setPerformId(String performId) {
		this.performId = performId;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public List<String> getWindIds() {
		return windIds;
	}

	public void setWindIds(List<String> windIds) {
		this.windIds = windIds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
