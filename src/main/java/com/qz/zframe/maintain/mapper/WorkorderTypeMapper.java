package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderType;
import com.qz.zframe.maintain.entity.WorkorderTypeExample;
import com.qz.zframe.maintain.vo.WorkorderTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkorderTypeMapper {
    int countByExample(WorkorderTypeExample example);

    int deleteByExample(WorkorderTypeExample example);

    int deleteByPrimaryKey(String workorderTypeId);

    int insert(WorkorderType record);

    int insertSelective(WorkorderType record);
    //批量删除
    int batchDelete(@Param("array") String[] ids);

    //根据id获取名称
    String getNameById(@Param("workorderTypeId") String workorderTypeId);

    //详情查询
    WorkorderTypeVo getWorkorderTypeDetail(@Param("workorderTypeId") String workorderTypeId);

    //列表查询
    List<WorkorderTypeVo> getAllWorkorderType();

    //列表分页查询
    List<WorkorderTypeVo> getWorkorderTypeList(@Param("map") Map<String, String> pageAndCondition);

    //分页总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<WorkorderType> selectByExample(WorkorderTypeExample example);

    WorkorderType selectByPrimaryKey(String workorderTypeId);

    int updateByExampleSelective(@Param("record") WorkorderType record, @Param("example") WorkorderTypeExample example);

    int updateByExample(@Param("record") WorkorderType record, @Param("example") WorkorderTypeExample example);

    int updateByPrimaryKeySelective(WorkorderType record);

    int updateByPrimaryKey(WorkorderType record);

    /**
     * 获取所有可用工单类型
     * @return
     */
    List<WorkorderTypeVo> getAllWorkorderTypeByStatus();
}