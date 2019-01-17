package com.qz.zframe.run.entity.submit;

import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkPerform;
import com.qz.zframe.run.entity.WorkTask;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: WorkPerformTaskSubmit</p>
 * <p>@Description: 工作执行查询提交数据封装类 </p>
 * @author 
 * @date 2018年11月13日 上午10:32:31
 * @version:V1.0
 */
public class WorkPerformTaskSubmit {

	@ApiModelProperty(value = "工作执行表", name = "workPerform")
	private WorkPerform workPerform;

	@ApiModelProperty(value = "工作任务表", name = "workTask")
	private WorkTask workTask;

	@ApiModelProperty(value = "工作分类表", name = "workClassification")
	private WorkClassification workClassification;
	
	
	
	public WorkClassification getWorkClassification() {
		return workClassification;
	}

	public void setWorkClassification(WorkClassification workClassification) {
		this.workClassification = workClassification;
	}  

	public WorkPerform getWorkPerform() {
		return workPerform;
	}

	public void setWorkPerform(WorkPerform workPerform) {
		this.workPerform = workPerform;
	}

	public WorkTask getWorkTask() {
		return workTask;
	}

	public void setWorkTask(WorkTask workTask) {
		this.workTask = workTask;
	}
	
}
