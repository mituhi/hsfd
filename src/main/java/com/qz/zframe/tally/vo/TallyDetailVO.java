package com.qz.zframe.tally.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TallyDetailVO {

    private String equipmentBelonging;

    private String practitionerName;

    private String architectureName;

    private String checkContent;

    private String standardJudgment;

    private String checkResult;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date finishTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date benchmarkDate;

    private String cycle;

    private String cycleUnit;

    public Date getBenchmarkDate() {
        return benchmarkDate;
    }

    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getEquipmentBelonging() {
        return equipmentBelonging;
    }

    public void setEquipmentBelonging(String equipmentBelonging) {
        this.equipmentBelonging = equipmentBelonging;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public String getArchitectureName() {
        return architectureName;
    }

    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
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

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

}
