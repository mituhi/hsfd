package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.List;

public class DamagedAuditDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DamagedAuditDetailExample() {
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

        public Criteria andDamagedAuditDetailIdIsNull() {
            addCriterion("damaged_audit_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdIsNotNull() {
            addCriterion("damaged_audit_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdEqualTo(String value) {
            addCriterion("damaged_audit_detail_id =", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdNotEqualTo(String value) {
            addCriterion("damaged_audit_detail_id <>", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdGreaterThan(String value) {
            addCriterion("damaged_audit_detail_id >", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_audit_detail_id >=", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdLessThan(String value) {
            addCriterion("damaged_audit_detail_id <", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_audit_detail_id <=", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdLike(String value) {
            addCriterion("damaged_audit_detail_id like", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdNotLike(String value) {
            addCriterion("damaged_audit_detail_id not like", value, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdIn(List<String> values) {
            addCriterion("damaged_audit_detail_id in", values, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdNotIn(List<String> values) {
            addCriterion("damaged_audit_detail_id not in", values, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdBetween(String value1, String value2) {
            addCriterion("damaged_audit_detail_id between", value1, value2, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDetailIdNotBetween(String value1, String value2) {
            addCriterion("damaged_audit_detail_id not between", value1, value2, "damagedAuditDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdIsNull() {
            addCriterion("damaged_audit_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdIsNotNull() {
            addCriterion("damaged_audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdEqualTo(String value) {
            addCriterion("a.damaged_audit_id =", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotEqualTo(String value) {
            addCriterion("damaged_audit_id <>", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdGreaterThan(String value) {
            addCriterion("damaged_audit_id >", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_audit_id >=", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLessThan(String value) {
            addCriterion("damaged_audit_id <", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_audit_id <=", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLike(String value) {
            addCriterion("damaged_audit_id like", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotLike(String value) {
            addCriterion("damaged_audit_id not like", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdIn(List<String> values) {
            addCriterion("damaged_audit_id in", values, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotIn(List<String> values) {
            addCriterion("damaged_audit_id not in", values, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdBetween(String value1, String value2) {
            addCriterion("damaged_audit_id between", value1, value2, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotBetween(String value1, String value2) {
            addCriterion("damaged_audit_id not between", value1, value2, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdIsNull() {
            addCriterion("damaged_parts_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdIsNotNull() {
            addCriterion("damaged_parts_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdEqualTo(String value) {
            addCriterion("damaged_parts_detail_id =", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotEqualTo(String value) {
            addCriterion("damaged_parts_detail_id <>", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdGreaterThan(String value) {
            addCriterion("damaged_parts_detail_id >", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_parts_detail_id >=", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLessThan(String value) {
            addCriterion("damaged_parts_detail_id <", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_parts_detail_id <=", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLike(String value) {
            addCriterion("damaged_parts_detail_id like", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotLike(String value) {
            addCriterion("damaged_parts_detail_id not like", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdIn(List<String> values) {
            addCriterion("damaged_parts_detail_id in", values, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotIn(List<String> values) {
            addCriterion("damaged_parts_detail_id not in", values, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdBetween(String value1, String value2) {
            addCriterion("damaged_parts_detail_id between", value1, value2, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotBetween(String value1, String value2) {
            addCriterion("damaged_parts_detail_id not between", value1, value2, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditNumIsNull() {
            addCriterion("audit_num is null");
            return (Criteria) this;
        }

        public Criteria andAuditNumIsNotNull() {
            addCriterion("audit_num is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNumEqualTo(Integer value) {
            addCriterion("audit_num =", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumNotEqualTo(Integer value) {
            addCriterion("audit_num <>", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumGreaterThan(Integer value) {
            addCriterion("audit_num >", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_num >=", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumLessThan(Integer value) {
            addCriterion("audit_num <", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumLessThanOrEqualTo(Integer value) {
            addCriterion("audit_num <=", value, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumIn(List<Integer> values) {
            addCriterion("audit_num in", values, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumNotIn(List<Integer> values) {
            addCriterion("audit_num not in", values, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumBetween(Integer value1, Integer value2) {
            addCriterion("audit_num between", value1, value2, "auditNum");
            return (Criteria) this;
        }

        public Criteria andAuditNumNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_num not between", value1, value2, "auditNum");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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