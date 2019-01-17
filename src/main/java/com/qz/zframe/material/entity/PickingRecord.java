package com.qz.zframe.material.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 领料单基本信息
 * 
 * @author syc
 * @date 2018年11月19日下午4:26:53
 *
 */
public class PickingRecord implements Serializable{
	
	
   
	private static final long serialVersionUID = -4986958852499177271L;

    @ApiModelProperty(name="pickingId",value="领料id",required=true)
	private String pickingId;

    @ApiModelProperty(name="pickingOrder",value="领料单号",required=true)
    private String pickingOrder;

    @ApiModelProperty(name="pickingType",value="领料类型编码",required=true)
    private String pickingType;

    @ApiModelProperty(name="pickingTypeName",value="领料类型名称",required=true)
    private String pickingTypeName;
    
    @ApiModelProperty(name="prckingDescribe",value="领料类型",required=true)
    private String prckingDescribe;

    
    @ApiModelProperty(name="workOrder",value="工单号",required=false)
    private String workOrder;

    
    @ApiModelProperty(name="workOrderDescribe",value="工单描述",required=false)
    private String workOrderDescribe;

    @ApiModelProperty(name="picker",value="领料人用户id",required=true)
    private String picker;
    
    @ApiModelProperty(name="windId",value="风电场id",required=true)
    private String windId;
    
    @ApiModelProperty(name="windName",value="风电场名称",required=false)
    private String windName;

    
    @ApiModelProperty(name="stockAddId",value="库存地点id",required=true)
    private String stockAddId;
    
    @ApiModelProperty(name="stockAddName",value="库存地点名称",required=false)
    private String stockAddName;
    
    @ApiModelProperty(name="departmentId",value="部门id",required=false)
    private String departmentId;
    
    @ApiModelProperty(name="departmentName",value="部门名称",required=false)
    private String departmentName;

    @ApiModelProperty(name="approvalStatus",value="审核状态，01保存，02提交，03审核通过，已确认，04审核不通过",required=false)
    private String approvalStatus;
    
    @ApiModelProperty(name="approvalStatusText",value="审核状态转换文本",required=false)
    private String approvalStatusText;

    @ApiModelProperty(name="approvalOpinion",value="审核意见",required=false)
    private String approvalOpinion;

    @ApiModelProperty(name="createTime",value="创建时间",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createTime;
    
    private String status;

    @ApiModelProperty(name="fileId",value="上传文件id",required=false)
    private String fileId;
    
    @ApiModelProperty(name="fileName",value="上传文件名称",required=false)
    private String fileName;
    
    @ApiModelProperty(name="creater",value="创建人id",required=true)
    private String creater;
    
    @ApiModelProperty(name="createName",value="创建人名称",required=false)
    private String createName;
    
    @ApiModelProperty(name="proposer",value="申请人",required=false)
    private String proposer;
    
    @ApiModelProperty(name="applicationDate",value="申请时间,仅作展示时使用",required=false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date applicationDate;

	@ApiModelProperty(name="recordDetails",value="领料详情列表",required=false)
    private List<PickingRecordDetail> recordDetails;
    
    @ApiModelProperty(name="returnPickingOrder",value="退料时所选领用单号",required=false)
    private  String returnPickingOrder;

    private String value;
   
    
    @ApiModelProperty(name="returnPickingId",value="退料时所选领用单Id",required=false)
    private String returnPickingId;
    
    public String getPickingId() {
        return pickingId;
    }

    public void setPickingId(String pickingId) {
        this.pickingId = pickingId == null ? null : pickingId.trim();
    }

    public String getPickingOrder() {
        return pickingOrder;
    }

    public void setPickingOrder(String pickingOrder) {
        this.pickingOrder = pickingOrder == null ? null : pickingOrder.trim();
    }

    public String getPickingType() {
        return pickingType;
    }

    public void setPickingType(String pickingType) {
        this.pickingType = pickingType == null ? null : pickingType.trim();
    }

    public String getPrckingDescribe() {
        return prckingDescribe;
    }

    public void setPrckingDescribe(String prckingDescribe) {
        this.prckingDescribe = prckingDescribe == null ? null : prckingDescribe.trim();
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder == null ? null : workOrder.trim();
    }

    public String getWorkOrderDescribe() {
        return workOrderDescribe;
    }

    public void setWorkOrderDescribe(String workOrderDescribe) {
        this.workOrderDescribe = workOrderDescribe == null ? null : workOrderDescribe.trim();
    }

    public String getPicker() {
        return picker;
    }

    public void setPicker(String picker) {
        this.picker = picker == null ? null : picker.trim();
    }

 

    public String getStockAddId() {
        return stockAddId;
    }

    public void setStockAddId(String stockAddId) {
        this.stockAddId = stockAddId == null ? null : stockAddId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

	public String getStockAddName() {
		return stockAddName;
	}

	public void setStockAddName(String stockAddName) {
		this.stockAddName = stockAddName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public List<PickingRecordDetail> getRecordDetails() {
		return recordDetails;
	}

	public void setRecordDetails(List<PickingRecordDetail> recordDetails) {
		this.recordDetails = recordDetails;
	}

	public String getPickingTypeName() {
		return pickingTypeName;
	}

	public void setPickingTypeName(String pickingTypeName) {
		this.pickingTypeName = pickingTypeName;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}
	public String getApprovalStatusText() {
		return approvalStatusText;
	}

	public void setApprovalStatusText(String approvalStatusText) {
		this.approvalStatusText = approvalStatusText;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReturnPickingOrder() {
		return returnPickingOrder;
	}

	public void setReturnPickingOrder(String returnPickingOrder) {
		this.returnPickingOrder = returnPickingOrder;
	} 	
	
	public String getWindId() {
		return windId;
	}

	public void setWindId(String windId) {
		this.windId = windId;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getReturnPickingId() {
		return returnPickingId;
	}

	public void setReturnPickingId(String returnPickingId) {
		this.returnPickingId = returnPickingId;
	}
	
}