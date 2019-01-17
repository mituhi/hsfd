package com.qz.zframe.maintain.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.vo.WorkorderTypeVo;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface WorkorderTypeService {

    /**
     * 添加工单类型
     */
    ResultEntity addWorkorderType(WorkorderTypeVo workorderTypeVo);

    /**
     * 批量删除工单类型
     */
    ResultEntity deleteWorkorderType(String[] workorderTypeIds);

    /**
     * 修改工单类型
     */
    ResultEntity updateWorkorderType(WorkorderTypeVo workorderTypeVo);

    /**
     * 浏览工单类型
     */
    ResultEntity getWorkorderTypeDetail(String workorderTypeId);

    /**
     * 工单分类列表查询
     */
    PageResultEntity getWorkorderTypeList(Map<String,String> pageAndCondition);

    /**
     * 工单分类列表导出
     */
    void exportToExcel(HttpServletResponse response);

    /**
     * 获取所有工单类型
     * @return
     */
    PageResultEntity getAllWorkorderTypeList();
}
