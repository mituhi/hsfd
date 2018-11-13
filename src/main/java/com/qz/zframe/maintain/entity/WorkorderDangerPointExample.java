package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderDangerPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderDangerPointExample() {
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

        public Criteria andDangerPointIdIsNull() {
            addCriterion("danger_point_id is null");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdIsNotNull() {
            addCriterion("danger_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdEqualTo(String value) {
            addCriterion("danger_point_id =", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdNotEqualTo(String value) {
            addCriterion("danger_point_id <>", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdGreaterThan(String value) {
            addCriterion("danger_point_id >", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("danger_point_id >=", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdLessThan(String value) {
            addCriterion("danger_point_id <", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdLessThanOrEqualTo(String value) {
            addCriterion("danger_point_id <=", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdLike(String value) {
            addCriterion("danger_point_id like", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdNotLike(String value) {
            addCriterion("danger_point_id not like", value, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdIn(List<String> values) {
            addCriterion("danger_point_id in", values, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdNotIn(List<String> values) {
            addCriterion("danger_point_id not in", values, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdBetween(String value1, String value2) {
            addCriterion("danger_point_id between", value1, value2, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andDangerPointIdNotBetween(String value1, String value2) {
            addCriterion("danger_point_id not between", value1, value2, "dangerPointId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIsNull() {
            addCriterion("workorder_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIsNotNull() {
            addCriterion("workorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdEqualTo(String value) {
            addCriterion("workorder_id =", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotEqualTo(String value) {
            addCriterion("workorder_id <>", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThan(String value) {
            addCriterion("workorder_id >", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_id >=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThan(String value) {
            addCriterion("workorder_id <", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThanOrEqualTo(String value) {
            addCriterion("workorder_id <=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLike(String value) {
            addCriterion("workorder_id like", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotLike(String value) {
            addCriterion("workorder_id not like", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIn(List<String> values) {
            addCriterion("workorder_id in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotIn(List<String> values) {
            addCriterion("workorder_id not in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdBetween(String value1, String value2) {
            addCriterion("workorder_id between", value1, value2, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotBetween(String value1, String value2) {
            addCriterion("workorder_id not between", value1, value2, "workorderId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNull() {
            addCriterion("knowledge_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNotNull() {
            addCriterion("knowledge_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdEqualTo(String value) {
            addCriterion("knowledge_id =", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotEqualTo(String value) {
            addCriterion("knowledge_id <>", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThan(String value) {
            addCriterion("knowledge_id >", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_id >=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThan(String value) {
            addCriterion("knowledge_id <", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThanOrEqualTo(String value) {
            addCriterion("knowledge_id <=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLike(String value) {
            addCriterion("knowledge_id like", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotLike(String value) {
            addCriterion("knowledge_id not like", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIn(List<String> values) {
            addCriterion("knowledge_id in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotIn(List<String> values) {
            addCriterion("knowledge_id not in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdBetween(String value1, String value2) {
            addCriterion("knowledge_id between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotBetween(String value1, String value2) {
            addCriterion("knowledge_id not between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andDangerNumberIsNull() {
            addCriterion("danger_number is null");
            return (Criteria) this;
        }

        public Criteria andDangerNumberIsNotNull() {
            addCriterion("danger_number is not null");
            return (Criteria) this;
        }

        public Criteria andDangerNumberEqualTo(String value) {
            addCriterion("danger_number =", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberNotEqualTo(String value) {
            addCriterion("danger_number <>", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberGreaterThan(String value) {
            addCriterion("danger_number >", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("danger_number >=", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberLessThan(String value) {
            addCriterion("danger_number <", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberLessThanOrEqualTo(String value) {
            addCriterion("danger_number <=", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberLike(String value) {
            addCriterion("danger_number like", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberNotLike(String value) {
            addCriterion("danger_number not like", value, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberIn(List<String> values) {
            addCriterion("danger_number in", values, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberNotIn(List<String> values) {
            addCriterion("danger_number not in", values, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberBetween(String value1, String value2) {
            addCriterion("danger_number between", value1, value2, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerNumberNotBetween(String value1, String value2) {
            addCriterion("danger_number not between", value1, value2, "dangerNumber");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceIsNull() {
            addCriterion("danger_danger_source is null");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceIsNotNull() {
            addCriterion("danger_danger_source is not null");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceEqualTo(String value) {
            addCriterion("danger_danger_source =", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceNotEqualTo(String value) {
            addCriterion("danger_danger_source <>", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceGreaterThan(String value) {
            addCriterion("danger_danger_source >", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceGreaterThanOrEqualTo(String value) {
            addCriterion("danger_danger_source >=", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceLessThan(String value) {
            addCriterion("danger_danger_source <", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceLessThanOrEqualTo(String value) {
            addCriterion("danger_danger_source <=", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceLike(String value) {
            addCriterion("danger_danger_source like", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceNotLike(String value) {
            addCriterion("danger_danger_source not like", value, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceIn(List<String> values) {
            addCriterion("danger_danger_source in", values, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceNotIn(List<String> values) {
            addCriterion("danger_danger_source not in", values, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceBetween(String value1, String value2) {
            addCriterion("danger_danger_source between", value1, value2, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerDangerSourceNotBetween(String value1, String value2) {
            addCriterion("danger_danger_source not between", value1, value2, "dangerDangerSource");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresIsNull() {
            addCriterion("danger_pre_measures is null");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresIsNotNull() {
            addCriterion("danger_pre_measures is not null");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresEqualTo(String value) {
            addCriterion("danger_pre_measures =", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresNotEqualTo(String value) {
            addCriterion("danger_pre_measures <>", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresGreaterThan(String value) {
            addCriterion("danger_pre_measures >", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("danger_pre_measures >=", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresLessThan(String value) {
            addCriterion("danger_pre_measures <", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresLessThanOrEqualTo(String value) {
            addCriterion("danger_pre_measures <=", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresLike(String value) {
            addCriterion("danger_pre_measures like", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresNotLike(String value) {
            addCriterion("danger_pre_measures not like", value, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresIn(List<String> values) {
            addCriterion("danger_pre_measures in", values, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresNotIn(List<String> values) {
            addCriterion("danger_pre_measures not in", values, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresBetween(String value1, String value2) {
            addCriterion("danger_pre_measures between", value1, value2, "dangerPreMeasures");
            return (Criteria) this;
        }

        public Criteria andDangerPreMeasuresNotBetween(String value1, String value2) {
            addCriterion("danger_pre_measures not between", value1, value2, "dangerPreMeasures");
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