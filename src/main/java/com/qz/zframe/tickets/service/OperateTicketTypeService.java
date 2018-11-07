package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.entity.OperateTicketType;

public interface OperateTicketTypeService {

    /**
     * 查询操作票类型列表
     */
    public ResultEntity getOperateTicketTypeList();

    /**
     * 新建操作票类型
     */
    public ResultEntity createOperateTicketType();

    /**
     * 添加操作票类型
     */
    public ResultEntity addOperateTicketType(OperateTicketType operateTicketType);

    /**
     * 删除操作票类型
     */
    public ResultEntity deleteOperateTicketType(String ticketTypeIds);

    /**
     * 修改操作票类型
     */
    public ResultEntity updateOperateTicketType(OperateTicketType operateTicketType);

    /**
     * 查询操作票类型详情
     */
    public ResultEntity selectOperateTicketType(String ticketTypeId);
}
