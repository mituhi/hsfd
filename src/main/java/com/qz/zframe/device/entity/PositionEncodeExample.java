package com.qz.zframe.device.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class PositionEncodeExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionEncodeExample() {
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

        public Criteria andPositionCodeIsNull() {
            addCriterion("position_code is null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNotNull() {
            addCriterion("position_code is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeEqualTo(String value) {
            addCriterion("position_code =", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotEqualTo(String value) {
            addCriterion("position_code <>", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThan(String value) {
            addCriterion("position_code >", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("position_code >=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThan(String value) {
            addCriterion("position_code <", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("position_code <=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLike(String value) {
            addCriterion("position_code like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotLike(String value) {
            addCriterion("position_code not like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIn(List<String> values) {
            addCriterion("position_code in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotIn(List<String> values) {
            addCriterion("position_code not in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeBetween(String value1, String value2) {
            addCriterion("position_code between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotBetween(String value1, String value2) {
            addCriterion("position_code not between", value1, value2, "positionCode");
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
            addCriterion("p.position_name =", value, "positionName");
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
            addCriterion("p.position_name like", "%"+value+"%", "positionName");
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

        public Criteria andSuperiorPositionIsNull() {
            addCriterion("superior_position is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionIsNotNull() {
            addCriterion("superior_position is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionEqualTo(String value) {
            addCriterion("superior_position =", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionNotEqualTo(String value) {
            addCriterion("superior_position <>", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionGreaterThan(String value) {
            addCriterion("superior_position >", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionGreaterThanOrEqualTo(String value) {
            addCriterion("superior_position >=", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionLessThan(String value) {
            addCriterion("superior_position <", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionLessThanOrEqualTo(String value) {
            addCriterion("superior_position <=", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionLike(String value) {
            addCriterion("superior_position like", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionNotLike(String value) {
            addCriterion("superior_position not like", value, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionIn(List<String> values) {
            addCriterion("superior_position in", values, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionNotIn(List<String> values) {
            addCriterion("superior_position not in", values, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionBetween(String value1, String value2) {
            addCriterion("superior_position between", value1, value2, "superiorPosition");
            return (Criteria) this;
        }

        public Criteria andSuperiorPositionNotBetween(String value1, String value2) {
            addCriterion("superior_position not between", value1, value2, "superiorPosition");
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
            addCriterion("p.wind_id =", value, "windId");
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
            addCriterion("p.hierarchy =", value, "hierarchy");
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
            addCriterion("p.crew =", value, "crew");
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