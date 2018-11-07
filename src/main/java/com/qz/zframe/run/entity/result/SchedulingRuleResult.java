package com.qz.zframe.run.entity.result;

import java.util.Set;

import com.qz.zframe.run.entity.SchedulingRule;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingRuleResult extends SchedulingRule {
	
	@ApiModelProperty(value="值次编码集合",name="valueCodeList")
	private Set<String> valueCodeList;

	public Set<String> getValueCodeList() {
		return valueCodeList;
	}

	public void setValueCodeList(Set<String> valueCodeList) {
		this.valueCodeList = valueCodeList;
	}

}
