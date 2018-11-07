package com.qz.zframe.material.enums;

public enum EnableStatusEnum {
	
	ENABLE_START("01", "启用"),
	ENABLE_STOP("02", "停用");

	private String code;

	private String text;

	EnableStatusEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
