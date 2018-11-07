package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class SchedulingManagementExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulingManagementExample() {
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

        public Criteria andSchedulingManagementIdIsNull() {
            addCriterion("scheduling_management_id is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdIsNotNull() {
            addCriterion("scheduling_management_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdEqualTo(String value) {
            addCriterion("scheduling_management_id =", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotEqualTo(String value) {
            addCriterion("scheduling_management_id <>", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdGreaterThan(String value) {
            addCriterion("scheduling_management_id >", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_management_id >=", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLessThan(String value) {
            addCriterion("scheduling_management_id <", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLessThanOrEqualTo(String value) {
            addCriterion("scheduling_management_id <=", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLike(String value) {
            addCriterion("scheduling_management_id like", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotLike(String value) {
            addCriterion("scheduling_management_id not like", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdIn(List<String> values) {
            addCriterion("scheduling_management_id in", values, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotIn(List<String> values) {
            addCriterion("scheduling_management_id not in", values, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdBetween(String value1, String value2) {
            addCriterion("scheduling_management_id between", value1, value2, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotBetween(String value1, String value2) {
            addCriterion("scheduling_management_id not between", value1, value2, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeIsNull() {
            addCriterion("scheduling_code is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeIsNotNull() {
            addCriterion("scheduling_code is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeEqualTo(String value) {
            addCriterion("scheduling_code =", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeNotEqualTo(String value) {
            addCriterion("scheduling_code <>", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeGreaterThan(String value) {
            addCriterion("scheduling_code >", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_code >=", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeLessThan(String value) {
            addCriterion("scheduling_code <", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeLessThanOrEqualTo(String value) {
            addCriterion("scheduling_code <=", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeLike(String value) {
            addCriterion("scheduling_code like", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeNotLike(String value) {
            addCriterion("scheduling_code not like", value, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeIn(List<String> values) {
            addCriterion("scheduling_code in", values, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeNotIn(List<String> values) {
            addCriterion("scheduling_code not in", values, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeBetween(String value1, String value2) {
            addCriterion("scheduling_code between", value1, value2, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingCodeNotBetween(String value1, String value2) {
            addCriterion("scheduling_code not between", value1, value2, "schedulingCode");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIsNull() {
            addCriterion("scheduling_name is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIsNotNull() {
            addCriterion("scheduling_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameEqualTo(String value) {
            addCriterion("scheduling_name =", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotEqualTo(String value) {
            addCriterion("scheduling_name <>", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameGreaterThan(String value) {
            addCriterion("scheduling_name >", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_name >=", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLessThan(String value) {
            addCriterion("scheduling_name <", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLessThanOrEqualTo(String value) {
            addCriterion("scheduling_name <=", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLike(String value) {
            addCriterion("scheduling_name like", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotLike(String value) {
            addCriterion("scheduling_name not like", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIn(List<String> values) {
            addCriterion("scheduling_name in", values, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotIn(List<String> values) {
            addCriterion("scheduling_name not in", values, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameBetween(String value1, String value2) {
            addCriterion("scheduling_name between", value1, value2, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotBetween(String value1, String value2) {
            addCriterion("scheduling_name not between", value1, value2, "schedulingName");
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