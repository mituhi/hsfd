package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderProcessExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("process_id like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("process_id not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("process_id not between", value1, value2, "processId");
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

        public Criteria andProcessNumberIsNull() {
            addCriterion("process_number is null");
            return (Criteria) this;
        }

        public Criteria andProcessNumberIsNotNull() {
            addCriterion("process_number is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNumberEqualTo(String value) {
            addCriterion("process_number =", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotEqualTo(String value) {
            addCriterion("process_number <>", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberGreaterThan(String value) {
            addCriterion("process_number >", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberGreaterThanOrEqualTo(String value) {
            addCriterion("process_number >=", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberLessThan(String value) {
            addCriterion("process_number <", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberLessThanOrEqualTo(String value) {
            addCriterion("process_number <=", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberLike(String value) {
            addCriterion("process_number like", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotLike(String value) {
            addCriterion("process_number not like", value, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberIn(List<String> values) {
            addCriterion("process_number in", values, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotIn(List<String> values) {
            addCriterion("process_number not in", values, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberBetween(String value1, String value2) {
            addCriterion("process_number between", value1, value2, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessNumberNotBetween(String value1, String value2) {
            addCriterion("process_number not between", value1, value2, "processNumber");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNull() {
            addCriterion("process_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessDescIsNotNull() {
            addCriterion("process_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDescEqualTo(String value) {
            addCriterion("process_desc =", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotEqualTo(String value) {
            addCriterion("process_desc <>", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThan(String value) {
            addCriterion("process_desc >", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("process_desc >=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThan(String value) {
            addCriterion("process_desc <", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLessThanOrEqualTo(String value) {
            addCriterion("process_desc <=", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescLike(String value) {
            addCriterion("process_desc like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotLike(String value) {
            addCriterion("process_desc not like", value, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescIn(List<String> values) {
            addCriterion("process_desc in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotIn(List<String> values) {
            addCriterion("process_desc not in", values, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescBetween(String value1, String value2) {
            addCriterion("process_desc between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessDescNotBetween(String value1, String value2) {
            addCriterion("process_desc not between", value1, value2, "processDesc");
            return (Criteria) this;
        }

        public Criteria andProcessExternalIsNull() {
            addCriterion("process_external is null");
            return (Criteria) this;
        }

        public Criteria andProcessExternalIsNotNull() {
            addCriterion("process_external is not null");
            return (Criteria) this;
        }

        public Criteria andProcessExternalEqualTo(String value) {
            addCriterion("process_external =", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalNotEqualTo(String value) {
            addCriterion("process_external <>", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalGreaterThan(String value) {
            addCriterion("process_external >", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalGreaterThanOrEqualTo(String value) {
            addCriterion("process_external >=", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalLessThan(String value) {
            addCriterion("process_external <", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalLessThanOrEqualTo(String value) {
            addCriterion("process_external <=", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalLike(String value) {
            addCriterion("process_external like", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalNotLike(String value) {
            addCriterion("process_external not like", value, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalIn(List<String> values) {
            addCriterion("process_external in", values, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalNotIn(List<String> values) {
            addCriterion("process_external not in", values, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalBetween(String value1, String value2) {
            addCriterion("process_external between", value1, value2, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessExternalNotBetween(String value1, String value2) {
            addCriterion("process_external not between", value1, value2, "processExternal");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursIsNull() {
            addCriterion("process_plan_work_hours is null");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursIsNotNull() {
            addCriterion("process_plan_work_hours is not null");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursEqualTo(String value) {
            addCriterion("process_plan_work_hours =", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursNotEqualTo(String value) {
            addCriterion("process_plan_work_hours <>", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursGreaterThan(String value) {
            addCriterion("process_plan_work_hours >", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursGreaterThanOrEqualTo(String value) {
            addCriterion("process_plan_work_hours >=", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursLessThan(String value) {
            addCriterion("process_plan_work_hours <", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursLessThanOrEqualTo(String value) {
            addCriterion("process_plan_work_hours <=", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursLike(String value) {
            addCriterion("process_plan_work_hours like", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursNotLike(String value) {
            addCriterion("process_plan_work_hours not like", value, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursIn(List<String> values) {
            addCriterion("process_plan_work_hours in", values, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursNotIn(List<String> values) {
            addCriterion("process_plan_work_hours not in", values, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursBetween(String value1, String value2) {
            addCriterion("process_plan_work_hours between", value1, value2, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanWorkHoursNotBetween(String value1, String value2) {
            addCriterion("process_plan_work_hours not between", value1, value2, "processPlanWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumIsNull() {
            addCriterion("process_plan_person_num is null");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumIsNotNull() {
            addCriterion("process_plan_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumEqualTo(String value) {
            addCriterion("process_plan_person_num =", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumNotEqualTo(String value) {
            addCriterion("process_plan_person_num <>", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumGreaterThan(String value) {
            addCriterion("process_plan_person_num >", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumGreaterThanOrEqualTo(String value) {
            addCriterion("process_plan_person_num >=", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumLessThan(String value) {
            addCriterion("process_plan_person_num <", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumLessThanOrEqualTo(String value) {
            addCriterion("process_plan_person_num <=", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumLike(String value) {
            addCriterion("process_plan_person_num like", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumNotLike(String value) {
            addCriterion("process_plan_person_num not like", value, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumIn(List<String> values) {
            addCriterion("process_plan_person_num in", values, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumNotIn(List<String> values) {
            addCriterion("process_plan_person_num not in", values, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumBetween(String value1, String value2) {
            addCriterion("process_plan_person_num between", value1, value2, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessPlanPersonNumNotBetween(String value1, String value2) {
            addCriterion("process_plan_person_num not between", value1, value2, "processPlanPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursIsNull() {
            addCriterion("process_actual_work_hours is null");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursIsNotNull() {
            addCriterion("process_actual_work_hours is not null");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursEqualTo(String value) {
            addCriterion("process_actual_work_hours =", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursNotEqualTo(String value) {
            addCriterion("process_actual_work_hours <>", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursGreaterThan(String value) {
            addCriterion("process_actual_work_hours >", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursGreaterThanOrEqualTo(String value) {
            addCriterion("process_actual_work_hours >=", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursLessThan(String value) {
            addCriterion("process_actual_work_hours <", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursLessThanOrEqualTo(String value) {
            addCriterion("process_actual_work_hours <=", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursLike(String value) {
            addCriterion("process_actual_work_hours like", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursNotLike(String value) {
            addCriterion("process_actual_work_hours not like", value, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursIn(List<String> values) {
            addCriterion("process_actual_work_hours in", values, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursNotIn(List<String> values) {
            addCriterion("process_actual_work_hours not in", values, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursBetween(String value1, String value2) {
            addCriterion("process_actual_work_hours between", value1, value2, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualWorkHoursNotBetween(String value1, String value2) {
            addCriterion("process_actual_work_hours not between", value1, value2, "processActualWorkHours");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumIsNull() {
            addCriterion("process_actual_person_num is null");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumIsNotNull() {
            addCriterion("process_actual_person_num is not null");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumEqualTo(String value) {
            addCriterion("process_actual_person_num =", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumNotEqualTo(String value) {
            addCriterion("process_actual_person_num <>", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumGreaterThan(String value) {
            addCriterion("process_actual_person_num >", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumGreaterThanOrEqualTo(String value) {
            addCriterion("process_actual_person_num >=", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumLessThan(String value) {
            addCriterion("process_actual_person_num <", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumLessThanOrEqualTo(String value) {
            addCriterion("process_actual_person_num <=", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumLike(String value) {
            addCriterion("process_actual_person_num like", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumNotLike(String value) {
            addCriterion("process_actual_person_num not like", value, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumIn(List<String> values) {
            addCriterion("process_actual_person_num in", values, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumNotIn(List<String> values) {
            addCriterion("process_actual_person_num not in", values, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumBetween(String value1, String value2) {
            addCriterion("process_actual_person_num between", value1, value2, "processActualPersonNum");
            return (Criteria) this;
        }

        public Criteria andProcessActualPersonNumNotBetween(String value1, String value2) {
            addCriterion("process_actual_person_num not between", value1, value2, "processActualPersonNum");
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