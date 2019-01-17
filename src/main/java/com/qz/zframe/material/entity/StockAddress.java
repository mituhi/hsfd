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
	
	@ApiModelProperty(name="stockAddAttrText",value="库存地点属性转换文本",required=false)
	@JsonView({ ListView.class })
    private String stockAddAttrText;


	@ApiModelProperty(name="architectureCode",value="风电场编码",required=true)
	@JsonView({ ListView.class })
    private String architectureCode;
    
 
	@ApiModelProperty(name="architectureName",value="风电场名称",required=false)
	@JsonView({ ListView.class })
    private String architectureName;

    
	@ApiModelProperty(name="status",value="库存地状态，01启用，02停用",required=true)
	@JsonView({ ListView.class })
    private String status;
	
	@ApiModelProperty(name="statusText",value="库存地状态转换文本",required=false)
	@JsonView({ ListView.class })
    private String statusText;

  
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


	public String getArchitectureCode() {
		return architectureCode;
	}

	public void setArchitectureCode(String architectureCode) {
		this.architectureCode = architectureCode;
	}

	public String getArchitectureName() {
		return architectureName;
	}

	public void setArchitectureName(String architectureName) {
		this.architectureName = architectureName;
	}

	public String getStockAddAttrText() {
		return stockAddAttrText;
	}

	public void setStockAddAttrText(String stockAddAttrText) {
		this.stockAddAttrText = stockAddAttrText;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	
}