package com.qz.zframe.device.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class RunParametersExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RunParametersExample() {
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

        public Criteria andTechnicalIdIsNull() {
            addCriterion("technical_id is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdIsNotNull() {
            addCriterion("technical_id is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdEqualTo(String value) {
            addCriterion("technical_id =", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotEqualTo(String value) {
            addCriterion("technical_id <>", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdGreaterThan(String value) {
            addCriterion("technical_id >", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdGreaterThanOrEqualTo(String value) {
            addCriterion("technical_id >=", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdLessThan(String value) {
            addCriterion("technical_id <", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdLessThanOrEqualTo(String value) {
            addCriterion("technical_id <=", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdLike(String value) {
            addCriterion("technical_id like", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotLike(String value) {
            addCriterion("technical_id not like", value, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdIn(List<String> values) {
            addCriterion("technical_id in", values, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotIn(List<String> values) {
            addCriterion("technical_id not in", values, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdBetween(String value1, String value2) {
            addCriterion("technical_id between", value1, value2, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalIdNotBetween(String value1, String value2) {
            addCriterion("technical_id not between", value1, value2, "technicalId");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeIsNull() {
            addCriterion("technical_type is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeIsNotNull() {
            addCriterion("technical_type is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeEqualTo(String value) {
            addCriterion("technical_type =", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeNotEqualTo(String value) {
            addCriterion("technical_type <>", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeGreaterThan(String value) {
            addCriterion("technical_type >", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("technical_type >=", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeLessThan(String value) {
            addCriterion("technical_type <", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeLessThanOrEqualTo(String value) {
            addCriterion("technical_type <=", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeLike(String value) {
            addCriterion("technical_type like", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeNotLike(String value) {
            addCriterion("technical_type not like", value, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeIn(List<String> values) {
            addCriterion("technical_type in", values, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeNotIn(List<String> values) {
            addCriterion("technical_type not in", values, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeBetween(String value1, String value2) {
            addCriterion("technical_type between", value1, value2, "technicalType");
            return (Criteria) this;
        }

        public Criteria andTechnicalTypeNotBetween(String value1, String value2) {
            addCriterion("technical_type not between", value1, value2, "technicalType");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNull() {
            addCriterion("parameter_code is null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNotNull() {
            addCriterion("parameter_code is not null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeEqualTo(String value) {
            addCriterion("parameter_code =", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotEqualTo(String value) {
            addCriterion("parameter_code <>", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThan(String value) {
            addCriterion("parameter_code >", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_code >=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThan(String value) {
            addCriterion("parameter_code <", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThanOrEqualTo(String value) {
            addCriterion("parameter_code <=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLike(String value) {
            addCriterion("parameter_code like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotLike(String value) {
            addCriterion("parameter_code not like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIn(List<String> values) {
            addCriterion("parameter_code in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotIn(List<String> values) {
            addCriterion("parameter_code not in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeBetween(String value1, String value2) {
            addCriterion("parameter_code between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotBetween(String value1, String value2) {
            addCriterion("parameter_code not between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNull() {
            addCriterion("parameter_name is null");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNotNull() {
            addCriterion("parameter_name is not null");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualTo(String value) {
            addCriterion("parameter_name =", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualTo(String value) {
            addCriterion("parameter_name <>", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThan(String value) {
            addCriterion("parameter_name >", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_name >=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThan(String value) {
            addCriterion("parameter_name <", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualTo(String value) {
            addCriterion("parameter_name <=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLike(String value) {
            addCriterion("parameter_name like", "%"+value+"%", "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotLike(String value) {
            addCriterion("parameter_name not like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameIn(List<String> values) {
            addCriterion("parameter_name in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotIn(List<String> values) {
            addCriterion("parameter_name not in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameBetween(String value1, String value2) {
            addCriterion("parameter_name between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotBetween(String value1, String value2) {
            addCriterion("parameter_name not between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andNumberValueIsNull() {
            addCriterion("number_value is null");
            return (Criteria) this;
        }

        public Criteria andNumberValueIsNotNull() {
            addCriterion("number_value is not null");
            return (Criteria) this;
        }

        public Criteria andNumberValueEqualTo(String value) {
            addCriterion("number_value =", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueNotEqualTo(String value) {
            addCriterion("number_value <>", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueGreaterThan(String value) {
            addCriterion("number_value >", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueGreaterThanOrEqualTo(String value) {
            addCriterion("number_value >=", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueLessThan(String value) {
            addCriterion("number_value <", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueLessThanOrEqualTo(String value) {
            addCriterion("number_value <=", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueLike(String value) {
            addCriterion("number_value like", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueNotLike(String value) {
            addCriterion("number_value not like", value, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueIn(List<String> values) {
            addCriterion("number_value in", values, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueNotIn(List<String> values) {
            addCriterion("number_value not in", values, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueBetween(String value1, String value2) {
            addCriterion("number_value between", value1, value2, "numberValue");
            return (Criteria) this;
        }

        public Criteria andNumberValueNotBetween(String value1, String value2) {
            addCriterion("number_value not between", value1, value2, "numberValue");
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

        public Criteria andAlphabetValueIsNull() {
            addCriterion("alphabet_value is null");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueIsNotNull() {
            addCriterion("alphabet_value is not null");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueEqualTo(String value) {
            addCriterion("alphabet_value =", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueNotEqualTo(String value) {
            addCriterion("alphabet_value <>", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueGreaterThan(String value) {
            addCriterion("alphabet_value >", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueGreaterThanOrEqualTo(String value) {
            addCriterion("alphabet_value >=", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueLessThan(String value) {
            addCriterion("alphabet_value <", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueLessThanOrEqualTo(String value) {
            addCriterion("alphabet_value <=", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueLike(String value) {
            addCriterion("alphabet_value like", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueNotLike(String value) {
            addCriterion("alphabet_value not like", value, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueIn(List<String> values) {
            addCriterion("alphabet_value in", values, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueNotIn(List<String> values) {
            addCriterion("alphabet_value not in", values, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueBetween(String value1, String value2) {
            addCriterion("alphabet_value between", value1, value2, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andAlphabetValueNotBetween(String value1, String value2) {
            addCriterion("alphabet_value not between", value1, value2, "alphabetValue");
            return (Criteria) this;
        }

        public Criteria andImportantGradeIsNull() {
            addCriterion("important_grade is null");
            return (Criteria) this;
        }

        public Criteria andImportantGradeIsNotNull() {
            addCriterion("important_grade is not null");
            return (Criteria) this;
        }

        public Criteria andImportantGradeEqualTo(String value) {
            addCriterion("important_grade =", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeNotEqualTo(String value) {
            addCriterion("important_grade <>", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeGreaterThan(String value) {
            addCriterion("important_grade >", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeGreaterThanOrEqualTo(String value) {
            addCriterion("important_grade >=", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeLessThan(String value) {
            addCriterion("important_grade <", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeLessThanOrEqualTo(String value) {
            addCriterion("important_grade <=", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeLike(String value) {
            addCriterion("important_grade like", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeNotLike(String value) {
            addCriterion("important_grade not like", value, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeIn(List<String> values) {
            addCriterion("important_grade in", values, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeNotIn(List<String> values) {
            addCriterion("important_grade not in", values, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeBetween(String value1, String value2) {
            addCriterion("important_grade between", value1, value2, "importantGrade");
            return (Criteria) this;
        }

        public Criteria andImportantGradeNotBetween(String value1, String value2) {
            addCriterion("important_grade not between", value1, value2, "importantGrade");
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