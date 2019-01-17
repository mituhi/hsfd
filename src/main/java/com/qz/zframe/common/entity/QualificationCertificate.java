package com.qz.zframe.common.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 资质证书表
 */
public class QualificationCertificate {

    @ApiModelProperty(value="证书id",name="certificateId",required=false)
    private String certificateId;
    @ApiModelProperty(value="证书编号",name="certificateCode",required=false)
    private String certificateCode;
    @ApiModelProperty(value="证书名称",name="certificateName",required=false)
    private String certificateName;
    @ApiModelProperty(value="证书描述",name="certificateDescribe",required=false)
    private String certificateDescribe;
    @ApiModelProperty(value="创建人",name="creater",required=false)
    private String creater;
    @ApiModelProperty(value="创建时间",name="createTime",required=false)
    private Date createTime;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateDescribe() {
        return certificateDescribe;
    }

    public void setCertificateDescribe(String certificateDescribe) {
        this.certificateDescribe = certificateDescribe;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
