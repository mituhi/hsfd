package com.qz.zframe.common.util;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

public class BaseResultEntity {

	@JsonView({ BaseJsonView.class })
	@ApiModelProperty(value="返回码（0，成功；-1，失败）",name="code",required=false)
	private int code = -1;

	@JsonView({ BaseJsonView.class })
	@ApiModelProperty(value="返回信息",name="msg",required=false)
	private String msg;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
