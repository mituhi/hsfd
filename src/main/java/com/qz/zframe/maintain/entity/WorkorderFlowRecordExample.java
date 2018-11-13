package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderFlowRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderFlowRecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(String value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(String value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(String value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(String value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(String value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLike(String value) {
            addCriterion("record_id like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotLike(String value) {
            addCriterion("record_id not like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<String> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<String> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(String value1, String value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(String value1, String value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
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

        public Criteria andRecordNameIsNull() {
            addCriterion("record_name is null");
            return (Criteria) this;
        }

        public Criteria andRecordNameIsNotNull() {
            addCriterion("record_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNameEqualTo(String value) {
            addCriterion("record_name =", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameNotEqualTo(String value) {
            addCriterion("record_name <>", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameGreaterThan(String value) {
            addCriterion("record_name >", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameGreaterThanOrEqualTo(String value) {
            addCriterion("record_name >=", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameLessThan(String value) {
            addCriterion("record_name <", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameLessThanOrEqualTo(String value) {
            addCriterion("record_name <=", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameLike(String value) {
            addCriterion("record_name like", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameNotLike(String value) {
            addCriterion("record_name not like", value, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameIn(List<String> values) {
            addCriterion("record_name in", values, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameNotIn(List<String> values) {
            addCriterion("record_name not in", values, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameBetween(String value1, String value2) {
            addCriterion("record_name between", value1, value2, "recordName");
            return (Criteria) this;
        }

        public Criteria andRecordNameNotBetween(String value1, String value2) {
            addCriterion("record_name not between", value1, value2, "recordName");
            return (Criteria) this;
        }

        public Criteria andDealPersonIsNull() {
            addCriterion("deal_person is null");
            return (Criteria) this;
        }

        public Criteria andDealPersonIsNotNull() {
            addCriterion("deal_person is not null");
            return (Criteria) this;
        }

        public Criteria andDealPersonEqualTo(String value) {
            addCriterion("deal_person =", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotEqualTo(String value) {
            addCriterion("deal_person <>", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonGreaterThan(String value) {
            addCriterion("deal_person >", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonGreaterThanOrEqualTo(String value) {
            addCriterion("deal_person >=", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLessThan(String value) {
            addCriterion("deal_person <", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLessThanOrEqualTo(String value) {
            addCriterion("deal_person <=", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLike(String value) {
            addCriterion("deal_person like", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotLike(String value) {
            addCriterion("deal_person not like", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonIn(List<String> values) {
            addCriterion("deal_person in", values, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotIn(List<String> values) {
            addCriterion("deal_person not in", values, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonBetween(String value1, String value2) {
            addCriterion("deal_person between", value1, value2, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotBetween(String value1, String value2) {
            addCriterion("deal_person not between", value1, value2, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNull() {
            addCriterion("deal_opinion is null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNotNull() {
            addCriterion("deal_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionEqualTo(String value) {
            addCriterion("deal_opinion =", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotEqualTo(String value) {
            addCriterion("deal_opinion <>", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThan(String value) {
            addCriterion("deal_opinion >", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("deal_opinion >=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThan(String value) {
            addCriterion("deal_opinion <", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThanOrEqualTo(String value) {
            addCriterion("deal_opinion <=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLike(String value) {
            addCriterion("deal_opinion like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotLike(String value) {
            addCriterion("deal_opinion not like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIn(List<String> values) {
            addCriterion("deal_opinion in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotIn(List<String> values) {
            addCriterion("deal_opinion not in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionBetween(String value1, String value2) {
            addCriterion("deal_opinion between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotBetween(String value1, String value2) {
            addCriterion("deal_opinion not between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("deal_result is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("deal_result is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("deal_result =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("deal_result <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("deal_result >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("deal_result >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("deal_result <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("deal_result <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("deal_result like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("deal_result not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("deal_result in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("deal_result not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("deal_result between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("deal_result not between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
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