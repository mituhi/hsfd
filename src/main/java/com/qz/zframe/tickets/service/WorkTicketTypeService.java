package com.qz.zframe.tickets.service;

import com.github.pagehelper.Page;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;

import java.util.Map;

public interface WorkTicketTypeService {

    /**
     * 添加工作票类型
     */
    public ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 删除工作票类型
     */
    public ResultEntity deleteWorkTicketType(String workTicketTypeIds);

    /**
     * 修改工作票类型
     */
    public ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 工作票类型详情查询
     */
    public ResultEntity getWorkTicketTypeDetail(String workTicketTypeId);

    /**
     * 工作票类型列表查询
     */
    public PageResultEntity getWorkTicketTypeList(Map<String,String> pageAndCondition);

}
