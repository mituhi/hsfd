package com.qz.zframe.material.entity;

import java.util.ArrayList;
import java.util.List;

public class ScrapDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScrapDetailExample() {
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

        public Criteria andScrapDetailIdIsNull() {
            addCriterion("scrap_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdIsNotNull() {
            addCriterion("scrap_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdEqualTo(String value) {
            addCriterion("scrap_detail_id =", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdNotEqualTo(String value) {
            addCriterion("scrap_detail_id <>", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdGreaterThan(String value) {
            addCriterion("scrap_detail_id >", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_detail_id >=", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdLessThan(String value) {
            addCriterion("scrap_detail_id <", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdLessThanOrEqualTo(String value) {
            addCriterion("scrap_detail_id <=", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdLike(String value) {
            addCriterion("scrap_detail_id like", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdNotLike(String value) {
            addCriterion("scrap_detail_id not like", value, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdIn(List<String> values) {
            addCriterion("scrap_detail_id in", values, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdNotIn(List<String> values) {
            addCriterion("scrap_detail_id not in", values, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdBetween(String value1, String value2) {
            addCriterion("scrap_detail_id between", value1, value2, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapDetailIdNotBetween(String value1, String value2) {
            addCriterion("scrap_detail_id not between", value1, value2, "scrapDetailId");
            return (Criteria) this;
        }

        public Criteria andScrapIdIsNull() {
            addCriterion("scrap_id is null");
            return (Criteria) this;
        }

        public Criteria andScrapIdIsNotNull() {
            addCriterion("scrap_id is not null");
            return (Criteria) this;
        }

        public Criteria andScrapIdEqualTo(String value) {
            addCriterion("scrap_id =", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotEqualTo(String value) {
            addCriterion("scrap_id <>", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdGreaterThan(String value) {
            addCriterion("scrap_id >", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_id >=", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLessThan(String value) {
            addCriterion("scrap_id <", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLessThanOrEqualTo(String value) {
            addCriterion("scrap_id <=", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdLike(String value) {
            addCriterion("scrap_id like", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotLike(String value) {
            addCriterion("scrap_id not like", value, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdIn(List<String> values) {
            addCriterion("scrap_id in", values, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotIn(List<String> values) {
            addCriterion("scrap_id not in", values, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdBetween(String value1, String value2) {
            addCriterion("scrap_id between", value1, value2, "scrapId");
            return (Criteria) this;
        }

        public Criteria andScrapIdNotBetween(String value1, String value2) {
            addCriterion("scrap_id not between", value1, value2, "scrapId");
            return (Criteria) this;
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

        public Criteria andScrapNumIsNull() {
            addCriterion("scrap_num is null");
            return (Criteria) this;
        }

        public Criteria andScrapNumIsNotNull() {
            addCriterion("scrap_num is not null");
            return (Criteria) this;
        }

        public Criteria andScrapNumEqualTo(Integer value) {
            addCriterion("scrap_num =", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumNotEqualTo(Integer value) {
            addCriterion("scrap_num <>", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumGreaterThan(Integer value) {
            addCriterion("scrap_num >", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("scrap_num >=", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumLessThan(Integer value) {
            addCriterion("scrap_num <", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumLessThanOrEqualTo(Integer value) {
            addCriterion("scrap_num <=", value, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumIn(List<Integer> values) {
            addCriterion("scrap_num in", values, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumNotIn(List<Integer> values) {
            addCriterion("scrap_num not in", values, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumBetween(Integer value1, Integer value2) {
            addCriterion("scrap_num between", value1, value2, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapNumNotBetween(Integer value1, Integer value2) {
            addCriterion("scrap_num not between", value1, value2, "scrapNum");
            return (Criteria) this;
        }

        public Criteria andScrapReasonIsNull() {
            addCriterion("scrap_reason is null");
            return (Criteria) this;
        }

        public Criteria andScrapReasonIsNotNull() {
            addCriterion("scrap_reason is not null");
            return (Criteria) this;
        }

        public Criteria andScrapReasonEqualTo(String value) {
            addCriterion("scrap_reason =", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonNotEqualTo(String value) {
            addCriterion("scrap_reason <>", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonGreaterThan(String value) {
            addCriterion("scrap_reason >", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonGreaterThanOrEqualTo(String value) {
            addCriterion("scrap_reason >=", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonLessThan(String value) {
            addCriterion("scrap_reason <", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonLessThanOrEqualTo(String value) {
            addCriterion("scrap_reason <=", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonLike(String value) {
            addCriterion("scrap_reason like", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonNotLike(String value) {
            addCriterion("scrap_reason not like", value, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonIn(List<String> values) {
            addCriterion("scrap_reason in", values, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonNotIn(List<String> values) {
            addCriterion("scrap_reason not in", values, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonBetween(String value1, String value2) {
            addCriterion("scrap_reason between", value1, value2, "scrapReason");
            return (Criteria) this;
        }

        public Criteria andScrapReasonNotBetween(String value1, String value2) {
            addCriterion("scrap_reason not between", value1, value2, "scrapReason");
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