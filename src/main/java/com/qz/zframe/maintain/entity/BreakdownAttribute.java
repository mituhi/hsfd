package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiParam;

public class BreakdownAttribute {

    @ApiParam(name="attributeId",value="故障属性id",required=false)
    private String attributeId;

    @ApiParam(name="attributeName",value="故障属性名称",required=false)
    private String attributeName;

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId == null ? null : attributeId.trim();
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }
}