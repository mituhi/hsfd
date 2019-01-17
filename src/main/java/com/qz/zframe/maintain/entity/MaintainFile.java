package com.qz.zframe.maintain.entity;

import io.swagger.annotations.ApiModelProperty;

public class MaintainFile {

    @ApiModelProperty(name="id",value="主键id",required=false)
    private String id;

    @ApiModelProperty(name="assoId",value="关联表id",required=false)
    private String assoId;

    @ApiModelProperty(name="fileId",value="文件id",required=false)
    private String fileId;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAssoId() {
        return assoId;
    }

    public void setAssoId(String assoId) {
        this.assoId = assoId == null ? null : assoId.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}