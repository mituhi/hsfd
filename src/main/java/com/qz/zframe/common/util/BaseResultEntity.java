package com.qz.zframe.common.util;

import com.fasterxml.jackson.annotation.JsonView;

public class BaseResultEntity {

	@JsonView({ BaseJsonView.class })
	private int code = -1;
	@JsonView({ BaseJsonView.class })
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
