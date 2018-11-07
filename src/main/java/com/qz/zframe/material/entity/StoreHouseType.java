package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 出库类型
 * 
 * @author syc
 * @date 2018年11月2日上午10:11:13
 *
 */
public class StoreHouseType implements Serializable{
    
	private static final long serialVersionUID = -3518902560390363959L;
	
	public interface ListView extends BaseJsonView {};

	
	
	@ApiModelProperty(name="typeId",value="出库类型id",required=true)
	@JsonView({ListView.class})
	private String typeId;

 
	@ApiModelProperty(name="typeCode",value="出库类型编码",required=true)
	@JsonView({ListView.class})
    private String typeCode;

  
	@ApiModelProperty(name="typeName",value="出库类型名称",required=true)
	@JsonView({ListView.class})
    private String typeName;

   
	@ApiModelProperty(name="isRelatedJobs",value="是否关联工单，01是，02否",required=true)
	@JsonView({ListView.class})
    private String isRelatedJobs;

   
	@ApiModelProperty(name="isNegative",value="是否负数，01是02否",required=true)
	@JsonView({ListView.class})
    private String isNegative;

    /**
     * 删除状态
     */
    private String isDelete;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date createTime;

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

	public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getIsRelatedJobs() {
        return isRelatedJobs;
    }

    public void setIsRelatedJobs(String isRelatedJobs) {
        this.isRelatedJobs = isRelatedJobs == null ? null : isRelatedJobs.trim();
    }

    public String getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(String isNegative) {
        this.isNegative = isNegative == null ? null : isNegative.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}