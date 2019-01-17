package com.qz.zframe.run.entity.submit;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p> Title: UserValueTimeUpload</p>
 * <p>@Description: 规则信息新增 接收字段实体类</p>
 * 
 * @author 
 * @date 2018年11月2日 上午11:17:19
 * @version:V1.0
 */
public class UserValueTimeUpload {
	
	@ApiModelProperty(value="值次编码",name="valueCode")
	private String valueCode;
	@ApiModelProperty(value="用户id",name="userId")
	private String userId;
	@ApiModelProperty(value="班次编码",name="shiftCode")
	private String shiftCode;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
