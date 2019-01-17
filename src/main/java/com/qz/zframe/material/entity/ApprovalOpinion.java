package com.qz.zframe.material.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ApprovalOpinion implements Serializable {

	private static final long serialVersionUID = -2042237336672160635L;
	
	@ApiModelProperty(name="pickingId",value="领料单Id",required=true)
	private String  pickingId;
	
	@ApiModelProperty(name="approvalOpinion",value="备注",required=true)
	private String approvalOpinion;

	public String getPickingId() {
		return pickingId;
	}

	public void setPickingId(String pickingId) {
		this.pickingId = pickingId;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}
	
	
	

}
