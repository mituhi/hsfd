package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.WorkorderMaterial;
import com.qz.zframe.maintain.entity.WorkorderMaterialExample;
import com.qz.zframe.maintain.vo.WorkorderMaterialVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkorderMaterialMapper {
    int countByExample(WorkorderMaterialExample example);

    int deleteByExample(WorkorderMaterialExample example);

    int deleteByPrimaryKey(String workorderMaterialId);

    int insert(WorkorderMaterial record);

    int insertSelective(WorkorderMaterial record);

    //根据流水号查询id
    String getIdBySerialNumber(@Param("serialNumber") String serialNumber);

    //根据缺陷工单ids批量删除
    int batchDeleteByWorkOrderIds(@Param("list") List<String> workorderIdList);

    //根据工单ids批量删除
    int batchDeleteByOrderIds(@Param("list") List<String> orderIdList);

    //根据故障知识ids批量删除
    int batchDeleteByKnowledgeIds(@Param("list") List<String> knowledgeIdList);

    //根据缺陷工单id查询
    List<WorkorderMaterialVo> getWorkorderMaterialVoByworkorderId(@Param("workorderId") String workorderId,@Param("stockAddId") String stockAddId);

    //根据工单id查询
    List<WorkorderMaterialVo> getWorkorderMaterialVoByorderId(@Param("orderId") String orderId,@Param("stockAddId") String stockAddId);

    List<WorkorderMaterial> selectByExample(WorkorderMaterialExample example);

    WorkorderMaterial selectByPrimaryKey(String workorderMaterialId);

    int updateByExampleSelective(@Param("record") WorkorderMaterial record, @Param("example") WorkorderMaterialExample example);

    int updateByExample(@Param("record") WorkorderMaterial record, @Param("example") WorkorderMaterialExample example);

    int updateByPrimaryKeySelective(WorkorderMaterial record);

    int updateByPrimaryKey(WorkorderMaterial record);
}