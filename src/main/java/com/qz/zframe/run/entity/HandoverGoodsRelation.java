package com.qz.zframe.run.entity;

public class HandoverGoodsRelation {
	
    private String handoverGoodsRelationId;

    private String handoverGoodsId;

    private String goodsId;

    public String getHandoverGoodsRelationId() {
        return handoverGoodsRelationId;
    }

    public void setHandoverGoodsRelationId(String handoverGoodsRelationId) {
        this.handoverGoodsRelationId = handoverGoodsRelationId == null ? null : handoverGoodsRelationId.trim();
    }

    public String getHandoverGoodsId() {
        return handoverGoodsId;
    }

    public void setHandoverGoodsId(String handoverGoodsId) {
        this.handoverGoodsId = handoverGoodsId == null ? null : handoverGoodsId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }
}