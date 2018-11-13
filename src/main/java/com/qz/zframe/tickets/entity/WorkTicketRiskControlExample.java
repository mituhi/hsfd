package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketRiskControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketRiskControlExample() {
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

        public Criteria andMeasureIdIsNull() {
            addCriterion("measure_id is null");
            return (Criteria) this;
        }

        public Criteria andMeasureIdIsNotNull() {
            addCriterion("measure_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureIdEqualTo(String value) {
            addCriterion("measure_id =", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdNotEqualTo(String value) {
            addCriterion("measure_id <>", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdGreaterThan(String value) {
            addCriterion("measure_id >", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdGreaterThanOrEqualTo(String value) {
            addCriterion("measure_id >=", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdLessThan(String value) {
            addCriterion("measure_id <", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdLessThanOrEqualTo(String value) {
            addCriterion("measure_id <=", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdLike(String value) {
            addCriterion("measure_id like", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdNotLike(String value) {
            addCriterion("measure_id not like", value, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdIn(List<String> values) {
            addCriterion("measure_id in", values, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdNotIn(List<String> values) {
            addCriterion("measure_id not in", values, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdBetween(String value1, String value2) {
            addCriterion("measure_id between", value1, value2, "measureId");
            return (Criteria) this;
        }

        public Criteria andMeasureIdNotBetween(String value1, String value2) {
            addCriterion("measure_id not between", value1, value2, "measureId");
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

        public Criteria andStandardTicketIdIsNull() {
            addCriterion("standard_ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdIsNotNull() {
            addCriterion("standard_ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdEqualTo(String value) {
            addCriterion("standard_ticket_id =", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotEqualTo(String value) {
            addCriterion("standard_ticket_id <>", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdGreaterThan(String value) {
            addCriterion("standard_ticket_id >", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("standard_ticket_id >=", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLessThan(String value) {
            addCriterion("standard_ticket_id <", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLessThanOrEqualTo(String value) {
            addCriterion("standard_ticket_id <=", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLike(String value) {
            addCriterion("standard_ticket_id like", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotLike(String value) {
            addCriterion("standard_ticket_id not like", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdIn(List<String> values) {
            addCriterion("standard_ticket_id in", values, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotIn(List<String> values) {
            addCriterion("standard_ticket_id not in", values, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdBetween(String value1, String value2) {
            addCriterion("standard_ticket_id between", value1, value2, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotBetween(String value1, String value2) {
            addCriterion("standard_ticket_id not between", value1, value2, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberIsNull() {
            addCriterion("measure_number is null");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberIsNotNull() {
            addCriterion("measure_number is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberEqualTo(String value) {
            addCriterion("measure_number =", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberNotEqualTo(String value) {
            addCriterion("measure_number <>", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberGreaterThan(String value) {
            addCriterion("measure_number >", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberGreaterThanOrEqualTo(String value) {
            addCriterion("measure_number >=", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberLessThan(String value) {
            addCriterion("measure_number <", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberLessThanOrEqualTo(String value) {
            addCriterion("measure_number <=", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberLike(String value) {
            addCriterion("measure_number like", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberNotLike(String value) {
            addCriterion("measure_number not like", value, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberIn(List<String> values) {
            addCriterion("measure_number in", values, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberNotIn(List<String> values) {
            addCriterion("measure_number not in", values, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberBetween(String value1, String value2) {
            addCriterion("measure_number between", value1, value2, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andMeasureNumberNotBetween(String value1, String value2) {
            addCriterion("measure_number not between", value1, value2, "measureNumber");
            return (Criteria) this;
        }

        public Criteria andDangerPointIsNull() {
            addCriterion("danger_point is null");
            return (Criteria) this;
        }

        public Criteria andDangerPointIsNotNull() {
            addCriterion("danger_point is not null");
            return (Criteria) this;
        }

        public Criteria andDangerPointEqualTo(String value) {
            addCriterion("danger_point =", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointNotEqualTo(String value) {
            addCriterion("danger_point <>", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointGreaterThan(String value) {
            addCriterion("danger_point >", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointGreaterThanOrEqualTo(String value) {
            addCriterion("danger_point >=", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointLessThan(String value) {
            addCriterion("danger_point <", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointLessThanOrEqualTo(String value) {
            addCriterion("danger_point <=", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointLike(String value) {
            addCriterion("danger_point like", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointNotLike(String value) {
            addCriterion("danger_point not like", value, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointIn(List<String> values) {
            addCriterion("danger_point in", values, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointNotIn(List<String> values) {
            addCriterion("danger_point not in", values, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointBetween(String value1, String value2) {
            addCriterion("danger_point between", value1, value2, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andDangerPointNotBetween(String value1, String value2) {
            addCriterion("danger_point not between", value1, value2, "dangerPoint");
            return (Criteria) this;
        }

        public Criteria andMeasureIsNull() {
            addCriterion("measure is null");
            return (Criteria) this;
        }

        public Criteria andMeasureIsNotNull() {
            addCriterion("measure is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureEqualTo(String value) {
            addCriterion("measure =", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotEqualTo(String value) {
            addCriterion("measure <>", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureGreaterThan(String value) {
            addCriterion("measure >", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("measure >=", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLessThan(String value) {
            addCriterion("measure <", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLessThanOrEqualTo(String value) {
            addCriterion("measure <=", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLike(String value) {
            addCriterion("measure like", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotLike(String value) {
            addCriterion("measure not like", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureIn(List<String> values) {
            addCriterion("measure in", values, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotIn(List<String> values) {
            addCriterion("measure not in", values, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureBetween(String value1, String value2) {
            addCriterion("measure between", value1, value2, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotBetween(String value1, String value2) {
            addCriterion("measure not between", value1, value2, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorIsNull() {
            addCriterion("measure_executor is null");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorIsNotNull() {
            addCriterion("measure_executor is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorEqualTo(String value) {
            addCriterion("measure_executor =", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorNotEqualTo(String value) {
            addCriterion("measure_executor <>", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorGreaterThan(String value) {
            addCriterion("measure_executor >", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorGreaterThanOrEqualTo(String value) {
            addCriterion("measure_executor >=", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorLessThan(String value) {
            addCriterion("measure_executor <", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorLessThanOrEqualTo(String value) {
            addCriterion("measure_executor <=", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorLike(String value) {
            addCriterion("measure_executor like", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorNotLike(String value) {
            addCriterion("measure_executor not like", value, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorIn(List<String> values) {
            addCriterion("measure_executor in", values, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorNotIn(List<String> values) {
            addCriterion("measure_executor not in", values, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorBetween(String value1, String value2) {
            addCriterion("measure_executor between", value1, value2, "measureExecutor");
            return (Criteria) this;
        }

        public Criteria andMeasureExecutorNotBetween(String value1, String value2) {
            addCriterion("measure_executor not between", value1, value2, "measureExecutor");
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