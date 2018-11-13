package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderMaterialExample() {
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

        public Criteria andWorkorderMaterialIdIsNull() {
            addCriterion("workorder_material_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdIsNotNull() {
            addCriterion("workorder_material_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdEqualTo(String value) {
            addCriterion("workorder_material_id =", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdNotEqualTo(String value) {
            addCriterion("workorder_material_id <>", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdGreaterThan(String value) {
            addCriterion("workorder_material_id >", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_material_id >=", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdLessThan(String value) {
            addCriterion("workorder_material_id <", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("workorder_material_id <=", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdLike(String value) {
            addCriterion("workorder_material_id like", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdNotLike(String value) {
            addCriterion("workorder_material_id not like", value, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdIn(List<String> values) {
            addCriterion("workorder_material_id in", values, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdNotIn(List<String> values) {
            addCriterion("workorder_material_id not in", values, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdBetween(String value1, String value2) {
            addCriterion("workorder_material_id between", value1, value2, "workorderMaterialId");
            return (Criteria) this;
        }

        public Criteria andWorkorderMaterialIdNotBetween(String value1, String value2) {
            addCriterion("workorder_material_id not between", value1, value2, "workorderMaterialId");
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

        public Criteria andMaterialNumberIsNull() {
            addCriterion("material_number is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberIsNotNull() {
            addCriterion("material_number is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberEqualTo(String value) {
            addCriterion("material_number =", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberNotEqualTo(String value) {
            addCriterion("material_number <>", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberGreaterThan(String value) {
            addCriterion("material_number >", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("material_number >=", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberLessThan(String value) {
            addCriterion("material_number <", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberLessThanOrEqualTo(String value) {
            addCriterion("material_number <=", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberLike(String value) {
            addCriterion("material_number like", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberNotLike(String value) {
            addCriterion("material_number not like", value, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberIn(List<String> values) {
            addCriterion("material_number in", values, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberNotIn(List<String> values) {
            addCriterion("material_number not in", values, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberBetween(String value1, String value2) {
            addCriterion("material_number between", value1, value2, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialNumberNotBetween(String value1, String value2) {
            addCriterion("material_number not between", value1, value2, "materialNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialDescIsNull() {
            addCriterion("material_desc is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescIsNotNull() {
            addCriterion("material_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescEqualTo(String value) {
            addCriterion("material_desc =", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescNotEqualTo(String value) {
            addCriterion("material_desc <>", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescGreaterThan(String value) {
            addCriterion("material_desc >", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescGreaterThanOrEqualTo(String value) {
            addCriterion("material_desc >=", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescLessThan(String value) {
            addCriterion("material_desc <", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescLessThanOrEqualTo(String value) {
            addCriterion("material_desc <=", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescLike(String value) {
            addCriterion("material_desc like", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescNotLike(String value) {
            addCriterion("material_desc not like", value, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescIn(List<String> values) {
            addCriterion("material_desc in", values, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescNotIn(List<String> values) {
            addCriterion("material_desc not in", values, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescBetween(String value1, String value2) {
            addCriterion("material_desc between", value1, value2, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialDescNotBetween(String value1, String value2) {
            addCriterion("material_desc not between", value1, value2, "materialDesc");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountIsNull() {
            addCriterion("material_plan_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountIsNotNull() {
            addCriterion("material_plan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountEqualTo(String value) {
            addCriterion("material_plan_amount =", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountNotEqualTo(String value) {
            addCriterion("material_plan_amount <>", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountGreaterThan(String value) {
            addCriterion("material_plan_amount >", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountGreaterThanOrEqualTo(String value) {
            addCriterion("material_plan_amount >=", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountLessThan(String value) {
            addCriterion("material_plan_amount <", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountLessThanOrEqualTo(String value) {
            addCriterion("material_plan_amount <=", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountLike(String value) {
            addCriterion("material_plan_amount like", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountNotLike(String value) {
            addCriterion("material_plan_amount not like", value, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountIn(List<String> values) {
            addCriterion("material_plan_amount in", values, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountNotIn(List<String> values) {
            addCriterion("material_plan_amount not in", values, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountBetween(String value1, String value2) {
            addCriterion("material_plan_amount between", value1, value2, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialPlanAmountNotBetween(String value1, String value2) {
            addCriterion("material_plan_amount not between", value1, value2, "materialPlanAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialCostIsNull() {
            addCriterion("material_cost is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCostIsNotNull() {
            addCriterion("material_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCostEqualTo(String value) {
            addCriterion("material_cost =", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostNotEqualTo(String value) {
            addCriterion("material_cost <>", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostGreaterThan(String value) {
            addCriterion("material_cost >", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostGreaterThanOrEqualTo(String value) {
            addCriterion("material_cost >=", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostLessThan(String value) {
            addCriterion("material_cost <", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostLessThanOrEqualTo(String value) {
            addCriterion("material_cost <=", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostLike(String value) {
            addCriterion("material_cost like", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostNotLike(String value) {
            addCriterion("material_cost not like", value, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostIn(List<String> values) {
            addCriterion("material_cost in", values, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostNotIn(List<String> values) {
            addCriterion("material_cost not in", values, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostBetween(String value1, String value2) {
            addCriterion("material_cost between", value1, value2, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialCostNotBetween(String value1, String value2) {
            addCriterion("material_cost not between", value1, value2, "materialCost");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountIsNull() {
            addCriterion("material_actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountIsNotNull() {
            addCriterion("material_actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountEqualTo(String value) {
            addCriterion("material_actual_amount =", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountNotEqualTo(String value) {
            addCriterion("material_actual_amount <>", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountGreaterThan(String value) {
            addCriterion("material_actual_amount >", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountGreaterThanOrEqualTo(String value) {
            addCriterion("material_actual_amount >=", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountLessThan(String value) {
            addCriterion("material_actual_amount <", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountLessThanOrEqualTo(String value) {
            addCriterion("material_actual_amount <=", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountLike(String value) {
            addCriterion("material_actual_amount like", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountNotLike(String value) {
            addCriterion("material_actual_amount not like", value, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountIn(List<String> values) {
            addCriterion("material_actual_amount in", values, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountNotIn(List<String> values) {
            addCriterion("material_actual_amount not in", values, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountBetween(String value1, String value2) {
            addCriterion("material_actual_amount between", value1, value2, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualAmountNotBetween(String value1, String value2) {
            addCriterion("material_actual_amount not between", value1, value2, "materialActualAmount");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyIsNull() {
            addCriterion("material_actual_money is null");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyIsNotNull() {
            addCriterion("material_actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyEqualTo(String value) {
            addCriterion("material_actual_money =", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyNotEqualTo(String value) {
            addCriterion("material_actual_money <>", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyGreaterThan(String value) {
            addCriterion("material_actual_money >", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("material_actual_money >=", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyLessThan(String value) {
            addCriterion("material_actual_money <", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyLessThanOrEqualTo(String value) {
            addCriterion("material_actual_money <=", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyLike(String value) {
            addCriterion("material_actual_money like", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyNotLike(String value) {
            addCriterion("material_actual_money not like", value, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyIn(List<String> values) {
            addCriterion("material_actual_money in", values, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyNotIn(List<String> values) {
            addCriterion("material_actual_money not in", values, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyBetween(String value1, String value2) {
            addCriterion("material_actual_money between", value1, value2, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialActualMoneyNotBetween(String value1, String value2) {
            addCriterion("material_actual_money not between", value1, value2, "materialActualMoney");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameIsNull() {
            addCriterion("material_wind_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameIsNotNull() {
            addCriterion("material_wind_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameEqualTo(String value) {
            addCriterion("material_wind_name =", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameNotEqualTo(String value) {
            addCriterion("material_wind_name <>", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameGreaterThan(String value) {
            addCriterion("material_wind_name >", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_wind_name >=", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameLessThan(String value) {
            addCriterion("material_wind_name <", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameLessThanOrEqualTo(String value) {
            addCriterion("material_wind_name <=", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameLike(String value) {
            addCriterion("material_wind_name like", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameNotLike(String value) {
            addCriterion("material_wind_name not like", value, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameIn(List<String> values) {
            addCriterion("material_wind_name in", values, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameNotIn(List<String> values) {
            addCriterion("material_wind_name not in", values, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameBetween(String value1, String value2) {
            addCriterion("material_wind_name between", value1, value2, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andMaterialWindNameNotBetween(String value1, String value2) {
            addCriterion("material_wind_name not between", value1, value2, "materialWindName");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialIsNull() {
            addCriterion("final_receive_material is null");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialIsNotNull() {
            addCriterion("final_receive_material is not null");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialEqualTo(String value) {
            addCriterion("final_receive_material =", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialNotEqualTo(String value) {
            addCriterion("final_receive_material <>", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialGreaterThan(String value) {
            addCriterion("final_receive_material >", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("final_receive_material >=", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialLessThan(String value) {
            addCriterion("final_receive_material <", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialLessThanOrEqualTo(String value) {
            addCriterion("final_receive_material <=", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialLike(String value) {
            addCriterion("final_receive_material like", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialNotLike(String value) {
            addCriterion("final_receive_material not like", value, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialIn(List<String> values) {
            addCriterion("final_receive_material in", values, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialNotIn(List<String> values) {
            addCriterion("final_receive_material not in", values, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialBetween(String value1, String value2) {
            addCriterion("final_receive_material between", value1, value2, "finalReceiveMaterial");
            return (Criteria) this;
        }

        public Criteria andFinalReceiveMaterialNotBetween(String value1, String value2) {
            addCriterion("final_receive_material not between", value1, value2, "finalReceiveMaterial");
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