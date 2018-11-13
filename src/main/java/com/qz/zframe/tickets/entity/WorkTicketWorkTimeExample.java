package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTicketWorkTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketWorkTimeExample() {
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

        public Criteria andWorkTimeIdIsNull() {
            addCriterion("work_time_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdIsNotNull() {
            addCriterion("work_time_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdEqualTo(String value) {
            addCriterion("work_time_id =", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdNotEqualTo(String value) {
            addCriterion("work_time_id <>", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdGreaterThan(String value) {
            addCriterion("work_time_id >", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_time_id >=", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdLessThan(String value) {
            addCriterion("work_time_id <", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdLessThanOrEqualTo(String value) {
            addCriterion("work_time_id <=", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdLike(String value) {
            addCriterion("work_time_id like", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdNotLike(String value) {
            addCriterion("work_time_id not like", value, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdIn(List<String> values) {
            addCriterion("work_time_id in", values, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdNotIn(List<String> values) {
            addCriterion("work_time_id not in", values, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdBetween(String value1, String value2) {
            addCriterion("work_time_id between", value1, value2, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIdNotBetween(String value1, String value2) {
            addCriterion("work_time_id not between", value1, value2, "workTimeId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(String value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(String value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(String value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(String value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLike(String value) {
            addCriterion("ticket_id like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotLike(String value) {
            addCriterion("ticket_id not like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<String> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<String> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(String value1, String value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(String value1, String value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberIsNull() {
            addCriterion("work_time_number is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberIsNotNull() {
            addCriterion("work_time_number is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberEqualTo(String value) {
            addCriterion("work_time_number =", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberNotEqualTo(String value) {
            addCriterion("work_time_number <>", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberGreaterThan(String value) {
            addCriterion("work_time_number >", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("work_time_number >=", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberLessThan(String value) {
            addCriterion("work_time_number <", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberLessThanOrEqualTo(String value) {
            addCriterion("work_time_number <=", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberLike(String value) {
            addCriterion("work_time_number like", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberNotLike(String value) {
            addCriterion("work_time_number not like", value, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberIn(List<String> values) {
            addCriterion("work_time_number in", values, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberNotIn(List<String> values) {
            addCriterion("work_time_number not in", values, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberBetween(String value1, String value2) {
            addCriterion("work_time_number between", value1, value2, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNumberNotBetween(String value1, String value2) {
            addCriterion("work_time_number not between", value1, value2, "workTimeNumber");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIsNull() {
            addCriterion("work_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIsNotNull() {
            addCriterion("work_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeEqualTo(Date value) {
            addCriterion("work_start_time =", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotEqualTo(Date value) {
            addCriterion("work_start_time <>", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThan(Date value) {
            addCriterion("work_start_time >", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("work_start_time >=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThan(Date value) {
            addCriterion("work_start_time <", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("work_start_time <=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIn(List<Date> values) {
            addCriterion("work_start_time in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotIn(List<Date> values) {
            addCriterion("work_start_time not in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeBetween(Date value1, Date value2) {
            addCriterion("work_start_time between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("work_start_time not between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadIsNull() {
            addCriterion("work_start_head is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadIsNotNull() {
            addCriterion("work_start_head is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadEqualTo(String value) {
            addCriterion("work_start_head =", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadNotEqualTo(String value) {
            addCriterion("work_start_head <>", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadGreaterThan(String value) {
            addCriterion("work_start_head >", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadGreaterThanOrEqualTo(String value) {
            addCriterion("work_start_head >=", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadLessThan(String value) {
            addCriterion("work_start_head <", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadLessThanOrEqualTo(String value) {
            addCriterion("work_start_head <=", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadLike(String value) {
            addCriterion("work_start_head like", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadNotLike(String value) {
            addCriterion("work_start_head not like", value, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadIn(List<String> values) {
            addCriterion("work_start_head in", values, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadNotIn(List<String> values) {
            addCriterion("work_start_head not in", values, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadBetween(String value1, String value2) {
            addCriterion("work_start_head between", value1, value2, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartHeadNotBetween(String value1, String value2) {
            addCriterion("work_start_head not between", value1, value2, "workStartHead");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorIsNull() {
            addCriterion("work_start_licensor is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorIsNotNull() {
            addCriterion("work_start_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorEqualTo(String value) {
            addCriterion("work_start_licensor =", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorNotEqualTo(String value) {
            addCriterion("work_start_licensor <>", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorGreaterThan(String value) {
            addCriterion("work_start_licensor >", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("work_start_licensor >=", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorLessThan(String value) {
            addCriterion("work_start_licensor <", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorLessThanOrEqualTo(String value) {
            addCriterion("work_start_licensor <=", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorLike(String value) {
            addCriterion("work_start_licensor like", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorNotLike(String value) {
            addCriterion("work_start_licensor not like", value, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorIn(List<String> values) {
            addCriterion("work_start_licensor in", values, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorNotIn(List<String> values) {
            addCriterion("work_start_licensor not in", values, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorBetween(String value1, String value2) {
            addCriterion("work_start_licensor between", value1, value2, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkStartLicensorNotBetween(String value1, String value2) {
            addCriterion("work_start_licensor not between", value1, value2, "workStartLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNull() {
            addCriterion("work_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNotNull() {
            addCriterion("work_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeEqualTo(Date value) {
            addCriterion("work_end_time =", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotEqualTo(Date value) {
            addCriterion("work_end_time <>", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThan(Date value) {
            addCriterion("work_end_time >", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("work_end_time >=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThan(Date value) {
            addCriterion("work_end_time <", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("work_end_time <=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIn(List<Date> values) {
            addCriterion("work_end_time in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotIn(List<Date> values) {
            addCriterion("work_end_time not in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeBetween(Date value1, Date value2) {
            addCriterion("work_end_time between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("work_end_time not between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIsNull() {
            addCriterion("work_end_head is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIsNotNull() {
            addCriterion("work_end_head is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadEqualTo(String value) {
            addCriterion("work_end_head =", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotEqualTo(String value) {
            addCriterion("work_end_head <>", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadGreaterThan(String value) {
            addCriterion("work_end_head >", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadGreaterThanOrEqualTo(String value) {
            addCriterion("work_end_head >=", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLessThan(String value) {
            addCriterion("work_end_head <", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLessThanOrEqualTo(String value) {
            addCriterion("work_end_head <=", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLike(String value) {
            addCriterion("work_end_head like", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotLike(String value) {
            addCriterion("work_end_head not like", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIn(List<String> values) {
            addCriterion("work_end_head in", values, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotIn(List<String> values) {
            addCriterion("work_end_head not in", values, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadBetween(String value1, String value2) {
            addCriterion("work_end_head between", value1, value2, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotBetween(String value1, String value2) {
            addCriterion("work_end_head not between", value1, value2, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIsNull() {
            addCriterion("work_end_licensor is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIsNotNull() {
            addCriterion("work_end_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorEqualTo(String value) {
            addCriterion("work_end_licensor =", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotEqualTo(String value) {
            addCriterion("work_end_licensor <>", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorGreaterThan(String value) {
            addCriterion("work_end_licensor >", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("work_end_licensor >=", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLessThan(String value) {
            addCriterion("work_end_licensor <", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLessThanOrEqualTo(String value) {
            addCriterion("work_end_licensor <=", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLike(String value) {
            addCriterion("work_end_licensor like", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotLike(String value) {
            addCriterion("work_end_licensor not like", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIn(List<String> values) {
            addCriterion("work_end_licensor in", values, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotIn(List<String> values) {
            addCriterion("work_end_licensor not in", values, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorBetween(String value1, String value2) {
            addCriterion("work_end_licensor between", value1, value2, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotBetween(String value1, String value2) {
            addCriterion("work_end_licensor not between", value1, value2, "workEndLicensor");
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