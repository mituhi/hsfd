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

    int insertSelective(PositionEncode record);

    List<PositionEncode> selectByExample(PositionEncodeExample example);

    PositionEncode selectByPrimaryKey(String positionId);

    int updateByExampleSelective(@Param("record") PositionEncode record, @Param("example") PositionEncodeExample example);

    int updateByExample(@Param("record") PositionEncode record, @Param("example") PositionEncodeExample example);

    int updateByPrimaryKeySelective(PositionEncode record);

    int updateByPrimaryKey(PositionEncode record);
    
    List<PositionEncode> selectStructure();
    
    List<PositionEncode> selectStructureList(String superiorPosition);
}