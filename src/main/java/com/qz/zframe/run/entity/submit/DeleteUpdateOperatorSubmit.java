package com.qz.zframe.run.entity.submit;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p> Title: DeleteUpdateOperatorSubmit </p>
 * <p>@Description: 删除值班人员</p>
 * 
 * @author 陈汇奇
 * @date 2018年11月6日 上午9:04:57
 * @version:V1.0
 */
public class DeleteUpdateOperatorSubmit {

	@ApiModelProperty(value="用户id",name="userId",required=true)
	private List<String> userId;

	@ApiModelProperty(value="排班规则表id",name="schedulingRuleId",required=true)
	private String schedulingRuleId;
	
	@ApiModelProperty(value="值次名称",name="valueName",required=true)
	private String valueName;

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public String getSchedulingRuleId() {
		return schedulingRuleId;
	}

	public void setSchedulingRuleId(String schedulingRuleId) {
		this.schedulingRuleId = schedulingRuleId;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

}
