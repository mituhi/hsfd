package com.qz.zframe.material.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.PickingRecord;
import com.qz.zframe.material.entity.PickingRecordDetail;
import com.qz.zframe.material.entity.PickingRecordDetailExample;
import com.qz.zframe.material.entity.PickingRecordExample;

public interface PickingRecordService {

	/**
	 * 获取领料单列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<PickingRecord> getPickRecordList(PickingRecordExample example) throws Exception;

	/**
	 * 获取领料单详情
	 * 
	 * @param @param pickingId
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<PickingRecord> getPickRecordDetail(String pickingId);

	/**
	 * 新增领料单
	 * 
	 * @param @param pickingRecord
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity addPickRecord(PickingRecord pickingRecord) throws Exception;

	/**
	 * 获取最大得领料单号
	 * 
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String getMaxPickingOrder();

	public ResultEntity updatePickRecord(PickingRecord pickingRecord)  throws ParseException;

	public NewPageResult<PickingRecordDetail> getPickRecordDetailList(PickingRecordDetailExample example);

	/**
	 * 审批同意
	 * 
	 * @param @param pickingId
	 * @param @param pickingId2
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity agreeOrderStatus(String pickingId, String approvalOpinion);

	/**
	 * 审批拒绝
	 * 
	 * @param @param pickingId
	 * @param @param pickingId2
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity refuseOrderStatus(String pickingId, String approvalOpinion);

	public ResultEntity deletePickRecord(List<String> pickingIds);

	public NewPageResult<PickingRecord> getPickRecordByOrderNo(PickingRecordExample example, String pickType);

}
