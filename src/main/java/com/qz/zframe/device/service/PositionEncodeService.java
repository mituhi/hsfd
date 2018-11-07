package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;

public interface PositionEncodeService {
	//查询位置编码信息
	 public	PageResultEntity findPosition(PositionEncodeExample position);
    //新增位置编码
	 public ResultEntity  addPosition(PositionEncode positionEncode);
	//修改位置编码
	 public ResultEntity  updatePosition(PositionEncode positionEncode);
	 //查询位置编码详情
	 public  PageResultEntity  findByPositionId(String positionId);
	 //批量删除位置编码
	 public   ResultEntity  deletePositions(List<String> positionIds);
	 // 查询位置编码结构顶层
	 public   PageResultEntity  findStructure();
	 //查询位置编码结构底层
	 public   PageResultEntity  findStructureList(String superiorPostition); 
}
