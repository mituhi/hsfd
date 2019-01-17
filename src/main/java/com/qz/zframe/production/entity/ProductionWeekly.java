package com.qz.zframe.production.entity;

import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ProductionWeekly {
	@ApiModelProperty(name = "weekId", value = "周报表id", required = false)
	
    private String weekId;

    @ApiModelProperty(name = "weekStart", value = "周报表开始时间", required = false)
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date weekStart;
    
    @ApiModelProperty(name = "weekEnd", value = "周报表结束时间", required = false)
	
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date weekEnd;
    
    @ApiModelProperty(name = " cycle", value = "周期 ", required = false)
	
    private String   cycle ;
    
    @ApiModelProperty(name = "fullConsumption", value = "全场上网电量 ", required = false)
	
    private String  fullConsumption ;

    @ApiModelProperty(name = "numberShutdowns", value = "全场非正常停机次数", required = true)
    
    private String numberShutdowns ;

    @ApiModelProperty(name = "windSpeed", value = "scada平均风速", required = true)
   
    private String  windSpeed ;
    
    @ApiModelProperty(name = "averageWindSpeed", value = "测风塔平均风速", required = true)
   
    private String   averageWindSpeed ;
    
    @ApiModelProperty(name = "maximumWindSpeed", value = "全场最高风速", required = true)
   
    private String   maximumWindSpeed ;
    
    @ApiModelProperty(name = "averageAvailableHours", value = "平均可利用小时", required = true)
   
    private String  averageAvailableHours  ;
    
    @ApiModelProperty(name = "averageAvailabilityRate", value = "平均可利用率", required = true)
   
    private String   averageAvailabilityRate ;
    
    @ApiModelProperty(name = "purchasedElectricity", value = "外购电量", required = true)
   
    private String purchasedElectricity ;
    
	@ApiModelProperty(name = "comprehensiveWindPower", value = "风场综合用电", required = true)
  
	private String  comprehensiveWindPower ;
	
	@ApiModelProperty(name = "powerGeneration", value = "风机发电量", required = true)
    
	private String powerGeneration;
	
	@ApiModelProperty(name = "weeklyCapacity", value = "周累计发电量 ", required = true)
   
	private String   weeklyCapacity ;
	
    @ApiModelProperty(name = "dailyAverageTemperature", value = "发电计划完成率 ", required = true)
   
    private String   generationPlanning ;
    
    @ApiModelProperty(name = "nextWeekPlan", value = "下周计划上网电量", required = false)
	
    private String nextWeekPlan  ;
    
    @ApiModelProperty(name = "estimatedWindNextWeek", value = "下周预估风速", required = false)
	
    private String  estimatedWindNextWeek   ;
    
    @ApiModelProperty(name = "planCompletionRate", value = "对比计划完成率", required = false)
	
    private String  planCompletionRate   ;
    
    @ApiModelProperty(name = "abandonedWindPower", value = "弃风电量", required = false)
	
    private String   abandonedWindPower ;

	@ApiModelProperty(name = "windId", value = "风电场id", required = false)
	
    private String windId;
	
	@ApiModelProperty(name = "year", value = "年份", required = false)
	
    private String year;
	@ApiModelProperty(name = "windName", value = "风电场名称", required = false)
	@Transient
    private String windName;

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId == null ? null : weekId.trim();
    }

    public Date getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(Date weekStart) {
        this.weekStart = weekStart;
    }

    public Date getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(Date weekEnd) {
        this.weekEnd = weekEnd;
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

    public String getWeeklyCapacity() {
        return weeklyCapacity;
    }

    public void setWeeklyCapacity(String weeklyCapacity) {
        this.weeklyCapacity = weeklyCapacity == null ? null : weeklyCapacity.trim();
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
	@Transient
	public String getWindName() {
		return windName;
	}
	@Transient
	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

    
    
}