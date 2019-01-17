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
            addCriterion("important_matter like", value, "importantMatter");
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

        public Criteria andUpdatePersonIsNull() {
            addCriterion("update_person is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNotNull() {
            addCriterion("update_person is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonEqualTo(Date value) {
            addCriterion("update_person =", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotEqualTo(Date value) {
            addCriterion("update_person <>", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThan(Date value) {
            addCriterion("update_person >", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThanOrEqualTo(Date value) {
            addCriterion("update_person >=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThan(Date value) {
            addCriterion("update_person <", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThanOrEqualTo(Date value) {
            addCriterion("update_person <=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIn(List<Date> values) {
            addCriterion("update_person in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotIn(List<Date> values) {
            addCriterion("update_person not in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonBetween(Date value1, Date value2) {
            addCriterion("update_person between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotBetween(Date value1, Date value2) {
            addCriterion("update_person not between", value1, value2, "updatePerson");
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