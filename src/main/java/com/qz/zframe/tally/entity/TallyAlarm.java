package com.qz.zframe.tally.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TallyAlarm {
    //主键id
    @ApiModelProperty(value="主键id",name="alarmId",required=true)
    private  String alarmId;

    //风电场
    @ApiModelProperty(value="风电场id",name="windId",required=true)
    private  String windId;

    //风电场
    @ApiModelProperty(value="风电场名称",name="windName",required=true)
    private  String windName;

    //标准id
    @ApiModelProperty(value="标准id",name="standardId",required=true)
    private  String standardId;

    //线路名称
    @ApiModelProperty(value="线路名称",name="routeName",required=true)
    private  String routeName;

    //开始时间
    @ApiModelProperty(value="开始时间",name="startTime",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date startTime;

    //结束时间
    @ApiModelProperty(value="结束时间",name="endTime",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date endTime;

    //设备名称
    @ApiModelProperty(value="设备名称",name="equipmentBelonging",required=true)
    private  String equipmentBelonging;

    //点检内容
    @ApiModelProperty(value="点检内容",name="checkContent",required=true)
    private  String checkContent;

    //处理标准
    @ApiModelProperty(value="处理标准",name="treatmentStandard",required=true)
    private  String treatmentStandard;

    //结果
    @ApiModelProperty(value="结果",name="result",required=true)
    private  String result;

    //点检人
    @ApiModelProperty(value="点检人id",name="tallyPerson",required=true)
    private  String tallyPerson;

    //点检人名称
    @ApiModelProperty(value="点检人名称",name="tallyPersonName",required=true)
    private  String tallyPersonName;

    //处理状态
    @ApiModelProperty(value="处理状态id",name="processingStatus",required=true)
    private  String processingStatus;

    //处理状态名称
    @ApiModelProperty(value="处理状态名称",name="processingStatusName",required=true)
    private  String processingStatusName;

    //设备id
    @ApiModelProperty(value="设备id",name="equipmentId",required=true)
    private  String equipmentId;

    //设备名称
    @ApiModelProperty(value="设备名称",name="equipmentName",required=true)
    private  String equipmentName;

    //点检标准
    @ApiModelProperty(value="点检标准",name="standardType",required=true)
    private  String standardType;

    //点检标准名称
    @ApiModelProperty(value="点检标准名称",name="standardTypeName",required=true)
    private  String standardTypeName;

    //处理人id
    @ApiModelProperty(value="处理人id",name="processingPerson",required=true)
    private  String processingPerson;

    //处理人名称
    @ApiModelProperty(value="处理人名称",name="processingPersonName",required=true)
    private  String processingPersonName;

    //处理方案
    @ApiModelProperty(value="处理方案",name="processingScheme",required=true)
    private  String processingScheme;

    //创建时间
    @ApiModelProperty(value="创建时间",name="createTime",required=true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date createTime;

    @ApiModelProperty(value="判断标准",name="standardJudgment",required=false)
    private String standardJudgment;

    @ApiModelProperty(value="位置id",name="positionId",required=false)
    private String positionId;

    @ApiModelProperty(value="机组id",name="crew",required=false)
    private String crew;

    public  String  getAlarmId(){
        return  this.alarmId;
    };
    public  void  setAlarmId(String alarmId){
        this.alarmId=alarmId;
    }

    public  String  getWindId(){
        return  this.windId;
    };
    public  void  setWindId(String windId){
        this.windId=windId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Date getStartTime(){
        return  this.startTime;
    };
    public  void  setStartTime(Date startTime){
        this.startTime=startTime;
    }

    public  Date  getEndTime(){
        return  this.endTime;
    };
    public  void  setEndTime(Date endTime){
        this.endTime=endTime;
    }

    public  String  getEquipmentBelonging(){
        return  this.equipmentBelonging;
    };
    public  void  setEquipmentBelonging(String equipmentBelonging){
        this.equipmentBelonging=equipmentBelonging;
    }

    public  String  getCheckContent(){
        return  this.checkContent;
    };
    public  void  setCheckContent(String checkContent){
        this.checkContent=checkContent;
    }

    public  String  getTreatmentStandard(){
        return  this.treatmentStandard;
    };
    public  void  setTreatmentStandard(String treatmentStandard){
        this.treatmentStandard=treatmentStandard;
    }

    public  String  getResult(){
        return  this.result;
    };
    public  void  setResult(String result){
        this.result=result;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getTallyPerson() {
        return tallyPerson;
    }

    public void setTallyPerson(String tallyPerson) {
        this.tallyPerson = tallyPerson;
    }

    public String getTallyPersonName() {
        return tallyPersonName;
    }

    public void setTallyPersonName(String tallyPersonName) {
        this.tallyPersonName = tallyPersonName;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public String getProcessingStatusName() {
        return processingStatusName;
    }

    public void setProcessingStatusName(String processingStatusName) {
        this.processingStatusName = processingStatusName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }

    public String getProcessingPerson() {
        return processingPerson;
    }

    public void setProcessingPerson(String processingPerson) {
        this.processingPerson = processingPerson;
    }

    public String getProcessingPersonName() {
        return processingPersonName;
    }

    public void setProcessingPersonName(String processingPersonName) {
        this.processingPersonName = processingPersonName;
    }

    public String getProcessingScheme() {
        return processingScheme;
    }

    public void setProcessingScheme(String processingScheme) {
        this.processingScheme = processingScheme;
    }

    public String getStandardTypeName() {
        return standardTypeName;
    }

    public void setStandardTypeName(String standardTypeName) {
        this.standardTypeName = standardTypeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getStandardJudgment() {
        return standardJudgment;
    }

    public void setStandardJudgment(String standardJudgment) {
        this.standardJudgment = standardJudgment;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }
}
