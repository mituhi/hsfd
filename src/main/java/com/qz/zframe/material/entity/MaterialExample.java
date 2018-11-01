package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class MaterialExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialExample() {
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

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("a.material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIsNull() {
            addCriterion("material_describe is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIsNotNull() {
            addCriterion("material_describe is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeEqualTo(String value) {
            addCriterion("material_describe =", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotEqualTo(String value) {
            addCriterion("material_describe <>", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeGreaterThan(String value) {
            addCriterion("material_describe >", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("material_describe >=", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLessThan(String value) {
            addCriterion("material_describe <", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLessThanOrEqualTo(String value) {
            addCriterion("material_describe <=", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLike(String value) {
            addCriterion("a.material_describe like", "%"+value+"%", "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotLike(String value) {
            addCriterion("material_describe not like", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIn(List<String> values) {
            addCriterion("material_describe in", values, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotIn(List<String> values) {
            addCriterion("material_describe not in", values, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeBetween(String value1, String value2) {
            addCriterion("material_describe between", value1, value2, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotBetween(String value1, String value2) {
            addCriterion("material_describe not between", value1, value2, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("a.material_type =", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIsNull() {
            addCriterion("measuring_unit is null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIsNotNull() {
            addCriterion("measuring_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitEqualTo(String value) {
            addCriterion("measuring_unit =", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotEqualTo(String value) {
            addCriterion("measuring_unit <>", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitGreaterThan(String value) {
            addCriterion("measuring_unit >", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitGreaterThanOrEqualTo(String value) {
            addCriterion("measuring_unit >=", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLessThan(String value) {
            addCriterion("measuring_unit <", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLessThanOrEqualTo(String value) {
            addCriterion("measuring_unit <=", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLike(String value) {
            addCriterion("measuring_unit like", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotLike(String value) {
            addCriterion("measuring_unit not like", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIn(List<String> values) {
            addCriterion("measuring_unit in", values, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotIn(List<String> values) {
            addCriterion("measuring_unit not in", values, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitBetween(String value1, String value2) {
            addCriterion("measuring_unit between", value1, value2, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotBetween(String value1, String value2) {
            addCriterion("measuring_unit not between", value1, value2, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIsNull() {
            addCriterion("material_num is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIsNotNull() {
            addCriterion("material_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumEqualTo(BigDecimal value) {
            addCriterion("material_num =", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotEqualTo(BigDecimal value) {
            addCriterion("material_num <>", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumGreaterThan(BigDecimal value) {
            addCriterion("material_num >", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("material_num >=", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumLessThan(BigDecimal value) {
            addCriterion("material_num <", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("material_num <=", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIn(List<BigDecimal> values) {
            addCriterion("material_num in", values, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotIn(List<BigDecimal> values) {
            addCriterion("material_num not in", values, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("material_num between", value1, value2, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("material_num not between", value1, value2, "materialNum");
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

        public Criteria andGraphNumberIsNull() {
            addCriterion("graph_number is null");
            return (Criteria) this;
        }

        public Criteria andGraphNumberIsNotNull() {
            addCriterion("graph_number is not null");
            return (Criteria) this;
        }

        public Criteria andGraphNumberEqualTo(String value) {
            addCriterion("graph_number =", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberNotEqualTo(String value) {
            addCriterion("graph_number <>", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberGreaterThan(String value) {
            addCriterion("graph_number >", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberGreaterThanOrEqualTo(String value) {
            addCriterion("graph_number >=", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberLessThan(String value) {
            addCriterion("graph_number <", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberLessThanOrEqualTo(String value) {
            addCriterion("graph_number <=", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberLike(String value) {
            addCriterion("graph_number like", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberNotLike(String value) {
            addCriterion("graph_number not like", value, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberIn(List<String> values) {
            addCriterion("graph_number in", values, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberNotIn(List<String> values) {
            addCriterion("graph_number not in", values, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberBetween(String value1, String value2) {
            addCriterion("graph_number between", value1, value2, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andGraphNumberNotBetween(String value1, String value2) {
            addCriterion("graph_number not between", value1, value2, "graphNumber");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdIsNull() {
            addCriterion("material_property_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdIsNotNull() {
            addCriterion("material_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdEqualTo(String value) {
            addCriterion("material_property_id =", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdNotEqualTo(String value) {
            addCriterion("material_property_id <>", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdGreaterThan(String value) {
            addCriterion("material_property_id >", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_property_id >=", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdLessThan(String value) {
            addCriterion("material_property_id <", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdLessThanOrEqualTo(String value) {
            addCriterion("material_property_id <=", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdLike(String value) {
            addCriterion("material_property_id like", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdNotLike(String value) {
            addCriterion("material_property_id not like", value, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdIn(List<String> values) {
            addCriterion("material_property_id in", values, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdNotIn(List<String> values) {
            addCriterion("material_property_id not in", values, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdBetween(String value1, String value2) {
            addCriterion("material_property_id between", value1, value2, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialPropertyIdNotBetween(String value1, String value2) {
            addCriterion("material_property_id not between", value1, value2, "materialPropertyId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIsNull() {
            addCriterion("material_group_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIsNotNull() {
            addCriterion("material_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdEqualTo(String value) {
            addCriterion("material_group_id =", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotEqualTo(String value) {
            addCriterion("material_group_id <>", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdGreaterThan(String value) {
            addCriterion("material_group_id >", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_group_id >=", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLessThan(String value) {
            addCriterion("material_group_id <", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLessThanOrEqualTo(String value) {
            addCriterion("material_group_id <=", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLike(String value) {
            addCriterion("material_group_id like", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotLike(String value) {
            addCriterion("material_group_id not like", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIn(List<String> values) {
            addCriterion("material_group_id in", values, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotIn(List<String> values) {
            addCriterion("material_group_id not in", values, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdBetween(String value1, String value2) {
            addCriterion("material_group_id between", value1, value2, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotBetween(String value1, String value2) {
            addCriterion("material_group_id not between", value1, value2, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNull() {
            addCriterion("identification is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNotNull() {
            addCriterion("identification is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationEqualTo(String value) {
            addCriterion("identification =", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotEqualTo(String value) {
            addCriterion("identification <>", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThan(String value) {
            addCriterion("identification >", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("identification >=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThan(String value) {
            addCriterion("identification <", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThanOrEqualTo(String value) {
            addCriterion("identification <=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLike(String value) {
            addCriterion("identification like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotLike(String value) {
            addCriterion("identification not like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationIn(List<String> values) {
            addCriterion("identification in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotIn(List<String> values) {
            addCriterion("identification not in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationBetween(String value1, String value2) {
            addCriterion("identification between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotBetween(String value1, String value2) {
            addCriterion("identification not between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andIsFixedIsNull() {
            addCriterion("is_fixed is null");
            return (Criteria) this;
        }

        public Criteria andIsFixedIsNotNull() {
            addCriterion("is_fixed is not null");
            return (Criteria) this;
        }

        public Criteria andIsFixedEqualTo(String value) {
            addCriterion("is_fixed =", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedNotEqualTo(String value) {
            addCriterion("is_fixed <>", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedGreaterThan(String value) {
            addCriterion("is_fixed >", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedGreaterThanOrEqualTo(String value) {
            addCriterion("is_fixed >=", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedLessThan(String value) {
            addCriterion("is_fixed <", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedLessThanOrEqualTo(String value) {
            addCriterion("is_fixed <=", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedLike(String value) {
            addCriterion("is_fixed like", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedNotLike(String value) {
            addCriterion("is_fixed not like", value, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedIn(List<String> values) {
            addCriterion("is_fixed in", values, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedNotIn(List<String> values) {
            addCriterion("is_fixed not in", values, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedBetween(String value1, String value2) {
            addCriterion("is_fixed between", value1, value2, "isFixed");
            return (Criteria) this;
        }

        public Criteria andIsFixedNotBetween(String value1, String value2) {
            addCriterion("is_fixed not between", value1, value2, "isFixed");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIsNull() {
            addCriterion("production_address is null");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIsNotNull() {
            addCriterion("production_address is not null");
            return (Criteria) this;
        }

        public Criteria andProductionAddressEqualTo(String value) {
            addCriterion("production_address =", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotEqualTo(String value) {
            addCriterion("production_address <>", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressGreaterThan(String value) {
            addCriterion("production_address >", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressGreaterThanOrEqualTo(String value) {
            addCriterion("production_address >=", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLessThan(String value) {
            addCriterion("production_address <", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLessThanOrEqualTo(String value) {
            addCriterion("production_address <=", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressLike(String value) {
            addCriterion("production_address like", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotLike(String value) {
            addCriterion("production_address not like", value, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressIn(List<String> values) {
            addCriterion("production_address in", values, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotIn(List<String> values) {
            addCriterion("production_address not in", values, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressBetween(String value1, String value2) {
            addCriterion("production_address between", value1, value2, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andProductionAddressNotBetween(String value1, String value2) {
            addCriterion("production_address not between", value1, value2, "productionAddress");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeIsNull() {
            addCriterion("is_guarantee is null");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeIsNotNull() {
            addCriterion("is_guarantee is not null");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeEqualTo(String value) {
            addCriterion("is_guarantee =", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotEqualTo(String value) {
            addCriterion("is_guarantee <>", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeGreaterThan(String value) {
            addCriterion("is_guarantee >", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("is_guarantee >=", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLessThan(String value) {
            addCriterion("is_guarantee <", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("is_guarantee <=", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLike(String value) {
            addCriterion("is_guarantee like", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotLike(String value) {
            addCriterion("is_guarantee not like", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeIn(List<String> values) {
            addCriterion("is_guarantee in", values, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotIn(List<String> values) {
            addCriterion("is_guarantee not in", values, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeBetween(String value1, String value2) {
            addCriterion("is_guarantee between", value1, value2, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotBetween(String value1, String value2) {
            addCriterion("is_guarantee not between", value1, value2, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodIsNull() {
            addCriterion("quality_guarantee_period is null");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodIsNotNull() {
            addCriterion("quality_guarantee_period is not null");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodEqualTo(String value) {
            addCriterion("quality_guarantee_period =", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodNotEqualTo(String value) {
            addCriterion("quality_guarantee_period <>", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodGreaterThan(String value) {
            addCriterion("quality_guarantee_period >", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("quality_guarantee_period >=", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodLessThan(String value) {
            addCriterion("quality_guarantee_period <", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodLessThanOrEqualTo(String value) {
            addCriterion("quality_guarantee_period <=", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodLike(String value) {
            addCriterion("quality_guarantee_period like", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodNotLike(String value) {
            addCriterion("quality_guarantee_period not like", value, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodIn(List<String> values) {
            addCriterion("quality_guarantee_period in", values, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodNotIn(List<String> values) {
            addCriterion("quality_guarantee_period not in", values, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodBetween(String value1, String value2) {
            addCriterion("quality_guarantee_period between", value1, value2, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andQualityGuaranteePeriodNotBetween(String value1, String value2) {
            addCriterion("quality_guarantee_period not between", value1, value2, "qualityGuaranteePeriod");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterIsNull() {
            addCriterion("material_parameter is null");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterIsNotNull() {
            addCriterion("material_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterEqualTo(String value) {
            addCriterion("material_parameter =", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterNotEqualTo(String value) {
            addCriterion("material_parameter <>", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterGreaterThan(String value) {
            addCriterion("material_parameter >", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterGreaterThanOrEqualTo(String value) {
            addCriterion("material_parameter >=", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterLessThan(String value) {
            addCriterion("material_parameter <", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterLessThanOrEqualTo(String value) {
            addCriterion("material_parameter <=", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterLike(String value) {
            addCriterion("material_parameter like", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterNotLike(String value) {
            addCriterion("material_parameter not like", value, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterIn(List<String> values) {
            addCriterion("material_parameter in", values, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterNotIn(List<String> values) {
            addCriterion("material_parameter not in", values, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterBetween(String value1, String value2) {
            addCriterion("material_parameter between", value1, value2, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andMaterialParameterNotBetween(String value1, String value2) {
            addCriterion("material_parameter not between", value1, value2, "materialParameter");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsControlStockIsNull() {
            addCriterion("is_control_stock is null");
            return (Criteria) this;
        }

        public Criteria andIsControlStockIsNotNull() {
            addCriterion("is_control_stock is not null");
            return (Criteria) this;
        }

        public Criteria andIsControlStockEqualTo(String value) {
            addCriterion("is_control_stock =", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockNotEqualTo(String value) {
            addCriterion("is_control_stock <>", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockGreaterThan(String value) {
            addCriterion("is_control_stock >", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockGreaterThanOrEqualTo(String value) {
            addCriterion("is_control_stock >=", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockLessThan(String value) {
            addCriterion("is_control_stock <", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockLessThanOrEqualTo(String value) {
            addCriterion("is_control_stock <=", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockLike(String value) {
            addCriterion("is_control_stock like", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockNotLike(String value) {
            addCriterion("is_control_stock not like", value, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockIn(List<String> values) {
            addCriterion("is_control_stock in", values, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockNotIn(List<String> values) {
            addCriterion("is_control_stock not in", values, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockBetween(String value1, String value2) {
            addCriterion("is_control_stock between", value1, value2, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andIsControlStockNotBetween(String value1, String value2) {
            addCriterion("is_control_stock not between", value1, value2, "isControlStock");
            return (Criteria) this;
        }

        public Criteria andStockMaxIsNull() {
            addCriterion("stock_max is null");
            return (Criteria) this;
        }

        public Criteria andStockMaxIsNotNull() {
            addCriterion("stock_max is not null");
            return (Criteria) this;
        }

        public Criteria andStockMaxEqualTo(Integer value) {
            addCriterion("stock_max =", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxNotEqualTo(Integer value) {
            addCriterion("stock_max <>", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxGreaterThan(Integer value) {
            addCriterion("stock_max >", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_max >=", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxLessThan(Integer value) {
            addCriterion("stock_max <", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxLessThanOrEqualTo(Integer value) {
            addCriterion("stock_max <=", value, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxIn(List<Integer> values) {
            addCriterion("stock_max in", values, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxNotIn(List<Integer> values) {
            addCriterion("stock_max not in", values, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxBetween(Integer value1, Integer value2) {
            addCriterion("stock_max between", value1, value2, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_max not between", value1, value2, "stockMax");
            return (Criteria) this;
        }

        public Criteria andStockMinIsNull() {
            addCriterion("stock_min is null");
            return (Criteria) this;
        }

        public Criteria andStockMinIsNotNull() {
            addCriterion("stock_min is not null");
            return (Criteria) this;
        }

        public Criteria andStockMinEqualTo(Integer value) {
            addCriterion("stock_min =", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinNotEqualTo(Integer value) {
            addCriterion("stock_min <>", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinGreaterThan(Integer value) {
            addCriterion("stock_min >", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_min >=", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinLessThan(Integer value) {
            addCriterion("stock_min <", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinLessThanOrEqualTo(Integer value) {
            addCriterion("stock_min <=", value, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinIn(List<Integer> values) {
            addCriterion("stock_min in", values, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinNotIn(List<Integer> values) {
            addCriterion("stock_min not in", values, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinBetween(Integer value1, Integer value2) {
            addCriterion("stock_min between", value1, value2, "stockMin");
            return (Criteria) this;
        }

        public Criteria andStockMinNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_min not between", value1, value2, "stockMin");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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