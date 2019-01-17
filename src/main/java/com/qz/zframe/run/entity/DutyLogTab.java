package com.qz.zframe.run.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class DutyLogTab {
	
	@ApiModelProperty(value="值班日志TAB表id",name="tabId")
    private String tabId;

	@ApiModelProperty(value="值班日志TAB表编号",name="tabCode")
    private String tabCode;

	@ApiModelProperty(value="值班日志TAB表名称",name="tabName")
    private String tabName;

	@ApiModelProperty(value="值班日志TAB表Url链接",name="url")
    private String url;

    @ApiModelProperty(value="值班日志TAB表Url链接",name="url")
	private String maintainer;

    @ApiModelProperty(value="值班日志TAB表Url链接",name="url")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date maintainTime;

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
    }

    public String getTabCode() {
        return tabCode;
    }

    public void setTabCode(String tabCode) {
        this.tabCode = tabCode == null ? null : tabCode.trim();
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public Date getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }
}