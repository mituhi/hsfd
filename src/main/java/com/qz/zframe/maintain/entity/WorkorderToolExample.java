package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderToolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderToolExample() {
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

        public Criteria andToolIdIsNull() {
            addCriterion("tool_id is null");
            return (Criteria) this;
        }

        public Criteria andToolIdIsNotNull() {
            addCriterion("tool_id is not null");
            return (Criteria) this;
        }

        public Criteria andToolIdEqualTo(String value) {
            addCriterion("tool_id =", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotEqualTo(String value) {
            addCriterion("tool_id <>", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdGreaterThan(String value) {
            addCriterion("tool_id >", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdGreaterThanOrEqualTo(String value) {
            addCriterion("tool_id >=", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdLessThan(String value) {
            addCriterion("tool_id <", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdLessThanOrEqualTo(String value) {
            addCriterion("tool_id <=", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdLike(String value) {
            addCriterion("tool_id like", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotLike(String value) {
            addCriterion("tool_id not like", value, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdIn(List<String> values) {
            addCriterion("tool_id in", values, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotIn(List<String> values) {
            addCriterion("tool_id not in", values, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdBetween(String value1, String value2) {
            addCriterion("tool_id between", value1, value2, "toolId");
            return (Criteria) this;
        }

        public Criteria andToolIdNotBetween(String value1, String value2) {
            addCriterion("tool_id not between", value1, value2, "toolId");
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

        public Criteria andToolNumberIsNull() {
            addCriterion("tool_number is null");
            return (Criteria) this;
        }

        public Criteria andToolNumberIsNotNull() {
            addCriterion("tool_number is not null");
            return (Criteria) this;
        }

        public Criteria andToolNumberEqualTo(String value) {
            addCriterion("tool_number =", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotEqualTo(String value) {
            addCriterion("tool_number <>", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberGreaterThan(String value) {
            addCriterion("tool_number >", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tool_number >=", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLessThan(String value) {
            addCriterion("tool_number <", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLessThanOrEqualTo(String value) {
            addCriterion("tool_number <=", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberLike(String value) {
            addCriterion("tool_number like", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotLike(String value) {
            addCriterion("tool_number not like", value, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberIn(List<String> values) {
            addCriterion("tool_number in", values, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotIn(List<String> values) {
            addCriterion("tool_number not in", values, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberBetween(String value1, String value2) {
            addCriterion("tool_number between", value1, value2, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolNumberNotBetween(String value1, String value2) {
            addCriterion("tool_number not between", value1, value2, "toolNumber");
            return (Criteria) this;
        }

        public Criteria andToolDescIsNull() {
            addCriterion("tool_desc is null");
            return (Criteria) this;
        }

        public Criteria andToolDescIsNotNull() {
            addCriterion("tool_desc is not null");
            return (Criteria) this;
        }

        public Criteria andToolDescEqualTo(String value) {
            addCriterion("tool_desc =", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescNotEqualTo(String value) {
            addCriterion("tool_desc <>", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescGreaterThan(String value) {
            addCriterion("tool_desc >", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescGreaterThanOrEqualTo(String value) {
            addCriterion("tool_desc >=", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescLessThan(String value) {
            addCriterion("tool_desc <", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescLessThanOrEqualTo(String value) {
            addCriterion("tool_desc <=", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescLike(String value) {
            addCriterion("tool_desc like", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescNotLike(String value) {
            addCriterion("tool_desc not like", value, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescIn(List<String> values) {
            addCriterion("tool_desc in", values, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescNotIn(List<String> values) {
            addCriterion("tool_desc not in", values, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescBetween(String value1, String value2) {
            addCriterion("tool_desc between", value1, value2, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolDescNotBetween(String value1, String value2) {
            addCriterion("tool_desc not between", value1, value2, "toolDesc");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountIsNull() {
            addCriterion("tool_plan_amount is null");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountIsNotNull() {
            addCriterion("tool_plan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountEqualTo(String value) {
            addCriterion("tool_plan_amount =", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountNotEqualTo(String value) {
            addCriterion("tool_plan_amount <>", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountGreaterThan(String value) {
            addCriterion("tool_plan_amount >", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountGreaterThanOrEqualTo(String value) {
            addCriterion("tool_plan_amount >=", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountLessThan(String value) {
            addCriterion("tool_plan_amount <", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountLessThanOrEqualTo(String value) {
            addCriterion("tool_plan_amount <=", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountLike(String value) {
            addCriterion("tool_plan_amount like", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountNotLike(String value) {
            addCriterion("tool_plan_amount not like", value, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountIn(List<String> values) {
            addCriterion("tool_plan_amount in", values, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountNotIn(List<String> values) {
            addCriterion("tool_plan_amount not in", values, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountBetween(String value1, String value2) {
            addCriterion("tool_plan_amount between", value1, value2, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolPlanAmountNotBetween(String value1, String value2) {
            addCriterion("tool_plan_amount not between", value1, value2, "toolPlanAmount");
            return (Criteria) this;
        }

        public Criteria andToolUnitIsNull() {
            addCriterion("tool_unit is null");
            return (Criteria) this;
        }

        public Criteria andToolUnitIsNotNull() {
            addCriterion("tool_unit is not null");
            return (Criteria) this;
        }

        public Criteria andToolUnitEqualTo(String value) {
            addCriterion("tool_unit =", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitNotEqualTo(String value) {
            addCriterion("tool_unit <>", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitGreaterThan(String value) {
            addCriterion("tool_unit >", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitGreaterThanOrEqualTo(String value) {
            addCriterion("tool_unit >=", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitLessThan(String value) {
            addCriterion("tool_unit <", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitLessThanOrEqualTo(String value) {
            addCriterion("tool_unit <=", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitLike(String value) {
            addCriterion("tool_unit like", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitNotLike(String value) {
            addCriterion("tool_unit not like", value, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitIn(List<String> values) {
            addCriterion("tool_unit in", values, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitNotIn(List<String> values) {
            addCriterion("tool_unit not in", values, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitBetween(String value1, String value2) {
            addCriterion("tool_unit between", value1, value2, "toolUnit");
            return (Criteria) this;
        }

        public Criteria andToolUnitNotBetween(String value1, String value2) {
            addCriterion("tool_unit not between", value1, value2, "toolUnit");
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