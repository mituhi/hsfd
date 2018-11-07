package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class SchedulingRuleExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulingRuleExample() {
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

        public Criteria andSchedulingRuleIdIsNull() {
            addCriterion("scheduling_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdIsNotNull() {
            addCriterion("scheduling_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdEqualTo(String value) {
            addCriterion("scheduling_rule_id =", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdNotEqualTo(String value) {
            addCriterion("scheduling_rule_id <>", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdGreaterThan(String value) {
            addCriterion("scheduling_rule_id >", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_rule_id >=", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdLessThan(String value) {
            addCriterion("scheduling_rule_id <", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdLessThanOrEqualTo(String value) {
            addCriterion("scheduling_rule_id <=", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdLike(String value) {
            addCriterion("scheduling_rule_id like", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdNotLike(String value) {
            addCriterion("scheduling_rule_id not like", value, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdIn(List<String> values) {
            addCriterion("scheduling_rule_id in", values, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdNotIn(List<String> values) {
            addCriterion("scheduling_rule_id not in", values, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdBetween(String value1, String value2) {
            addCriterion("scheduling_rule_id between", value1, value2, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIdNotBetween(String value1, String value2) {
            addCriterion("scheduling_rule_id not between", value1, value2, "schedulingRuleId");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeIsNull() {
            addCriterion("scheduling_rule_code is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeIsNotNull() {
            addCriterion("scheduling_rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeEqualTo(String value) {
            addCriterion("scheduling_rule_code =", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeNotEqualTo(String value) {
            addCriterion("scheduling_rule_code <>", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeGreaterThan(String value) {
            addCriterion("scheduling_rule_code >", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_rule_code >=", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeLessThan(String value) {
            addCriterion("scheduling_rule_code <", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("scheduling_rule_code <=", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeLike(String value) {
            addCriterion("scheduling_rule_code like", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeNotLike(String value) {
            addCriterion("scheduling_rule_code not like", value, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeIn(List<String> values) {
            addCriterion("scheduling_rule_code in", values, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeNotIn(List<String> values) {
            addCriterion("scheduling_rule_code not in", values, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeBetween(String value1, String value2) {
            addCriterion("scheduling_rule_code between", value1, value2, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleCodeNotBetween(String value1, String value2) {
            addCriterion("scheduling_rule_code not between", value1, value2, "schedulingRuleCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIsNull() {
            addCriterion("scheduling_rule is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIsNotNull() {
            addCriterion("scheduling_rule is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleEqualTo(String value) {
            addCriterion("scheduling_rule =", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleNotEqualTo(String value) {
            addCriterion("scheduling_rule <>", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleGreaterThan(String value) {
            addCriterion("scheduling_rule >", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_rule >=", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleLessThan(String value) {
            addCriterion("scheduling_rule <", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleLessThanOrEqualTo(String value) {
            addCriterion("scheduling_rule <=", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleLike(String value) {
            addCriterion("scheduling_rule like", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleNotLike(String value) {
            addCriterion("scheduling_rule not like", value, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleIn(List<String> values) {
            addCriterion("scheduling_rule in", values, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleNotIn(List<String> values) {
            addCriterion("scheduling_rule not in", values, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleBetween(String value1, String value2) {
            addCriterion("scheduling_rule between", value1, value2, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andSchedulingRuleNotBetween(String value1, String value2) {
            addCriterion("scheduling_rule not between", value1, value2, "schedulingRule");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftIsNull() {
            addCriterion("scheduling_shift is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftIsNotNull() {
            addCriterion("scheduling_shift is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftEqualTo(String value) {
            addCriterion("scheduling_shift =", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftNotEqualTo(String value) {
            addCriterion("scheduling_shift <>", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftGreaterThan(String value) {
            addCriterion("scheduling_shift >", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_shift >=", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftLessThan(String value) {
            addCriterion("scheduling_shift <", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftLessThanOrEqualTo(String value) {
            addCriterion("scheduling_shift <=", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftLike(String value) {
            addCriterion("scheduling_shift like", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftNotLike(String value) {
            addCriterion("scheduling_shift not like", value, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftIn(List<String> values) {
            addCriterion("scheduling_shift in", values, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftNotIn(List<String> values) {
            addCriterion("scheduling_shift not in", values, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftBetween(String value1, String value2) {
            addCriterion("scheduling_shift between", value1, value2, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andSchedulingShiftNotBetween(String value1, String value2) {
            addCriterion("scheduling_shift not between", value1, value2, "schedulingShift");
            return (Criteria) this;
        }

        public Criteria andRotationCycleIsNull() {
            addCriterion("rotation_cycle is null");
            return (Criteria) this;
        }

        public Criteria andRotationCycleIsNotNull() {
            addCriterion("rotation_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andRotationCycleEqualTo(String value) {
            addCriterion("rotation_cycle =", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleNotEqualTo(String value) {
            addCriterion("rotation_cycle <>", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleGreaterThan(String value) {
            addCriterion("rotation_cycle >", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleGreaterThanOrEqualTo(String value) {
            addCriterion("rotation_cycle >=", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleLessThan(String value) {
            addCriterion("rotation_cycle <", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleLessThanOrEqualTo(String value) {
            addCriterion("rotation_cycle <=", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleLike(String value) {
            addCriterion("rotation_cycle like", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleNotLike(String value) {
            addCriterion("rotation_cycle not like", value, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleIn(List<String> values) {
            addCriterion("rotation_cycle in", values, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleNotIn(List<String> values) {
            addCriterion("rotation_cycle not in", values, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleBetween(String value1, String value2) {
            addCriterion("rotation_cycle between", value1, value2, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andRotationCycleNotBetween(String value1, String value2) {
            addCriterion("rotation_cycle not between", value1, value2, "rotationCycle");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayIsNull() {
            addCriterion("is_across_day is null");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayIsNotNull() {
            addCriterion("is_across_day is not null");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayEqualTo(String value) {
            addCriterion("is_across_day =", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayNotEqualTo(String value) {
            addCriterion("is_across_day <>", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayGreaterThan(String value) {
            addCriterion("is_across_day >", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayGreaterThanOrEqualTo(String value) {
            addCriterion("is_across_day >=", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayLessThan(String value) {
            addCriterion("is_across_day <", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayLessThanOrEqualTo(String value) {
            addCriterion("is_across_day <=", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayLike(String value) {
            addCriterion("is_across_day like", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayNotLike(String value) {
            addCriterion("is_across_day not like", value, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayIn(List<String> values) {
            addCriterion("is_across_day in", values, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayNotIn(List<String> values) {
            addCriterion("is_across_day not in", values, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayBetween(String value1, String value2) {
            addCriterion("is_across_day between", value1, value2, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andIsAcrossDayNotBetween(String value1, String value2) {
            addCriterion("is_across_day not between", value1, value2, "isAcrossDay");
            return (Criteria) this;
        }

        public Criteria andDayNumIsNull() {
            addCriterion("day_num is null");
            return (Criteria) this;
        }

        public Criteria andDayNumIsNotNull() {
            addCriterion("day_num is not null");
            return (Criteria) this;
        }

        public Criteria andDayNumEqualTo(String value) {
            addCriterion("day_num =", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumNotEqualTo(String value) {
            addCriterion("day_num <>", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumGreaterThan(String value) {
            addCriterion("day_num >", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumGreaterThanOrEqualTo(String value) {
            addCriterion("day_num >=", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumLessThan(String value) {
            addCriterion("day_num <", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumLessThanOrEqualTo(String value) {
            addCriterion("day_num <=", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumLike(String value) {
            addCriterion("day_num like", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumNotLike(String value) {
            addCriterion("day_num not like", value, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumIn(List<String> values) {
            addCriterion("day_num in", values, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumNotIn(List<String> values) {
            addCriterion("day_num not in", values, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumBetween(String value1, String value2) {
            addCriterion("day_num between", value1, value2, "dayNum");
            return (Criteria) this;
        }

        public Criteria andDayNumNotBetween(String value1, String value2) {
            addCriterion("day_num not between", value1, value2, "dayNum");
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