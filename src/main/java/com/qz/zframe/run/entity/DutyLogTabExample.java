package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.material.entity.MaterialExample.Criteria;

public class DutyLogTabExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyLogTabExample() {
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

        public Criteria andTabIdIsNull() {
            addCriterion("TAB_id is null");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNotNull() {
            addCriterion("TAB_id is not null");
            return (Criteria) this;
        }

        public Criteria andTabIdEqualTo(String value) {
            addCriterion("TAB_id =", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotEqualTo(String value) {
            addCriterion("TAB_id <>", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThan(String value) {
            addCriterion("TAB_id >", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_id >=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThan(String value) {
            addCriterion("TAB_id <", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThanOrEqualTo(String value) {
            addCriterion("TAB_id <=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLike(String value) {
            addCriterion("TAB_id like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotLike(String value) {
            addCriterion("TAB_id not like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdIn(List<String> values) {
            addCriterion("TAB_id in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotIn(List<String> values) {
            addCriterion("TAB_id not in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdBetween(String value1, String value2) {
            addCriterion("TAB_id between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotBetween(String value1, String value2) {
            addCriterion("TAB_id not between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabCodeIsNull() {
            addCriterion("TAB_code is null");
            return (Criteria) this;
        }

        public Criteria andTabCodeIsNotNull() {
            addCriterion("TAB_code is not null");
            return (Criteria) this;
        }

        public Criteria andTabCodeEqualTo(String value) {
            addCriterion("TAB_code =", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotEqualTo(String value) {
            addCriterion("TAB_code <>", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeGreaterThan(String value) {
            addCriterion("TAB_code >", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_code >=", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLessThan(String value) {
            addCriterion("TAB_code <", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLessThanOrEqualTo(String value) {
            addCriterion("TAB_code <=", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLike(String value) {
        	 addCriterion("TAB_code like","%"+value+"%", "tabCode");
            return (Criteria) this;
        }
        

        public Criteria andTabCodeNotLike(String value) {
            addCriterion("TAB_code not like", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeIn(List<String> values) {
            addCriterion("TAB_code in", values, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotIn(List<String> values) {
            addCriterion("TAB_code not in", values, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeBetween(String value1, String value2) {
            addCriterion("TAB_code between", value1, value2, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotBetween(String value1, String value2) {
            addCriterion("TAB_code not between", value1, value2, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNull() {
            addCriterion("TAB_name is null");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNotNull() {
            addCriterion("TAB_name is not null");
            return (Criteria) this;
        }

        public Criteria andTabNameEqualTo(String value) {
            addCriterion("TAB_name =", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotEqualTo(String value) {
            addCriterion("TAB_name <>", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThan(String value) {
            addCriterion("TAB_name >", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_name >=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThan(String value) {
            addCriterion("TAB_name <", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThanOrEqualTo(String value) {
            addCriterion("TAB_name <=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLike(String value) {
            addCriterion("TAB_name like", "%"+value+"%", "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotLike(String value) {
            addCriterion("TAB_name not like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameIn(List<String> values) {
            addCriterion("TAB_name in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotIn(List<String> values) {
            addCriterion("TAB_name not in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameBetween(String value1, String value2) {
            addCriterion("TAB_name between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotBetween(String value1, String value2) {
            addCriterion("TAB_name not between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like","%"+ value+"%", "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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