package com.qz.zframe.material.enums;

/**
 * 库存中物资状态
 * 
 * @author syc
 * @date 2018年11月27日下午7:57:37
 *
 */
public enum StockMaterialStatusEnum {
	
	STATUS_NORMAL("01", "正常"),
	STATUS_SCRAP("02", "报废"),
	STATUS_AUDIT("03", "待审核");
	
	private String code;
	
	private String text;
	
	StockMaterialStatusEnum(String code,String text){
		this.code=code;
		this.text=text;
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
