package com.qz.zframe.common.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class PageResultEntity extends BaseResultEntity {
	@JsonView({ BaseJsonView.class })
	private int total;
	@JsonView({ BaseJsonView.class })
	private List rows;

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return this.rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
