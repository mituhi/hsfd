package com.qz.zframe.run.entity.result;

import io.swagger.annotations.ApiModelProperty;

public class UserValueCodeResult {

	@ApiModelProperty(value="用户id",name="userId")
	private String userId;

	@ApiModelProperty(value="值次编码",name="valueCode")
	private String valueCode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

}
