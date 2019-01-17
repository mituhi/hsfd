package com.qz.zframe.common.controller;

import com.qz.zframe.common.entity.Common;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.PageResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/common")
@Api(tags = { "api-common" }, description = "公共接口")
public class CommonController {
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public SpFileUpload upload(MultipartFile file, HttpServletRequest request)
			throws Exception {
		SpFileUpload map = commonService.fileUpload(file, "01");
		return map;
	}
	
	@ApiOperation(value = "下载", notes = "下载")
	@RequestMapping(value = "download", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> download(
			@RequestParam(required = false)
			@ApiParam(name="fileId",value="文件id",required=true)String fileId, 
			HttpServletResponse response) throws Exception {
		logger.info("===== 下载 CommonController.download ===== fileId:"+fileId);
		commonService.download(response, fileId);
		return null;
	}
		
	@ApiOperation(value = "获取单号", notes = "获取单号")
	@RequestMapping(value = "findCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> queryCodeTypeById(
			@RequestParam(required = false)
			@ApiParam(name="code",value="标准代码编号",required=true)String code,
			@RequestParam(required = false)
			@ApiParam(name="maxCode",value="最大单号",required=false)String maxCode) throws Exception {
		logger.info("===== 获取单号 CommonController.findCode ===== code:"+code+"maxCode:"+maxCode);
		return new ResponseEntity<String>(commonService.customOrder(code, maxCode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取当前用户基本信息", notes = "获取当前用户基本信息")
	@RequestMapping(value = "findCommonMsg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Common> findCommonMsg() throws Exception {
		logger.info("===== 获取当前用户基本信息 CommonController.findCommonMsg ===== ");
		return new ResponseEntity<Common>(commonService.findCommonMsg(), HttpStatus.OK);
	}

	@ApiOperation(value = "删除ftp文件", notes = "删除ftp文件")
	@RequestMapping(value = "removeFile", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageResultEntity removeFile(@RequestParam(required = true)
			@ApiParam(name="fileId",value="文件id",required=true)String fileId) throws Exception {
		logger.info("===== 删除ftp文件 CommonController.deleteCodeType ===== fileId:"+fileId);
		return commonService.removeFile(fileId);
	}

	@ApiOperation(value = "根据用户id获取基本信息", notes = "根据用户id获取基本信息")
	@RequestMapping(value = "findUserBaseMsg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Common> findUserBaseMsg(
			@RequestParam(required = true)
			@ApiParam(name="userId",value="用户id",required=true)String userId) throws Exception {
		logger.info("===== 根据用户id获取基本信息 CommonController.findUserBaseMsg ===== userId:"+userId);
		return new ResponseEntity<Common>(commonService.findUserBaseMsg(userId), HttpStatus.OK);
	}

	/**
	 * 下载图片
	 *
	 * @param fileId 文件id
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@ApiOperation(value = "下载图片", notes = "下载图片")
	@RequestMapping(value = "/downloadForImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> downloadForImage(@RequestParam(required = true) String fileId)
			throws Exception {
		if (StringUtils.isBlank(fileId)) {
			throw new Exception("未选择文件");
		}
		byte[] bytes = commonService.downloadForBytes(fileId);
		return new ResponseEntity<>(bytes, HttpStatus.OK);
	}

}
