package com.qz.zframe.run.entity.result;

import io.swagger.annotations.ApiModelProperty;

public class ShiftValueCodeResult {

	@ApiModelProperty(value="班次编码",name="shiftCode")
	private String shiftCode;

	@ApiModelProperty(value="值次编码",name="valueCode")
	private String valueCode;

	public String getShiftCode() {
		return shiftCode;
	}

	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

}
