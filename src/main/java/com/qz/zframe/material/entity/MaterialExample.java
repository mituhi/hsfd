package com.qz.zframe.material.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qz.zframe.common.util.PageExample;

public class MaterialExample extends PageExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialExample() {
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

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("a.material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("a.material_code like","%"+ value+"%", "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }
        
        public Criteria andArchitectuerBetween(String value1, String value2) {
            addCriterion("e.architecture_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }
        
        public Criteria andArchitectuerEqualTo(String value) {
            addCriterion("e.architecture_code =", value ,"materialCode");
            return (Criteria) this;
        }
        

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("a.material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("a.material_name like","%"+ value+"%", "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("a.specifications like", "%"+value+"%", "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIsNull() {
            addCriterion("material_describe is null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIsNotNull() {
            addCriterion("material_describe is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeEqualTo(String value) {
            addCriterion("a.material_describe =", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotEqualTo(String value) {
            addCriterion("material_describe <>", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeGreaterThan(String value) {
            addCriterion("material_describe >", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("material_describe >=", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLessThan(String value) {
            addCriterion("material_describe <", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLessThanOrEqualTo(String value) {
            addCriterion("material_describe <=", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeLike(String value) {
            addCriterion("a.material_describe like", "%"+value+"%", "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotLike(String value) {
            addCriterion("material_describe not like", value, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeIn(List<String> values) {
            addCriterion("material_describe in", values, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotIn(List<String> values) {
            addCriterion("material_describe not in", values, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeBetween(String value1, String value2) {
            addCriterion("material_describe between", value1, value2, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialDescribeNotBetween(String value1, String value2) {
            addCriterion("material_describe not between", value1, value2, "materialDescribe");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIsNull() {
            addCriterion("material_group_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIsNotNull() {
            addCriterion("material_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdEqualTo(String value) {
            addCriterion("material_group_id =", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotEqualTo(String value) {
            addCriterion("material_group_id <>", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdGreaterThan(String value) {
            addCriterion("material_group_id >", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_group_id >=", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLessThan(String value) {
            addCriterion("material_group_id <", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLessThanOrEqualTo(String value) {
            addCriterion("material_group_id <=", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdLike(String value) {
            addCriterion("material_group_id like", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotLike(String value) {
            addCriterion("material_group_id not like", value, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdIn(List<String> values) {
            addCriterion("a.material_group_id in", values, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotIn(List<String> values) {
            addCriterion("material_group_id not in", values, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdBetween(String value1, String value2) {
            addCriterion("material_group_id between", value1, value2, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialGroupIdNotBetween(String value1, String value2) {
            addCriterion("material_group_id not between", value1, value2, "materialGroupId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdIsNull() {
            addCriterion("material_classify_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdIsNotNull() {
            addCriterion("material_classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdEqualTo(String value) {
            addCriterion("a.material_classify_id =", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotEqualTo(String value) {
            addCriterion("material_classify_id <>", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdGreaterThan(String value) {
            addCriterion("material_classify_id >", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_classify_id >=", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdLessThan(String value) {
            addCriterion("material_classify_id <", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdLessThanOrEqualTo(String value) {
            addCriterion("material_classify_id <=", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdLike(String value) {
            addCriterion("material_classify_id like", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotLike(String value) {
            addCriterion("material_classify_id not like", value, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdIn(List<String> values) {
            addCriterion("material_classify_id in", values, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotIn(List<String> values) {
            addCriterion("material_classify_id not in", values, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdBetween(String value1, String value2) {
            addCriterion("material_classify_id between", value1, value2, "materialClassifyId");
            return (Criteria) this;
        }

        public Criteria andMaterialClassifyIdNotBetween(String value1, String value2) {
            addCriterion("material_classify_id not between", value1, value2, "materialClassifyId");
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

        public Criteria andAbcLogoIsNull() {
            addCriterion("ABC_logo is null");
            return (Criteria) this;
        }

        public Criteria andAbcLogoIsNotNull() {
            addCriterion("ABC_logo is not null");
            return (Criteria) this;
        }

        public Criteria andAbcLogoEqualTo(String value) {
            addCriterion("ABC_logo =", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoNotEqualTo(String value) {
            addCriterion("ABC_logo <>", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoGreaterThan(String value) {
            addCriterion("ABC_logo >", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoGreaterThanOrEqualTo(String value) {
            addCriterion("ABC_logo >=", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoLessThan(String value) {
            addCriterion("ABC_logo <", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoLessThanOrEqualTo(String value) {
            addCriterion("ABC_logo <=", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoLike(String value) {
            addCriterion("ABC_logo like", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoNotLike(String value) {
            addCriterion("ABC_logo not like", value, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoIn(List<String> values) {
            addCriterion("ABC_logo in", values, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoNotIn(List<String> values) {
            addCriterion("ABC_logo not in", values, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoBetween(String value1, String value2) {
            addCriterion("ABC_logo between", value1, value2, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andAbcLogoNotBetween(String value1, String value2) {
            addCriterion("ABC_logo not between", value1, value2, "abcLogo");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIsNull() {
            addCriterion("material_num is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIsNotNull() {
            addCriterion("material_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNumEqualTo(String value) {
            addCriterion("material_num =", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotEqualTo(String value) {
            addCriterion("material_num <>", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumGreaterThan(String value) {
            addCriterion("material_num >", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumGreaterThanOrEqualTo(String value) {
            addCriterion("material_num >=", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumLessThan(String value) {
            addCriterion("material_num <", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumLessThanOrEqualTo(String value) {
            addCriterion("material_num <=", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumLike(String value) {
            addCriterion("material_num like", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotLike(String value) {
            addCriterion("material_num not like", value, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumIn(List<String> values) {
            addCriterion("material_num in", values, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotIn(List<String> values) {
            addCriterion("material_num not in", values, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumBetween(String value1, String value2) {
            addCriterion("material_num between", value1, value2, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialNumNotBetween(String value1, String value2) {
            addCriterion("material_num not between", value1, value2, "materialNum");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureIsNull() {
            addCriterion("material_texture is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureIsNotNull() {
            addCriterion("material_texture is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureEqualTo(String value) {
            addCriterion("material_texture =", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureNotEqualTo(String value) {
            addCriterion("material_texture <>", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureGreaterThan(String value) {
            addCriterion("material_texture >", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureGreaterThanOrEqualTo(String value) {
            addCriterion("material_texture >=", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureLessThan(String value) {
            addCriterion("material_texture <", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureLessThanOrEqualTo(String value) {
            addCriterion("material_texture <=", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureLike(String value) {
            addCriterion("material_texture like", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureNotLike(String value) {
            addCriterion("material_texture not like", value, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureIn(List<String> values) {
            addCriterion("material_texture in", values, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureNotIn(List<String> values) {
            addCriterion("material_texture not in", values, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureBetween(String value1, String value2) {
            addCriterion("material_texture between", value1, value2, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMaterialTextureNotBetween(String value1, String value2) {
            addCriterion("material_texture not between", value1, value2, "materialTexture");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIsNull() {
            addCriterion("measuring_unit is null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIsNotNull() {
            addCriterion("measuring_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitEqualTo(String value) {
            addCriterion("measuring_unit =", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotEqualTo(String value) {
            addCriterion("measuring_unit <>", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitGreaterThan(String value) {
            addCriterion("measuring_unit >", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitGreaterThanOrEqualTo(String value) {
            addCriterion("measuring_unit >=", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLessThan(String value) {
            addCriterion("measuring_unit <", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLessThanOrEqualTo(String value) {
            addCriterion("measuring_unit <=", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitLike(String value) {
            addCriterion("measuring_unit like", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotLike(String value) {
            addCriterion("measuring_unit not like", value, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitIn(List<String> values) {
            addCriterion("measuring_unit in", values, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotIn(List<String> values) {
            addCriterion("measuring_unit not in", values, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitBetween(String value1, String value2) {
            addCriterion("measuring_unit between", value1, value2, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andMeasuringUnitNotBetween(String value1, String value2) {
            addCriterion("measuring_unit not between", value1, value2, "measuringUnit");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("a.supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("supplier_id like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("supplier_id not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
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
            addCriterion("a.architecture_id =", value, "windId");
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
            addCriterion("a.architecture_id in", values, "windId");
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

        public Criteria andIsGuaranteeIsNull() {
            addCriterion("is_guarantee is null");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeIsNotNull() {
            addCriterion("is_guarantee is not null");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeEqualTo(String value) {
            addCriterion("is_guarantee =", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotEqualTo(String value) {
            addCriterion("is_guarantee <>", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeGreaterThan(String value) {
            addCriterion("is_guarantee >", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("is_guarantee >=", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLessThan(String value) {
            addCriterion("is_guarantee <", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("is_guarantee <=", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeLike(String value) {
            addCriterion("is_guarantee like", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotLike(String value) {
            addCriterion("is_guarantee not like", value, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeIn(List<String> values) {
            addCriterion("is_guarantee in", values, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotIn(List<String> values) {
            addCriterion("is_guarantee not in", values, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeBetween(String value1, String value2) {
            addCriterion("is_guarantee between", value1, value2, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsGuaranteeNotBetween(String value1, String value2) {
            addCriterion("is_guarantee not between", value1, value2, "isGuarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysIsNull() {
            addCriterion("guarantee_days is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysIsNotNull() {
            addCriterion("guarantee_days is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysEqualTo(Integer value) {
            addCriterion("guarantee_days =", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysNotEqualTo(Integer value) {
            addCriterion("guarantee_days <>", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysGreaterThan(Integer value) {
            addCriterion("guarantee_days >", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("guarantee_days >=", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysLessThan(Integer value) {
            addCriterion("guarantee_days <", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("guarantee_days <=", value, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysIn(List<Integer> values) {
            addCriterion("guarantee_days in", values, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysNotIn(List<Integer> values) {
            addCriterion("guarantee_days not in", values, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_days between", value1, value2, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_days not between", value1, value2, "guaranteeDays");
            return (Criteria) this;
        }

        public Criteria andIsConStockIsNull() {
            addCriterion("is_con_stock is null");
            return (Criteria) this;
        }

        public Criteria andIsConStockIsNotNull() {
            addCriterion("is_con_stock is not null");
            return (Criteria) this;
        }

        public Criteria andIsConStockEqualTo(String value) {
            addCriterion("is_con_stock =", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockNotEqualTo(String value) {
            addCriterion("is_con_stock <>", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockGreaterThan(String value) {
            addCriterion("is_con_stock >", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockGreaterThanOrEqualTo(String value) {
            addCriterion("is_con_stock >=", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockLessThan(String value) {
            addCriterion("is_con_stock <", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockLessThanOrEqualTo(String value) {
            addCriterion("is_con_stock <=", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockLike(String value) {
            addCriterion("is_con_stock like", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockNotLike(String value) {
            addCriterion("is_con_stock not like", value, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockIn(List<String> values) {
            addCriterion("is_con_stock in", values, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockNotIn(List<String> values) {
            addCriterion("is_con_stock not in", values, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockBetween(String value1, String value2) {
            addCriterion("is_con_stock between", value1, value2, "isConStock");
            return (Criteria) this;
        }

        public Criteria andIsConStockNotBetween(String value1, String value2) {
            addCriterion("is_con_stock not between", value1, value2, "isConStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNull() {
            addCriterion("max_stock is null");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNotNull() {
            addCriterion("max_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMaxStockEqualTo(Integer value) {
            addCriterion("max_stock =", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotEqualTo(Integer value) {
            addCriterion("max_stock <>", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThan(Integer value) {
            addCriterion("max_stock >", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_stock >=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThan(Integer value) {
            addCriterion("max_stock <", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThanOrEqualTo(Integer value) {
            addCriterion("max_stock <=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockIn(List<Integer> values) {
            addCriterion("max_stock in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotIn(List<Integer> values) {
            addCriterion("max_stock not in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockBetween(Integer value1, Integer value2) {
            addCriterion("max_stock between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotBetween(Integer value1, Integer value2) {
            addCriterion("max_stock not between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMinStockIsNull() {
            addCriterion("min_stock is null");
            return (Criteria) this;
        }

        public Criteria andMinStockIsNotNull() {
            addCriterion("min_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMinStockEqualTo(Integer value) {
            addCriterion("min_stock =", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockNotEqualTo(Integer value) {
            addCriterion("min_stock <>", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockGreaterThan(Integer value) {
            addCriterion("min_stock >", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_stock >=", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockLessThan(Integer value) {
            addCriterion("min_stock <", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockLessThanOrEqualTo(Integer value) {
            addCriterion("min_stock <=", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockIn(List<Integer> values) {
            addCriterion("min_stock in", values, "minStock");
            return (Criteria) this;
        }

		public Criteria andSearchKey(String value){
        addCriterion("(a.material_code like %"+value+"%\" or a.material_describe like %"+value+"%\" or a.material_describe like %"+value+"%\")");
        return (Criteria) this;
		}	
        

        public Criteria andMinStockNotIn(List<Integer> values) {
            addCriterion("min_stock not in", values, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockBetween(Integer value1, Integer value2) {
            addCriterion("min_stock between", value1, value2, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockNotBetween(Integer value1, Integer value2) {
            addCriterion("min_stock not between", value1, value2, "minStock");
            return (Criteria) this;
        }

        public Criteria andIsBatchConIsNull() {
            addCriterion("is_batch_con is null");
            return (Criteria) this;
        }

        public Criteria andIsBatchConIsNotNull() {
            addCriterion("is_batch_con is not null");
            return (Criteria) this;
        }

        public Criteria andIsBatchConEqualTo(String value) {
            addCriterion("is_batch_con =", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConNotEqualTo(String value) {
            addCriterion("is_batch_con <>", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConGreaterThan(String value) {
            addCriterion("is_batch_con >", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConGreaterThanOrEqualTo(String value) {
            addCriterion("is_batch_con >=", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConLessThan(String value) {
            addCriterion("is_batch_con <", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConLessThanOrEqualTo(String value) {
            addCriterion("is_batch_con <=", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConLike(String value) {
            addCriterion("is_batch_con like", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConNotLike(String value) {
            addCriterion("is_batch_con not like", value, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConIn(List<String> values) {
            addCriterion("is_batch_con in", values, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConNotIn(List<String> values) {
            addCriterion("is_batch_con not in", values, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConBetween(String value1, String value2) {
            addCriterion("is_batch_con between", value1, value2, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andIsBatchConNotBetween(String value1, String value2) {
            addCriterion("is_batch_con not between", value1, value2, "isBatchCon");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNull() {
            addCriterion("safety_stock is null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNotNull() {
            addCriterion("safety_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockEqualTo(Integer value) {
            addCriterion("safety_stock =", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotEqualTo(Integer value) {
            addCriterion("safety_stock <>", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThan(Integer value) {
            addCriterion("safety_stock >", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("safety_stock >=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThan(Integer value) {
            addCriterion("safety_stock <", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThanOrEqualTo(Integer value) {
            addCriterion("safety_stock <=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIn(List<Integer> values) {
            addCriterion("safety_stock in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotIn(List<Integer> values) {
            addCriterion("safety_stock not in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockBetween(Integer value1, Integer value2) {
            addCriterion("safety_stock between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotBetween(Integer value1, Integer value2) {
            addCriterion("safety_stock not between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNull() {
            addCriterion("current_stock is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNotNull() {
            addCriterion("current_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockEqualTo(Integer value) {
            addCriterion("current_stock =", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotEqualTo(Integer value) {
            addCriterion("current_stock <>", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThan(Integer value) {
            addCriterion("current_stock >", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_stock >=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThan(Integer value) {
            addCriterion("current_stock <", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThanOrEqualTo(Integer value) {
            addCriterion("current_stock <=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIn(List<Integer> values) {
            addCriterion("current_stock in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotIn(List<Integer> values) {
            addCriterion("current_stock not in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockBetween(Integer value1, Integer value2) {
            addCriterion("current_stock between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotBetween(Integer value1, Integer value2) {
            addCriterion("current_stock not between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNull() {
            addCriterion("average_price is null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNotNull() {
            addCriterion("average_price is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceEqualTo(BigDecimal value) {
            addCriterion("average_price =", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotEqualTo(BigDecimal value) {
            addCriterion("average_price <>", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThan(BigDecimal value) {
            addCriterion("average_price >", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average_price >=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThan(BigDecimal value) {
            addCriterion("average_price <", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average_price <=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIn(List<BigDecimal> values) {
            addCriterion("average_price in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotIn(List<BigDecimal> values) {
            addCriterion("average_price not in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_price between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_price not between", value1, value2, "averagePrice");
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

        public Criteria andExtend1IsNull() {
            addCriterion("extend1 is null");
            return (Criteria) this;
        }

        public Criteria andExtend1IsNotNull() {
            addCriterion("extend1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend1EqualTo(String value) {
            addCriterion("extend1 =", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotEqualTo(String value) {
            addCriterion("extend1 <>", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThan(String value) {
            addCriterion("extend1 >", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1GreaterThanOrEqualTo(String value) {
            addCriterion("extend1 >=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThan(String value) {
            addCriterion("extend1 <", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1LessThanOrEqualTo(String value) {
            addCriterion("extend1 <=", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Like(String value) {
            addCriterion("extend1 like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotLike(String value) {
            addCriterion("extend1 not like", value, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1In(List<String> values) {
            addCriterion("extend1 in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotIn(List<String> values) {
            addCriterion("extend1 not in", values, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1Between(String value1, String value2) {
            addCriterion("extend1 between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend1NotBetween(String value1, String value2) {
            addCriterion("extend1 not between", value1, value2, "extend1");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNull() {
            addCriterion("extend2 is null");
            return (Criteria) this;
        }

        public Criteria andExtend2IsNotNull() {
            addCriterion("extend2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend2EqualTo(String value) {
            addCriterion("extend2 =", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotEqualTo(String value) {
            addCriterion("extend2 <>", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThan(String value) {
            addCriterion("extend2 >", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2GreaterThanOrEqualTo(String value) {
            addCriterion("extend2 >=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThan(String value) {
            addCriterion("extend2 <", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2LessThanOrEqualTo(String value) {
            addCriterion("extend2 <=", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Like(String value) {
            addCriterion("extend2 like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotLike(String value) {
            addCriterion("extend2 not like", value, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2In(List<String> values) {
            addCriterion("extend2 in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotIn(List<String> values) {
            addCriterion("extend2 not in", values, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2Between(String value1, String value2) {
            addCriterion("extend2 between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend2NotBetween(String value1, String value2) {
            addCriterion("extend2 not between", value1, value2, "extend2");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNull() {
            addCriterion("extend3 is null");
            return (Criteria) this;
        }

        public Criteria andExtend3IsNotNull() {
            addCriterion("extend3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend3EqualTo(String value) {
            addCriterion("extend3 =", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotEqualTo(String value) {
            addCriterion("extend3 <>", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThan(String value) {
            addCriterion("extend3 >", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3GreaterThanOrEqualTo(String value) {
            addCriterion("extend3 >=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThan(String value) {
            addCriterion("extend3 <", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3LessThanOrEqualTo(String value) {
            addCriterion("extend3 <=", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Like(String value) {
            addCriterion("extend3 like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotLike(String value) {
            addCriterion("extend3 not like", value, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3In(List<String> values) {
            addCriterion("extend3 in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotIn(List<String> values) {
            addCriterion("extend3 not in", values, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3Between(String value1, String value2) {
            addCriterion("extend3 between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend3NotBetween(String value1, String value2) {
            addCriterion("extend3 not between", value1, value2, "extend3");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNull() {
            addCriterion("extend4 is null");
            return (Criteria) this;
        }

        public Criteria andExtend4IsNotNull() {
            addCriterion("extend4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtend4EqualTo(String value) {
            addCriterion("extend4 =", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotEqualTo(String value) {
            addCriterion("extend4 <>", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThan(String value) {
            addCriterion("extend4 >", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4GreaterThanOrEqualTo(String value) {
            addCriterion("extend4 >=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThan(String value) {
            addCriterion("extend4 <", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4LessThanOrEqualTo(String value) {
            addCriterion("extend4 <=", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Like(String value) {
            addCriterion("extend4 like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotLike(String value) {
            addCriterion("extend4 not like", value, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4In(List<String> values) {
            addCriterion("extend4 in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotIn(List<String> values) {
            addCriterion("extend4 not in", values, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4Between(String value1, String value2) {
            addCriterion("extend4 between", value1, value2, "extend4");
            return (Criteria) this;
        }

        public Criteria andExtend4NotBetween(String value1, String value2) {
            addCriterion("extend4 not between", value1, value2, "extend4");
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