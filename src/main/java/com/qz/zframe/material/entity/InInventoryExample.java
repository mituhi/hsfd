package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class InInventoryExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InInventoryExample() {
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

        public Criteria andInInventoryIdIsNull() {
            addCriterion("in_inventory_id is null");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdIsNotNull() {
            addCriterion("in_inventory_id is not null");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdEqualTo(String value) {
            addCriterion("a.in_inventory_id =", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdNotEqualTo(String value) {
            addCriterion("in_inventory_id <>", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdGreaterThan(String value) {
            addCriterion("in_inventory_id >", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_inventory_id >=", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdLessThan(String value) {
            addCriterion("in_inventory_id <", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdLessThanOrEqualTo(String value) {
            addCriterion("in_inventory_id <=", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdLike(String value) {
            addCriterion("in_inventory_id like", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdNotLike(String value) {
            addCriterion("in_inventory_id not like", value, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdIn(List<String> values) {
            addCriterion("a.in_inventory_id in", values, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdNotIn(List<String> values) {
            addCriterion("in_inventory_id not in", values, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdBetween(String value1, String value2) {
            addCriterion("in_inventory_id between", value1, value2, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryIdNotBetween(String value1, String value2) {
            addCriterion("in_inventory_id not between", value1, value2, "inInventoryId");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderIsNull() {
            addCriterion("in_inventory_order is null");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderIsNotNull() {
            addCriterion("in_inventory_order is not null");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderEqualTo(String value) {
            addCriterion("a.in_inventory_order =", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderNotEqualTo(String value) {
            addCriterion("in_inventory_order <>", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderGreaterThan(String value) {
            addCriterion("in_inventory_order >", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderGreaterThanOrEqualTo(String value) {
            addCriterion("in_inventory_order >=", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderLessThan(String value) {
            addCriterion("in_inventory_order <", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderLessThanOrEqualTo(String value) {
            addCriterion("in_inventory_order <=", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderLike(String value) {
            addCriterion("a.in_inventory_order like", "%"+value+"%", "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderNotLike(String value) {
            addCriterion("in_inventory_order not like", value, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderIn(List<String> values) {
            addCriterion("in_inventory_order in", values, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderNotIn(List<String> values) {
            addCriterion("in_inventory_order not in", values, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderBetween(String value1, String value2) {
            addCriterion("in_inventory_order between", value1, value2, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andInInventoryOrderNotBetween(String value1, String value2) {
            addCriterion("in_inventory_order not between", value1, value2, "inInventoryOrder");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedIsNull() {
            addCriterion("goods_described is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedIsNotNull() {
            addCriterion("goods_described is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedEqualTo(String value) {
            addCriterion("a.goods_described =", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedNotEqualTo(String value) {
            addCriterion("goods_described <>", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedGreaterThan(String value) {
            addCriterion("goods_described >", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedGreaterThanOrEqualTo(String value) {
            addCriterion("goods_described >=", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedLessThan(String value) {
            addCriterion("goods_described <", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedLessThanOrEqualTo(String value) {
            addCriterion("goods_described <=", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedLike(String value) {
            addCriterion("a.goods_described like","%"+ value+"%", "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedNotLike(String value) {
            addCriterion("goods_described not like", value, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedIn(List<String> values) {
            addCriterion("goods_described in", values, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedNotIn(List<String> values) {
            addCriterion("goods_described not in", values, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedBetween(String value1, String value2) {
            addCriterion("goods_described between", value1, value2, "goodsDescribed");
            return (Criteria) this;
        }

        public Criteria andGoodsDescribedNotBetween(String value1, String value2) {
            addCriterion("goods_described not between", value1, value2, "goodsDescribed");
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
        
        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("a.supplier_id =", value, "stockAddId");
            return (Criteria) this;
        }
        
        public Criteria andSupplierNameLikeTo(String value) {
            addCriterion("d.supplier_name like","%"+ value+"%", "stockAddId");
            return (Criteria) this;
        }
        public Criteria andStockNameLikeTo(String value) {
            addCriterion("c.stock_add_name like","%"+ value+"%", "stockAddId");
            return (Criteria) this;
        }
        
        public Criteria andCreaterIdEqualTo(String value) {
        	addCriterion("case when a.creater="+value, " then  1=1 else a.in_inventory_order is not null end","creater");
            return (Criteria) this;
        }
        
        public Criteria andCreaterIdEqualTos(String value) {
            addCriterion("case when a.creater="+value+ " then  1=1 else a.in_inventory_order is not null end");
            return (Criteria) this;
        }
      

		protected void addCriterions(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
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

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeIsNull() {
            addCriterion("in_inventory_time is null");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeIsNotNull() {
            addCriterion("in_inventory_time is not null");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeEqualTo(Date value) {
            addCriterionForJDBCDate("a.in_inventory_time =", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_inventory_time <>", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_inventory_time >", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_inventory_time >=", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeLessThan(Date value) {
            addCriterionForJDBCDate("in_inventory_time <", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_inventory_time <=", value, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_inventory_time in", values, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_inventory_time not in", values, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_inventory_time between", value1, value2, "inInventoryTime");
            return (Criteria) this;
        }

        public Criteria andInInventoryTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_inventory_time not between", value1, value2, "inInventoryTime");
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

        public Criteria andarchitectureCodeEqualTo(String value) {
            addCriterion("b.architecture_code =", value, "windId");
            return (Criteria) this;
        }
        
        public Criteria andWindIdEqualTo(String value) {
            addCriterion("b.architecture_code =", value, "windId");
            return (Criteria) this;
        }
        
        public Criteria andArchitectureIdEqualTo(String value) {
            addCriterion("a.architecture_id =", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotEqualTo(Integer value) {
            addCriterion("wind_id <>", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThan(Integer value) {
            addCriterion("wind_id >", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wind_id >=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThan(Integer value) {
            addCriterion("wind_id <", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdLessThanOrEqualTo(Integer value) {
            addCriterion("wind_id <=", value, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdIn(List<Integer> values) {
            addCriterion("wind_id in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotIn(List<Integer> values) {
            addCriterion("wind_id not in", values, "windId");
            return (Criteria) this;
        }

        public Criteria andarchitectureCodeBetween(String  value1, String value2) {
            addCriterion("b.architecture_id between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andWindIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wind_id not between", value1, value2, "windId");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNull() {
            addCriterion("contract_number is null");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNotNull() {
            addCriterion("contract_number is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumberEqualTo(String value) {
            addCriterion("contract_number =", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotEqualTo(String value) {
            addCriterion("contract_number <>", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThan(String value) {
            addCriterion("contract_number >", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contract_number >=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThan(String value) {
            addCriterion("contract_number <", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThanOrEqualTo(String value) {
            addCriterion("contract_number <=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLike(String value) {
            addCriterion("contract_number like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotLike(String value) {
            addCriterion("contract_number not like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberIn(List<String> values) {
            addCriterion("contract_number in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotIn(List<String> values) {
            addCriterion("contract_number not in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberBetween(String value1, String value2) {
            addCriterion("contract_number between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotBetween(String value1, String value2) {
            addCriterion("contract_number not between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeIsNull() {
            addCriterion("in_inventory_type is null");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeIsNotNull() {
            addCriterion("in_inventory_type is not null");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeEqualTo(String value) {
            addCriterion("a.in_inventory_type =", value, "inInventoryType");
            return (Criteria) this;
        }
        
        
        
        

        public Criteria andInInventoryTypeNotEqualTo(String value) {
            addCriterion("in_inventory_type <>", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeGreaterThan(String value) {
            addCriterion("in_inventory_type >", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("in_inventory_type >=", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeLessThan(String value) {
            addCriterion("in_inventory_type <", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeLessThanOrEqualTo(String value) {
            addCriterion("in_inventory_type <=", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeLike(String value) {
            addCriterion("in_inventory_type like", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeNotLike(String value) {
            addCriterion("in_inventory_type not like", value, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeIn(List<String> values) {
            addCriterion("in_inventory_type in", values, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeNotIn(List<String> values) {
            addCriterion("in_inventory_type not in", values, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeBetween(String value1, String value2) {
            addCriterion("in_inventory_type between", value1, value2, "inInventoryType");
            return (Criteria) this;
        }

        public Criteria andInInventoryTypeNotBetween(String value1, String value2) {
            addCriterion("in_inventory_type not between", value1, value2, "inInventoryType");
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
            addCriterion("a.is_delete =", value, "isDelete");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("a.status =", value, "status");
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