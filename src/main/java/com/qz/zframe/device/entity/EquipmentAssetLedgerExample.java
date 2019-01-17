package com.qz.zframe.device.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class EquipmentAssetLedgerExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentAssetLedgerExample() {
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

        public Criteria andEquipmentCodeIsNull() {
            addCriterion("equipment_code is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNotNull() {
            addCriterion("equipment_code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeEqualTo(String value) {
            addCriterion("equipment_code =", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotEqualTo(String value) {
            addCriterion("equipment_code <>", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThan(String value) {
            addCriterion("equipment_code >", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_code >=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThan(String value) {
            addCriterion("equipment_code <", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
            addCriterion("equipment_code <=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLike(String value) {
            addCriterion("e.equipment_code like", "%"+value+"%", "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotLike(String value) {
            addCriterion("equipment_code not like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIn(List<String> values) {
            addCriterion("equipment_code in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotIn(List<String> values) {
            addCriterion("equipment_code not in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeBetween(String value1, String value2) {
            addCriterion("equipment_code between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
            addCriterion("equipment_code not between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipment_name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipment_name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipment_name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipment_name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("e.equipment_name like", "%"+value+"%", "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipment_name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipment_name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipment_name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipment_name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipment_name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeEqualTo(String value) {
            addCriterion("e.position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
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
            addCriterion("e.wind_id =", value, "windId");
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

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andHierarchyIsNull() {
            addCriterion("hierarchy is null");
            return (Criteria) this;
        }

        public Criteria andHierarchyIsNotNull() {
            addCriterion("hierarchy is not null");
            return (Criteria) this;
        }

        public Criteria andHierarchyEqualTo(String value) {
            addCriterion("hierarchy =", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotEqualTo(String value) {
            addCriterion("hierarchy <>", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyGreaterThan(String value) {
            addCriterion("hierarchy >", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyGreaterThanOrEqualTo(String value) {
            addCriterion("hierarchy >=", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyLessThan(String value) {
            addCriterion("hierarchy <", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyLessThanOrEqualTo(String value) {
            addCriterion("hierarchy <=", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyLike(String value) {
            addCriterion("hierarchy like", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotLike(String value) {
            addCriterion("hierarchy not like", value, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyIn(List<String> values) {
            addCriterion("hierarchy in", values, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotIn(List<String> values) {
            addCriterion("hierarchy not in", values, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyBetween(String value1, String value2) {
            addCriterion("hierarchy between", value1, value2, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andHierarchyNotBetween(String value1, String value2) {
            addCriterion("hierarchy not between", value1, value2, "hierarchy");
            return (Criteria) this;
        }

        public Criteria andCrewIsNull() {
            addCriterion("crew is null");
            return (Criteria) this;
        }

        public Criteria andCrewIsNotNull() {
            addCriterion("crew is not null");
            return (Criteria) this;
        }

        public Criteria andCrewEqualTo(String value) {
            addCriterion("e.crew =", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewNotEqualTo(String value) {
            addCriterion("crew <>", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewGreaterThan(String value) {
            addCriterion("crew >", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewGreaterThanOrEqualTo(String value) {
            addCriterion("crew >=", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewLessThan(String value) {
            addCriterion("crew <", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewLessThanOrEqualTo(String value) {
            addCriterion("crew <=", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewLike(String value) {
            addCriterion("crew like", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewNotLike(String value) {
            addCriterion("crew not like", value, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewIn(List<String> values) {
            addCriterion("crew in", values, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewNotIn(List<String> values) {
            addCriterion("crew not in", values, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewBetween(String value1, String value2) {
            addCriterion("crew between", value1, value2, "crew");
            return (Criteria) this;
        }

        public Criteria andCrewNotBetween(String value1, String value2) {
            addCriterion("crew not between", value1, value2, "crew");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCostCenterIsNull() {
            addCriterion("cost_center is null");
            return (Criteria) this;
        }

        public Criteria andCostCenterIsNotNull() {
            addCriterion("cost_center is not null");
            return (Criteria) this;
        }

        public Criteria andCostCenterEqualTo(String value) {
            addCriterion("cost_center =", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotEqualTo(String value) {
            addCriterion("cost_center <>", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThan(String value) {
            addCriterion("cost_center >", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThanOrEqualTo(String value) {
            addCriterion("cost_center >=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThan(String value) {
            addCriterion("cost_center <", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThanOrEqualTo(String value) {
            addCriterion("cost_center <=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLike(String value) {
            addCriterion("cost_center like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotLike(String value) {
            addCriterion("cost_center not like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterIn(List<String> values) {
            addCriterion("cost_center in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotIn(List<String> values) {
            addCriterion("cost_center not in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterBetween(String value1, String value2) {
            addCriterion("cost_center between", value1, value2, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotBetween(String value1, String value2) {
            addCriterion("cost_center not between", value1, value2, "costCenter");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamIsNull() {
            addCriterion("maintenance_team is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamIsNotNull() {
            addCriterion("maintenance_team is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamEqualTo(String value) {
            addCriterion("maintenance_team =", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamNotEqualTo(String value) {
            addCriterion("maintenance_team <>", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamGreaterThan(String value) {
            addCriterion("maintenance_team >", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_team >=", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamLessThan(String value) {
            addCriterion("maintenance_team <", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamLessThanOrEqualTo(String value) {
            addCriterion("maintenance_team <=", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamLike(String value) {
            addCriterion("maintenance_team like", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamNotLike(String value) {
            addCriterion("maintenance_team not like", value, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamIn(List<String> values) {
            addCriterion("maintenance_team in", values, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamNotIn(List<String> values) {
            addCriterion("maintenance_team not in", values, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamBetween(String value1, String value2) {
            addCriterion("maintenance_team between", value1, value2, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTeamNotBetween(String value1, String value2) {
            addCriterion("maintenance_team not between", value1, value2, "maintenanceTeam");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(BigDecimal value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(BigDecimal value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(BigDecimal value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(BigDecimal value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(BigDecimal value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<BigDecimal> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<BigDecimal> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIsNull() {
            addCriterion("equipment_number is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIsNotNull() {
            addCriterion("equipment_number is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberEqualTo(String value) {
            addCriterion("equipment_number =", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotEqualTo(String value) {
            addCriterion("equipment_number <>", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberGreaterThan(String value) {
            addCriterion("equipment_number >", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_number >=", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLessThan(String value) {
            addCriterion("equipment_number <", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLessThanOrEqualTo(String value) {
            addCriterion("equipment_number <=", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLike(String value) {
            addCriterion("equipment_number like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotLike(String value) {
            addCriterion("equipment_number not like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIn(List<String> values) {
            addCriterion("equipment_number in", values, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotIn(List<String> values) {
            addCriterion("equipment_number not in", values, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberBetween(String value1, String value2) {
            addCriterion("equipment_number between", value1, value2, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotBetween(String value1, String value2) {
            addCriterion("equipment_number not between", value1, value2, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIsNull() {
            addCriterion("fixed_assets is null");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIsNotNull() {
            addCriterion("fixed_assets is not null");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsEqualTo(String value) {
            addCriterion("fixed_assets =", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotEqualTo(String value) {
            addCriterion("fixed_assets <>", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsGreaterThan(String value) {
            addCriterion("fixed_assets >", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_assets >=", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLessThan(String value) {
            addCriterion("fixed_assets <", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLessThanOrEqualTo(String value) {
            addCriterion("fixed_assets <=", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsLike(String value) {
            addCriterion("fixed_assets like", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotLike(String value) {
            addCriterion("fixed_assets not like", value, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsIn(List<String> values) {
            addCriterion("fixed_assets in", values, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotIn(List<String> values) {
            addCriterion("fixed_assets not in", values, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsBetween(String value1, String value2) {
            addCriterion("fixed_assets between", value1, value2, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andFixedAssetsNotBetween(String value1, String value2) {
            addCriterion("fixed_assets not between", value1, value2, "fixedAssets");
            return (Criteria) this;
        }

        public Criteria andDateManufactureIsNull() {
            addCriterion("date_manufacture is null");
            return (Criteria) this;
        }

        public Criteria andDateManufactureIsNotNull() {
            addCriterion("date_manufacture is not null");
            return (Criteria) this;
        }

        public Criteria andDateManufactureEqualTo(Date value) {
            addCriterion("date_manufacture =", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureNotEqualTo(Date value) {
            addCriterion("date_manufacture <>", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureGreaterThan(Date value) {
            addCriterion("date_manufacture >", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureGreaterThanOrEqualTo(Date value) {
            addCriterion("date_manufacture >=", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureLessThan(Date value) {
            addCriterion("date_manufacture <", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureLessThanOrEqualTo(Date value) {
            addCriterion("date_manufacture <=", value, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureIn(List<Date> values) {
            addCriterion("date_manufacture in", values, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureNotIn(List<Date> values) {
            addCriterion("date_manufacture not in", values, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureBetween(Date value1, Date value2) {
            addCriterion("date_manufacture between", value1, value2, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andDateManufactureNotBetween(Date value1, Date value2) {
            addCriterion("date_manufacture not between", value1, value2, "dateManufacture");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNull() {
            addCriterion("install_date is null");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNotNull() {
            addCriterion("install_date is not null");
            return (Criteria) this;
        }

        public Criteria andInstallDateEqualTo(Date value) {
            addCriterion("install_date =", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotEqualTo(Date value) {
            addCriterion("install_date <>", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThan(Date value) {
            addCriterion("install_date >", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThanOrEqualTo(Date value) {
            addCriterion("install_date >=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThan(Date value) {
            addCriterion("install_date <", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThanOrEqualTo(Date value) {
            addCriterion("install_date <=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateIn(List<Date> values) {
            addCriterion("install_date in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotIn(List<Date> values) {
            addCriterion("install_date not in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateBetween(Date value1, Date value2) {
            addCriterion("install_date between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotBetween(Date value1, Date value2) {
            addCriterion("install_date not between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryIsNull() {
            addCriterion("date_delivery is null");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryIsNotNull() {
            addCriterion("date_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryEqualTo(Date value) {
            addCriterion("date_delivery =", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryNotEqualTo(Date value) {
            addCriterion("date_delivery <>", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryGreaterThan(Date value) {
            addCriterion("date_delivery >", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryGreaterThanOrEqualTo(Date value) {
            addCriterion("date_delivery >=", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryLessThan(Date value) {
            addCriterion("date_delivery <", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryLessThanOrEqualTo(Date value) {
            addCriterion("date_delivery <=", value, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryIn(List<Date> values) {
            addCriterion("date_delivery in", values, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryNotIn(List<Date> values) {
            addCriterion("date_delivery not in", values, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryBetween(Date value1, Date value2) {
            addCriterion("date_delivery between", value1, value2, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andDateDeliveryNotBetween(Date value1, Date value2) {
            addCriterion("date_delivery not between", value1, value2, "dateDelivery");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationIsNull() {
            addCriterion("equipment_information is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationIsNotNull() {
            addCriterion("equipment_information is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationEqualTo(String value) {
            addCriterion("equipment_information =", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationNotEqualTo(String value) {
            addCriterion("equipment_information <>", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationGreaterThan(String value) {
            addCriterion("equipment_information >", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_information >=", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationLessThan(String value) {
            addCriterion("equipment_information <", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationLessThanOrEqualTo(String value) {
            addCriterion("equipment_information <=", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationLike(String value) {
            addCriterion("equipment_information like", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationNotLike(String value) {
            addCriterion("equipment_information not like", value, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationIn(List<String> values) {
            addCriterion("equipment_information in", values, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationNotIn(List<String> values) {
            addCriterion("equipment_information not in", values, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationBetween(String value1, String value2) {
            addCriterion("equipment_information between", value1, value2, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andEquipmentInformationNotBetween(String value1, String value2) {
            addCriterion("equipment_information not between", value1, value2, "equipmentInformation");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("e.supplier like", "%"+value+"%", "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andAssetStatusIsNull() {
            addCriterion("asset_status is null");
            return (Criteria) this;
        }

        public Criteria andAssetStatusIsNotNull() {
            addCriterion("asset_status is not null");
            return (Criteria) this;
        }

        public Criteria andAssetStatusEqualTo(String value) {
            addCriterion("e.asset_status =", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusNotEqualTo(String value) {
            addCriterion("e.asset_status <>", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusGreaterThan(String value) {
            addCriterion("asset_status >", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusGreaterThanOrEqualTo(String value) {
            addCriterion("asset_status >=", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusLessThan(String value) {
            addCriterion("asset_status <", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusLessThanOrEqualTo(String value) {
            addCriterion("asset_status <=", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusLike(String value) {
            addCriterion("asset_status like", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusNotLike(String value) {
            addCriterion("asset_status not like", value, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusIn(List<String> values) {
            addCriterion("asset_status in", values, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusNotIn(List<String> values) {
            addCriterion("asset_status not in", values, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusBetween(String value1, String value2) {
            addCriterion("asset_status between", value1, value2, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusNotBetween(String value1, String value2) {
            addCriterion("asset_status not between", value1, value2, "assetStatus");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateIsNull() {
            addCriterion("asset_status_date is null");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateIsNotNull() {
            addCriterion("asset_status_date is not null");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateEqualTo(Date value) {
            addCriterion("asset_status_date =", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateNotEqualTo(Date value) {
            addCriterion("asset_status_date <>", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateGreaterThan(Date value) {
            addCriterion("asset_status_date >", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateGreaterThanOrEqualTo(Date value) {
            addCriterion("asset_status_date >=", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateLessThan(Date value) {
            addCriterion("asset_status_date <", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateLessThanOrEqualTo(Date value) {
            addCriterion("asset_status_date <=", value, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateIn(List<Date> values) {
            addCriterion("asset_status_date in", values, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateNotIn(List<Date> values) {
            addCriterion("asset_status_date not in", values, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateBetween(Date value1, Date value2) {
            addCriterion("asset_status_date between", value1, value2, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetStatusDateNotBetween(Date value1, Date value2) {
            addCriterion("asset_status_date not between", value1, value2, "assetStatusDate");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIsNull() {
            addCriterion("asset_code is null");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIsNotNull() {
            addCriterion("asset_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCodeEqualTo(String value) {
            addCriterion("asset_code =", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotEqualTo(String value) {
            addCriterion("asset_code <>", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeGreaterThan(String value) {
            addCriterion("asset_code >", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_code >=", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLessThan(String value) {
            addCriterion("asset_code <", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLessThanOrEqualTo(String value) {
            addCriterion("asset_code <=", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeLike(String value) {
            addCriterion("asset_code like", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotLike(String value) {
            addCriterion("asset_code not like", value, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeIn(List<String> values) {
            addCriterion("asset_code in", values, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotIn(List<String> values) {
            addCriterion("asset_code not in", values, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeBetween(String value1, String value2) {
            addCriterion("asset_code between", value1, value2, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetCodeNotBetween(String value1, String value2) {
            addCriterion("asset_code not between", value1, value2, "assetCode");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNull() {
            addCriterion("asset_value is null");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNotNull() {
            addCriterion("asset_value is not null");
            return (Criteria) this;
        }

        public Criteria andAssetValueEqualTo(BigDecimal value) {
            addCriterion("asset_value =", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotEqualTo(BigDecimal value) {
            addCriterion("asset_value <>", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThan(BigDecimal value) {
            addCriterion("asset_value >", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("asset_value >=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThan(BigDecimal value) {
            addCriterion("asset_value <", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("asset_value <=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueIn(List<BigDecimal> values) {
            addCriterion("asset_value in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotIn(List<BigDecimal> values) {
            addCriterion("asset_value not in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asset_value between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asset_value not between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateIsNull() {
            addCriterion("monthly_depreciation_rate is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateIsNotNull() {
            addCriterion("monthly_depreciation_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateEqualTo(BigDecimal value) {
            addCriterion("monthly_depreciation_rate =", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateNotEqualTo(BigDecimal value) {
            addCriterion("monthly_depreciation_rate <>", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateGreaterThan(BigDecimal value) {
            addCriterion("monthly_depreciation_rate >", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_depreciation_rate >=", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateLessThan(BigDecimal value) {
            addCriterion("monthly_depreciation_rate <", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_depreciation_rate <=", value, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateIn(List<BigDecimal> values) {
            addCriterion("monthly_depreciation_rate in", values, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateNotIn(List<BigDecimal> values) {
            addCriterion("monthly_depreciation_rate not in", values, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_depreciation_rate between", value1, value2, "monthlyDepreciationRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyDepreciationRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_depreciation_rate not between", value1, value2, "monthlyDepreciationRate");
            return (Criteria) this;
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

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("e.equipment_id =", value, "equipmentId");
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