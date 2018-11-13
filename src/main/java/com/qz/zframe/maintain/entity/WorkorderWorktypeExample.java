package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderWorktypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderWorktypeExample() {
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

        public Criteria andWorktypeIdIsNull() {
            addCriterion("worktype_id is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdIsNotNull() {
            addCriterion("worktype_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdEqualTo(String value) {
            addCriterion("worktype_id =", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdNotEqualTo(String value) {
            addCriterion("worktype_id <>", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdGreaterThan(String value) {
            addCriterion("worktype_id >", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_id >=", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdLessThan(String value) {
            addCriterion("worktype_id <", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdLessThanOrEqualTo(String value) {
            addCriterion("worktype_id <=", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdLike(String value) {
            addCriterion("worktype_id like", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdNotLike(String value) {
            addCriterion("worktype_id not like", value, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdIn(List<String> values) {
            addCriterion("worktype_id in", values, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdNotIn(List<String> values) {
            addCriterion("worktype_id not in", values, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdBetween(String value1, String value2) {
            addCriterion("worktype_id between", value1, value2, "worktypeId");
            return (Criteria) this;
        }

        public Criteria andWorktypeIdNotBetween(String value1, String value2) {
            addCriterion("worktype_id not between", value1, value2, "worktypeId");
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

        public Criteria andWorktypeNumberIsNull() {
            addCriterion("worktype_number is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberIsNotNull() {
            addCriterion("worktype_number is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberEqualTo(String value) {
            addCriterion("worktype_number =", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberNotEqualTo(String value) {
            addCriterion("worktype_number <>", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberGreaterThan(String value) {
            addCriterion("worktype_number >", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_number >=", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberLessThan(String value) {
            addCriterion("worktype_number <", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberLessThanOrEqualTo(String value) {
            addCriterion("worktype_number <=", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberLike(String value) {
            addCriterion("worktype_number like", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberNotLike(String value) {
            addCriterion("worktype_number not like", value, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberIn(List<String> values) {
            addCriterion("worktype_number in", values, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberNotIn(List<String> values) {
            addCriterion("worktype_number not in", values, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberBetween(String value1, String value2) {
            addCriterion("worktype_number between", value1, value2, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNumberNotBetween(String value1, String value2) {
            addCriterion("worktype_number not between", value1, value2, "worktypeNumber");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameIsNull() {
            addCriterion("worktype_name is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameIsNotNull() {
            addCriterion("worktype_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameEqualTo(String value) {
            addCriterion("worktype_name =", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameNotEqualTo(String value) {
            addCriterion("worktype_name <>", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameGreaterThan(String value) {
            addCriterion("worktype_name >", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_name >=", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameLessThan(String value) {
            addCriterion("worktype_name <", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameLessThanOrEqualTo(String value) {
            addCriterion("worktype_name <=", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameLike(String value) {
            addCriterion("worktype_name like", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameNotLike(String value) {
            addCriterion("worktype_name not like", value, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameIn(List<String> values) {
            addCriterion("worktype_name in", values, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameNotIn(List<String> values) {
            addCriterion("worktype_name not in", values, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameBetween(String value1, String value2) {
            addCriterion("worktype_name between", value1, value2, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNameNotBetween(String value1, String value2) {
            addCriterion("worktype_name not between", value1, value2, "worktypeName");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumIsNull() {
            addCriterion("worktype_need_num is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumIsNotNull() {
            addCriterion("worktype_need_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumEqualTo(String value) {
            addCriterion("worktype_need_num =", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumNotEqualTo(String value) {
            addCriterion("worktype_need_num <>", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumGreaterThan(String value) {
            addCriterion("worktype_need_num >", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_need_num >=", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumLessThan(String value) {
            addCriterion("worktype_need_num <", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumLessThanOrEqualTo(String value) {
            addCriterion("worktype_need_num <=", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumLike(String value) {
            addCriterion("worktype_need_num like", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumNotLike(String value) {
            addCriterion("worktype_need_num not like", value, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumIn(List<String> values) {
            addCriterion("worktype_need_num in", values, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumNotIn(List<String> values) {
            addCriterion("worktype_need_num not in", values, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumBetween(String value1, String value2) {
            addCriterion("worktype_need_num between", value1, value2, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypeNeedNumNotBetween(String value1, String value2) {
            addCriterion("worktype_need_num not between", value1, value2, "worktypeNeedNum");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeIsNull() {
            addCriterion("worktype_plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeIsNotNull() {
            addCriterion("worktype_plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeEqualTo(Date value) {
            addCriterion("worktype_plan_start_time =", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeNotEqualTo(Date value) {
            addCriterion("worktype_plan_start_time <>", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeGreaterThan(Date value) {
            addCriterion("worktype_plan_start_time >", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("worktype_plan_start_time >=", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeLessThan(Date value) {
            addCriterion("worktype_plan_start_time <", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("worktype_plan_start_time <=", value, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeIn(List<Date> values) {
            addCriterion("worktype_plan_start_time in", values, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeNotIn(List<Date> values) {
            addCriterion("worktype_plan_start_time not in", values, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("worktype_plan_start_time between", value1, value2, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("worktype_plan_start_time not between", value1, value2, "worktypePlanStartTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeIsNull() {
            addCriterion("worktype_plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeIsNotNull() {
            addCriterion("worktype_plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeEqualTo(Date value) {
            addCriterion("worktype_plan_end_time =", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeNotEqualTo(Date value) {
            addCriterion("worktype_plan_end_time <>", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeGreaterThan(Date value) {
            addCriterion("worktype_plan_end_time >", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("worktype_plan_end_time >=", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeLessThan(Date value) {
            addCriterion("worktype_plan_end_time <", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("worktype_plan_end_time <=", value, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeIn(List<Date> values) {
            addCriterion("worktype_plan_end_time in", values, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeNotIn(List<Date> values) {
            addCriterion("worktype_plan_end_time not in", values, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("worktype_plan_end_time between", value1, value2, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("worktype_plan_end_time not between", value1, value2, "worktypePlanEndTime");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateIsNull() {
            addCriterion("worktype_standard_rate is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateIsNotNull() {
            addCriterion("worktype_standard_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateEqualTo(String value) {
            addCriterion("worktype_standard_rate =", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateNotEqualTo(String value) {
            addCriterion("worktype_standard_rate <>", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateGreaterThan(String value) {
            addCriterion("worktype_standard_rate >", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_standard_rate >=", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateLessThan(String value) {
            addCriterion("worktype_standard_rate <", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateLessThanOrEqualTo(String value) {
            addCriterion("worktype_standard_rate <=", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateLike(String value) {
            addCriterion("worktype_standard_rate like", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateNotLike(String value) {
            addCriterion("worktype_standard_rate not like", value, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateIn(List<String> values) {
            addCriterion("worktype_standard_rate in", values, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateNotIn(List<String> values) {
            addCriterion("worktype_standard_rate not in", values, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateBetween(String value1, String value2) {
            addCriterion("worktype_standard_rate between", value1, value2, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypeStandardRateNotBetween(String value1, String value2) {
            addCriterion("worktype_standard_rate not between", value1, value2, "worktypeStandardRate");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourIsNull() {
            addCriterion("worktype_plan_use_hour is null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourIsNotNull() {
            addCriterion("worktype_plan_use_hour is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourEqualTo(String value) {
            addCriterion("worktype_plan_use_hour =", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourNotEqualTo(String value) {
            addCriterion("worktype_plan_use_hour <>", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourGreaterThan(String value) {
            addCriterion("worktype_plan_use_hour >", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_plan_use_hour >=", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourLessThan(String value) {
            addCriterion("worktype_plan_use_hour <", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourLessThanOrEqualTo(String value) {
            addCriterion("worktype_plan_use_hour <=", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourLike(String value) {
            addCriterion("worktype_plan_use_hour like", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourNotLike(String value) {
            addCriterion("worktype_plan_use_hour not like", value, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourIn(List<String> values) {
            addCriterion("worktype_plan_use_hour in", values, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourNotIn(List<String> values) {
            addCriterion("worktype_plan_use_hour not in", values, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourBetween(String value1, String value2) {
            addCriterion("worktype_plan_use_hour between", value1, value2, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanUseHourNotBetween(String value1, String value2) {
            addCriterion("worktype_plan_use_hour not between", value1, value2, "worktypePlanUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeIsNull() {
            addCriterion("worktype_plan_fee is null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeIsNotNull() {
            addCriterion("worktype_plan_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeEqualTo(String value) {
            addCriterion("worktype_plan_fee =", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeNotEqualTo(String value) {
            addCriterion("worktype_plan_fee <>", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeGreaterThan(String value) {
            addCriterion("worktype_plan_fee >", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_plan_fee >=", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeLessThan(String value) {
            addCriterion("worktype_plan_fee <", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeLessThanOrEqualTo(String value) {
            addCriterion("worktype_plan_fee <=", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeLike(String value) {
            addCriterion("worktype_plan_fee like", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeNotLike(String value) {
            addCriterion("worktype_plan_fee not like", value, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeIn(List<String> values) {
            addCriterion("worktype_plan_fee in", values, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeNotIn(List<String> values) {
            addCriterion("worktype_plan_fee not in", values, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeBetween(String value1, String value2) {
            addCriterion("worktype_plan_fee between", value1, value2, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypePlanFeeNotBetween(String value1, String value2) {
            addCriterion("worktype_plan_fee not between", value1, value2, "worktypePlanFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourIsNull() {
            addCriterion("worktype_actual_use_hour is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourIsNotNull() {
            addCriterion("worktype_actual_use_hour is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourEqualTo(String value) {
            addCriterion("worktype_actual_use_hour =", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourNotEqualTo(String value) {
            addCriterion("worktype_actual_use_hour <>", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourGreaterThan(String value) {
            addCriterion("worktype_actual_use_hour >", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_actual_use_hour >=", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourLessThan(String value) {
            addCriterion("worktype_actual_use_hour <", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourLessThanOrEqualTo(String value) {
            addCriterion("worktype_actual_use_hour <=", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourLike(String value) {
            addCriterion("worktype_actual_use_hour like", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourNotLike(String value) {
            addCriterion("worktype_actual_use_hour not like", value, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourIn(List<String> values) {
            addCriterion("worktype_actual_use_hour in", values, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourNotIn(List<String> values) {
            addCriterion("worktype_actual_use_hour not in", values, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourBetween(String value1, String value2) {
            addCriterion("worktype_actual_use_hour between", value1, value2, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualUseHourNotBetween(String value1, String value2) {
            addCriterion("worktype_actual_use_hour not between", value1, value2, "worktypeActualUseHour");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeIsNull() {
            addCriterion("worktype_actual_fee is null");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeIsNotNull() {
            addCriterion("worktype_actual_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeEqualTo(String value) {
            addCriterion("worktype_actual_fee =", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeNotEqualTo(String value) {
            addCriterion("worktype_actual_fee <>", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeGreaterThan(String value) {
            addCriterion("worktype_actual_fee >", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeGreaterThanOrEqualTo(String value) {
            addCriterion("worktype_actual_fee >=", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeLessThan(String value) {
            addCriterion("worktype_actual_fee <", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeLessThanOrEqualTo(String value) {
            addCriterion("worktype_actual_fee <=", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeLike(String value) {
            addCriterion("worktype_actual_fee like", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeNotLike(String value) {
            addCriterion("worktype_actual_fee not like", value, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeIn(List<String> values) {
            addCriterion("worktype_actual_fee in", values, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeNotIn(List<String> values) {
            addCriterion("worktype_actual_fee not in", values, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeBetween(String value1, String value2) {
            addCriterion("worktype_actual_fee between", value1, value2, "worktypeActualFee");
            return (Criteria) this;
        }

        public Criteria andWorktypeActualFeeNotBetween(String value1, String value2) {
            addCriterion("worktype_actual_fee not between", value1, value2, "worktypeActualFee");
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