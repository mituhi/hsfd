package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ScrapExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScrapExample() {
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

        public Criteria andScrapIdIsNull() {
            addCriterion("scrap_id is null");
            return (Criteria) this;
        }

        public Criteria andScrapIdIsNotNull() {
            addCriterion("scrap_id is not null");
            return (Criteria) this;
        }

        public Criteria andScrapIdEqualTo(String value) {
            addCriterion("scrap_id =", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotEqualTo(String value) {
            addCriterion("scrap_id <>", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdGreaterThan(String value) {
            addCriterion("scrap_id >", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_id >=", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLessThan(String value) {
            addCriterion("scrap_id <", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLessThanOrEqualTo(String value) {
            addCriterion("scrap_id <=", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLike(String value) {
            addCriterion("scrap_id like", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotLike(String value) {
            addCriterion("scrap_id not like", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdIn(List<String> values) {
            addCriterion("scrap_id in", values, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotIn(List<String> values) {
            addCriterion("scrap_id not in", values, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdBetween(String value1, String value2) {
            addCriterion("scrap_id between", value1, value2, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotBetween(String value1, String value2) {
            addCriterion("scrap_id not between", value1, value2, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapOrderIsNull() {
            addCriterion("scrap_order is null");
            return (Criteria) this;
        }

        public Criteria andScrapOrderIsNotNull() {
            addCriterion("scrap_order is not null");
            return (Criteria) this;
        }

        public Criteria andScrapOrderEqualTo(String value) {
            addCriterion("scrap_order =", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderNotEqualTo(String value) {
            addCriterion("scrap_order <>", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderGreaterThan(String value) {
            addCriterion("scrap_order >", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_order >=", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderLessThan(String value) {
            addCriterion("scrap_order <", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderLessThanOrEqualTo(String value) {
            addCriterion("scrap_order <=", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderLike(String value) {
            addCriterion("scrap_order like", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderNotLike(String value) {
            addCriterion("scrap_order not like", value, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderIn(List<String> values) {
            addCriterion("scrap_order in", values, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderNotIn(List<String> values) {
            addCriterion("scrap_order not in", values, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderBetween(String value1, String value2) {
            addCriterion("scrap_order between", value1, value2, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapOrderNotBetween(String value1, String value2) {
            addCriterion("scrap_order not between", value1, value2, "scrapOrder");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeIsNull() {
            addCriterion("scrap_describe is null");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeIsNotNull() {
            addCriterion("scrap_describe is not null");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeEqualTo(String value) {
            addCriterion("scrap_describe =", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeNotEqualTo(String value) {
            addCriterion("scrap_describe <>", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeGreaterThan(String value) {
            addCriterion("scrap_describe >", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_describe >=", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeLessThan(String value) {
            addCriterion("scrap_describe <", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeLessThanOrEqualTo(String value) {
            addCriterion("scrap_describe <=", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeLike(String value) {
            addCriterion("scrap_describe like", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeNotLike(String value) {
            addCriterion("scrap_describe not like", value, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeIn(List<String> values) {
            addCriterion("scrap_describe in", values, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeNotIn(List<String> values) {
            addCriterion("scrap_describe not in", values, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeBetween(String value1, String value2) {
            addCriterion("scrap_describe between", value1, value2, "scrapDescribe");
            return (Criteria) this;
        }

        public Criteria andScrapDescribeNotBetween(String value1, String value2) {
            addCriterion("scrap_describe not between", value1, value2, "scrapDescribe");
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
            addCriterion("a.status =", value, "status");
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

        public Criteria andArchitectureIdIsNull() {
            addCriterion("architecture_id is null");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdIsNotNull() {
            addCriterion("architecture_id is not null");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdEqualTo(String value) {
            addCriterion("architecture_id =", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotEqualTo(String value) {
            addCriterion("architecture_id <>", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdGreaterThan(String value) {
            addCriterion("architecture_id >", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdGreaterThanOrEqualTo(String value) {
            addCriterion("architecture_id >=", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLessThan(String value) {
            addCriterion("architecture_id <", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLessThanOrEqualTo(String value) {
            addCriterion("architecture_id <=", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLike(String value) {
            addCriterion("architecture_id like", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotLike(String value) {
            addCriterion("architecture_id not like", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdIn(List<String> values) {
            addCriterion("a.architecture_id in", values, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotIn(List<String> values) {
            addCriterion("architecture_id not in", values, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdBetween(String value1, String value2) {
            addCriterion("architecture_id between", value1, value2, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotBetween(String value1, String value2) {
            addCriterion("architecture_id not between", value1, value2, "architectureId");
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