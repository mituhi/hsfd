package com.qz.zframe.production.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ProductionYearExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductionYearExample() {
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

        public Criteria andYearIdIsNull() {
            addCriterion("year_id is null");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNotNull() {
            addCriterion("year_id is not null");
            return (Criteria) this;
        }

        public Criteria andYearIdEqualTo(String value) {
            addCriterion("year_id =", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotEqualTo(String value) {
            addCriterion("year_id <>", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThan(String value) {
            addCriterion("year_id >", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThanOrEqualTo(String value) {
            addCriterion("year_id >=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThan(String value) {
            addCriterion("year_id <", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThanOrEqualTo(String value) {
            addCriterion("year_id <=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLike(String value) {
            addCriterion("year_id like", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotLike(String value) {
            addCriterion("year_id not like", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdIn(List<String> values) {
            addCriterion("year_id in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotIn(List<String> values) {
            addCriterion("year_id not in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdBetween(String value1, String value2) {
            addCriterion("year_id between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotBetween(String value1, String value2) {
            addCriterion("year_id not between", value1, value2, "yearId");
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

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andPlanFinishIsNull() {
            addCriterion("plan_finish is null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishIsNotNull() {
            addCriterion("plan_finish is not null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishEqualTo(String value) {
            addCriterion("plan_finish =", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishNotEqualTo(String value) {
            addCriterion("plan_finish <>", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishGreaterThan(String value) {
            addCriterion("plan_finish >", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishGreaterThanOrEqualTo(String value) {
            addCriterion("plan_finish >=", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishLessThan(String value) {
            addCriterion("plan_finish <", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishLessThanOrEqualTo(String value) {
            addCriterion("plan_finish <=", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishLike(String value) {
            addCriterion("plan_finish like", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishNotLike(String value) {
            addCriterion("plan_finish not like", value, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishIn(List<String> values) {
            addCriterion("plan_finish in", values, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishNotIn(List<String> values) {
            addCriterion("plan_finish not in", values, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishBetween(String value1, String value2) {
            addCriterion("plan_finish between", value1, value2, "planFinish");
            return (Criteria) this;
        }

        public Criteria andPlanFinishNotBetween(String value1, String value2) {
            addCriterion("plan_finish not between", value1, value2, "planFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishIsNull() {
            addCriterion("actual_finish is null");
            return (Criteria) this;
        }

        public Criteria andActualFinishIsNotNull() {
            addCriterion("actual_finish is not null");
            return (Criteria) this;
        }

        public Criteria andActualFinishEqualTo(String value) {
            addCriterion("actual_finish =", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishNotEqualTo(String value) {
            addCriterion("actual_finish <>", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishGreaterThan(String value) {
            addCriterion("actual_finish >", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishGreaterThanOrEqualTo(String value) {
            addCriterion("actual_finish >=", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishLessThan(String value) {
            addCriterion("actual_finish <", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishLessThanOrEqualTo(String value) {
            addCriterion("actual_finish <=", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishLike(String value) {
            addCriterion("actual_finish like", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishNotLike(String value) {
            addCriterion("actual_finish not like", value, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishIn(List<String> values) {
            addCriterion("actual_finish in", values, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishNotIn(List<String> values) {
            addCriterion("actual_finish not in", values, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishBetween(String value1, String value2) {
            addCriterion("actual_finish between", value1, value2, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andActualFinishNotBetween(String value1, String value2) {
            addCriterion("actual_finish not between", value1, value2, "actualFinish");
            return (Criteria) this;
        }

        public Criteria andLastYearIsNull() {
            addCriterion("last_year is null");
            return (Criteria) this;
        }

        public Criteria andLastYearIsNotNull() {
            addCriterion("last_year is not null");
            return (Criteria) this;
        }

        public Criteria andLastYearEqualTo(String value) {
            addCriterion("last_year =", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearNotEqualTo(String value) {
            addCriterion("last_year <>", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearGreaterThan(String value) {
            addCriterion("last_year >", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearGreaterThanOrEqualTo(String value) {
            addCriterion("last_year >=", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearLessThan(String value) {
            addCriterion("last_year <", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearLessThanOrEqualTo(String value) {
            addCriterion("last_year <=", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearLike(String value) {
            addCriterion("last_year like", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearNotLike(String value) {
            addCriterion("last_year not like", value, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearIn(List<String> values) {
            addCriterion("last_year in", values, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearNotIn(List<String> values) {
            addCriterion("last_year not in", values, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearBetween(String value1, String value2) {
            addCriterion("last_year between", value1, value2, "lastYear");
            return (Criteria) this;
        }

        public Criteria andLastYearNotBetween(String value1, String value2) {
            addCriterion("last_year not between", value1, value2, "lastYear");
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