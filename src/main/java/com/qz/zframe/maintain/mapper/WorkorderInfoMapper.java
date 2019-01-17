package com.qz.zframe.maintain.mapper;

import com.qz.zframe.common.entity.Role;
import com.qz.zframe.maintain.entity.WorkorderInfo;
import com.qz.zframe.maintain.entity.WorkorderInfoExample;
import com.qz.zframe.maintain.vo.WorkorderVo;
import com.qz.zframe.maintain.vo.WorkorderVoForMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkorderInfoMapper {
    int countByExample(WorkorderInfoExample example);

    int deleteByExample(WorkorderInfoExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(WorkorderInfo record);

    int insertSelective(WorkorderInfo record);

    //根据流水号查询id
    String getIdBySerialNumber(@Param("serialNumber") String serialNumber);

    //根据流水号查询缺陷工单
    WorkorderVoForMaterial getWorkorderBySerialNumber(@Param("serialNumber") String serialNumber);

    //批量删除
    int batchDeleteTrue(@Param("list") List<String> orderIdList);
    //批量删除
    int batchDeleteFalse(@Param("list") List<String> orderIdList);
    //详情查询
    WorkorderVo getWorkorderDetail(@Param("orderId") String orderId);
    //分页+条件列表查询
    List<WorkorderVo> getWorkorderList(@Param("map") Map<String, String> pageAndCondition,
                                       @Param("userId") String userId,
                                       @Param("list") List<Role> userRoleList);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition,
                 @Param("userId") String userId,
                 @Param("list") List<Role> userRoleList);

    List<WorkorderInfo> selectByExample(WorkorderInfoExample example);

    WorkorderInfo selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") WorkorderInfo record, @Param("example") WorkorderInfoExample example);

    int updateByExample(@Param("record") WorkorderInfo record, @Param("example") WorkorderInfoExample example);

    int updateByPrimaryKeySelective(WorkorderInfo record);

    int updateByPrimaryKey(WorkorderInfo record);
}