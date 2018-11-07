package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkorderTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderTypeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andWorkorderTypeIdIsNull() {
            addCriterion("workorder_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIsNotNull() {
            addCriterion("workorder_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdEqualTo(String value) {
            addCriterion("workorder_type_id =", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotEqualTo(String value) {
            addCriterion("workorder_type_id <>", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThan(String value) {
            addCriterion("workorder_type_id >", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_type_id >=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThan(String value) {
            addCriterion("workorder_type_id <", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThanOrEqualTo(String value) {
            addCriterion("workorder_type_id <=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLike(String value) {
            addCriterion("workorder_type_id like", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotLike(String value) {
            addCriterion("workorder_type_id not like", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIn(List<String> values) {
            addCriterion("workorder_type_id in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotIn(List<String> values) {
            addCriterion("workorder_type_id not in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdBetween(String value1, String value2) {
            addCriterion("workorder_type_id between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotBetween(String value1, String value2) {
            addCriterion("workorder_type_id not between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeIsNull() {
            addCriterion("workorder_type_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeIsNotNull() {
            addCriterion("workorder_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeEqualTo(String value) {
            addCriterion("workorder_type_code =", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeNotEqualTo(String value) {
            addCriterion("workorder_type_code <>", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeGreaterThan(String value) {
            addCriterion("workorder_type_code >", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_type_code >=", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeLessThan(String value) {
            addCriterion("workorder_type_code <", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("workorder_type_code <=", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeLike(String value) {
            addCriterion("workorder_type_code like", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeNotLike(String value) {
            addCriterion("workorder_type_code not like", value, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeIn(List<String> values) {
            addCriterion("workorder_type_code in", values, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeNotIn(List<String> values) {
            addCriterion("workorder_type_code not in", values, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeBetween(String value1, String value2) {
            addCriterion("workorder_type_code between", value1, value2, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeCodeNotBetween(String value1, String value2) {
            addCriterion("workorder_type_code not between", value1, value2, "workorderTypeCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameIsNull() {
            addCriterion("workorder_type_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameIsNotNull() {
            addCriterion("workorder_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameEqualTo(String value) {
            addCriterion("workorder_type_name =", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameNotEqualTo(String value) {
            addCriterion("workorder_type_name <>", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameGreaterThan(String value) {
            addCriterion("workorder_type_name >", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_type_name >=", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameLessThan(String value) {
            addCriterion("workorder_type_name <", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameLessThanOrEqualTo(String value) {
            addCriterion("workorder_type_name <=", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameLike(String value) {
            addCriterion("workorder_type_name like", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameNotLike(String value) {
            addCriterion("workorder_type_name not like", value, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameIn(List<String> values) {
            addCriterion("workorder_type_name in", values, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameNotIn(List<String> values) {
            addCriterion("workorder_type_name not in", values, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameBetween(String value1, String value2) {
            addCriterion("workorder_type_name between", value1, value2, "workorderTypeName");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNameNotBetween(String value1, String value2) {
            addCriterion("workorder_type_name not between", value1, value2, "workorderTypeName");
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

        public Criteria andMaintainerIsNull() {
            addCriterion("maintainer is null");
            return (Criteria) this;
        }

        public Criteria andMaintainerIsNotNull() {
            addCriterion("maintainer is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainerEqualTo(String value) {
            addCriterion("maintainer =", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotEqualTo(String value) {
            addCriterion("maintainer <>", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerGreaterThan(String value) {
            addCriterion("maintainer >", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerGreaterThanOrEqualTo(String value) {
            addCriterion("maintainer >=", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLessThan(String value) {
            addCriterion("maintainer <", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLessThanOrEqualTo(String value) {
            addCriterion("maintainer <=", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerLike(String value) {
            addCriterion("maintainer like", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotLike(String value) {
            addCriterion("maintainer not like", value, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerIn(List<String> values) {
            addCriterion("maintainer in", values, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotIn(List<String> values) {
            addCriterion("maintainer not in", values, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerBetween(String value1, String value2) {
            addCriterion("maintainer between", value1, value2, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainerNotBetween(String value1, String value2) {
            addCriterion("maintainer not between", value1, value2, "maintainer");
            return (Criteria) this;
        }

        public Criteria andMaintainDateIsNull() {
            addCriterion("maintain_date is null");
            return (Criteria) this;
        }

        public Criteria andMaintainDateIsNotNull() {
            addCriterion("maintain_date is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainDateEqualTo(Date value) {
            addCriterionForJDBCDate("maintain_date =", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("maintain_date <>", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateGreaterThan(Date value) {
            addCriterionForJDBCDate("maintain_date >", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintain_date >=", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateLessThan(Date value) {
            addCriterionForJDBCDate("maintain_date <", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintain_date <=", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateIn(List<Date> values) {
            addCriterionForJDBCDate("maintain_date in", values, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("maintain_date not in", values, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintain_date between", value1, value2, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintain_date not between", value1, value2, "maintainDate");
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