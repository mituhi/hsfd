package com.qz.zframe.tickets.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StandardWorkTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StandardWorkTicketExample() {
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

        public Criteria andStandardTicketNameIsNull() {
            addCriterion("standard_ticket_name is null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameIsNotNull() {
            addCriterion("standard_ticket_name is not null");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameEqualTo(String value) {
            addCriterion("standard_ticket_name =", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameNotEqualTo(String value) {
            addCriterion("standard_ticket_name <>", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameGreaterThan(String value) {
            addCriterion("standard_ticket_name >", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameGreaterThanOrEqualTo(String value) {
            addCriterion("standard_ticket_name >=", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameLessThan(String value) {
            addCriterion("standard_ticket_name <", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameLessThanOrEqualTo(String value) {
            addCriterion("standard_ticket_name <=", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameLike(String value) {
            addCriterion("standard_ticket_name like", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameNotLike(String value) {
            addCriterion("standard_ticket_name not like", value, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameIn(List<String> values) {
            addCriterion("standard_ticket_name in", values, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameNotIn(List<String> values) {
            addCriterion("standard_ticket_name not in", values, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameBetween(String value1, String value2) {
            addCriterion("standard_ticket_name between", value1, value2, "standardTicketName");
            return (Criteria) this;
        }

        public Criteria andStandardTicketNameNotBetween(String value1, String value2) {
            addCriterion("standard_ticket_name not between", value1, value2, "standardTicketName");
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

        public Criteria andDoubleNameIsNull() {
            addCriterion("double_name is null");
            return (Criteria) this;
        }

        public Criteria andDoubleNameIsNotNull() {
            addCriterion("double_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleNameEqualTo(String value) {
            addCriterion("double_name =", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameNotEqualTo(String value) {
            addCriterion("double_name <>", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameGreaterThan(String value) {
            addCriterion("double_name >", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameGreaterThanOrEqualTo(String value) {
            addCriterion("double_name >=", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameLessThan(String value) {
            addCriterion("double_name <", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameLessThanOrEqualTo(String value) {
            addCriterion("double_name <=", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameLike(String value) {
            addCriterion("double_name like", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameNotLike(String value) {
            addCriterion("double_name not like", value, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameIn(List<String> values) {
            addCriterion("double_name in", values, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameNotIn(List<String> values) {
            addCriterion("double_name not in", values, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameBetween(String value1, String value2) {
            addCriterion("double_name between", value1, value2, "doubleName");
            return (Criteria) this;
        }

        public Criteria andDoubleNameNotBetween(String value1, String value2) {
            addCriterion("double_name not between", value1, value2, "doubleName");
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