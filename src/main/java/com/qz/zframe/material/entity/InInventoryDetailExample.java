package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InInventoryDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InInventoryDetailExample() {
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

        public Criteria andInInventoryDetailIdIsNull() {
            addCriterion("in_inventory_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdIsNotNull() {
            addCriterion("in_inventory_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdEqualTo(String value) {
            addCriterion("in_inventory_detail_id =", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdNotEqualTo(String value) {
            addCriterion("in_inventory_detail_id <>", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdGreaterThan(String value) {
            addCriterion("in_inventory_detail_id >", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_inventory_detail_id >=", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdLessThan(String value) {
            addCriterion("in_inventory_detail_id <", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdLessThanOrEqualTo(String value) {
            addCriterion("in_inventory_detail_id <=", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdLike(String value) {
            addCriterion("in_inventory_detail_id like", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdNotLike(String value) {
            addCriterion("in_inventory_detail_id not like", value, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdIn(List<String> values) {
            addCriterion("in_inventory_detail_id in", values, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdNotIn(List<String> values) {
            addCriterion("in_inventory_detail_id not in", values, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdBetween(String value1, String value2) {
            addCriterion("in_inventory_detail_id between", value1, value2, "inInventoryDetailId");
            return (Criteria) this;
        }

        public Criteria andInInventoryDetailIdNotBetween(String value1, String value2) {
            addCriterion("in_inventory_detail_id not between", value1, value2, "inInventoryDetailId");
            return (Criteria) this;
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
            addCriterion("in_inventory_id in", values, "inInventoryId");
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

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goods_num in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andTaxPriceIsNull() {
            addCriterion("tax_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxPriceIsNotNull() {
            addCriterion("tax_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPriceEqualTo(BigDecimal value) {
            addCriterion("tax_price =", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_price <>", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_price >", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_price >=", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceLessThan(BigDecimal value) {
            addCriterion("tax_price <", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_price <=", value, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceIn(List<BigDecimal> values) {
            addCriterion("tax_price in", values, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_price not in", values, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_price between", value1, value2, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_price not between", value1, value2, "taxPrice");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIsNull() {
            addCriterion("tax_amount is null");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIsNotNull() {
            addCriterion("tax_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAmountEqualTo(BigDecimal value) {
            addCriterion("tax_amount =", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("tax_amount <>", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountGreaterThan(BigDecimal value) {
            addCriterion("tax_amount >", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amount >=", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountLessThan(BigDecimal value) {
            addCriterion("tax_amount <", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amount <=", value, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountIn(List<BigDecimal> values) {
            addCriterion("tax_amount in", values, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("tax_amount not in", values, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amount between", value1, value2, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amount not between", value1, value2, "taxAmount");
            return (Criteria) this;
        }

        public Criteria andTaxBillIsNull() {
            addCriterion("tax_bill is null");
            return (Criteria) this;
        }

        public Criteria andTaxBillIsNotNull() {
            addCriterion("tax_bill is not null");
            return (Criteria) this;
        }

        public Criteria andTaxBillEqualTo(String value) {
            addCriterion("tax_bill =", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillNotEqualTo(String value) {
            addCriterion("tax_bill <>", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillGreaterThan(String value) {
            addCriterion("tax_bill >", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillGreaterThanOrEqualTo(String value) {
            addCriterion("tax_bill >=", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillLessThan(String value) {
            addCriterion("tax_bill <", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillLessThanOrEqualTo(String value) {
            addCriterion("tax_bill <=", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillLike(String value) {
            addCriterion("tax_bill like", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillNotLike(String value) {
            addCriterion("tax_bill not like", value, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillIn(List<String> values) {
            addCriterion("tax_bill in", values, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillNotIn(List<String> values) {
            addCriterion("tax_bill not in", values, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillBetween(String value1, String value2) {
            addCriterion("tax_bill between", value1, value2, "taxBill");
            return (Criteria) this;
        }

        public Criteria andTaxBillNotBetween(String value1, String value2) {
            addCriterion("tax_bill not between", value1, value2, "taxBill");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceIsNull() {
            addCriterion("un_tax_price is null");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceIsNotNull() {
            addCriterion("un_tax_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceEqualTo(BigDecimal value) {
            addCriterion("un_tax_price =", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("un_tax_price <>", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceGreaterThan(BigDecimal value) {
            addCriterion("un_tax_price >", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("un_tax_price >=", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceLessThan(BigDecimal value) {
            addCriterion("un_tax_price <", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("un_tax_price <=", value, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceIn(List<BigDecimal> values) {
            addCriterion("un_tax_price in", values, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("un_tax_price not in", values, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("un_tax_price between", value1, value2, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andUnTaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("un_tax_price not between", value1, value2, "unTaxPrice");
            return (Criteria) this;
        }

        public Criteria andCheckResultsIsNull() {
            addCriterion("check_results is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultsIsNotNull() {
            addCriterion("check_results is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultsEqualTo(String value) {
            addCriterion("check_results =", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsNotEqualTo(String value) {
            addCriterion("check_results <>", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsGreaterThan(String value) {
            addCriterion("check_results >", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsGreaterThanOrEqualTo(String value) {
            addCriterion("check_results >=", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsLessThan(String value) {
            addCriterion("check_results <", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsLessThanOrEqualTo(String value) {
            addCriterion("check_results <=", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsLike(String value) {
            addCriterion("check_results like", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsNotLike(String value) {
            addCriterion("check_results not like", value, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsIn(List<String> values) {
            addCriterion("check_results in", values, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsNotIn(List<String> values) {
            addCriterion("check_results not in", values, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsBetween(String value1, String value2) {
            addCriterion("check_results between", value1, value2, "checkResults");
            return (Criteria) this;
        }

        public Criteria andCheckResultsNotBetween(String value1, String value2) {
            addCriterion("check_results not between", value1, value2, "checkResults");
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

        public Criteria andManufactureDayIsNull() {
            addCriterion("manufacture_day is null");
            return (Criteria) this;
        }

        public Criteria andManufactureDayIsNotNull() {
            addCriterion("manufacture_day is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureDayEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_day =", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_day <>", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayGreaterThan(Date value) {
            addCriterionForJDBCDate("manufacture_day >", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_day >=", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayLessThan(Date value) {
            addCriterionForJDBCDate("manufacture_day <", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("manufacture_day <=", value, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayIn(List<Date> values) {
            addCriterionForJDBCDate("manufacture_day in", values, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("manufacture_day not in", values, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("manufacture_day between", value1, value2, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andManufactureDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("manufacture_day not between", value1, value2, "manufactureDay");
            return (Criteria) this;
        }

        public Criteria andNetPriceIsNull() {
            addCriterion("net_price is null");
            return (Criteria) this;
        }

        public Criteria andNetPriceIsNotNull() {
            addCriterion("net_price is not null");
            return (Criteria) this;
        }

        public Criteria andNetPriceEqualTo(BigDecimal value) {
            addCriterion("net_price =", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceNotEqualTo(BigDecimal value) {
            addCriterion("net_price <>", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceGreaterThan(BigDecimal value) {
            addCriterion("net_price >", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_price >=", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceLessThan(BigDecimal value) {
            addCriterion("net_price <", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_price <=", value, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceIn(List<BigDecimal> values) {
            addCriterion("net_price in", values, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceNotIn(List<BigDecimal> values) {
            addCriterion("net_price not in", values, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_price between", value1, value2, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_price not between", value1, value2, "netPrice");
            return (Criteria) this;
        }

        public Criteria andNetWorthIsNull() {
            addCriterion("net_worth is null");
            return (Criteria) this;
        }

        public Criteria andNetWorthIsNotNull() {
            addCriterion("net_worth is not null");
            return (Criteria) this;
        }

        public Criteria andNetWorthEqualTo(BigDecimal value) {
            addCriterion("net_worth =", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotEqualTo(BigDecimal value) {
            addCriterion("net_worth <>", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthGreaterThan(BigDecimal value) {
            addCriterion("net_worth >", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_worth >=", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthLessThan(BigDecimal value) {
            addCriterion("net_worth <", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_worth <=", value, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthIn(List<BigDecimal> values) {
            addCriterion("net_worth in", values, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotIn(List<BigDecimal> values) {
            addCriterion("net_worth not in", values, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_worth between", value1, value2, "netWorth");
            return (Criteria) this;
        }

        public Criteria andNetWorthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_worth not between", value1, value2, "netWorth");
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