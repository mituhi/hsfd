package com.qz.zframe.tally.vo;

import com.qz.zframe.tally.entity.TallyResultChoose;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TallyResultVO {

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

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getManyChoose() {
        return manyChoose;
    }

    public void setManyChoose(String manyChoose) {
        this.manyChoose = manyChoose;
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
}
