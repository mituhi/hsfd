package com.qz.zframe.material.enums;

public enum MaterialClassifyLevelEnum {

	LEVEL_TOP("01", "顶级"),
	LEVEL_COMMON("02", "非顶级");

	private String code;

	private String text;

	MaterialClassifyLevelEnum(String code, String text) {
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
