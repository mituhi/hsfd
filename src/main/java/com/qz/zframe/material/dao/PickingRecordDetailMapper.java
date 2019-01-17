package com.qz.zframe.material.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.PickingRecordDetail;
import com.qz.zframe.material.entity.PickingRecordDetailExample;

@Mapper
public interface PickingRecordDetailMapper extends BaseMapper<PickingRecordDetail, PickingRecordDetailExample, Long>{

	public void insertList(List<PickingRecordDetail> list);

	public void deleteByPrimaryKey(String pickingId);

	public void deleteByPickingId(List<String> pickingIds);

	public void updateBatchReturnNum(List<PickingRecordDetail> returnDetailList);


    
}