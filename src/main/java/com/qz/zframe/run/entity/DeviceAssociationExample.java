package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceAssociationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceAssociationExample() {
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

        public Criteria andDeviceAssociationIdIsNull() {
            addCriterion("device_association_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdIsNotNull() {
            addCriterion("device_association_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdEqualTo(String value) {
            addCriterion("device_association_id =", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdNotEqualTo(String value) {
            addCriterion("device_association_id <>", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdGreaterThan(String value) {
            addCriterion("device_association_id >", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_association_id >=", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdLessThan(String value) {
            addCriterion("device_association_id <", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdLessThanOrEqualTo(String value) {
            addCriterion("device_association_id <=", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdLike(String value) {
            addCriterion("device_association_id like", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdNotLike(String value) {
            addCriterion("device_association_id not like", value, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdIn(List<String> values) {
            addCriterion("device_association_id in", values, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdNotIn(List<String> values) {
            addCriterion("device_association_id not in", values, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdBetween(String value1, String value2) {
            addCriterion("device_association_id between", value1, value2, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andDeviceAssociationIdNotBetween(String value1, String value2) {
            addCriterion("device_association_id not between", value1, value2, "deviceAssociationId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdIsNull() {
            addCriterion("main_equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdIsNotNull() {
            addCriterion("main_equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdEqualTo(String value) {
            addCriterion("main_equipment_id =", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdNotEqualTo(String value) {
            addCriterion("main_equipment_id <>", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdGreaterThan(String value) {
            addCriterion("main_equipment_id >", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_equipment_id >=", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdLessThan(String value) {
            addCriterion("main_equipment_id <", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("main_equipment_id <=", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdLike(String value) {
            addCriterion("main_equipment_id like", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdNotLike(String value) {
            addCriterion("main_equipment_id not like", value, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdIn(List<String> values) {
            addCriterion("main_equipment_id in", values, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdNotIn(List<String> values) {
            addCriterion("main_equipment_id not in", values, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdBetween(String value1, String value2) {
            addCriterion("main_equipment_id between", value1, value2, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("main_equipment_id not between", value1, value2, "mainEquipmentId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdIsNull() {
            addCriterion("main_equipment_info_id is null");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdIsNotNull() {
            addCriterion("main_equipment_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdEqualTo(String value) {
            addCriterion("main_equipment_info_id =", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdNotEqualTo(String value) {
            addCriterion("main_equipment_info_id <>", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdGreaterThan(String value) {
            addCriterion("main_equipment_info_id >", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_equipment_info_id >=", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdLessThan(String value) {
            addCriterion("main_equipment_info_id <", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdLessThanOrEqualTo(String value) {
            addCriterion("main_equipment_info_id <=", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdLike(String value) {
            addCriterion("main_equipment_info_id like", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdNotLike(String value) {
            addCriterion("main_equipment_info_id not like", value, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdIn(List<String> values) {
            addCriterion("main_equipment_info_id in", values, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdNotIn(List<String> values) {
            addCriterion("main_equipment_info_id not in", values, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdBetween(String value1, String value2) {
            addCriterion("main_equipment_info_id between", value1, value2, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andMainEquipmentInfoIdNotBetween(String value1, String value2) {
            addCriterion("main_equipment_info_id not between", value1, value2, "mainEquipmentInfoId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIsNull() {
            addCriterion("device_type_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIsNotNull() {
            addCriterion("device_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdEqualTo(String value) {
            addCriterion("device_type_id =", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotEqualTo(String value) {
            addCriterion("device_type_id <>", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThan(String value) {
            addCriterion("device_type_id >", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_id >=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThan(String value) {
            addCriterion("device_type_id <", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThanOrEqualTo(String value) {
            addCriterion("device_type_id <=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLike(String value) {
            addCriterion("device_type_id like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotLike(String value) {
            addCriterion("device_type_id not like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIn(List<String> values) {
            addCriterion("device_type_id in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotIn(List<String> values) {
            addCriterion("device_type_id not in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdBetween(String value1, String value2) {
            addCriterion("device_type_id between", value1, value2, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotBetween(String value1, String value2) {
            addCriterion("device_type_id not between", value1, value2, "deviceTypeId");
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