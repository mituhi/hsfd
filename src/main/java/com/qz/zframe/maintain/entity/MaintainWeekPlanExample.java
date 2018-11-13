package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MaintainWeekPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaintainWeekPlanExample() {
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andMaintainerIsNull() {
            addCriterion("maintainer is null");
            return (Criteria) this;
        }

        public Criteria andMaintainerIsNotNull() {
            addCriterion("maintainer is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainerEqualTo(String value) {
            addCriterion("maintainer =", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotEqualTo(String value) {
            addCriterion("maintainer <>", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerGreaterThan(String value) {
            addCriterion("maintainer >", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerGreaterThanOrEqualTo(String value) {
            addCriterion("maintainer >=", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLessThan(String value) {
            addCriterion("maintainer <", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLessThanOrEqualTo(String value) {
            addCriterion("maintainer <=", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLike(String value) {
            addCriterion("maintainer like", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotLike(String value) {
            addCriterion("maintainer not like", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerIn(List<String> values) {
            addCriterion("maintainer in", values, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotIn(List<String> values) {
            addCriterion("maintainer not in", values, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerBetween(String value1, String value2) {
            addCriterion("maintainer between", value1, value2, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotBetween(String value1, String value2) {
            addCriterion("maintainer not between", value1, value2, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIsNull() {
            addCriterion("maintain_time is null");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIsNotNull() {
            addCriterion("maintain_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeEqualTo(Date value) {
            addCriterion("maintain_time =", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotEqualTo(Date value) {
            addCriterion("maintain_time <>", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeGreaterThan(Date value) {
            addCriterion("maintain_time >", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("maintain_time >=", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeLessThan(Date value) {
            addCriterion("maintain_time <", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeLessThanOrEqualTo(Date value) {
            addCriterion("maintain_time <=", value, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeIn(List<Date> values) {
            addCriterion("maintain_time in", values, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotIn(List<Date> values) {
            addCriterion("maintain_time not in", values, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeBetween(Date value1, Date value2) {
            addCriterion("maintain_time between", value1, value2, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andMaintainTimeNotBetween(Date value1, Date value2) {
            addCriterion("maintain_time not between", value1, value2, "maintainTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearIsNull() {
            addCriterion("week_of_year is null");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearIsNotNull() {
            addCriterion("week_of_year is not null");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearEqualTo(String value) {
            addCriterion("week_of_year =", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearNotEqualTo(String value) {
            addCriterion("week_of_year <>", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearGreaterThan(String value) {
            addCriterion("week_of_year >", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearGreaterThanOrEqualTo(String value) {
            addCriterion("week_of_year >=", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearLessThan(String value) {
            addCriterion("week_of_year <", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearLessThanOrEqualTo(String value) {
            addCriterion("week_of_year <=", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearLike(String value) {
            addCriterion("week_of_year like", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearNotLike(String value) {
            addCriterion("week_of_year not like", value, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearIn(List<String> values) {
            addCriterion("week_of_year in", values, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearNotIn(List<String> values) {
            addCriterion("week_of_year not in", values, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearBetween(String value1, String value2) {
            addCriterion("week_of_year between", value1, value2, "weekOfYear");
            return (Criteria) this;
        }

        public Criteria andWeekOfYearNotBetween(String value1, String value2) {
            addCriterion("week_of_year not between", value1, value2, "weekOfYear");
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

        public Criteria andRecordPersonIsNull() {
            addCriterion("record_person is null");
            return (Criteria) this;
        }

        public Criteria andRecordPersonIsNotNull() {
            addCriterion("record_person is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPersonEqualTo(String value) {
            addCriterion("record_person =", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotEqualTo(String value) {
            addCriterion("record_person <>", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonGreaterThan(String value) {
            addCriterion("record_person >", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonGreaterThanOrEqualTo(String value) {
            addCriterion("record_person >=", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLessThan(String value) {
            addCriterion("record_person <", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLessThanOrEqualTo(String value) {
            addCriterion("record_person <=", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLike(String value) {
            addCriterion("record_person like", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotLike(String value) {
            addCriterion("record_person not like", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonIn(List<String> values) {
            addCriterion("record_person in", values, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotIn(List<String> values) {
            addCriterion("record_person not in", values, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonBetween(String value1, String value2) {
            addCriterion("record_person between", value1, value2, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotBetween(String value1, String value2) {
            addCriterion("record_person not between", value1, value2, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonIsNull() {
            addCriterion("on_duty_person is null");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonIsNotNull() {
            addCriterion("on_duty_person is not null");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonEqualTo(String value) {
            addCriterion("on_duty_person =", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonNotEqualTo(String value) {
            addCriterion("on_duty_person <>", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonGreaterThan(String value) {
            addCriterion("on_duty_person >", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("on_duty_person >=", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonLessThan(String value) {
            addCriterion("on_duty_person <", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonLessThanOrEqualTo(String value) {
            addCriterion("on_duty_person <=", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonLike(String value) {
            addCriterion("on_duty_person like", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonNotLike(String value) {
            addCriterion("on_duty_person not like", value, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonIn(List<String> values) {
            addCriterion("on_duty_person in", values, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonNotIn(List<String> values) {
            addCriterion("on_duty_person not in", values, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonBetween(String value1, String value2) {
            addCriterion("on_duty_person between", value1, value2, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andOnDutyPersonNotBetween(String value1, String value2) {
            addCriterion("on_duty_person not between", value1, value2, "onDutyPerson");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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