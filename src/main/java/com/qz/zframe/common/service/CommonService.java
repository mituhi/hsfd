package com.qz.zframe.common.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import org.springframework.web.multipart.MultipartFile;

import com.qz.zframe.common.entity.Common;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.file.FileException;

public interface CommonService {

	/**
	 * 文件上传
	 * @param file
	 * @param businessType
	 * @return
	 * @throws Exception
	 */
	SpFileUpload fileUpload(MultipartFile file, String businessType) throws Exception;
	
	/**
     * 下载
     *
     * @param fileId 文件ID
     * @return byte[]
     * @throws FileException
     */
    byte[] download(String fileId) throws FileException;
    
    /**
     * 下载（文件流写入Response对象中）
     *
     * @param response 响应
     * @param fileId   文件ID
     * @throws FileException
     */
    void download(HttpServletResponse response, String fileId) throws Exception;
    
    /**
     * 自定义单号
     * @param code 标准代码编号
     * @param maxCode 最大单号
     * @return
     * @throws Exception 
     */
    String customOrder(String code, String maxCode) throws Exception;

	/**
	 * 获取用户id、名称及当前时间
	 * @return
	 * @throws ParseException
	 */
	Common findCommonMsg() throws ParseException;

	/**
	 * 根据文件id删除文件信息及ftp上的文件
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	PageResultEntity removeFile(String fileId) throws Exception;

	/**
	 * 根据用户id获取基本信息
	 * @return
	 * @param userId
	 */
    Common findUserBaseMsg(String userId) throws Exception;

	/**
	 * 返回图片路径
	 * @param fileId
	 * @return
	 */
	byte[] downloadForBytes(String fileId) throws FileException;

	/**
	 * 导出二维码
	 * @param msgs 传入信息，包括
	 *  	qrUrl 二维码内容
	 *  	equipmentName 设备名称
	 *  	qrCodeId 二维码编号
	 *
	 */
	int exportQrCode(List<Map<String, String>> msgs) throws Exception;
}
