package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.List;

public class UserAssoInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAssoInfoExample() {
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

        public Criteria andAssoIdIsNull() {
            addCriterion("asso_id is null");
            return (Criteria) this;
        }

        public Criteria andAssoIdIsNotNull() {
            addCriterion("asso_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssoIdEqualTo(String value) {
            addCriterion("asso_id =", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotEqualTo(String value) {
            addCriterion("asso_id <>", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThan(String value) {
            addCriterion("asso_id >", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThanOrEqualTo(String value) {
            addCriterion("asso_id >=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThan(String value) {
            addCriterion("asso_id <", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThanOrEqualTo(String value) {
            addCriterion("asso_id <=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLike(String value) {
            addCriterion("asso_id like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotLike(String value) {
            addCriterion("asso_id not like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdIn(List<String> values) {
            addCriterion("asso_id in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotIn(List<String> values) {
            addCriterion("asso_id not in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdBetween(String value1, String value2) {
            addCriterion("asso_id between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotBetween(String value1, String value2) {
            addCriterion("asso_id not between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdIsNull() {
            addCriterion("work_ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdIsNotNull() {
            addCriterion("work_ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdEqualTo(String value) {
            addCriterion("work_ticket_type_id =", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotEqualTo(String value) {
            addCriterion("work_ticket_type_id <>", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdGreaterThan(String value) {
            addCriterion("work_ticket_type_id >", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_ticket_type_id >=", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLessThan(String value) {
            addCriterion("work_ticket_type_id <", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("work_ticket_type_id <=", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLike(String value) {
            addCriterion("work_ticket_type_id like", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotLike(String value) {
            addCriterion("work_ticket_type_id not like", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdIn(List<String> values) {
            addCriterion("work_ticket_type_id in", values, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotIn(List<String> values) {
            addCriterion("work_ticket_type_id not in", values, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdBetween(String value1, String value2) {
            addCriterion("work_ticket_type_id between", value1, value2, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("work_ticket_type_id not between", value1, value2, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdIsNull() {
            addCriterion("oper_ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdIsNotNull() {
            addCriterion("oper_ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdEqualTo(String value) {
            addCriterion("oper_ticket_type_id =", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotEqualTo(String value) {
            addCriterion("oper_ticket_type_id <>", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdGreaterThan(String value) {
            addCriterion("oper_ticket_type_id >", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("oper_ticket_type_id >=", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLessThan(String value) {
            addCriterion("oper_ticket_type_id <", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("oper_ticket_type_id <=", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLike(String value) {
            addCriterion("oper_ticket_type_id like", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotLike(String value) {
            addCriterion("oper_ticket_type_id not like", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdIn(List<String> values) {
            addCriterion("oper_ticket_type_id in", values, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotIn(List<String> values) {
            addCriterion("oper_ticket_type_id not in", values, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdBetween(String value1, String value2) {
            addCriterion("oper_ticket_type_id between", value1, value2, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("oper_ticket_type_id not between", value1, value2, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andUserNumbetIsNull() {
            addCriterion("user_numbet is null");
            return (Criteria) this;
        }

        public Criteria andUserNumbetIsNotNull() {
            addCriterion("user_numbet is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumbetEqualTo(String value) {
            addCriterion("user_numbet =", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetNotEqualTo(String value) {
            addCriterion("user_numbet <>", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetGreaterThan(String value) {
            addCriterion("user_numbet >", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetGreaterThanOrEqualTo(String value) {
            addCriterion("user_numbet >=", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetLessThan(String value) {
            addCriterion("user_numbet <", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetLessThanOrEqualTo(String value) {
            addCriterion("user_numbet <=", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetLike(String value) {
            addCriterion("user_numbet like", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetNotLike(String value) {
            addCriterion("user_numbet not like", value, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetIn(List<String> values) {
            addCriterion("user_numbet in", values, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetNotIn(List<String> values) {
            addCriterion("user_numbet not in", values, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetBetween(String value1, String value2) {
            addCriterion("user_numbet between", value1, value2, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserNumbetNotBetween(String value1, String value2) {
            addCriterion("user_numbet not between", value1, value2, "userNumbet");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberIsNull() {
            addCriterion("user_work_number is null");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberIsNotNull() {
            addCriterion("user_work_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberEqualTo(String value) {
            addCriterion("user_work_number =", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberNotEqualTo(String value) {
            addCriterion("user_work_number <>", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberGreaterThan(String value) {
            addCriterion("user_work_number >", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_work_number >=", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberLessThan(String value) {
            addCriterion("user_work_number <", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberLessThanOrEqualTo(String value) {
            addCriterion("user_work_number <=", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberLike(String value) {
            addCriterion("user_work_number like", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberNotLike(String value) {
            addCriterion("user_work_number not like", value, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberIn(List<String> values) {
            addCriterion("user_work_number in", values, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberNotIn(List<String> values) {
            addCriterion("user_work_number not in", values, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberBetween(String value1, String value2) {
            addCriterion("user_work_number between", value1, value2, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserWorkNumberNotBetween(String value1, String value2) {
            addCriterion("user_work_number not between", value1, value2, "userWorkNumber");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserUnitIsNull() {
            addCriterion("user_unit is null");
            return (Criteria) this;
        }

        public Criteria andUserUnitIsNotNull() {
            addCriterion("user_unit is not null");
            return (Criteria) this;
        }

        public Criteria andUserUnitEqualTo(String value) {
            addCriterion("user_unit =", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotEqualTo(String value) {
            addCriterion("user_unit <>", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitGreaterThan(String value) {
            addCriterion("user_unit >", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitGreaterThanOrEqualTo(String value) {
            addCriterion("user_unit >=", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLessThan(String value) {
            addCriterion("user_unit <", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLessThanOrEqualTo(String value) {
            addCriterion("user_unit <=", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitLike(String value) {
            addCriterion("user_unit like", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotLike(String value) {
            addCriterion("user_unit not like", value, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitIn(List<String> values) {
            addCriterion("user_unit in", values, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotIn(List<String> values) {
            addCriterion("user_unit not in", values, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitBetween(String value1, String value2) {
            addCriterion("user_unit between", value1, value2, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserUnitNotBetween(String value1, String value2) {
            addCriterion("user_unit not between", value1, value2, "userUnit");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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