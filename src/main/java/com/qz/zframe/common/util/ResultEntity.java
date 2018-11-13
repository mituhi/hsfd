package com.qz.zframe.common.util;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

public class ResultEntity extends BaseResultEntity{
	@JsonView({ BaseJsonView.class })
	@ApiModelProperty(value="返回实体",name="data",required=false)
	private Object data;

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
