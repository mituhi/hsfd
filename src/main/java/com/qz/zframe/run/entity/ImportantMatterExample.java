package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImportantMatterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImportantMatterExample() {
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

        public Criteria andMatterIdIsNull() {
            addCriterion("matter_id is null");
            return (Criteria) this;
        }

        public Criteria andMatterIdIsNotNull() {
            addCriterion("matter_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatterIdEqualTo(String value) {
            addCriterion("matter_id =", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotEqualTo(String value) {
            addCriterion("matter_id <>", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdGreaterThan(String value) {
            addCriterion("matter_id >", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdGreaterThanOrEqualTo(String value) {
            addCriterion("matter_id >=", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdLessThan(String value) {
            addCriterion("matter_id <", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdLessThanOrEqualTo(String value) {
            addCriterion("matter_id <=", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdLike(String value) {
            addCriterion("matter_id like", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotLike(String value) {
            addCriterion("matter_id not like", value, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdIn(List<String> values) {
            addCriterion("matter_id in", values, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotIn(List<String> values) {
            addCriterion("matter_id not in", values, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdBetween(String value1, String value2) {
            addCriterion("matter_id between", value1, value2, "matterId");
            return (Criteria) this;
        }

        public Criteria andMatterIdNotBetween(String value1, String value2) {
            addCriterion("matter_id not between", value1, value2, "matterId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNull() {
            addCriterion("log_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNotNull() {
            addCriterion("log_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdEqualTo(String value) {
            addCriterion("log_type_id =", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotEqualTo(String value) {
            addCriterion("log_type_id <>", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThan(String value) {
            addCriterion("log_type_id >", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_type_id >=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThan(String value) {
            addCriterion("log_type_id <", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThanOrEqualTo(String value) {
            addCriterion("log_type_id <=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLike(String value) {
            addCriterion("log_type_id like", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotLike(String value) {
            addCriterion("log_type_id not like", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIn(List<String> values) {
            addCriterion("log_type_id in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotIn(List<String> values) {
            addCriterion("log_type_id not in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdBetween(String value1, String value2) {
            addCriterion("log_type_id between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotBetween(String value1, String value2) {
            addCriterion("log_type_id not between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like","%"+ value+"%", "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNull() {
            addCriterion("log_name is null");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNotNull() {
            addCriterion("log_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogNameEqualTo(String value) {
            addCriterion("log_name =", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotEqualTo(String value) {
            addCriterion("log_name <>", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThan(String value) {
            addCriterion("log_name >", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_name >=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThan(String value) {
            addCriterion("log_name <", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThanOrEqualTo(String value) {
            addCriterion("log_name <=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLike(String value) {
            addCriterion("log_name like","%"+ value+"%", "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotLike(String value) {
            addCriterion("log_name not like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameIn(List<String> values) {
            addCriterion("log_name in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotIn(List<String> values) {
            addCriterion("log_name not in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameBetween(String value1, String value2) {
            addCriterion("log_name between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotBetween(String value1, String value2) {
            addCriterion("log_name not between", value1, value2, "logName");
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

        public Criteria andImportantMatterIsNull() {
            addCriterion("important_matter is null");
            return (Criteria) this;
        }

        public Criteria andImportantMatterIsNotNull() {
            addCriterion("important_matter is not null");
            return (Criteria) this;
        }

        public Criteria andImportantMatterEqualTo(String value) {
            addCriterion("important_matter =", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterNotEqualTo(String value) {
            addCriterion("important_matter <>", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterGreaterThan(String value) {
            addCriterion("important_matter >", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterGreaterThanOrEqualTo(String value) {
            addCriterion("important_matter >=", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterLessThan(String value) {
            addCriterion("important_matter <", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterLessThanOrEqualTo(String value) {
            addCriterion("important_matter <=", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterLike(String value) {
            addCriterion("important_matter like", "%"+value+"%", "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterNotLike(String value) {
            addCriterion("important_matter not like", value, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterIn(List<String> values) {
            addCriterion("important_matter in", values, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterNotIn(List<String> values) {
            addCriterion("important_matter not in", values, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterBetween(String value1, String value2) {
            addCriterion("important_matter between", value1, value2, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andImportantMatterNotBetween(String value1, String value2) {
            addCriterion("important_matter not between", value1, value2, "importantMatter");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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