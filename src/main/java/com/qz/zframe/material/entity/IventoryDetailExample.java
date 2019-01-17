package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class IventoryDetailExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IventoryDetailExample() {
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

        public Criteria andInventoryIdIsNull() {
            addCriterion("inventory_id is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIdIsNotNull() {
            addCriterion("inventory_id is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryIdEqualTo(String value) {
            addCriterion("inventory_id =", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotEqualTo(String value) {
            addCriterion("inventory_id <>", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdGreaterThan(String value) {
            addCriterion("inventory_id >", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("inventory_id >=", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLessThan(String value) {
            addCriterion("inventory_id <", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLessThanOrEqualTo(String value) {
            addCriterion("inventory_id <=", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLike(String value) {
            addCriterion("inventory_id like", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotLike(String value) {
            addCriterion("inventory_id not like", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdIn(List<String> values) {
            addCriterion("inventory_id in", values, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotIn(List<String> values) {
            addCriterion("inventory_id not in", values, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdBetween(String value1, String value2) {
            addCriterion("inventory_id between", value1, value2, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotBetween(String value1, String value2) {
            addCriterion("inventory_id not between", value1, value2, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andAssoIdIsNull() {
            addCriterion("asso_id is null");
            return (Criteria) this;
        }

        public Criteria andAssoIdIsNotNull() {
            addCriterion("asso_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssoIdEqualTo(String value) {
            addCriterion("asso_id =", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotEqualTo(String value) {
            addCriterion("asso_id <>", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThan(String value) {
            addCriterion("asso_id >", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThanOrEqualTo(String value) {
            addCriterion("asso_id >=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThan(String value) {
            addCriterion("asso_id <", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThanOrEqualTo(String value) {
            addCriterion("asso_id <=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLike(String value) {
            addCriterion("asso_id like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotLike(String value) {
            addCriterion("asso_id not like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdIn(List<String> values) {
            addCriterion("asso_id in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotIn(List<String> values) {
            addCriterion("asso_id not in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdBetween(String value1, String value2) {
            addCriterion("asso_id between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotBetween(String value1, String value2) {
            addCriterion("asso_id not between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
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

        public Criteria andStockAddIdIsNull() {
            addCriterion("stock_add_id is null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIsNotNull() {
            addCriterion("stock_add_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdEqualTo(String value) {
            addCriterion("stock_add_id =", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotEqualTo(String value) {
            addCriterion("stock_add_id <>", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThan(String value) {
            addCriterion("stock_add_id >", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_id >=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThan(String value) {
            addCriterion("stock_add_id <", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThanOrEqualTo(String value) {
            addCriterion("stock_add_id <=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLike(String value) {
            addCriterion("stock_add_id like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotLike(String value) {
            addCriterion("stock_add_id not like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIn(List<String> values) {
            addCriterion("stock_add_id in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotIn(List<String> values) {
            addCriterion("stock_add_id not in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdBetween(String value1, String value2) {
            addCriterion("stock_add_id between", value1, value2, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotBetween(String value1, String value2) {
            addCriterion("stock_add_id not between", value1, value2, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andInventoryNumIsNull() {
            addCriterion("inventory_num is null");
            return (Criteria) this;
        }

        public Criteria andInventoryNumIsNotNull() {
            addCriterion("inventory_num is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryNumEqualTo(Integer value) {
            addCriterion("inventory_num =", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumNotEqualTo(Integer value) {
            addCriterion("inventory_num <>", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumGreaterThan(Integer value) {
            addCriterion("inventory_num >", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory_num >=", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumLessThan(Integer value) {
            addCriterion("inventory_num <", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumLessThanOrEqualTo(Integer value) {
            addCriterion("inventory_num <=", value, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumIn(List<Integer> values) {
            addCriterion("inventory_num in", values, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumNotIn(List<Integer> values) {
            addCriterion("inventory_num not in", values, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumBetween(Integer value1, Integer value2) {
            addCriterion("inventory_num between", value1, value2, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory_num not between", value1, value2, "inventoryNum");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountIsNull() {
            addCriterion("inventory_amount is null");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountIsNotNull() {
            addCriterion("inventory_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountEqualTo(BigDecimal value) {
            addCriterion("inventory_amount =", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountNotEqualTo(BigDecimal value) {
            addCriterion("inventory_amount <>", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountGreaterThan(BigDecimal value) {
            addCriterion("inventory_amount >", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inventory_amount >=", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountLessThan(BigDecimal value) {
            addCriterion("inventory_amount <", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inventory_amount <=", value, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountIn(List<BigDecimal> values) {
            addCriterion("inventory_amount in", values, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountNotIn(List<BigDecimal> values) {
            addCriterion("inventory_amount not in", values, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inventory_amount between", value1, value2, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andInventoryAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inventory_amount not between", value1, value2, "inventoryAmount");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("type_code is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("type_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("type_code =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("type_code <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("type_code >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("type_code >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("type_code <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("type_code <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("type_code like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("type_code not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("type_code in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("type_code not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("type_code between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("type_code not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNull() {
            addCriterion("access_type is null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNotNull() {
            addCriterion("access_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeEqualTo(String value) {
            addCriterion("access_type =", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotEqualTo(String value) {
            addCriterion("access_type <>", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThan(String value) {
            addCriterion("access_type >", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("access_type >=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThan(String value) {
            addCriterion("access_type <", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThanOrEqualTo(String value) {
            addCriterion("access_type <=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLike(String value) {
            addCriterion("access_type like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotLike(String value) {
            addCriterion("access_type not like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIn(List<String> values) {
            addCriterion("access_type in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotIn(List<String> values) {
            addCriterion("access_type not in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeBetween(String value1, String value2) {
            addCriterion("access_type between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotBetween(String value1, String value2) {
            addCriterion("access_type not between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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