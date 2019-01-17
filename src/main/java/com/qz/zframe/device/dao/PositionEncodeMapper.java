package com.qz.zframe.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;
@Mapper
public interface PositionEncodeMapper extends BaseMapper<PositionEncode, PositionEncodeExample, Long>{
    int countByExample(PositionEncodeExample example);

    int deleteByExample(PositionEncodeExample example);

    int deleteByPrimaryKey(String positionId);

    int deleteByPrimaryKeyList(List<String> positionIds);
    
    int insert(PositionEncode record);
    int insert(List<PositionEncode> positionEncode);
    int insertSelective(PositionEncode record);
    
    List<PositionEncode>  selectByWindId(String windId);
    
    List<PositionEncode> selectByExample(PositionEncodeExample example);
    
    List<PositionEncode>  selectAll();

    PositionEncode selectByPrimaryKey(String positionId);
    
    PositionEncode  selectByPositionCode(String positionCode);

    PositionEncode selectByIdAndCodeAndName(String positionId);
    
    int updateByExampleSelective(@Param("record") PositionEncode record, @Param("example") PositionEncodeExample example);

    int updateByExample(@Param("record") PositionEncode record, @Param("example") PositionEncodeExample example);

    int updateByPrimaryKeySelective(PositionEncode record);

    int updateByPrimaryKey(PositionEncode record);
    
    List<PositionEncode> selectStructure();
    //查所有的位置信息
    List<PositionEncode> selectStructureAndHierarchy1(@Param("windId")String windId);
    //根据层级查询下拉框数据
    List<PositionEncode> selectStructureAndHierarchy2(@Param("hierarchy")String hierarchy,@Param("windId")String windId);
   /* List<PositionEncode> selectStructureAndHierarchy3();
    List<PositionEncode> selectStructureAndHierarchy4();
    List<PositionEncode> selectStructureAndHierarchy5();*/
    List<PositionEncode> selectStructures();
    List<PositionEncode> selectStructureList(String positionId);
    
    List<PositionEncode>  selectIsTop(@Param("windId")String windId);
    List<PositionEncode>  selectNotIsTop(@Param("windId")String windId);
    
    List<PositionEncode> selectBySuperPosition(String positionId);
}