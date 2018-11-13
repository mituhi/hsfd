package com.qz.zframe.tally.entity;

import io.swagger.annotations.ApiModelProperty;

/*
二维码配置
 */
public class QrCode {
    //二维码id
    @ApiModelProperty(value="二维码id",name="qrCodeId",required=false)
    private String qrCodeId;
    //编号
    @ApiModelProperty(value="编号",name="code",required=false)
    private String code;
    //所属风电场
    @ApiModelProperty(value="所属风电场",name="windId",required=false)
    private String windId;
    //位置名称
    @ApiModelProperty(value="位置名称",name="addressName",required=false)
    private String addressName;
    @ApiModelProperty(value="风电场",name="windCode",required=false)
    private String windCode;

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode;
    }
}
