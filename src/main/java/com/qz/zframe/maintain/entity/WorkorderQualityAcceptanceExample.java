package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderQualityAcceptanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderQualityAcceptanceExample() {
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

        public Criteria andQualityAcceptanceIdIsNull() {
            addCriterion("quality_acceptance_id is null");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdIsNotNull() {
            addCriterion("quality_acceptance_id is not null");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdEqualTo(String value) {
            addCriterion("quality_acceptance_id =", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdNotEqualTo(String value) {
            addCriterion("quality_acceptance_id <>", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdGreaterThan(String value) {
            addCriterion("quality_acceptance_id >", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("quality_acceptance_id >=", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdLessThan(String value) {
            addCriterion("quality_acceptance_id <", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdLessThanOrEqualTo(String value) {
            addCriterion("quality_acceptance_id <=", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdLike(String value) {
            addCriterion("quality_acceptance_id like", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdNotLike(String value) {
            addCriterion("quality_acceptance_id not like", value, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdIn(List<String> values) {
            addCriterion("quality_acceptance_id in", values, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdNotIn(List<String> values) {
            addCriterion("quality_acceptance_id not in", values, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdBetween(String value1, String value2) {
            addCriterion("quality_acceptance_id between", value1, value2, "qualityAcceptanceId");
            return (Criteria) this;
        }

        public Criteria andQualityAcceptanceIdNotBetween(String value1, String value2) {
            addCriterion("quality_acceptance_id not between", value1, value2, "qualityAcceptanceId");
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

        public Criteria andAcceptanceEvaluationIsNull() {
            addCriterion("acceptance_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationIsNotNull() {
            addCriterion("acceptance_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationEqualTo(String value) {
            addCriterion("acceptance_evaluation =", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationNotEqualTo(String value) {
            addCriterion("acceptance_evaluation <>", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationGreaterThan(String value) {
            addCriterion("acceptance_evaluation >", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("acceptance_evaluation >=", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationLessThan(String value) {
            addCriterion("acceptance_evaluation <", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationLessThanOrEqualTo(String value) {
            addCriterion("acceptance_evaluation <=", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationLike(String value) {
            addCriterion("acceptance_evaluation like", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationNotLike(String value) {
            addCriterion("acceptance_evaluation not like", value, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationIn(List<String> values) {
            addCriterion("acceptance_evaluation in", values, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationNotIn(List<String> values) {
            addCriterion("acceptance_evaluation not in", values, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationBetween(String value1, String value2) {
            addCriterion("acceptance_evaluation between", value1, value2, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceEvaluationNotBetween(String value1, String value2) {
            addCriterion("acceptance_evaluation not between", value1, value2, "acceptanceEvaluation");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkIsNull() {
            addCriterion("acceptance_remark is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkIsNotNull() {
            addCriterion("acceptance_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkEqualTo(String value) {
            addCriterion("acceptance_remark =", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkNotEqualTo(String value) {
            addCriterion("acceptance_remark <>", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkGreaterThan(String value) {
            addCriterion("acceptance_remark >", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("acceptance_remark >=", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkLessThan(String value) {
            addCriterion("acceptance_remark <", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkLessThanOrEqualTo(String value) {
            addCriterion("acceptance_remark <=", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkLike(String value) {
            addCriterion("acceptance_remark like", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkNotLike(String value) {
            addCriterion("acceptance_remark not like", value, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkIn(List<String> values) {
            addCriterion("acceptance_remark in", values, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkNotIn(List<String> values) {
            addCriterion("acceptance_remark not in", values, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkBetween(String value1, String value2) {
            addCriterion("acceptance_remark between", value1, value2, "acceptanceRemark");
            return (Criteria) this;
        }

        public Criteria andAcceptanceRemarkNotBetween(String value1, String value2) {
            addCriterion("acceptance_remark not between", value1, value2, "acceptanceRemark");
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