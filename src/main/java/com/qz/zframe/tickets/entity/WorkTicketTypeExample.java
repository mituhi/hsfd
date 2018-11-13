package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkTicketTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketTypeExample() {
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

        public Criteria andWorkTicketTypeIdIsNull() {
            addCriterion("work_ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdIsNotNull() {
            addCriterion("work_ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdEqualTo(String value) {
            addCriterion("work_ticket_type_id =", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotEqualTo(String value) {
            addCriterion("work_ticket_type_id <>", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdGreaterThan(String value) {
            addCriterion("work_ticket_type_id >", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_ticket_type_id >=", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLessThan(String value) {
            addCriterion("work_ticket_type_id <", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("work_ticket_type_id <=", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdLike(String value) {
            addCriterion("work_ticket_type_id like", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotLike(String value) {
            addCriterion("work_ticket_type_id not like", value, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdIn(List<String> values) {
            addCriterion("work_ticket_type_id in", values, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotIn(List<String> values) {
            addCriterion("work_ticket_type_id not in", values, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdBetween(String value1, String value2) {
            addCriterion("work_ticket_type_id between", value1, value2, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("work_ticket_type_id not between", value1, value2, "workTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberIsNull() {
            addCriterion("ticketTypeNumber is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberIsNotNull() {
            addCriterion("ticketTypeNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberEqualTo(String value) {
            addCriterion("ticketTypeNumber =", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberNotEqualTo(String value) {
            addCriterion("ticketTypeNumber <>", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberGreaterThan(String value) {
            addCriterion("ticketTypeNumber >", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ticketTypeNumber >=", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberLessThan(String value) {
            addCriterion("ticketTypeNumber <", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberLessThanOrEqualTo(String value) {
            addCriterion("ticketTypeNumber <=", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberLike(String value) {
            addCriterion("ticketTypeNumber like", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberNotLike(String value) {
            addCriterion("ticketTypeNumber not like", value, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberIn(List<String> values) {
            addCriterion("ticketTypeNumber in", values, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberNotIn(List<String> values) {
            addCriterion("ticketTypeNumber not in", values, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberBetween(String value1, String value2) {
            addCriterion("ticketTypeNumber between", value1, value2, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNumberNotBetween(String value1, String value2) {
            addCriterion("ticketTypeNumber not between", value1, value2, "ticketTypeNumber");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescIsNull() {
            addCriterion("ticket_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescIsNotNull() {
            addCriterion("ticket_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescEqualTo(String value) {
            addCriterion("ticket_type_desc =", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescNotEqualTo(String value) {
            addCriterion("ticket_type_desc <>", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescGreaterThan(String value) {
            addCriterion("ticket_type_desc >", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_type_desc >=", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescLessThan(String value) {
            addCriterion("ticket_type_desc <", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescLessThanOrEqualTo(String value) {
            addCriterion("ticket_type_desc <=", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescLike(String value) {
            addCriterion("ticket_type_desc like", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescNotLike(String value) {
            addCriterion("ticket_type_desc not like", value, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescIn(List<String> values) {
            addCriterion("ticket_type_desc in", values, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescNotIn(List<String> values) {
            addCriterion("ticket_type_desc not in", values, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescBetween(String value1, String value2) {
            addCriterion("ticket_type_desc between", value1, value2, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeDescNotBetween(String value1, String value2) {
            addCriterion("ticket_type_desc not between", value1, value2, "ticketTypeDesc");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameIsNull() {
            addCriterion("ticket_type_name is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameIsNotNull() {
            addCriterion("ticket_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameEqualTo(String value) {
            addCriterion("ticket_type_name =", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameNotEqualTo(String value) {
            addCriterion("ticket_type_name <>", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameGreaterThan(String value) {
            addCriterion("ticket_type_name >", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_type_name >=", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameLessThan(String value) {
            addCriterion("ticket_type_name <", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameLessThanOrEqualTo(String value) {
            addCriterion("ticket_type_name <=", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameLike(String value) {
            addCriterion("ticket_type_name like", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameNotLike(String value) {
            addCriterion("ticket_type_name not like", value, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameIn(List<String> values) {
            addCriterion("ticket_type_name in", values, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameNotIn(List<String> values) {
            addCriterion("ticket_type_name not in", values, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameBetween(String value1, String value2) {
            addCriterion("ticket_type_name between", value1, value2, "ticketTypeName");
            return (Criteria) this;
        }

        public Criteria andTicketTypeNameNotBetween(String value1, String value2) {
            addCriterion("ticket_type_name not between", value1, value2, "ticketTypeName");
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