package com.qz.zframe.tally.entity;

import java.util.Date;

public class TallyUnchecked {
    //主键id
    private  String uncheckedId;

    //路线id
    private  String routeId;

    //完成时间
    private  Date finishTime;

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

    //备注详情
    private  String volumeDetails;


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

    public  Date  getFinishTime(){
        return  this.finishTime;
    };
    public  void  setFinishTime(Date finishTime){
        this.finishTime=finishTime;
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

    public  String  getVolumeDetails(){
        return  this.volumeDetails;
    };
    public  void  setVolumeDetails(String volumeDetails){
        this.volumeDetails=volumeDetails;
    }
}
