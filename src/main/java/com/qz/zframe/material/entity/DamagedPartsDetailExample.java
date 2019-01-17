package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class DamagedPartsDetailExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DamagedPartsDetailExample() {
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

        public Criteria andDamagedPartsDetailIdIsNull() {
            addCriterion("damaged_parts_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdIsNotNull() {
            addCriterion("damaged_parts_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdEqualTo(String value) {
            addCriterion("damaged_parts_detail_id =", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotEqualTo(String value) {
            addCriterion("damaged_parts_detail_id <>", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdGreaterThan(String value) {
            addCriterion("damaged_parts_detail_id >", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_parts_detail_id >=", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLessThan(String value) {
            addCriterion("damaged_parts_detail_id <", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_parts_detail_id <=", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdLike(String value) {
            addCriterion("damaged_parts_detail_id like", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotLike(String value) {
            addCriterion("damaged_parts_detail_id not like", value, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdIn(List<String> values) {
            addCriterion("damaged_parts_detail_id in", values, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotIn(List<String> values) {
            addCriterion("damaged_parts_detail_id not in", values, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdBetween(String value1, String value2) {
            addCriterion("damaged_parts_detail_id between", value1, value2, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDetailIdNotBetween(String value1, String value2) {
            addCriterion("damaged_parts_detail_id not between", value1, value2, "damagedPartsDetailId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdIsNull() {
            addCriterion("damaged_parts_id is null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdIsNotNull() {
            addCriterion("damaged_parts_id is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdEqualTo(String value) {
            addCriterion("a.damaged_parts_id =", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdNotEqualTo(String value) {
            addCriterion("damaged_parts_id <>", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdGreaterThan(String value) {
            addCriterion("damaged_parts_id >", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_parts_id >=", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdLessThan(String value) {
            addCriterion("damaged_parts_id <", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdLessThanOrEqualTo(String value) {
            addCriterion("damaged_parts_id <=", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdLike(String value) {
            addCriterion("damaged_parts_id like", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdNotLike(String value) {
            addCriterion("damaged_parts_id not like", value, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdIn(List<String> values) {
            addCriterion("damaged_parts_id in", values, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdNotIn(List<String> values) {
            addCriterion("damaged_parts_id not in", values, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdBetween(String value1, String value2) {
            addCriterion("damaged_parts_id between", value1, value2, "damagedPartsId");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsIdNotBetween(String value1, String value2) {
            addCriterion("damaged_parts_id not between", value1, value2, "damagedPartsId");
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

        public Criteria andStorageNumIsNull() {
            addCriterion("storage_num is null");
            return (Criteria) this;
        }

        public Criteria andStorageNumIsNotNull() {
            addCriterion("storage_num is not null");
            return (Criteria) this;
        }

        public Criteria andStorageNumEqualTo(Integer value) {
            addCriterion("storage_num =", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotEqualTo(Integer value) {
            addCriterion("storage_num <>", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumGreaterThan(Integer value) {
            addCriterion("storage_num >", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_num >=", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumLessThan(Integer value) {
            addCriterion("storage_num <", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumLessThanOrEqualTo(Integer value) {
            addCriterion("storage_num <=", value, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumIn(List<Integer> values) {
            addCriterion("storage_num in", values, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotIn(List<Integer> values) {
            addCriterion("storage_num not in", values, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumBetween(Integer value1, Integer value2) {
            addCriterion("storage_num between", value1, value2, "storageNum");
            return (Criteria) this;
        }

        public Criteria andStorageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_num not between", value1, value2, "storageNum");
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