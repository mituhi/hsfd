package com.qz.zframe.tally.vo;

import io.swagger.annotations.ApiModelProperty;

public class TallyStandardPostVO {

    //路线名称
    @ApiModelProperty(value="路线名称",name="routeName",required=false)
    private String routeName;
    //标准编码
    @ApiModelProperty(value="标准编码",name="standardCoding",required=false)
    private String standardCoding;
    //所属设备
    @ApiModelProperty(value="所属设备",name="equipmentBelonging",required=false)
    private String equipmentBelonging;
    //所在部位
    @ApiModelProperty(value="所在部位",name="location",required=false)
    private String location;
    //点检内容
    @ApiModelProperty(value="点检内容",name="checkContent",required=false)
    private String checkContent;
    //标准类型
    @ApiModelProperty(value="标准类型",name="standardType",required=false)
    private String standardType;
    //数据类型
    @ApiModelProperty(value="数据类型",name="dataType",required=false)
    private String dataType;
    //信号类型
    @ApiModelProperty(value="信号类型",name="signalType",required=false)
    private String signalType;
    //点检方法
    @ApiModelProperty(value="点检方法",name="checkMethod",required=false)
    private String checkMethod;
    //判断标准
    @ApiModelProperty(value="判断标准",name="standardJudgment",required=false)
    private String standardJudgment;
    //结果选项
    @ApiModelProperty(value="结果选项",name="resultOptions",required=false)
    private String resultOptions;
    //计量单位
    @ApiModelProperty(value="计量单位",name="measurementUnit",required=false)
    private String measurementUnit;
    //典型值
    @ApiModelProperty(value="典型值",name="typicalValue",required=false)
    private String typicalValue;
    //设备状态
    @ApiModelProperty(value="设备状态",name="equipmentState",required=false)
    private String equipmentState;
    //二维码位置
    @ApiModelProperty(value="二维码位置",name="twodimensionalcodeLocation",required=false)
    private String twodimensionalcodeLocation;
    //启停点
    @ApiModelProperty(value="启停点",name="startandstopPoint",required=false)
    private String startandstopPoint;
    //主控点
    @ApiModelProperty(value="主控点",name="maincontrolPoint",required=false)
    private String maincontrolPoint;
    //报警类型
    @ApiModelProperty(value="报警类型",name="alarmType",required=false)
    private String alarmType;
    //报警上限
    @ApiModelProperty(value="报警上限",name="alarmCeiling",required=false)
    private String alarmCeiling;
    //报警下限
    @ApiModelProperty(value="报警下限",name="alarmLowerlimit",required=false)
    private String alarmLowerlimit;
    //发射率
    @ApiModelProperty(value="发射率",name="emissivity",required=false)
    private String emissivity;
    //里程上限
    @ApiModelProperty(value="里程上限",name="upperlimitMileage",required=false)
    private String upperlimitMileage;
    //里程下限
    @ApiModelProperty(value="里程下限",name="lowerlimitMileage",required=false)
    private String lowerlimitMileage;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStandardCoding() {
        return standardCoding;
    }

    public void setStandardCoding(String standardCoding) {
        this.standardCoding = standardCoding;
    }

    public String getEquipmentBelonging() {
        return equipmentBelonging;
    }

    public void setEquipmentBelonging(String equipmentBelonging) {
        this.equipmentBelonging = equipmentBelonging;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public String getStandardJudgment() {
        return standardJudgment;
    }

    public void setStandardJudgment(String standardJudgment) {
        this.standardJudgment = standardJudgment;
    }

    public String getResultOptions() {
        return resultOptions;
    }

    public void setResultOptions(String resultOptions) {
        this.resultOptions = resultOptions;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getTypicalValue() {
        return typicalValue;
    }

    public void setTypicalValue(String typicalValue) {
        this.typicalValue = typicalValue;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public String getTwodimensionalcodeLocation() {
        return twodimensionalcodeLocation;
    }

    public void setTwodimensionalcodeLocation(String twodimensionalcodeLocation) {
        this.twodimensionalcodeLocation = twodimensionalcodeLocation;
    }

    public String getStartandstopPoint() {
        return startandstopPoint;
    }

    public void setStartandstopPoint(String startandstopPoint) {
        this.startandstopPoint = startandstopPoint;
    }

    public String getMaincontrolPoint() {
        return maincontrolPoint;
    }

    public void setMaincontrolPoint(String maincontrolPoint) {
        this.maincontrolPoint = maincontrolPoint;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmCeiling() {
        return alarmCeiling;
    }

    public void setAlarmCeiling(String alarmCeiling) {
        this.alarmCeiling = alarmCeiling;
    }

    public String getAlarmLowerlimit() {
        return alarmLowerlimit;
    }

    public void setAlarmLowerlimit(String alarmLowerlimit) {
        this.alarmLowerlimit = alarmLowerlimit;
    }

    public String getEmissivity() {
        return emissivity;
    }

    public void setEmissivity(String emissivity) {
        this.emissivity = emissivity;
    }

    public String getUpperlimitMileage() {
        return upperlimitMileage;
    }

    public void setUpperlimitMileage(String upperlimitMileage) {
        this.upperlimitMileage = upperlimitMileage;
    }

    public String getLowerlimitMileage() {
        return lowerlimitMileage;
    }

    public void setLowerlimitMileage(String lowerlimitMileage) {
        this.lowerlimitMileage = lowerlimitMileage;
    }
}
