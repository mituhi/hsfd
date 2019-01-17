package com.qz.zframe.run.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class WorkPerform {
	
	@ApiModelProperty(value="任务执行id",name="performId")
    private String performId;

	@ApiModelProperty(value="工作任务id",name="workTaskId")
    private String workTaskId;

	@ApiModelProperty(value="计划开始时间/启动时间",name="startTime",required=true)
    private Date startTime;

	@ApiModelProperty(value="计划完成时间",name="completeTime",required=true)
    private Date completeTime;

	@ApiModelProperty(value="处理人",name="dealPeople",required=true)
    private String dealPeople;

	@ApiModelProperty(value="实际完成时间",name="endTime",required=true)
    private Date endTime;

	@ApiModelProperty(value="参与人",name="participants")
    private String participants;

    @ApiModelProperty(value="完成情况",name="completion")
    private String completion;

    @ApiModelProperty(value="存在问题",name="question")
    private String question;
    
    @ApiModelProperty(value="多余字段/不用在意",name="launchTime")
    private Date launchTime;

    @ApiModelProperty(value="完成状态",name="completeStatus")
    private String completeStatus;

    public String getPerformId() {
        return performId;
    }

    public void setPerformId(String performId) {
        this.performId = performId == null ? null : performId.trim();
    }

    public String getWorkTaskId() {
        return workTaskId;
    }

    public void setWorkTaskId(String workTaskId) {
        this.workTaskId = workTaskId == null ? null : workTaskId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getDealPeople() {
        return dealPeople;
    }

    public void setDealPeople(String dealPeople) {
        this.dealPeople = dealPeople == null ? null : dealPeople.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants == null ? null : participants.trim();
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion == null ? null : completion.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus == null ? null : completeStatus.trim();
    }
}