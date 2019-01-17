package com.qz.zframe.run.entity.submit;

import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.run.entity.WorkTask;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: WorkTaskSubmit</p>
 * <p>@Description: 工作任务添加提交信息包装实体类 </p>
 * @author 
 * @date 2018年11月16日 下午2:10:01
 * @version:V1.0
 */
public class WorkTaskSubmit {
	
	//工作任务信息
	@ApiModelProperty(value = "工作任务信息对象", name = "workTask")
	private WorkTask workTask;
	
	//上传的文件
	@ApiModelProperty(value = "上传的附件", name = "multipartFile")
	private MultipartFile multipartFile;

	public WorkTask getWorkTask() {
		return workTask;
	}

	public void setWorkTask(WorkTask workTask) {
		this.workTask = workTask;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	
	
}
