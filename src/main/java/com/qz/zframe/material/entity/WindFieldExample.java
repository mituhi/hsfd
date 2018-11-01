package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class WindFieldExample extends PageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WindFieldExample() {
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

        public Criteria andWindCodeIsNull() {
            addCriterion("wind_code is null");
            return (Criteria) this;
        }

        public Criteria andWindCodeIsNotNull() {
            addCriterion("wind_code is not null");
            return (Criteria) this;
        }

        public Criteria andWindCodeEqualTo(String value) {
            addCriterion("wind_code =", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotEqualTo(String value) {
            addCriterion("wind_code <>", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeGreaterThan(String value) {
            addCriterion("wind_code >", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wind_code >=", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLessThan(String value) {
            addCriterion("wind_code <", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLessThanOrEqualTo(String value) {
            addCriterion("wind_code <=", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLike(String value) {
            addCriterion("wind_code like", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotLike(String value) {
            addCriterion("wind_code not like", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeIn(List<String> values) {
            addCriterion("wind_code in", values, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotIn(List<String> values) {
            addCriterion("wind_code not in", values, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeBetween(String value1, String value2) {
            addCriterion("wind_code between", value1, value2, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotBetween(String value1, String value2) {
            addCriterion("wind_code not between", value1, value2, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindNameIsNull() {
            addCriterion("wind_name is null");
            return (Criteria) this;
        }

        public Criteria andWindNameIsNotNull() {
            addCriterion("wind_name is not null");
            return (Criteria) this;
        }

        public Criteria andWindNameEqualTo(String value) {
            addCriterion("wind_name =", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameNotEqualTo(String value) {
            addCriterion("wind_name <>", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameGreaterThan(String value) {
            addCriterion("wind_name >", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameGreaterThanOrEqualTo(String value) {
            addCriterion("wind_name >=", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameLessThan(String value) {
            addCriterion("wind_name <", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameLessThanOrEqualTo(String value) {
            addCriterion("wind_name <=", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameLike(String value) {
            addCriterion("wind_name like", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameNotLike(String value) {
            addCriterion("wind_name not like", value, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameIn(List<String> values) {
            addCriterion("wind_name in", values, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameNotIn(List<String> values) {
            addCriterion("wind_name not in", values, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameBetween(String value1, String value2) {
            addCriterion("wind_name between", value1, value2, "windName");
            return (Criteria) this;
        }

        public Criteria andWindNameNotBetween(String value1, String value2) {
            addCriterion("wind_name not between", value1, value2, "windName");
            return (Criteria) this;
        }

        public Criteria andWindStatusIsNull() {
            addCriterion("wind_status is null");
            return (Criteria) this;
        }

        public Criteria andWindStatusIsNotNull() {
            addCriterion("wind_status is not null");
            return (Criteria) this;
        }

        public Criteria andWindStatusEqualTo(String value) {
            addCriterion("wind_status =", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusNotEqualTo(String value) {
            addCriterion("wind_status <>", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusGreaterThan(String value) {
            addCriterion("wind_status >", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusGreaterThanOrEqualTo(String value) {
            addCriterion("wind_status >=", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusLessThan(String value) {
            addCriterion("wind_status <", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusLessThanOrEqualTo(String value) {
            addCriterion("wind_status <=", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusLike(String value) {
            addCriterion("wind_status like", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusNotLike(String value) {
            addCriterion("wind_status not like", value, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusIn(List<String> values) {
            addCriterion("wind_status in", values, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusNotIn(List<String> values) {
            addCriterion("wind_status not in", values, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusBetween(String value1, String value2) {
            addCriterion("wind_status between", value1, value2, "windStatus");
            return (Criteria) this;
        }

        public Criteria andWindStatusNotBetween(String value1, String value2) {
            addCriterion("wind_status not between", value1, value2, "windStatus");
            return (Criteria) this;
        }

        public Criteria andIsValuableIsNull() {
            addCriterion("is_valuable is null");
            return (Criteria) this;
        }

        public Criteria andIsValuableIsNotNull() {
            addCriterion("is_valuable is not null");
            return (Criteria) this;
        }

        public Criteria andIsValuableEqualTo(String value) {
            addCriterion("is_valuable =", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableNotEqualTo(String value) {
            addCriterion("is_valuable <>", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableGreaterThan(String value) {
            addCriterion("is_valuable >", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableGreaterThanOrEqualTo(String value) {
            addCriterion("is_valuable >=", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableLessThan(String value) {
            addCriterion("is_valuable <", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableLessThanOrEqualTo(String value) {
            addCriterion("is_valuable <=", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableLike(String value) {
            addCriterion("is_valuable like", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableNotLike(String value) {
            addCriterion("is_valuable not like", value, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableIn(List<String> values) {
            addCriterion("is_valuable in", values, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableNotIn(List<String> values) {
            addCriterion("is_valuable not in", values, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableBetween(String value1, String value2) {
            addCriterion("is_valuable between", value1, value2, "isValuable");
            return (Criteria) this;
        }

        public Criteria andIsValuableNotBetween(String value1, String value2) {
            addCriterion("is_valuable not between", value1, value2, "isValuable");
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