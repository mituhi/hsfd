package com.qz.zframe.tally.entity;
/*
二维码配置
 */
public class QrCode {
    //二维码id
    private String qrCodeId;
    //编号
    private String code;
    //所属风电场
    private String windId;
    //位置名称
    private String addressName;

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
}
