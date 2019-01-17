package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SchedulingAssociatedDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulingAssociatedDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAssociatedDetailIdIsNull() {
            addCriterion("associated_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdIsNotNull() {
            addCriterion("associated_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdEqualTo(String value) {
            addCriterion("associated_detail_id =", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdNotEqualTo(String value) {
            addCriterion("associated_detail_id <>", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdGreaterThan(String value) {
            addCriterion("associated_detail_id >", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("associated_detail_id >=", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdLessThan(String value) {
            addCriterion("associated_detail_id <", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdLessThanOrEqualTo(String value) {
            addCriterion("associated_detail_id <=", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdLike(String value) {
            addCriterion("associated_detail_id like", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdNotLike(String value) {
            addCriterion("associated_detail_id not like", value, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdIn(List<String> values) {
            addCriterion("associated_detail_id in", values, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdNotIn(List<String> values) {
            addCriterion("associated_detail_id not in", values, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdBetween(String value1, String value2) {
            addCriterion("associated_detail_id between", value1, value2, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDetailIdNotBetween(String value1, String value2) {
            addCriterion("associated_detail_id not between", value1, value2, "associatedDetailId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIsNull() {
            addCriterion("associated_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIsNotNull() {
            addCriterion("associated_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdEqualTo(String value) {
            addCriterion("associated_id =", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotEqualTo(String value) {
            addCriterion("associated_id <>", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThan(String value) {
            addCriterion("associated_id >", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("associated_id >=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThan(String value) {
            addCriterion("associated_id <", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThanOrEqualTo(String value) {
            addCriterion("associated_id <=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLike(String value) {
            addCriterion("associated_id like", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotLike(String value) {
            addCriterion("associated_id not like", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIn(List<String> values) {
            addCriterion("associated_id in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotIn(List<String> values) {
            addCriterion("associated_id not in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdBetween(String value1, String value2) {
            addCriterion("associated_id between", value1, value2, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotBetween(String value1, String value2) {
            addCriterion("associated_id not between", value1, value2, "associatedId");
            return (Criteria) this;
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andRemartIsNull() {
            addCriterion("remart is null");
            return (Criteria) this;
        }

        public Criteria andRemartIsNotNull() {
            addCriterion("remart is not null");
            return (Criteria) this;
        }

        public Criteria andRemartEqualTo(String value) {
            addCriterion("remart =", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartNotEqualTo(String value) {
            addCriterion("remart <>", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartGreaterThan(String value) {
            addCriterion("remart >", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartGreaterThanOrEqualTo(String value) {
            addCriterion("remart >=", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartLessThan(String value) {
            addCriterion("remart <", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartLessThanOrEqualTo(String value) {
            addCriterion("remart <=", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartLike(String value) {
            addCriterion("remart like", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartNotLike(String value) {
            addCriterion("remart not like", value, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartIn(List<String> values) {
            addCriterion("remart in", values, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartNotIn(List<String> values) {
            addCriterion("remart not in", values, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartBetween(String value1, String value2) {
            addCriterion("remart between", value1, value2, "remart");
            return (Criteria) this;
        }

        public Criteria andRemartNotBetween(String value1, String value2) {
            addCriterion("remart not between", value1, value2, "remart");
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