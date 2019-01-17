package com.qz.zframe.device.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.file.FileException;
import com.qz.zframe.question.entity.QuestionFeedback;

public interface EquipmentAssetLedgerService {

	/**
	 * //查询设备资产台账信息
	 * 
	 * @param assetLedgerExample
	 * @return
	 */
	public PageResultEntity findAssetLedger(EquipmentAssetLedgerExample assetLedgerExample);

	/**
	 * //新增位设备资产台账信息
	 * 
	 * @param assetLedger
	 * @return
	 */

	public ResultEntity addAssetLedger(EquipmentAssetLedger assetLedger);

	/**
	 * //修改设备资产台账信息
	 * 
	 * @param assetLedger
	 * @return
	 * @throws Exception
	 */

	public ResultEntity updateAssetLedger(EquipmentAssetLedger assetLedger) throws Exception;

	/**
	 * //查询设备资产台账信息详情
	 * 
	 * @param equipmentAssetId
	 * @return
	 * @throws FileException
	 */
	public PageResultEntity findByEquipmentAssetId(String equipmentAssetId) throws FileException;

	/**
	 * //批量设备资产台账信息
	 * 
	 * @param equipmentAssetIds
	 * @return
	 * @throws Exception
	 */

	public ResultEntity deleteAssetLedger(List<String> equipmentAssetIds) throws Exception;

	/**
	 * //设备资产台账信息变动查询
	 * 
	 * @param assetLedgerExample
	 * @return
	 */
	public PageResultEntity findChange(EquipmentAssetLedgerExample assetLedgerExample);

	/**
	 * 查询资产变动详情
	 * 
	 * @param equipmentAssetId
	 * @return
	 */
	public PageResultEntity findById(String equipmentAssetId);

	/**
	 * 导出数据
	 * 
	 * @param assetLedgerExample
	 * @param response
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public String ExportExcl(EquipmentAssetLedgerExample assetLedgerExample, HttpServletResponse response,
			String sheetName) throws Exception;

	/**
	 * //关闭设备资产台账信息
	 * 
	 * @param assetLedger
	 * @return
	 * @throws Exception
	 */

	public ResultEntity closeDown(EquipmentAssetLedger assetLedger) throws Exception;

	/**
	 * 删除上传的文件
	 * 
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public ResultEntity removeFile(List<String> fileId) throws Exception;

	/*
	 * //上传图片文档 public ResultEntity fileUpload(MultipartFile file, String
	 * businessType);
	 */
	/**
	 * 根据风电场查询设备
	 * 
	 * @param assetLedgerExample
	 * @return
	 */
	PageResultEntity selectByWindId(EquipmentAssetLedgerExample assetLedgerExample);
}
