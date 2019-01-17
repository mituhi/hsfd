package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class DamagedAuditExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DamagedAuditExample() {
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

        public Criteria andDamagedAuditIdIsNull() {
            addCriterion("damaged_audit_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdIsNotNull() {
            addCriterion("damaged_audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdEqualTo(String value) {
            addCriterion("damaged_audit_id =", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotEqualTo(String value) {
            addCriterion("damaged_audit_id <>", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdGreaterThan(String value) {
            addCriterion("damaged_audit_id >", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_audit_id >=", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLessThan(String value) {
            addCriterion("damaged_audit_id <", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_audit_id <=", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdLike(String value) {
            addCriterion("damaged_audit_id like", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotLike(String value) {
            addCriterion("damaged_audit_id not like", value, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdIn(List<String> values) {
            addCriterion("damaged_audit_id in", values, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotIn(List<String> values) {
            addCriterion("damaged_audit_id not in", values, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdBetween(String value1, String value2) {
            addCriterion("damaged_audit_id between", value1, value2, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditIdNotBetween(String value1, String value2) {
            addCriterion("damaged_audit_id not between", value1, value2, "damagedAuditId");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderIsNull() {
            addCriterion("damaged_audit_order is null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderIsNotNull() {
            addCriterion("damaged_audit_order is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderEqualTo(String value) {
            addCriterion("damaged_audit_order =", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderNotEqualTo(String value) {
            addCriterion("damaged_audit_order <>", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderGreaterThan(String value) {
            addCriterion("damaged_audit_order >", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_audit_order >=", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderLessThan(String value) {
            addCriterion("damaged_audit_order <", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderLessThanOrEqualTo(String value) {
            addCriterion("damaged_audit_order <=", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderLike(String value) {
            addCriterion("damaged_audit_order like", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderNotLike(String value) {
            addCriterion("damaged_audit_order not like", value, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderIn(List<String> values) {
            addCriterion("damaged_audit_order in", values, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderNotIn(List<String> values) {
            addCriterion("damaged_audit_order not in", values, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderBetween(String value1, String value2) {
            addCriterion("damaged_audit_order between", value1, value2, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditOrderNotBetween(String value1, String value2) {
            addCriterion("damaged_audit_order not between", value1, value2, "damagedAuditOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeIsNull() {
            addCriterion("damaged_audit_describe is null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeIsNotNull() {
            addCriterion("damaged_audit_describe is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeEqualTo(String value) {
            addCriterion("damaged_audit_describe =", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeNotEqualTo(String value) {
            addCriterion("damaged_audit_describe <>", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeGreaterThan(String value) {
            addCriterion("damaged_audit_describe >", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_audit_describe >=", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeLessThan(String value) {
            addCriterion("damaged_audit_describe <", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeLessThanOrEqualTo(String value) {
            addCriterion("damaged_audit_describe <=", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeLike(String value) {
            addCriterion("a.damaged_audit_describe like", "%"+value+"%", "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeNotLike(String value) {
            addCriterion("damaged_audit_describe not like", value, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeIn(List<String> values) {
            addCriterion("damaged_audit_describe in", values, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeNotIn(List<String> values) {
            addCriterion("damaged_audit_describe not in", values, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeBetween(String value1, String value2) {
            addCriterion("damaged_audit_describe between", value1, value2, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedAuditDescribeNotBetween(String value1, String value2) {
            addCriterion("damaged_audit_describe not between", value1, value2, "damagedAuditDescribe");
            return (Criteria) this;
        }

        public Criteria andWindIdIsNull() {
            addCriterion("wind_id is null");
            return (Criteria) this;
        }

        public Criteria andWindIdIsNotNull() {
            addCriterion("wind_id is not null");
            return (Criteria) this;
        }

        public Criteria andWindIdEqualTo(String value) {
            addCriterion("a.wind_id =", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotEqualTo(String value) {
            addCriterion("wind_id <>", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThan(String value) {
            addCriterion("wind_id >", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThanOrEqualTo(String value) {
            addCriterion("wind_id >=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThan(String value) {
            addCriterion("wind_id <", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThanOrEqualTo(String value) {
            addCriterion("wind_id <=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLike(String value) {
            addCriterion("wind_id like", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotLike(String value) {
            addCriterion("wind_id not like", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdIn(List<String> values) {
            addCriterion("a.wind_id in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotIn(List<String> values) {
            addCriterion("wind_id not in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdBetween(String value1, String value2) {
            addCriterion("wind_id between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotBetween(String value1, String value2) {
            addCriterion("wind_id not between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("a.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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