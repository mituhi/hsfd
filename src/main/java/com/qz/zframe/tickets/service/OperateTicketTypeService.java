package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;

import java.util.Map;

public interface OperateTicketTypeService {

    /**
     * 添加操作票类型
     */
    public ResultEntity addOperateTicketType(OperateTicketTypeVo operateTicketTypeVo);

    /**
     * 删除操作票类型
     */
    public ResultEntity deleteOperateTicketType(String ticketTypeIds);

    /**
     * 修改操作票类型
     */
    public ResultEntity updateOperateTicketType(OperateTicketTypeVo operateTicketTypeVo);

    /**
     * 浏览操作票类型
     */
    public ResultEntity getOperateTicketTypeDetail(String ticketTypeId);

    /**
     * 操作票类型列表查询
     */
    public PageResultEntity getOperateTicketTypeList(Map<String,String> pageAndCondition);
}
