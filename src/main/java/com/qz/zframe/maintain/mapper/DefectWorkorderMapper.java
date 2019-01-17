package com.qz.zframe.maintain.mapper;

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.maintain.entity.DefectWorkorder;
import com.qz.zframe.maintain.entity.DefectWorkorderExample;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
import com.qz.zframe.maintain.vo.WorkorderVoForMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DefectWorkorderMapper {
    int countByExample(DefectWorkorderExample example);

    int deleteByExample(DefectWorkorderExample example);

    int deleteByPrimaryKey(String workorderId);

    int insert(DefectWorkorder record);

    int insertSelective(DefectWorkorder record);

    //根据流水号查询id
    String getIdBySerialNumber(@Param("serialNumber") String serialNumber);

    //根据流水号查询缺陷工单
    WorkorderVoForMaterial getDefectWorkorderBySerialNumber(@Param("serialNumber") String serialNumber);

    //批量真删除
    int batchDeleteTrue(@Param("list") List<String> workorderIdList);

    //批量假删除
    int batchDeleteFalse(@Param("list") List<String> workorderIdList);

    //详情查询
    DefectWorkorderVo getDefectWorkorderDetail(@Param("workorderId") String workorderId);

    //分页+条件列表查询
    List<DefectWorkorderVo> getDefectWorkorderList(@Param("map") Map<String, String> pageAndCondition,
                                                   @Param("userId") String userId,
                                                   @Param("list") List<Role> userRoleList);

    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition,
                 @Param("userId") String userId,
                 @Param("list") List<Role> userRoleList);

    List<DefectWorkorder> selectByExample(DefectWorkorderExample example);

    DefectWorkorder selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") DefectWorkorder record, @Param("example") DefectWorkorderExample example);

    int updateByExample(@Param("record") DefectWorkorder record, @Param("example") DefectWorkorderExample example);

    int updateByPrimaryKeySelective(DefectWorkorder record);

    int updateByPrimaryKey(DefectWorkorder record);
}