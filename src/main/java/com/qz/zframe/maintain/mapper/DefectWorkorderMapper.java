package com.qz.zframe.maintain.mapper;

import com.qz.zframe.maintain.entity.DefectWorkorder;
import com.qz.zframe.maintain.entity.DefectWorkorderExample;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
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
    //批量删除
    int batchDelete(@Param("array") String[] ids);
    //详情查询
    DefectWorkorderVo getDefectWorkorderDetail(@Param("workorderId") String workorderId);
    //分页+条件列表查询
    List<DefectWorkorderVo> getDefectWorkorderListByPageAndCondition(@Param("map") Map<String, String> pageAndCondition);
    //根据条件查询总记录数
    int getTotal(@Param("map") Map<String, String> pageAndCondition);

    List<DefectWorkorder> selectByExample(DefectWorkorderExample example);

    DefectWorkorder selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") DefectWorkorder record, @Param("example") DefectWorkorderExample example);

    int updateByExample(@Param("record") DefectWorkorder record, @Param("example") DefectWorkorderExample example);

    int updateByPrimaryKeySelective(DefectWorkorder record);

    int updateByPrimaryKey(DefectWorkorder record);
}