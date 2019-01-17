package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTicketExample() {
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

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(String value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(String value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(String value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(String value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLike(String value) {
            addCriterion("ticket_id like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotLike(String value) {
            addCriterion("ticket_id not like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<String> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<String> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(String value1, String value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(String value1, String value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
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

        public Criteria andStandardTicketIdIsNull() {
            addCriterion("standard_ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdIsNotNull() {
            addCriterion("standard_ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdEqualTo(String value) {
            addCriterion("standard_ticket_id =", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotEqualTo(String value) {
            addCriterion("standard_ticket_id <>", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdGreaterThan(String value) {
            addCriterion("standard_ticket_id >", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("standard_ticket_id >=", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLessThan(String value) {
            addCriterion("standard_ticket_id <", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLessThanOrEqualTo(String value) {
            addCriterion("standard_ticket_id <=", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdLike(String value) {
            addCriterion("standard_ticket_id like", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotLike(String value) {
            addCriterion("standard_ticket_id not like", value, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdIn(List<String> values) {
            addCriterion("standard_ticket_id in", values, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotIn(List<String> values) {
            addCriterion("standard_ticket_id not in", values, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdBetween(String value1, String value2) {
            addCriterion("standard_ticket_id between", value1, value2, "standardTicketId");
            return (Criteria) this;
        }

        public Criteria andStandardTicketIdNotBetween(String value1, String value2) {
            addCriterion("standard_ticket_id not between", value1, value2, "standardTicketId");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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
            addCriterion("maintain_date =", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotEqualTo(Date value) {
            addCriterion("maintain_date <>", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateGreaterThan(Date value) {
            addCriterion("maintain_date >", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("maintain_date >=", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateLessThan(Date value) {
            addCriterion("maintain_date <", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateLessThanOrEqualTo(Date value) {
            addCriterion("maintain_date <=", value, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateIn(List<Date> values) {
            addCriterion("maintain_date in", values, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotIn(List<Date> values) {
            addCriterion("maintain_date not in", values, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateBetween(Date value1, Date value2) {
            addCriterion("maintain_date between", value1, value2, "maintainDate");
            return (Criteria) this;
        }

        public Criteria andMaintainDateNotBetween(Date value1, Date value2) {
            addCriterion("maintain_date not between", value1, value2, "maintainDate");
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

        public Criteria andFlowStatusIsNull() {
            addCriterion("flow_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNotNull() {
            addCriterion("flow_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusEqualTo(String value) {
            addCriterion("flow_status =", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotEqualTo(String value) {
            addCriterion("flow_status <>", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThan(String value) {
            addCriterion("flow_status >", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("flow_status >=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThan(String value) {
            addCriterion("flow_status <", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThanOrEqualTo(String value) {
            addCriterion("flow_status <=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLike(String value) {
            addCriterion("flow_status like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotLike(String value) {
            addCriterion("flow_status not like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIn(List<String> values) {
            addCriterion("flow_status in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotIn(List<String> values) {
            addCriterion("flow_status not in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusBetween(String value1, String value2) {
            addCriterion("flow_status between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotBetween(String value1, String value2) {
            addCriterion("flow_status not between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIsNull() {
            addCriterion("work_position is null");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIsNotNull() {
            addCriterion("work_position is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPositionEqualTo(String value) {
            addCriterion("work_position =", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotEqualTo(String value) {
            addCriterion("work_position <>", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionGreaterThan(String value) {
            addCriterion("work_position >", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionGreaterThanOrEqualTo(String value) {
            addCriterion("work_position >=", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLessThan(String value) {
            addCriterion("work_position <", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLessThanOrEqualTo(String value) {
            addCriterion("work_position <=", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionLike(String value) {
            addCriterion("work_position like", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotLike(String value) {
            addCriterion("work_position not like", value, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionIn(List<String> values) {
            addCriterion("work_position in", values, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotIn(List<String> values) {
            addCriterion("work_position not in", values, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionBetween(String value1, String value2) {
            addCriterion("work_position between", value1, value2, "workPosition");
            return (Criteria) this;
        }

        public Criteria andWorkPositionNotBetween(String value1, String value2) {
            addCriterion("work_position not between", value1, value2, "workPosition");
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

        public Criteria andCrewIdIsNull() {
            addCriterion("crew_id is null");
            return (Criteria) this;
        }

        public Criteria andCrewIdIsNotNull() {
            addCriterion("crew_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrewIdEqualTo(String value) {
            addCriterion("crew_id =", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotEqualTo(String value) {
            addCriterion("crew_id <>", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdGreaterThan(String value) {
            addCriterion("crew_id >", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdGreaterThanOrEqualTo(String value) {
            addCriterion("crew_id >=", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLessThan(String value) {
            addCriterion("crew_id <", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLessThanOrEqualTo(String value) {
            addCriterion("crew_id <=", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLike(String value) {
            addCriterion("crew_id like", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotLike(String value) {
            addCriterion("crew_id not like", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdIn(List<String> values) {
            addCriterion("crew_id in", values, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotIn(List<String> values) {
            addCriterion("crew_id not in", values, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdBetween(String value1, String value2) {
            addCriterion("crew_id between", value1, value2, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotBetween(String value1, String value2) {
            addCriterion("crew_id not between", value1, value2, "crewId");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andWorkTeamIsNull() {
            addCriterion("work_team is null");
            return (Criteria) this;
        }

        public Criteria andWorkTeamIsNotNull() {
            addCriterion("work_team is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTeamEqualTo(String value) {
            addCriterion("work_team =", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamNotEqualTo(String value) {
            addCriterion("work_team <>", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamGreaterThan(String value) {
            addCriterion("work_team >", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamGreaterThanOrEqualTo(String value) {
            addCriterion("work_team >=", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamLessThan(String value) {
            addCriterion("work_team <", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamLessThanOrEqualTo(String value) {
            addCriterion("work_team <=", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamLike(String value) {
            addCriterion("work_team like", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamNotLike(String value) {
            addCriterion("work_team not like", value, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamIn(List<String> values) {
            addCriterion("work_team in", values, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamNotIn(List<String> values) {
            addCriterion("work_team not in", values, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamBetween(String value1, String value2) {
            addCriterion("work_team between", value1, value2, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkTeamNotBetween(String value1, String value2) {
            addCriterion("work_team not between", value1, value2, "workTeam");
            return (Criteria) this;
        }

        public Criteria andWorkHeadIsNull() {
            addCriterion("work_head is null");
            return (Criteria) this;
        }

        public Criteria andWorkHeadIsNotNull() {
            addCriterion("work_head is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHeadEqualTo(String value) {
            addCriterion("work_head =", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadNotEqualTo(String value) {
            addCriterion("work_head <>", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadGreaterThan(String value) {
            addCriterion("work_head >", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadGreaterThanOrEqualTo(String value) {
            addCriterion("work_head >=", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadLessThan(String value) {
            addCriterion("work_head <", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadLessThanOrEqualTo(String value) {
            addCriterion("work_head <=", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadLike(String value) {
            addCriterion("work_head like", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadNotLike(String value) {
            addCriterion("work_head not like", value, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadIn(List<String> values) {
            addCriterion("work_head in", values, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadNotIn(List<String> values) {
            addCriterion("work_head not in", values, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadBetween(String value1, String value2) {
            addCriterion("work_head between", value1, value2, "workHead");
            return (Criteria) this;
        }

        public Criteria andWorkHeadNotBetween(String value1, String value2) {
            addCriterion("work_head not between", value1, value2, "workHead");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionDescIsNull() {
            addCriterion("position_desc is null");
            return (Criteria) this;
        }

        public Criteria andPositionDescIsNotNull() {
            addCriterion("position_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDescEqualTo(String value) {
            addCriterion("position_desc =", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotEqualTo(String value) {
            addCriterion("position_desc <>", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescGreaterThan(String value) {
            addCriterion("position_desc >", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescGreaterThanOrEqualTo(String value) {
            addCriterion("position_desc >=", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLessThan(String value) {
            addCriterion("position_desc <", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLessThanOrEqualTo(String value) {
            addCriterion("position_desc <=", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLike(String value) {
            addCriterion("position_desc like", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotLike(String value) {
            addCriterion("position_desc not like", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescIn(List<String> values) {
            addCriterion("position_desc in", values, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotIn(List<String> values) {
            addCriterion("position_desc not in", values, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescBetween(String value1, String value2) {
            addCriterion("position_desc between", value1, value2, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotBetween(String value1, String value2) {
            addCriterion("position_desc not between", value1, value2, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescIsNull() {
            addCriterion("equipment_desc is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescIsNotNull() {
            addCriterion("equipment_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescEqualTo(String value) {
            addCriterion("equipment_desc =", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescNotEqualTo(String value) {
            addCriterion("equipment_desc <>", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescGreaterThan(String value) {
            addCriterion("equipment_desc >", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_desc >=", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescLessThan(String value) {
            addCriterion("equipment_desc <", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescLessThanOrEqualTo(String value) {
            addCriterion("equipment_desc <=", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescLike(String value) {
            addCriterion("equipment_desc like", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescNotLike(String value) {
            addCriterion("equipment_desc not like", value, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescIn(List<String> values) {
            addCriterion("equipment_desc in", values, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescNotIn(List<String> values) {
            addCriterion("equipment_desc not in", values, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescBetween(String value1, String value2) {
            addCriterion("equipment_desc between", value1, value2, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andEquipmentDescNotBetween(String value1, String value2) {
            addCriterion("equipment_desc not between", value1, value2, "equipmentDesc");
            return (Criteria) this;
        }

        public Criteria andWorkMemberIsNull() {
            addCriterion("work_member is null");
            return (Criteria) this;
        }

        public Criteria andWorkMemberIsNotNull() {
            addCriterion("work_member is not null");
            return (Criteria) this;
        }

        public Criteria andWorkMemberEqualTo(String value) {
            addCriterion("work_member =", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberNotEqualTo(String value) {
            addCriterion("work_member <>", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberGreaterThan(String value) {
            addCriterion("work_member >", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberGreaterThanOrEqualTo(String value) {
            addCriterion("work_member >=", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberLessThan(String value) {
            addCriterion("work_member <", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberLessThanOrEqualTo(String value) {
            addCriterion("work_member <=", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberLike(String value) {
            addCriterion("work_member like", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberNotLike(String value) {
            addCriterion("work_member not like", value, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberIn(List<String> values) {
            addCriterion("work_member in", values, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberNotIn(List<String> values) {
            addCriterion("work_member not in", values, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberBetween(String value1, String value2) {
            addCriterion("work_member between", value1, value2, "workMember");
            return (Criteria) this;
        }

        public Criteria andWorkMemberNotBetween(String value1, String value2) {
            addCriterion("work_member not between", value1, value2, "workMember");
            return (Criteria) this;
        }

        public Criteria andMemberNumIsNull() {
            addCriterion("member_num is null");
            return (Criteria) this;
        }

        public Criteria andMemberNumIsNotNull() {
            addCriterion("member_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNumEqualTo(Integer value) {
            addCriterion("member_num =", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotEqualTo(Integer value) {
            addCriterion("member_num <>", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThan(Integer value) {
            addCriterion("member_num >", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_num >=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThan(Integer value) {
            addCriterion("member_num <", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThanOrEqualTo(Integer value) {
            addCriterion("member_num <=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumIn(List<Integer> values) {
            addCriterion("member_num in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotIn(List<Integer> values) {
            addCriterion("member_num not in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumBetween(Integer value1, Integer value2) {
            addCriterion("member_num between", value1, value2, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotBetween(Integer value1, Integer value2) {
            addCriterion("member_num not between", value1, value2, "memberNum");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemIsNull() {
            addCriterion("double_naem is null");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemIsNotNull() {
            addCriterion("double_naem is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemEqualTo(String value) {
            addCriterion("double_naem =", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemNotEqualTo(String value) {
            addCriterion("double_naem <>", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemGreaterThan(String value) {
            addCriterion("double_naem >", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemGreaterThanOrEqualTo(String value) {
            addCriterion("double_naem >=", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemLessThan(String value) {
            addCriterion("double_naem <", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemLessThanOrEqualTo(String value) {
            addCriterion("double_naem <=", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemLike(String value) {
            addCriterion("double_naem like", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemNotLike(String value) {
            addCriterion("double_naem not like", value, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemIn(List<String> values) {
            addCriterion("double_naem in", values, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemNotIn(List<String> values) {
            addCriterion("double_naem not in", values, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemBetween(String value1, String value2) {
            addCriterion("double_naem between", value1, value2, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andDoubleNaemNotBetween(String value1, String value2) {
            addCriterion("double_naem not between", value1, value2, "doubleNaem");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkConditionIsNull() {
            addCriterion("work_condition is null");
            return (Criteria) this;
        }

        public Criteria andWorkConditionIsNotNull() {
            addCriterion("work_condition is not null");
            return (Criteria) this;
        }

        public Criteria andWorkConditionEqualTo(String value) {
            addCriterion("work_condition =", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionNotEqualTo(String value) {
            addCriterion("work_condition <>", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionGreaterThan(String value) {
            addCriterion("work_condition >", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionGreaterThanOrEqualTo(String value) {
            addCriterion("work_condition >=", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionLessThan(String value) {
            addCriterion("work_condition <", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionLessThanOrEqualTo(String value) {
            addCriterion("work_condition <=", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionLike(String value) {
            addCriterion("work_condition like", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionNotLike(String value) {
            addCriterion("work_condition not like", value, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionIn(List<String> values) {
            addCriterion("work_condition in", values, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionNotIn(List<String> values) {
            addCriterion("work_condition not in", values, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionBetween(String value1, String value2) {
            addCriterion("work_condition between", value1, value2, "workCondition");
            return (Criteria) this;
        }

        public Criteria andWorkConditionNotBetween(String value1, String value2) {
            addCriterion("work_condition not between", value1, value2, "workCondition");
            return (Criteria) this;
        }

        public Criteria andSignerIsNull() {
            addCriterion("signer is null");
            return (Criteria) this;
        }

        public Criteria andSignerIsNotNull() {
            addCriterion("signer is not null");
            return (Criteria) this;
        }

        public Criteria andSignerEqualTo(String value) {
            addCriterion("signer =", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotEqualTo(String value) {
            addCriterion("signer <>", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerGreaterThan(String value) {
            addCriterion("signer >", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerGreaterThanOrEqualTo(String value) {
            addCriterion("signer >=", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLessThan(String value) {
            addCriterion("signer <", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLessThanOrEqualTo(String value) {
            addCriterion("signer <=", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerLike(String value) {
            addCriterion("signer like", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotLike(String value) {
            addCriterion("signer not like", value, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerIn(List<String> values) {
            addCriterion("signer in", values, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotIn(List<String> values) {
            addCriterion("signer not in", values, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerBetween(String value1, String value2) {
            addCriterion("signer between", value1, value2, "signer");
            return (Criteria) this;
        }

        public Criteria andSignerNotBetween(String value1, String value2) {
            addCriterion("signer not between", value1, value2, "signer");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNull() {
            addCriterion("sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(Date value) {
            addCriterion("sign_time =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(Date value) {
            addCriterion("sign_time <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(Date value) {
            addCriterion("sign_time >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_time >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(Date value) {
            addCriterion("sign_time <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_time <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<Date> values) {
            addCriterion("sign_time in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<Date> values) {
            addCriterion("sign_time not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(Date value1, Date value2) {
            addCriterion("sign_time between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_time not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonIsNull() {
            addCriterion("run_main_person is null");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonIsNotNull() {
            addCriterion("run_main_person is not null");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonEqualTo(String value) {
            addCriterion("run_main_person =", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonNotEqualTo(String value) {
            addCriterion("run_main_person <>", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonGreaterThan(String value) {
            addCriterion("run_main_person >", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonGreaterThanOrEqualTo(String value) {
            addCriterion("run_main_person >=", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonLessThan(String value) {
            addCriterion("run_main_person <", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonLessThanOrEqualTo(String value) {
            addCriterion("run_main_person <=", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonLike(String value) {
            addCriterion("run_main_person like", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonNotLike(String value) {
            addCriterion("run_main_person not like", value, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonIn(List<String> values) {
            addCriterion("run_main_person in", values, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonNotIn(List<String> values) {
            addCriterion("run_main_person not in", values, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonBetween(String value1, String value2) {
            addCriterion("run_main_person between", value1, value2, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andRunMainPersonNotBetween(String value1, String value2) {
            addCriterion("run_main_person not between", value1, value2, "runMainPerson");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadIsNull() {
            addCriterion("receive_head is null");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadIsNotNull() {
            addCriterion("receive_head is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadEqualTo(String value) {
            addCriterion("receive_head =", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadNotEqualTo(String value) {
            addCriterion("receive_head <>", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadGreaterThan(String value) {
            addCriterion("receive_head >", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadGreaterThanOrEqualTo(String value) {
            addCriterion("receive_head >=", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadLessThan(String value) {
            addCriterion("receive_head <", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadLessThanOrEqualTo(String value) {
            addCriterion("receive_head <=", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadLike(String value) {
            addCriterion("receive_head like", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadNotLike(String value) {
            addCriterion("receive_head not like", value, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadIn(List<String> values) {
            addCriterion("receive_head in", values, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadNotIn(List<String> values) {
            addCriterion("receive_head not in", values, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadBetween(String value1, String value2) {
            addCriterion("receive_head between", value1, value2, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveHeadNotBetween(String value1, String value2) {
            addCriterion("receive_head not between", value1, value2, "receiveHead");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorIsNull() {
            addCriterion("scene_licensor is null");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorIsNotNull() {
            addCriterion("scene_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorEqualTo(String value) {
            addCriterion("scene_licensor =", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorNotEqualTo(String value) {
            addCriterion("scene_licensor <>", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorGreaterThan(String value) {
            addCriterion("scene_licensor >", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("scene_licensor >=", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorLessThan(String value) {
            addCriterion("scene_licensor <", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorLessThanOrEqualTo(String value) {
            addCriterion("scene_licensor <=", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorLike(String value) {
            addCriterion("scene_licensor like", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorNotLike(String value) {
            addCriterion("scene_licensor not like", value, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorIn(List<String> values) {
            addCriterion("scene_licensor in", values, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorNotIn(List<String> values) {
            addCriterion("scene_licensor not in", values, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorBetween(String value1, String value2) {
            addCriterion("scene_licensor between", value1, value2, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andSceneLicensorNotBetween(String value1, String value2) {
            addCriterion("scene_licensor not between", value1, value2, "sceneLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorIsNull() {
            addCriterion("run_licensor is null");
            return (Criteria) this;
        }

        public Criteria andRunLicensorIsNotNull() {
            addCriterion("run_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andRunLicensorEqualTo(String value) {
            addCriterion("run_licensor =", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorNotEqualTo(String value) {
            addCriterion("run_licensor <>", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorGreaterThan(String value) {
            addCriterion("run_licensor >", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("run_licensor >=", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorLessThan(String value) {
            addCriterion("run_licensor <", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorLessThanOrEqualTo(String value) {
            addCriterion("run_licensor <=", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorLike(String value) {
            addCriterion("run_licensor like", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorNotLike(String value) {
            addCriterion("run_licensor not like", value, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorIn(List<String> values) {
            addCriterion("run_licensor in", values, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorNotIn(List<String> values) {
            addCriterion("run_licensor not in", values, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorBetween(String value1, String value2) {
            addCriterion("run_licensor between", value1, value2, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andRunLicensorNotBetween(String value1, String value2) {
            addCriterion("run_licensor not between", value1, value2, "runLicensor");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeIsNull() {
            addCriterion("license_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeIsNotNull() {
            addCriterion("license_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeEqualTo(Date value) {
            addCriterion("license_start_time =", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeNotEqualTo(Date value) {
            addCriterion("license_start_time <>", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeGreaterThan(Date value) {
            addCriterion("license_start_time >", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("license_start_time >=", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeLessThan(Date value) {
            addCriterion("license_start_time <", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("license_start_time <=", value, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeIn(List<Date> values) {
            addCriterion("license_start_time in", values, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeNotIn(List<Date> values) {
            addCriterion("license_start_time not in", values, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeBetween(Date value1, Date value2) {
            addCriterion("license_start_time between", value1, value2, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andLicenseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("license_start_time not between", value1, value2, "licenseStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionIsNull() {
            addCriterion("work_team_opinion is null");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionIsNotNull() {
            addCriterion("work_team_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionEqualTo(String value) {
            addCriterion("work_team_opinion =", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionNotEqualTo(String value) {
            addCriterion("work_team_opinion <>", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionGreaterThan(String value) {
            addCriterion("work_team_opinion >", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("work_team_opinion >=", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionLessThan(String value) {
            addCriterion("work_team_opinion <", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionLessThanOrEqualTo(String value) {
            addCriterion("work_team_opinion <=", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionLike(String value) {
            addCriterion("work_team_opinion like", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionNotLike(String value) {
            addCriterion("work_team_opinion not like", value, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionIn(List<String> values) {
            addCriterion("work_team_opinion in", values, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionNotIn(List<String> values) {
            addCriterion("work_team_opinion not in", values, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionBetween(String value1, String value2) {
            addCriterion("work_team_opinion between", value1, value2, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkTeamOpinionNotBetween(String value1, String value2) {
            addCriterion("work_team_opinion not between", value1, value2, "workTeamOpinion");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToIsNull() {
            addCriterion("head_change_to is null");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToIsNotNull() {
            addCriterion("head_change_to is not null");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToEqualTo(String value) {
            addCriterion("head_change_to =", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToNotEqualTo(String value) {
            addCriterion("head_change_to <>", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToGreaterThan(String value) {
            addCriterion("head_change_to >", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToGreaterThanOrEqualTo(String value) {
            addCriterion("head_change_to >=", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToLessThan(String value) {
            addCriterion("head_change_to <", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToLessThanOrEqualTo(String value) {
            addCriterion("head_change_to <=", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToLike(String value) {
            addCriterion("head_change_to like", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToNotLike(String value) {
            addCriterion("head_change_to not like", value, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToIn(List<String> values) {
            addCriterion("head_change_to in", values, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToNotIn(List<String> values) {
            addCriterion("head_change_to not in", values, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToBetween(String value1, String value2) {
            addCriterion("head_change_to between", value1, value2, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeToNotBetween(String value1, String value2) {
            addCriterion("head_change_to not between", value1, value2, "headChangeTo");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerIsNull() {
            addCriterion("head_change_signer is null");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerIsNotNull() {
            addCriterion("head_change_signer is not null");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerEqualTo(String value) {
            addCriterion("head_change_signer =", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerNotEqualTo(String value) {
            addCriterion("head_change_signer <>", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerGreaterThan(String value) {
            addCriterion("head_change_signer >", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerGreaterThanOrEqualTo(String value) {
            addCriterion("head_change_signer >=", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerLessThan(String value) {
            addCriterion("head_change_signer <", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerLessThanOrEqualTo(String value) {
            addCriterion("head_change_signer <=", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerLike(String value) {
            addCriterion("head_change_signer like", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerNotLike(String value) {
            addCriterion("head_change_signer not like", value, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerIn(List<String> values) {
            addCriterion("head_change_signer in", values, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerNotIn(List<String> values) {
            addCriterion("head_change_signer not in", values, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerBetween(String value1, String value2) {
            addCriterion("head_change_signer between", value1, value2, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChangeSignerNotBetween(String value1, String value2) {
            addCriterion("head_change_signer not between", value1, value2, "headChangeSigner");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeIsNull() {
            addCriterion("head_chaneg_time is null");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeIsNotNull() {
            addCriterion("head_chaneg_time is not null");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeEqualTo(Date value) {
            addCriterion("head_chaneg_time =", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeNotEqualTo(Date value) {
            addCriterion("head_chaneg_time <>", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeGreaterThan(Date value) {
            addCriterion("head_chaneg_time >", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("head_chaneg_time >=", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeLessThan(Date value) {
            addCriterion("head_chaneg_time <", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeLessThanOrEqualTo(Date value) {
            addCriterion("head_chaneg_time <=", value, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeIn(List<Date> values) {
            addCriterion("head_chaneg_time in", values, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeNotIn(List<Date> values) {
            addCriterion("head_chaneg_time not in", values, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeBetween(Date value1, Date value2) {
            addCriterion("head_chaneg_time between", value1, value2, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andHeadChanegTimeNotBetween(Date value1, Date value2) {
            addCriterion("head_chaneg_time not between", value1, value2, "headChanegTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNull() {
            addCriterion("delay_time is null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNotNull() {
            addCriterion("delay_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeEqualTo(Date value) {
            addCriterion("delay_time =", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotEqualTo(Date value) {
            addCriterion("delay_time <>", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThan(Date value) {
            addCriterion("delay_time >", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delay_time >=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThan(Date value) {
            addCriterion("delay_time <", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThanOrEqualTo(Date value) {
            addCriterion("delay_time <=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIn(List<Date> values) {
            addCriterion("delay_time in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotIn(List<Date> values) {
            addCriterion("delay_time not in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeBetween(Date value1, Date value2) {
            addCriterion("delay_time between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotBetween(Date value1, Date value2) {
            addCriterion("delay_time not between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadIsNull() {
            addCriterion("delay_head is null");
            return (Criteria) this;
        }

        public Criteria andDelayHeadIsNotNull() {
            addCriterion("delay_head is not null");
            return (Criteria) this;
        }

        public Criteria andDelayHeadEqualTo(String value) {
            addCriterion("delay_head =", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadNotEqualTo(String value) {
            addCriterion("delay_head <>", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadGreaterThan(String value) {
            addCriterion("delay_head >", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadGreaterThanOrEqualTo(String value) {
            addCriterion("delay_head >=", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadLessThan(String value) {
            addCriterion("delay_head <", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadLessThanOrEqualTo(String value) {
            addCriterion("delay_head <=", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadLike(String value) {
            addCriterion("delay_head like", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadNotLike(String value) {
            addCriterion("delay_head not like", value, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadIn(List<String> values) {
            addCriterion("delay_head in", values, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadNotIn(List<String> values) {
            addCriterion("delay_head not in", values, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadBetween(String value1, String value2) {
            addCriterion("delay_head between", value1, value2, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadNotBetween(String value1, String value2) {
            addCriterion("delay_head not between", value1, value2, "delayHead");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeIsNull() {
            addCriterion("delay_head_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeIsNotNull() {
            addCriterion("delay_head_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeEqualTo(Date value) {
            addCriterion("delay_head_sign_time =", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeNotEqualTo(Date value) {
            addCriterion("delay_head_sign_time <>", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeGreaterThan(Date value) {
            addCriterion("delay_head_sign_time >", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delay_head_sign_time >=", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeLessThan(Date value) {
            addCriterion("delay_head_sign_time <", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("delay_head_sign_time <=", value, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeIn(List<Date> values) {
            addCriterion("delay_head_sign_time in", values, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeNotIn(List<Date> values) {
            addCriterion("delay_head_sign_time not in", values, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeBetween(Date value1, Date value2) {
            addCriterion("delay_head_sign_time between", value1, value2, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayHeadSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("delay_head_sign_time not between", value1, value2, "delayHeadSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorIsNull() {
            addCriterion("delay_licensor is null");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorIsNotNull() {
            addCriterion("delay_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorEqualTo(String value) {
            addCriterion("delay_licensor =", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorNotEqualTo(String value) {
            addCriterion("delay_licensor <>", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorGreaterThan(String value) {
            addCriterion("delay_licensor >", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("delay_licensor >=", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorLessThan(String value) {
            addCriterion("delay_licensor <", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorLessThanOrEqualTo(String value) {
            addCriterion("delay_licensor <=", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorLike(String value) {
            addCriterion("delay_licensor like", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorNotLike(String value) {
            addCriterion("delay_licensor not like", value, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorIn(List<String> values) {
            addCriterion("delay_licensor in", values, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorNotIn(List<String> values) {
            addCriterion("delay_licensor not in", values, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorBetween(String value1, String value2) {
            addCriterion("delay_licensor between", value1, value2, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorNotBetween(String value1, String value2) {
            addCriterion("delay_licensor not between", value1, value2, "delayLicensor");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeIsNull() {
            addCriterion("delay_licensor_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeIsNotNull() {
            addCriterion("delay_licensor_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeEqualTo(Date value) {
            addCriterion("delay_licensor_sign_time =", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeNotEqualTo(Date value) {
            addCriterion("delay_licensor_sign_time <>", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeGreaterThan(Date value) {
            addCriterion("delay_licensor_sign_time >", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delay_licensor_sign_time >=", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeLessThan(Date value) {
            addCriterion("delay_licensor_sign_time <", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("delay_licensor_sign_time <=", value, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeIn(List<Date> values) {
            addCriterion("delay_licensor_sign_time in", values, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeNotIn(List<Date> values) {
            addCriterion("delay_licensor_sign_time not in", values, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeBetween(Date value1, Date value2) {
            addCriterion("delay_licensor_sign_time between", value1, value2, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andDelayLicensorSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("delay_licensor_sign_time not between", value1, value2, "delayLicensorSignTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIsNull() {
            addCriterion("work_end_head is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIsNotNull() {
            addCriterion("work_end_head is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadEqualTo(String value) {
            addCriterion("work_end_head =", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotEqualTo(String value) {
            addCriterion("work_end_head <>", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadGreaterThan(String value) {
            addCriterion("work_end_head >", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadGreaterThanOrEqualTo(String value) {
            addCriterion("work_end_head >=", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLessThan(String value) {
            addCriterion("work_end_head <", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLessThanOrEqualTo(String value) {
            addCriterion("work_end_head <=", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadLike(String value) {
            addCriterion("work_end_head like", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotLike(String value) {
            addCriterion("work_end_head not like", value, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadIn(List<String> values) {
            addCriterion("work_end_head in", values, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotIn(List<String> values) {
            addCriterion("work_end_head not in", values, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadBetween(String value1, String value2) {
            addCriterion("work_end_head between", value1, value2, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndHeadNotBetween(String value1, String value2) {
            addCriterion("work_end_head not between", value1, value2, "workEndHead");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIsNull() {
            addCriterion("work_end_licensor is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIsNotNull() {
            addCriterion("work_end_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorEqualTo(String value) {
            addCriterion("work_end_licensor =", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotEqualTo(String value) {
            addCriterion("work_end_licensor <>", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorGreaterThan(String value) {
            addCriterion("work_end_licensor >", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("work_end_licensor >=", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLessThan(String value) {
            addCriterion("work_end_licensor <", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLessThanOrEqualTo(String value) {
            addCriterion("work_end_licensor <=", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorLike(String value) {
            addCriterion("work_end_licensor like", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotLike(String value) {
            addCriterion("work_end_licensor not like", value, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorIn(List<String> values) {
            addCriterion("work_end_licensor in", values, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotIn(List<String> values) {
            addCriterion("work_end_licensor not in", values, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorBetween(String value1, String value2) {
            addCriterion("work_end_licensor between", value1, value2, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndLicensorNotBetween(String value1, String value2) {
            addCriterion("work_end_licensor not between", value1, value2, "workEndLicensor");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNull() {
            addCriterion("work_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNotNull() {
            addCriterion("work_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeEqualTo(Date value) {
            addCriterion("work_end_time =", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotEqualTo(Date value) {
            addCriterion("work_end_time <>", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThan(Date value) {
            addCriterion("work_end_time >", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("work_end_time >=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThan(Date value) {
            addCriterion("work_end_time <", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("work_end_time <=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIn(List<Date> values) {
            addCriterion("work_end_time in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotIn(List<Date> values) {
            addCriterion("work_end_time not in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeBetween(Date value1, Date value2) {
            addCriterion("work_end_time between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("work_end_time not between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorIsNull() {
            addCriterion("ticket_end_licensor is null");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorIsNotNull() {
            addCriterion("ticket_end_licensor is not null");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorEqualTo(String value) {
            addCriterion("ticket_end_licensor =", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorNotEqualTo(String value) {
            addCriterion("ticket_end_licensor <>", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorGreaterThan(String value) {
            addCriterion("ticket_end_licensor >", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_end_licensor >=", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorLessThan(String value) {
            addCriterion("ticket_end_licensor <", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorLessThanOrEqualTo(String value) {
            addCriterion("ticket_end_licensor <=", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorLike(String value) {
            addCriterion("ticket_end_licensor like", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorNotLike(String value) {
            addCriterion("ticket_end_licensor not like", value, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorIn(List<String> values) {
            addCriterion("ticket_end_licensor in", values, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorNotIn(List<String> values) {
            addCriterion("ticket_end_licensor not in", values, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorBetween(String value1, String value2) {
            addCriterion("ticket_end_licensor between", value1, value2, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndLicensorNotBetween(String value1, String value2) {
            addCriterion("ticket_end_licensor not between", value1, value2, "ticketEndLicensor");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIsNull() {
            addCriterion("ticket_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIsNotNull() {
            addCriterion("ticket_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeEqualTo(Date value) {
            addCriterion("ticket_end_time =", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotEqualTo(Date value) {
            addCriterion("ticket_end_time <>", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeGreaterThan(Date value) {
            addCriterion("ticket_end_time >", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ticket_end_time >=", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeLessThan(Date value) {
            addCriterion("ticket_end_time <", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("ticket_end_time <=", value, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeIn(List<Date> values) {
            addCriterion("ticket_end_time in", values, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotIn(List<Date> values) {
            addCriterion("ticket_end_time not in", values, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeBetween(Date value1, Date value2) {
            addCriterion("ticket_end_time between", value1, value2, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andTicketEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("ticket_end_time not between", value1, value2, "ticketEndTime");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberIsNull() {
            addCriterion("unuse_wire_number is null");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberIsNotNull() {
            addCriterion("unuse_wire_number is not null");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberEqualTo(String value) {
            addCriterion("unuse_wire_number =", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberNotEqualTo(String value) {
            addCriterion("unuse_wire_number <>", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberGreaterThan(String value) {
            addCriterion("unuse_wire_number >", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberGreaterThanOrEqualTo(String value) {
            addCriterion("unuse_wire_number >=", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberLessThan(String value) {
            addCriterion("unuse_wire_number <", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberLessThanOrEqualTo(String value) {
            addCriterion("unuse_wire_number <=", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberLike(String value) {
            addCriterion("unuse_wire_number like", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberNotLike(String value) {
            addCriterion("unuse_wire_number not like", value, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberIn(List<String> values) {
            addCriterion("unuse_wire_number in", values, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberNotIn(List<String> values) {
            addCriterion("unuse_wire_number not in", values, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberBetween(String value1, String value2) {
            addCriterion("unuse_wire_number between", value1, value2, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumberNotBetween(String value1, String value2) {
            addCriterion("unuse_wire_number not between", value1, value2, "unuseWireNumber");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumIsNull() {
            addCriterion("unuse_wire_num is null");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumIsNotNull() {
            addCriterion("unuse_wire_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumEqualTo(Integer value) {
            addCriterion("unuse_wire_num =", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumNotEqualTo(Integer value) {
            addCriterion("unuse_wire_num <>", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumGreaterThan(Integer value) {
            addCriterion("unuse_wire_num >", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unuse_wire_num >=", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumLessThan(Integer value) {
            addCriterion("unuse_wire_num <", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumLessThanOrEqualTo(Integer value) {
            addCriterion("unuse_wire_num <=", value, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumIn(List<Integer> values) {
            addCriterion("unuse_wire_num in", values, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumNotIn(List<Integer> values) {
            addCriterion("unuse_wire_num not in", values, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumBetween(Integer value1, Integer value2) {
            addCriterion("unuse_wire_num between", value1, value2, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andUnuseWireNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unuse_wire_num not between", value1, value2, "unuseWireNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumIsNull() {
            addCriterion("knife_car_num is null");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumIsNotNull() {
            addCriterion("knife_car_num is not null");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumEqualTo(Integer value) {
            addCriterion("knife_car_num =", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumNotEqualTo(Integer value) {
            addCriterion("knife_car_num <>", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumGreaterThan(Integer value) {
            addCriterion("knife_car_num >", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("knife_car_num >=", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumLessThan(Integer value) {
            addCriterion("knife_car_num <", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumLessThanOrEqualTo(Integer value) {
            addCriterion("knife_car_num <=", value, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumIn(List<Integer> values) {
            addCriterion("knife_car_num in", values, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumNotIn(List<Integer> values) {
            addCriterion("knife_car_num not in", values, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumBetween(Integer value1, Integer value2) {
            addCriterion("knife_car_num between", value1, value2, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andKnifeCarNumNotBetween(Integer value1, Integer value2) {
            addCriterion("knife_car_num not between", value1, value2, "knifeCarNum");
            return (Criteria) this;
        }

        public Criteria andGuardianIsNull() {
            addCriterion("guardian is null");
            return (Criteria) this;
        }

        public Criteria andGuardianIsNotNull() {
            addCriterion("guardian is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianEqualTo(String value) {
            addCriterion("guardian =", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotEqualTo(String value) {
            addCriterion("guardian <>", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianGreaterThan(String value) {
            addCriterion("guardian >", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianGreaterThanOrEqualTo(String value) {
            addCriterion("guardian >=", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLessThan(String value) {
            addCriterion("guardian <", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLessThanOrEqualTo(String value) {
            addCriterion("guardian <=", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianLike(String value) {
            addCriterion("guardian like", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotLike(String value) {
            addCriterion("guardian not like", value, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianIn(List<String> values) {
            addCriterion("guardian in", values, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotIn(List<String> values) {
            addCriterion("guardian not in", values, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianBetween(String value1, String value2) {
            addCriterion("guardian between", value1, value2, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianNotBetween(String value1, String value2) {
            addCriterion("guardian not between", value1, value2, "guardian");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContIsNull() {
            addCriterion("guardian_place_and_cont is null");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContIsNotNull() {
            addCriterion("guardian_place_and_cont is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContEqualTo(String value) {
            addCriterion("guardian_place_and_cont =", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContNotEqualTo(String value) {
            addCriterion("guardian_place_and_cont <>", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContGreaterThan(String value) {
            addCriterion("guardian_place_and_cont >", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_place_and_cont >=", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContLessThan(String value) {
            addCriterion("guardian_place_and_cont <", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContLessThanOrEqualTo(String value) {
            addCriterion("guardian_place_and_cont <=", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContLike(String value) {
            addCriterion("guardian_place_and_cont like", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContNotLike(String value) {
            addCriterion("guardian_place_and_cont not like", value, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContIn(List<String> values) {
            addCriterion("guardian_place_and_cont in", values, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContNotIn(List<String> values) {
            addCriterion("guardian_place_and_cont not in", values, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContBetween(String value1, String value2) {
            addCriterion("guardian_place_and_cont between", value1, value2, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianPlaceAndContNotBetween(String value1, String value2) {
            addCriterion("guardian_place_and_cont not between", value1, value2, "guardianPlaceAndCont");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingIsNull() {
            addCriterion("guardian_other_thing is null");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingIsNotNull() {
            addCriterion("guardian_other_thing is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingEqualTo(String value) {
            addCriterion("guardian_other_thing =", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingNotEqualTo(String value) {
            addCriterion("guardian_other_thing <>", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingGreaterThan(String value) {
            addCriterion("guardian_other_thing >", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_other_thing >=", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingLessThan(String value) {
            addCriterion("guardian_other_thing <", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingLessThanOrEqualTo(String value) {
            addCriterion("guardian_other_thing <=", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingLike(String value) {
            addCriterion("guardian_other_thing like", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingNotLike(String value) {
            addCriterion("guardian_other_thing not like", value, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingIn(List<String> values) {
            addCriterion("guardian_other_thing in", values, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingNotIn(List<String> values) {
            addCriterion("guardian_other_thing not in", values, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingBetween(String value1, String value2) {
            addCriterion("guardian_other_thing between", value1, value2, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andGuardianOtherThingNotBetween(String value1, String value2) {
            addCriterion("guardian_other_thing not between", value1, value2, "guardianOtherThing");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNull() {
            addCriterion("evaluation is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNotNull() {
            addCriterion("evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationEqualTo(String value) {
            addCriterion("evaluation =", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotEqualTo(String value) {
            addCriterion("evaluation <>", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThan(String value) {
            addCriterion("evaluation >", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation >=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThan(String value) {
            addCriterion("evaluation <", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThanOrEqualTo(String value) {
            addCriterion("evaluation <=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLike(String value) {
            addCriterion("evaluation like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotLike(String value) {
            addCriterion("evaluation not like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationIn(List<String> values) {
            addCriterion("evaluation in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotIn(List<String> values) {
            addCriterion("evaluation not in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationBetween(String value1, String value2) {
            addCriterion("evaluation between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotBetween(String value1, String value2) {
            addCriterion("evaluation not between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationContIsNull() {
            addCriterion("evaluation_cont is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationContIsNotNull() {
            addCriterion("evaluation_cont is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationContEqualTo(String value) {
            addCriterion("evaluation_cont =", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContNotEqualTo(String value) {
            addCriterion("evaluation_cont <>", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContGreaterThan(String value) {
            addCriterion("evaluation_cont >", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_cont >=", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContLessThan(String value) {
            addCriterion("evaluation_cont <", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContLessThanOrEqualTo(String value) {
            addCriterion("evaluation_cont <=", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContLike(String value) {
            addCriterion("evaluation_cont like", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContNotLike(String value) {
            addCriterion("evaluation_cont not like", value, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContIn(List<String> values) {
            addCriterion("evaluation_cont in", values, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContNotIn(List<String> values) {
            addCriterion("evaluation_cont not in", values, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContBetween(String value1, String value2) {
            addCriterion("evaluation_cont between", value1, value2, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationContNotBetween(String value1, String value2) {
            addCriterion("evaluation_cont not between", value1, value2, "evaluationCont");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeIsNull() {
            addCriterion("evaluation_time is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeIsNotNull() {
            addCriterion("evaluation_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeEqualTo(Date value) {
            addCriterion("evaluation_time =", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotEqualTo(Date value) {
            addCriterion("evaluation_time <>", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeGreaterThan(Date value) {
            addCriterion("evaluation_time >", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evaluation_time >=", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeLessThan(Date value) {
            addCriterion("evaluation_time <", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeLessThanOrEqualTo(Date value) {
            addCriterion("evaluation_time <=", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeIn(List<Date> values) {
            addCriterion("evaluation_time in", values, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotIn(List<Date> values) {
            addCriterion("evaluation_time not in", values, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeBetween(Date value1, Date value2) {
            addCriterion("evaluation_time between", value1, value2, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotBetween(Date value1, Date value2) {
            addCriterion("evaluation_time not between", value1, value2, "evaluationTime");
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