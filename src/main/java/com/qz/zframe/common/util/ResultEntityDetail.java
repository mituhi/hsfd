package com.qz.zframe.common.util;

import org.apache.poi.ss.formula.functions.T;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultEntityDetail<T> extends BaseResultEntity{
	
	@JsonView({ BaseJsonView.class })
	@ApiModelProperty(value="返回实体",name="data",required=false)
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
