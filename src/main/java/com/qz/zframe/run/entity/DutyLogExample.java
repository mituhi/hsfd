package com.qz.zframe.run.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DutyLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyLogExample() {
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

        public Criteria andDutyLogIdIsNull() {
            addCriterion("duty_log_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdIsNotNull() {
            addCriterion("duty_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdEqualTo(String value) {
            addCriterion("duty_log_id =", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotEqualTo(String value) {
            addCriterion("duty_log_id <>", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdGreaterThan(String value) {
            addCriterion("duty_log_id >", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_log_id >=", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLessThan(String value) {
            addCriterion("duty_log_id <", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLessThanOrEqualTo(String value) {
            addCriterion("duty_log_id <=", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdLike(String value) {
            addCriterion("duty_log_id like", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotLike(String value) {
            addCriterion("duty_log_id not like", value, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdIn(List<String> values) {
            addCriterion("duty_log_id in", values, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotIn(List<String> values) {
            addCriterion("duty_log_id not in", values, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdBetween(String value1, String value2) {
            addCriterion("duty_log_id between", value1, value2, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andDutyLogIdNotBetween(String value1, String value2) {
            addCriterion("duty_log_id not between", value1, value2, "dutyLogId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNull() {
            addCriterion("log_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNotNull() {
            addCriterion("log_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdEqualTo(String value) {
            addCriterion("log_type_id =", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotEqualTo(String value) {
            addCriterion("log_type_id <>", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThan(String value) {
            addCriterion("log_type_id >", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_type_id >=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThan(String value) {
            addCriterion("log_type_id <", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThanOrEqualTo(String value) {
            addCriterion("log_type_id <=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLike(String value) {
            addCriterion("log_type_id like", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotLike(String value) {
            addCriterion("log_type_id not like", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIn(List<String> values) {
            addCriterion("log_type_id in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotIn(List<String> values) {
            addCriterion("log_type_id not in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdBetween(String value1, String value2) {
            addCriterion("log_type_id between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotBetween(String value1, String value2) {
            addCriterion("log_type_id not between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNull() {
            addCriterion("log_name is null");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNotNull() {
            addCriterion("log_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogNameEqualTo(String value) {
            addCriterion("log_name =", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotEqualTo(String value) {
            addCriterion("log_name <>", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThan(String value) {
            addCriterion("log_name >", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_name >=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThan(String value) {
            addCriterion("log_name <", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThanOrEqualTo(String value) {
            addCriterion("log_name <=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLike(String value) {
            addCriterion("log_name like", "%"+value+"%", "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotLike(String value) {
            addCriterion("log_name not like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameIn(List<String> values) {
            addCriterion("log_name in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotIn(List<String> values) {
            addCriterion("log_name not in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameBetween(String value1, String value2) {
            addCriterion("log_name between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotBetween(String value1, String value2) {
            addCriterion("log_name not between", value1, value2, "logName");
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

        public Criteria andSchedulingManagementIdIsNull() {
            addCriterion("scheduling_management_id is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdIsNotNull() {
            addCriterion("scheduling_management_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdEqualTo(String value) {
            addCriterion("scheduling_management_id =", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotEqualTo(String value) {
            addCriterion("scheduling_management_id <>", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdGreaterThan(String value) {
            addCriterion("scheduling_management_id >", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_management_id >=", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLessThan(String value) {
            addCriterion("scheduling_management_id <", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLessThanOrEqualTo(String value) {
            addCriterion("scheduling_management_id <=", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdLike(String value) {
            addCriterion("scheduling_management_id like", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotLike(String value) {
            addCriterion("scheduling_management_id not like", value, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdIn(List<String> values) {
            addCriterion("scheduling_management_id in", values, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotIn(List<String> values) {
            addCriterion("scheduling_management_id not in", values, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdBetween(String value1, String value2) {
            addCriterion("scheduling_management_id between", value1, value2, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingManagementIdNotBetween(String value1, String value2) {
            addCriterion("scheduling_management_id not between", value1, value2, "schedulingManagementId");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIsNull() {
            addCriterion("scheduling_name is null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIsNotNull() {
            addCriterion("scheduling_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameEqualTo(String value) {
            addCriterion("scheduling_name =", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotEqualTo(String value) {
            addCriterion("scheduling_name <>", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameGreaterThan(String value) {
            addCriterion("scheduling_name >", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameGreaterThanOrEqualTo(String value) {
            addCriterion("scheduling_name >=", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLessThan(String value) {
            addCriterion("scheduling_name <", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLessThanOrEqualTo(String value) {
            addCriterion("scheduling_name <=", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameLike(String value) {
            addCriterion("scheduling_name like", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotLike(String value) {
            addCriterion("scheduling_name not like", value, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameIn(List<String> values) {
            addCriterion("scheduling_name in", values, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotIn(List<String> values) {
            addCriterion("scheduling_name not in", values, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameBetween(String value1, String value2) {
            addCriterion("scheduling_name between", value1, value2, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andSchedulingNameNotBetween(String value1, String value2) {
            addCriterion("scheduling_name not between", value1, value2, "schedulingName");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNull() {
            addCriterion("duty_user is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIsNotNull() {
            addCriterion("duty_user is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserEqualTo(String value) {
            addCriterion("duty_user =", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotEqualTo(String value) {
            addCriterion("duty_user <>", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThan(String value) {
            addCriterion("duty_user >", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user >=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThan(String value) {
            addCriterion("duty_user <", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLessThanOrEqualTo(String value) {
            addCriterion("duty_user <=", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserLike(String value) {
            addCriterion("duty_user like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotLike(String value) {
            addCriterion("duty_user not like", value, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserIn(List<String> values) {
            addCriterion("duty_user in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotIn(List<String> values) {
            addCriterion("duty_user not in", values, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserBetween(String value1, String value2) {
            addCriterion("duty_user between", value1, value2, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserNotBetween(String value1, String value2) {
            addCriterion("duty_user not between", value1, value2, "dutyUser");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsIsNull() {
            addCriterion("duty_user_ids is null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsIsNotNull() {
            addCriterion("duty_user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsEqualTo(String value) {
            addCriterion("duty_user_ids =", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotEqualTo(String value) {
            addCriterion("duty_user_ids <>", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsGreaterThan(String value) {
            addCriterion("duty_user_ids >", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("duty_user_ids >=", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLessThan(String value) {
            addCriterion("duty_user_ids <", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLessThanOrEqualTo(String value) {
            addCriterion("duty_user_ids <=", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsLike(String value) {
            addCriterion("duty_user_ids like", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotLike(String value) {
            addCriterion("duty_user_ids not like", value, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsIn(List<String> values) {
            addCriterion("duty_user_ids in", values, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotIn(List<String> values) {
            addCriterion("duty_user_ids not in", values, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsBetween(String value1, String value2) {
            addCriterion("duty_user_ids between", value1, value2, "dutyUserIds");
            return (Criteria) this;
        }

        public Criteria andDutyUserIdsNotBetween(String value1, String value2) {
            addCriterion("duty_user_ids not between", value1, value2, "dutyUserIds");
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

        public Criteria andIsFaceToFaceIsNull() {
            addCriterion("is_face_to_face is null");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceIsNotNull() {
            addCriterion("is_face_to_face is not null");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceEqualTo(String value) {
            addCriterion("is_face_to_face =", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceNotEqualTo(String value) {
            addCriterion("is_face_to_face <>", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceGreaterThan(String value) {
            addCriterion("is_face_to_face >", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceGreaterThanOrEqualTo(String value) {
            addCriterion("is_face_to_face >=", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceLessThan(String value) {
            addCriterion("is_face_to_face <", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceLessThanOrEqualTo(String value) {
            addCriterion("is_face_to_face <=", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceLike(String value) {
            addCriterion("is_face_to_face like", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceNotLike(String value) {
            addCriterion("is_face_to_face not like", value, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceIn(List<String> values) {
            addCriterion("is_face_to_face in", values, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceNotIn(List<String> values) {
            addCriterion("is_face_to_face not in", values, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceBetween(String value1, String value2) {
            addCriterion("is_face_to_face between", value1, value2, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andIsFaceToFaceNotBetween(String value1, String value2) {
            addCriterion("is_face_to_face not between", value1, value2, "isFaceToFace");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andDutyRememberIdIsNull() {
            addCriterion("duty_remember_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdIsNotNull() {
            addCriterion("duty_remember_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdEqualTo(String value) {
            addCriterion("duty_remember_id =", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdNotEqualTo(String value) {
            addCriterion("duty_remember_id <>", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdGreaterThan(String value) {
            addCriterion("duty_remember_id >", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdGreaterThanOrEqualTo(String value) {
            addCriterion("duty_remember_id >=", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdLessThan(String value) {
            addCriterion("duty_remember_id <", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdLessThanOrEqualTo(String value) {
            addCriterion("duty_remember_id <=", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdLike(String value) {
            addCriterion("duty_remember_id like", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdNotLike(String value) {
            addCriterion("duty_remember_id not like", value, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdIn(List<String> values) {
            addCriterion("duty_remember_id in", values, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdNotIn(List<String> values) {
            addCriterion("duty_remember_id not in", values, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdBetween(String value1, String value2) {
            addCriterion("duty_remember_id between", value1, value2, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andDutyRememberIdNotBetween(String value1, String value2) {
            addCriterion("duty_remember_id not between", value1, value2, "dutyRememberId");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNull() {
            addCriterion("TAB_id is null");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNotNull() {
            addCriterion("TAB_id is not null");
            return (Criteria) this;
        }

        public Criteria andTabIdEqualTo(String value) {
            addCriterion("TAB_id =", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotEqualTo(String value) {
            addCriterion("TAB_id <>", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThan(String value) {
            addCriterion("TAB_id >", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_id >=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThan(String value) {
            addCriterion("TAB_id <", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThanOrEqualTo(String value) {
            addCriterion("TAB_id <=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLike(String value) {
            addCriterion("TAB_id like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotLike(String value) {
            addCriterion("TAB_id not like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdIn(List<String> values) {
            addCriterion("TAB_id in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotIn(List<String> values) {
            addCriterion("TAB_id not in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdBetween(String value1, String value2) {
            addCriterion("TAB_id between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotBetween(String value1, String value2) {
            addCriterion("TAB_id not between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andMaintainUserIsNull() {
            addCriterion("maintain_user is null");
            return (Criteria) this;
        }

        public Criteria andMaintainUserIsNotNull() {
            addCriterion("maintain_user is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainUserEqualTo(String value) {
            addCriterion("maintain_user =", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserNotEqualTo(String value) {
            addCriterion("maintain_user <>", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserGreaterThan(String value) {
            addCriterion("maintain_user >", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserGreaterThanOrEqualTo(String value) {
            addCriterion("maintain_user >=", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserLessThan(String value) {
            addCriterion("maintain_user <", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserLessThanOrEqualTo(String value) {
            addCriterion("maintain_user <=", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserLike(String value) {
            addCriterion("maintain_user like", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserNotLike(String value) {
            addCriterion("maintain_user not like", value, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserIn(List<String> values) {
            addCriterion("maintain_user in", values, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserNotIn(List<String> values) {
            addCriterion("maintain_user not in", values, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserBetween(String value1, String value2) {
            addCriterion("maintain_user between", value1, value2, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andMaintainUserNotBetween(String value1, String value2) {
            addCriterion("maintain_user not between", value1, value2, "maintainUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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