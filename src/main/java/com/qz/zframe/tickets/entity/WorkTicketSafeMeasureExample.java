package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkTicketSafeMeasureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketSafeMeasureExample() {
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

        public Criteria andSafeIdIsNull() {
            addCriterion("safe_id is null");
            return (Criteria) this;
        }

        public Criteria andSafeIdIsNotNull() {
            addCriterion("safe_id is not null");
            return (Criteria) this;
        }

        public Criteria andSafeIdEqualTo(String value) {
            addCriterion("safe_id =", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotEqualTo(String value) {
            addCriterion("safe_id <>", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdGreaterThan(String value) {
            addCriterion("safe_id >", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdGreaterThanOrEqualTo(String value) {
            addCriterion("safe_id >=", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdLessThan(String value) {
            addCriterion("safe_id <", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdLessThanOrEqualTo(String value) {
            addCriterion("safe_id <=", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdLike(String value) {
            addCriterion("safe_id like", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotLike(String value) {
            addCriterion("safe_id not like", value, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdIn(List<String> values) {
            addCriterion("safe_id in", values, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotIn(List<String> values) {
            addCriterion("safe_id not in", values, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdBetween(String value1, String value2) {
            addCriterion("safe_id between", value1, value2, "safeId");
            return (Criteria) this;
        }

        public Criteria andSafeIdNotBetween(String value1, String value2) {
            addCriterion("safe_id not between", value1, value2, "safeId");
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

        public Criteria andSafeNumberIsNull() {
            addCriterion("safe_number is null");
            return (Criteria) this;
        }

        public Criteria andSafeNumberIsNotNull() {
            addCriterion("safe_number is not null");
            return (Criteria) this;
        }

        public Criteria andSafeNumberEqualTo(String value) {
            addCriterion("safe_number =", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberNotEqualTo(String value) {
            addCriterion("safe_number <>", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberGreaterThan(String value) {
            addCriterion("safe_number >", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("safe_number >=", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberLessThan(String value) {
            addCriterion("safe_number <", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberLessThanOrEqualTo(String value) {
            addCriterion("safe_number <=", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberLike(String value) {
            addCriterion("safe_number like", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberNotLike(String value) {
            addCriterion("safe_number not like", value, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberIn(List<String> values) {
            addCriterion("safe_number in", values, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberNotIn(List<String> values) {
            addCriterion("safe_number not in", values, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberBetween(String value1, String value2) {
            addCriterion("safe_number between", value1, value2, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeNumberNotBetween(String value1, String value2) {
            addCriterion("safe_number not between", value1, value2, "safeNumber");
            return (Criteria) this;
        }

        public Criteria andSafeTitleIsNull() {
            addCriterion("safe_title is null");
            return (Criteria) this;
        }

        public Criteria andSafeTitleIsNotNull() {
            addCriterion("safe_title is not null");
            return (Criteria) this;
        }

        public Criteria andSafeTitleEqualTo(String value) {
            addCriterion("safe_title =", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleNotEqualTo(String value) {
            addCriterion("safe_title <>", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleGreaterThan(String value) {
            addCriterion("safe_title >", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("safe_title >=", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleLessThan(String value) {
            addCriterion("safe_title <", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleLessThanOrEqualTo(String value) {
            addCriterion("safe_title <=", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleLike(String value) {
            addCriterion("safe_title like", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleNotLike(String value) {
            addCriterion("safe_title not like", value, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleIn(List<String> values) {
            addCriterion("safe_title in", values, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleNotIn(List<String> values) {
            addCriterion("safe_title not in", values, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleBetween(String value1, String value2) {
            addCriterion("safe_title between", value1, value2, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeTitleNotBetween(String value1, String value2) {
            addCriterion("safe_title not between", value1, value2, "safeTitle");
            return (Criteria) this;
        }

        public Criteria andSafeContentIsNull() {
            addCriterion("safe_content is null");
            return (Criteria) this;
        }

        public Criteria andSafeContentIsNotNull() {
            addCriterion("safe_content is not null");
            return (Criteria) this;
        }

        public Criteria andSafeContentEqualTo(String value) {
            addCriterion("safe_content =", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotEqualTo(String value) {
            addCriterion("safe_content <>", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentGreaterThan(String value) {
            addCriterion("safe_content >", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentGreaterThanOrEqualTo(String value) {
            addCriterion("safe_content >=", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLessThan(String value) {
            addCriterion("safe_content <", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLessThanOrEqualTo(String value) {
            addCriterion("safe_content <=", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLike(String value) {
            addCriterion("safe_content like", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotLike(String value) {
            addCriterion("safe_content not like", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentIn(List<String> values) {
            addCriterion("safe_content in", values, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotIn(List<String> values) {
            addCriterion("safe_content not in", values, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentBetween(String value1, String value2) {
            addCriterion("safe_content between", value1, value2, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotBetween(String value1, String value2) {
            addCriterion("safe_content not between", value1, value2, "safeContent");
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