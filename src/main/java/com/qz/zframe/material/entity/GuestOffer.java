package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class GuestOffer implements Serializable{
	
	
    /**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1245066346762450673L;

	@ApiModelProperty(name="guestId",value="客商id",required=true)
	private String guestId;

	@ApiModelProperty(name="scrapId",value="报废id",required=true)
    private String scrapId;

	@ApiModelProperty(name="guestName",value="客商名称",required=false)
    private String guestName;

	@ApiModelProperty(name="fixedTelephone",value="固定电话",required=false)
    private String fixedTelephone;

	@ApiModelProperty(name="mobilePhone",value="移动手机",required=false)
    private String mobilePhone;

	@ApiModelProperty(name="offerAmount",value="报价金额",required=false)
    private BigDecimal offerAmount;

	@ApiModelProperty(name="adviceWin",value="建议中标",required=false)
    private String adviceWin;
	
	@ApiModelProperty(name="remark",value="备注",required=false)
    private String remark;

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId == null ? null : guestId.trim();
    }

    public String getScrapId() {
        return scrapId;
    }

    public void setScrapId(String scrapId) {
        this.scrapId = scrapId == null ? null : scrapId.trim();
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName == null ? null : guestName.trim();
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone == null ? null : fixedTelephone.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public BigDecimal getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(BigDecimal offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getAdviceWin() {
        return adviceWin;
    }

    public void setAdviceWin(String adviceWin) {
        this.adviceWin = adviceWin == null ? null : adviceWin.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}