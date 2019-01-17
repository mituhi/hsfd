package com.qz.zframe.device.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;
@Mapper
public interface CrewInformationMapper extends BaseMapper<CrewInformation, CrewInformationExample, Long>{
    int countByExample(CrewInformationExample example);

    int deleteByExample(CrewInformationExample example);
    
    int deleteByPrimaryKeyList(List<String> crewIds);
    
    int insert(CrewInformation record);

    int insertSelective(CrewInformation record);

    List<CrewInformation> selectByExample(CrewInformationExample example);
    
    List<CrewInformation> select(CrewInformationExample example);
    
    List<CrewInformation> selectCrewByWind (@Param("windId")String windId);
    
    List<CrewInformation> selectAll();
    
    CrewInformation selectByPrimaryKey(String crewId);
    
    CrewInformation selectByCrewCode(String crewCode);
    
    int update(CrewInformation record);
    
    int updateByExampleSelective(@Param("record") CrewInformation record, @Param("example") CrewInformationExample example);

    int updateByExample(@Param("record") CrewInformation record, @Param("example") CrewInformationExample example);
}