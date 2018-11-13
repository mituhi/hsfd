package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OperateTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateTicketExample() {
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

        public Criteria andOperTicketTypeIdIsNull() {
            addCriterion("oper_ticket_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdIsNotNull() {
            addCriterion("oper_ticket_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdEqualTo(String value) {
            addCriterion("oper_ticket_type_id =", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotEqualTo(String value) {
            addCriterion("oper_ticket_type_id <>", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdGreaterThan(String value) {
            addCriterion("oper_ticket_type_id >", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("oper_ticket_type_id >=", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLessThan(String value) {
            addCriterion("oper_ticket_type_id <", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLessThanOrEqualTo(String value) {
            addCriterion("oper_ticket_type_id <=", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdLike(String value) {
            addCriterion("oper_ticket_type_id like", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotLike(String value) {
            addCriterion("oper_ticket_type_id not like", value, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdIn(List<String> values) {
            addCriterion("oper_ticket_type_id in", values, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotIn(List<String> values) {
            addCriterion("oper_ticket_type_id not in", values, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdBetween(String value1, String value2) {
            addCriterion("oper_ticket_type_id between", value1, value2, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andOperTicketTypeIdNotBetween(String value1, String value2) {
            addCriterion("oper_ticket_type_id not between", value1, value2, "operTicketTypeId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdIsNull() {
            addCriterion("typical_ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdIsNotNull() {
            addCriterion("typical_ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdEqualTo(String value) {
            addCriterion("typical_ticket_id =", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotEqualTo(String value) {
            addCriterion("typical_ticket_id <>", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdGreaterThan(String value) {
            addCriterion("typical_ticket_id >", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("typical_ticket_id >=", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLessThan(String value) {
            addCriterion("typical_ticket_id <", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLessThanOrEqualTo(String value) {
            addCriterion("typical_ticket_id <=", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdLike(String value) {
            addCriterion("typical_ticket_id like", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotLike(String value) {
            addCriterion("typical_ticket_id not like", value, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdIn(List<String> values) {
            addCriterion("typical_ticket_id in", values, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotIn(List<String> values) {
            addCriterion("typical_ticket_id not in", values, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdBetween(String value1, String value2) {
            addCriterion("typical_ticket_id between", value1, value2, "typicalTicketId");
            return (Criteria) this;
        }

        public Criteria andTypicalTicketIdNotBetween(String value1, String value2) {
            addCriterion("typical_ticket_id not between", value1, value2, "typicalTicketId");
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

        public Criteria andFlowStepIsNull() {
            addCriterion("flow_step is null");
            return (Criteria) this;
        }

        public Criteria andFlowStepIsNotNull() {
            addCriterion("flow_step is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStepEqualTo(String value) {
            addCriterion("flow_step =", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepNotEqualTo(String value) {
            addCriterion("flow_step <>", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepGreaterThan(String value) {
            addCriterion("flow_step >", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepGreaterThanOrEqualTo(String value) {
            addCriterion("flow_step >=", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepLessThan(String value) {
            addCriterion("flow_step <", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepLessThanOrEqualTo(String value) {
            addCriterion("flow_step <=", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepLike(String value) {
            addCriterion("flow_step like", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepNotLike(String value) {
            addCriterion("flow_step not like", value, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepIn(List<String> values) {
            addCriterion("flow_step in", values, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepNotIn(List<String> values) {
            addCriterion("flow_step not in", values, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepBetween(String value1, String value2) {
            addCriterion("flow_step between", value1, value2, "flowStep");
            return (Criteria) this;
        }

        public Criteria andFlowStepNotBetween(String value1, String value2) {
            addCriterion("flow_step not between", value1, value2, "flowStep");
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

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
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

        public Criteria andExecuterIsNull() {
            addCriterion("executer is null");
            return (Criteria) this;
        }

        public Criteria andExecuterIsNotNull() {
            addCriterion("executer is not null");
            return (Criteria) this;
        }

        public Criteria andExecuterEqualTo(String value) {
            addCriterion("executer =", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterNotEqualTo(String value) {
            addCriterion("executer <>", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterGreaterThan(String value) {
            addCriterion("executer >", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterGreaterThanOrEqualTo(String value) {
            addCriterion("executer >=", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterLessThan(String value) {
            addCriterion("executer <", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterLessThanOrEqualTo(String value) {
            addCriterion("executer <=", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterLike(String value) {
            addCriterion("executer like", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterNotLike(String value) {
            addCriterion("executer not like", value, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterIn(List<String> values) {
            addCriterion("executer in", values, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterNotIn(List<String> values) {
            addCriterion("executer not in", values, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterBetween(String value1, String value2) {
            addCriterion("executer between", value1, value2, "executer");
            return (Criteria) this;
        }

        public Criteria andExecuterNotBetween(String value1, String value2) {
            addCriterion("executer not between", value1, value2, "executer");
            return (Criteria) this;
        }

        public Criteria andSupervisiorIsNull() {
            addCriterion("supervisior is null");
            return (Criteria) this;
        }

        public Criteria andSupervisiorIsNotNull() {
            addCriterion("supervisior is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisiorEqualTo(String value) {
            addCriterion("supervisior =", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorNotEqualTo(String value) {
            addCriterion("supervisior <>", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorGreaterThan(String value) {
            addCriterion("supervisior >", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorGreaterThanOrEqualTo(String value) {
            addCriterion("supervisior >=", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorLessThan(String value) {
            addCriterion("supervisior <", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorLessThanOrEqualTo(String value) {
            addCriterion("supervisior <=", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorLike(String value) {
            addCriterion("supervisior like", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorNotLike(String value) {
            addCriterion("supervisior not like", value, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorIn(List<String> values) {
            addCriterion("supervisior in", values, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorNotIn(List<String> values) {
            addCriterion("supervisior not in", values, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorBetween(String value1, String value2) {
            addCriterion("supervisior between", value1, value2, "supervisior");
            return (Criteria) this;
        }

        public Criteria andSupervisiorNotBetween(String value1, String value2) {
            addCriterion("supervisior not between", value1, value2, "supervisior");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeIsNull() {
            addCriterion("oper_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeIsNotNull() {
            addCriterion("oper_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeEqualTo(Date value) {
            addCriterion("oper_start_time =", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeNotEqualTo(Date value) {
            addCriterion("oper_start_time <>", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeGreaterThan(Date value) {
            addCriterion("oper_start_time >", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_start_time >=", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeLessThan(Date value) {
            addCriterion("oper_start_time <", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_start_time <=", value, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeIn(List<Date> values) {
            addCriterion("oper_start_time in", values, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeNotIn(List<Date> values) {
            addCriterion("oper_start_time not in", values, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeBetween(Date value1, Date value2) {
            addCriterion("oper_start_time between", value1, value2, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_start_time not between", value1, value2, "operStartTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeIsNull() {
            addCriterion("oper_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeIsNotNull() {
            addCriterion("oper_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeEqualTo(Date value) {
            addCriterion("oper_end_time =", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeNotEqualTo(Date value) {
            addCriterion("oper_end_time <>", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeGreaterThan(Date value) {
            addCriterion("oper_end_time >", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_end_time >=", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeLessThan(Date value) {
            addCriterion("oper_end_time <", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_end_time <=", value, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeIn(List<Date> values) {
            addCriterion("oper_end_time in", values, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeNotIn(List<Date> values) {
            addCriterion("oper_end_time not in", values, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeBetween(Date value1, Date value2) {
            addCriterion("oper_end_time between", value1, value2, "operEndTime");
            return (Criteria) this;
        }

        public Criteria andOperEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_end_time not between", value1, value2, "operEndTime");
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