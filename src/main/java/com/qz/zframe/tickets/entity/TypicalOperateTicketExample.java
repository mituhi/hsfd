package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TypicalOperateTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypicalOperateTicketExample() {
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

        public Criteria andTypicalTicketIdIsNull() {
            addCriterion("typical_ticket__id is null");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdIsNotNull() {
            addCriterion("typical_ticket__id is not null");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdEqualTo(String value) {
            addCriterion("typical_ticket__id =", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotEqualTo(String value) {
            addCriterion("typical_ticket__id <>", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdGreaterThan(String value) {
            addCriterion("typical_ticket__id >", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("typical_ticket__id >=", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLessThan(String value) {
            addCriterion("typical_ticket__id <", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLessThanOrEqualTo(String value) {
            addCriterion("typical_ticket__id <=", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLike(String value) {
            addCriterion("typical_ticket__id like", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotLike(String value) {
            addCriterion("typical_ticket__id not like", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdIn(List<String> values) {
            addCriterion("typical_ticket__id in", values, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotIn(List<String> values) {
            addCriterion("typical_ticket__id not in", values, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdBetween(String value1, String value2) {
            addCriterion("typical_ticket__id between", value1, value2, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotBetween(String value1, String value2) {
            addCriterion("typical_ticket__id not between", value1, value2, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeIsNull() {
            addCriterion("typical_ticke_code is null");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeIsNotNull() {
            addCriterion("typical_ticke_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeEqualTo(String value) {
            addCriterion("typical_ticke_code =", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeNotEqualTo(String value) {
            addCriterion("typical_ticke_code <>", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeGreaterThan(String value) {
            addCriterion("typical_ticke_code >", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("typical_ticke_code >=", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeLessThan(String value) {
            addCriterion("typical_ticke_code <", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeLessThanOrEqualTo(String value) {
            addCriterion("typical_ticke_code <=", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeLike(String value) {
            addCriterion("typical_ticke_code like", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeNotLike(String value) {
            addCriterion("typical_ticke_code not like", value, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeIn(List<String> values) {
            addCriterion("typical_ticke_code in", values, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeNotIn(List<String> values) {
            addCriterion("typical_ticke_code not in", values, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeBetween(String value1, String value2) {
            addCriterion("typical_ticke_code between", value1, value2, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTypicalTickeCodeNotBetween(String value1, String value2) {
            addCriterion("typical_ticke_code not between", value1, value2, "typicalTickeCode");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdIsNull() {
            addCriterion("ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdIsNotNull() {
            addCriterion("ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdEqualTo(String value) {
            addCriterion("ticket_type_id =", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotEqualTo(String value) {
            addCriterion("ticket_type_id <>", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdGreaterThan(String value) {
            addCriterion("ticket_type_id >", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_type_id >=", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLessThan(String value) {
            addCriterion("ticket_type_id <", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_type_id <=", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdLike(String value) {
            addCriterion("ticket_type_id like", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotLike(String value) {
            addCriterion("ticket_type_id not like", value, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdIn(List<String> values) {
            addCriterion("ticket_type_id in", values, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotIn(List<String> values) {
            addCriterion("ticket_type_id not in", values, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdBetween(String value1, String value2) {
            addCriterion("ticket_type_id between", value1, value2, "ticketTypeId");
            return (Criteria) this;
        }

        public Criteria andTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("ticket_type_id not between", value1, value2, "ticketTypeId");
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

        public Criteria andLocaltionIsNull() {
            addCriterion("localtion is null");
            return (Criteria) this;
        }

        public Criteria andLocaltionIsNotNull() {
            addCriterion("localtion is not null");
            return (Criteria) this;
        }

        public Criteria andLocaltionEqualTo(String value) {
            addCriterion("localtion =", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionNotEqualTo(String value) {
            addCriterion("localtion <>", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionGreaterThan(String value) {
            addCriterion("localtion >", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionGreaterThanOrEqualTo(String value) {
            addCriterion("localtion >=", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionLessThan(String value) {
            addCriterion("localtion <", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionLessThanOrEqualTo(String value) {
            addCriterion("localtion <=", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionLike(String value) {
            addCriterion("localtion like", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionNotLike(String value) {
            addCriterion("localtion not like", value, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionIn(List<String> values) {
            addCriterion("localtion in", values, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionNotIn(List<String> values) {
            addCriterion("localtion not in", values, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionBetween(String value1, String value2) {
            addCriterion("localtion between", value1, value2, "localtion");
            return (Criteria) this;
        }

        public Criteria andLocaltionNotBetween(String value1, String value2) {
            addCriterion("localtion not between", value1, value2, "localtion");
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

        public Criteria andEquipmentIsNull() {
            addCriterion("equipment is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIsNotNull() {
            addCriterion("equipment is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentEqualTo(String value) {
            addCriterion("equipment =", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotEqualTo(String value) {
            addCriterion("equipment <>", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThan(String value) {
            addCriterion("equipment >", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("equipment >=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThan(String value) {
            addCriterion("equipment <", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThanOrEqualTo(String value) {
            addCriterion("equipment <=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLike(String value) {
            addCriterion("equipment like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotLike(String value) {
            addCriterion("equipment not like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentIn(List<String> values) {
            addCriterion("equipment in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotIn(List<String> values) {
            addCriterion("equipment not in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentBetween(String value1, String value2) {
            addCriterion("equipment between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotBetween(String value1, String value2) {
            addCriterion("equipment not between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andDapartmentsIsNull() {
            addCriterion("dapartments is null");
            return (Criteria) this;
        }

        public Criteria andDapartmentsIsNotNull() {
            addCriterion("dapartments is not null");
            return (Criteria) this;
        }

        public Criteria andDapartmentsEqualTo(String value) {
            addCriterion("dapartments =", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsNotEqualTo(String value) {
            addCriterion("dapartments <>", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsGreaterThan(String value) {
            addCriterion("dapartments >", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsGreaterThanOrEqualTo(String value) {
            addCriterion("dapartments >=", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsLessThan(String value) {
            addCriterion("dapartments <", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsLessThanOrEqualTo(String value) {
            addCriterion("dapartments <=", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsLike(String value) {
            addCriterion("dapartments like", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsNotLike(String value) {
            addCriterion("dapartments not like", value, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsIn(List<String> values) {
            addCriterion("dapartments in", values, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsNotIn(List<String> values) {
            addCriterion("dapartments not in", values, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsBetween(String value1, String value2) {
            addCriterion("dapartments between", value1, value2, "dapartments");
            return (Criteria) this;
        }

        public Criteria andDapartmentsNotBetween(String value1, String value2) {
            addCriterion("dapartments not between", value1, value2, "dapartments");
            return (Criteria) this;
        }

        public Criteria andOperateContentIsNull() {
            addCriterion("operate_content is null");
            return (Criteria) this;
        }

        public Criteria andOperateContentIsNotNull() {
            addCriterion("operate_content is not null");
            return (Criteria) this;
        }

        public Criteria andOperateContentEqualTo(String value) {
            addCriterion("operate_content =", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentNotEqualTo(String value) {
            addCriterion("operate_content <>", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentGreaterThan(String value) {
            addCriterion("operate_content >", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentGreaterThanOrEqualTo(String value) {
            addCriterion("operate_content >=", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentLessThan(String value) {
            addCriterion("operate_content <", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentLessThanOrEqualTo(String value) {
            addCriterion("operate_content <=", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentLike(String value) {
            addCriterion("operate_content like", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentNotLike(String value) {
            addCriterion("operate_content not like", value, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentIn(List<String> values) {
            addCriterion("operate_content in", values, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentNotIn(List<String> values) {
            addCriterion("operate_content not in", values, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentBetween(String value1, String value2) {
            addCriterion("operate_content between", value1, value2, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateContentNotBetween(String value1, String value2) {
            addCriterion("operate_content not between", value1, value2, "operateContent");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsIsNull() {
            addCriterion("operate_items_ids is null");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsIsNotNull() {
            addCriterion("operate_items_ids is not null");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsEqualTo(String value) {
            addCriterion("operate_items_ids =", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsNotEqualTo(String value) {
            addCriterion("operate_items_ids <>", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsGreaterThan(String value) {
            addCriterion("operate_items_ids >", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsGreaterThanOrEqualTo(String value) {
            addCriterion("operate_items_ids >=", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsLessThan(String value) {
            addCriterion("operate_items_ids <", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsLessThanOrEqualTo(String value) {
            addCriterion("operate_items_ids <=", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsLike(String value) {
            addCriterion("operate_items_ids like", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsNotLike(String value) {
            addCriterion("operate_items_ids not like", value, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsIn(List<String> values) {
            addCriterion("operate_items_ids in", values, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsNotIn(List<String> values) {
            addCriterion("operate_items_ids not in", values, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsBetween(String value1, String value2) {
            addCriterion("operate_items_ids between", value1, value2, "operateItemsIds");
            return (Criteria) this;
        }

        public Criteria andOperateItemsIdsNotBetween(String value1, String value2) {
            addCriterion("operate_items_ids not between", value1, value2, "operateItemsIds");
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