package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TallyAlarmVO {
    //主键id
    private  String alarmId;

    //路线id
    private  String routeId;

    private String windId;

    private String routeName;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date benchmarkDate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    private String cycle;

    private String cycleUnit;

    private String equipmentBelonging;

    private String checkContent;

    private String standardJudgment;

    private String practitionerName;

    //结果
    private  String result;

    //处理备注
    private  String processingNotes;

    //处理人
    private  String processingPerson;

    //处理方案
    private  String processingScheme;


    public  String  getAlarmId(){
        return  this.alarmId;
    };
    public  void  setAlarmId(String alarmId){
        this.alarmId=alarmId;
    }

    public  String  getRouteId(){
        return  this.routeId;
    };
    public  void  setRouteId(String routeId){
        this.routeId=routeId;
    }

    public  String  getResult(){
        return  this.result;
    };
    public  void  setResult(String result){
        this.result=result;
    }

    public  String  getProcessingNotes(){
        return  this.processingNotes;
    };
    public  void  setProcessingNotes(String processingNotes){
        this.processingNotes=processingNotes;
    }

    public  String  getProcessingPerson(){
        return  this.processingPerson;
    };
    public  void  setProcessingPerson(String processingPerson){
        this.processingPerson=processingPerson;
    }

    public  String  getProcessingScheme(){
        return  this.processingScheme;
    };
    public  void  setProcessingScheme(String processingScheme){
        this.processingScheme=processingScheme;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Date getBenchmarkDate() {
        return benchmarkDate;
    }

    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getEquipmentBelonging() {
        return equipmentBelonging;
    }

    public void setEquipmentBelonging(String equipmentBelonging) {
        this.equipmentBelonging = equipmentBelonging;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getStandardJudgment() {
        return standardJudgment;
    }

    public void setStandardJudgment(String standardJudgment) {
        this.standardJudgment = standardJudgment;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }
}
