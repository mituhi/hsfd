package com.qz.zframe.common.util;

public class PageExample {
	private int pageNo = 1;
	private int pageSize = 10;
	private int isPage = 1;

	public void setPageNo(Integer pageNo) {
		if (pageNo != null) {
			this.pageNo = pageNo.intValue();
		}
	}

	public int getPageNo() {
		if (this.pageNo < 1) {
			return 1;
		}
		return this.pageNo;
	}

	public int getPageSize() {
		if (this.pageSize < 1) {
			return 10;
		}
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize != null) {
			this.pageSize = pageSize.intValue();
		}
	}

	public int getPageIndex() {
		return (getPageNo() - 1) * getPageSize();
	}

	public int getIsPage() {
		return this.isPage;
	}

	public void setIsPage(int isPage) {
		this.isPage = isPage;
	}

	public static int getPageIndex(Integer pageNo, Integer pageSize) {
		return (((pageNo == null) || (pageNo.intValue() < 1) ? 1 : pageNo.intValue()) - 1) * getPageSize(pageSize);
	}

	public static int getPageSize(Integer pageSize) {
		if ((pageSize == null) || (pageSize.intValue() < 1)) {
			return 10;
		}
		return pageSize.intValue();
	}

}
