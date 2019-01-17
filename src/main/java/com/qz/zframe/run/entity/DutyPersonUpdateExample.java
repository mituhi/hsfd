package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DutyPersonUpdateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyPersonUpdateExample() {
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

        public Criteria andDutyPersonUpdateIdIsNull() {
            addCriterion("duty_person_update_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdIsNotNull() {
            addCriterion("duty_person_update_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdEqualTo(String value) {
            addCriterion("duty_person_update_id =", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdNotEqualTo(String value) {
            addCriterion("duty_person_update_id <>", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdGreaterThan(String value) {
            addCriterion("duty_person_update_id >", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_person_update_id >=", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdLessThan(String value) {
            addCriterion("duty_person_update_id <", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdLessThanOrEqualTo(String value) {
            addCriterion("duty_person_update_id <=", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdLike(String value) {
            addCriterion("duty_person_update_id like", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdNotLike(String value) {
            addCriterion("duty_person_update_id not like", value, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdIn(List<String> values) {
            addCriterion("duty_person_update_id in", values, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdNotIn(List<String> values) {
            addCriterion("duty_person_update_id not in", values, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdBetween(String value1, String value2) {
            addCriterion("duty_person_update_id between", value1, value2, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andDutyPersonUpdateIdNotBetween(String value1, String value2) {
            addCriterion("duty_person_update_id not between", value1, value2, "dutyPersonUpdateId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdIsNull() {
            addCriterion("scheduling_associated_id is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdIsNotNull() {
            addCriterion("scheduling_associated_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdEqualTo(String value) {
            addCriterion("scheduling_associated_id =", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdNotEqualTo(String value) {
            addCriterion("scheduling_associated_id <>", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdGreaterThan(String value) {
            addCriterion("scheduling_associated_id >", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_associated_id >=", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdLessThan(String value) {
            addCriterion("scheduling_associated_id <", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdLessThanOrEqualTo(String value) {
            addCriterion("scheduling_associated_id <=", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdLike(String value) {
            addCriterion("scheduling_associated_id like", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdNotLike(String value) {
            addCriterion("scheduling_associated_id not like", value, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdIn(List<String> values) {
            addCriterion("scheduling_associated_id in", values, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdNotIn(List<String> values) {
            addCriterion("scheduling_associated_id not in", values, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdBetween(String value1, String value2) {
            addCriterion("scheduling_associated_id between", value1, value2, "schedulingAssociatedId");
            return (Criteria) this;
        }

        public Criteria andSchedulingAssociatedIdNotBetween(String value1, String value2) {
            addCriterion("scheduling_associated_id not between", value1, value2, "schedulingAssociatedId");
            return (Criteria) this;
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

        public Criteria andShiftIdIsNull() {
            addCriterion("shift_id is null");
            return (Criteria) this;
        }

        public Criteria andShiftIdIsNotNull() {
            addCriterion("shift_id is not null");
            return (Criteria) this;
        }

        public Criteria andShiftIdEqualTo(String value) {
            addCriterion("shift_id =", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotEqualTo(String value) {
            addCriterion("shift_id <>", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdGreaterThan(String value) {
            addCriterion("shift_id >", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdGreaterThanOrEqualTo(String value) {
            addCriterion("shift_id >=", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdLessThan(String value) {
            addCriterion("shift_id <", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdLessThanOrEqualTo(String value) {
            addCriterion("shift_id <=", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdLike(String value) {
            addCriterion("shift_id like", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotLike(String value) {
            addCriterion("shift_id not like", value, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdIn(List<String> values) {
            addCriterion("shift_id in", values, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotIn(List<String> values) {
            addCriterion("shift_id not in", values, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdBetween(String value1, String value2) {
            addCriterion("shift_id between", value1, value2, "shiftId");
            return (Criteria) this;
        }

        public Criteria andShiftIdNotBetween(String value1, String value2) {
            addCriterion("shift_id not between", value1, value2, "shiftId");
            return (Criteria) this;
        }

        public Criteria andDutyDateIsNull() {
            addCriterion("duty_date is null");
            return (Criteria) this;
        }

        public Criteria andDutyDateIsNotNull() {
            addCriterion("duty_date is not null");
            return (Criteria) this;
        }

        public Criteria andDutyDateEqualTo(Date value) {
            addCriterion("duty_date =", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateNotEqualTo(Date value) {
            addCriterion("duty_date <>", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateGreaterThan(Date value) {
            addCriterion("duty_date >", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("duty_date >=", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateLessThan(Date value) {
            addCriterion("duty_date <", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateLessThanOrEqualTo(Date value) {
            addCriterion("duty_date <=", value, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateIn(List<Date> values) {
            addCriterion("duty_date in", values, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateNotIn(List<Date> values) {
            addCriterion("duty_date not in", values, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateBetween(Date value1, Date value2) {
            addCriterion("duty_date between", value1, value2, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyDateNotBetween(Date value1, Date value2) {
            addCriterion("duty_date not between", value1, value2, "dutyDate");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdIsNull() {
            addCriterion("duty_users_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdIsNotNull() {
            addCriterion("duty_users_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdEqualTo(String value) {
            addCriterion("duty_users_id =", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdNotEqualTo(String value) {
            addCriterion("duty_users_id <>", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdGreaterThan(String value) {
            addCriterion("duty_users_id >", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_users_id >=", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdLessThan(String value) {
            addCriterion("duty_users_id <", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdLessThanOrEqualTo(String value) {
            addCriterion("duty_users_id <=", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdLike(String value) {
            addCriterion("duty_users_id like", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdNotLike(String value) {
            addCriterion("duty_users_id not like", value, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdIn(List<String> values) {
            addCriterion("duty_users_id in", values, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdNotIn(List<String> values) {
            addCriterion("duty_users_id not in", values, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdBetween(String value1, String value2) {
            addCriterion("duty_users_id between", value1, value2, "dutyUsersId");
            return (Criteria) this;
        }

        public Criteria andDutyUsersIdNotBetween(String value1, String value2) {
            addCriterion("duty_users_id not between", value1, value2, "dutyUsersId");
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