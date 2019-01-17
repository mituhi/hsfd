package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class NewSchedulingAssociatedExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewSchedulingAssociatedExample() {
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

        public Criteria andAssociatedIdIsNull() {
            addCriterion("associated_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIsNotNull() {
            addCriterion("associated_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdEqualTo(String value) {
            addCriterion("associated_id =", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotEqualTo(String value) {
            addCriterion("a.associated_id <>", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThan(String value) {
            addCriterion("associated_id >", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("associated_id >=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThan(String value) {
            addCriterion("associated_id <", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThanOrEqualTo(String value) {
            addCriterion("associated_id <=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLike(String value) {
            addCriterion("associated_id like", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotLike(String value) {
            addCriterion("associated_id not like", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIn(List<String> values) {
            addCriterion("associated_id in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotIn(List<String> values) {
            addCriterion("associated_id not in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdBetween(String value1, String value2) {
            addCriterion("associated_id between", value1, value2, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotBetween(String value1, String value2) {
            addCriterion("associated_id not between", value1, value2, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeIsNull() {
            addCriterion("associated_code is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeIsNotNull() {
            addCriterion("associated_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeEqualTo(String value) {
            addCriterion("associated_code =", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeNotEqualTo(String value) {
            addCriterion("associated_code <>", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeGreaterThan(String value) {
            addCriterion("associated_code >", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeGreaterThanOrEqualTo(String value) {
            addCriterion("associated_code >=", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeLessThan(String value) {
            addCriterion("associated_code <", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeLessThanOrEqualTo(String value) {
            addCriterion("associated_code <=", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeLike(String value) {
            addCriterion("a.associated_code like","%"+ value+"%", "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeNotLike(String value) {
            addCriterion("associated_code not like", value, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeIn(List<String> values) {
            addCriterion("associated_code in", values, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeNotIn(List<String> values) {
            addCriterion("associated_code not in", values, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeBetween(String value1, String value2) {
            addCriterion("associated_code between", value1, value2, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedCodeNotBetween(String value1, String value2) {
            addCriterion("associated_code not between", value1, value2, "associatedCode");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameIsNull() {
            addCriterion("associated_name is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameIsNotNull() {
            addCriterion("associated_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameEqualTo(String value) {
            addCriterion("a.associated_name =", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameNotEqualTo(String value) {
            addCriterion("associated_name <>", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameGreaterThan(String value) {
            addCriterion("associated_name >", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameGreaterThanOrEqualTo(String value) {
            addCriterion("associated_name >=", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameLessThan(String value) {
            addCriterion("associated_name <", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameLessThanOrEqualTo(String value) {
            addCriterion("associated_name <=", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameLike(String value) {
            addCriterion("a.associated_name like","%" +value+"%", "associatedName");
            return (Criteria) this;
        }
        
        public Criteria andSchedulingRuleCodeLike(String value) {
            addCriterion("c.scheduling_rule_code like binary","%" +value+"%", "associatedName");
            return (Criteria) this;
        }
        
        public Criteria andschedulingRuleLike(String value) {
            addCriterion("c.scheduling_rule like binary","%" +value+"%", "associatedName");
            return (Criteria) this;
        }
        
        public Criteria andStartDateLike(String value) {
            addCriterion("b.start_date like binary","%" +value+"%", "associatedName");
            return (Criteria) this;
        }
        
        public Criteria andEndDateLike(String value) {
            addCriterion("b.end_date like binary","%" +value+"%", "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameNotLike(String value) {
            addCriterion("associated_name not like", value, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameIn(List<String> values) {
            addCriterion("associated_name in", values, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameNotIn(List<String> values) {
            addCriterion("associated_name not in", values, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameBetween(String value1, String value2) {
            addCriterion("associated_name between", value1, value2, "associatedName");
            return (Criteria) this;
        }

        public Criteria andAssociatedNameNotBetween(String value1, String value2) {
            addCriterion("associated_name not between", value1, value2, "associatedName");
            return (Criteria) this;
        }

        public Criteria andWindCodeIsNull() {
            addCriterion("wind_code is null");
            return (Criteria) this;
        }

        public Criteria andWindCodeIsNotNull() {
            addCriterion("wind_code is not null");
            return (Criteria) this;
        }

        public Criteria andWindCodeEqualTo(String value) {
            addCriterion("a.wind_code =", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotEqualTo(String value) {
            addCriterion("wind_code <>", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeGreaterThan(String value) {
            addCriterion("wind_code >", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wind_code >=", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLessThan(String value) {
            addCriterion("wind_code <", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLessThanOrEqualTo(String value) {
            addCriterion("wind_code <=", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeLike(String value) {
            addCriterion("wind_code like", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotLike(String value) {
            addCriterion("wind_code not like", value, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeIn(List<String> values) {
            addCriterion("wind_code in", values, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotIn(List<String> values) {
            addCriterion("wind_code not in", values, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeBetween(String value1, String value2) {
            addCriterion("a.wind_code between", value1, value2, "windCode");
            return (Criteria) this;
        }

        public Criteria andWindCodeNotBetween(String value1, String value2) {
            addCriterion("wind_code not between", value1, value2, "windCode");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("a.is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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
        
        
        public Criteria andDetailAssociatedIdIsNotNull() {
            addCriterion("b.associated_id is not null");
            return (Criteria) this;
        }
        
        public Criteria andDetailAssociatedIdIsNull() {
            addCriterion("b.associated_id is  null");
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
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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