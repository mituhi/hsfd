package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DefectWorkorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DefectWorkorderExample() {
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

        public Criteria andWorkorderCodeIsNull() {
            addCriterion("workorder_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeIsNotNull() {
            addCriterion("workorder_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeEqualTo(String value) {
            addCriterion("workorder_code =", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeNotEqualTo(String value) {
            addCriterion("workorder_code <>", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeGreaterThan(String value) {
            addCriterion("workorder_code >", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_code >=", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeLessThan(String value) {
            addCriterion("workorder_code <", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeLessThanOrEqualTo(String value) {
            addCriterion("workorder_code <=", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeLike(String value) {
            addCriterion("workorder_code like", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeNotLike(String value) {
            addCriterion("workorder_code not like", value, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeIn(List<String> values) {
            addCriterion("workorder_code in", values, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeNotIn(List<String> values) {
            addCriterion("workorder_code not in", values, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeBetween(String value1, String value2) {
            addCriterion("workorder_code between", value1, value2, "workorderCode");
            return (Criteria) this;
        }

        public Criteria andWorkorderCodeNotBetween(String value1, String value2) {
            addCriterion("workorder_code not between", value1, value2, "workorderCode");
            return (Criteria) this;
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

        public Criteria andDealModeIsNull() {
            addCriterion("deal_mode is null");
            return (Criteria) this;
        }

        public Criteria andDealModeIsNotNull() {
            addCriterion("deal_mode is not null");
            return (Criteria) this;
        }

        public Criteria andDealModeEqualTo(String value) {
            addCriterion("deal_mode =", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeNotEqualTo(String value) {
            addCriterion("deal_mode <>", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeGreaterThan(String value) {
            addCriterion("deal_mode >", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeGreaterThanOrEqualTo(String value) {
            addCriterion("deal_mode >=", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeLessThan(String value) {
            addCriterion("deal_mode <", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeLessThanOrEqualTo(String value) {
            addCriterion("deal_mode <=", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeLike(String value) {
            addCriterion("deal_mode like", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeNotLike(String value) {
            addCriterion("deal_mode not like", value, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeIn(List<String> values) {
            addCriterion("deal_mode in", values, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeNotIn(List<String> values) {
            addCriterion("deal_mode not in", values, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeBetween(String value1, String value2) {
            addCriterion("deal_mode between", value1, value2, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDealModeNotBetween(String value1, String value2) {
            addCriterion("deal_mode not between", value1, value2, "dealMode");
            return (Criteria) this;
        }

        public Criteria andDutyTeamIsNull() {
            addCriterion("duty_team is null");
            return (Criteria) this;
        }

        public Criteria andDutyTeamIsNotNull() {
            addCriterion("duty_team is not null");
            return (Criteria) this;
        }

        public Criteria andDutyTeamEqualTo(String value) {
            addCriterion("duty_team =", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamNotEqualTo(String value) {
            addCriterion("duty_team <>", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamGreaterThan(String value) {
            addCriterion("duty_team >", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamGreaterThanOrEqualTo(String value) {
            addCriterion("duty_team >=", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamLessThan(String value) {
            addCriterion("duty_team <", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamLessThanOrEqualTo(String value) {
            addCriterion("duty_team <=", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamLike(String value) {
            addCriterion("duty_team like", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamNotLike(String value) {
            addCriterion("duty_team not like", value, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamIn(List<String> values) {
            addCriterion("duty_team in", values, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamNotIn(List<String> values) {
            addCriterion("duty_team not in", values, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamBetween(String value1, String value2) {
            addCriterion("duty_team between", value1, value2, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyTeamNotBetween(String value1, String value2) {
            addCriterion("duty_team not between", value1, value2, "dutyTeam");
            return (Criteria) this;
        }

        public Criteria andDutyHeadIsNull() {
            addCriterion("duty_head is null");
            return (Criteria) this;
        }

        public Criteria andDutyHeadIsNotNull() {
            addCriterion("duty_head is not null");
            return (Criteria) this;
        }

        public Criteria andDutyHeadEqualTo(String value) {
            addCriterion("duty_head =", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadNotEqualTo(String value) {
            addCriterion("duty_head <>", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadGreaterThan(String value) {
            addCriterion("duty_head >", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadGreaterThanOrEqualTo(String value) {
            addCriterion("duty_head >=", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadLessThan(String value) {
            addCriterion("duty_head <", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadLessThanOrEqualTo(String value) {
            addCriterion("duty_head <=", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadLike(String value) {
            addCriterion("duty_head like", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadNotLike(String value) {
            addCriterion("duty_head not like", value, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadIn(List<String> values) {
            addCriterion("duty_head in", values, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadNotIn(List<String> values) {
            addCriterion("duty_head not in", values, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadBetween(String value1, String value2) {
            addCriterion("duty_head between", value1, value2, "dutyHead");
            return (Criteria) this;
        }

        public Criteria andDutyHeadNotBetween(String value1, String value2) {
            addCriterion("duty_head not between", value1, value2, "dutyHead");
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

        public Criteria andFillTimeIsNull() {
            addCriterion("fill_time is null");
            return (Criteria) this;
        }

        public Criteria andFillTimeIsNotNull() {
            addCriterion("fill_time is not null");
            return (Criteria) this;
        }

        public Criteria andFillTimeEqualTo(Date value) {
            addCriterion("fill_time =", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotEqualTo(Date value) {
            addCriterion("fill_time <>", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThan(Date value) {
            addCriterion("fill_time >", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fill_time >=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThan(Date value) {
            addCriterion("fill_time <", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThanOrEqualTo(Date value) {
            addCriterion("fill_time <=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeIn(List<Date> values) {
            addCriterion("fill_time in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotIn(List<Date> values) {
            addCriterion("fill_time not in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeBetween(Date value1, Date value2) {
            addCriterion("fill_time between", value1, value2, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotBetween(Date value1, Date value2) {
            addCriterion("fill_time not between", value1, value2, "fillTime");
            return (Criteria) this;
        }

        public Criteria andUnitMemberIsNull() {
            addCriterion("unit_member is null");
            return (Criteria) this;
        }

        public Criteria andUnitMemberIsNotNull() {
            addCriterion("unit_member is not null");
            return (Criteria) this;
        }

        public Criteria andUnitMemberEqualTo(String value) {
            addCriterion("unit_member =", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberNotEqualTo(String value) {
            addCriterion("unit_member <>", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberGreaterThan(String value) {
            addCriterion("unit_member >", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberGreaterThanOrEqualTo(String value) {
            addCriterion("unit_member >=", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberLessThan(String value) {
            addCriterion("unit_member <", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberLessThanOrEqualTo(String value) {
            addCriterion("unit_member <=", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberLike(String value) {
            addCriterion("unit_member like", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberNotLike(String value) {
            addCriterion("unit_member not like", value, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberIn(List<String> values) {
            addCriterion("unit_member in", values, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberNotIn(List<String> values) {
            addCriterion("unit_member not in", values, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberBetween(String value1, String value2) {
            addCriterion("unit_member between", value1, value2, "unitMember");
            return (Criteria) this;
        }

        public Criteria andUnitMemberNotBetween(String value1, String value2) {
            addCriterion("unit_member not between", value1, value2, "unitMember");
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

        public Criteria andDefectRemarkIsNull() {
            addCriterion("defect_remark is null");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkIsNotNull() {
            addCriterion("defect_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkEqualTo(String value) {
            addCriterion("defect_remark =", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkNotEqualTo(String value) {
            addCriterion("defect_remark <>", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkGreaterThan(String value) {
            addCriterion("defect_remark >", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("defect_remark >=", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkLessThan(String value) {
            addCriterion("defect_remark <", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkLessThanOrEqualTo(String value) {
            addCriterion("defect_remark <=", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkLike(String value) {
            addCriterion("defect_remark like", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkNotLike(String value) {
            addCriterion("defect_remark not like", value, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkIn(List<String> values) {
            addCriterion("defect_remark in", values, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkNotIn(List<String> values) {
            addCriterion("defect_remark not in", values, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkBetween(String value1, String value2) {
            addCriterion("defect_remark between", value1, value2, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectRemarkNotBetween(String value1, String value2) {
            addCriterion("defect_remark not between", value1, value2, "defectRemark");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisIsNull() {
            addCriterion("defect_analysis is null");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisIsNotNull() {
            addCriterion("defect_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisEqualTo(String value) {
            addCriterion("defect_analysis =", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisNotEqualTo(String value) {
            addCriterion("defect_analysis <>", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisGreaterThan(String value) {
            addCriterion("defect_analysis >", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("defect_analysis >=", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisLessThan(String value) {
            addCriterion("defect_analysis <", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisLessThanOrEqualTo(String value) {
            addCriterion("defect_analysis <=", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisLike(String value) {
            addCriterion("defect_analysis like", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisNotLike(String value) {
            addCriterion("defect_analysis not like", value, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisIn(List<String> values) {
            addCriterion("defect_analysis in", values, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisNotIn(List<String> values) {
            addCriterion("defect_analysis not in", values, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisBetween(String value1, String value2) {
            addCriterion("defect_analysis between", value1, value2, "defectAnalysis");
            return (Criteria) this;
        }

        public Criteria andDefectAnalysisNotBetween(String value1, String value2) {
            addCriterion("defect_analysis not between", value1, value2, "defectAnalysis");
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

        public Criteria andPlanWorkHourIsNull() {
            addCriterion("plan_work_hour is null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourIsNotNull() {
            addCriterion("plan_work_hour is not null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourEqualTo(String value) {
            addCriterion("plan_work_hour =", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourNotEqualTo(String value) {
            addCriterion("plan_work_hour <>", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourGreaterThan(String value) {
            addCriterion("plan_work_hour >", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourGreaterThanOrEqualTo(String value) {
            addCriterion("plan_work_hour >=", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourLessThan(String value) {
            addCriterion("plan_work_hour <", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourLessThanOrEqualTo(String value) {
            addCriterion("plan_work_hour <=", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourLike(String value) {
            addCriterion("plan_work_hour like", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourNotLike(String value) {
            addCriterion("plan_work_hour not like", value, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourIn(List<String> values) {
            addCriterion("plan_work_hour in", values, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourNotIn(List<String> values) {
            addCriterion("plan_work_hour not in", values, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourBetween(String value1, String value2) {
            addCriterion("plan_work_hour between", value1, value2, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkHourNotBetween(String value1, String value2) {
            addCriterion("plan_work_hour not between", value1, value2, "planWorkHour");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeIsNull() {
            addCriterion("plan_material_fee is null");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeIsNotNull() {
            addCriterion("plan_material_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeEqualTo(String value) {
            addCriterion("plan_material_fee =", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeNotEqualTo(String value) {
            addCriterion("plan_material_fee <>", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeGreaterThan(String value) {
            addCriterion("plan_material_fee >", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_material_fee >=", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeLessThan(String value) {
            addCriterion("plan_material_fee <", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeLessThanOrEqualTo(String value) {
            addCriterion("plan_material_fee <=", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeLike(String value) {
            addCriterion("plan_material_fee like", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeNotLike(String value) {
            addCriterion("plan_material_fee not like", value, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeIn(List<String> values) {
            addCriterion("plan_material_fee in", values, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeNotIn(List<String> values) {
            addCriterion("plan_material_fee not in", values, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeBetween(String value1, String value2) {
            addCriterion("plan_material_fee between", value1, value2, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanMaterialFeeNotBetween(String value1, String value2) {
            addCriterion("plan_material_fee not between", value1, value2, "planMaterialFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeIsNull() {
            addCriterion("plan_service_fee is null");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeIsNotNull() {
            addCriterion("plan_service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeEqualTo(String value) {
            addCriterion("plan_service_fee =", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeNotEqualTo(String value) {
            addCriterion("plan_service_fee <>", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeGreaterThan(String value) {
            addCriterion("plan_service_fee >", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_service_fee >=", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeLessThan(String value) {
            addCriterion("plan_service_fee <", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeLessThanOrEqualTo(String value) {
            addCriterion("plan_service_fee <=", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeLike(String value) {
            addCriterion("plan_service_fee like", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeNotLike(String value) {
            addCriterion("plan_service_fee not like", value, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeIn(List<String> values) {
            addCriterion("plan_service_fee in", values, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeNotIn(List<String> values) {
            addCriterion("plan_service_fee not in", values, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeBetween(String value1, String value2) {
            addCriterion("plan_service_fee between", value1, value2, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andPlanServiceFeeNotBetween(String value1, String value2) {
            addCriterion("plan_service_fee not between", value1, value2, "planServiceFee");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeIsNull() {
            addCriterion("actual_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeIsNotNull() {
            addCriterion("actual_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeEqualTo(Date value) {
            addCriterion("actual_complete_time =", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeNotEqualTo(Date value) {
            addCriterion("actual_complete_time <>", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeGreaterThan(Date value) {
            addCriterion("actual_complete_time >", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_complete_time >=", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeLessThan(Date value) {
            addCriterion("actual_complete_time <", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_complete_time <=", value, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeIn(List<Date> values) {
            addCriterion("actual_complete_time in", values, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeNotIn(List<Date> values) {
            addCriterion("actual_complete_time not in", values, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("actual_complete_time between", value1, value2, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andActualCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_complete_time not between", value1, value2, "actualCompleteTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1IsNull() {
            addCriterion("equipment_status_requirement_1 is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1IsNotNull() {
            addCriterion("equipment_status_requirement_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1EqualTo(String value) {
            addCriterion("equipment_status_requirement_1 =", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1NotEqualTo(String value) {
            addCriterion("equipment_status_requirement_1 <>", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1GreaterThan(String value) {
            addCriterion("equipment_status_requirement_1 >", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1GreaterThanOrEqualTo(String value) {
            addCriterion("equipment_status_requirement_1 >=", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1LessThan(String value) {
            addCriterion("equipment_status_requirement_1 <", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1LessThanOrEqualTo(String value) {
            addCriterion("equipment_status_requirement_1 <=", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1Like(String value) {
            addCriterion("equipment_status_requirement_1 like", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1NotLike(String value) {
            addCriterion("equipment_status_requirement_1 not like", value, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1In(List<String> values) {
            addCriterion("equipment_status_requirement_1 in", values, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1NotIn(List<String> values) {
            addCriterion("equipment_status_requirement_1 not in", values, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1Between(String value1, String value2) {
            addCriterion("equipment_status_requirement_1 between", value1, value2, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement1NotBetween(String value1, String value2) {
            addCriterion("equipment_status_requirement_1 not between", value1, value2, "equipmentStatusRequirement1");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2IsNull() {
            addCriterion("equipment_status_requirement_2 is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2IsNotNull() {
            addCriterion("equipment_status_requirement_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2EqualTo(String value) {
            addCriterion("equipment_status_requirement_2 =", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2NotEqualTo(String value) {
            addCriterion("equipment_status_requirement_2 <>", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2GreaterThan(String value) {
            addCriterion("equipment_status_requirement_2 >", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2GreaterThanOrEqualTo(String value) {
            addCriterion("equipment_status_requirement_2 >=", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2LessThan(String value) {
            addCriterion("equipment_status_requirement_2 <", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2LessThanOrEqualTo(String value) {
            addCriterion("equipment_status_requirement_2 <=", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2Like(String value) {
            addCriterion("equipment_status_requirement_2 like", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2NotLike(String value) {
            addCriterion("equipment_status_requirement_2 not like", value, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2In(List<String> values) {
            addCriterion("equipment_status_requirement_2 in", values, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2NotIn(List<String> values) {
            addCriterion("equipment_status_requirement_2 not in", values, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2Between(String value1, String value2) {
            addCriterion("equipment_status_requirement_2 between", value1, value2, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusRequirement2NotBetween(String value1, String value2) {
            addCriterion("equipment_status_requirement_2 not between", value1, value2, "equipmentStatusRequirement2");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementIsNull() {
            addCriterion("other_requirement is null");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementIsNotNull() {
            addCriterion("other_requirement is not null");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementEqualTo(String value) {
            addCriterion("other_requirement =", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementNotEqualTo(String value) {
            addCriterion("other_requirement <>", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementGreaterThan(String value) {
            addCriterion("other_requirement >", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("other_requirement >=", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementLessThan(String value) {
            addCriterion("other_requirement <", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementLessThanOrEqualTo(String value) {
            addCriterion("other_requirement <=", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementLike(String value) {
            addCriterion("other_requirement like", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementNotLike(String value) {
            addCriterion("other_requirement not like", value, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementIn(List<String> values) {
            addCriterion("other_requirement in", values, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementNotIn(List<String> values) {
            addCriterion("other_requirement not in", values, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementBetween(String value1, String value2) {
            addCriterion("other_requirement between", value1, value2, "otherRequirement");
            return (Criteria) this;
        }

        public Criteria andOtherRequirementNotBetween(String value1, String value2) {
            addCriterion("other_requirement not between", value1, value2, "otherRequirement");
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