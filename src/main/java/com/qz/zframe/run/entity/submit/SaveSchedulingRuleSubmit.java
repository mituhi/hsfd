package com.qz.zframe.run.entity.submit;

import java.util.List;

import com.qz.zframe.run.entity.SchedulingRule;
import com.qz.zframe.run.entity.result.ShiftValueCodeResult;
import com.qz.zframe.run.entity.result.UserValueCodeResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Title: SaveSchedulingRuleSbumit</p>
 * <p>@Description: 排班规则添加页面提交封装类 </p>
 * @author 陈汇奇
 * @date 2018年11月2日 下午5:05:44
 * @version:V1.0
 */
public class SaveSchedulingRuleSubmit {

	@ApiModelProperty(value="存放班次编码，值次编码集合",name="shiftValueCodeResults",required=true)
	private List<ShiftValueCodeResult> shiftValueCodeResults;

	@ApiModelProperty(value="存放用户id，值次编码集合",name="userValueCodeResults",required=true)
	private List<UserValueCodeResult> userValueCodeResults;

	@ApiModelProperty(value="排班规则",name="schedulingRule",required=true)
	private SchedulingRule schedulingRule;

	public List<ShiftValueCodeResult> getShiftValueCodeResults() {
		return shiftValueCodeResults;
	}

	public void setShiftValueCodeResults(List<ShiftValueCodeResult> shiftValueCodeResults) {
		this.shiftValueCodeResults = shiftValueCodeResults;
	}

	public List<UserValueCodeResult> getUserValueCodeResults() {
		return userValueCodeResults;
	}

	public void setUserValueCodeResults(List<UserValueCodeResult> userValueCodeResults) {
		this.userValueCodeResults = userValueCodeResults;
	}

	public SchedulingRule getSchedulingRule() {
		return schedulingRule;
	}

	public void setSchedulingRule(SchedulingRule schedulingRule) {
		this.schedulingRule = schedulingRule;
	}

}
