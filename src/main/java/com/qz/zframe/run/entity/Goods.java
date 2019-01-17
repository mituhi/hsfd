package com.qz.zframe.run.entity;

import io.swagger.annotations.ApiModelProperty;

public class Goods {
	
	@ApiModelProperty(value="物品明细表id",name="goodsId")
    private String goodsId;

	@ApiModelProperty(value="物资编号",name="goodsCode",required = true)
    private String goodsCode;

	@ApiModelProperty(value="物资名称",name="goodsName",required = true)
    private String goodsName;

	@ApiModelProperty(value="备注",name="remark")
    private String remark;

	@ApiModelProperty(value="物资排序",name="sort")
    private Integer sort;

	@ApiModelProperty(value="是否启用",name="isEnabled")
    private String isEnabled;

	@ApiModelProperty(value="物品状态",name="goodsStatus")
    private String goodsStatus;
	
	@ApiModelProperty(value="交接物品表id",name="handoverGoodsId")
    private String handoverGoodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus == null ? null : goodsStatus.trim();
    }

	public String getHandoverGoodsId() {
		return handoverGoodsId;
	}

	public void setHandoverGoodsId(String handoverGoodsId) {
		this.handoverGoodsId = handoverGoodsId;
	} 
}