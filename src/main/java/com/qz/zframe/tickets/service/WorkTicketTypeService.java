package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;

public interface WorkTicketTypeService {

    /**
     * 工作票类型列表查询
     */
    public ResultEntity getWorkTicketTypeList();

    /**
     * 新建工作票类型
     * @return
     */
    public ResultEntity createWorkTicketType();

    /**
     * 添加工作票类型
     */
    public ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 删除工作票类型
     */
    public ResultEntity deleteWorkTicketType(String ticketTypeIds);

    /**
     * 修改工作票类型
     */
    public ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 工作票类型详情查询
     */
    public ResultEntity getWorkTicketTypeDetail(String ticketTypeId);
}
