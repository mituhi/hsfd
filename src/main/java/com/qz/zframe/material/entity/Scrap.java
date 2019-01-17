package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class Scrap implements Serializable{
	
	private static final long serialVersionUID = 4734472103649333374L;

	@ApiModelProperty(name="scrapId",value="报废id",required=true)
	private String scrapId;

	@ApiModelProperty(name="scrapOrder",value="报废单号",required=true)
    private String scrapOrder;

	@ApiModelProperty(name="scrapDescribe",value="报废描述",required=true)
    private String scrapDescribe;

	@ApiModelProperty(name="creater",value="创建人id",required=false)
    private String creater;
	
	@ApiModelProperty(name="createName",value="创建人名称",required=false)
    private String createName;

	
	@ApiModelProperty(name="createTime",value="创建时间",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;

	@ApiModelProperty(name="status",value="状态",required=false)
    private String status;

	@ApiModelProperty(name="architectureId",value="风电场id",required=true)
    private String architectureId;

	@ApiModelProperty(name="architectureName",value="风电场名称",required=false)
	private String architectureName;
	
	
	@ApiModelProperty(name="scrapDetails",value="报废详情集合",required=false)
	private List<ScrapDetail> scrapDetails;
	
	@ApiModelProperty(name="guestOffers",value="客商集合",required=false)
	private List<GuestOffer> guestOffers;
	
    public String getScrapId() {
        return scrapId;
    }

    public void setScrapId(String scrapId) {
        this.scrapId = scrapId == null ? null : scrapId.trim();
    }

    public String getScrapOrder() {
        return scrapOrder;
    }

    public void setScrapOrder(String scrapOrder) {
        this.scrapOrder = scrapOrder == null ? null : scrapOrder.trim();
    }

    public String getScrapDescribe() {
        return scrapDescribe;
    }

    public void setScrapDescribe(String scrapDescribe) {
        this.scrapDescribe = scrapDescribe == null ? null : scrapDescribe.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getArchitectureId() {
        return architectureId;
    }

    public void setArchitectureId(String architectureId) {
        this.architectureId = architectureId == null ? null : architectureId.trim();
    }

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getArchitectureName() {
		return architectureName;
	}

	public void setArchitectureName(String architectureName) {
		this.architectureName = architectureName;
	}

	public List<ScrapDetail> getScrapDetails() {
		return scrapDetails;
	}

	public void setScrapDetails(List<ScrapDetail> scrapDetails) {
		this.scrapDetails = scrapDetails;
	}

	public List<GuestOffer> getGuestOffers() {
		return guestOffers;
	}

	public void setGuestOffers(List<GuestOffer> guestOffers) {
		this.guestOffers = guestOffers;
	}
	
}