package com.qz.zframe.tally.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class QrCodeExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QrCodeExample() {
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

        public Criteria andQrIdIsNull() {
            addCriterion("qr_id is null");
            return (Criteria) this;
        }

        public Criteria andQrIdIsNotNull() {
            addCriterion("qr_id is not null");
            return (Criteria) this;
        }

        public Criteria andQrIdEqualTo(String value) {
            addCriterion("a.qr_id =", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdNotEqualTo(String value) {
            addCriterion("qr_id <>", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdGreaterThan(String value) {
            addCriterion("qr_id >", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdGreaterThanOrEqualTo(String value) {
            addCriterion("qr_id >=", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdLessThan(String value) {
            addCriterion("qr_id <", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdLessThanOrEqualTo(String value) {
            addCriterion("qr_id <=", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdLike(String value) {
            addCriterion("qr_id like", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdNotLike(String value) {
            addCriterion("qr_id not like", value, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdIn(List<String> values) {
            addCriterion("qr_id in", values, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdNotIn(List<String> values) {
            addCriterion("qr_id not in", values, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdBetween(String value1, String value2) {
            addCriterion("qr_id between", value1, value2, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrIdNotBetween(String value1, String value2) {
            addCriterion("qr_id not between", value1, value2, "qrId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdIsNull() {
            addCriterion("qr_code_id is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdIsNotNull() {
            addCriterion("qr_code_id is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdEqualTo(String value) {
            addCriterion("qr_code_id =", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdNotEqualTo(String value) {
            addCriterion("a.qr_code_id <>", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdGreaterThan(String value) {
            addCriterion("qr_code_id >", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code_id >=", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdLessThan(String value) {
            addCriterion("qr_code_id <", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdLessThanOrEqualTo(String value) {
            addCriterion("qr_code_id <=", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdLike(String value) {
            addCriterion("qr_code_id like", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdNotLike(String value) {
            addCriterion("qr_code_id not like", value, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdIn(List<String> values) {
            addCriterion("qr_code_id in", values, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdNotIn(List<String> values) {
            addCriterion("qr_code_id not in", values, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdBetween(String value1, String value2) {
            addCriterion("qr_code_id between", value1, value2, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIdNotBetween(String value1, String value2) {
            addCriterion("qr_code_id not between", value1, value2, "qrCodeId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("a.position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }
        
        public Criteria andPositionNameLike(String value) {
            addCriterion("b.position_name like", "%"+value+"%", "positionName");
            return (Criteria) this;
        }
        
        public Criteria andPositionCodeLike(String value) {
            addCriterion("b.position_code like", "%"+value+"%", "positionCode");
            return (Criteria) this;
        }
        
        public Criteria andArchitectureTypeEqualTO(String value) {
            addCriterion("c.architecture_type =", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
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