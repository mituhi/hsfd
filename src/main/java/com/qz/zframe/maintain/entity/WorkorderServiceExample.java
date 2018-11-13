package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderServiceExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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

        public Criteria andServiceNumberIsNull() {
            addCriterion("service_number is null");
            return (Criteria) this;
        }

        public Criteria andServiceNumberIsNotNull() {
            addCriterion("service_number is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNumberEqualTo(String value) {
            addCriterion("service_number =", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberNotEqualTo(String value) {
            addCriterion("service_number <>", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberGreaterThan(String value) {
            addCriterion("service_number >", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("service_number >=", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberLessThan(String value) {
            addCriterion("service_number <", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberLessThanOrEqualTo(String value) {
            addCriterion("service_number <=", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberLike(String value) {
            addCriterion("service_number like", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberNotLike(String value) {
            addCriterion("service_number not like", value, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberIn(List<String> values) {
            addCriterion("service_number in", values, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberNotIn(List<String> values) {
            addCriterion("service_number not in", values, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberBetween(String value1, String value2) {
            addCriterion("service_number between", value1, value2, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceNumberNotBetween(String value1, String value2) {
            addCriterion("service_number not between", value1, value2, "serviceNumber");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNull() {
            addCriterion("service_desc is null");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNotNull() {
            addCriterion("service_desc is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDescEqualTo(String value) {
            addCriterion("service_desc =", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotEqualTo(String value) {
            addCriterion("service_desc <>", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThan(String value) {
            addCriterion("service_desc >", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThanOrEqualTo(String value) {
            addCriterion("service_desc >=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThan(String value) {
            addCriterion("service_desc <", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThanOrEqualTo(String value) {
            addCriterion("service_desc <=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLike(String value) {
            addCriterion("service_desc like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotLike(String value) {
            addCriterion("service_desc not like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescIn(List<String> values) {
            addCriterion("service_desc in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotIn(List<String> values) {
            addCriterion("service_desc not in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescBetween(String value1, String value2) {
            addCriterion("service_desc between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotBetween(String value1, String value2) {
            addCriterion("service_desc not between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceUnitIsNull() {
            addCriterion("service_unit is null");
            return (Criteria) this;
        }

        public Criteria andServiceUnitIsNotNull() {
            addCriterion("service_unit is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUnitEqualTo(String value) {
            addCriterion("service_unit =", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitNotEqualTo(String value) {
            addCriterion("service_unit <>", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitGreaterThan(String value) {
            addCriterion("service_unit >", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitGreaterThanOrEqualTo(String value) {
            addCriterion("service_unit >=", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitLessThan(String value) {
            addCriterion("service_unit <", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitLessThanOrEqualTo(String value) {
            addCriterion("service_unit <=", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitLike(String value) {
            addCriterion("service_unit like", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitNotLike(String value) {
            addCriterion("service_unit not like", value, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitIn(List<String> values) {
            addCriterion("service_unit in", values, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitNotIn(List<String> values) {
            addCriterion("service_unit not in", values, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitBetween(String value1, String value2) {
            addCriterion("service_unit between", value1, value2, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServiceUnitNotBetween(String value1, String value2) {
            addCriterion("service_unit not between", value1, value2, "serviceUnit");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountIsNull() {
            addCriterion("service_plan_amount is null");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountIsNotNull() {
            addCriterion("service_plan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountEqualTo(String value) {
            addCriterion("service_plan_amount =", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountNotEqualTo(String value) {
            addCriterion("service_plan_amount <>", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountGreaterThan(String value) {
            addCriterion("service_plan_amount >", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountGreaterThanOrEqualTo(String value) {
            addCriterion("service_plan_amount >=", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountLessThan(String value) {
            addCriterion("service_plan_amount <", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountLessThanOrEqualTo(String value) {
            addCriterion("service_plan_amount <=", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountLike(String value) {
            addCriterion("service_plan_amount like", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountNotLike(String value) {
            addCriterion("service_plan_amount not like", value, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountIn(List<String> values) {
            addCriterion("service_plan_amount in", values, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountNotIn(List<String> values) {
            addCriterion("service_plan_amount not in", values, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountBetween(String value1, String value2) {
            addCriterion("service_plan_amount between", value1, value2, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServicePlanAmountNotBetween(String value1, String value2) {
            addCriterion("service_plan_amount not between", value1, value2, "servicePlanAmount");
            return (Criteria) this;
        }

        public Criteria andServiceCostIsNull() {
            addCriterion("service_cost is null");
            return (Criteria) this;
        }

        public Criteria andServiceCostIsNotNull() {
            addCriterion("service_cost is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCostEqualTo(String value) {
            addCriterion("service_cost =", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostNotEqualTo(String value) {
            addCriterion("service_cost <>", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostGreaterThan(String value) {
            addCriterion("service_cost >", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostGreaterThanOrEqualTo(String value) {
            addCriterion("service_cost >=", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostLessThan(String value) {
            addCriterion("service_cost <", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostLessThanOrEqualTo(String value) {
            addCriterion("service_cost <=", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostLike(String value) {
            addCriterion("service_cost like", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostNotLike(String value) {
            addCriterion("service_cost not like", value, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostIn(List<String> values) {
            addCriterion("service_cost in", values, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostNotIn(List<String> values) {
            addCriterion("service_cost not in", values, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostBetween(String value1, String value2) {
            addCriterion("service_cost between", value1, value2, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceCostNotBetween(String value1, String value2) {
            addCriterion("service_cost not between", value1, value2, "serviceCost");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountIsNull() {
            addCriterion("service_actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountIsNotNull() {
            addCriterion("service_actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountEqualTo(String value) {
            addCriterion("service_actual_amount =", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountNotEqualTo(String value) {
            addCriterion("service_actual_amount <>", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountGreaterThan(String value) {
            addCriterion("service_actual_amount >", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountGreaterThanOrEqualTo(String value) {
            addCriterion("service_actual_amount >=", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountLessThan(String value) {
            addCriterion("service_actual_amount <", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountLessThanOrEqualTo(String value) {
            addCriterion("service_actual_amount <=", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountLike(String value) {
            addCriterion("service_actual_amount like", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountNotLike(String value) {
            addCriterion("service_actual_amount not like", value, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountIn(List<String> values) {
            addCriterion("service_actual_amount in", values, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountNotIn(List<String> values) {
            addCriterion("service_actual_amount not in", values, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountBetween(String value1, String value2) {
            addCriterion("service_actual_amount between", value1, value2, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualAmountNotBetween(String value1, String value2) {
            addCriterion("service_actual_amount not between", value1, value2, "serviceActualAmount");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyIsNull() {
            addCriterion("service_actual_money is null");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyIsNotNull() {
            addCriterion("service_actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyEqualTo(String value) {
            addCriterion("service_actual_money =", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyNotEqualTo(String value) {
            addCriterion("service_actual_money <>", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyGreaterThan(String value) {
            addCriterion("service_actual_money >", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("service_actual_money >=", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyLessThan(String value) {
            addCriterion("service_actual_money <", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyLessThanOrEqualTo(String value) {
            addCriterion("service_actual_money <=", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyLike(String value) {
            addCriterion("service_actual_money like", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyNotLike(String value) {
            addCriterion("service_actual_money not like", value, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyIn(List<String> values) {
            addCriterion("service_actual_money in", values, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyNotIn(List<String> values) {
            addCriterion("service_actual_money not in", values, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyBetween(String value1, String value2) {
            addCriterion("service_actual_money between", value1, value2, "serviceActualMoney");
            return (Criteria) this;
        }

        public Criteria andServiceActualMoneyNotBetween(String value1, String value2) {
            addCriterion("service_actual_money not between", value1, value2, "serviceActualMoney");
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