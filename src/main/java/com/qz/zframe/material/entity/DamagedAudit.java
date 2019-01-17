package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 损坏件审核基本信息
 * 
 * @author syc
 * @date 2018年11月13日下午4:37:13
 *
 */
public class DamagedAudit implements Serializable{
    
	private static final long serialVersionUID = 6961158504491040391L;

	
	@ApiModelProperty(name="damagedAuditId",value="损坏件审核id",required=true)
	private String damagedAuditId;

	
	@ApiModelProperty(name="damagedAuditOrder",value="损坏件审核单号",required=true)
    private String damagedAuditOrder;

	@ApiModelProperty(name="damagedAuditDescribe",value="核定描述",required=true)
    private String damagedAuditDescribe;

	@ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;

	@ApiModelProperty(name="creater",value="创建人id",required=false)
    private String creater;
    
    @ApiModelProperty(name="createName",value="创建人名称",required=false)
    private String createName;

    @ApiModelProperty(name="createTime",value="创建日期",required=false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;

    @ApiModelProperty(name="status",value="状态",required=false)
    private String status;
    
	@ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;
    
    @ApiModelProperty(name="damagedAuditDetails",value="物资明细",required=true)
    private List<DamagedAuditDetail> damagedAuditDetails;

    public String getDamagedAuditId() {
        return damagedAuditId;
    }

    public void setDamagedAuditId(String damagedAuditId) {
        this.damagedAuditId = damagedAuditId == null ? null : damagedAuditId.trim();
    }

    public String getDamagedAuditOrder() {
        return damagedAuditOrder;
    }

    public void setDamagedAuditOrder(String damagedAuditOrder) {
        this.damagedAuditOrder = damagedAuditOrder == null ? null : damagedAuditOrder.trim();
    }

    public String getDamagedAuditDescribe() {
        return damagedAuditDescribe;
    }

    public void setDamagedAuditDescribe(String damagedAuditDescribe) {
        this.damagedAuditDescribe = damagedAuditDescribe == null ? null : damagedAuditDescribe.trim();
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

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public List<DamagedAuditDetail> getDamagedAuditDetails() {
		return damagedAuditDetails;
	}

	public void setDamagedAuditDetails(List<DamagedAuditDetail> damagedAuditDetails) {
		this.damagedAuditDetails = damagedAuditDetails;
	}
   
    
}