package com.qz.zframe.material.enums;



public enum  IsDeleteEnum {
	
	DELETE_YES("02","已删除"),
	DELETE_NO("01","正常");

	
	private String code;  
	
    private String text;
    
    
    IsDeleteEnum(String code, String text) {
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
