package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class ValueTime {
	
	@ApiModelProperty(value="值次id",name="valueId")
    private String valueId;
    
    @ApiModelProperty(value="值次编码",name="valueCode",required=true)
    private String valueCode;

    @ApiModelProperty(value="值次名称",name="valueName",required=true)
    private String valueName;

    @ApiModelProperty(value="值次状态",name="status",required=true)
    private String status;

    @ApiModelProperty(value="值次排序",name="sort",required=true)
    private Integer sort;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId == null ? null : valueId.trim();
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode == null ? null : valueCode.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}