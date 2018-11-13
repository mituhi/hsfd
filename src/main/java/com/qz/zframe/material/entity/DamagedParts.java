package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;
import io.swagger.annotations.ApiModelProperty;

public class DamagedParts implements Serializable {
	

	private static final long serialVersionUID = 8360998089649350068L;
	
	public interface ListView extends BaseJsonView {};

	@ApiModelProperty(name="damagedPartsId",value="损坏件id",required=true)
	@JsonView({ ListView.class })
	private String damagedPartsId;

	@ApiModelProperty(name="damagedPartsOrder",value="损坏件单号",required=true)
	@JsonView({ ListView.class })
	private String damagedPartsOrder;

	@ApiModelProperty(name="damagedPartsDescribe",value="损坏件描述",required=true)
	@JsonView({ ListView.class })   
	private String damagedPartsDescribe;

	
	@ApiModelProperty(name="stockAddId",value="库存地点id",required=true)
	@JsonView({ ListView.class })
	private String stockAddId;
	
	@ApiModelProperty(name="stockAddName",value="库存地点名称",required=false)
	@JsonView({ ListView.class })
	private String stockAddName;

	@ApiModelProperty(name="remark",value="备注",required=false)
	@JsonView({ ListView.class })
	private String remark;

	@ApiModelProperty(name="storageTime",value="入库日期，展示",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	@JsonView({ ListView.class })
	private Date storageTime;
	
	@ApiModelProperty(name="storageDate",value="入库日期，新增或编辑时使用",required=true)
	private String storageDate;

	@ApiModelProperty(name="windId",value="风电场id",required=true)
	@JsonView({ ListView.class })
	private String windId;
	
	@ApiModelProperty(name="windName",value="风电场名称",required=false)
	@JsonView({ ListView.class })
	private String windName;

	
	@ApiModelProperty(name="creater",value="创建人id",required=false)
    private String creater;
	
	@ApiModelProperty(name="createName",value="创建人名称",required=false)
	@JsonView({ ListView.class })
	private String createName;

	@ApiModelProperty(name="createName",value="创建日期",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	@JsonView({ ListView.class })
    private Date createTime;

	@ApiModelProperty(name="status",value="状态",required=false)
	@JsonView({ ListView.class })
	private String status;
	
	@ApiModelProperty(name="damagedPartsDetails",value="物资明细列表",required=false)
    private List<DamagedPartsDetail> damagedPartsDetails;

    public String getStockAddName() {
		return stockAddName;
	}

	public void setStockAddName(String stockAddName) {
		this.stockAddName = stockAddName;
	}

	public String getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(String storageDate) {
		this.storageDate = storageDate;
	}

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public List<DamagedPartsDetail> getDamagedPartsDetails() {
		return damagedPartsDetails;
	}

	public void setDamagedPartsDetails(List<DamagedPartsDetail> damagedPartsDetails) {
		this.damagedPartsDetails = damagedPartsDetails;
	}

	public String getDamagedPartsId() {
        return damagedPartsId;
    }

    public void setDamagedPartsId(String damagedPartsId) {
        this.damagedPartsId = damagedPartsId == null ? null : damagedPartsId.trim();
    }

    public String getDamagedPartsOrder() {
        return damagedPartsOrder;
    }

    public void setDamagedPartsOrder(String damagedPartsOrder) {
        this.damagedPartsOrder = damagedPartsOrder == null ? null : damagedPartsOrder.trim();
    }

    public String getDamagedPartsDescribe() {
        return damagedPartsDescribe;
    }

    public void setDamagedPartsDescribe(String damagedPartsDescribe) {
        this.damagedPartsDescribe = damagedPartsDescribe == null ? null : damagedPartsDescribe.trim();
    }

    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId == null ? null : stockAddId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
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
    
    
}