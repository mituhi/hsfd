package com.qz.zframe.tally.entity;
/*
点检标准表
 */
public class TallyStandard {
    //标准id
    private String standardId;
    //路线id
    private String routeId;
    //设备id
    private String equipmentId;
    //标准编码
    private String standardCoding;
    //所属设备
    private String equipmentBelonging;
    //所在部位
    private String location;
    //点检内容
    private String checkContent;
    //标准类型
    private String standardType;
    //数据类型
    private String dataType;
    //信号类型
    private String signalType;
    //点检方法
    private String checkMethod;
    //判断标准
    private String standardJudgment;
    //结果选项
    private String resultOptions;
    //计量单位
    private String measurementUnit;
    //典型值
    private String typicalValue;
    //设备状态
    private String equipmentState;
    //二维码位置
    private String twodimensionalcodeLocation;
    //启停点
    private String startandstopPoint;
    //主控点
    private String maincontrolPoint;
    //报警类型
    private String alarmType;
    //报警上限
    private String alarmCeiling;
    //报警下限
    private String alarmLowerlimit;
    //发射率
    private String emissivity;
    //里程上限
    private String upperlimitMileage;
    //里程下限
    private String lowerlimitMileage;
    //真假删除
    private String trueId;

    public String getTrueId() {
        return trueId;
    }

    public void setTrueId(String trueId) {
        this.trueId = trueId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getStandardCoding() {
        return standardCoding;
    }

    public void setStandardCoding(String standardCoding) {
        this.standardCoding = standardCoding;
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

    public String getEquipmentBelonging() {
        return equipmentBelonging;
    }

    public void setEquipmentBelonging(String equipmentBelonging) {
        this.equipmentBelonging = equipmentBelonging;
    }

    public TallyStandard() {
    }

    public TallyStandard(String standardId, String routeId, String equipmentId, String standardCoding, String equipmentBelonging, String location, String checkContent, String standardType, String dataType, String signalType, String checkMethod, String standardJudgment, String resultOptions, String measurementUnit, String typicalValue, String equipmentState, String twodimensionalcodeLocation, String startandstopPoint, String maincontrolPoint, String alarmType, String alarmCeiling, String alarmLowerlimit, String emissivity, String upperlimitMileage, String lowerlimitMileage) {
        this.standardId = standardId;
        this.routeId = routeId;
        this.equipmentId = equipmentId;
        this.standardCoding = standardCoding;
        this.equipmentBelonging = equipmentBelonging;
        this.location = location;
        this.checkContent = checkContent;
        this.standardType = standardType;
        this.dataType = dataType;
        this.signalType = signalType;
        this.checkMethod = checkMethod;
        this.standardJudgment = standardJudgment;
        this.resultOptions = resultOptions;
        this.measurementUnit = measurementUnit;
        this.typicalValue = typicalValue;
        this.equipmentState = equipmentState;
        this.twodimensionalcodeLocation = twodimensionalcodeLocation;
        this.startandstopPoint = startandstopPoint;
        this.maincontrolPoint = maincontrolPoint;
        this.alarmType = alarmType;
        this.alarmCeiling = alarmCeiling;
        this.alarmLowerlimit = alarmLowerlimit;
        this.emissivity = emissivity;
        this.upperlimitMileage = upperlimitMileage;
        this.lowerlimitMileage = lowerlimitMileage;
    }

    @Override
    public String toString() {
        return "TallyStandard{" +
                "standardId='" + standardId + '\'' +
                ", routeId='" + routeId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", standardCoding='" + standardCoding + '\'' +
                ", equipmentBelonging='" + equipmentBelonging + '\'' +
                ", location='" + location + '\'' +
                ", checkContent='" + checkContent + '\'' +
                ", standardType='" + standardType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", signalType='" + signalType + '\'' +
                ", checkMethod='" + checkMethod + '\'' +
                ", standardJudgment='" + standardJudgment + '\'' +
                ", resultOptions='" + resultOptions + '\'' +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", typicalValue='" + typicalValue + '\'' +
                ", equipmentState='" + equipmentState + '\'' +
                ", twodimensionalcodeLocation='" + twodimensionalcodeLocation + '\'' +
                ", startandstopPoint='" + startandstopPoint + '\'' +
                ", maincontrolPoint='" + maincontrolPoint + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmCeiling='" + alarmCeiling + '\'' +
                ", alarmLowerlimit='" + alarmLowerlimit + '\'' +
                ", emissivity='" + emissivity + '\'' +
                ", upperlimitMileage='" + upperlimitMileage + '\'' +
                ", lowerlimitMileage='" + lowerlimitMileage + '\'' +
                '}';
    }
}
