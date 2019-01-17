package com.qz.zframe.tickets.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tickets.vo.WorkTicketTypeVo;

import java.util.Map;

public interface WorkTicketTypeService {

    /**
     * 添加工作票类型
     */
    ResultEntity addWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 修改工作票类型
     */
    ResultEntity updateWorkTicketType(WorkTicketTypeVo workTicketTypeVo);

    /**
     * 删除工作票类型
     */
    ResultEntity deleteWorkTicketType(String[] workTicketTypeIds);

    /**
     * 工作票类型详情查询
     */
    ResultEntity getWorkTicketTypeDetail(String workTicketTypeId);

    /**
     * 工作票类型列表查询
     */
    PageResultEntity getWorkTicketTypeList(Map<String,String> pageAndCondition, String startArchitectureCode , String endArchitectureCode);

    /**
     * 下拉框工作票类型
     */
    ResultEntity getAllWorkTicketType();

    /**
     * 工作负责人列表查询
     */
    ResultEntity getWorkHeadList(String workTicketTypeId);

    /**
     * 签收人列表查询
     */
    ResultEntity getSignerList(String workTicketTypeId);

    /**
     * 许可人列表查询
     */
    ResultEntity getLicensorList(String workTicketTypeId);

}
