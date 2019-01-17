package com.qz.zframe.run.entity.result;

import io.swagger.annotations.ApiModelProperty;

public class ShiftValueCodeResult {

	@ApiModelProperty(value="班次Id",name="shiftCode")
	private String shiftId;

	@ApiModelProperty(value="值次Id",name="valueCode")
	private String valueId;

	@ApiModelProperty(value="天次Id",name="dayId")
	private String dayId;

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public String getValueId() {
		return valueId;
	}

	public void setValueId(String valueId) {
		this.valueId = valueId;
	}

	public String getDayId() {
		return dayId;
	}

	public void setDayId(String dayId) {
		this.dayId = dayId;
	}
}
