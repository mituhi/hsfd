package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketTypeSafeMeasureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketTypeSafeMeasureExample() {
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

        public Criteria andTicketTypeIdIsNull() {
            addCriterion("ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdIsNotNull() {
            addCriterion("ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdEqualTo(String value) {
            addCriterion("ticket_type_id =", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotEqualTo(String value) {
            addCriterion("ticket_type_id <>", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdGreaterThan(String value) {
            addCriterion("ticket_type_id >", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_type_id >=", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLessThan(String value) {
            addCriterion("ticket_type_id <", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_type_id <=", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLike(String value) {
            addCriterion("ticket_type_id like", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotLike(String value) {
            addCriterion("ticket_type_id not like", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdIn(List<String> values) {
            addCriterion("ticket_type_id in", values, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotIn(List<String> values) {
            addCriterion("ticket_type_id not in", values, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdBetween(String value1, String value2) {
            addCriterion("ticket_type_id between", value1, value2, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("ticket_type_id not between", value1, value2, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeIsNull() {
            addCriterion("measure_type is null");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeIsNotNull() {
            addCriterion("measure_type is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeEqualTo(String value) {
            addCriterion("measure_type =", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeNotEqualTo(String value) {
            addCriterion("measure_type <>", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeGreaterThan(String value) {
            addCriterion("measure_type >", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeGreaterThanOrEqualTo(String value) {
            addCriterion("measure_type >=", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeLessThan(String value) {
            addCriterion("measure_type <", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeLessThanOrEqualTo(String value) {
            addCriterion("measure_type <=", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeLike(String value) {
            addCriterion("measure_type like", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeNotLike(String value) {
            addCriterion("measure_type not like", value, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeIn(List<String> values) {
            addCriterion("measure_type in", values, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeNotIn(List<String> values) {
            addCriterion("measure_type not in", values, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeBetween(String value1, String value2) {
            addCriterion("measure_type between", value1, value2, "measureType");
            return (Criteria) this;
        }

        public Criteria andMeasureTypeNotBetween(String value1, String value2) {
            addCriterion("measure_type not between", value1, value2, "measureType");
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