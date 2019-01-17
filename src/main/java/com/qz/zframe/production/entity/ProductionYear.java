package com.qz.zframe.production.entity;

public class ProductionYear {
    private String yearId;

    private String windId;

    private String project;

    private String planFinish;

    private String actualFinish;

    private String lastYear;

    private String year;

    private String windCode;

    private String windName;

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId == null ? null : yearId.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getPlanFinish() {
        return planFinish;
    }

    public void setPlanFinish(String planFinish) {
        this.planFinish = planFinish == null ? null : planFinish.trim();
    }

    public String getActualFinish() {
        return actualFinish;
    }

    public void setActualFinish(String actualFinish) {
        this.actualFinish = actualFinish == null ? null : actualFinish.trim();
    }

    public String getLastYear() {
        return lastYear;
    }

    public void setLastYear(String lastYear) {
        this.lastYear = lastYear == null ? null : lastYear.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode == null ? null : windCode.trim();
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName == null ? null : windName.trim();
    }
}