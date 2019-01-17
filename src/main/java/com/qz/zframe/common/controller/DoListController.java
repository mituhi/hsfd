package com.qz.zframe.common.controller;

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.service.DoListService;
import com.qz.zframe.common.util.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common/dolist")
@Api(tags = { "api-common-doList" }, description = "待办信息")
public class DoListController {
	private static Logger logger = LoggerFactory.getLogger(DoListController.class);
	
	@Autowired
	private DoListService doListService;

	@ApiOperation(value = "获取待办信息", notes = "获取待办信息")
	@RequestMapping(value = "findDoList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResultEntity findDoList() {
		logger.info("===== 根据父id查询组织架构信息 DoListController.findDoList ===== ");
		return doListService.findDoList();
	}

}
