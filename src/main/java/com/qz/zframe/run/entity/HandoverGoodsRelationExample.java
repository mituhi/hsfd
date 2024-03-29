package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

public class HandoverGoodsRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HandoverGoodsRelationExample() {
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

        public Criteria andHandoverGoodsRelationIdIsNull() {
            addCriterion("handover_goods_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdIsNotNull() {
            addCriterion("handover_goods_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdEqualTo(String value) {
            addCriterion("handover_goods_relation_id =", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdNotEqualTo(String value) {
            addCriterion("handover_goods_relation_id <>", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdGreaterThan(String value) {
            addCriterion("handover_goods_relation_id >", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdGreaterThanOrEqualTo(String value) {
            addCriterion("handover_goods_relation_id >=", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdLessThan(String value) {
            addCriterion("handover_goods_relation_id <", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdLessThanOrEqualTo(String value) {
            addCriterion("handover_goods_relation_id <=", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdLike(String value) {
            addCriterion("handover_goods_relation_id like", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdNotLike(String value) {
            addCriterion("handover_goods_relation_id not like", value, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdIn(List<String> values) {
            addCriterion("handover_goods_relation_id in", values, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdNotIn(List<String> values) {
            addCriterion("handover_goods_relation_id not in", values, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdBetween(String value1, String value2) {
            addCriterion("handover_goods_relation_id between", value1, value2, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsRelationIdNotBetween(String value1, String value2) {
            addCriterion("handover_goods_relation_id not between", value1, value2, "handoverGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdIsNull() {
            addCriterion("handover_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdIsNotNull() {
            addCriterion("handover_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdEqualTo(String value) {
            addCriterion("handover_goods_id =", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdNotEqualTo(String value) {
            addCriterion("handover_goods_id <>", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdGreaterThan(String value) {
            addCriterion("handover_goods_id >", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("handover_goods_id >=", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdLessThan(String value) {
            addCriterion("handover_goods_id <", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("handover_goods_id <=", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdLike(String value) {
            addCriterion("handover_goods_id like", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdNotLike(String value) {
            addCriterion("handover_goods_id not like", value, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdIn(List<String> values) {
            addCriterion("handover_goods_id in", values, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdNotIn(List<String> values) {
            addCriterion("handover_goods_id not in", values, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdBetween(String value1, String value2) {
            addCriterion("handover_goods_id between", value1, value2, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andHandoverGoodsIdNotBetween(String value1, String value2) {
            addCriterion("handover_goods_id not between", value1, value2, "handoverGoodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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