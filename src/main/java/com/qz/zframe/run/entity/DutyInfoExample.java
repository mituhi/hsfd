package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DutyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyInfoExample() {
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

        public Criteria andDutyInfoIdIsNull() {
            addCriterion("duty_info_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdIsNotNull() {
            addCriterion("duty_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdEqualTo(String value) {
            addCriterion("duty_info_id =", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdNotEqualTo(String value) {
            addCriterion("duty_info_id <>", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdGreaterThan(String value) {
            addCriterion("duty_info_id >", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_info_id >=", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdLessThan(String value) {
            addCriterion("duty_info_id <", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdLessThanOrEqualTo(String value) {
            addCriterion("duty_info_id <=", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdLike(String value) {
            addCriterion("duty_info_id like", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdNotLike(String value) {
            addCriterion("duty_info_id not like", value, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdIn(List<String> values) {
            addCriterion("duty_info_id in", values, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdNotIn(List<String> values) {
            addCriterion("duty_info_id not in", values, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdBetween(String value1, String value2) {
            addCriterion("duty_info_id between", value1, value2, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyInfoIdNotBetween(String value1, String value2) {
            addCriterion("duty_info_id not between", value1, value2, "dutyInfoId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdIsNull() {
            addCriterion("duty_log_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdIsNotNull() {
            addCriterion("duty_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdEqualTo(String value) {
            addCriterion("duty_log_id =", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotEqualTo(String value) {
            addCriterion("duty_log_id <>", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdGreaterThan(String value) {
            addCriterion("duty_log_id >", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_log_id >=", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLessThan(String value) {
            addCriterion("duty_log_id <", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLessThanOrEqualTo(String value) {
            addCriterion("duty_log_id <=", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLike(String value) {
            addCriterion("duty_log_id like", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotLike(String value) {
            addCriterion("duty_log_id not like", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdIn(List<String> values) {
            addCriterion("duty_log_id in", values, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotIn(List<String> values) {
            addCriterion("duty_log_id not in", values, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdBetween(String value1, String value2) {
            addCriterion("duty_log_id between", value1, value2, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotBetween(String value1, String value2) {
            addCriterion("duty_log_id not between", value1, value2, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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

        public Criteria andShiftNameIsNull() {
            addCriterion("shift_name is null");
            return (Criteria) this;
        }

        public Criteria andShiftNameIsNotNull() {
            addCriterion("shift_name is not null");
            return (Criteria) this;
        }

        public Criteria andShiftNameEqualTo(String value) {
            addCriterion("shift_name =", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotEqualTo(String value) {
            addCriterion("shift_name <>", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameGreaterThan(String value) {
            addCriterion("shift_name >", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameGreaterThanOrEqualTo(String value) {
            addCriterion("shift_name >=", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLessThan(String value) {
            addCriterion("shift_name <", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLessThanOrEqualTo(String value) {
            addCriterion("shift_name <=", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameLike(String value) {
            addCriterion("shift_name like", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotLike(String value) {
            addCriterion("shift_name not like", value, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameIn(List<String> values) {
            addCriterion("shift_name in", values, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotIn(List<String> values) {
            addCriterion("shift_name not in", values, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameBetween(String value1, String value2) {
            addCriterion("shift_name between", value1, value2, "shiftName");
            return (Criteria) this;
        }

        public Criteria andShiftNameNotBetween(String value1, String value2) {
            addCriterion("shift_name not between", value1, value2, "shiftName");
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
            addCriterion("value_name like", value, "valueName");
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

        public Criteria andDutyUserIdsIsNull() {
            addCriterion("duty_user_ids is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsIsNotNull() {
            addCriterion("duty_user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsEqualTo(String value) {
            addCriterion("duty_user_ids =", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotEqualTo(String value) {
            addCriterion("duty_user_ids <>", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsGreaterThan(String value) {
            addCriterion("duty_user_ids >", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user_ids >=", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLessThan(String value) {
            addCriterion("duty_user_ids <", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLessThanOrEqualTo(String value) {
            addCriterion("duty_user_ids <=", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLike(String value) {
            addCriterion("duty_user_ids like", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotLike(String value) {
            addCriterion("duty_user_ids not like", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsIn(List<String> values) {
            addCriterion("duty_user_ids in", values, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotIn(List<String> values) {
            addCriterion("duty_user_ids not in", values, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsBetween(String value1, String value2) {
            addCriterion("duty_user_ids between", value1, value2, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotBetween(String value1, String value2) {
            addCriterion("duty_user_ids not between", value1, value2, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andSuccessorIsNull() {
            addCriterion("successor is null");
            return (Criteria) this;
        }

        public Criteria andSuccessorIsNotNull() {
            addCriterion("successor is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessorEqualTo(String value) {
            addCriterion("successor =", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorNotEqualTo(String value) {
            addCriterion("successor <>", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorGreaterThan(String value) {
            addCriterion("successor >", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorGreaterThanOrEqualTo(String value) {
            addCriterion("successor >=", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorLessThan(String value) {
            addCriterion("successor <", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorLessThanOrEqualTo(String value) {
            addCriterion("successor <=", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorLike(String value) {
            addCriterion("successor like", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorNotLike(String value) {
            addCriterion("successor not like", value, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorIn(List<String> values) {
            addCriterion("successor in", values, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorNotIn(List<String> values) {
            addCriterion("successor not in", values, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorBetween(String value1, String value2) {
            addCriterion("successor between", value1, value2, "successor");
            return (Criteria) this;
        }

        public Criteria andSuccessorNotBetween(String value1, String value2) {
            addCriterion("successor not between", value1, value2, "successor");
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