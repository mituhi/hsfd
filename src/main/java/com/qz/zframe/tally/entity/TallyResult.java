package com.qz.zframe.tally.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TallyResult {
    //结果id
    @ApiModelProperty(value="结果id",name="resultId",required=false)
    private  String resultId;

    //结果选项分组名称
    @ApiModelProperty(value="结果选项分组名称",name="resultName",required=false)
    private  String resultName;

    //是否多选
    @ApiModelProperty(value="是否多选",name="manyChoose",required=false)
    private  String manyChoose;

    //结果选项
    @ApiModelProperty(value="结果选项编号",name="resultCode",required=false)
    private  String resultCode;

    @ApiModelProperty(value="结果选项表",name="tallyResultChooseList",required=false)
    private List<TallyResultChoose> tallyResultChooseList;

    //是否删除
    @ApiModelProperty(value="是否删除",name="isDelete",required=false)
    private  String isDelete;

    //结果选项
    @ApiModelProperty(value="结果选项",name="resultChoose",required=false)
    private  String resultChoose;

    public  String  getResultId(){
        return  this.resultId;
    };
    public  void  setResultId(String resultId){
        this.resultId=resultId;
    }

    public  String  getResultName(){
        return  this.resultName;
    };
    public  void  setResultName(String resultName){
        this.resultName=resultName;
    }

    public  String  getManyChoose(){
        return  this.manyChoose;
    };
    public  void  setManyChoose(String manyChoose){
        this.manyChoose=manyChoose;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<TallyResultChoose> getTallyResultChooseList() {
        return tallyResultChooseList;
    }

    public void setTallyResultChooseList(List<TallyResultChoose> tallyResultChooseList) {
        this.tallyResultChooseList = tallyResultChooseList;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getResultChoose() {
        return resultChoose;
    }

    public void setResultChoose(String resultChoose) {
        this.resultChoose = resultChoose;
    }
}
