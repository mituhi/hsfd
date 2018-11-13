package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class DutyRemember {
	
	@ApiModelProperty(value="当班记事id",name="dutyId")
    private String dutyId;

	@ApiModelProperty(value="运行日志id",name="runLogId")
    private String runLogId;

	@ApiModelProperty(value="记事时间",name="rememberTime")
    private String rememberTime;

	@ApiModelProperty(value="记事主题",name="rememberTheme",required=true)
    private String rememberTheme;

	@ApiModelProperty(value="记事内容",name="rememberContent",required=true)
    private String rememberContent;

	@ApiModelProperty(value="记事人",name="remember")
    private String remember;

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId == null ? null : dutyId.trim();
    }

    public String getRunLogId() {
        return runLogId;
    }

    public void setRunLogId(String runLogId) {
        this.runLogId = runLogId == null ? null : runLogId.trim();
    }

    public String getRememberTime() {
        return rememberTime;
    }

    public void setRememberTime(String rememberTime) {
        this.rememberTime = rememberTime == null ? null : rememberTime.trim();
    }

    public String getRememberTheme() {
        return rememberTheme;
    }

    public void setRememberTheme(String rememberTheme) {
        this.rememberTheme = rememberTheme == null ? null : rememberTheme.trim();
    }

    public String getRememberContent() {
        return rememberContent;
    }

    public void setRememberContent(String rememberContent) {
        this.rememberContent = rememberContent == null ? null : rememberContent.trim();
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember == null ? null : remember.trim();
    }
}