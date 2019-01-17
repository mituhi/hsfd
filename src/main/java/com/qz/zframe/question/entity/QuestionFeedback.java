package com.qz.zframe.question.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QuestionFeedback {
    private String questionId;

    private String userId;

    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;
    @Transient
    private String createTimes;
    
    private String contentQuestion;
    
    private String title;
    
    @Transient
    private List<String> file;
    @Transient
    private List<String>   route ;
    // 导出序号
    private String aaa;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion == null ? null : contentQuestion.trim();
    }

	public List<String> getFile() {
		return file;
	}

	public void setFile(List<String> file) {
		this.file = file;
	}
	@Transient
	public String getCreateTimes() {
		return createTimes;
	}
	@Transient
	public void setCreateTimes(String createTimes) {
		this.createTimes = createTimes;
	}
	@Transient
	public List<String> getRoute() {
		return route;
	}
	@Transient
	public void setRoute(List<String> route) {
		this.route = route;
	}

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
    
}