package com.qz.zframe.production.entity;

import java.util.Date;

public class ProductionMonth {
    private String monthId;

    private Date monthStart;

    private String fullConsumption;

    private String numberShutdowns;

    private String windSpeed;

    private String averageWindSpeed;

    private String maximumWindSpeed;

    private String averageAvailableHours;

    private String averageAvailabilityRate;

    private String purchasedElectricity;

    private String comprehensiveWindPower;

    private String powerGeneration;

    private String monthCapacity;

    private String generationPlanning;

    private String nextWeekPlan;

    private String estimatedWindNextWeek;

    private String planCompletionRate;

    private String abandonedWindPower;

    private String windId;

    private String year;

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId == null ? null : monthId.trim();
    }

    public Date getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(Date monthStart) {
        this.monthStart = monthStart;
    }

    public String getFullConsumption() {
        return fullConsumption;
    }

    public void setFullConsumption(String fullConsumption) {
        this.fullConsumption = fullConsumption == null ? null : fullConsumption.trim();
    }

    public String getNumberShutdowns() {
        return numberShutdowns;
    }

    public void setNumberShutdowns(String numberShutdowns) {
        this.numberShutdowns = numberShutdowns == null ? null : numberShutdowns.trim();
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed == null ? null : windSpeed.trim();
    }

    public String getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(String averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed == null ? null : averageWindSpeed.trim();
    }

    public String getMaximumWindSpeed() {
        return maximumWindSpeed;
    }

    public void setMaximumWindSpeed(String maximumWindSpeed) {
        this.maximumWindSpeed = maximumWindSpeed == null ? null : maximumWindSpeed.trim();
    }

    public String getAverageAvailableHours() {
        return averageAvailableHours;
    }

    public void setAverageAvailableHours(String averageAvailableHours) {
        this.averageAvailableHours = averageAvailableHours == null ? null : averageAvailableHours.trim();
    }

    public String getAverageAvailabilityRate() {
        return averageAvailabilityRate;
    }

    public void setAverageAvailabilityRate(String averageAvailabilityRate) {
        this.averageAvailabilityRate = averageAvailabilityRate == null ? null : averageAvailabilityRate.trim();
    }

    public String getPurchasedElectricity() {
        return purchasedElectricity;
    }

    public void setPurchasedElectricity(String purchasedElectricity) {
        this.purchasedElectricity = purchasedElectricity == null ? null : purchasedElectricity.trim();
    }

    public String getComprehensiveWindPower() {
        return comprehensiveWindPower;
    }

    public void setComprehensiveWindPower(String comprehensiveWindPower) {
        this.comprehensiveWindPower = comprehensiveWindPower == null ? null : comprehensiveWindPower.trim();
    }

    public String getPowerGeneration() {
        return powerGeneration;
    }

    public void setPowerGeneration(String powerGeneration) {
        this.powerGeneration = powerGeneration == null ? null : powerGeneration.trim();
    }

    public String getMonthCapacity() {
        return monthCapacity;
    }

    public void setMonthCapacity(String monthCapacity) {
        this.monthCapacity = monthCapacity == null ? null : monthCapacity.trim();
    }

    public String getGenerationPlanning() {
        return generationPlanning;
    }

    public void setGenerationPlanning(String generationPlanning) {
        this.generationPlanning = generationPlanning == null ? null : generationPlanning.trim();
    }

    public String getNextWeekPlan() {
        return nextWeekPlan;
    }

    public void setNextWeekPlan(String nextWeekPlan) {
        this.nextWeekPlan = nextWeekPlan == null ? null : nextWeekPlan.trim();
    }

    public String getEstimatedWindNextWeek() {
        return estimatedWindNextWeek;
    }

    public void setEstimatedWindNextWeek(String estimatedWindNextWeek) {
        this.estimatedWindNextWeek = estimatedWindNextWeek == null ? null : estimatedWindNextWeek.trim();
    }

    public String getPlanCompletionRate() {
        return planCompletionRate;
    }

    public void setPlanCompletionRate(String planCompletionRate) {
        this.planCompletionRate = planCompletionRate == null ? null : planCompletionRate.trim();
    }

    public String getAbandonedWindPower() {
        return abandonedWindPower;
    }

    public void setAbandonedWindPower(String abandonedWindPower) {
        this.abandonedWindPower = abandonedWindPower == null ? null : abandonedWindPower.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}