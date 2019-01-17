package com.qz.zframe.tally.service;

import java.io.InputStream;
import java.util.List;

import com.qz.zframe.device.entity.CrewInformationExample;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.entity.QrCodeExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TallyQrCodeService {

	/**
	 * 获取二维码配置列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return NewPageResult<QrCode>    返回类型
	 * @throws
	 */
	NewPageResult<QrCode> getlistQrCode(QrCodeExample example);

	/**
	 * 新增二维码配置
	 * 
	 * @param @param qrCode
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	ResultEntity insertByCodes(QrCode qrCode) throws Exception;

	/**
	 * 编辑二维码配置
	 * 
	 * @param @param qrCode
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	ResultEntity updateQrCodeByCode(QrCode qrCode);

	ResultEntity deleteQrCodeByQrId(List<String> qrIds);


    ResultEntity ExportExcl(QrCodeExample example, HttpServletResponse response, String positionCode,String sheetName,String noteSite,ResultEntity resultEntity) throws Exception;

    ResultEntity importQrCode(String originalFilename, InputStream inputStream,ResultEntity resultEntity);

	ResultEntity ExportExclByIds(QrCodeExample example, HttpServletResponse response, String positionCode, String sheetName, String noteSite, ResultEntity resultEntity, HttpServletRequest request) throws Exception;
}
