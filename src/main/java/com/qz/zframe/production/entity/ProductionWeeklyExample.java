package com.qz.zframe.production.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ProductionWeeklyExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductionWeeklyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andWeekIdIsNull() {
            addCriterion("week_id is null");
            return (Criteria) this;
        }

        public Criteria andWeekIdIsNotNull() {
            addCriterion("week_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeekIdEqualTo(String value) {
            addCriterion("week_id =", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotEqualTo(String value) {
            addCriterion("week_id <>", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThan(String value) {
            addCriterion("week_id >", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThanOrEqualTo(String value) {
            addCriterion("week_id >=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThan(String value) {
            addCriterion("week_id <", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThanOrEqualTo(String value) {
            addCriterion("week_id <=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLike(String value) {
            addCriterion("week_id like", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotLike(String value) {
            addCriterion("week_id not like", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdIn(List<String> values) {
            addCriterion("week_id in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotIn(List<String> values) {
            addCriterion("week_id not in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdBetween(String value1, String value2) {
            addCriterion("week_id between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotBetween(String value1, String value2) {
            addCriterion("week_id not between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekStartIsNull() {
            addCriterion("week_start is null");
            return (Criteria) this;
        }

        public Criteria andWeekStartIsNotNull() {
            addCriterion("week_start is not null");
            return (Criteria) this;
        }

        public Criteria andWeekStartEqualTo(Date value) {
            addCriterionForJDBCDate("week_start =", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("week_start <>", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartGreaterThan(Date value) {
            addCriterionForJDBCDate("week_start >", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("week_start >=", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartLessThan(Date value) {
            addCriterionForJDBCDate("week_start <", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("week_start <=", value, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartIn(List<Date> values) {
            addCriterionForJDBCDate("week_start in", values, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("week_start not in", values, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("week_start between", value1, value2, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("week_start not between", value1, value2, "weekStart");
            return (Criteria) this;
        }

        public Criteria andWeekEndIsNull() {
            addCriterion("week_end is null");
            return (Criteria) this;
        }

        public Criteria andWeekEndIsNotNull() {
            addCriterion("week_end is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEndEqualTo(Date value) {
            addCriterionForJDBCDate("week_end =", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("week_end <>", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndGreaterThan(Date value) {
            addCriterionForJDBCDate("week_end >", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("week_end >=", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndLessThan(Date value) {
            addCriterionForJDBCDate("week_end <", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("week_end <=", value, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndIn(List<Date> values) {
            addCriterionForJDBCDate("week_end in", values, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("week_end not in", values, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("week_end between", value1, value2, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andWeekEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("week_end not between", value1, value2, "weekEnd");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionIsNull() {
            addCriterion("full_consumption is null");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionIsNotNull() {
            addCriterion("full_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionEqualTo(String value) {
            addCriterion("full_consumption =", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionNotEqualTo(String value) {
            addCriterion("full_consumption <>", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionGreaterThan(String value) {
            addCriterion("full_consumption >", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("full_consumption >=", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionLessThan(String value) {
            addCriterion("full_consumption <", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionLessThanOrEqualTo(String value) {
            addCriterion("full_consumption <=", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionLike(String value) {
            addCriterion("full_consumption like", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionNotLike(String value) {
            addCriterion("full_consumption not like", value, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionIn(List<String> values) {
            addCriterion("full_consumption in", values, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionNotIn(List<String> values) {
            addCriterion("full_consumption not in", values, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionBetween(String value1, String value2) {
            addCriterion("full_consumption between", value1, value2, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andFullConsumptionNotBetween(String value1, String value2) {
            addCriterion("full_consumption not between", value1, value2, "fullConsumption");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsIsNull() {
            addCriterion("number_shutdowns is null");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsIsNotNull() {
            addCriterion("number_shutdowns is not null");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsEqualTo(String value) {
            addCriterion("number_shutdowns =", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsNotEqualTo(String value) {
            addCriterion("number_shutdowns <>", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsGreaterThan(String value) {
            addCriterion("number_shutdowns >", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsGreaterThanOrEqualTo(String value) {
            addCriterion("number_shutdowns >=", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsLessThan(String value) {
            addCriterion("number_shutdowns <", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsLessThanOrEqualTo(String value) {
            addCriterion("number_shutdowns <=", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsLike(String value) {
            addCriterion("number_shutdowns like", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsNotLike(String value) {
            addCriterion("number_shutdowns not like", value, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsIn(List<String> values) {
            addCriterion("number_shutdowns in", values, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsNotIn(List<String> values) {
            addCriterion("number_shutdowns not in", values, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsBetween(String value1, String value2) {
            addCriterion("number_shutdowns between", value1, value2, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andNumberShutdownsNotBetween(String value1, String value2) {
            addCriterion("number_shutdowns not between", value1, value2, "numberShutdowns");
            return (Criteria) this;
        }

        public Criteria andWindSpeedIsNull() {
            addCriterion("wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedIsNotNull() {
            addCriterion("wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andWindSpeedEqualTo(String value) {
            addCriterion("wind_speed =", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedNotEqualTo(String value) {
            addCriterion("wind_speed <>", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedGreaterThan(String value) {
            addCriterion("wind_speed >", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("wind_speed >=", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedLessThan(String value) {
            addCriterion("wind_speed <", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedLessThanOrEqualTo(String value) {
            addCriterion("wind_speed <=", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedLike(String value) {
            addCriterion("wind_speed like", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedNotLike(String value) {
            addCriterion("wind_speed not like", value, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedIn(List<String> values) {
            addCriterion("wind_speed in", values, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedNotIn(List<String> values) {
            addCriterion("wind_speed not in", values, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedBetween(String value1, String value2) {
            addCriterion("wind_speed between", value1, value2, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andWindSpeedNotBetween(String value1, String value2) {
            addCriterion("wind_speed not between", value1, value2, "windSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedIsNull() {
            addCriterion("average_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedIsNotNull() {
            addCriterion("average_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedEqualTo(String value) {
            addCriterion("average_wind_speed =", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedNotEqualTo(String value) {
            addCriterion("average_wind_speed <>", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedGreaterThan(String value) {
            addCriterion("average_wind_speed >", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("average_wind_speed >=", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedLessThan(String value) {
            addCriterion("average_wind_speed <", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedLessThanOrEqualTo(String value) {
            addCriterion("average_wind_speed <=", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedLike(String value) {
            addCriterion("average_wind_speed like", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedNotLike(String value) {
            addCriterion("average_wind_speed not like", value, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedIn(List<String> values) {
            addCriterion("average_wind_speed in", values, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedNotIn(List<String> values) {
            addCriterion("average_wind_speed not in", values, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedBetween(String value1, String value2) {
            addCriterion("average_wind_speed between", value1, value2, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageWindSpeedNotBetween(String value1, String value2) {
            addCriterion("average_wind_speed not between", value1, value2, "averageWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIsNull() {
            addCriterion("maximum_wind_speed is null");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIsNotNull() {
            addCriterion("maximum_wind_speed is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedEqualTo(String value) {
            addCriterion("maximum_wind_speed =", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotEqualTo(String value) {
            addCriterion("maximum_wind_speed <>", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedGreaterThan(String value) {
            addCriterion("maximum_wind_speed >", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_wind_speed >=", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedLessThan(String value) {
            addCriterion("maximum_wind_speed <", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedLessThanOrEqualTo(String value) {
            addCriterion("maximum_wind_speed <=", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedLike(String value) {
            addCriterion("maximum_wind_speed like", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotLike(String value) {
            addCriterion("maximum_wind_speed not like", value, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedIn(List<String> values) {
            addCriterion("maximum_wind_speed in", values, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotIn(List<String> values) {
            addCriterion("maximum_wind_speed not in", values, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedBetween(String value1, String value2) {
            addCriterion("maximum_wind_speed between", value1, value2, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andMaximumWindSpeedNotBetween(String value1, String value2) {
            addCriterion("maximum_wind_speed not between", value1, value2, "maximumWindSpeed");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursIsNull() {
            addCriterion("\" average_available_hours\" is null");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursIsNotNull() {
            addCriterion("\" average_available_hours\" is not null");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursEqualTo(String value) {
            addCriterion("\" average_available_hours\" =", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursNotEqualTo(String value) {
            addCriterion("\" average_available_hours\" <>", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursGreaterThan(String value) {
            addCriterion("\" average_available_hours\" >", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursGreaterThanOrEqualTo(String value) {
            addCriterion("\" average_available_hours\" >=", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursLessThan(String value) {
            addCriterion("\" average_available_hours\" <", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursLessThanOrEqualTo(String value) {
            addCriterion("\" average_available_hours\" <=", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursLike(String value) {
            addCriterion("\" average_available_hours\" like", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursNotLike(String value) {
            addCriterion("\" average_available_hours\" not like", value, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursIn(List<String> values) {
            addCriterion("\" average_available_hours\" in", values, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursNotIn(List<String> values) {
            addCriterion("\" average_available_hours\" not in", values, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursBetween(String value1, String value2) {
            addCriterion("\" average_available_hours\" between", value1, value2, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailableHoursNotBetween(String value1, String value2) {
            addCriterion("\" average_available_hours\" not between", value1, value2, "averageAvailableHours");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateIsNull() {
            addCriterion("average_availability_rate is null");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateIsNotNull() {
            addCriterion("average_availability_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateEqualTo(String value) {
            addCriterion("average_availability_rate =", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateNotEqualTo(String value) {
            addCriterion("average_availability_rate <>", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateGreaterThan(String value) {
            addCriterion("average_availability_rate >", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateGreaterThanOrEqualTo(String value) {
            addCriterion("average_availability_rate >=", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateLessThan(String value) {
            addCriterion("average_availability_rate <", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateLessThanOrEqualTo(String value) {
            addCriterion("average_availability_rate <=", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateLike(String value) {
            addCriterion("average_availability_rate like", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateNotLike(String value) {
            addCriterion("average_availability_rate not like", value, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateIn(List<String> values) {
            addCriterion("average_availability_rate in", values, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateNotIn(List<String> values) {
            addCriterion("average_availability_rate not in", values, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateBetween(String value1, String value2) {
            addCriterion("average_availability_rate between", value1, value2, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andAverageAvailabilityRateNotBetween(String value1, String value2) {
            addCriterion("average_availability_rate not between", value1, value2, "averageAvailabilityRate");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityIsNull() {
            addCriterion("purchased_electricity is null");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityIsNotNull() {
            addCriterion("purchased_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityEqualTo(String value) {
            addCriterion("purchased_electricity =", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityNotEqualTo(String value) {
            addCriterion("purchased_electricity <>", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityGreaterThan(String value) {
            addCriterion("purchased_electricity >", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("purchased_electricity >=", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityLessThan(String value) {
            addCriterion("purchased_electricity <", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityLessThanOrEqualTo(String value) {
            addCriterion("purchased_electricity <=", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityLike(String value) {
            addCriterion("purchased_electricity like", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityNotLike(String value) {
            addCriterion("purchased_electricity not like", value, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityIn(List<String> values) {
            addCriterion("purchased_electricity in", values, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityNotIn(List<String> values) {
            addCriterion("purchased_electricity not in", values, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityBetween(String value1, String value2) {
            addCriterion("purchased_electricity between", value1, value2, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andPurchasedElectricityNotBetween(String value1, String value2) {
            addCriterion("purchased_electricity not between", value1, value2, "purchasedElectricity");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerIsNull() {
            addCriterion("comprehensive_wind_power is null");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerIsNotNull() {
            addCriterion("comprehensive_wind_power is not null");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerEqualTo(String value) {
            addCriterion("comprehensive_wind_power =", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerNotEqualTo(String value) {
            addCriterion("comprehensive_wind_power <>", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerGreaterThan(String value) {
            addCriterion("comprehensive_wind_power >", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerGreaterThanOrEqualTo(String value) {
            addCriterion("comprehensive_wind_power >=", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerLessThan(String value) {
            addCriterion("comprehensive_wind_power <", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerLessThanOrEqualTo(String value) {
            addCriterion("comprehensive_wind_power <=", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerLike(String value) {
            addCriterion("comprehensive_wind_power like", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerNotLike(String value) {
            addCriterion("comprehensive_wind_power not like", value, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerIn(List<String> values) {
            addCriterion("comprehensive_wind_power in", values, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerNotIn(List<String> values) {
            addCriterion("comprehensive_wind_power not in", values, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerBetween(String value1, String value2) {
            addCriterion("comprehensive_wind_power between", value1, value2, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andComprehensiveWindPowerNotBetween(String value1, String value2) {
            addCriterion("comprehensive_wind_power not between", value1, value2, "comprehensiveWindPower");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationIsNull() {
            addCriterion("power_generation is null");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationIsNotNull() {
            addCriterion("power_generation is not null");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationEqualTo(String value) {
            addCriterion("power_generation =", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationNotEqualTo(String value) {
            addCriterion("power_generation <>", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationGreaterThan(String value) {
            addCriterion("power_generation >", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationGreaterThanOrEqualTo(String value) {
            addCriterion("power_generation >=", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationLessThan(String value) {
            addCriterion("power_generation <", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationLessThanOrEqualTo(String value) {
            addCriterion("power_generation <=", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationLike(String value) {
            addCriterion("power_generation like", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationNotLike(String value) {
            addCriterion("power_generation not like", value, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationIn(List<String> values) {
            addCriterion("power_generation in", values, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationNotIn(List<String> values) {
            addCriterion("power_generation not in", values, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationBetween(String value1, String value2) {
            addCriterion("power_generation between", value1, value2, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andPowerGenerationNotBetween(String value1, String value2) {
            addCriterion("power_generation not between", value1, value2, "powerGeneration");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityIsNull() {
            addCriterion("weekly_capacity is null");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityIsNotNull() {
            addCriterion("weekly_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityEqualTo(String value) {
            addCriterion("weekly_capacity =", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityNotEqualTo(String value) {
            addCriterion("weekly_capacity <>", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityGreaterThan(String value) {
            addCriterion("weekly_capacity >", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("weekly_capacity >=", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityLessThan(String value) {
            addCriterion("weekly_capacity <", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityLessThanOrEqualTo(String value) {
            addCriterion("weekly_capacity <=", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityLike(String value) {
            addCriterion("weekly_capacity like", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityNotLike(String value) {
            addCriterion("weekly_capacity not like", value, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityIn(List<String> values) {
            addCriterion("weekly_capacity in", values, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityNotIn(List<String> values) {
            addCriterion("weekly_capacity not in", values, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityBetween(String value1, String value2) {
            addCriterion("weekly_capacity between", value1, value2, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andWeeklyCapacityNotBetween(String value1, String value2) {
            addCriterion("weekly_capacity not between", value1, value2, "weeklyCapacity");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningIsNull() {
            addCriterion("\" generation_planning\" is null");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningIsNotNull() {
            addCriterion("\" generation_planning\" is not null");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningEqualTo(String value) {
            addCriterion("\" generation_planning\" =", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningNotEqualTo(String value) {
            addCriterion("\" generation_planning\" <>", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningGreaterThan(String value) {
            addCriterion("\" generation_planning\" >", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningGreaterThanOrEqualTo(String value) {
            addCriterion("\" generation_planning\" >=", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningLessThan(String value) {
            addCriterion("\" generation_planning\" <", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningLessThanOrEqualTo(String value) {
            addCriterion("\" generation_planning\" <=", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningLike(String value) {
            addCriterion("\" generation_planning\" like", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningNotLike(String value) {
            addCriterion("\" generation_planning\" not like", value, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningIn(List<String> values) {
            addCriterion("\" generation_planning\" in", values, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningNotIn(List<String> values) {
            addCriterion("\" generation_planning\" not in", values, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningBetween(String value1, String value2) {
            addCriterion("\" generation_planning\" between", value1, value2, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andGenerationPlanningNotBetween(String value1, String value2) {
            addCriterion("\" generation_planning\" not between", value1, value2, "generationPlanning");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanIsNull() {
            addCriterion("next_week_plan is null");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanIsNotNull() {
            addCriterion("next_week_plan is not null");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanEqualTo(String value) {
            addCriterion("next_week_plan =", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanNotEqualTo(String value) {
            addCriterion("next_week_plan <>", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanGreaterThan(String value) {
            addCriterion("next_week_plan >", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanGreaterThanOrEqualTo(String value) {
            addCriterion("next_week_plan >=", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanLessThan(String value) {
            addCriterion("next_week_plan <", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanLessThanOrEqualTo(String value) {
            addCriterion("next_week_plan <=", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanLike(String value) {
            addCriterion("next_week_plan like", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanNotLike(String value) {
            addCriterion("next_week_plan not like", value, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanIn(List<String> values) {
            addCriterion("next_week_plan in", values, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanNotIn(List<String> values) {
            addCriterion("next_week_plan not in", values, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanBetween(String value1, String value2) {
            addCriterion("next_week_plan between", value1, value2, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andNextWeekPlanNotBetween(String value1, String value2) {
            addCriterion("next_week_plan not between", value1, value2, "nextWeekPlan");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekIsNull() {
            addCriterion("estimated_wind_next_week is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekIsNotNull() {
            addCriterion("estimated_wind_next_week is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekEqualTo(String value) {
            addCriterion("estimated_wind_next_week =", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekNotEqualTo(String value) {
            addCriterion("estimated_wind_next_week <>", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekGreaterThan(String value) {
            addCriterion("estimated_wind_next_week >", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekGreaterThanOrEqualTo(String value) {
            addCriterion("estimated_wind_next_week >=", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekLessThan(String value) {
            addCriterion("estimated_wind_next_week <", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekLessThanOrEqualTo(String value) {
            addCriterion("estimated_wind_next_week <=", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekLike(String value) {
            addCriterion("estimated_wind_next_week like", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekNotLike(String value) {
            addCriterion("estimated_wind_next_week not like", value, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekIn(List<String> values) {
            addCriterion("estimated_wind_next_week in", values, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekNotIn(List<String> values) {
            addCriterion("estimated_wind_next_week not in", values, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekBetween(String value1, String value2) {
            addCriterion("estimated_wind_next_week between", value1, value2, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andEstimatedWindNextWeekNotBetween(String value1, String value2) {
            addCriterion("estimated_wind_next_week not between", value1, value2, "estimatedWindNextWeek");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateIsNull() {
            addCriterion("plan_completion_rate is null");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateIsNotNull() {
            addCriterion("plan_completion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateEqualTo(String value) {
            addCriterion("plan_completion_rate =", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateNotEqualTo(String value) {
            addCriterion("plan_completion_rate <>", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateGreaterThan(String value) {
            addCriterion("plan_completion_rate >", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateGreaterThanOrEqualTo(String value) {
            addCriterion("plan_completion_rate >=", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateLessThan(String value) {
            addCriterion("plan_completion_rate <", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateLessThanOrEqualTo(String value) {
            addCriterion("plan_completion_rate <=", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateLike(String value) {
            addCriterion("plan_completion_rate like", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateNotLike(String value) {
            addCriterion("plan_completion_rate not like", value, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateIn(List<String> values) {
            addCriterion("plan_completion_rate in", values, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateNotIn(List<String> values) {
            addCriterion("plan_completion_rate not in", values, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateBetween(String value1, String value2) {
            addCriterion("plan_completion_rate between", value1, value2, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andPlanCompletionRateNotBetween(String value1, String value2) {
            addCriterion("plan_completion_rate not between", value1, value2, "planCompletionRate");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerIsNull() {
            addCriterion("abandoned_wind_power is null");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerIsNotNull() {
            addCriterion("abandoned_wind_power is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerEqualTo(String value) {
            addCriterion("abandoned_wind_power =", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerNotEqualTo(String value) {
            addCriterion("abandoned_wind_power <>", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerGreaterThan(String value) {
            addCriterion("abandoned_wind_power >", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerGreaterThanOrEqualTo(String value) {
            addCriterion("abandoned_wind_power >=", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerLessThan(String value) {
            addCriterion("abandoned_wind_power <", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerLessThanOrEqualTo(String value) {
            addCriterion("abandoned_wind_power <=", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerLike(String value) {
            addCriterion("abandoned_wind_power like", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerNotLike(String value) {
            addCriterion("abandoned_wind_power not like", value, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerIn(List<String> values) {
            addCriterion("abandoned_wind_power in", values, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerNotIn(List<String> values) {
            addCriterion("abandoned_wind_power not in", values, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerBetween(String value1, String value2) {
            addCriterion("abandoned_wind_power between", value1, value2, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andAbandonedWindPowerNotBetween(String value1, String value2) {
            addCriterion("abandoned_wind_power not between", value1, value2, "abandonedWindPower");
            return (Criteria) this;
        }

        public Criteria andWindIdIsNull() {
            addCriterion("wind_id is null");
            return (Criteria) this;
        }

        public Criteria andWindIdIsNotNull() {
            addCriterion("wind_id is not null");
            return (Criteria) this;
        }

        public Criteria andWindIdEqualTo(String value) {
            addCriterion("wind_id =", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotEqualTo(String value) {
            addCriterion("wind_id <>", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThan(String value) {
            addCriterion("wind_id >", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThanOrEqualTo(String value) {
            addCriterion("wind_id >=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThan(String value) {
            addCriterion("wind_id <", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThanOrEqualTo(String value) {
            addCriterion("wind_id <=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLike(String value) {
            addCriterion("wind_id like", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotLike(String value) {
            addCriterion("wind_id not like", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdIn(List<String> values) {
            addCriterion("wind_id in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotIn(List<String> values) {
            addCriterion("wind_id not in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdBetween(String value1, String value2) {
            addCriterion("wind_id between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotBetween(String value1, String value2) {
            addCriterion("wind_id not between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}