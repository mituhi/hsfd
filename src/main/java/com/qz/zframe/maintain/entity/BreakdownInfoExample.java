package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BreakdownInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BreakdownInfoExample() {
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

        public Criteria andBreakdownIdIsNull() {
            addCriterion("breakdown_id is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdIsNotNull() {
            addCriterion("breakdown_id is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdEqualTo(String value) {
            addCriterion("breakdown_id =", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdNotEqualTo(String value) {
            addCriterion("breakdown_id <>", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdGreaterThan(String value) {
            addCriterion("breakdown_id >", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_id >=", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdLessThan(String value) {
            addCriterion("breakdown_id <", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdLessThanOrEqualTo(String value) {
            addCriterion("breakdown_id <=", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdLike(String value) {
            addCriterion("breakdown_id like", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdNotLike(String value) {
            addCriterion("breakdown_id not like", value, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdIn(List<String> values) {
            addCriterion("breakdown_id in", values, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdNotIn(List<String> values) {
            addCriterion("breakdown_id not in", values, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdBetween(String value1, String value2) {
            addCriterion("breakdown_id between", value1, value2, "breakdownId");
            return (Criteria) this;
        }

        public Criteria andBreakdownIdNotBetween(String value1, String value2) {
            addCriterion("breakdown_id not between", value1, value2, "breakdownId");
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

        public Criteria andBreakdownCodeIsNull() {
            addCriterion("breakdown_code is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeIsNotNull() {
            addCriterion("breakdown_code is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeEqualTo(String value) {
            addCriterion("breakdown_code =", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeNotEqualTo(String value) {
            addCriterion("breakdown_code <>", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeGreaterThan(String value) {
            addCriterion("breakdown_code >", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_code >=", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeLessThan(String value) {
            addCriterion("breakdown_code <", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeLessThanOrEqualTo(String value) {
            addCriterion("breakdown_code <=", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeLike(String value) {
            addCriterion("breakdown_code like", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeNotLike(String value) {
            addCriterion("breakdown_code not like", value, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeIn(List<String> values) {
            addCriterion("breakdown_code in", values, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeNotIn(List<String> values) {
            addCriterion("breakdown_code not in", values, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeBetween(String value1, String value2) {
            addCriterion("breakdown_code between", value1, value2, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownCodeNotBetween(String value1, String value2) {
            addCriterion("breakdown_code not between", value1, value2, "breakdownCode");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescIsNull() {
            addCriterion("breakdown_desc is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescIsNotNull() {
            addCriterion("breakdown_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescEqualTo(String value) {
            addCriterion("breakdown_desc =", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescNotEqualTo(String value) {
            addCriterion("breakdown_desc <>", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescGreaterThan(String value) {
            addCriterion("breakdown_desc >", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_desc >=", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescLessThan(String value) {
            addCriterion("breakdown_desc <", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescLessThanOrEqualTo(String value) {
            addCriterion("breakdown_desc <=", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescLike(String value) {
            addCriterion("breakdown_desc like", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescNotLike(String value) {
            addCriterion("breakdown_desc not like", value, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescIn(List<String> values) {
            addCriterion("breakdown_desc in", values, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescNotIn(List<String> values) {
            addCriterion("breakdown_desc not in", values, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescBetween(String value1, String value2) {
            addCriterion("breakdown_desc between", value1, value2, "breakdownDesc");
            return (Criteria) this;
        }

        public Criteria andBreakdownDescNotBetween(String value1, String value2) {
            addCriterion("breakdown_desc not between", value1, value2, "breakdownDesc");
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

        public Criteria andBreakdownSourceIsNull() {
            addCriterion("breakdown_source is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceIsNotNull() {
            addCriterion("breakdown_source is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceEqualTo(String value) {
            addCriterion("breakdown_source =", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceNotEqualTo(String value) {
            addCriterion("breakdown_source <>", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceGreaterThan(String value) {
            addCriterion("breakdown_source >", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_source >=", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceLessThan(String value) {
            addCriterion("breakdown_source <", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceLessThanOrEqualTo(String value) {
            addCriterion("breakdown_source <=", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceLike(String value) {
            addCriterion("breakdown_source like", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceNotLike(String value) {
            addCriterion("breakdown_source not like", value, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceIn(List<String> values) {
            addCriterion("breakdown_source in", values, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceNotIn(List<String> values) {
            addCriterion("breakdown_source not in", values, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceBetween(String value1, String value2) {
            addCriterion("breakdown_source between", value1, value2, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andBreakdownSourceNotBetween(String value1, String value2) {
            addCriterion("breakdown_source not between", value1, value2, "breakdownSource");
            return (Criteria) this;
        }

        public Criteria andDealwithModeIsNull() {
            addCriterion("dealwith_mode is null");
            return (Criteria) this;
        }

        public Criteria andDealwithModeIsNotNull() {
            addCriterion("dealwith_mode is not null");
            return (Criteria) this;
        }

        public Criteria andDealwithModeEqualTo(String value) {
            addCriterion("dealwith_mode =", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeNotEqualTo(String value) {
            addCriterion("dealwith_mode <>", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeGreaterThan(String value) {
            addCriterion("dealwith_mode >", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeGreaterThanOrEqualTo(String value) {
            addCriterion("dealwith_mode >=", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeLessThan(String value) {
            addCriterion("dealwith_mode <", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeLessThanOrEqualTo(String value) {
            addCriterion("dealwith_mode <=", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeLike(String value) {
            addCriterion("dealwith_mode like", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeNotLike(String value) {
            addCriterion("dealwith_mode not like", value, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeIn(List<String> values) {
            addCriterion("dealwith_mode in", values, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeNotIn(List<String> values) {
            addCriterion("dealwith_mode not in", values, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeBetween(String value1, String value2) {
            addCriterion("dealwith_mode between", value1, value2, "dealwithMode");
            return (Criteria) this;
        }

        public Criteria andDealwithModeNotBetween(String value1, String value2) {
            addCriterion("dealwith_mode not between", value1, value2, "dealwithMode");
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamIsNull() {
            addCriterion("dealwith_team is null");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamIsNotNull() {
            addCriterion("dealwith_team is not null");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamEqualTo(String value) {
            addCriterion("dealwith_team =", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamNotEqualTo(String value) {
            addCriterion("dealwith_team <>", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamGreaterThan(String value) {
            addCriterion("dealwith_team >", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamGreaterThanOrEqualTo(String value) {
            addCriterion("dealwith_team >=", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamLessThan(String value) {
            addCriterion("dealwith_team <", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamLessThanOrEqualTo(String value) {
            addCriterion("dealwith_team <=", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamLike(String value) {
            addCriterion("dealwith_team like", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamNotLike(String value) {
            addCriterion("dealwith_team not like", value, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamIn(List<String> values) {
            addCriterion("dealwith_team in", values, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamNotIn(List<String> values) {
            addCriterion("dealwith_team not in", values, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamBetween(String value1, String value2) {
            addCriterion("dealwith_team between", value1, value2, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithTeamNotBetween(String value1, String value2) {
            addCriterion("dealwith_team not between", value1, value2, "dealwithTeam");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonIsNull() {
            addCriterion("dealwith_person is null");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonIsNotNull() {
            addCriterion("dealwith_person is not null");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonEqualTo(String value) {
            addCriterion("dealwith_person =", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonNotEqualTo(String value) {
            addCriterion("dealwith_person <>", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonGreaterThan(String value) {
            addCriterion("dealwith_person >", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonGreaterThanOrEqualTo(String value) {
            addCriterion("dealwith_person >=", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonLessThan(String value) {
            addCriterion("dealwith_person <", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonLessThanOrEqualTo(String value) {
            addCriterion("dealwith_person <=", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonLike(String value) {
            addCriterion("dealwith_person like", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonNotLike(String value) {
            addCriterion("dealwith_person not like", value, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonIn(List<String> values) {
            addCriterion("dealwith_person in", values, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonNotIn(List<String> values) {
            addCriterion("dealwith_person not in", values, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonBetween(String value1, String value2) {
            addCriterion("dealwith_person between", value1, value2, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andDealwithPersonNotBetween(String value1, String value2) {
            addCriterion("dealwith_person not between", value1, value2, "dealwithPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonIsNull() {
            addCriterion("fill_person is null");
            return (Criteria) this;
        }

        public Criteria andFillPersonIsNotNull() {
            addCriterion("fill_person is not null");
            return (Criteria) this;
        }

        public Criteria andFillPersonEqualTo(String value) {
            addCriterion("fill_person =", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonNotEqualTo(String value) {
            addCriterion("fill_person <>", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonGreaterThan(String value) {
            addCriterion("fill_person >", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonGreaterThanOrEqualTo(String value) {
            addCriterion("fill_person >=", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonLessThan(String value) {
            addCriterion("fill_person <", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonLessThanOrEqualTo(String value) {
            addCriterion("fill_person <=", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonLike(String value) {
            addCriterion("fill_person like", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonNotLike(String value) {
            addCriterion("fill_person not like", value, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonIn(List<String> values) {
            addCriterion("fill_person in", values, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonNotIn(List<String> values) {
            addCriterion("fill_person not in", values, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonBetween(String value1, String value2) {
            addCriterion("fill_person between", value1, value2, "fillPerson");
            return (Criteria) this;
        }

        public Criteria andFillPersonNotBetween(String value1, String value2) {
            addCriterion("fill_person not between", value1, value2, "fillPerson");
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

        public Criteria andVaneSpeedIsNull() {
            addCriterion("vane_speed is null");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedIsNotNull() {
            addCriterion("vane_speed is not null");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedEqualTo(String value) {
            addCriterion("vane_speed =", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedNotEqualTo(String value) {
            addCriterion("vane_speed <>", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedGreaterThan(String value) {
            addCriterion("vane_speed >", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("vane_speed >=", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedLessThan(String value) {
            addCriterion("vane_speed <", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedLessThanOrEqualTo(String value) {
            addCriterion("vane_speed <=", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedLike(String value) {
            addCriterion("vane_speed like", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedNotLike(String value) {
            addCriterion("vane_speed not like", value, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedIn(List<String> values) {
            addCriterion("vane_speed in", values, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedNotIn(List<String> values) {
            addCriterion("vane_speed not in", values, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedBetween(String value1, String value2) {
            addCriterion("vane_speed between", value1, value2, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andVaneSpeedNotBetween(String value1, String value2) {
            addCriterion("vane_speed not between", value1, value2, "vaneSpeed");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1IsNull() {
            addCriterion("blade_torque_1 is null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1IsNotNull() {
            addCriterion("blade_torque_1 is not null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1EqualTo(String value) {
            addCriterion("blade_torque_1 =", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1NotEqualTo(String value) {
            addCriterion("blade_torque_1 <>", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1GreaterThan(String value) {
            addCriterion("blade_torque_1 >", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1GreaterThanOrEqualTo(String value) {
            addCriterion("blade_torque_1 >=", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1LessThan(String value) {
            addCriterion("blade_torque_1 <", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1LessThanOrEqualTo(String value) {
            addCriterion("blade_torque_1 <=", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1Like(String value) {
            addCriterion("blade_torque_1 like", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1NotLike(String value) {
            addCriterion("blade_torque_1 not like", value, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1In(List<String> values) {
            addCriterion("blade_torque_1 in", values, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1NotIn(List<String> values) {
            addCriterion("blade_torque_1 not in", values, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1Between(String value1, String value2) {
            addCriterion("blade_torque_1 between", value1, value2, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque1NotBetween(String value1, String value2) {
            addCriterion("blade_torque_1 not between", value1, value2, "bladeTorque1");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2IsNull() {
            addCriterion("blade_torque_2 is null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2IsNotNull() {
            addCriterion("blade_torque_2 is not null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2EqualTo(String value) {
            addCriterion("blade_torque_2 =", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2NotEqualTo(String value) {
            addCriterion("blade_torque_2 <>", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2GreaterThan(String value) {
            addCriterion("blade_torque_2 >", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2GreaterThanOrEqualTo(String value) {
            addCriterion("blade_torque_2 >=", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2LessThan(String value) {
            addCriterion("blade_torque_2 <", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2LessThanOrEqualTo(String value) {
            addCriterion("blade_torque_2 <=", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2Like(String value) {
            addCriterion("blade_torque_2 like", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2NotLike(String value) {
            addCriterion("blade_torque_2 not like", value, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2In(List<String> values) {
            addCriterion("blade_torque_2 in", values, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2NotIn(List<String> values) {
            addCriterion("blade_torque_2 not in", values, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2Between(String value1, String value2) {
            addCriterion("blade_torque_2 between", value1, value2, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque2NotBetween(String value1, String value2) {
            addCriterion("blade_torque_2 not between", value1, value2, "bladeTorque2");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3IsNull() {
            addCriterion("blade_torque_3 is null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3IsNotNull() {
            addCriterion("blade_torque_3 is not null");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3EqualTo(String value) {
            addCriterion("blade_torque_3 =", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3NotEqualTo(String value) {
            addCriterion("blade_torque_3 <>", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3GreaterThan(String value) {
            addCriterion("blade_torque_3 >", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3GreaterThanOrEqualTo(String value) {
            addCriterion("blade_torque_3 >=", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3LessThan(String value) {
            addCriterion("blade_torque_3 <", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3LessThanOrEqualTo(String value) {
            addCriterion("blade_torque_3 <=", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3Like(String value) {
            addCriterion("blade_torque_3 like", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3NotLike(String value) {
            addCriterion("blade_torque_3 not like", value, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3In(List<String> values) {
            addCriterion("blade_torque_3 in", values, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3NotIn(List<String> values) {
            addCriterion("blade_torque_3 not in", values, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3Between(String value1, String value2) {
            addCriterion("blade_torque_3 between", value1, value2, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andBladeTorque3NotBetween(String value1, String value2) {
            addCriterion("blade_torque_3 not between", value1, value2, "bladeTorque3");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("active_time is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("active_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Date value) {
            addCriterion("active_time =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Date value) {
            addCriterion("active_time <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Date value) {
            addCriterion("active_time >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("active_time >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Date value) {
            addCriterion("active_time <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("active_time <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Date> values) {
            addCriterion("active_time in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Date> values) {
            addCriterion("active_time not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Date value1, Date value2) {
            addCriterion("active_time between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("active_time not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIsNull() {
            addCriterion("recover_time is null");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIsNotNull() {
            addCriterion("recover_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeEqualTo(Date value) {
            addCriterion("recover_time =", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotEqualTo(Date value) {
            addCriterion("recover_time <>", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeGreaterThan(Date value) {
            addCriterion("recover_time >", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recover_time >=", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeLessThan(Date value) {
            addCriterion("recover_time <", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeLessThanOrEqualTo(Date value) {
            addCriterion("recover_time <=", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIn(List<Date> values) {
            addCriterion("recover_time in", values, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotIn(List<Date> values) {
            addCriterion("recover_time not in", values, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeBetween(Date value1, Date value2) {
            addCriterion("recover_time between", value1, value2, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotBetween(Date value1, Date value2) {
            addCriterion("recover_time not between", value1, value2, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedIsNull() {
            addCriterion("downtime_windspeed is null");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedIsNotNull() {
            addCriterion("downtime_windspeed is not null");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedEqualTo(String value) {
            addCriterion("downtime_windspeed =", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedNotEqualTo(String value) {
            addCriterion("downtime_windspeed <>", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedGreaterThan(String value) {
            addCriterion("downtime_windspeed >", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedGreaterThanOrEqualTo(String value) {
            addCriterion("downtime_windspeed >=", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedLessThan(String value) {
            addCriterion("downtime_windspeed <", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedLessThanOrEqualTo(String value) {
            addCriterion("downtime_windspeed <=", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedLike(String value) {
            addCriterion("downtime_windspeed like", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedNotLike(String value) {
            addCriterion("downtime_windspeed not like", value, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedIn(List<String> values) {
            addCriterion("downtime_windspeed in", values, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedNotIn(List<String> values) {
            addCriterion("downtime_windspeed not in", values, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedBetween(String value1, String value2) {
            addCriterion("downtime_windspeed between", value1, value2, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andDowntimeWindspeedNotBetween(String value1, String value2) {
            addCriterion("downtime_windspeed not between", value1, value2, "downtimeWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedIsNull() {
            addCriterion("recover_windspeed is null");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedIsNotNull() {
            addCriterion("recover_windspeed is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedEqualTo(String value) {
            addCriterion("recover_windspeed =", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedNotEqualTo(String value) {
            addCriterion("recover_windspeed <>", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedGreaterThan(String value) {
            addCriterion("recover_windspeed >", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedGreaterThanOrEqualTo(String value) {
            addCriterion("recover_windspeed >=", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedLessThan(String value) {
            addCriterion("recover_windspeed <", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedLessThanOrEqualTo(String value) {
            addCriterion("recover_windspeed <=", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedLike(String value) {
            addCriterion("recover_windspeed like", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedNotLike(String value) {
            addCriterion("recover_windspeed not like", value, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedIn(List<String> values) {
            addCriterion("recover_windspeed in", values, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedNotIn(List<String> values) {
            addCriterion("recover_windspeed not in", values, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedBetween(String value1, String value2) {
            addCriterion("recover_windspeed between", value1, value2, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andRecoverWindspeedNotBetween(String value1, String value2) {
            addCriterion("recover_windspeed not between", value1, value2, "recoverWindspeed");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeIsNull() {
            addCriterion("interrupt_time is null");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeIsNotNull() {
            addCriterion("interrupt_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeEqualTo(String value) {
            addCriterion("interrupt_time =", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeNotEqualTo(String value) {
            addCriterion("interrupt_time <>", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeGreaterThan(String value) {
            addCriterion("interrupt_time >", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("interrupt_time >=", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeLessThan(String value) {
            addCriterion("interrupt_time <", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeLessThanOrEqualTo(String value) {
            addCriterion("interrupt_time <=", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeLike(String value) {
            addCriterion("interrupt_time like", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeNotLike(String value) {
            addCriterion("interrupt_time not like", value, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeIn(List<String> values) {
            addCriterion("interrupt_time in", values, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeNotIn(List<String> values) {
            addCriterion("interrupt_time not in", values, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeBetween(String value1, String value2) {
            addCriterion("interrupt_time between", value1, value2, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andInterruptTimeNotBetween(String value1, String value2) {
            addCriterion("interrupt_time not between", value1, value2, "interruptTime");
            return (Criteria) this;
        }

        public Criteria andElectricityLossIsNull() {
            addCriterion("electricity_loss is null");
            return (Criteria) this;
        }

        public Criteria andElectricityLossIsNotNull() {
            addCriterion("electricity_loss is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityLossEqualTo(String value) {
            addCriterion("electricity_loss =", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossNotEqualTo(String value) {
            addCriterion("electricity_loss <>", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossGreaterThan(String value) {
            addCriterion("electricity_loss >", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossGreaterThanOrEqualTo(String value) {
            addCriterion("electricity_loss >=", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossLessThan(String value) {
            addCriterion("electricity_loss <", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossLessThanOrEqualTo(String value) {
            addCriterion("electricity_loss <=", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossLike(String value) {
            addCriterion("electricity_loss like", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossNotLike(String value) {
            addCriterion("electricity_loss not like", value, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossIn(List<String> values) {
            addCriterion("electricity_loss in", values, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossNotIn(List<String> values) {
            addCriterion("electricity_loss not in", values, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossBetween(String value1, String value2) {
            addCriterion("electricity_loss between", value1, value2, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andElectricityLossNotBetween(String value1, String value2) {
            addCriterion("electricity_loss not between", value1, value2, "electricityLoss");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeIsNull() {
            addCriterion("grid_connected_recover_time is null");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeIsNotNull() {
            addCriterion("grid_connected_recover_time is not null");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeEqualTo(Date value) {
            addCriterion("grid_connected_recover_time =", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeNotEqualTo(Date value) {
            addCriterion("grid_connected_recover_time <>", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeGreaterThan(Date value) {
            addCriterion("grid_connected_recover_time >", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("grid_connected_recover_time >=", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeLessThan(Date value) {
            addCriterion("grid_connected_recover_time <", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeLessThanOrEqualTo(Date value) {
            addCriterion("grid_connected_recover_time <=", value, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeIn(List<Date> values) {
            addCriterion("grid_connected_recover_time in", values, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeNotIn(List<Date> values) {
            addCriterion("grid_connected_recover_time not in", values, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeBetween(Date value1, Date value2) {
            addCriterion("grid_connected_recover_time between", value1, value2, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andGridConnectedRecoverTimeNotBetween(Date value1, Date value2) {
            addCriterion("grid_connected_recover_time not between", value1, value2, "gridConnectedRecoverTime");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationIsNull() {
            addCriterion("breakdown_location is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationIsNotNull() {
            addCriterion("breakdown_location is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationEqualTo(String value) {
            addCriterion("breakdown_location =", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationNotEqualTo(String value) {
            addCriterion("breakdown_location <>", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationGreaterThan(String value) {
            addCriterion("breakdown_location >", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_location >=", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationLessThan(String value) {
            addCriterion("breakdown_location <", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationLessThanOrEqualTo(String value) {
            addCriterion("breakdown_location <=", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationLike(String value) {
            addCriterion("breakdown_location like", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationNotLike(String value) {
            addCriterion("breakdown_location not like", value, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationIn(List<String> values) {
            addCriterion("breakdown_location in", values, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationNotIn(List<String> values) {
            addCriterion("breakdown_location not in", values, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationBetween(String value1, String value2) {
            addCriterion("breakdown_location between", value1, value2, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownLocationNotBetween(String value1, String value2) {
            addCriterion("breakdown_location not between", value1, value2, "breakdownLocation");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeIsNull() {
            addCriterion("breakdown_attribute is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeIsNotNull() {
            addCriterion("breakdown_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeEqualTo(String value) {
            addCriterion("breakdown_attribute =", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeNotEqualTo(String value) {
            addCriterion("breakdown_attribute <>", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeGreaterThan(String value) {
            addCriterion("breakdown_attribute >", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_attribute >=", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeLessThan(String value) {
            addCriterion("breakdown_attribute <", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeLessThanOrEqualTo(String value) {
            addCriterion("breakdown_attribute <=", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeLike(String value) {
            addCriterion("breakdown_attribute like", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeNotLike(String value) {
            addCriterion("breakdown_attribute not like", value, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeIn(List<String> values) {
            addCriterion("breakdown_attribute in", values, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeNotIn(List<String> values) {
            addCriterion("breakdown_attribute not in", values, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeBetween(String value1, String value2) {
            addCriterion("breakdown_attribute between", value1, value2, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andBreakdownAttributeNotBetween(String value1, String value2) {
            addCriterion("breakdown_attribute not between", value1, value2, "breakdownAttribute");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadIsNull() {
            addCriterion("maximum_load is null");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadIsNotNull() {
            addCriterion("maximum_load is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadEqualTo(String value) {
            addCriterion("maximum_load =", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadNotEqualTo(String value) {
            addCriterion("maximum_load <>", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadGreaterThan(String value) {
            addCriterion("maximum_load >", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_load >=", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadLessThan(String value) {
            addCriterion("maximum_load <", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadLessThanOrEqualTo(String value) {
            addCriterion("maximum_load <=", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadLike(String value) {
            addCriterion("maximum_load like", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadNotLike(String value) {
            addCriterion("maximum_load not like", value, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadIn(List<String> values) {
            addCriterion("maximum_load in", values, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadNotIn(List<String> values) {
            addCriterion("maximum_load not in", values, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadBetween(String value1, String value2) {
            addCriterion("maximum_load between", value1, value2, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andMaximumLoadNotBetween(String value1, String value2) {
            addCriterion("maximum_load not between", value1, value2, "maximumLoad");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110IsNull() {
            addCriterion("system_busbar_110 is null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110IsNotNull() {
            addCriterion("system_busbar_110 is not null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110EqualTo(String value) {
            addCriterion("system_busbar_110 =", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110NotEqualTo(String value) {
            addCriterion("system_busbar_110 <>", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110GreaterThan(String value) {
            addCriterion("system_busbar_110 >", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110GreaterThanOrEqualTo(String value) {
            addCriterion("system_busbar_110 >=", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110LessThan(String value) {
            addCriterion("system_busbar_110 <", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110LessThanOrEqualTo(String value) {
            addCriterion("system_busbar_110 <=", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110Like(String value) {
            addCriterion("system_busbar_110 like", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110NotLike(String value) {
            addCriterion("system_busbar_110 not like", value, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110In(List<String> values) {
            addCriterion("system_busbar_110 in", values, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110NotIn(List<String> values) {
            addCriterion("system_busbar_110 not in", values, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110Between(String value1, String value2) {
            addCriterion("system_busbar_110 between", value1, value2, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar110NotBetween(String value1, String value2) {
            addCriterion("system_busbar_110 not between", value1, value2, "systemBusbar110");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35IsNull() {
            addCriterion("system_busbar_35 is null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35IsNotNull() {
            addCriterion("system_busbar_35 is not null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35EqualTo(String value) {
            addCriterion("system_busbar_35 =", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35NotEqualTo(String value) {
            addCriterion("system_busbar_35 <>", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35GreaterThan(String value) {
            addCriterion("system_busbar_35 >", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35GreaterThanOrEqualTo(String value) {
            addCriterion("system_busbar_35 >=", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35LessThan(String value) {
            addCriterion("system_busbar_35 <", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35LessThanOrEqualTo(String value) {
            addCriterion("system_busbar_35 <=", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35Like(String value) {
            addCriterion("system_busbar_35 like", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35NotLike(String value) {
            addCriterion("system_busbar_35 not like", value, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35In(List<String> values) {
            addCriterion("system_busbar_35 in", values, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35NotIn(List<String> values) {
            addCriterion("system_busbar_35 not in", values, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35Between(String value1, String value2) {
            addCriterion("system_busbar_35 between", value1, value2, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar35NotBetween(String value1, String value2) {
            addCriterion("system_busbar_35 not between", value1, value2, "systemBusbar35");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400IsNull() {
            addCriterion("system_busbar_400 is null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400IsNotNull() {
            addCriterion("system_busbar_400 is not null");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400EqualTo(String value) {
            addCriterion("system_busbar_400 =", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400NotEqualTo(String value) {
            addCriterion("system_busbar_400 <>", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400GreaterThan(String value) {
            addCriterion("system_busbar_400 >", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400GreaterThanOrEqualTo(String value) {
            addCriterion("system_busbar_400 >=", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400LessThan(String value) {
            addCriterion("system_busbar_400 <", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400LessThanOrEqualTo(String value) {
            addCriterion("system_busbar_400 <=", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400Like(String value) {
            addCriterion("system_busbar_400 like", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400NotLike(String value) {
            addCriterion("system_busbar_400 not like", value, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400In(List<String> values) {
            addCriterion("system_busbar_400 in", values, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400NotIn(List<String> values) {
            addCriterion("system_busbar_400 not in", values, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400Between(String value1, String value2) {
            addCriterion("system_busbar_400 between", value1, value2, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andSystemBusbar400NotBetween(String value1, String value2) {
            addCriterion("system_busbar_400 not between", value1, value2, "systemBusbar400");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberIsNull() {
            addCriterion("workorder_number is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberIsNotNull() {
            addCriterion("workorder_number is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberEqualTo(String value) {
            addCriterion("workorder_number =", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberNotEqualTo(String value) {
            addCriterion("workorder_number <>", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberGreaterThan(String value) {
            addCriterion("workorder_number >", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_number >=", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberLessThan(String value) {
            addCriterion("workorder_number <", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberLessThanOrEqualTo(String value) {
            addCriterion("workorder_number <=", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberLike(String value) {
            addCriterion("workorder_number like", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberNotLike(String value) {
            addCriterion("workorder_number not like", value, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberIn(List<String> values) {
            addCriterion("workorder_number in", values, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberNotIn(List<String> values) {
            addCriterion("workorder_number not in", values, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberBetween(String value1, String value2) {
            addCriterion("workorder_number between", value1, value2, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumberNotBetween(String value1, String value2) {
            addCriterion("workorder_number not between", value1, value2, "workorderNumber");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescIsNull() {
            addCriterion("workorder_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescIsNotNull() {
            addCriterion("workorder_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescEqualTo(String value) {
            addCriterion("workorder_desc =", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescNotEqualTo(String value) {
            addCriterion("workorder_desc <>", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescGreaterThan(String value) {
            addCriterion("workorder_desc >", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_desc >=", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescLessThan(String value) {
            addCriterion("workorder_desc <", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescLessThanOrEqualTo(String value) {
            addCriterion("workorder_desc <=", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescLike(String value) {
            addCriterion("workorder_desc like", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescNotLike(String value) {
            addCriterion("workorder_desc not like", value, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescIn(List<String> values) {
            addCriterion("workorder_desc in", values, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescNotIn(List<String> values) {
            addCriterion("workorder_desc not in", values, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescBetween(String value1, String value2) {
            addCriterion("workorder_desc between", value1, value2, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderDescNotBetween(String value1, String value2) {
            addCriterion("workorder_desc not between", value1, value2, "workorderDesc");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIsNull() {
            addCriterion("workorder_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIsNotNull() {
            addCriterion("workorder_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeEqualTo(String value) {
            addCriterion("workorder_type =", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNotEqualTo(String value) {
            addCriterion("workorder_type <>", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeGreaterThan(String value) {
            addCriterion("workorder_type >", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_type >=", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeLessThan(String value) {
            addCriterion("workorder_type <", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeLessThanOrEqualTo(String value) {
            addCriterion("workorder_type <=", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeLike(String value) {
            addCriterion("workorder_type like", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNotLike(String value) {
            addCriterion("workorder_type not like", value, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIn(List<String> values) {
            addCriterion("workorder_type in", values, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNotIn(List<String> values) {
            addCriterion("workorder_type not in", values, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeBetween(String value1, String value2) {
            addCriterion("workorder_type between", value1, value2, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeNotBetween(String value1, String value2) {
            addCriterion("workorder_type not between", value1, value2, "workorderType");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusIsNull() {
            addCriterion("workorder_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusIsNotNull() {
            addCriterion("workorder_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusEqualTo(String value) {
            addCriterion("workorder_status =", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusNotEqualTo(String value) {
            addCriterion("workorder_status <>", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusGreaterThan(String value) {
            addCriterion("workorder_status >", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_status >=", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusLessThan(String value) {
            addCriterion("workorder_status <", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusLessThanOrEqualTo(String value) {
            addCriterion("workorder_status <=", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusLike(String value) {
            addCriterion("workorder_status like", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusNotLike(String value) {
            addCriterion("workorder_status not like", value, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusIn(List<String> values) {
            addCriterion("workorder_status in", values, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusNotIn(List<String> values) {
            addCriterion("workorder_status not in", values, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusBetween(String value1, String value2) {
            addCriterion("workorder_status between", value1, value2, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkorderStatusNotBetween(String value1, String value2) {
            addCriterion("workorder_status not between", value1, value2, "workorderStatus");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPhenomenonIsNull() {
            addCriterion("phenomenon is null");
            return (Criteria) this;
        }

        public Criteria andPhenomenonIsNotNull() {
            addCriterion("phenomenon is not null");
            return (Criteria) this;
        }

        public Criteria andPhenomenonEqualTo(String value) {
            addCriterion("phenomenon =", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonNotEqualTo(String value) {
            addCriterion("phenomenon <>", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonGreaterThan(String value) {
            addCriterion("phenomenon >", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonGreaterThanOrEqualTo(String value) {
            addCriterion("phenomenon >=", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonLessThan(String value) {
            addCriterion("phenomenon <", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonLessThanOrEqualTo(String value) {
            addCriterion("phenomenon <=", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonLike(String value) {
            addCriterion("phenomenon like", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonNotLike(String value) {
            addCriterion("phenomenon not like", value, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonIn(List<String> values) {
            addCriterion("phenomenon in", values, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonNotIn(List<String> values) {
            addCriterion("phenomenon not in", values, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonBetween(String value1, String value2) {
            addCriterion("phenomenon between", value1, value2, "phenomenon");
            return (Criteria) this;
        }

        public Criteria andPhenomenonNotBetween(String value1, String value2) {
            addCriterion("phenomenon not between", value1, value2, "phenomenon");
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