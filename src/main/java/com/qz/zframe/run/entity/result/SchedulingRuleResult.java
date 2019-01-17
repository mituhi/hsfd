package com.qz.zframe.run.entity.result;

import java.util.Set;

import com.qz.zframe.run.entity.SchedulingRule;

import io.swagger.annotations.ApiModelProperty;

public class SchedulingRuleResult extends SchedulingRule {
	
	@ApiModelProperty(value="值次编码集合",name="valueCodeList")
	private Set<String> valueCodeList;

	
	@ApiModelProperty(value="值次编码集合/用于导出到Excel",name="valueCodeStr")
	private String valueCodeStr;

	@ApiModelProperty(value="值次编码拼接",name="valueCodes")
	private String valueCodes;

	@ApiModelProperty(value="班次编码拼接",name="valueCodes")
	private String shifts;

	public String getShifts() {
		return shifts;
	}

	public void setShifts(String shifts) {
		this.shifts = shifts;
	}

	public String getValueCodes() {
		return valueCodes;
	}

	public void setValueCodes(String valueCodes) {
		this.valueCodes = valueCodes;
	}

	public String getValueCodeStr() {
		return valueCodeStr;
	}

	public void setValueCodeStr(String valueCodeStr) {
		this.valueCodeStr = valueCodeStr;
	}

	public Set<String> getValueCodeList() {
		return valueCodeList;
	}

	public void setValueCodeList(Set<String> valueCodeList) {
		this.valueCodeList = valueCodeList;
	}

}
