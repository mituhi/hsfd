package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andTicketCodeIsNull() {
            addCriterion("ticket_code is null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIsNotNull() {
            addCriterion("ticket_code is not null");
            return (Criteria) this;
        }

        public Criteria andTicketCodeEqualTo(String value) {
            addCriterion("ticket_code =", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotEqualTo(String value) {
            addCriterion("ticket_code <>", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThan(String value) {
            addCriterion("ticket_code >", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_code >=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThan(String value) {
            addCriterion("ticket_code <", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLessThanOrEqualTo(String value) {
            addCriterion("ticket_code <=", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeLike(String value) {
            addCriterion("ticket_code like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotLike(String value) {
            addCriterion("ticket_code not like", value, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeIn(List<String> values) {
            addCriterion("ticket_code in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotIn(List<String> values) {
            addCriterion("ticket_code not in", values, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeBetween(String value1, String value2) {
            addCriterion("ticket_code between", value1, value2, "ticketCode");
            return (Criteria) this;
        }

        public Criteria andTicketCodeNotBetween(String value1, String value2) {
            addCriterion("ticket_code not between", value1, value2, "ticketCode");
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andDepartmentsIsNull() {
            addCriterion("departments is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentsIsNotNull() {
            addCriterion("departments is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentsEqualTo(String value) {
            addCriterion("departments =", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsNotEqualTo(String value) {
            addCriterion("departments <>", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsGreaterThan(String value) {
            addCriterion("departments >", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsGreaterThanOrEqualTo(String value) {
            addCriterion("departments >=", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsLessThan(String value) {
            addCriterion("departments <", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsLessThanOrEqualTo(String value) {
            addCriterion("departments <=", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsLike(String value) {
            addCriterion("departments like", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsNotLike(String value) {
            addCriterion("departments not like", value, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsIn(List<String> values) {
            addCriterion("departments in", values, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsNotIn(List<String> values) {
            addCriterion("departments not in", values, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsBetween(String value1, String value2) {
            addCriterion("departments between", value1, value2, "departments");
            return (Criteria) this;
        }

        public Criteria andDepartmentsNotBetween(String value1, String value2) {
            addCriterion("departments not between", value1, value2, "departments");
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

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
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

        public Criteria andMachineSetIsNull() {
            addCriterion("machine_set is null");
            return (Criteria) this;
        }

        public Criteria andMachineSetIsNotNull() {
            addCriterion("machine_set is not null");
            return (Criteria) this;
        }

        public Criteria andMachineSetEqualTo(String value) {
            addCriterion("machine_set =", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetNotEqualTo(String value) {
            addCriterion("machine_set <>", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetGreaterThan(String value) {
            addCriterion("machine_set >", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetGreaterThanOrEqualTo(String value) {
            addCriterion("machine_set >=", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetLessThan(String value) {
            addCriterion("machine_set <", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetLessThanOrEqualTo(String value) {
            addCriterion("machine_set <=", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetLike(String value) {
            addCriterion("machine_set like", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetNotLike(String value) {
            addCriterion("machine_set not like", value, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetIn(List<String> values) {
            addCriterion("machine_set in", values, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetNotIn(List<String> values) {
            addCriterion("machine_set not in", values, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetBetween(String value1, String value2) {
            addCriterion("machine_set between", value1, value2, "machineSet");
            return (Criteria) this;
        }

        public Criteria andMachineSetNotBetween(String value1, String value2) {
            addCriterion("machine_set not between", value1, value2, "machineSet");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andExamineApprovePersonIsNull() {
            addCriterion("examine_approve_person is null");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonIsNotNull() {
            addCriterion("examine_approve_person is not null");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonEqualTo(String value) {
            addCriterion("examine_approve_person =", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonNotEqualTo(String value) {
            addCriterion("examine_approve_person <>", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonGreaterThan(String value) {
            addCriterion("examine_approve_person >", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonGreaterThanOrEqualTo(String value) {
            addCriterion("examine_approve_person >=", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonLessThan(String value) {
            addCriterion("examine_approve_person <", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonLessThanOrEqualTo(String value) {
            addCriterion("examine_approve_person <=", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonLike(String value) {
            addCriterion("examine_approve_person like", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonNotLike(String value) {
            addCriterion("examine_approve_person not like", value, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonIn(List<String> values) {
            addCriterion("examine_approve_person in", values, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonNotIn(List<String> values) {
            addCriterion("examine_approve_person not in", values, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonBetween(String value1, String value2) {
            addCriterion("examine_approve_person between", value1, value2, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andExamineApprovePersonNotBetween(String value1, String value2) {
            addCriterion("examine_approve_person not between", value1, value2, "examineApprovePerson");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
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