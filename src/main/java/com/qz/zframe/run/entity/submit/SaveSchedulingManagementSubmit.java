package com.qz.zframe.run.entity.submit;

import java.util.List;

import com.qz.zframe.run.entity.SchedulingAssociated;
import com.qz.zframe.run.entity.SchedulingManagement;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: SaveSchedulingManagementSubmit</p>
 * <p> @Description: 排版管理表添加页面提交封装类 </p>
 * 
 * @author 陈汇奇
 * @date 2018年11月2日 下午5:05:22
 * @version:V1.0
 */
public class SaveSchedulingManagementSubmit {
	
	@ApiModelProperty(value="排班管理对象",name="schedulingManagement",required=true)
	private SchedulingManagement schedulingManagement;

	@ApiModelProperty(value="排班关联对象集合",name="schedulingAssociateds",required=true)
	private List<SchedulingAssociated> schedulingAssociateds;

	public SchedulingManagement getSchedulingManagement() {
		return schedulingManagement;
	}

	public void setSchedulingManagement(SchedulingManagement schedulingManagement) {
		this.schedulingManagement = schedulingManagement;
	}

	public List<SchedulingAssociated> getSchedulingAssociateds() {
		return schedulingAssociateds;
	}

	public void setSchedulingAssociateds(List<SchedulingAssociated> schedulingAssociateds) {
		this.schedulingAssociateds = schedulingAssociateds;
	}

}
