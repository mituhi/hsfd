package com.qz.zframe.tally.entity;

import java.util.Date;

public class TallyUnchecked {
    //主键id
    private  String uncheckedId;

    //路线id
    private  String routeId;

    //开始时间
    private  Date startTime;

    //结束时间
    private  Date endTime;

    //实机执行人
    private  String actualExecutor;

    //未检数量
    private  String uncheckedQuantity;

    //已检数量
    private  String checkedQuantity;

    //总数
    private  String total;

    //漏检率
    private  String leakageRate;

    //已备注数量
    private  String volumeRemarks;

    //日期
    private  Date date;

    //漏检原因
    private  String causeLeak;

    //漏检数量
    private  String leakageQuantity;

    //部门名称
    private  String departmentName;


    public  String  getUncheckedId(){
        return  this.uncheckedId;
    };
    public  void  setUncheckedId(String uncheckedId){
        this.uncheckedId=uncheckedId;
    }

    public  String  getRouteId(){
        return  this.routeId;
    };
    public  void  setRouteId(String routeId){
        this.routeId=routeId;
    }

    public  Date  getStartTime(){
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

    public  String  getActualExecutor(){
        return  this.actualExecutor;
    };
    public  void  setActualExecutor(String actualExecutor){
        this.actualExecutor=actualExecutor;
    }

    public  String  getUncheckedQuantity(){
        return  this.uncheckedQuantity;
    };
    public  void  setUncheckedQuantity(String uncheckedQuantity){
        this.uncheckedQuantity=uncheckedQuantity;
    }

    public  String  getCheckedQuantity(){
        return  this.checkedQuantity;
    };
    public  void  setCheckedQuantity(String checkedQuantity){
        this.checkedQuantity=checkedQuantity;
    }

    public  String  getTotal(){
        return  this.total;
    };
    public  void  setTotal(String total){
        this.total=total;
    }

    public  String  getLeakageRate(){
        return  this.leakageRate;
    };
    public  void  setLeakageRate(String leakageRate){
        this.leakageRate=leakageRate;
    }

    public  String  getVolumeRemarks(){
        return  this.volumeRemarks;
    };
    public  void  setVolumeRemarks(String volumeRemarks){
        this.volumeRemarks=volumeRemarks;
    }

    public Date getDate(){
        return  this.date;
    };
    public  void  setDate(Date date){
        this.date=date;
    }

    public  String  getCauseLeak(){
        return  this.causeLeak;
    };
    public  void  setCauseLeak(String causeLeak){
        this.causeLeak=causeLeak;
    }

    public  String  getLeakageQuantity(){
        return  this.leakageQuantity;
    };
    public  void  setLeakageQuantity(String leakageQuantity){
        this.leakageQuantity=leakageQuantity;
    }

    public  String  getDepartmentName(){
        return  this.departmentName;
    };
    public  void  setDepartmentName(String departmentName){
        this.departmentName=departmentName;
    }
}
