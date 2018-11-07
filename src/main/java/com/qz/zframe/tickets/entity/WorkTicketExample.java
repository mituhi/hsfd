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

        public Criteria andSafetyOfficerIsNull() {
            addCriterion("safety_officer is null");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerIsNotNull() {
            addCriterion("safety_officer is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerEqualTo(String value) {
            addCriterion("safety_officer =", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerNotEqualTo(String value) {
            addCriterion("safety_officer <>", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerGreaterThan(String value) {
            addCriterion("safety_officer >", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerGreaterThanOrEqualTo(String value) {
            addCriterion("safety_officer >=", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerLessThan(String value) {
            addCriterion("safety_officer <", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerLessThanOrEqualTo(String value) {
            addCriterion("safety_officer <=", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerLike(String value) {
            addCriterion("safety_officer like", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerNotLike(String value) {
            addCriterion("safety_officer not like", value, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerIn(List<String> values) {
            addCriterion("safety_officer in", values, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerNotIn(List<String> values) {
            addCriterion("safety_officer not in", values, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerBetween(String value1, String value2) {
            addCriterion("safety_officer between", value1, value2, "safetyOfficer");
            return (Criteria) this;
        }

        public Criteria andSafetyOfficerNotBetween(String value1, String value2) {
            addCriterion("safety_officer not between", value1, value2, "safetyOfficer");
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

        public Criteria andWorkUnitIsNull() {
            addCriterion("work_unit is null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNotNull() {
            addCriterion("work_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitEqualTo(String value) {
            addCriterion("work_unit =", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotEqualTo(String value) {
            addCriterion("work_unit <>", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThan(String value) {
            addCriterion("work_unit >", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("work_unit >=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThan(String value) {
            addCriterion("work_unit <", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("work_unit <=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLike(String value) {
            addCriterion("work_unit like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotLike(String value) {
            addCriterion("work_unit not like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIn(List<String> values) {
            addCriterion("work_unit in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotIn(List<String> values) {
            addCriterion("work_unit not in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitBetween(String value1, String value2) {
            addCriterion("work_unit between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotBetween(String value1, String value2) {
            addCriterion("work_unit not between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberIsNull() {
            addCriterion("other_unit_member is null");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberIsNotNull() {
            addCriterion("other_unit_member is not null");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberEqualTo(String value) {
            addCriterion("other_unit_member =", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberNotEqualTo(String value) {
            addCriterion("other_unit_member <>", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberGreaterThan(String value) {
            addCriterion("other_unit_member >", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberGreaterThanOrEqualTo(String value) {
            addCriterion("other_unit_member >=", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberLessThan(String value) {
            addCriterion("other_unit_member <", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberLessThanOrEqualTo(String value) {
            addCriterion("other_unit_member <=", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberLike(String value) {
            addCriterion("other_unit_member like", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberNotLike(String value) {
            addCriterion("other_unit_member not like", value, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberIn(List<String> values) {
            addCriterion("other_unit_member in", values, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberNotIn(List<String> values) {
            addCriterion("other_unit_member not in", values, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberBetween(String value1, String value2) {
            addCriterion("other_unit_member between", value1, value2, "otherUnitMember");
            return (Criteria) this;
        }

        public Criteria andOtherUnitMemberNotBetween(String value1, String value2) {
            addCriterion("other_unit_member not between", value1, value2, "otherUnitMember");
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

        public Criteria andSecurityMeasureIsNull() {
            addCriterion("security_measure is null");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureIsNotNull() {
            addCriterion("security_measure is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureEqualTo(String value) {
            addCriterion("security_measure =", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureNotEqualTo(String value) {
            addCriterion("security_measure <>", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureGreaterThan(String value) {
            addCriterion("security_measure >", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("security_measure >=", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureLessThan(String value) {
            addCriterion("security_measure <", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureLessThanOrEqualTo(String value) {
            addCriterion("security_measure <=", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureLike(String value) {
            addCriterion("security_measure like", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureNotLike(String value) {
            addCriterion("security_measure not like", value, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureIn(List<String> values) {
            addCriterion("security_measure in", values, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureNotIn(List<String> values) {
            addCriterion("security_measure not in", values, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureBetween(String value1, String value2) {
            addCriterion("security_measure between", value1, value2, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSecurityMeasureNotBetween(String value1, String value2) {
            addCriterion("security_measure not between", value1, value2, "securityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureIsNull() {
            addCriterion("sup_security_measure is null");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureIsNotNull() {
            addCriterion("sup_security_measure is not null");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureEqualTo(String value) {
            addCriterion("sup_security_measure =", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureNotEqualTo(String value) {
            addCriterion("sup_security_measure <>", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureGreaterThan(String value) {
            addCriterion("sup_security_measure >", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("sup_security_measure >=", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureLessThan(String value) {
            addCriterion("sup_security_measure <", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureLessThanOrEqualTo(String value) {
            addCriterion("sup_security_measure <=", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureLike(String value) {
            addCriterion("sup_security_measure like", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureNotLike(String value) {
            addCriterion("sup_security_measure not like", value, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureIn(List<String> values) {
            addCriterion("sup_security_measure in", values, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureNotIn(List<String> values) {
            addCriterion("sup_security_measure not in", values, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureBetween(String value1, String value2) {
            addCriterion("sup_security_measure between", value1, value2, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andSupSecurityMeasureNotBetween(String value1, String value2) {
            addCriterion("sup_security_measure not between", value1, value2, "supSecurityMeasure");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsIsNull() {
            addCriterion("measure_ids is null");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsIsNotNull() {
            addCriterion("measure_ids is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsEqualTo(String value) {
            addCriterion("measure_ids =", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsNotEqualTo(String value) {
            addCriterion("measure_ids <>", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsGreaterThan(String value) {
            addCriterion("measure_ids >", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsGreaterThanOrEqualTo(String value) {
            addCriterion("measure_ids >=", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsLessThan(String value) {
            addCriterion("measure_ids <", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsLessThanOrEqualTo(String value) {
            addCriterion("measure_ids <=", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsLike(String value) {
            addCriterion("measure_ids like", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsNotLike(String value) {
            addCriterion("measure_ids not like", value, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsIn(List<String> values) {
            addCriterion("measure_ids in", values, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsNotIn(List<String> values) {
            addCriterion("measure_ids not in", values, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsBetween(String value1, String value2) {
            addCriterion("measure_ids between", value1, value2, "measureIds");
            return (Criteria) this;
        }

        public Criteria andMeasureIdsNotBetween(String value1, String value2) {
            addCriterion("measure_ids not between", value1, value2, "measureIds");
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

        public Criteria andLicenseEndTimeIsNull() {
            addCriterion("license_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeIsNotNull() {
            addCriterion("license_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeEqualTo(Date value) {
            addCriterion("license_end_time =", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeNotEqualTo(Date value) {
            addCriterion("license_end_time <>", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeGreaterThan(Date value) {
            addCriterion("license_end_time >", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("license_end_time >=", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeLessThan(Date value) {
            addCriterion("license_end_time <", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("license_end_time <=", value, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeIn(List<Date> values) {
            addCriterion("license_end_time in", values, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeNotIn(List<Date> values) {
            addCriterion("license_end_time not in", values, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeBetween(Date value1, Date value2) {
            addCriterion("license_end_time between", value1, value2, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicenseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("license_end_time not between", value1, value2, "licenseEndTime");
            return (Criteria) this;
        }

        public Criteria andLicensorIsNull() {
            addCriterion("licensor is null");
            return (Criteria) this;
        }

        public Criteria andLicensorIsNotNull() {
            addCriterion("licensor is not null");
            return (Criteria) this;
        }

        public Criteria andLicensorEqualTo(String value) {
            addCriterion("licensor =", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorNotEqualTo(String value) {
            addCriterion("licensor <>", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorGreaterThan(String value) {
            addCriterion("licensor >", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorGreaterThanOrEqualTo(String value) {
            addCriterion("licensor >=", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorLessThan(String value) {
            addCriterion("licensor <", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorLessThanOrEqualTo(String value) {
            addCriterion("licensor <=", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorLike(String value) {
            addCriterion("licensor like", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorNotLike(String value) {
            addCriterion("licensor not like", value, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorIn(List<String> values) {
            addCriterion("licensor in", values, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorNotIn(List<String> values) {
            addCriterion("licensor not in", values, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorBetween(String value1, String value2) {
            addCriterion("licensor between", value1, value2, "licensor");
            return (Criteria) this;
        }

        public Criteria andLicensorNotBetween(String value1, String value2) {
            addCriterion("licensor not between", value1, value2, "licensor");
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

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
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