package com.qz.zframe.run.entity.result;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: SchedulingManagementResult</p>
 * <p> @Description: 排班表首页查询字段返回包装类</p>
 * @author 陈汇奇
 * @date 2018年11月2日 下午6:25:09
 * @version:V1.0
 */
public class SchedulingManagementResult {

	@ApiModelProperty(value="排班关联表id",name="schedulingAssociatedId",required=true)
	private String schedulingAssociatedId;  //排班关联表id

	@ApiModelProperty(value="排班编号",name="schedulingCode",required=true)
	private String schedulingCode;       //排版管理表中  排班编号

	@ApiModelProperty(value=" 排班表名称",name="schedulingName",required=true)
	private String schedulingName;		//排版管理表中  排班表名称

	@ApiModelProperty(value="  部门名称",name="department",required=true)
	private String department;			//排版管理表中  部门名称

	@ApiModelProperty(value=" 排班规则编码",name="schedulingRuleCode",required=true)
	private String schedulingRuleCode;	//排班规则表中   排班规则编码

	@ApiModelProperty(value="排班规则名称",name="schedulingRule",required=true)
	private String schedulingRule;		//排班规则表中   排班规则名称

	@ApiModelProperty(value="开始日期",name="startTime",required=true)
	private Date startTime;				

	@ApiModelProperty(value="结束日期",name="endTime",required=true)
	private Date endTime;

	public String getSchedulingAssociatedId() {
		return schedulingAssociatedId;
	}

	public void setSchedulingAssociatedId(String schedulingAssociatedId) {
		this.schedulingAssociatedId = schedulingAssociatedId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSchedulingRuleCode() {
		return schedulingRuleCode;
	}

	public void setSchedulingRuleCode(String schedulingRuleCode) {
		this.schedulingRuleCode = schedulingRuleCode;
	}

	public String getSchedulingRule() {
		return schedulingRule;
	}

	public void setSchedulingRule(String schedulingRule) {
		this.schedulingRule = schedulingRule;
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
