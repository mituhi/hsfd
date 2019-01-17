package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GuestOfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuestOfferExample() {
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

        public Criteria andGuestIdIsNull() {
            addCriterion("guest_id is null");
            return (Criteria) this;
        }

        public Criteria andGuestIdIsNotNull() {
            addCriterion("guest_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuestIdEqualTo(String value) {
            addCriterion("guest_id =", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotEqualTo(String value) {
            addCriterion("guest_id <>", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThan(String value) {
            addCriterion("guest_id >", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdGreaterThanOrEqualTo(String value) {
            addCriterion("guest_id >=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThan(String value) {
            addCriterion("guest_id <", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLessThanOrEqualTo(String value) {
            addCriterion("guest_id <=", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdLike(String value) {
            addCriterion("guest_id like", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotLike(String value) {
            addCriterion("guest_id not like", value, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdIn(List<String> values) {
            addCriterion("guest_id in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotIn(List<String> values) {
            addCriterion("guest_id not in", values, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdBetween(String value1, String value2) {
            addCriterion("guest_id between", value1, value2, "guestId");
            return (Criteria) this;
        }

        public Criteria andGuestIdNotBetween(String value1, String value2) {
            addCriterion("guest_id not between", value1, value2, "guestId");
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

        public Criteria andGuestNameIsNull() {
            addCriterion("guest_name is null");
            return (Criteria) this;
        }

        public Criteria andGuestNameIsNotNull() {
            addCriterion("guest_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuestNameEqualTo(String value) {
            addCriterion("guest_name =", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotEqualTo(String value) {
            addCriterion("guest_name <>", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameGreaterThan(String value) {
            addCriterion("guest_name >", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameGreaterThanOrEqualTo(String value) {
            addCriterion("guest_name >=", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLessThan(String value) {
            addCriterion("guest_name <", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLessThanOrEqualTo(String value) {
            addCriterion("guest_name <=", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLike(String value) {
            addCriterion("guest_name like", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotLike(String value) {
            addCriterion("guest_name not like", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameIn(List<String> values) {
            addCriterion("guest_name in", values, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotIn(List<String> values) {
            addCriterion("guest_name not in", values, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameBetween(String value1, String value2) {
            addCriterion("guest_name between", value1, value2, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotBetween(String value1, String value2) {
            addCriterion("guest_name not between", value1, value2, "guestName");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIsNull() {
            addCriterion("fixed_telephone is null");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIsNotNull() {
            addCriterion("fixed_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneEqualTo(String value) {
            addCriterion("fixed_telephone =", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotEqualTo(String value) {
            addCriterion("fixed_telephone <>", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneGreaterThan(String value) {
            addCriterion("fixed_telephone >", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_telephone >=", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLessThan(String value) {
            addCriterion("fixed_telephone <", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLessThanOrEqualTo(String value) {
            addCriterion("fixed_telephone <=", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLike(String value) {
            addCriterion("fixed_telephone like", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotLike(String value) {
            addCriterion("fixed_telephone not like", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIn(List<String> values) {
            addCriterion("fixed_telephone in", values, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotIn(List<String> values) {
            addCriterion("fixed_telephone not in", values, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneBetween(String value1, String value2) {
            addCriterion("fixed_telephone between", value1, value2, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotBetween(String value1, String value2) {
            addCriterion("fixed_telephone not between", value1, value2, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andOfferAmountIsNull() {
            addCriterion("offer_amount is null");
            return (Criteria) this;
        }

        public Criteria andOfferAmountIsNotNull() {
            addCriterion("offer_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOfferAmountEqualTo(BigDecimal value) {
            addCriterion("offer_amount =", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountNotEqualTo(BigDecimal value) {
            addCriterion("offer_amount <>", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountGreaterThan(BigDecimal value) {
            addCriterion("offer_amount >", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_amount >=", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountLessThan(BigDecimal value) {
            addCriterion("offer_amount <", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_amount <=", value, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountIn(List<BigDecimal> values) {
            addCriterion("offer_amount in", values, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountNotIn(List<BigDecimal> values) {
            addCriterion("offer_amount not in", values, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_amount between", value1, value2, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andOfferAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_amount not between", value1, value2, "offerAmount");
            return (Criteria) this;
        }

        public Criteria andAdviceWinIsNull() {
            addCriterion("advice_win is null");
            return (Criteria) this;
        }

        public Criteria andAdviceWinIsNotNull() {
            addCriterion("advice_win is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceWinEqualTo(String value) {
            addCriterion("advice_win =", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinNotEqualTo(String value) {
            addCriterion("advice_win <>", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinGreaterThan(String value) {
            addCriterion("advice_win >", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinGreaterThanOrEqualTo(String value) {
            addCriterion("advice_win >=", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinLessThan(String value) {
            addCriterion("advice_win <", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinLessThanOrEqualTo(String value) {
            addCriterion("advice_win <=", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinLike(String value) {
            addCriterion("advice_win like", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinNotLike(String value) {
            addCriterion("advice_win not like", value, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinIn(List<String> values) {
            addCriterion("advice_win in", values, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinNotIn(List<String> values) {
            addCriterion("advice_win not in", values, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinBetween(String value1, String value2) {
            addCriterion("advice_win between", value1, value2, "adviceWin");
            return (Criteria) this;
        }

        public Criteria andAdviceWinNotBetween(String value1, String value2) {
            addCriterion("advice_win not between", value1, value2, "adviceWin");
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