package com.qz.zframe.device.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ParametersExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParametersExample() {
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

        public Criteria andParameterIdIsNull() {
            addCriterion("parameter_id is null");
            return (Criteria) this;
        }

        public Criteria andParameterIdIsNotNull() {
            addCriterion("parameter_id is not null");
            return (Criteria) this;
        }

        public Criteria andParameterIdEqualTo(String value) {
            addCriterion("parameter_id =", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdNotEqualTo(String value) {
            addCriterion("parameter_id <>", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdGreaterThan(String value) {
            addCriterion("parameter_id >", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_id >=", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdLessThan(String value) {
            addCriterion("parameter_id <", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdLessThanOrEqualTo(String value) {
            addCriterion("parameter_id <=", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdLike(String value) {
            addCriterion("parameter_id like", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdNotLike(String value) {
            addCriterion("parameter_id not like", value, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdIn(List<String> values) {
            addCriterion("parameter_id in", values, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdNotIn(List<String> values) {
            addCriterion("parameter_id not in", values, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdBetween(String value1, String value2) {
            addCriterion("parameter_id between", value1, value2, "parameterId");
            return (Criteria) this;
        }

        public Criteria andParameterIdNotBetween(String value1, String value2) {
            addCriterion("parameter_id not between", value1, value2, "parameterId");
            return (Criteria) this;
        }

        public Criteria andOutputIsNull() {
            addCriterion("output is null");
            return (Criteria) this;
        }

        public Criteria andOutputIsNotNull() {
            addCriterion("output is not null");
            return (Criteria) this;
        }

        public Criteria andOutputEqualTo(String value) {
            addCriterion("output =", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotEqualTo(String value) {
            addCriterion("output <>", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThan(String value) {
            addCriterion("output >", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThanOrEqualTo(String value) {
            addCriterion("output >=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThan(String value) {
            addCriterion("output <", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThanOrEqualTo(String value) {
            addCriterion("output <=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLike(String value) {
            addCriterion("output like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotLike(String value) {
            addCriterion("output not like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputIn(List<String> values) {
            addCriterion("output in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotIn(List<String> values) {
            addCriterion("output not in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputBetween(String value1, String value2) {
            addCriterion("output between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotBetween(String value1, String value2) {
            addCriterion("output not between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andRunIsNull() {
            addCriterion("run is null");
            return (Criteria) this;
        }

        public Criteria andRunIsNotNull() {
            addCriterion("run is not null");
            return (Criteria) this;
        }

        public Criteria andRunEqualTo(String value) {
            addCriterion("run =", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotEqualTo(String value) {
            addCriterion("run <>", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunGreaterThan(String value) {
            addCriterion("run >", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunGreaterThanOrEqualTo(String value) {
            addCriterion("run >=", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLessThan(String value) {
            addCriterion("run <", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLessThanOrEqualTo(String value) {
            addCriterion("run <=", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLike(String value) {
            addCriterion("run like", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotLike(String value) {
            addCriterion("run not like", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunIn(List<String> values) {
            addCriterion("run in", values, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotIn(List<String> values) {
            addCriterion("run not in", values, "run");
            return (Criteria) this;
        }

        public Criteria andRunBetween(String value1, String value2) {
            addCriterion("run between", value1, value2, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotBetween(String value1, String value2) {
            addCriterion("run not between", value1, value2, "run");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNull() {
            addCriterion("parameter_code is null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNotNull() {
            addCriterion("parameter_code is not null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeEqualTo(String value) {
            addCriterion("parameter_code =", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotEqualTo(String value) {
            addCriterion("parameter_code <>", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThan(String value) {
            addCriterion("parameter_code >", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_code >=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThan(String value) {
            addCriterion("parameter_code <", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThanOrEqualTo(String value) {
            addCriterion("parameter_code <=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLike(String value) {
            addCriterion("parameter_code like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotLike(String value) {
            addCriterion("parameter_code not like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIn(List<String> values) {
            addCriterion("parameter_code in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotIn(List<String> values) {
            addCriterion("parameter_code not in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeBetween(String value1, String value2) {
            addCriterion("parameter_code between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotBetween(String value1, String value2) {
            addCriterion("parameter_code not between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNull() {
            addCriterion("parameter_name is null");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNotNull() {
            addCriterion("parameter_name is not null");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualTo(String value) {
            addCriterion("parameter_name =", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualTo(String value) {
            addCriterion("parameter_name <>", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThan(String value) {
            addCriterion("parameter_name >", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_name >=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThan(String value) {
            addCriterion("parameter_name <", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualTo(String value) {
            addCriterion("parameter_name <=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLike(String value) {
            addCriterion("p.parameter_name like", "%"+value+"%", "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotLike(String value) {
            addCriterion("parameter_name not like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameIn(List<String> values) {
            addCriterion("parameter_name in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotIn(List<String> values) {
            addCriterion("parameter_name not in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameBetween(String value1, String value2) {
            addCriterion("parameter_name between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotBetween(String value1, String value2) {
            addCriterion("parameter_name not between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
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