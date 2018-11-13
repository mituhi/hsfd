package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class MaintainWorkContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaintainWorkContentExample() {
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

        public Criteria andWorkContentIdIsNull() {
            addCriterion("work_content_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdIsNotNull() {
            addCriterion("work_content_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdEqualTo(String value) {
            addCriterion("work_content_id =", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdNotEqualTo(String value) {
            addCriterion("work_content_id <>", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdGreaterThan(String value) {
            addCriterion("work_content_id >", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_content_id >=", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdLessThan(String value) {
            addCriterion("work_content_id <", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdLessThanOrEqualTo(String value) {
            addCriterion("work_content_id <=", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdLike(String value) {
            addCriterion("work_content_id like", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdNotLike(String value) {
            addCriterion("work_content_id not like", value, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdIn(List<String> values) {
            addCriterion("work_content_id in", values, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdNotIn(List<String> values) {
            addCriterion("work_content_id not in", values, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdBetween(String value1, String value2) {
            addCriterion("work_content_id between", value1, value2, "workContentId");
            return (Criteria) this;
        }

        public Criteria andWorkContentIdNotBetween(String value1, String value2) {
            addCriterion("work_content_id not between", value1, value2, "workContentId");
            return (Criteria) this;
        }

        public Criteria andDayIdIsNull() {
            addCriterion("day_id is null");
            return (Criteria) this;
        }

        public Criteria andDayIdIsNotNull() {
            addCriterion("day_id is not null");
            return (Criteria) this;
        }

        public Criteria andDayIdEqualTo(String value) {
            addCriterion("day_id =", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotEqualTo(String value) {
            addCriterion("day_id <>", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThan(String value) {
            addCriterion("day_id >", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThanOrEqualTo(String value) {
            addCriterion("day_id >=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThan(String value) {
            addCriterion("day_id <", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThanOrEqualTo(String value) {
            addCriterion("day_id <=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLike(String value) {
            addCriterion("day_id like", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotLike(String value) {
            addCriterion("day_id not like", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdIn(List<String> values) {
            addCriterion("day_id in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotIn(List<String> values) {
            addCriterion("day_id not in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdBetween(String value1, String value2) {
            addCriterion("day_id between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotBetween(String value1, String value2) {
            addCriterion("day_id not between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andWeekIdIsNull() {
            addCriterion("week_id is null");
            return (Criteria) this;
        }

        public Criteria andWeekIdIsNotNull() {
            addCriterion("week_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeekIdEqualTo(String value) {
            addCriterion("week_id =", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotEqualTo(String value) {
            addCriterion("week_id <>", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThan(String value) {
            addCriterion("week_id >", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdGreaterThanOrEqualTo(String value) {
            addCriterion("week_id >=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThan(String value) {
            addCriterion("week_id <", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLessThanOrEqualTo(String value) {
            addCriterion("week_id <=", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdLike(String value) {
            addCriterion("week_id like", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotLike(String value) {
            addCriterion("week_id not like", value, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdIn(List<String> values) {
            addCriterion("week_id in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotIn(List<String> values) {
            addCriterion("week_id not in", values, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdBetween(String value1, String value2) {
            addCriterion("week_id between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andWeekIdNotBetween(String value1, String value2) {
            addCriterion("week_id not between", value1, value2, "weekId");
            return (Criteria) this;
        }

        public Criteria andContentNumberIsNull() {
            addCriterion("content_number is null");
            return (Criteria) this;
        }

        public Criteria andContentNumberIsNotNull() {
            addCriterion("content_number is not null");
            return (Criteria) this;
        }

        public Criteria andContentNumberEqualTo(String value) {
            addCriterion("content_number =", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberNotEqualTo(String value) {
            addCriterion("content_number <>", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberGreaterThan(String value) {
            addCriterion("content_number >", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("content_number >=", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberLessThan(String value) {
            addCriterion("content_number <", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberLessThanOrEqualTo(String value) {
            addCriterion("content_number <=", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberLike(String value) {
            addCriterion("content_number like", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberNotLike(String value) {
            addCriterion("content_number not like", value, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberIn(List<String> values) {
            addCriterion("content_number in", values, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberNotIn(List<String> values) {
            addCriterion("content_number not in", values, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberBetween(String value1, String value2) {
            addCriterion("content_number between", value1, value2, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andContentNumberNotBetween(String value1, String value2) {
            addCriterion("content_number not between", value1, value2, "contentNumber");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIsNull() {
            addCriterion("work_task is null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIsNotNull() {
            addCriterion("work_task is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskEqualTo(String value) {
            addCriterion("work_task =", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNotEqualTo(String value) {
            addCriterion("work_task <>", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskGreaterThan(String value) {
            addCriterion("work_task >", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskGreaterThanOrEqualTo(String value) {
            addCriterion("work_task >=", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskLessThan(String value) {
            addCriterion("work_task <", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskLessThanOrEqualTo(String value) {
            addCriterion("work_task <=", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskLike(String value) {
            addCriterion("work_task like", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNotLike(String value) {
            addCriterion("work_task not like", value, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskIn(List<String> values) {
            addCriterion("work_task in", values, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNotIn(List<String> values) {
            addCriterion("work_task not in", values, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskBetween(String value1, String value2) {
            addCriterion("work_task between", value1, value2, "workTask");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNotBetween(String value1, String value2) {
            addCriterion("work_task not between", value1, value2, "workTask");
            return (Criteria) this;
        }

        public Criteria andStaffIsNull() {
            addCriterion("staff is null");
            return (Criteria) this;
        }

        public Criteria andStaffIsNotNull() {
            addCriterion("staff is not null");
            return (Criteria) this;
        }

        public Criteria andStaffEqualTo(String value) {
            addCriterion("staff =", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotEqualTo(String value) {
            addCriterion("staff <>", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThan(String value) {
            addCriterion("staff >", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThanOrEqualTo(String value) {
            addCriterion("staff >=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThan(String value) {
            addCriterion("staff <", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThanOrEqualTo(String value) {
            addCriterion("staff <=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLike(String value) {
            addCriterion("staff like", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotLike(String value) {
            addCriterion("staff not like", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffIn(List<String> values) {
            addCriterion("staff in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotIn(List<String> values) {
            addCriterion("staff not in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffBetween(String value1, String value2) {
            addCriterion("staff between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotBetween(String value1, String value2) {
            addCriterion("staff not between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNull() {
            addCriterion("is_complete is null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNotNull() {
            addCriterion("is_complete is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteEqualTo(String value) {
            addCriterion("is_complete =", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotEqualTo(String value) {
            addCriterion("is_complete <>", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThan(String value) {
            addCriterion("is_complete >", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_complete >=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThan(String value) {
            addCriterion("is_complete <", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThanOrEqualTo(String value) {
            addCriterion("is_complete <=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLike(String value) {
            addCriterion("is_complete like", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotLike(String value) {
            addCriterion("is_complete not like", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIn(List<String> values) {
            addCriterion("is_complete in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotIn(List<String> values) {
            addCriterion("is_complete not in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteBetween(String value1, String value2) {
            addCriterion("is_complete between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotBetween(String value1, String value2) {
            addCriterion("is_complete not between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeIsNull() {
            addCriterion("work_content_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeIsNotNull() {
            addCriterion("work_content_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeEqualTo(String value) {
            addCriterion("work_content_type =", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeNotEqualTo(String value) {
            addCriterion("work_content_type <>", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeGreaterThan(String value) {
            addCriterion("work_content_type >", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_content_type >=", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeLessThan(String value) {
            addCriterion("work_content_type <", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeLessThanOrEqualTo(String value) {
            addCriterion("work_content_type <=", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeLike(String value) {
            addCriterion("work_content_type like", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeNotLike(String value) {
            addCriterion("work_content_type not like", value, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeIn(List<String> values) {
            addCriterion("work_content_type in", values, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeNotIn(List<String> values) {
            addCriterion("work_content_type not in", values, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeBetween(String value1, String value2) {
            addCriterion("work_content_type between", value1, value2, "workContentType");
            return (Criteria) this;
        }

        public Criteria andWorkContentTypeNotBetween(String value1, String value2) {
            addCriterion("work_content_type not between", value1, value2, "workContentType");
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