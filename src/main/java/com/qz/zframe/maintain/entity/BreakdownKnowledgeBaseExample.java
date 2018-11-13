package com.qz.zframe.maintain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BreakdownKnowledgeBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BreakdownKnowledgeBaseExample() {
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

        public Criteria andKnowledgeIdIsNull() {
            addCriterion("knowledge_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNotNull() {
            addCriterion("knowledge_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdEqualTo(String value) {
            addCriterion("knowledge_id =", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotEqualTo(String value) {
            addCriterion("knowledge_id <>", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThan(String value) {
            addCriterion("knowledge_id >", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_id >=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThan(String value) {
            addCriterion("knowledge_id <", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThanOrEqualTo(String value) {
            addCriterion("knowledge_id <=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLike(String value) {
            addCriterion("knowledge_id like", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotLike(String value) {
            addCriterion("knowledge_id not like", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIn(List<String> values) {
            addCriterion("knowledge_id in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotIn(List<String> values) {
            addCriterion("knowledge_id not in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdBetween(String value1, String value2) {
            addCriterion("knowledge_id between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotBetween(String value1, String value2) {
            addCriterion("knowledge_id not between", value1, value2, "knowledgeId");
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

        public Criteria andKnowledgeDescIsNull() {
            addCriterion("knowledge_desc is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescIsNotNull() {
            addCriterion("knowledge_desc is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescEqualTo(String value) {
            addCriterion("knowledge_desc =", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescNotEqualTo(String value) {
            addCriterion("knowledge_desc <>", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescGreaterThan(String value) {
            addCriterion("knowledge_desc >", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_desc >=", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescLessThan(String value) {
            addCriterion("knowledge_desc <", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescLessThanOrEqualTo(String value) {
            addCriterion("knowledge_desc <=", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescLike(String value) {
            addCriterion("knowledge_desc like", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescNotLike(String value) {
            addCriterion("knowledge_desc not like", value, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescIn(List<String> values) {
            addCriterion("knowledge_desc in", values, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescNotIn(List<String> values) {
            addCriterion("knowledge_desc not in", values, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescBetween(String value1, String value2) {
            addCriterion("knowledge_desc between", value1, value2, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeDescNotBetween(String value1, String value2) {
            addCriterion("knowledge_desc not between", value1, value2, "knowledgeDesc");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameIsNull() {
            addCriterion("knowledge_name is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameIsNotNull() {
            addCriterion("knowledge_name is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameEqualTo(String value) {
            addCriterion("knowledge_name =", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameNotEqualTo(String value) {
            addCriterion("knowledge_name <>", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameGreaterThan(String value) {
            addCriterion("knowledge_name >", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_name >=", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameLessThan(String value) {
            addCriterion("knowledge_name <", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameLessThanOrEqualTo(String value) {
            addCriterion("knowledge_name <=", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameLike(String value) {
            addCriterion("knowledge_name like", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameNotLike(String value) {
            addCriterion("knowledge_name not like", value, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameIn(List<String> values) {
            addCriterion("knowledge_name in", values, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameNotIn(List<String> values) {
            addCriterion("knowledge_name not in", values, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameBetween(String value1, String value2) {
            addCriterion("knowledge_name between", value1, value2, "knowledgeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNameNotBetween(String value1, String value2) {
            addCriterion("knowledge_name not between", value1, value2, "knowledgeName");
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

        public Criteria andDefectPhenomenonIsNull() {
            addCriterion("defect_phenomenon is null");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonIsNotNull() {
            addCriterion("defect_phenomenon is not null");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonEqualTo(String value) {
            addCriterion("defect_phenomenon =", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonNotEqualTo(String value) {
            addCriterion("defect_phenomenon <>", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonGreaterThan(String value) {
            addCriterion("defect_phenomenon >", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonGreaterThanOrEqualTo(String value) {
            addCriterion("defect_phenomenon >=", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonLessThan(String value) {
            addCriterion("defect_phenomenon <", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonLessThanOrEqualTo(String value) {
            addCriterion("defect_phenomenon <=", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonLike(String value) {
            addCriterion("defect_phenomenon like", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonNotLike(String value) {
            addCriterion("defect_phenomenon not like", value, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonIn(List<String> values) {
            addCriterion("defect_phenomenon in", values, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonNotIn(List<String> values) {
            addCriterion("defect_phenomenon not in", values, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonBetween(String value1, String value2) {
            addCriterion("defect_phenomenon between", value1, value2, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andDefectPhenomenonNotBetween(String value1, String value2) {
            addCriterion("defect_phenomenon not between", value1, value2, "defectPhenomenon");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisIsNull() {
            addCriterion("cause_analysis is null");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisIsNotNull() {
            addCriterion("cause_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisEqualTo(String value) {
            addCriterion("cause_analysis =", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisNotEqualTo(String value) {
            addCriterion("cause_analysis <>", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisGreaterThan(String value) {
            addCriterion("cause_analysis >", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("cause_analysis >=", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisLessThan(String value) {
            addCriterion("cause_analysis <", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisLessThanOrEqualTo(String value) {
            addCriterion("cause_analysis <=", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisLike(String value) {
            addCriterion("cause_analysis like", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisNotLike(String value) {
            addCriterion("cause_analysis not like", value, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisIn(List<String> values) {
            addCriterion("cause_analysis in", values, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisNotIn(List<String> values) {
            addCriterion("cause_analysis not in", values, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisBetween(String value1, String value2) {
            addCriterion("cause_analysis between", value1, value2, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCauseAnalysisNotBetween(String value1, String value2) {
            addCriterion("cause_analysis not between", value1, value2, "causeAnalysis");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescIsNull() {
            addCriterion("repair_process_desc is null");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescIsNotNull() {
            addCriterion("repair_process_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescEqualTo(String value) {
            addCriterion("repair_process_desc =", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescNotEqualTo(String value) {
            addCriterion("repair_process_desc <>", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescGreaterThan(String value) {
            addCriterion("repair_process_desc >", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescGreaterThanOrEqualTo(String value) {
            addCriterion("repair_process_desc >=", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescLessThan(String value) {
            addCriterion("repair_process_desc <", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescLessThanOrEqualTo(String value) {
            addCriterion("repair_process_desc <=", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescLike(String value) {
            addCriterion("repair_process_desc like", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescNotLike(String value) {
            addCriterion("repair_process_desc not like", value, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescIn(List<String> values) {
            addCriterion("repair_process_desc in", values, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescNotIn(List<String> values) {
            addCriterion("repair_process_desc not in", values, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescBetween(String value1, String value2) {
            addCriterion("repair_process_desc between", value1, value2, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andRepairProcessDescNotBetween(String value1, String value2) {
            addCriterion("repair_process_desc not between", value1, value2, "repairProcessDesc");
            return (Criteria) this;
        }

        public Criteria andSolutionIsNull() {
            addCriterion("solution is null");
            return (Criteria) this;
        }

        public Criteria andSolutionIsNotNull() {
            addCriterion("solution is not null");
            return (Criteria) this;
        }

        public Criteria andSolutionEqualTo(String value) {
            addCriterion("solution =", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotEqualTo(String value) {
            addCriterion("solution <>", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionGreaterThan(String value) {
            addCriterion("solution >", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionGreaterThanOrEqualTo(String value) {
            addCriterion("solution >=", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLessThan(String value) {
            addCriterion("solution <", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLessThanOrEqualTo(String value) {
            addCriterion("solution <=", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLike(String value) {
            addCriterion("solution like", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotLike(String value) {
            addCriterion("solution not like", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionIn(List<String> values) {
            addCriterion("solution in", values, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotIn(List<String> values) {
            addCriterion("solution not in", values, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionBetween(String value1, String value2) {
            addCriterion("solution between", value1, value2, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotBetween(String value1, String value2) {
            addCriterion("solution not between", value1, value2, "solution");
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