package com.qz.zframe.tally.entity;

import io.swagger.annotations.ApiModelProperty;

public class TallyResultChoose {
    //结果选项id
    @ApiModelProperty(value="结果选项id",name="chooseId",required=false)
    private  String chooseId;

    //结果id
    @ApiModelProperty(value="结果id",name="resultId",required=false)
    private  String resultId;

    //结果选项
    @ApiModelProperty(value="结果选项",name="resultChoose",required=false)
    private  String resultChoose;

    //报警等级
    @ApiModelProperty(value="报警等级",name="alarmLevel",required=false)
    private  String alarmLevel;

    @ApiModelProperty(value="报警等级名称",name="alarmLevelText",required=false)
    private  String alarmLevelText;


    public  String  getChooseId(){
        return  this.chooseId;
    };
    public  void  setChooseId(String chooseId){
        this.chooseId=chooseId;
    }

    public  String  getResultId(){
        return  this.resultId;
    };
    public  void  setResultId(String resultId){
        this.resultId=resultId;
    }

    public  String  getResultChoose(){
        return  this.resultChoose;
    };
    public  void  setResultChoose(String resultChoose){
        this.resultChoose=resultChoose;
    }

    public  String  getAlarmLevel(){
        return  this.alarmLevel;
    };
    public  void  setAlarmLevel(String alarmLevel){
        this.alarmLevel=alarmLevel;
    }

    public String getAlarmLevelText() {
        return alarmLevelText;
    }

    public void setAlarmLevelText(String alarmLevelText) {
        this.alarmLevelText = alarmLevelText;
    }
}
