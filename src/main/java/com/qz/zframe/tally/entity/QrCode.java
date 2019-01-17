package com.qz.zframe.tally.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 二维码配置信息
 * 
 * @author sn
 * @date 2018年12月4日下午2:50:57
 *
 */
public class QrCode implements Serializable {
	

	private static final long serialVersionUID = -7607599166627703971L;

	@ApiModelProperty(name="qrId",value="二维码主键Id",required=true)
    private String qrId;

	@ApiModelProperty(name="qrCodeId",value="二维码编码Id",required=false)
    private String qrCodeId;

	@ApiModelProperty(name="positionId",value="位置编码Id",required=true)
    private String positionId;
	
	@ApiModelProperty(name="positionCode",value="位置编码",required=false)
	private String positionCode;
	
	@ApiModelProperty(name="positionName",value="位置编码名称",required=false)
	private String positionName;
	
	@ApiModelProperty(name="architectureCode",value="风电场编码",required=false)
	private String windCode;
	
	@ApiModelProperty(name="windName",value="风电场名称",required=false)
	private String windName;
	
	@ApiModelProperty(name="creater",value="创建人Id",required=false)
	private String creater;
	
	@ApiModelProperty(name="createTime",value="创建时间",required=false)
	private Date createTime;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId == null ? null : qrId.trim();
    }

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId == null ? null : qrCodeId.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getWindCode() {
		return windCode;
	}

	public void setWindCode(String windCode) {
		this.windCode = windCode;
	}

	public String getWindName() {
		return windName;
	}

	public void setWindName(String windName) {
		this.windName = windName;
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