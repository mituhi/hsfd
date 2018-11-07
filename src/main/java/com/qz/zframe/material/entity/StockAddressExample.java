package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class StockAddressExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockAddressExample() {
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

        public Criteria andStockAddIdIsNull() {
            addCriterion("stock_add_id is null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIsNotNull() {
            addCriterion("stock_add_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdEqualTo(String value) {
            addCriterion("stock_add_id =", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotEqualTo(String value) {
            addCriterion("stock_add_id <>", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThan(String value) {
            addCriterion("stock_add_id >", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_id >=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThan(String value) {
            addCriterion("stock_add_id <", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThanOrEqualTo(String value) {
            addCriterion("stock_add_id <=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLike(String value) {
            addCriterion("stock_add_id like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotLike(String value) {
            addCriterion("stock_add_id not like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIn(List<String> values) {
            addCriterion("stock_add_id in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotIn(List<String> values) {
            addCriterion("stock_add_id not in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdBetween(String value1, String value2) {
            addCriterion("stock_add_id between", value1, value2, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotBetween(String value1, String value2) {
            addCriterion("stock_add_id not between", value1, value2, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeIsNull() {
            addCriterion("stock_add_code is null");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeIsNotNull() {
            addCriterion("stock_add_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeEqualTo(String value) {
            addCriterion("a.stock_add_code =", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeNotEqualTo(String value) {
            addCriterion("stock_add_code <>", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeGreaterThan(String value) {
            addCriterion("stock_add_code >", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_code >=", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeLessThan(String value) {
            addCriterion("stock_add_code <", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_add_code <=", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeLike(String value) {
            addCriterion("stock_add_code like", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeNotLike(String value) {
            addCriterion("stock_add_code not like", value, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeIn(List<String> values) {
            addCriterion("stock_add_code in", values, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeNotIn(List<String> values) {
            addCriterion("stock_add_code not in", values, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeBetween(String value1, String value2) {
            addCriterion("stock_add_code between", value1, value2, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddCodeNotBetween(String value1, String value2) {
            addCriterion("stock_add_code not between", value1, value2, "stockAddCode");
            return (Criteria) this;
        }

        public Criteria andStockAddNameIsNull() {
            addCriterion("stock_add_name is null");
            return (Criteria) this;
        }

        public Criteria andStockAddNameIsNotNull() {
            addCriterion("stock_add_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddNameEqualTo(String value) {
            addCriterion("a.stock_add_name =", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameNotEqualTo(String value) {
            addCriterion("stock_add_name <>", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameGreaterThan(String value) {
            addCriterion("stock_add_name >", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_name >=", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameLessThan(String value) {
            addCriterion("stock_add_name <", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameLessThanOrEqualTo(String value) {
            addCriterion("stock_add_name <=", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameLike(String value) {
            addCriterion("a.stock_add_name like","%"+ value+"%", "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameNotLike(String value) {
            addCriterion("stock_add_name not like", value, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameIn(List<String> values) {
            addCriterion("stock_add_name in", values, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameNotIn(List<String> values) {
            addCriterion("stock_add_name not in", values, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameBetween(String value1, String value2) {
            addCriterion("stock_add_name between", value1, value2, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddNameNotBetween(String value1, String value2) {
            addCriterion("stock_add_name not between", value1, value2, "stockAddName");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrIsNull() {
            addCriterion("stock_add_attr is null");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrIsNotNull() {
            addCriterion("stock_add_attr is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrEqualTo(String value) {
            addCriterion("stock_add_attr =", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrNotEqualTo(String value) {
            addCriterion("stock_add_attr <>", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrGreaterThan(String value) {
            addCriterion("stock_add_attr >", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_attr >=", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrLessThan(String value) {
            addCriterion("stock_add_attr <", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrLessThanOrEqualTo(String value) {
            addCriterion("stock_add_attr <=", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrLike(String value) {
            addCriterion("stock_add_attr like", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrNotLike(String value) {
            addCriterion("stock_add_attr not like", value, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrIn(List<String> values) {
            addCriterion("stock_add_attr in", values, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrNotIn(List<String> values) {
            addCriterion("stock_add_attr not in", values, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrBetween(String value1, String value2) {
            addCriterion("stock_add_attr between", value1, value2, "stockAddAttr");
            return (Criteria) this;
        }

        public Criteria andStockAddAttrNotBetween(String value1, String value2) {
            addCriterion("stock_add_attr not between", value1, value2, "stockAddAttr");
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
            addCriterion("wind_id =", value, "windId");
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
            addCriterion("wind_id in", values, "windId");
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
        
        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("a.is_delete =", value, "status");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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