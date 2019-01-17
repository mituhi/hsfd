package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class MaterialUnitExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialUnitExample() {
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

        public Criteria andMeasuringUnitIdIsNull() {
            addCriterion("measuring_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdIsNotNull() {
            addCriterion("measuring_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdEqualTo(String value) {
            addCriterion("measuring_unit_id =", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdNotEqualTo(String value) {
            addCriterion("measuring_unit_id <>", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdGreaterThan(String value) {
            addCriterion("measuring_unit_id >", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("measuring_unit_id >=", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdLessThan(String value) {
            addCriterion("measuring_unit_id <", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdLessThanOrEqualTo(String value) {
            addCriterion("measuring_unit_id <=", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdLike(String value) {
            addCriterion("measuring_unit_id like", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdNotLike(String value) {
            addCriterion("measuring_unit_id not like", value, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdIn(List<String> values) {
            addCriterion("measuring_unit_id in", values, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdNotIn(List<String> values) {
            addCriterion("measuring_unit_id not in", values, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdBetween(String value1, String value2) {
            addCriterion("measuring_unit_id between", value1, value2, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIdNotBetween(String value1, String value2) {
            addCriterion("measuring_unit_id not between", value1, value2, "measuringUnitId");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeIsNull() {
            addCriterion("measuring_unit_code is null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeIsNotNull() {
            addCriterion("measuring_unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeEqualTo(String value) {
            addCriterion("measuring_unit_code =", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeNotEqualTo(String value) {
            addCriterion("measuring_unit_code <>", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeGreaterThan(String value) {
            addCriterion("measuring_unit_code >", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("measuring_unit_code >=", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeLessThan(String value) {
            addCriterion("measuring_unit_code <", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("measuring_unit_code <=", value, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeLike(String value) {
            addCriterion("measuring_unit_code like","%"+ value+"%", "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeNotLike(String value) {
            addCriterion("measuring_unit_code not like", "%"+value+"%", "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeIn(List<String> values) {
            addCriterion("measuring_unit_code in", values, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeNotIn(List<String> values) {
            addCriterion("measuring_unit_code not in", values, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeBetween(String value1, String value2) {
            addCriterion("measuring_unit_code between", value1, value2, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitCodeNotBetween(String value1, String value2) {
            addCriterion("measuring_unit_code not between", value1, value2, "measuringUnitCode");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameIsNull() {
            addCriterion("measuring_unit_name is null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameIsNotNull() {
            addCriterion("measuring_unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameEqualTo(String value) {
            addCriterion("measuring_unit_name =", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameNotEqualTo(String value) {
            addCriterion("measuring_unit_name <>", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameGreaterThan(String value) {
            addCriterion("measuring_unit_name >", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("measuring_unit_name >=", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameLessThan(String value) {
            addCriterion("measuring_unit_name <", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameLessThanOrEqualTo(String value) {
            addCriterion("measuring_unit_name <=", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameLike(String value) {
            addCriterion("measuring_unit_name like","%" +value+"%", "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameNotLike(String value) {
            addCriterion("measuring_unit_name not like", value, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameIn(List<String> values) {
            addCriterion("measuring_unit_name in", values, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameNotIn(List<String> values) {
            addCriterion("measuring_unit_name not in", values, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameBetween(String value1, String value2) {
            addCriterion("measuring_unit_name between", value1, value2, "measuringUnitName");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNameNotBetween(String value1, String value2) {
            addCriterion("measuring_unit_name not between", value1, value2, "measuringUnitName");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
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