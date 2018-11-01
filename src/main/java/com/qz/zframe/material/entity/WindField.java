package com.qz.zframe.material.entity;

import java.io.Serializable;

import com.qz.zframe.common.util.BaseJsonView;

public class WindField implements Serializable{
   
	private static final long serialVersionUID = -8955553217388062709L;
	
	public interface ListView extends BaseJsonView{};

	
	/**
	 * 风电场id
	 */
	private String windId;

    /**
     * 风电场编码
     */
    private String windCode;

    /**
     * 风电场名称
     */
    private String windName;

    /**
     * 风电场状态
     */
    private String windStatus;

    /**
     * 是否有价值
     */
    private String isValuable;

    /**
     * 备注
     */
    private String remark;

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode == null ? null : windCode.trim();
    }

    public String getWindName() {
        return windName;
    }

    public void setWindName(String windName) {
        this.windName = windName == null ? null : windName.trim();
    }

    public String getWindStatus() {
        return windStatus;
    }

    public void setWindStatus(String windStatus) {
        this.windStatus = windStatus == null ? null : windStatus.trim();
    }

    public String getIsValuable() {
        return isValuable;
    }

    public void setIsValuable(String isValuable) {
        this.isValuable = isValuable == null ? null : isValuable.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}