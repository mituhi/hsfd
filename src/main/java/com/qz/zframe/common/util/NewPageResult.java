package com.qz.zframe.common.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回类")
public class NewPageResult<T> extends BaseResultEntity{

	@ApiModelProperty(value="总条数")
	@JsonView({ BaseJsonView.class })
	private int total;
	
	@ApiModelProperty(value="集合")
	@JsonView({ BaseJsonView.class })
	private T rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}
	
	
}
