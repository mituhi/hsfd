package com.qz.zframe.device.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class ComponentsExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComponentsExample() {
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

        public Criteria andComponentIdIsNull() {
            addCriterion("component_id is null");
            return (Criteria) this;
        }

        public Criteria andComponentIdIsNotNull() {
            addCriterion("component_id is not null");
            return (Criteria) this;
        }

        public Criteria andComponentIdEqualTo(String value) {
            addCriterion("component_id =", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotEqualTo(String value) {
            addCriterion("component_id <>", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdGreaterThan(String value) {
            addCriterion("component_id >", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdGreaterThanOrEqualTo(String value) {
            addCriterion("component_id >=", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdLessThan(String value) {
            addCriterion("component_id <", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdLessThanOrEqualTo(String value) {
            addCriterion("component_id <=", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdLike(String value) {
            addCriterion("component_id like", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotLike(String value) {
            addCriterion("component_id not like", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdIn(List<String> values) {
            addCriterion("component_id in", values, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotIn(List<String> values) {
            addCriterion("component_id not in", values, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdBetween(String value1, String value2) {
            addCriterion("component_id between", value1, value2, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotBetween(String value1, String value2) {
            addCriterion("component_id not between", value1, value2, "componentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdIsNull() {
            addCriterion("equipment_asset_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdIsNotNull() {
            addCriterion("equipment_asset_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdEqualTo(String value) {
            addCriterion("equipment_asset_id =", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdNotEqualTo(String value) {
            addCriterion("equipment_asset_id <>", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdGreaterThan(String value) {
            addCriterion("equipment_asset_id >", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_asset_id >=", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdLessThan(String value) {
            addCriterion("equipment_asset_id <", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_asset_id <=", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdLike(String value) {
            addCriterion("equipment_asset_id like", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdNotLike(String value) {
            addCriterion("equipment_asset_id not like", value, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdIn(List<String> values) {
            addCriterion("equipment_asset_id in", values, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdNotIn(List<String> values) {
            addCriterion("equipment_asset_id not in", values, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdBetween(String value1, String value2) {
            addCriterion("equipment_asset_id between", value1, value2, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAssetIdNotBetween(String value1, String value2) {
            addCriterion("equipment_asset_id not between", value1, value2, "equipmentAssetId");
            return (Criteria) this;
        }

        public Criteria andComponentCodeIsNull() {
            addCriterion("component_code is null");
            return (Criteria) this;
        }

        public Criteria andComponentCodeIsNotNull() {
            addCriterion("component_code is not null");
            return (Criteria) this;
        }

        public Criteria andComponentCodeEqualTo(String value) {
            addCriterion("component_code =", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeNotEqualTo(String value) {
            addCriterion("component_code <>", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeGreaterThan(String value) {
            addCriterion("component_code >", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("component_code >=", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeLessThan(String value) {
            addCriterion("component_code <", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeLessThanOrEqualTo(String value) {
            addCriterion("component_code <=", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeLike(String value) {
            addCriterion("component_code like", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeNotLike(String value) {
            addCriterion("component_code not like", value, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeIn(List<String> values) {
            addCriterion("component_code in", values, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeNotIn(List<String> values) {
            addCriterion("component_code not in", values, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeBetween(String value1, String value2) {
            addCriterion("component_code between", value1, value2, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentCodeNotBetween(String value1, String value2) {
            addCriterion("component_code not between", value1, value2, "componentCode");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNull() {
            addCriterion("component_name is null");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNotNull() {
            addCriterion("component_name is not null");
            return (Criteria) this;
        }

        public Criteria andComponentNameEqualTo(String value) {
            addCriterion("component_name =", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotEqualTo(String value) {
            addCriterion("component_name <>", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThan(String value) {
            addCriterion("component_name >", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThanOrEqualTo(String value) {
            addCriterion("component_name >=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThan(String value) {
            addCriterion("component_name <", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThanOrEqualTo(String value) {
            addCriterion("component_name <=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLike(String value) {
            addCriterion("component_name like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotLike(String value) {
            addCriterion("component_name not like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameIn(List<String> values) {
            addCriterion("component_name in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotIn(List<String> values) {
            addCriterion("component_name not in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameBetween(String value1, String value2) {
            addCriterion("component_name between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotBetween(String value1, String value2) {
            addCriterion("component_name not between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelIsNull() {
            addCriterion("specification_model is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelIsNotNull() {
            addCriterion("specification_model is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelEqualTo(String value) {
            addCriterion("specification_model =", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelNotEqualTo(String value) {
            addCriterion("specification_model <>", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelGreaterThan(String value) {
            addCriterion("specification_model >", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelGreaterThanOrEqualTo(String value) {
            addCriterion("specification_model >=", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelLessThan(String value) {
            addCriterion("specification_model <", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelLessThanOrEqualTo(String value) {
            addCriterion("specification_model <=", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelLike(String value) {
            addCriterion("specification_model like", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelNotLike(String value) {
            addCriterion("specification_model not like", value, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelIn(List<String> values) {
            addCriterion("specification_model in", values, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelNotIn(List<String> values) {
            addCriterion("specification_model not in", values, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelBetween(String value1, String value2) {
            addCriterion("specification_model between", value1, value2, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andSpecificationModelNotBetween(String value1, String value2) {
            addCriterion("specification_model not between", value1, value2, "specificationModel");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(BigDecimal value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(BigDecimal value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(BigDecimal value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(BigDecimal value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<BigDecimal> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<BigDecimal> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number not between", value1, value2, "number");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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