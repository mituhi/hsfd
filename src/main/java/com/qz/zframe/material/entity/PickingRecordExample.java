package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class PickingRecordExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PickingRecordExample() {
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
            addCriterion("a.picking_id in", values, "pickingId");
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

        public Criteria andPickingOrderIsNull() {
            addCriterion("picking_order is null");
            return (Criteria) this;
        }

        public Criteria andPickingOrderIsNotNull() {
            addCriterion("picking_order is not null");
            return (Criteria) this;
        }

        public Criteria andPickingOrderEqualTo(String value) {
            addCriterion("a.picking_order =", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderNotEqualTo(String value) {
            addCriterion("picking_order <>", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderGreaterThan(String value) {
            addCriterion("picking_order >", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderGreaterThanOrEqualTo(String value) {
            addCriterion("picking_order >=", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderLessThan(String value) {
            addCriterion("picking_order <", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderLessThanOrEqualTo(String value) {
            addCriterion("picking_order <=", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderLike(String value) {
            addCriterion("a.picking_order like","%"+ value+"%", "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderNotLike(String value) {
            addCriterion("picking_order not like", value, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderIn(List<String> values) {
            addCriterion("picking_order in", values, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderNotIn(List<String> values) {
            addCriterion("picking_order not in", values, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderBetween(String value1, String value2) {
            addCriterion("picking_order between", value1, value2, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingOrderNotBetween(String value1, String value2) {
            addCriterion("picking_order not between", value1, value2, "pickingOrder");
            return (Criteria) this;
        }

        public Criteria andPickingTypeIsNull() {
            addCriterion("picking_type is null");
            return (Criteria) this;
        }

        public Criteria andPickingTypeIsNotNull() {
            addCriterion("picking_type is not null");
            return (Criteria) this;
        }

        public Criteria andPickingTypeEqualTo(String value) {
            addCriterion("a.picking_type =", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeNotEqualTo(String value) {
            addCriterion("picking_type <>", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeGreaterThan(String value) {
            addCriterion("picking_type >", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("picking_type >=", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeLessThan(String value) {
            addCriterion("picking_type <", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeLessThanOrEqualTo(String value) {
            addCriterion("picking_type <=", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeLike(String value) {
            addCriterion("picking_type like", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeNotLike(String value) {
            addCriterion("picking_type not like", value, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeIn(List<String> values) {
            addCriterion("picking_type in", values, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeNotIn(List<String> values) {
            addCriterion("picking_type not in", values, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeBetween(String value1, String value2) {
            addCriterion("picking_type between", value1, value2, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPickingTypeNotBetween(String value1, String value2) {
            addCriterion("picking_type not between", value1, value2, "pickingType");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeIsNull() {
            addCriterion("prcking_describe is null");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeIsNotNull() {
            addCriterion("prcking_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeEqualTo(String value) {
            addCriterion("prcking_describe =", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeNotEqualTo(String value) {
            addCriterion("prcking_describe <>", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeGreaterThan(String value) {
            addCriterion("prcking_describe >", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("prcking_describe >=", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeLessThan(String value) {
            addCriterion("prcking_describe <", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeLessThanOrEqualTo(String value) {
            addCriterion("prcking_describe <=", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeLike(String value) {
            addCriterion("prcking_describe like", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeNotLike(String value) {
            addCriterion("prcking_describe not like", value, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeIn(List<String> values) {
            addCriterion("prcking_describe in", values, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeNotIn(List<String> values) {
            addCriterion("prcking_describe not in", values, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeBetween(String value1, String value2) {
            addCriterion("prcking_describe between", value1, value2, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andPrckingDescribeNotBetween(String value1, String value2) {
            addCriterion("prcking_describe not between", value1, value2, "prckingDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIsNull() {
            addCriterion("work_order is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIsNotNull() {
            addCriterion("work_order is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderEqualTo(String value) {
            addCriterion("a.work_order =", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNotEqualTo(String value) {
            addCriterion("work_order <>", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderGreaterThan(String value) {
            addCriterion("work_order >", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderGreaterThanOrEqualTo(String value) {
            addCriterion("work_order >=", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderLessThan(String value) {
            addCriterion("work_order <", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderLessThanOrEqualTo(String value) {
            addCriterion("work_order <=", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderLike(String value) {
            addCriterion("a.work_order like","%"+ value+"%", "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNotLike(String value) {
            addCriterion("work_order not like", value, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIn(List<String> values) {
            addCriterion("work_order in", values, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNotIn(List<String> values) {
            addCriterion("work_order not in", values, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderBetween(String value1, String value2) {
            addCriterion("work_order between", value1, value2, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNotBetween(String value1, String value2) {
            addCriterion("work_order not between", value1, value2, "workOrder");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeIsNull() {
            addCriterion("work_order_describe is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeIsNotNull() {
            addCriterion("work_order_describe is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeEqualTo(String value) {
            addCriterion("work_order_describe =", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeNotEqualTo(String value) {
            addCriterion("work_order_describe <>", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeGreaterThan(String value) {
            addCriterion("work_order_describe >", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_describe >=", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeLessThan(String value) {
            addCriterion("work_order_describe <", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeLessThanOrEqualTo(String value) {
            addCriterion("work_order_describe <=", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeLike(String value) {
            addCriterion("work_order_describe like", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeNotLike(String value) {
            addCriterion("work_order_describe not like", value, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeIn(List<String> values) {
            addCriterion("work_order_describe in", values, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeNotIn(List<String> values) {
            addCriterion("work_order_describe not in", values, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeBetween(String value1, String value2) {
            addCriterion("work_order_describe between", value1, value2, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andWorkOrderDescribeNotBetween(String value1, String value2) {
            addCriterion("work_order_describe not between", value1, value2, "workOrderDescribe");
            return (Criteria) this;
        }

        public Criteria andPickerIsNull() {
            addCriterion("picker is null");
            return (Criteria) this;
        }

        public Criteria andPickerIsNotNull() {
            addCriterion("picker is not null");
            return (Criteria) this;
        }

        public Criteria andPickerEqualTo(String value) {
            addCriterion("picker =", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotEqualTo(String value) {
            addCriterion("picker <>", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThan(String value) {
            addCriterion("picker >", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThanOrEqualTo(String value) {
            addCriterion("picker >=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThan(String value) {
            addCriterion("picker <", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThanOrEqualTo(String value) {
            addCriterion("picker <=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLike(String value) {
            addCriterion("picker like", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotLike(String value) {
            addCriterion("picker not like", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerIn(List<String> values) {
            addCriterion("picker in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotIn(List<String> values) {
            addCriterion("picker not in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerBetween(String value1, String value2) {
            addCriterion("picker between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotBetween(String value1, String value2) {
            addCriterion("picker not between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdIsNull() {
            addCriterion("architecture_id is null");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdIsNotNull() {
            addCriterion("architecture_id is not null");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdEqualTo(String value) {
            addCriterion("architecture_id =", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotEqualTo(String value) {
            addCriterion("architecture_id <>", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdGreaterThan(String value) {
            addCriterion("architecture_id >", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdGreaterThanOrEqualTo(String value) {
            addCriterion("architecture_id >=", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLessThan(String value) {
            addCriterion("architecture_id <", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLessThanOrEqualTo(String value) {
            addCriterion("architecture_id <=", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdLike(String value) {
            addCriterion("architecture_id like", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotLike(String value) {
            addCriterion("architecture_id not like", value, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdIn(List<String> values) {
            addCriterion("architecture_id in", values, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureIdNotIn(List<String> values) {
            addCriterion("architecture_id not in", values, "architectureId");
            return (Criteria) this;
        }

        public Criteria andArchitectureCodeBetween(String value1, String value2) {
            addCriterion("b.architecture_code between", value1, value2, "architectureId");
            return (Criteria) this;
        }
        
        public Criteria andArchitectureCodeEqualTo(String value) {
            addCriterion("b.architecture_code =", value, "architectureCode");
            return (Criteria) this;
        }
        
        
        public Criteria andCreateNameLikeTo(String value) {
            addCriterion("user_name like ","%"+value+"%", "architectureCode");
            return (Criteria) this;
        }

        
        public Criteria andProposerLikeTo(String value) {
            addCriterion("a.proposer like ","%"+value+"%", "architectureCode");
            return (Criteria) this;
        }
        
        public Criteria andArchitectureIdNotBetween(String value1, String value2) {
            addCriterion("architecture_id not between", value1, value2, "architectureCode");
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
            addCriterion("stock_add_id =", value, "stockAddId");
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

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("a.approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }
        
        public Criteria andArchitectureType(String value) {
            addCriterion("b.architecture_type =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNull() {
            addCriterion("approval_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNotNull() {
            addCriterion("approval_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionEqualTo(String value) {
            addCriterion("approval_opinion =", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotEqualTo(String value) {
            addCriterion("approval_opinion <>", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThan(String value) {
            addCriterion("approval_opinion >", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("approval_opinion >=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThan(String value) {
            addCriterion("approval_opinion <", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThanOrEqualTo(String value) {
            addCriterion("approval_opinion <=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLike(String value) {
            addCriterion("approval_opinion like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotLike(String value) {
            addCriterion("approval_opinion not like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIn(List<String> values) {
            addCriterion("approval_opinion in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotIn(List<String> values) {
            addCriterion("approval_opinion not in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionBetween(String value1, String value2) {
            addCriterion("approval_opinion between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotBetween(String value1, String value2) {
            addCriterion("approval_opinion not between", value1, value2, "approvalOpinion");
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
        
        
        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("a.application_time =", value, "createTime");
            return (Criteria) this;
        }
        
        public Criteria andCreateTimeLikeTo(Date value) {
            addCriterion("a.create_time like", value+"%", "createTime");
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
            addCriterion("a.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }
        
        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("a.application_time between", value1, value2, "createTime");
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }
        
        public Criteria andIsDelete(String value) {
            addCriterion("g.is_delete =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("file_id like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("file_id not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
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
        	 addCriterion("case when a.creater="+value+ " then  1=1 else a.picking_order is not null end");
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