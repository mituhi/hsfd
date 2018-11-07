package com.qz.zframe.run.entity.result;

import java.util.ArrayList;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: SchedulingQueryResult</p>
 * <p>@Description: 排班查询返回封装类 </p>
 * @author 陈汇奇
 * @date 2018年11月5日 下午1:48:19
 * @version:V1.0
 */
public class SchedulingQueryResult {

	@ApiModelProperty(value="开始日期",name="startDate")
	private String startDate;
	
	// 结束时间
	@ApiModelProperty(value="结束日期",name="endDate")
	private String endDate;
	
	// 用户名称
	@ApiModelProperty(value="用户名称集合",name="usernames")
	private ArrayList<String> usernames;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public ArrayList<String> getUsernames() {
		return usernames;
	}
	public void setUsernames(ArrayList<String> usernames) {
		this.usernames = usernames;
	}
	
	
}
