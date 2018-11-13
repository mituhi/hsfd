package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class DamagedPartsExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DamagedPartsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
            addCriterion("damaged_parts_id =", value, "damagedPartsId");
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

        public Criteria andDamagedPartsOrderIsNull() {
            addCriterion("damaged_parts_order is null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderIsNotNull() {
            addCriterion("damaged_parts_order is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderEqualTo(String value) {
            addCriterion("damaged_parts_order =", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderNotEqualTo(String value) {
            addCriterion("damaged_parts_order <>", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderGreaterThan(String value) {
            addCriterion("damaged_parts_order >", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_parts_order >=", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderLessThan(String value) {
            addCriterion("damaged_parts_order <", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderLessThanOrEqualTo(String value) {
            addCriterion("damaged_parts_order <=", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderLike(String value) {
            addCriterion("damaged_parts_order like", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderNotLike(String value) {
            addCriterion("damaged_parts_order not like", value, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderIn(List<String> values) {
            addCriterion("damaged_parts_order in", values, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderNotIn(List<String> values) {
            addCriterion("damaged_parts_order not in", values, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderBetween(String value1, String value2) {
            addCriterion("damaged_parts_order between", value1, value2, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsOrderNotBetween(String value1, String value2) {
            addCriterion("damaged_parts_order not between", value1, value2, "damagedPartsOrder");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeIsNull() {
            addCriterion("damaged_parts_describe is null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeIsNotNull() {
            addCriterion("damaged_parts_describe is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeEqualTo(String value) {
            addCriterion("damaged_parts_describe =", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeNotEqualTo(String value) {
            addCriterion("damaged_parts_describe <>", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeGreaterThan(String value) {
            addCriterion("damaged_parts_describe >", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("damaged_parts_describe >=", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeLessThan(String value) {
            addCriterion("damaged_parts_describe <", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeLessThanOrEqualTo(String value) {
            addCriterion("damaged_parts_describe <=", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeLike(String value) {
            addCriterion("a.damaged_parts_describe like", "%"+value+"%", "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeNotLike(String value) {
            addCriterion("damaged_parts_describe not like", value, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeIn(List<String> values) {
            addCriterion("damaged_parts_describe in", values, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeNotIn(List<String> values) {
            addCriterion("damaged_parts_describe not in", values, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeBetween(String value1, String value2) {
            addCriterion("damaged_parts_describe between", value1, value2, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andDamagedPartsDescribeNotBetween(String value1, String value2) {
            addCriterion("damaged_parts_describe not between", value1, value2, "damagedPartsDescribe");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIsNull() {
            addCriterion("stock_add_id is null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIsNotNull() {
            addCriterion("stock_add_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockAddIdEqualTo(String value) {
            addCriterion("a.stock_add_id =", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotEqualTo(String value) {
            addCriterion("stock_add_id <>", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThan(String value) {
            addCriterion("stock_add_id >", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_add_id >=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThan(String value) {
            addCriterion("stock_add_id <", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLessThanOrEqualTo(String value) {
            addCriterion("stock_add_id <=", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdLike(String value) {
            addCriterion("stock_add_id like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotLike(String value) {
            addCriterion("stock_add_id not like", value, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdIn(List<String> values) {
            addCriterion("stock_add_id in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotIn(List<String> values) {
            addCriterion("stock_add_id not in", values, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdBetween(String value1, String value2) {
            addCriterion("stock_add_id between", value1, value2, "stockAddId");
            return (Criteria) this;
        }

        public Criteria andStockAddIdNotBetween(String value1, String value2) {
            addCriterion("stock_add_id not between", value1, value2, "stockAddId");
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

        public Criteria andStorageTimeIsNull() {
            addCriterion("storage_time is null");
            return (Criteria) this;
        }

        public Criteria andStorageTimeIsNotNull() {
            addCriterion("storage_time is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTimeEqualTo(Date value) {
            addCriterionForJDBCDate("storage_time =", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("storage_time <>", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("storage_time >", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("storage_time >=", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeLessThan(Date value) {
            addCriterionForJDBCDate("storage_time <", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("storage_time <=", value, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeIn(List<Date> values) {
            addCriterionForJDBCDate("storage_time in", values, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("storage_time not in", values, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("storage_time between", value1, value2, "storageTime");
            return (Criteria) this;
        }

        public Criteria andStorageTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("storage_time not between", value1, value2, "storageTime");
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
        
        public Criteria andCreateTimeLikeTo(String value) {
            addCriterion("a.create_time like ", value+"%", "createTime");
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