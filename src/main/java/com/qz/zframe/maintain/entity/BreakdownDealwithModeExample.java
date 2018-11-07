package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class BreakdownDealwithModeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BreakdownDealwithModeExample() {
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

        public Criteria andModeIdIsNull() {
            addCriterion("mode_id is null");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNotNull() {
            addCriterion("mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andModeIdEqualTo(String value) {
            addCriterion("mode_id =", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotEqualTo(String value) {
            addCriterion("mode_id <>", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThan(String value) {
            addCriterion("mode_id >", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThanOrEqualTo(String value) {
            addCriterion("mode_id >=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThan(String value) {
            addCriterion("mode_id <", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThanOrEqualTo(String value) {
            addCriterion("mode_id <=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLike(String value) {
            addCriterion("mode_id like", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotLike(String value) {
            addCriterion("mode_id not like", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdIn(List<String> values) {
            addCriterion("mode_id in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotIn(List<String> values) {
            addCriterion("mode_id not in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdBetween(String value1, String value2) {
            addCriterion("mode_id between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotBetween(String value1, String value2) {
            addCriterion("mode_id not between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeNameIsNull() {
            addCriterion("mode_name is null");
            return (Criteria) this;
        }

        public Criteria andModeNameIsNotNull() {
            addCriterion("mode_name is not null");
            return (Criteria) this;
        }

        public Criteria andModeNameEqualTo(String value) {
            addCriterion("mode_name =", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotEqualTo(String value) {
            addCriterion("mode_name <>", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameGreaterThan(String value) {
            addCriterion("mode_name >", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("mode_name >=", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLessThan(String value) {
            addCriterion("mode_name <", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLessThanOrEqualTo(String value) {
            addCriterion("mode_name <=", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameLike(String value) {
            addCriterion("mode_name like", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotLike(String value) {
            addCriterion("mode_name not like", value, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameIn(List<String> values) {
            addCriterion("mode_name in", values, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotIn(List<String> values) {
            addCriterion("mode_name not in", values, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameBetween(String value1, String value2) {
            addCriterion("mode_name between", value1, value2, "modeName");
            return (Criteria) this;
        }

        public Criteria andModeNameNotBetween(String value1, String value2) {
            addCriterion("mode_name not between", value1, value2, "modeName");
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