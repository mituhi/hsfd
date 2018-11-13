package com.qz.zframe.device.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class CrewInformationExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrewInformationExample() {
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

        public Criteria andCrewIdIsNull() {
            addCriterion("crew_id is null");
            return (Criteria) this;
        }

        public Criteria andCrewIdIsNotNull() {
            addCriterion("crew_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrewIdEqualTo(String value) {
            addCriterion("crew_id =", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotEqualTo(String value) {
            addCriterion("crew_id <>", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdGreaterThan(String value) {
            addCriterion("crew_id >", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdGreaterThanOrEqualTo(String value) {
            addCriterion("crew_id >=", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLessThan(String value) {
            addCriterion("crew_id <", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLessThanOrEqualTo(String value) {
            addCriterion("crew_id <=", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdLike(String value) {
            addCriterion("crew_id like", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotLike(String value) {
            addCriterion("crew_id not like", value, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdIn(List<String> values) {
            addCriterion("crew_id in", values, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotIn(List<String> values) {
            addCriterion("crew_id not in", values, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdBetween(String value1, String value2) {
            addCriterion("crew_id between", value1, value2, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewIdNotBetween(String value1, String value2) {
            addCriterion("crew_id not between", value1, value2, "crewId");
            return (Criteria) this;
        }

        public Criteria andCrewCodeIsNull() {
            addCriterion("crew_code is null");
            return (Criteria) this;
        }

        public Criteria andCrewCodeIsNotNull() {
            addCriterion("crew_code is not null");
            return (Criteria) this;
        }

        public Criteria andCrewCodeEqualTo(String value) {
            addCriterion("crew_code =", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeNotEqualTo(String value) {
            addCriterion("crew_code <>", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeGreaterThan(String value) {
            addCriterion("crew_code >", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeGreaterThanOrEqualTo(String value) {
            addCriterion("crew_code >=", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeLessThan(String value) {
            addCriterion("crew_code <", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeLessThanOrEqualTo(String value) {
            addCriterion("crew_code <=", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeLike(String value) {
            addCriterion("crew_code like", "%"+value+"%", "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeNotLike(String value) {
            addCriterion("crew_code not like", value, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeIn(List<String> values) {
            addCriterion("crew_code in", values, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeNotIn(List<String> values) {
            addCriterion("crew_code not in", values, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeBetween(String value1, String value2) {
            addCriterion("crew_code between", value1, value2, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewCodeNotBetween(String value1, String value2) {
            addCriterion("crew_code not between", value1, value2, "crewCode");
            return (Criteria) this;
        }

        public Criteria andCrewNameIsNull() {
            addCriterion("crew_name is null");
            return (Criteria) this;
        }

        public Criteria andCrewNameIsNotNull() {
            addCriterion("crew_name is not null");
            return (Criteria) this;
        }

        public Criteria andCrewNameEqualTo(String value) {
            addCriterion("crew_name =", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameNotEqualTo(String value) {
            addCriterion("crew_name <>", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameGreaterThan(String value) {
            addCriterion("crew_name >", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameGreaterThanOrEqualTo(String value) {
            addCriterion("crew_name >=", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameLessThan(String value) {
            addCriterion("crew_name <", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameLessThanOrEqualTo(String value) {
            addCriterion("crew_name <=", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameLike(String value) {
            addCriterion("crew_name like", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameNotLike(String value) {
            addCriterion("crew_name not like", value, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameIn(List<String> values) {
            addCriterion("crew_name in", values, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameNotIn(List<String> values) {
            addCriterion("crew_name not in", values, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameBetween(String value1, String value2) {
            addCriterion("crew_name between", value1, value2, "crewName");
            return (Criteria) this;
        }

        public Criteria andCrewNameNotBetween(String value1, String value2) {
            addCriterion("crew_name not between", value1, value2, "crewName");
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
            addCriterion("c.wind_id =", value, "windId");
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

        public Criteria andInstalledCapacityIsNull() {
            addCriterion("installed_capacity is null");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityIsNotNull() {
            addCriterion("installed_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityEqualTo(String value) {
            addCriterion("installed_capacity =", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityNotEqualTo(String value) {
            addCriterion("installed_capacity <>", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityGreaterThan(String value) {
            addCriterion("installed_capacity >", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("installed_capacity >=", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityLessThan(String value) {
            addCriterion("installed_capacity <", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityLessThanOrEqualTo(String value) {
            addCriterion("installed_capacity <=", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityLike(String value) {
            addCriterion("installed_capacity like", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityNotLike(String value) {
            addCriterion("installed_capacity not like", value, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityIn(List<String> values) {
            addCriterion("installed_capacity in", values, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityNotIn(List<String> values) {
            addCriterion("installed_capacity not in", values, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityBetween(String value1, String value2) {
            addCriterion("installed_capacity between", value1, value2, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andInstalledCapacityNotBetween(String value1, String value2) {
            addCriterion("installed_capacity not between", value1, value2, "installedCapacity");
            return (Criteria) this;
        }

        public Criteria andEnableDateIsNull() {
            addCriterion("enable_date is null");
            return (Criteria) this;
        }

        public Criteria andEnableDateIsNotNull() {
            addCriterion("enable_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnableDateEqualTo(Date value) {
            addCriterion("enable_date =", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotEqualTo(Date value) {
            addCriterion("enable_date <>", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateGreaterThan(Date value) {
            addCriterion("enable_date >", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateGreaterThanOrEqualTo(Date value) {
            addCriterion("enable_date >=", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateLessThan(Date value) {
            addCriterion("enable_date <", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateLessThanOrEqualTo(Date value) {
            addCriterion("enable_date <=", value, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateIn(List<Date> values) {
            addCriterion("enable_date in", values, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotIn(List<Date> values) {
            addCriterion("enable_date not in", values, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateBetween(Date value1, Date value2) {
            addCriterion("enable_date between", value1, value2, "enableDate");
            return (Criteria) this;
        }

        public Criteria andEnableDateNotBetween(Date value1, Date value2) {
            addCriterion("enable_date not between", value1, value2, "enableDate");
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

        public Criteria andCreatDateIsNull() {
            addCriterion("creat_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNotNull() {
            addCriterion("creat_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatDateEqualTo(Date value) {
            addCriterion("creat_date =", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotEqualTo(Date value) {
            addCriterion("creat_date <>", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThan(Date value) {
            addCriterion("creat_date >", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_date >=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThan(Date value) {
            addCriterion("creat_date <", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThanOrEqualTo(Date value) {
            addCriterion("creat_date <=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateIn(List<Date> values) {
            addCriterion("creat_date in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotIn(List<Date> values) {
            addCriterion("creat_date not in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateBetween(Date value1, Date value2) {
            addCriterion("creat_date between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotBetween(Date value1, Date value2) {
            addCriterion("creat_date not between", value1, value2, "creatDate");
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