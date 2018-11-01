package com.qz.zframe.device.entity;

import java.util.ArrayList;
import java.util.List;
import com.qz.zframe.common.util.PageExample;

public class EquipmentClassificationExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentClassificationExample() {
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

        public Criteria andEquipmentTypeIsNull() {
            addCriterion("equipment_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNotNull() {
            addCriterion("equipment_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeEqualTo(String value) {
            addCriterion("equipment_type =", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotEqualTo(String value) {
            addCriterion("equipment_type <>", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThan(String value) {
            addCriterion("equipment_type >", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type >=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThan(String value) {
            addCriterion("equipment_type <", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type <=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLike(String value) {
            addCriterion("equipment_type like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotLike(String value) {
            addCriterion("equipment_type not like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIn(List<String> values) {
            addCriterion("equipment_type in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotIn(List<String> values) {
            addCriterion("equipment_type not in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeBetween(String value1, String value2) {
            addCriterion("equipment_type between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotBetween(String value1, String value2) {
            addCriterion("equipment_type not between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", "%"+value+"%", "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentIsNull() {
            addCriterion("superior_equipment is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentIsNotNull() {
            addCriterion("superior_equipment is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentEqualTo(String value) {
            addCriterion("superior_equipment =", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNotEqualTo(String value) {
            addCriterion("superior_equipment <>", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentGreaterThan(String value) {
            addCriterion("superior_equipment >", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("superior_equipment >=", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentLessThan(String value) {
            addCriterion("superior_equipment <", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentLessThanOrEqualTo(String value) {
            addCriterion("superior_equipment <=", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentLike(String value) {
            addCriterion("superior_equipment like", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNotLike(String value) {
            addCriterion("superior_equipment not like", value, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentIn(List<String> values) {
            addCriterion("superior_equipment in", values, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNotIn(List<String> values) {
            addCriterion("superior_equipment not in", values, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentBetween(String value1, String value2) {
            addCriterion("superior_equipment between", value1, value2, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNotBetween(String value1, String value2) {
            addCriterion("superior_equipment not between", value1, value2, "superiorEquipment");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeIsNull() {
            addCriterion("superior_equipment_describe is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeIsNotNull() {
            addCriterion("superior_equipment_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeEqualTo(String value) {
            addCriterion("superior_equipment_describe =", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeNotEqualTo(String value) {
            addCriterion("superior_equipment_describe <>", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeGreaterThan(String value) {
            addCriterion("superior_equipment_describe >", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("superior_equipment_describe >=", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeLessThan(String value) {
            addCriterion("superior_equipment_describe <", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeLessThanOrEqualTo(String value) {
            addCriterion("superior_equipment_describe <=", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeLike(String value) {
            addCriterion("superior_equipment_describe like", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeNotLike(String value) {
            addCriterion("superior_equipment_describe not like", value, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeIn(List<String> values) {
            addCriterion("superior_equipment_describe in", values, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeNotIn(List<String> values) {
            addCriterion("superior_equipment_describe not in", values, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeBetween(String value1, String value2) {
            addCriterion("superior_equipment_describe between", value1, value2, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentDescribeNotBetween(String value1, String value2) {
            addCriterion("superior_equipment_describe not between", value1, value2, "superiorEquipmentDescribe");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameIsNull() {
            addCriterion("superior_equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameIsNotNull() {
            addCriterion("superior_equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameEqualTo(String value) {
            addCriterion("superior_equipment_name =", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameNotEqualTo(String value) {
            addCriterion("superior_equipment_name <>", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameGreaterThan(String value) {
            addCriterion("superior_equipment_name >", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("superior_equipment_name >=", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameLessThan(String value) {
            addCriterion("superior_equipment_name <", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("superior_equipment_name <=", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameLike(String value) {
            addCriterion("superior_equipment_name like", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameNotLike(String value) {
            addCriterion("superior_equipment_name not like", value, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameIn(List<String> values) {
            addCriterion("superior_equipment_name in", values, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameNotIn(List<String> values) {
            addCriterion("superior_equipment_name not in", values, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameBetween(String value1, String value2) {
            addCriterion("superior_equipment_name between", value1, value2, "superiorEquipmentName");
            return (Criteria) this;
        }

        public Criteria andSuperiorEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("superior_equipment_name not between", value1, value2, "superiorEquipmentName");
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

        public Criteria andIsToplevelIsNull() {
            addCriterion("is_toplevel is null");
            return (Criteria) this;
        }

        public Criteria andIsToplevelIsNotNull() {
            addCriterion("is_toplevel is not null");
            return (Criteria) this;
        }

        public Criteria andIsToplevelEqualTo(String value) {
            addCriterion("is_toplevel =", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelNotEqualTo(String value) {
            addCriterion("is_toplevel <>", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelGreaterThan(String value) {
            addCriterion("is_toplevel >", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelGreaterThanOrEqualTo(String value) {
            addCriterion("is_toplevel >=", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelLessThan(String value) {
            addCriterion("is_toplevel <", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelLessThanOrEqualTo(String value) {
            addCriterion("is_toplevel <=", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelLike(String value) {
            addCriterion("is_toplevel like", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelNotLike(String value) {
            addCriterion("is_toplevel not like", value, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelIn(List<String> values) {
            addCriterion("is_toplevel in", values, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelNotIn(List<String> values) {
            addCriterion("is_toplevel not in", values, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelBetween(String value1, String value2) {
            addCriterion("is_toplevel between", value1, value2, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andIsToplevelNotBetween(String value1, String value2) {
            addCriterion("is_toplevel not between", value1, value2, "isToplevel");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeIsNull() {
            addCriterion("equipment_type_describe is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeIsNotNull() {
            addCriterion("equipment_type_describe is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeEqualTo(String value) {
            addCriterion("equipment_type_describe =", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeNotEqualTo(String value) {
            addCriterion("equipment_type_describe <>", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeGreaterThan(String value) {
            addCriterion("equipment_type_describe >", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type_describe >=", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeLessThan(String value) {
            addCriterion("equipment_type_describe <", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type_describe <=", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeLike(String value) {
            addCriterion("equipment_type_describe like", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeNotLike(String value) {
            addCriterion("equipment_type_describe not like", value, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeIn(List<String> values) {
            addCriterion("equipment_type_describe in", values, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeNotIn(List<String> values) {
            addCriterion("equipment_type_describe not in", values, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeBetween(String value1, String value2) {
            addCriterion("equipment_type_describe between", value1, value2, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeDescribeNotBetween(String value1, String value2) {
            addCriterion("equipment_type_describe not between", value1, value2, "equipmentTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andOutputIdIsNull() {
            addCriterion("output_id is null");
            return (Criteria) this;
        }

        public Criteria andOutputIdIsNotNull() {
            addCriterion("output_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutputIdEqualTo(String value) {
            addCriterion("output_id =", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdNotEqualTo(String value) {
            addCriterion("output_id <>", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdGreaterThan(String value) {
            addCriterion("output_id >", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdGreaterThanOrEqualTo(String value) {
            addCriterion("output_id >=", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdLessThan(String value) {
            addCriterion("output_id <", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdLessThanOrEqualTo(String value) {
            addCriterion("output_id <=", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdLike(String value) {
            addCriterion("output_id like", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdNotLike(String value) {
            addCriterion("output_id not like", value, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdIn(List<String> values) {
            addCriterion("output_id in", values, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdNotIn(List<String> values) {
            addCriterion("output_id not in", values, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdBetween(String value1, String value2) {
            addCriterion("output_id between", value1, value2, "outputId");
            return (Criteria) this;
        }

        public Criteria andOutputIdNotBetween(String value1, String value2) {
            addCriterion("output_id not between", value1, value2, "outputId");
            return (Criteria) this;
        }

        public Criteria andRunIdIsNull() {
            addCriterion("run_id is null");
            return (Criteria) this;
        }

        public Criteria andRunIdIsNotNull() {
            addCriterion("run_id is not null");
            return (Criteria) this;
        }

        public Criteria andRunIdEqualTo(String value) {
            addCriterion("run_id =", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdNotEqualTo(String value) {
            addCriterion("run_id <>", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdGreaterThan(String value) {
            addCriterion("run_id >", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdGreaterThanOrEqualTo(String value) {
            addCriterion("run_id >=", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdLessThan(String value) {
            addCriterion("run_id <", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdLessThanOrEqualTo(String value) {
            addCriterion("run_id <=", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdLike(String value) {
            addCriterion("run_id like", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdNotLike(String value) {
            addCriterion("run_id not like", value, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdIn(List<String> values) {
            addCriterion("run_id in", values, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdNotIn(List<String> values) {
            addCriterion("run_id not in", values, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdBetween(String value1, String value2) {
            addCriterion("run_id between", value1, value2, "runId");
            return (Criteria) this;
        }

        public Criteria andRunIdNotBetween(String value1, String value2) {
            addCriterion("run_id not between", value1, value2, "runId");
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