package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 库存地点编码
 * 
 * @author syc
 * @date 2018年11月2日下午6:18:03
 *
 */
public class StockAddress implements Serializable{
	
	
	private static final long serialVersionUID = 1695325993247141951L;
	
	public interface ListView extends BaseJsonView {};


	@ApiModelProperty(name="stockAddId",value="库存地点id",required=true)
	@JsonView({ ListView.class })
	private String stockAddId;

 
	@ApiModelProperty(name="stockAddCode",value="库存地点编码",required=true)
	@JsonView({ ListView.class })
    private String stockAddCode;

	@ApiModelProperty(name="stockAddName",value="库存地点名称",required=true)
	@JsonView({ ListView.class })
    private String stockAddName;

	@ApiModelProperty(name="stockAddAttr",value="库存地点属性，01物理，02逻辑",required=true)
	@JsonView({ ListView.class })
    private String stockAddAttr;


	@ApiModelProperty(name="windId",value="风电场id",required=true)
	@JsonView({ ListView.class })
    private String windId;
    
 
	@ApiModelProperty(name="windName",value="风电场名称",required=false)
	@JsonView({ ListView.class })
    private String windName;

    
	@ApiModelProperty(name="status",value="库存地状态，01启用，02停用",required=true)
	@JsonView({ ListView.class })
    private String status;

  
	@ApiModelProperty(name="remark",value="备注",required=false)
	@JsonView({ ListView.class })
    private String remark;

    /**
     * 创建人
     */
	@ApiModelProperty(name="creater",value="创建人",required=false)
    private String creater;

    /**
     * 创建时间
     */
	@ApiModelProperty(name="createTime",value="创建时间",required=false)
    private Date createTime;
    
	@ApiModelProperty(name="isDelete",value="删除状态",required=false)
    private String isDelete;


    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId == null ? null : stockAddId.trim();
    }

    public String getStockAddCode() {
        return stockAddCode;
    }

    public void setStockAddCode(String stockAddCode) {
        this.stockAddCode = stockAddCode == null ? null : stockAddCode.trim();
    }

    public String getStockAddName() {
        return stockAddName;
    }

    public void setStockAddName(String stockAddName) {
        this.stockAddName = stockAddName == null ? null : stockAddName.trim();
    }

    public String getStockAddAttr() {
        return stockAddAttr;
    }

    public void setStockAddAttr(String stockAddAttr) {
        this.stockAddAttr = stockAddAttr == null ? null : stockAddAttr.trim();
    }

    public String getWindId() {
        return windId;
    }

    public void setWindId(String windId) {
        this.windId = windId == null ? null : windId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

   

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
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