package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.OperateTicketTypeVo;

import java.util.Map;

public interface OperateTicketTypeService {

    /**
     * 添加操作票类型
     */
    ResultEntity addOperateTicketType(OperateTicketTypeVo operateTicketTypeVo);

    /**
     * 修改操作票类型
     */
    ResultEntity updateOperateTicketType(OperateTicketTypeVo operateTicketTypeVo);

    /**
     * 删除操作票类型
     */
    ResultEntity deleteOperateTicketType(String[] ticketTypeIds);

    /**
     * 浏览操作票类型
     */
    ResultEntity getOperateTicketTypeDetail(String ticketTypeId);

    /**
     * 操作票类型列表查询
     */
    PageResultEntity getOperateTicketTypeList(Map<String,String> pageAndCondition);

    /**
     * 下拉框-操作票类型
     */
    ResultEntity getAllperateTicketType();

    /**
     * 操作人列表查询
     */
    ResultEntity getExecuterList(String ticketTypeId);

    /**
     * 监护人列表查询
     */
    ResultEntity getSupervisiorList(String ticketTypeId);

}
