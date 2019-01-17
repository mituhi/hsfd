package com.qz.zframe.device.service;

import java.io.InputStream;
import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;

public interface PositionEncodeService {
	
	/**
	 * //查询位置编码信息
	 * 
	 * @param positionExample
	 * @return
	 */
	public PageResultEntity findPosition(PositionEncodeExample positionExample);

	/**
	 * //新增位置编码
	 * 
	 * @param positionEncode
	 * @return
	 */

	public ResultEntity addPosition(PositionEncode positionEncode);

	/**
	 * //修改位置编码
	 * 
	 * @param positionEncode
	 * @return
	 */

	public ResultEntity updatePosition(PositionEncode positionEncode);

	/**
	 * //查询位置编码详情
	 * 
	 * @param positionId
	 * @return
	 */

	public PageResultEntity findByPositionId(String positionId);

	/**
	 * //批量删除位置编码
	 * 
	 * @param positionIds
	 * @return
	 */

	public ResultEntity deletePositions(List<String> positionIds);

	// 查询位置编码结构顶层
	public PageResultEntity findStructure();

	// 查询位置编码结构底层
	public PageResultEntity findStructureList(String superiorPostition);
	
	/**
	 * 导入KKS位置编码
	 * @param fileName
	 * @param in
	 * @return
	 * @throws Exception
	 */
	
	public ResultEntity importBook(String fileName, InputStream in) throws Exception;
}
