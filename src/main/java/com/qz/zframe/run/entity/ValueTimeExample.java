package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ValueTimeExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ValueTimeExample() {
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

        public Criteria andValueIdIsNull() {
            addCriterion("value_id is null");
            return (Criteria) this;
        }

        public Criteria andValueIdIsNotNull() {
            addCriterion("value_id is not null");
            return (Criteria) this;
        }

        public Criteria andValueIdEqualTo(String value) {
            addCriterion("value_id =", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdNotEqualTo(String value) {
            addCriterion("value_id <>", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdGreaterThan(String value) {
            addCriterion("value_id >", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("value_id >=", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdLessThan(String value) {
            addCriterion("value_id <", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdLessThanOrEqualTo(String value) {
            addCriterion("value_id <=", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdLike(String value) {
            addCriterion("value_id like", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdNotLike(String value) {
            addCriterion("value_id not like", value, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdIn(List<String> values) {
            addCriterion("value_id in", values, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdNotIn(List<String> values) {
            addCriterion("value_id not in", values, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdBetween(String value1, String value2) {
            addCriterion("value_id between", value1, value2, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueIdNotBetween(String value1, String value2) {
            addCriterion("value_id not between", value1, value2, "valueId");
            return (Criteria) this;
        }

        public Criteria andValueCodeIsNull() {
            addCriterion("value_code is null");
            return (Criteria) this;
        }

        public Criteria andValueCodeIsNotNull() {
            addCriterion("value_code is not null");
            return (Criteria) this;
        }

        public Criteria andValueCodeEqualTo(String value) {
            addCriterion("value_code =", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeNotEqualTo(String value) {
            addCriterion("value_code <>", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeGreaterThan(String value) {
            addCriterion("value_code >", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeGreaterThanOrEqualTo(String value) {
            addCriterion("value_code >=", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeLessThan(String value) {
            addCriterion("value_code <", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeLessThanOrEqualTo(String value) {
            addCriterion("value_code <=", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeLike(String value) {
            addCriterion("value_code like", "%"+value+"%", "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeNotLike(String value) {
            addCriterion("value_code not like", value, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeIn(List<String> values) {
            addCriterion("value_code in", values, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeNotIn(List<String> values) {
            addCriterion("value_code not in", values, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeBetween(String value1, String value2) {
            addCriterion("value_code between", value1, value2, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueCodeNotBetween(String value1, String value2) {
            addCriterion("value_code not between", value1, value2, "valueCode");
            return (Criteria) this;
        }

        public Criteria andValueNameIsNull() {
            addCriterion("value_name is null");
            return (Criteria) this;
        }

        public Criteria andValueNameIsNotNull() {
            addCriterion("value_name is not null");
            return (Criteria) this;
        }

        public Criteria andValueNameEqualTo(String value) {
            addCriterion("value_name =", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameNotEqualTo(String value) {
            addCriterion("value_name <>", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameGreaterThan(String value) {
            addCriterion("value_name >", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameGreaterThanOrEqualTo(String value) {
            addCriterion("value_name >=", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameLessThan(String value) {
            addCriterion("value_name <", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameLessThanOrEqualTo(String value) {
            addCriterion("value_name <=", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameLike(String value) {
            addCriterion("value_name like", "%"+value+"%", "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameNotLike(String value) {
            addCriterion("value_name not like", value, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameIn(List<String> values) {
            addCriterion("value_name in", values, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameNotIn(List<String> values) {
            addCriterion("value_name not in", values, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameBetween(String value1, String value2) {
            addCriterion("value_name between", value1, value2, "valueName");
            return (Criteria) this;
        }

        public Criteria andValueNameNotBetween(String value1, String value2) {
            addCriterion("value_name not between", value1, value2, "valueName");
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
            addCriterion("status like", "%"+value+"%", "status");
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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