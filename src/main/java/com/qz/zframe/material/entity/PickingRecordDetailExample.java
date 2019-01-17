package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class PickingRecordDetailExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PickingRecordDetailExample() {
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

        public Criteria andPickingDetailIdIsNull() {
            addCriterion("picking_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdIsNotNull() {
            addCriterion("picking_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdEqualTo(String value) {
            addCriterion("picking_detail_id =", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdNotEqualTo(String value) {
            addCriterion("picking_detail_id <>", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdGreaterThan(String value) {
            addCriterion("picking_detail_id >", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("picking_detail_id >=", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdLessThan(String value) {
            addCriterion("picking_detail_id <", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdLessThanOrEqualTo(String value) {
            addCriterion("picking_detail_id <=", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdLike(String value) {
            addCriterion("picking_detail_id like", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdNotLike(String value) {
            addCriterion("picking_detail_id not like", value, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdIn(List<String> values) {
            addCriterion("picking_detail_id in", values, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdNotIn(List<String> values) {
            addCriterion("picking_detail_id not in", values, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdBetween(String value1, String value2) {
            addCriterion("picking_detail_id between", value1, value2, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingDetailIdNotBetween(String value1, String value2) {
            addCriterion("picking_detail_id not between", value1, value2, "pickingDetailId");
            return (Criteria) this;
        }

        public Criteria andPickingIdIsNull() {
            addCriterion("picking_id is null");
            return (Criteria) this;
        }

        public Criteria andPickingIdIsNotNull() {
            addCriterion("picking_id is not null");
            return (Criteria) this;
        }

        public Criteria andPickingIdEqualTo(String value) {
            addCriterion("a.picking_id =", value, "pickingId");
            return (Criteria) this;
        }
        
        public Criteria andPickingIdOrderTo(String value) {
            addCriterion("b.picking_order =", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingIdNotEqualTo(String value) {
            addCriterion("picking_id <>", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdGreaterThan(String value) {
            addCriterion("picking_id >", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdGreaterThanOrEqualTo(String value) {
            addCriterion("picking_id >=", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdLessThan(String value) {
            addCriterion("picking_id <", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdLessThanOrEqualTo(String value) {
            addCriterion("picking_id <=", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdLike(String value) {
            addCriterion("picking_id like", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdNotLike(String value) {
            addCriterion("picking_id not like", value, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdIn(List<String> values) {
            addCriterion("picking_id in", values, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdNotIn(List<String> values) {
            addCriterion("picking_id not in", values, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdBetween(String value1, String value2) {
            addCriterion("picking_id between", value1, value2, "pickingId");
            return (Criteria) this;
        }

        public Criteria andPickingIdNotBetween(String value1, String value2) {
            addCriterion("picking_id not between", value1, value2, "pickingId");
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

        public Criteria andReturnPickingDetailIdIsNull() {
            addCriterion("return_picking_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdIsNotNull() {
            addCriterion("return_picking_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdEqualTo(String value) {
            addCriterion("return_picking_detail_id =", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdNotEqualTo(String value) {
            addCriterion("return_picking_detail_id <>", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdGreaterThan(String value) {
            addCriterion("return_picking_detail_id >", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("return_picking_detail_id >=", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdLessThan(String value) {
            addCriterion("return_picking_detail_id <", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdLessThanOrEqualTo(String value) {
            addCriterion("return_picking_detail_id <=", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdLike(String value) {
            addCriterion("return_picking_detail_id like", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdNotLike(String value) {
            addCriterion("return_picking_detail_id not like", value, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdIn(List<String> values) {
            addCriterion("return_picking_detail_id in", values, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdNotIn(List<String> values) {
            addCriterion("return_picking_detail_id not in", values, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdBetween(String value1, String value2) {
            addCriterion("return_picking_detail_id between", value1, value2, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andReturnPickingDetailIdNotBetween(String value1, String value2) {
            addCriterion("return_picking_detail_id not between", value1, value2, "returnPickingDetailId");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumIsNull() {
            addCriterion("recipients_num is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumIsNotNull() {
            addCriterion("recipients_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumEqualTo(Integer value) {
            addCriterion("recipients_num =", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumNotEqualTo(Integer value) {
            addCriterion("recipients_num <>", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumGreaterThan(Integer value) {
            addCriterion("recipients_num >", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("recipients_num >=", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumLessThan(Integer value) {
            addCriterion("recipients_num <", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumLessThanOrEqualTo(Integer value) {
            addCriterion("recipients_num <=", value, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumIn(List<Integer> values) {
            addCriterion("recipients_num in", values, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumNotIn(List<Integer> values) {
            addCriterion("recipients_num not in", values, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumBetween(Integer value1, Integer value2) {
            addCriterion("recipients_num between", value1, value2, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andRecipientsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("recipients_num not between", value1, value2, "recipientsNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumIsNull() {
            addCriterion("return_num is null");
            return (Criteria) this;
        }

        public Criteria andReturnNumIsNotNull() {
            addCriterion("return_num is not null");
            return (Criteria) this;
        }

        public Criteria andReturnNumEqualTo(Integer value) {
            addCriterion("return_num =", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotEqualTo(Integer value) {
            addCriterion("return_num <>", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumGreaterThan(Integer value) {
            addCriterion("return_num >", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_num >=", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumLessThan(Integer value) {
            addCriterion("return_num <", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumLessThanOrEqualTo(Integer value) {
            addCriterion("return_num <=", value, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumIn(List<Integer> values) {
            addCriterion("return_num in", values, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotIn(List<Integer> values) {
            addCriterion("return_num not in", values, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumBetween(Integer value1, Integer value2) {
            addCriterion("return_num between", value1, value2, "returnNum");
            return (Criteria) this;
        }

        public Criteria andReturnNumNotBetween(Integer value1, Integer value2) {
            addCriterion("return_num not between", value1, value2, "returnNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumIsNull() {
            addCriterion("refundable_num is null");
            return (Criteria) this;
        }

        public Criteria andRefundableNumIsNotNull() {
            addCriterion("refundable_num is not null");
            return (Criteria) this;
        }

        public Criteria andRefundableNumEqualTo(Integer value) {
            addCriterion("refundable_num =", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumNotEqualTo(Integer value) {
            addCriterion("refundable_num <>", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumGreaterThan(Integer value) {
            addCriterion("refundable_num >", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("refundable_num >=", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumLessThan(Integer value) {
            addCriterion("refundable_num <", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumLessThanOrEqualTo(Integer value) {
            addCriterion("refundable_num <=", value, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumIn(List<Integer> values) {
            addCriterion("refundable_num in", values, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumNotIn(List<Integer> values) {
            addCriterion("refundable_num not in", values, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumBetween(Integer value1, Integer value2) {
            addCriterion("refundable_num between", value1, value2, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andRefundableNumNotBetween(Integer value1, Integer value2) {
            addCriterion("refundable_num not between", value1, value2, "refundableNum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
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
            addCriterion("in_inventory_id =", value, "inInventoryId");
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

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
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