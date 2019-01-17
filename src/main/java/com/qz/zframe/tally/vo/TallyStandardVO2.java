package com.qz.zframe.tally.vo;

public class TallyStandardVO2 {

    //编号
    private String standardId;
    //设备名称
    private String equipmentBelonging;

    private String equipmentId;
    //点检内容
    private String checkContent;
    //判断标准
    private String standardJudgment;
    //风电场
    private String windId;

    private String windName;
    //二维码id
    private String twodimensionalcodeLocation;
    //位置
    private String position;
    //路线名称
    private String routeName;
    //周期名称
    private String cycleName;

    private String routeId;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
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

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getTwodimensionalcodeLocation() {
        return twodimensionalcodeLocation;
    }

    public void setTwodimensionalcodeLocation(String twodimensionalcodeLocation) {
        this.twodimensionalcodeLocation = twodimensionalcodeLocation;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }
}
