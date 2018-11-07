package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 供应商信息
 * 
 * @ClassName: Supplier
 * @author syc
 * @date 2018年11月3日下午2:52:14
 *
 */
public class Supplier implements Serializable{
	
    
	private static final long serialVersionUID = 7600743724946307208L;
	
	public interface ListView extends BaseJsonView {};

	@ApiModelProperty(name="supplierId",value="供应商id",required=false)
	@JsonView({ ListView.class })
	private String supplierId;

	@ApiModelProperty(name="supplierCode",value="供应商编码",required=true)
	@JsonView({ ListView.class })
    private String supplierCode;

	@ApiModelProperty(name="supplierName",value="供应商名称",required=true)
	@JsonView({ ListView.class })
    private String supplierName;

	@ApiModelProperty(name="abcLogo",value="ABC标识",required=false)
    private String abcLogo;
    
	@ApiModelProperty(name="supplierDescribe",value="供应商描述",required=false)
    @JsonView({ ListView.class })
    private String  supplierDescribe;

	@ApiModelProperty(name="supplierStatus",value="供应商状态，01启用，02停用",required=true)
    private String supplierStatus;

	@ApiModelProperty(name="supplierAddress",value="供应商地址",required=false)
    private String supplierAddress;

	@ApiModelProperty(name="eMail",value="邮箱",required=false)
    @JsonView({ ListView.class })
    private String eMail;

	@ApiModelProperty(name="dutyParagStatus",value="税号状态，01启用，02停用",required=true)
    private String dutyParagStatus;

	@ApiModelProperty(name="openingBank",value="开户行",required=false)
    private String openingBank;

	@ApiModelProperty(name="bankAccount",value="开户行账号",required=false)
    private String bankAccount;

	@ApiModelProperty(name="businessLeader",value="负责人",required=false)
    @JsonView({ ListView.class })
    private String businessLeader;

	@ApiModelProperty(name="mobile",value="移动电话",required=false)
    @JsonView({ ListView.class })
    private String mobile;

	@ApiModelProperty(name="phone",value="固定电话",required=false)
    @JsonView({ ListView.class })
    private String phone;

	@ApiModelProperty(name="remark",value="备注",required=false)
    @JsonView({ ListView.class })
    private String remark;

	@ApiModelProperty(name="creater",value="创建人",required=false)
    private String creater;

	@ApiModelProperty(name="createTime",value="创建时间",required=false)
    private Date createTime;
    
	@ApiModelProperty(name="isDelete",value="删除状态,01正常，02删除",required=false)
    private String isDelete;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getAbcLogo() {
        return abcLogo;
    }

    public void setAbcLogo(String abcLogo) {
        this.abcLogo = abcLogo == null ? null : abcLogo.trim();
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus == null ? null : supplierStatus.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getDutyParagStatus() {
        return dutyParagStatus;
    }

    public void setDutyParagStatus(String dutyParagStatus) {
        this.dutyParagStatus = dutyParagStatus == null ? null : dutyParagStatus.trim();
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getBusinessLeader() {
        return businessLeader;
    }

    public void setBusinessLeader(String businessLeader) {
        this.businessLeader = businessLeader == null ? null : businessLeader.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getSupplierDescribe() {
		return supplierDescribe;
	}

	public void setSupplierDescribe(String supplierDescribe) {
		this.supplierDescribe = supplierDescribe;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}