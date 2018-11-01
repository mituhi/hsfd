package com.qz.zframe.common.util;

import com.fasterxml.jackson.annotation.JsonView;

public class ResultEntity extends BaseResultEntity{
	@JsonView({ BaseJsonView.class })
	private Object data;

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
