package com.qz.zframe.run.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.run.entity.NewSchedulingAssociated.ListView;

import io.swagger.annotations.ApiModelProperty;

/**
 * 排班管理详情
 * 
 * @author syc
 * @date 2019年1月3日下午4:08:25
 *
 */
public class SchedulingAssociatedDetail implements Serializable{
    
	private static final long serialVersionUID = -6998128678771115722L;

	@ApiModelProperty(value="排版管理详情Id",name="associatedDetailId",required=true)
	@JsonView({ListView.class})
	private String associatedDetailId;

	@ApiModelProperty(value="排版管理Id",name="associatedId",required=true)
    private String associatedId;

	@ApiModelProperty(value="排版规则Id",name="schedulingRuleId",required=true)
	@JsonView({ListView.class})
    private String schedulingRuleId;

	@ApiModelProperty(value="开始日期",name="startDate",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	@JsonView({ListView.class})
    private Date startDate;

	@ApiModelProperty(value="结束日期",name="endDate",required=true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	@JsonView({ListView.class})
    private Date endDate;

	@ApiModelProperty(value="备注",name="remark",required=false)
	@JsonView({ListView.class})
    private String remark;
	
	@ApiModelProperty(value="排版规则编码",name="schedulingRuleCode",required=false)
	@JsonView({ListView.class})
	private String schedulingRuleCode;
	
	@ApiModelProperty(value="排版规则名称",name="schedulingRule",required=false)
	@JsonView({ListView.class})
	private String schedulingRule;
	
	@ApiModelProperty(value="排序",name="sort",required=false)
	@JsonView({ListView.class})
    private String sort;

    public String getAssociatedDetailId() {
        return associatedDetailId;
    }

    public void setAssociatedDetailId(String associatedDetailId) {
        this.associatedDetailId = associatedDetailId == null ? null : associatedDetailId.trim();
    }

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId == null ? null : associatedId.trim();
    }

    public String getSchedulingRuleId() {
        return schedulingRuleId;
    }

    public void setSchedulingRuleId(String schedulingRuleId) {
        this.schedulingRuleId = schedulingRuleId == null ? null : schedulingRuleId.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSchedulingRuleCode() {
		return schedulingRuleCode;
	}

	public void setSchedulingRuleCode(String schedulingRuleCode) {
		this.schedulingRuleCode = schedulingRuleCode;
	}

	public String getSchedulingRule() {
		return schedulingRule;
	}

	public void setSchedulingRule(String schedulingRule) {
		this.schedulingRule = schedulingRule;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}