package com.qz.zframe.tally.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TallyAlarm {
    //主键id
    private  String alarmId;

    //风电场
    private  String windId;

    //线路名称
    private  String routeName;

    //开始时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date startTime;

    //结束时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date endTime;

    //设备名称
    private  String equipmentBelonging;

    //点检内容
    private  String checkContent;

    //点检标准
    private  String checkStandard;

    //处理标准
    private  String treatmentStandard;

    //结果
    private  String result;


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

    public  String  getCheckStandard(){
        return  this.checkStandard;
    };
    public  void  setCheckStandard(String checkStandard){
        this.checkStandard=checkStandard;
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
}
