package com.qz.zframe.material.enums;

public enum InInventoryTypeEnum {
	
	ORDINARY_INITIAL("01", "普通入库"),
	STAGE_INITIAL("02", "期初入库");
    
	private String code;

	private String text;

	InInventoryTypeEnum(String code, String text) {
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
