package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class MaintainLog {
	
	@ApiModelProperty(value="维护日志表id",name="id")
    private String id;

	@ApiModelProperty(value="当前操作人员id",name="userId")
    private String userId;

	@ApiModelProperty(value="当前操作人员名字",name="username")
    private String username;

	@ApiModelProperty(value="操作时间",name="time")
    private Date time;

	@ApiModelProperty(value="操作的url",name="url")
    private String url;

	@ApiModelProperty(value="操作的方法",name="method")
    private String method;

	@ApiModelProperty(value="结果",name="result")
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}