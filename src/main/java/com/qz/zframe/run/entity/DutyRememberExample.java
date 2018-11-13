package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

public class DutyRememberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyRememberExample() {
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

        public Criteria andDutyIdIsNull() {
            addCriterion("duty_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyIdIsNotNull() {
            addCriterion("duty_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyIdEqualTo(String value) {
            addCriterion("duty_id =", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotEqualTo(String value) {
            addCriterion("duty_id <>", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThan(String value) {
            addCriterion("duty_id >", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_id >=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThan(String value) {
            addCriterion("duty_id <", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThanOrEqualTo(String value) {
            addCriterion("duty_id <=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLike(String value) {
            addCriterion("duty_id like", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotLike(String value) {
            addCriterion("duty_id not like", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdIn(List<String> values) {
            addCriterion("duty_id in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotIn(List<String> values) {
            addCriterion("duty_id not in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdBetween(String value1, String value2) {
            addCriterion("duty_id between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotBetween(String value1, String value2) {
            addCriterion("duty_id not between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdIsNull() {
            addCriterion("run_log_id is null");
            return (Criteria) this;
        }

        public Criteria andRunLogIdIsNotNull() {
            addCriterion("run_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andRunLogIdEqualTo(String value) {
            addCriterion("run_log_id =", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdNotEqualTo(String value) {
            addCriterion("run_log_id <>", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdGreaterThan(String value) {
            addCriterion("run_log_id >", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("run_log_id >=", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdLessThan(String value) {
            addCriterion("run_log_id <", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdLessThanOrEqualTo(String value) {
            addCriterion("run_log_id <=", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdLike(String value) {
            addCriterion("run_log_id like", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdNotLike(String value) {
            addCriterion("run_log_id not like", value, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdIn(List<String> values) {
            addCriterion("run_log_id in", values, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdNotIn(List<String> values) {
            addCriterion("run_log_id not in", values, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdBetween(String value1, String value2) {
            addCriterion("run_log_id between", value1, value2, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRunLogIdNotBetween(String value1, String value2) {
            addCriterion("run_log_id not between", value1, value2, "runLogId");
            return (Criteria) this;
        }

        public Criteria andRememberTimeIsNull() {
            addCriterion("remember_time is null");
            return (Criteria) this;
        }

        public Criteria andRememberTimeIsNotNull() {
            addCriterion("remember_time is not null");
            return (Criteria) this;
        }

        public Criteria andRememberTimeEqualTo(String value) {
            addCriterion("remember_time =", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeNotEqualTo(String value) {
            addCriterion("remember_time <>", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeGreaterThan(String value) {
            addCriterion("remember_time >", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeGreaterThanOrEqualTo(String value) {
            addCriterion("remember_time >=", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeLessThan(String value) {
            addCriterion("remember_time <", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeLessThanOrEqualTo(String value) {
            addCriterion("remember_time <=", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeLike(String value) {
            addCriterion("remember_time like", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeNotLike(String value) {
            addCriterion("remember_time not like", value, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeIn(List<String> values) {
            addCriterion("remember_time in", values, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeNotIn(List<String> values) {
            addCriterion("remember_time not in", values, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeBetween(String value1, String value2) {
            addCriterion("remember_time between", value1, value2, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberTimeNotBetween(String value1, String value2) {
            addCriterion("remember_time not between", value1, value2, "rememberTime");
            return (Criteria) this;
        }

        public Criteria andRememberThemeIsNull() {
            addCriterion("remember_theme is null");
            return (Criteria) this;
        }

        public Criteria andRememberThemeIsNotNull() {
            addCriterion("remember_theme is not null");
            return (Criteria) this;
        }

        public Criteria andRememberThemeEqualTo(String value) {
            addCriterion("remember_theme =", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeNotEqualTo(String value) {
            addCriterion("remember_theme <>", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeGreaterThan(String value) {
            addCriterion("remember_theme >", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeGreaterThanOrEqualTo(String value) {
            addCriterion("remember_theme >=", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeLessThan(String value) {
            addCriterion("remember_theme <", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeLessThanOrEqualTo(String value) {
            addCriterion("remember_theme <=", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeLike(String value) {
            addCriterion("remember_theme like", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeNotLike(String value) {
            addCriterion("remember_theme not like", value, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeIn(List<String> values) {
            addCriterion("remember_theme in", values, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeNotIn(List<String> values) {
            addCriterion("remember_theme not in", values, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeBetween(String value1, String value2) {
            addCriterion("remember_theme between", value1, value2, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberThemeNotBetween(String value1, String value2) {
            addCriterion("remember_theme not between", value1, value2, "rememberTheme");
            return (Criteria) this;
        }

        public Criteria andRememberContentIsNull() {
            addCriterion("remember_content is null");
            return (Criteria) this;
        }

        public Criteria andRememberContentIsNotNull() {
            addCriterion("remember_content is not null");
            return (Criteria) this;
        }

        public Criteria andRememberContentEqualTo(String value) {
            addCriterion("remember_content =", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentNotEqualTo(String value) {
            addCriterion("remember_content <>", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentGreaterThan(String value) {
            addCriterion("remember_content >", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentGreaterThanOrEqualTo(String value) {
            addCriterion("remember_content >=", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentLessThan(String value) {
            addCriterion("remember_content <", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentLessThanOrEqualTo(String value) {
            addCriterion("remember_content <=", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentLike(String value) {
            addCriterion("remember_content like", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentNotLike(String value) {
            addCriterion("remember_content not like", value, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentIn(List<String> values) {
            addCriterion("remember_content in", values, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentNotIn(List<String> values) {
            addCriterion("remember_content not in", values, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentBetween(String value1, String value2) {
            addCriterion("remember_content between", value1, value2, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberContentNotBetween(String value1, String value2) {
            addCriterion("remember_content not between", value1, value2, "rememberContent");
            return (Criteria) this;
        }

        public Criteria andRememberIsNull() {
            addCriterion("remember is null");
            return (Criteria) this;
        }

        public Criteria andRememberIsNotNull() {
            addCriterion("remember is not null");
            return (Criteria) this;
        }

        public Criteria andRememberEqualTo(String value) {
            addCriterion("remember =", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberNotEqualTo(String value) {
            addCriterion("remember <>", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberGreaterThan(String value) {
            addCriterion("remember >", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberGreaterThanOrEqualTo(String value) {
            addCriterion("remember >=", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberLessThan(String value) {
            addCriterion("remember <", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberLessThanOrEqualTo(String value) {
            addCriterion("remember <=", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberLike(String value) {
            addCriterion("remember like", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberNotLike(String value) {
            addCriterion("remember not like", value, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberIn(List<String> values) {
            addCriterion("remember in", values, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberNotIn(List<String> values) {
            addCriterion("remember not in", values, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberBetween(String value1, String value2) {
            addCriterion("remember between", value1, value2, "remember");
            return (Criteria) this;
        }

        public Criteria andRememberNotBetween(String value1, String value2) {
            addCriterion("remember not between", value1, value2, "remember");
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