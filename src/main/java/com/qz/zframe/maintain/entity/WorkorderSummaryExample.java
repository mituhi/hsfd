package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkorderSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderSummaryExample() {
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

        public Criteria andSummaryIdIsNull() {
            addCriterion("summary_id is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIdIsNotNull() {
            addCriterion("summary_id is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryIdEqualTo(String value) {
            addCriterion("summary_id =", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdNotEqualTo(String value) {
            addCriterion("summary_id <>", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdGreaterThan(String value) {
            addCriterion("summary_id >", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("summary_id >=", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdLessThan(String value) {
            addCriterion("summary_id <", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdLessThanOrEqualTo(String value) {
            addCriterion("summary_id <=", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdLike(String value) {
            addCriterion("summary_id like", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdNotLike(String value) {
            addCriterion("summary_id not like", value, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdIn(List<String> values) {
            addCriterion("summary_id in", values, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdNotIn(List<String> values) {
            addCriterion("summary_id not in", values, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdBetween(String value1, String value2) {
            addCriterion("summary_id between", value1, value2, "summaryId");
            return (Criteria) this;
        }

        public Criteria andSummaryIdNotBetween(String value1, String value2) {
            addCriterion("summary_id not between", value1, value2, "summaryId");
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

        public Criteria andSummaryProblemDescIsNull() {
            addCriterion("summary_problem_desc is null");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescIsNotNull() {
            addCriterion("summary_problem_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescEqualTo(String value) {
            addCriterion("summary_problem_desc =", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescNotEqualTo(String value) {
            addCriterion("summary_problem_desc <>", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescGreaterThan(String value) {
            addCriterion("summary_problem_desc >", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescGreaterThanOrEqualTo(String value) {
            addCriterion("summary_problem_desc >=", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescLessThan(String value) {
            addCriterion("summary_problem_desc <", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescLessThanOrEqualTo(String value) {
            addCriterion("summary_problem_desc <=", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescLike(String value) {
            addCriterion("summary_problem_desc like", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescNotLike(String value) {
            addCriterion("summary_problem_desc not like", value, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescIn(List<String> values) {
            addCriterion("summary_problem_desc in", values, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescNotIn(List<String> values) {
            addCriterion("summary_problem_desc not in", values, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescBetween(String value1, String value2) {
            addCriterion("summary_problem_desc between", value1, value2, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryProblemDescNotBetween(String value1, String value2) {
            addCriterion("summary_problem_desc not between", value1, value2, "summaryProblemDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonIsNull() {
            addCriterion("summary_breakdown_phenomenon is null");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonIsNotNull() {
            addCriterion("summary_breakdown_phenomenon is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonEqualTo(String value) {
            addCriterion("summary_breakdown_phenomenon =", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonNotEqualTo(String value) {
            addCriterion("summary_breakdown_phenomenon <>", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonGreaterThan(String value) {
            addCriterion("summary_breakdown_phenomenon >", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonGreaterThanOrEqualTo(String value) {
            addCriterion("summary_breakdown_phenomenon >=", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonLessThan(String value) {
            addCriterion("summary_breakdown_phenomenon <", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonLessThanOrEqualTo(String value) {
            addCriterion("summary_breakdown_phenomenon <=", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonLike(String value) {
            addCriterion("summary_breakdown_phenomenon like", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonNotLike(String value) {
            addCriterion("summary_breakdown_phenomenon not like", value, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonIn(List<String> values) {
            addCriterion("summary_breakdown_phenomenon in", values, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonNotIn(List<String> values) {
            addCriterion("summary_breakdown_phenomenon not in", values, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonBetween(String value1, String value2) {
            addCriterion("summary_breakdown_phenomenon between", value1, value2, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownPhenomenonNotBetween(String value1, String value2) {
            addCriterion("summary_breakdown_phenomenon not between", value1, value2, "summaryBreakdownPhenomenon");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseIsNull() {
            addCriterion("summary_breakdown_cause is null");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseIsNotNull() {
            addCriterion("summary_breakdown_cause is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseEqualTo(String value) {
            addCriterion("summary_breakdown_cause =", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseNotEqualTo(String value) {
            addCriterion("summary_breakdown_cause <>", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseGreaterThan(String value) {
            addCriterion("summary_breakdown_cause >", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseGreaterThanOrEqualTo(String value) {
            addCriterion("summary_breakdown_cause >=", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseLessThan(String value) {
            addCriterion("summary_breakdown_cause <", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseLessThanOrEqualTo(String value) {
            addCriterion("summary_breakdown_cause <=", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseLike(String value) {
            addCriterion("summary_breakdown_cause like", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseNotLike(String value) {
            addCriterion("summary_breakdown_cause not like", value, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseIn(List<String> values) {
            addCriterion("summary_breakdown_cause in", values, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseNotIn(List<String> values) {
            addCriterion("summary_breakdown_cause not in", values, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseBetween(String value1, String value2) {
            addCriterion("summary_breakdown_cause between", value1, value2, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryBreakdownCauseNotBetween(String value1, String value2) {
            addCriterion("summary_breakdown_cause not between", value1, value2, "summaryBreakdownCause");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondIsNull() {
            addCriterion("summary_repair_before_cond is null");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondIsNotNull() {
            addCriterion("summary_repair_before_cond is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondEqualTo(String value) {
            addCriterion("summary_repair_before_cond =", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondNotEqualTo(String value) {
            addCriterion("summary_repair_before_cond <>", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondGreaterThan(String value) {
            addCriterion("summary_repair_before_cond >", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondGreaterThanOrEqualTo(String value) {
            addCriterion("summary_repair_before_cond >=", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondLessThan(String value) {
            addCriterion("summary_repair_before_cond <", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondLessThanOrEqualTo(String value) {
            addCriterion("summary_repair_before_cond <=", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondLike(String value) {
            addCriterion("summary_repair_before_cond like", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondNotLike(String value) {
            addCriterion("summary_repair_before_cond not like", value, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondIn(List<String> values) {
            addCriterion("summary_repair_before_cond in", values, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondNotIn(List<String> values) {
            addCriterion("summary_repair_before_cond not in", values, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondBetween(String value1, String value2) {
            addCriterion("summary_repair_before_cond between", value1, value2, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairBeforeCondNotBetween(String value1, String value2) {
            addCriterion("summary_repair_before_cond not between", value1, value2, "summaryRepairBeforeCond");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescIsNull() {
            addCriterion("summary_repair_process_desc is null");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescIsNotNull() {
            addCriterion("summary_repair_process_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescEqualTo(String value) {
            addCriterion("summary_repair_process_desc =", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescNotEqualTo(String value) {
            addCriterion("summary_repair_process_desc <>", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescGreaterThan(String value) {
            addCriterion("summary_repair_process_desc >", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("summary_repair_process_desc >=", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescLessThan(String value) {
            addCriterion("summary_repair_process_desc <", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescLessThanOrEqualTo(String value) {
            addCriterion("summary_repair_process_desc <=", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescLike(String value) {
            addCriterion("summary_repair_process_desc like", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescNotLike(String value) {
            addCriterion("summary_repair_process_desc not like", value, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescIn(List<String> values) {
            addCriterion("summary_repair_process_desc in", values, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescNotIn(List<String> values) {
            addCriterion("summary_repair_process_desc not in", values, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescBetween(String value1, String value2) {
            addCriterion("summary_repair_process_desc between", value1, value2, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryRepairProcessDescNotBetween(String value1, String value2) {
            addCriterion("summary_repair_process_desc not between", value1, value2, "summaryRepairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisIsNull() {
            addCriterion("summary_cause_analysis is null");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisIsNotNull() {
            addCriterion("summary_cause_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisEqualTo(String value) {
            addCriterion("summary_cause_analysis =", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisNotEqualTo(String value) {
            addCriterion("summary_cause_analysis <>", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisGreaterThan(String value) {
            addCriterion("summary_cause_analysis >", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("summary_cause_analysis >=", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisLessThan(String value) {
            addCriterion("summary_cause_analysis <", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisLessThanOrEqualTo(String value) {
            addCriterion("summary_cause_analysis <=", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisLike(String value) {
            addCriterion("summary_cause_analysis like", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisNotLike(String value) {
            addCriterion("summary_cause_analysis not like", value, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisIn(List<String> values) {
            addCriterion("summary_cause_analysis in", values, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisNotIn(List<String> values) {
            addCriterion("summary_cause_analysis not in", values, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisBetween(String value1, String value2) {
            addCriterion("summary_cause_analysis between", value1, value2, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummaryCauseAnalysisNotBetween(String value1, String value2) {
            addCriterion("summary_cause_analysis not between", value1, value2, "summaryCauseAnalysis");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionIsNull() {
            addCriterion("summary_solution is null");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionIsNotNull() {
            addCriterion("summary_solution is not null");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionEqualTo(String value) {
            addCriterion("summary_solution =", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionNotEqualTo(String value) {
            addCriterion("summary_solution <>", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionGreaterThan(String value) {
            addCriterion("summary_solution >", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionGreaterThanOrEqualTo(String value) {
            addCriterion("summary_solution >=", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionLessThan(String value) {
            addCriterion("summary_solution <", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionLessThanOrEqualTo(String value) {
            addCriterion("summary_solution <=", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionLike(String value) {
            addCriterion("summary_solution like", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionNotLike(String value) {
            addCriterion("summary_solution not like", value, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionIn(List<String> values) {
            addCriterion("summary_solution in", values, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionNotIn(List<String> values) {
            addCriterion("summary_solution not in", values, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionBetween(String value1, String value2) {
            addCriterion("summary_solution between", value1, value2, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummarySolutionNotBetween(String value1, String value2) {
            addCriterion("summary_solution not between", value1, value2, "summarySolution");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyIsNull() {
            addCriterion("summary_konwledge_apply is null");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyIsNotNull() {
            addCriterion("summary_konwledge_apply is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyEqualTo(String value) {
            addCriterion("summary_konwledge_apply =", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyNotEqualTo(String value) {
            addCriterion("summary_konwledge_apply <>", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyGreaterThan(String value) {
            addCriterion("summary_konwledge_apply >", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyGreaterThanOrEqualTo(String value) {
            addCriterion("summary_konwledge_apply >=", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyLessThan(String value) {
            addCriterion("summary_konwledge_apply <", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyLessThanOrEqualTo(String value) {
            addCriterion("summary_konwledge_apply <=", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyLike(String value) {
            addCriterion("summary_konwledge_apply like", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyNotLike(String value) {
            addCriterion("summary_konwledge_apply not like", value, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyIn(List<String> values) {
            addCriterion("summary_konwledge_apply in", values, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyNotIn(List<String> values) {
            addCriterion("summary_konwledge_apply not in", values, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyBetween(String value1, String value2) {
            addCriterion("summary_konwledge_apply between", value1, value2, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryKonwledgeApplyNotBetween(String value1, String value2) {
            addCriterion("summary_konwledge_apply not between", value1, value2, "summaryKonwledgeApply");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentIsNull() {
            addCriterion("summary_attachment is null");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentIsNotNull() {
            addCriterion("summary_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentEqualTo(String value) {
            addCriterion("summary_attachment =", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentNotEqualTo(String value) {
            addCriterion("summary_attachment <>", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentGreaterThan(String value) {
            addCriterion("summary_attachment >", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("summary_attachment >=", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentLessThan(String value) {
            addCriterion("summary_attachment <", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentLessThanOrEqualTo(String value) {
            addCriterion("summary_attachment <=", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentLike(String value) {
            addCriterion("summary_attachment like", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentNotLike(String value) {
            addCriterion("summary_attachment not like", value, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentIn(List<String> values) {
            addCriterion("summary_attachment in", values, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentNotIn(List<String> values) {
            addCriterion("summary_attachment not in", values, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentBetween(String value1, String value2) {
            addCriterion("summary_attachment between", value1, value2, "summaryAttachment");
            return (Criteria) this;
        }

        public Criteria andSummaryAttachmentNotBetween(String value1, String value2) {
            addCriterion("summary_attachment not between", value1, value2, "summaryAttachment");
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