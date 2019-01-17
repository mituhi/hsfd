package com.qz.zframe.run.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.common.util.BaseJsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 排班管理实体类
 * 
 * @author syc
 * @date 2019年1月3日下午4:08:05
 *
 */
public class NewSchedulingAssociated  extends SchedulingAssociatedDetail implements Serializable {
	
	public interface ListView extends BaseJsonView {};
	
	private static final long serialVersionUID = 5100105627658674064L;

	@ApiModelProperty(value="排班管理Id",name="associatedId",required=true)
	@JsonView({ListView.class})
	private String associatedId;

	@ApiModelProperty(value="排班管理编码",name="associatedCode",required=true)
	@JsonView({ListView.class})
    private String associatedCode;

	@ApiModelProperty(value="排班管理名称",name="associatedName",required=true)
	@JsonView({ListView.class})
    private String associatedName;

	@ApiModelProperty(value="风电场编码",name="windCode",required=true)
	@JsonView({ListView.class})
    private String windCode;

	@ApiModelProperty(value="风电场名称",name="windName",required=true)
	@JsonView({ListView.class})
	private String windName;

	@ApiModelProperty(value="删除状态",name="isDelete",required=false)
    private String isDelete;

    private String creater;

    private Date createTime;
    
    @ApiModelProperty(value="排版规则集合",name="details",required=true)
    @JsonView({ListView.class})
    private List<SchedulingAssociatedDetail> details;
    

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId == null ? null : associatedId.trim();
    }

    public String getAssociatedCode() {
        return associatedCode;
    }

    public void setAssociatedCode(String associatedCode) {
        this.associatedCode = associatedCode == null ? null : associatedCode.trim();
    }

    public String getAssociatedName() {
        return associatedName;
    }

    public void setAssociatedName(String associatedName) {
        this.associatedName = associatedName == null ? null : associatedName.trim();
    }

    public String getWindCode() {
        return windCode;
    }

    public void setWindCode(String windCode) {
        this.windCode = windCode == null ? null : windCode.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
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

	public List<SchedulingAssociatedDetail> getDetails() {
		return details;
	}

	public void setDetails(List<SchedulingAssociatedDetail> details) {
		this.details = details;
	}


	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
	}   
}