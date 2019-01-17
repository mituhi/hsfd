package com.qz.zframe.tally.entity;

import java.util.Date;

public class TallyRecord {
    //主键id
    private  String recordId;

    //路线id
    private  String routeId;

    //点检人姓名
    private  String practitionerName;

    //标准数量
    private  String standardQuantity;

    //记录数量
    private  String recordNumber;

    //报警数量
    private  String alarmNumber;

    //已处理报警数量
    private  String processedAlerts;

    //点检结果
    private  String checkResult;


    public  String  getRecordId(){
        return  this.recordId;
    };
    public  void  setRecordId(String recordId){
        this.recordId=recordId;
    }

    public  String  getRouteId(){
        return  this.routeId;
    };
    public  void  setRouteId(String routeId){
        this.routeId=routeId;
    }

    public  String  getPractitionerName(){
        return  this.practitionerName;
    };
    public  void  setPractitionerName(String practitionerName){
        this.practitionerName=practitionerName;
    }

    public  String  getStandardQuantity(){
        return  this.standardQuantity;
    };
    public  void  setStandardQuantity(String standardQuantity){
        this.standardQuantity=standardQuantity;
    }

    public  String  getRecordNumber(){
        return  this.recordNumber;
    };
    public  void  setRecordNumber(String recordNumber){
        this.recordNumber=recordNumber;
    }

    public  String  getAlarmNumber(){
        return  this.alarmNumber;
    };
    public  void  setAlarmNumber(String alarmNumber){
        this.alarmNumber=alarmNumber;
    }

    public  String  getProcessedAlerts(){
        return  this.processedAlerts;
    };
    public  void  setProcessedAlerts(String processedAlerts){
        this.processedAlerts=processedAlerts;
    }

    public  String  getCheckResult(){
        return  this.checkResult;
    };
    public  void  setCheckResult(String checkResult){
        this.checkResult=checkResult;
    }
}
