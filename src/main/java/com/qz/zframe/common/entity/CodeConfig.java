package com.qz.zframe.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 编码配置表
 */
public class CodeConfig {

    @ApiModelProperty(value="配置id",name="configId",required=false)
    private String configId;
    @ApiModelProperty(value="配置类型",name="configType",required=false)
    private String configType;
    @ApiModelProperty(value="配置类型名称",name="configTypeName",required=false)
    private String configTypeName;
    @ApiModelProperty(value="业务编号",name="businessCode",required=false)
    private String businessCode;
    @ApiModelProperty(value="配置值",name="configValue",required=false)
    private String configValue;
    @ApiModelProperty(value="状态,01:启用;02:停用",name="status",required=false)
    private String status;
    @ApiModelProperty(value="状态名称",name="statusName",required=false)
    private String statusName;
    @ApiModelProperty(value="创建人",name="creater",required=false)
    private String creater;
    @ApiModelProperty(value="创建人名称",name="createrName",required=false)
    private String createrName;
    @ApiModelProperty(value="创建时间",name="createTime",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createTime;
    @ApiModelProperty(value="显示顺序",name="dispOrder",required=false)
    private int dispOrder;

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigTypeName() {
        return configTypeName;
    }

    public void setConfigTypeName(String configTypeName) {
        this.configTypeName = configTypeName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDispOrder() {
        return dispOrder;
    }

    public void setDispOrder(int dispOrder) {
        this.dispOrder = dispOrder;
    }
}
